package com.youku.playerservice.axp.cache;

import android.content.Context;
import android.text.TextUtils;
import com.youku.a.a;
import com.youku.alixplayer.misc.Preloader;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.CachePreloadParams;
import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.cache.task.MediaSourceCacheTask;
import com.youku.playerservice.axp.cache.task.MinsetTask;
import com.youku.playerservice.axp.cache.task.MultiGetUpsTask;
import com.youku.playerservice.axp.cache.task.MultiMediaSourceCacheTask;
import com.youku.playerservice.axp.cache.task.PlayInfoMultiCacheTask;
import com.youku.playerservice.axp.cache.task.PlayInfoNormalCacheTask;
import com.youku.playerservice.axp.cache.task.PlayerCacheTask;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: Taobao */
public class CacheManager implements IInternalCachePreloadCallback {
    public static final String BIZ_TYPE = "biz_type";
    public static final String BIZ_TYPE_FEED = "feed";
    public static final String BIZ_TYPE_LIVE = "live";
    public static final String BIZ_TYPE_VOD = "vod";
    public static final String PRELOAD_SIZE = "preload_size";
    public static final String PRIORITY_LEVEL = "priority_level";
    public static final String SLICE_ID = "slice_id";
    public static final String TAG_MEDIASOURCE = "CacheManager-MediaSource";
    public static final String TAG_MINSET = "CacheManager-Minset";
    public static final String TAG_MULTIGET = "CacheManager-MultiGet";
    public static final String TAG_PLAYER = "CacheManager-Player";
    private static volatile CacheManager mAXPCacheManager;
    private ConcurrentHashMap<String, CacheRecorder> mCacheRecorders = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ICachePreloadCallback> mCallbacks = new ConcurrentHashMap<>();
    private ExecutorService mExecutorService = Executors.newCachedThreadPool();
    private ConcurrentHashMap<String, Future> mTasks = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<String>> mUrlRecorder = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, Map<String, String>>> mVidRecorder = new ConcurrentHashMap<>();

    private CacheManager() {
        Logger.setDebugMode(true);
    }

    private void addPoolId(String str, String str2) {
        CacheRecorder cacheRecorder;
        if (!TextUtils.isEmpty(str)) {
            if (!this.mCacheRecorders.containsKey(str)) {
                cacheRecorder = new CacheRecorder();
                this.mCacheRecorders.put(str, cacheRecorder);
            } else {
                cacheRecorder = this.mCacheRecorders.get(str);
            }
            cacheRecorder.addPoolId(str2);
        }
    }

    private void addTaskKey(String str, String str2) {
        CacheRecorder cacheRecorder;
        if (!TextUtils.isEmpty(str)) {
            if (!this.mCacheRecorders.containsKey(str)) {
                cacheRecorder = new CacheRecorder();
                this.mCacheRecorders.put(str, cacheRecorder);
            } else {
                cacheRecorder = this.mCacheRecorders.get(str);
            }
            cacheRecorder.addTaskKey(str2);
        }
    }

    private void cancelPreloadTask(String str) {
        TLogUtil.loge(TAG_MEDIASOURCE, "cancelPreloadTask url:" + str);
        Preloader.cancelPreload(str);
    }

    private void cancelTaskByGroupid(String str) {
        CacheRecorder cacheRecorder = this.mCacheRecorders.get(str);
        if (cacheRecorder != null) {
            List<String> taskKeyList = cacheRecorder.getTaskKeyList();
            synchronized (taskKeyList) {
                if (taskKeyList.size() > 0) {
                    for (String str2 : taskKeyList) {
                        Future future = this.mTasks.get(str2);
                        if (future != null) {
                            future.cancel(true);
                            this.mTasks.remove(str2);
                        }
                    }
                    taskKeyList.clear();
                }
            }
        }
    }

    public static CacheManager getInstance() {
        if (mAXPCacheManager == null) {
            synchronized (CacheManager.class) {
                if (mAXPCacheManager == null) {
                    mAXPCacheManager = new CacheManager();
                }
            }
        }
        return mAXPCacheManager;
    }

    private void recyclePlayersByGroupid(Context context, String str) {
        CacheRecorder cacheRecorder = this.mCacheRecorders.get(str);
        if (cacheRecorder != null) {
            List<String> poolIdList = cacheRecorder.getPoolIdList();
            synchronized (poolIdList) {
                if (poolIdList.size() > 0) {
                    for (String str2 : poolIdList) {
                        a.a(context).b(str2);
                        TLogUtil.loge(TAG_PLAYER, "recyclePlayersByGroupid: recyclePlayer-" + str2);
                    }
                    poolIdList.clear();
                }
            }
        }
    }

    private void removeTaskKey(String str) {
        for (CacheRecorder cacheRecorder : this.mCacheRecorders.values()) {
            cacheRecorder.removeTaskKey(str);
        }
    }

    public void cancelUrlMediaSourceWithKey(String str) {
        TLogUtil.loge(TAG_MEDIASOURCE, "cancelUrlMediaSourceWithKey key:" + str);
        Future future = this.mTasks.get(str);
        if (future != null) {
            future.cancel(true);
            this.mTasks.remove(str);
        }
        List<String> list = this.mUrlRecorder.get(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                cancelPreloadTask(str2);
            }
            this.mUrlRecorder.remove(str);
        }
    }

    public void cancelVidMediaSourceWithKey(String str) {
        TLogUtil.loge(TAG_MEDIASOURCE, "cancelVidMediaSourceWithKey key:" + str);
        Future future = this.mTasks.get(str);
        if (future != null) {
            future.cancel(true);
            this.mTasks.remove(str);
        }
        synchronized (this) {
            if (this.mVidRecorder.get(str) != null) {
                for (Map<String, String> map : this.mVidRecorder.get(str).values()) {
                    if (map != null) {
                        for (String str2 : map.keySet()) {
                            cancelPreloadTask(str2);
                        }
                    }
                }
            }
        }
    }

    public void clearCallbackWithKey(String str) {
        ConcurrentHashMap<String, ICachePreloadCallback> concurrentHashMap = this.mCallbacks;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            this.mCallbacks.remove(str);
        }
        synchronized (this) {
            this.mVidRecorder.remove(str);
        }
    }

    public void clearPreloadWithGroupid(Context context, String str) {
        TLogUtil.loge(TAG_PLAYER, "clearPreloadWithGroupid：" + str);
        if (!TextUtils.isEmpty(str) && this.mCacheRecorders.containsKey(str)) {
            cancelTaskByGroupid(str);
            recyclePlayersByGroupid(context, str);
            this.mCacheRecorders.remove(str);
            for (CacheRecorder cacheRecorder : this.mCacheRecorders.values()) {
                if (cacheRecorder != null && cacheRecorder.getPoolIdList().size() > 0) {
                    TLogUtil.loge(TAG_PLAYER, "recyclePlayersByGroupid: leftPlayer-" + cacheRecorder.getPoolIdList().toString());
                }
            }
        }
    }

    public void clearPreloadWithKey(String str) {
        TLogUtil.loge(TAG_PLAYER, "clearPreloadWithKey：" + str);
        Future future = this.mTasks.get(str);
        if (future != null) {
            future.cancel(true);
            this.mTasks.remove(str);
        }
    }

    public String getPreloadKey() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        return !this.mTasks.containsKey(valueOf) ? valueOf : String.valueOf(System.currentTimeMillis());
    }

    public boolean isExistsPreloadWithKey(String str) {
        return this.mTasks.get(str) != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b5, code lost:
        if (android.text.TextUtils.isEmpty(r10.getPlayerId()) == false) goto L_0x00c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // com.youku.playerservice.axp.cache.IInternalCachePreloadCallback
    public void onResult(String str, CachePreloadParams cachePreloadParams, CachePreloadResult.AXPCachePreloadStatus aXPCachePreloadStatus, CachePreloadResult cachePreloadResult) {
        if (!(cachePreloadParams == null || cachePreloadParams.getPlayParams() == null)) {
            String str2 = "";
            String str3 = "";
            if (cachePreloadParams.getPlayParams().getPlayIdParams() != null) {
                str2 = cachePreloadParams.getPlayParams().getPlayIdParams().getPlayId();
            } else if (cachePreloadParams.getPlayParams().getPlayUrlParams() != null) {
                str3 = cachePreloadParams.getPlayParams().getPlayUrlParams().getPlayUrl();
            }
            TLogUtil.loge(TAG_PLAYER, "onResult--playid:" + str2 + "--playUrl:" + str3 + "--state:" + aXPCachePreloadStatus.value);
            if (aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PLAYER && cachePreloadResult != null) {
                PlayInfoError error = cachePreloadResult.getError();
                TLogUtil.loge(TAG_PLAYER, "onResult--playfailed--playid:" + str2 + "--playUrl:" + str3 + "--code:" + error.getErrorCode());
            }
        }
        CachePreloadResult.AXPCachePreloadStatus aXPCachePreloadStatus2 = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_CREATE_PLAYER;
        if (aXPCachePreloadStatus != aXPCachePreloadStatus2) {
            removeTaskKey(str);
            if (this.mTasks.containsKey(str)) {
                this.mTasks.remove(str);
            }
        }
        if (aXPCachePreloadStatus == aXPCachePreloadStatus2) {
            if (cachePreloadResult != null) {
            }
            if (aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_MEDIASOURCE_UPDATEVIDTOURL) {
                synchronized (this) {
                    if (cachePreloadResult != null) {
                        if (cachePreloadResult.getVidToUrls() != null) {
                            if (this.mVidRecorder.containsKey(str)) {
                                this.mVidRecorder.get(str).putAll(cachePreloadResult.getVidToUrls());
                            } else {
                                this.mVidRecorder.put(str, cachePreloadResult.getVidToUrls());
                            }
                        }
                    }
                }
            }
            if (this.mCallbacks.get(str) != null) {
                this.mCallbacks.get(str).onResult(cachePreloadParams, aXPCachePreloadStatus, cachePreloadResult);
                if (aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS || aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_TASK || aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_SUCCESS_PLAYER || aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PLAYER || aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_PLAYER || aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_NOPLAYID_PLAYER) {
                    this.mCallbacks.remove(str);
                    return;
                }
                return;
            }
            return;
        }
        if (aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_PLAYER) {
            removePoolId(cachePreloadResult.getPlayerId());
        }
        if (aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_MEDIASOURCE_UPDATEVIDTOURL) {
        }
        if (this.mCallbacks.get(str) != null) {
        }
        addPoolId(cachePreloadParams.getGroupId(), cachePreloadResult.getPlayerId());
        if (aXPCachePreloadStatus == CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_MEDIASOURCE_UPDATEVIDTOURL) {
        }
        if (this.mCallbacks.get(str) != null) {
        }
    }

    public void preloadMediaSourceWithUrls(String str, Context context, List<String> list, Map<String, String> map, ICachePreloadCallback iCachePreloadCallback) {
        if (TextUtils.isEmpty(str) || context == null) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithUrls params error");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS, null);
            }
        } else if (list == null || list.size() == 0 || list.size() > 10) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithUrls urls error");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS, null);
            }
        } else if (isExistsPreloadWithKey(str)) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithUrls：key is exist");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_TASK, null);
            }
        } else {
            if (iCachePreloadCallback != null) {
                this.mCallbacks.put(str, iCachePreloadCallback);
            }
            this.mTasks.put(str, this.mExecutorService.submit(new MultiMediaSourceCacheTask(str, context, null, list, map, this)));
            this.mUrlRecorder.put(str, list);
        }
    }

    public void preloadMediaSourceWithVids(String str, Context context, List<String> list, Map<String, String> map, ICachePreloadCallback iCachePreloadCallback) {
        if (TextUtils.isEmpty(str) || context == null) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithVids params error");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS, null);
            }
        } else if (list == null || list.size() == 0 || list.size() > 10) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithVids vids error");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS, null);
            }
        } else if (isExistsPreloadWithKey(str)) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithVids：key is exist");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_TASK, null);
            }
        } else {
            if (iCachePreloadCallback != null) {
                this.mCallbacks.put(str, iCachePreloadCallback);
            }
            this.mTasks.put(str, this.mExecutorService.submit(new MultiMediaSourceCacheTask(str, context, list, null, map, this)));
        }
    }

    public void preloadMinset(Context context, List<MinsetPreloadInfo> list, Map<String, String> map) {
        if (list != null && list.size() != 0) {
            this.mExecutorService.submit(new MinsetTask(context, list, map));
        }
    }

    public void preloadMultiget(Context context, List<String> list, Map<String, String> map, IMultiGetUpsCallback iMultiGetUpsCallback) {
        if (list != null && list.size() != 0) {
            this.mExecutorService.submit(new MultiGetUpsTask(context, list, map, iMultiGetUpsCallback));
        }
    }

    public void preloadWithKey(String str, CachePreloadParams cachePreloadParams, ICachePreloadCallback iCachePreloadCallback) {
        ICachePreloadCallback iCachePreloadCallback2;
        CachePreloadResult.AXPCachePreloadStatus aXPCachePreloadStatus;
        String str2;
        if (iCachePreloadCallback != null) {
            this.mCallbacks.put(str, iCachePreloadCallback);
        }
        Object obj = null;
        if (!TextUtils.isEmpty(str) || this.mCallbacks.get(str) == null) {
            if (!TextUtils.isEmpty(cachePreloadParams.getGroupId()) || this.mCallbacks.get(str) == null) {
                if (cachePreloadParams.getPlayParams() != null) {
                    String str3 = "";
                    if (cachePreloadParams.getPlayParams().getPlayIdParams() != null) {
                        str3 = cachePreloadParams.getPlayParams().getPlayIdParams().getPlayId();
                        str2 = str3;
                    } else {
                        str2 = cachePreloadParams.getPlayParams().getPlayUrlParams() != null ? cachePreloadParams.getPlayParams().getPlayUrlParams().getPlayUrl() : str3;
                    }
                    TLogUtil.loge(TAG_PLAYER, "preloadWithKey--playid:" + str3 + "--playUrl:" + str2 + "--groupid:" + cachePreloadParams.getGroupId());
                }
                if (isExistsPreloadWithKey(str)) {
                    TLogUtil.loge(TAG_PLAYER, "preloadWithKey：key is exist");
                    if (this.mCallbacks.get(str) != null) {
                        iCachePreloadCallback2 = this.mCallbacks.get(str);
                        aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_TASK;
                        iCachePreloadCallback2.onResult(cachePreloadParams, aXPCachePreloadStatus, null);
                    }
                }
                if (cachePreloadParams.getPlayParams() != null) {
                    cachePreloadParams.getPlayParams().putString("prePlayTs", String.valueOf(System.currentTimeMillis()));
                }
                CachePreloadParams.AXPCacheAction cacheAction = cachePreloadParams.getCacheAction();
                if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_PLAYINFO_NORMAL) {
                    obj = new PlayInfoNormalCacheTask(str, cachePreloadParams, this);
                } else if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_PLAYINFO_MULTI) {
                    obj = new PlayInfoMultiCacheTask(str, cachePreloadParams, this);
                } else if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_MEDIASOURCE) {
                    if (cachePreloadParams.getPlayParams() == null || cachePreloadParams.getPlayParams().getPlayType() != PlayDefinition.PlayType.LIVE || this.mCallbacks.get(str) == null) {
                        obj = new MediaSourceCacheTask(str, cachePreloadParams, this);
                    } else {
                        iCachePreloadCallback2 = this.mCallbacks.get(str);
                        aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE;
                        iCachePreloadCallback2.onResult(cachePreloadParams, aXPCachePreloadStatus, null);
                    }
                } else if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_PLAYER) {
                    obj = new PlayerCacheTask(str, cachePreloadParams, this);
                }
                if (obj != null) {
                    this.mTasks.put(str, this.mExecutorService.submit((Callable) obj));
                    if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_PLAYER) {
                        addTaskKey(cachePreloadParams.getGroupId(), str);
                        return;
                    } else if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_MEDIASOURCE && cachePreloadParams.getPlayParams() != null && cachePreloadParams.getPlayParams().getPlayIdParams() != null) {
                        String playUrl = cachePreloadParams.getPlayParams().getPlayIdParams().getPlayUrl();
                        if (!TextUtils.isEmpty(playUrl)) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(playUrl);
                            this.mUrlRecorder.put(str, arrayList);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                TLogUtil.loge(TAG_PLAYER, "preloadWithKey：groupid is null");
            }
        }
        iCachePreloadCallback2 = this.mCallbacks.get(str);
        aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS;
        iCachePreloadCallback2.onResult(cachePreloadParams, aXPCachePreloadStatus, null);
    }

    public int queryPreloadMediaSourceResultWithUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            Preloader.PreloadStatus checkPreloadStatus = Preloader.checkPreloadStatus(str);
            if (checkPreloadStatus == Preloader.PreloadStatus.COMPLETED) {
                return 0;
            }
            if (checkPreloadStatus == Preloader.PreloadStatus.FAILED) {
                return 1;
            }
            if (checkPreloadStatus != Preloader.PreloadStatus.IDLE && checkPreloadStatus == Preloader.PreloadStatus.STARTED) {
                return 3;
            }
        }
        return 2;
    }

    public Preloader.PreloadStatus queryPreloadMediaSourceResultWithVid(String str, String str2) {
        TLogUtil.loge(TAG_MEDIASOURCE, "queryPreloadMediaSourceResultWithVid key:" + str + " vid:" + str2);
        Map<String, Map<String, String>> map = this.mVidRecorder.get(str);
        Preloader.PreloadStatus preloadStatus = null;
        if (map != null && map.containsKey(str2)) {
            Iterator<String> it = map.get(str2).keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Preloader.PreloadStatus checkPreloadStatus = Preloader.checkPreloadStatus(next);
                TLogUtil.loge(TAG_MEDIASOURCE, "queryPreloadMediaSourceResultWithVid url:" + next);
                Preloader.PreloadStatus preloadStatus2 = Preloader.PreloadStatus.COMPLETED;
                if (checkPreloadStatus != preloadStatus2) {
                    Preloader.PreloadStatus preloadStatus3 = Preloader.PreloadStatus.FAILED;
                    if (checkPreloadStatus == preloadStatus3) {
                        preloadStatus = preloadStatus3;
                        break;
                    }
                    Preloader.PreloadStatus preloadStatus4 = Preloader.PreloadStatus.IDLE;
                    if (checkPreloadStatus != preloadStatus4) {
                        preloadStatus2 = Preloader.PreloadStatus.STARTED;
                        if (checkPreloadStatus != preloadStatus2) {
                        }
                        preloadStatus = preloadStatus2;
                    } else if (preloadStatus != preloadStatus2) {
                        if (preloadStatus == null || preloadStatus == preloadStatus4) {
                            preloadStatus = preloadStatus4;
                        }
                    }
                } else if (preloadStatus != Preloader.PreloadStatus.IDLE) {
                    if (!(preloadStatus == null || preloadStatus == preloadStatus2)) {
                    }
                    preloadStatus = preloadStatus2;
                }
                preloadStatus = Preloader.PreloadStatus.STARTED;
            }
        }
        TLogUtil.loge(TAG_MEDIASOURCE, "queryPreloadMediaSourceResultWithVid checkStatus:" + preloadStatus);
        return preloadStatus;
    }

    public void removePoolId(String str) {
        for (CacheRecorder cacheRecorder : this.mCacheRecorders.values()) {
            cacheRecorder.removePoolId(str);
        }
    }
}
