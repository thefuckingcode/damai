package com.youku.playerservice.axp.cache.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.youku.alixplayer.misc.Preloader;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.cache.CachePool;
import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.cache.IInternalCachePreloadCallback;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.p2p.P2pManager;
import com.youku.playerservice.axp.p2p.PcdnType;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.request.MultiGetUpsRequest;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.upsplayer.module.Segs;
import com.youku.upsplayer.module.SimpleVideoInfo;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class MultiMediaSourceCacheTask extends CacheTask {
    private Context mContext;
    private Map<String, String> mExtParams;
    private IInternalCachePreloadCallback mInternalCallback;
    private String mKey;
    private IPlayInfoRequest.Callback mPlayInfoRequestCallback = new IPlayInfoRequest.Callback() {
        /* class com.youku.playerservice.axp.cache.task.MultiMediaSourceCacheTask.AnonymousClass1 */

        @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
        public void onFinished(PlayParams playParams, List<PlayInfoResponse> list) {
            if (list == null || list.size() <= 0) {
                List<String> vids = playParams.getPlayIdParams().getVids();
                if (vids != null && vids.size() > 0) {
                    for (String str : vids) {
                        if (MultiMediaSourceCacheTask.this.mInternalCallback != null) {
                            CachePreloadResult cachePreloadResult = new CachePreloadResult();
                            cachePreloadResult.setVidOfPreload(str);
                            MultiMediaSourceCacheTask.this.mInternalCallback.onResult(MultiMediaSourceCacheTask.this.mKey, null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE, cachePreloadResult);
                        }
                    }
                    return;
                }
                return;
            }
            for (PlayInfoResponse playInfoResponse : list) {
                if (MultiMediaSourceCacheTask.this.mVids.contains(playInfoResponse.getUpsInfo().getSimpleVideoInfo().getVid())) {
                    CachePool.getInstance().savePlayInfoResponse(MultiMediaSourceCacheTask.this.mContext, playInfoResponse);
                    MultiMediaSourceCacheTask.this.preloadSimpleVideoInfo(playInfoResponse.getUpsInfo().getSimpleVideoInfo(), MultiMediaSourceCacheTask.this.mExtParams);
                }
            }
        }
    };
    private Map<String, Map<String, String>> mPreloadResult;
    private List<String> mUrls;
    private List<String> mVids;

    public MultiMediaSourceCacheTask(String str, Context context, List<String> list, List<String> list2, Map<String, String> map, IInternalCachePreloadCallback iInternalCachePreloadCallback) {
        this.mKey = str;
        this.mContext = context;
        this.mVids = list;
        this.mUrls = list2;
        this.mExtParams = map;
        this.mInternalCallback = iInternalCachePreloadCallback;
        this.mPreloadResult = new HashMap();
    }

    private void addPreloadTask(String str, Map<String, String> map) {
        Context context;
        StringBuilder sb = new StringBuilder();
        String str2 = !TextUtils.isEmpty(map.get(CacheManager.PRIORITY_LEVEL)) ? map.get(CacheManager.PRIORITY_LEVEL) : "2";
        sb.append("priority_level=" + str2);
        String str3 = map.get("biz_type");
        String enableDownloader = !TextUtils.isEmpty(str3) ? ApsUtil.enableDownloader(str3) : "1";
        sb.append("&use_downloader=" + enableDownloader);
        if ("1".equals(enableDownloader) && (context = this.mContext) != null) {
            P2pManager.Result pcdnUrl = P2pManager.getInstance(context).getPcdnUrl(this.mContext, PcdnType.LIVE, str);
            if (!"10000".equals(pcdnUrl.errorCode)) {
                TLogUtil.playLog("p2pCode=" + pcdnUrl.errorCode);
            } else if (!TextUtils.isEmpty(pcdnUrl.finalUrl)) {
                str = pcdnUrl.finalUrl;
            }
        }
        if (!TextUtils.isEmpty(map.get(CacheManager.PRELOAD_SIZE))) {
            try {
                int parseInt = Integer.parseInt(map.get(CacheManager.PRELOAD_SIZE));
                sb.append("&preload_size=" + parseInt);
            } catch (NumberFormatException unused) {
            }
        }
        if (!TextUtils.isEmpty(map.get(CacheManager.SLICE_ID))) {
            try {
                long parseLong = Long.parseLong(map.get(CacheManager.SLICE_ID));
                sb.append("&slice_id=" + parseLong);
            } catch (NumberFormatException unused2) {
            }
        }
        Preloader.PreloadStatus checkPreloadStatus = Preloader.checkPreloadStatus(str);
        if (checkPreloadStatus == Preloader.PreloadStatus.COMPLETED) {
            TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, "MultiMediaSourceCacheTask dataExist url:" + str);
            updatePreloadResultComplete(str);
        } else if (checkPreloadStatus == Preloader.PreloadStatus.STARTED) {
            TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, "MultiMediaSourceCacheTask taskExist url:" + str);
        } else {
            TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, "MultiMediaSourceCacheTask preload url:" + str + "-params:" + sb.toString());
            Preloader.preload(str, sb.toString(), new Preloader.PreloadListener() {
                /* class com.youku.playerservice.axp.cache.task.MultiMediaSourceCacheTask.AnonymousClass2 */

                @Override // com.youku.alixplayer.misc.Preloader.PreloadListener
                public void onPreloadStatusUpdated(String str, Preloader.PreloadStatus preloadStatus) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("MultiMediaSourceCacheTask onPreloadStatusUpdated url:");
                    sb.append(str);
                    Preloader.PreloadStatus preloadStatus2 = Preloader.PreloadStatus.COMPLETED;
                    sb.append(preloadStatus == preloadStatus2 ? "-complete" : "-failed");
                    TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, sb.toString());
                    if (MultiMediaSourceCacheTask.this.mPreloadResult == null || MultiMediaSourceCacheTask.this.mPreloadResult.size() <= 0) {
                        CachePreloadResult.AXPCachePreloadStatus aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_SUCCESS_MEDIASOURCE;
                        if (preloadStatus != preloadStatus2 && preloadStatus == Preloader.PreloadStatus.FAILED) {
                            aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE;
                        }
                        if (MultiMediaSourceCacheTask.this.mInternalCallback != null) {
                            CachePreloadResult cachePreloadResult = new CachePreloadResult();
                            cachePreloadResult.setUrlOfPreload(str);
                            MultiMediaSourceCacheTask.this.mInternalCallback.onResult(MultiMediaSourceCacheTask.this.mKey, null, aXPCachePreloadStatus, cachePreloadResult);
                        }
                    } else if (preloadStatus == preloadStatus2) {
                        MultiMediaSourceCacheTask.this.updatePreloadResultComplete(str);
                    } else if (preloadStatus == Preloader.PreloadStatus.FAILED) {
                        for (String str2 : MultiMediaSourceCacheTask.this.mPreloadResult.keySet()) {
                            Map map = (Map) MultiMediaSourceCacheTask.this.mPreloadResult.get(str2);
                            if (map != null && map.containsKey(str)) {
                                map.put(str, "-1");
                                if (MultiMediaSourceCacheTask.this.mInternalCallback != null) {
                                    MultiMediaSourceCacheTask.this.mPreloadResult.remove(map);
                                    CachePreloadResult cachePreloadResult2 = new CachePreloadResult();
                                    cachePreloadResult2.setVidOfPreload(str2);
                                    MultiMediaSourceCacheTask.this.mInternalCallback.onResult(MultiMediaSourceCacheTask.this.mKey, null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE, cachePreloadResult2);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void preloadSimpleVideoInfo(SimpleVideoInfo simpleVideoInfo, Map<String, String> map) {
        String str = simpleVideoInfo.getStream().m3u8_url;
        if (TextUtils.isEmpty(str) || !"1".equals(Uri.parse(str).getQueryParameter("sm"))) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            for (Segs segs : simpleVideoInfo.getStream().segs) {
                hashMap.put(segs.cdn_url, "0");
            }
            this.mPreloadResult.put(simpleVideoInfo.getVid(), hashMap);
            CachePreloadResult cachePreloadResult = new CachePreloadResult();
            cachePreloadResult.setVidToUrls(this.mPreloadResult);
            IInternalCachePreloadCallback iInternalCachePreloadCallback = this.mInternalCallback;
            if (iInternalCachePreloadCallback != null) {
                iInternalCachePreloadCallback.onResult(this.mKey, null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_MEDIASOURCE_UPDATEVIDTOURL, cachePreloadResult);
            }
            for (Segs segs2 : simpleVideoInfo.getStream().segs) {
                addPreloadTask(segs2.cdn_url, this.mExtParams);
            }
            return;
        }
        CachePreloadResult cachePreloadResult2 = new CachePreloadResult();
        cachePreloadResult2.setVidToUrls(this.mPreloadResult);
        IInternalCachePreloadCallback iInternalCachePreloadCallback2 = this.mInternalCallback;
        if (iInternalCachePreloadCallback2 != null) {
            iInternalCachePreloadCallback2.onResult(this.mKey, null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_MEDIASOURCE_UPDATEVIDTOURL, cachePreloadResult2);
        }
        CachePreloadResult cachePreloadResult3 = new CachePreloadResult();
        cachePreloadResult3.setVidOfPreload(simpleVideoInfo.getVid());
        IInternalCachePreloadCallback iInternalCachePreloadCallback3 = this.mInternalCallback;
        if (iInternalCachePreloadCallback3 != null) {
            iInternalCachePreloadCallback3.onResult(this.mKey, null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE, cachePreloadResult3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updatePreloadResultComplete(String str) {
        Map<String, Map<String, String>> map = this.mPreloadResult;
        if (map != null && map.size() > 0) {
            for (String str2 : this.mPreloadResult.keySet()) {
                Map<String, String> map2 = this.mPreloadResult.get(str2);
                if (map2 != null && map2.containsKey(str)) {
                    map2.put(str, "1");
                    boolean z = true;
                    for (String str3 : map2.values()) {
                        if (str3.equals("0")) {
                            z = false;
                        }
                    }
                    if (z && this.mInternalCallback != null) {
                        this.mPreloadResult.remove(map2);
                        CachePreloadResult cachePreloadResult = new CachePreloadResult();
                        cachePreloadResult.setVidOfPreload(str2);
                        this.mInternalCallback.onResult(this.mKey, null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_SUCCESS_MEDIASOURCE, cachePreloadResult);
                    }
                }
            }
        } else if (this.mInternalCallback != null) {
            CachePreloadResult cachePreloadResult2 = new CachePreloadResult();
            cachePreloadResult2.setUrlOfPreload(str);
            this.mInternalCallback.onResult(this.mKey, null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_SUCCESS_MEDIASOURCE, cachePreloadResult2);
        }
    }

    @Override // java.util.concurrent.Callable, com.youku.playerservice.axp.cache.task.CacheTask, com.youku.playerservice.axp.cache.task.CacheTask
    public CachePreloadResult call() {
        if (this.mUrls != null) {
            TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, "MultiMediaSourceCacheTask startwork urls:" + this.mUrls.toString());
            for (String str : this.mUrls) {
                addPreloadTask(str, this.mExtParams);
            }
            IInternalCachePreloadCallback iInternalCachePreloadCallback = this.mInternalCallback;
            if (iInternalCachePreloadCallback != null) {
                iInternalCachePreloadCallback.onResult(this.mKey, null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_MEDIASOURCE_UPDATEVIDTOURL, null);
            }
        } else if (this.mVids != null) {
            TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, "MultiMediaSourceCacheTask startwork vids:" + this.mVids.toString());
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            String str3 = this.mExtParams.containsKey(TableField.PLAYER_SOURCE) ? this.mExtParams.get(TableField.PLAYER_SOURCE) : str2;
            for (String str4 : this.mVids) {
                PlayInfoResponse queryPlayInfoResponse = CachePool.getInstance().queryPlayInfoResponse(this.mContext, PlayDefinition.PlayInfoType.UPS, str4, str3);
                if (queryPlayInfoResponse == null || queryPlayInfoResponse.getUpsInfo() == null || queryPlayInfoResponse.getUpsInfo().getSimpleVideoInfo() == null) {
                    arrayList.add(str4);
                } else {
                    preloadSimpleVideoInfo(queryPlayInfoResponse.getUpsInfo().getSimpleVideoInfo(), this.mExtParams);
                }
            }
            if (arrayList.size() != 0) {
                TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, "MultiMediaSourceCacheTask request vids:" + arrayList.toString());
                MultiGetUpsRequest multiGetUpsRequest = new MultiGetUpsRequest(this.mContext);
                multiGetUpsRequest.setRequestCallback(this.mPlayInfoRequestCallback);
                if (this.mExtParams.containsKey("ccode")) {
                    str2 = this.mExtParams.get("ccode");
                }
                int intValue = !TextUtils.isEmpty(this.mExtParams.get("requestQuality")) ? Integer.valueOf(this.mExtParams.get("requestQuality")).intValue() : 0;
                PlayIdParams playIdParams = new PlayIdParams(this.mVids.get(0), str2);
                playIdParams.putString(TableField.PLAYER_SOURCE, str3);
                playIdParams.setVids(arrayList);
                playIdParams.setRequestQuality(Quality.getQualityByCode(intValue));
                multiGetUpsRequest.request(PlayParams.createPlayParams(PlayDefinition.PlayType.VOD, PlayDefinition.PlayScene.LONG_VIDEO, playIdParams));
            }
        }
        return null;
    }
}
