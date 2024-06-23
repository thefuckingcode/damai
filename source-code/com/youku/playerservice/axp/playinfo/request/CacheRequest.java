package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.base.model.AdInfo;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.middlewareservice.provider.videodownload.DownloadManagerProviderProxy;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.CacheBitStream;
import com.youku.playerservice.axp.item.Codec;
import com.youku.playerservice.axp.item.MediaMap;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.StreamSegItem;
import com.youku.playerservice.axp.playinfo.CacheUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.thread.CacheWorkThread;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.service.download.DownloadInfo;
import com.youku.service.download.DownloadInfoOuter;
import com.youku.service.download.SubtitleInfo;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.module.Stream;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.util.YoukuUtil;
import com.youku.vip.info.VipUserService;
import com.youku.xadsdk.playerad.PlayerAdManager;
import com.youku.xadsdk.playerad.interfaces.IAdDataCallback;
import com.youku.xadsdk.playerad.model.PlayerVideoInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class CacheRequest implements IPlayInfoRequest {
    public static final String TAG = "CacheRequest";
    protected IPlayInfoRequest.Callback mCallback;
    protected Context mContext;
    protected final Handler mHandler;
    protected volatile boolean mIsCancel;
    protected PlayParams mPlayParams;
    protected PlayerConfig mPlayerConfig;
    private volatile boolean mRequestDone = false;
    private List<PlayInfoResponse> mResponses;
    private IPlayInfoRequest.State mState = IPlayInfoRequest.State.IDLE;

    public CacheRequest(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
        this.mHandler = new Handler(CacheWorkThread.getLooper());
        this.mPlayerConfig = playerConfig;
    }

    private int constructBitStream(DownloadInfoOuter downloadInfoOuter, VideoInfo videoInfo, PlayInfoUpsResponse playInfoUpsResponse) {
        int i;
        Quality quality;
        String str;
        Codec codec;
        PlayDefinition.PlayFormat playFormat;
        String str2;
        String streamType = downloadInfoOuter.getStreamType();
        MediaMap.MediaFormat media = MediaMap.getMedia(streamType);
        Stream stream = getStream(videoInfo, streamType);
        if (media == null || stream == null) {
            quality = Quality.getQualityByCode(downloadInfoOuter.getFormat());
            codec = downloadInfoOuter.isH265() ? Codec.H265 : Codec.H264;
            i = downloadInfoOuter.seconds * 1000;
            str = downloadInfoOuter.getLanguage();
        } else {
            quality = media.getQuality();
            codec = media.getCodec();
            i = stream.milliseconds_video;
            str = stream.audio_lang;
        }
        CacheBitStream cacheBitStream = new CacheBitStream(quality, streamType, codec, i);
        cacheBitStream.setDownloadType(CacheBitStream.DownloadType.FINISH);
        cacheBitStream.setLangCode(str);
        cacheBitStream.putString("downloadType", downloadInfoOuter.getDownloadType() + "");
        playInfoUpsResponse.getPlayParams().putString("downloadType", downloadInfoOuter.getDownloadType() + "");
        if (this.mPlayParams.getPlayIdParams().getRequestQuality() != quality) {
            TLogUtil.flowLog(this.mPlayParams.getSessionId(), "起播清晰度与缓存清晰度不同，优先使用缓存清晰度 " + quality);
            this.mPlayParams.getPlayIdParams().setRequestQuality(quality);
            this.mPlayParams.getPlayIdParams().setLanguageCode(str);
        }
        playInfoUpsResponse.setCacheInfo(new CacheUpsInfo(cacheBitStream, videoInfo, downloadInfoOuter));
        if (LiveManager.StreamConfig.FORMAT_HLS.equals(downloadInfoOuter.getFile_format())) {
            String m3u8Uri = downloadInfoOuter.getM3u8Uri();
            if (downloadInfoOuter.getDownloadType() == 1) {
                if (TextUtils.isEmpty(m3u8Uri)) {
                    return 51001;
                }
                if ("1".equals(ConfigFetcher.getInstance().getConfig("player_switch", "enable_pcdn_check", "1"))) {
                    String PCDNCheckCompletion = DownloadManagerProviderProxy.PCDNCheckCompletion(playInfoUpsResponse.getPlayId(), 1);
                    int parseInt = TextUtils.isEmpty(PCDNCheckCompletion) ? 0 : TextUtils.isDigitsOnly(PCDNCheckCompletion) ? Integer.parseInt(PCDNCheckCompletion) : 1;
                    int i2 = parseInt & 2;
                    if ((parseInt & 8) != 0) {
                        return 51003;
                    }
                    if (i2 != 0) {
                        return 51002;
                    }
                }
            } else if (!new File(m3u8Uri).exists() && !DownloadManagerProviderProxy.playfix(downloadInfoOuter, 2)) {
                return 50005;
            } else {
                if (!new File(m3u8Uri).exists()) {
                    TLogUtil.playLog("CacheRequest playlist修复后还是为空");
                    return 50003;
                }
            }
            cacheBitStream.setM3u8Url(m3u8Uri);
            playFormat = PlayDefinition.PlayFormat.HLS;
        } else if (downloadInfoOuter.getSegInfos() == null || downloadInfoOuter.getSegInfos().isEmpty()) {
            return 50003;
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = downloadInfoOuter.getSegInfos().iterator();
            while (it.hasNext()) {
                DownloadInfo.SegInfo segInfo = (DownloadInfo.SegInfo) it.next();
                long j = (long) (segInfo.seconds * 1000.0d);
                if (downloadInfoOuter.getDownloadType() == 1) {
                    str2 = segInfo.url;
                } else {
                    str2 = downloadInfoOuter.getSavePath() + segInfo.id;
                }
                StreamSegItem streamSegItem = new StreamSegItem(str2, (int) j);
                streamSegItem.setAd(segInfo.isAd ? 1 : 0);
                streamSegItem.setFileSize(segInfo.size);
                arrayList.add(streamSegItem);
            }
            cacheBitStream.setStreamSegList(arrayList);
            playFormat = PlayDefinition.PlayFormat.MP4;
        }
        cacheBitStream.setPlayFormat(playFormat);
        constructSubtitle(downloadInfoOuter, cacheBitStream);
        String playId = this.mPlayParams.getPlayIdParams().getPlayId();
        if ("copyrightDRM".equalsIgnoreCase(downloadInfoOuter.drm_type)) {
            if (TextUtils.isEmpty(DownloadManagerProviderProxy.getCacheDRMKey(this.mContext, playId)) && YoukuUtil.hasInternet()) {
                TLogUtil.playLog("CacheRequest drmKey为空，开始进行修复");
                if (!DownloadManagerProviderProxy.playfix(downloadInfoOuter, 1)) {
                    return 50006;
                }
            }
            String cacheDRMKey = DownloadManagerProviderProxy.getCacheDRMKey(this.mContext, playId);
            if (TextUtils.isEmpty(cacheDRMKey)) {
                TLogUtil.playLog("CacheRequest drmKey修复后还是为空");
                return 50004;
            }
            cacheBitStream.setDrmKey(cacheDRMKey);
            cacheBitStream.setDrmType(downloadInfoOuter.drm_type);
        }
        return 0;
    }

    private void constructSubtitle(DownloadInfoOuter downloadInfoOuter, BitStream bitStream) {
        SubtitleInfo subtitleInfo;
        bitStream.putString("enableSubtitle", downloadInfoOuter.isShowSubtitle() ? "1" : "0");
        if (downloadInfoOuter.subtitlesList != null && downloadInfoOuter.subtitlesList.size() > 0) {
            SubtitleInfo subtitleInfo2 = (SubtitleInfo) downloadInfoOuter.subtitlesList.get(0);
            if (subtitleInfo2 != null) {
                File file = new File(subtitleInfo2.getSavePath());
                if (!file.exists()) {
                    TLogUtil.playLog("字幕0文件不存在，进行修复");
                    this.mPlayParams.putString("subtitleFail", "0号字幕修复");
                    if (YoukuUtil.hasInternet()) {
                        if (!DownloadManagerProviderProxy.playfix(downloadInfoOuter, 3)) {
                            TLogUtil.playLog("字幕0文件不存在，修复失败");
                            this.mPlayParams.putString("subtitleFail", "0号字幕修复失败");
                        }
                    }
                }
                bitStream.putString("firstSubtitleUrl", file.getAbsolutePath());
            }
            if (downloadInfoOuter.subtitlesList.size() >= 2 && (subtitleInfo = (SubtitleInfo) downloadInfoOuter.subtitlesList.get(1)) != null) {
                File file2 = new File(subtitleInfo.getSavePath());
                if (file2.exists()) {
                    bitStream.putString("secondSubtitleUrl", file2.getAbsolutePath());
                } else {
                    TLogUtil.playLog("字幕1文件不存在");
                }
            }
        }
    }

    private PlayerVideoInfo createPlayerVideoInfo(Context context, PlayParams playParams) {
        PlayerVideoInfo playerVideoInfo = new PlayerVideoInfo();
        playerVideoInfo.setVip(VipUserService.getInstance().isVip());
        playerVideoInfo.setQuality("auto");
        playerVideoInfo.setVideoMode(0);
        playerVideoInfo.setIsOffline(true);
        playerVideoInfo.setVideoId(playParams.getPlayIdParams().getPlayId());
        playerVideoInfo.setStreamType(0);
        return playerVideoInfo;
    }

    private Stream getStream(VideoInfo videoInfo, String str) {
        if (videoInfo == null || videoInfo.getStream() == null) {
            return null;
        }
        Stream[] stream = videoInfo.getStream();
        for (Stream stream2 : stream) {
            if (str != null && str.equals(stream2.stream_type)) {
                return stream2;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handle() {
        PlayInfoError playInfoError;
        String str;
        PlayParams playParams;
        if (!this.mIsCancel) {
            DownloadInfoOuter downloadInfoOuter = DownloadManagerProviderProxy.getDownloadInfoOuter(this.mPlayParams.getPlayIdParams().getPlayId());
            final PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(this.mContext, this.mPlayParams);
            playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.LOCAL);
            if (downloadInfoOuter == null) {
                new PlayInfoError().setErrorCode(50002);
                playInfoError = new PlayInfoError();
            } else {
                playInfoUpsResponse.setProperties("downloadInfo", downloadInfoOuter);
                String downloadVersionName = downloadInfoOuter.getDownloadVersionName();
                Long valueOf = Long.valueOf(downloadInfoOuter.getCreateTime());
                PlayParams playParams2 = this.mPlayParams;
                playParams2.putString("downloadCreateTime", valueOf + "");
                this.mPlayParams.putString("downloadVersionName", downloadVersionName);
                String upsSnapshot = downloadInfoOuter.getUpsSnapshot();
                VideoInfo videoInfo = null;
                if (!TextUtils.isEmpty(upsSnapshot)) {
                    try {
                        VideoInfo videoInfo2 = new VideoInfo();
                        ((ParseResult.UpsResult) JSON.parseObject(upsSnapshot, ParseResult.UpsResult.class)).apply(videoInfo2);
                        videoInfo2.setStream(ParseResult.parseStream(videoInfo2.getStreamJson()));
                        videoInfo = videoInfo2;
                    } catch (Exception e) {
                        e.printStackTrace();
                        TLogUtil.flowLog(this.mPlayParams.getSessionId(), e.getMessage());
                        playParams = this.mPlayParams;
                        str = "2";
                    }
                } else {
                    playParams = this.mPlayParams;
                    str = "1";
                    playParams.putString("cacheUpsError", str);
                }
                int constructBitStream = constructBitStream(downloadInfoOuter, videoInfo, playInfoUpsResponse);
                if (constructBitStream != 0) {
                    new PlayInfoError().setErrorCode(constructBitStream);
                    playInfoError = new PlayInfoError();
                } else if (VipUserService.getInstance().isPower(100000, "10002")) {
                    reportResult(playInfoUpsResponse);
                    return;
                } else {
                    PlayerAdManager.getPreAd(createPlayerVideoInfo(this.mContext, this.mPlayParams), new IAdDataCallback() {
                        /* class com.youku.playerservice.axp.playinfo.request.CacheRequest.AnonymousClass2 */

                        public void onFailed(int i, String str) {
                        }

                        public void onSuccess(AdInfo adInfo) {
                            playInfoUpsResponse.setAdInfo(adInfo);
                            CacheRequest.this.onNotifyOnce(playInfoUpsResponse);
                        }
                    });
                    this.mHandler.postDelayed(new Runnable() {
                        /* class com.youku.playerservice.axp.playinfo.request.CacheRequest.AnonymousClass3 */

                        public void run() {
                            CacheRequest.this.onNotifyOnce(playInfoUpsResponse);
                        }
                    }, 300);
                    return;
                }
            }
            playInfoUpsResponse.setError(playInfoError);
            reportResult(playInfoUpsResponse);
        }
    }

    public static boolean hasCacheData(PlayParams playParams) {
        boolean z;
        PlayIdParams playIdParams = playParams.getPlayIdParams();
        boolean isDownLoaded = isDownLoaded(playIdParams);
        if (isDownLoaded || !playIdParams.isLocalPlay()) {
            z = false;
        } else {
            TLogUtil.flowLog(playParams.getSessionId(), "没有downloadInfo，但业务方仍然调用离线播放");
            z = true;
        }
        if (!isDownLoaded || playIdParams.isLocalPlay()) {
            return z;
        }
        TLogUtil.flowLog(playParams.getSessionId(), "播放器检查到有缓存视频，进行缓存播放");
        return true;
    }

    private static boolean isDownLoaded(PlayIdParams playIdParams) {
        String playId = playIdParams.getPlayId();
        String languageCode = playIdParams.getLanguageCode();
        DownloadInfoOuter downloadInfoOuter = DownloadManagerProviderProxy.getDownloadInfoOuter(playId);
        return downloadInfoOuter != null && downloadInfoOuter.getState() == 1 && ("default".equals(downloadInfoOuter.getLanguage()) || "default".equals(languageCode) || "".equals(languageCode) || "null".equals(languageCode) || languageCode == null || TextUtils.equals(languageCode, downloadInfoOuter.getLanguage()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onNotifyOnce(PlayInfoResponse playInfoResponse) {
        if (!this.mRequestDone) {
            this.mRequestDone = true;
            reportResult(playInfoResponse);
        }
    }

    private void reportResult(final PlayInfoResponse playInfoResponse) {
        this.mState = IPlayInfoRequest.State.FINISHED;
        this.mHandler.post(new Runnable() {
            /* class com.youku.playerservice.axp.playinfo.request.CacheRequest.AnonymousClass4 */

            public void run() {
                CacheRequest cacheRequest = CacheRequest.this;
                if (cacheRequest.mCallback != null) {
                    cacheRequest.mResponses = new ArrayList();
                    CacheRequest.this.mResponses.add(playInfoResponse);
                    CacheRequest cacheRequest2 = CacheRequest.this;
                    cacheRequest2.mCallback.onFinished(cacheRequest2.mPlayParams, cacheRequest2.mResponses);
                }
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public List<PlayInfoResponse> getPlayInfoResponses() {
        return this.mResponses;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public IPlayInfoRequest.State getState() {
        return this.mState;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void request(PlayParams playParams) {
        this.mState = IPlayInfoRequest.State.RUNNING;
        this.mPlayParams = playParams;
        this.mHandler.post(new Runnable() {
            /* class com.youku.playerservice.axp.playinfo.request.CacheRequest.AnonymousClass1 */

            public void run() {
                CacheRequest.this.handle();
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
