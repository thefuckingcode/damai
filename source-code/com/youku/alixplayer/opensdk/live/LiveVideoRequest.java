package com.youku.alixplayer.opensdk.live;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.ta.utdid2.android.utils.Base64;
import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.PlayerUtil;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.LivePlayerController;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.MicPlayInfo;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class LiveVideoRequest implements IVideoRequest {
    public static final String TAG = "LiveVideoRequest";
    protected IVideoRequest.Callback mCallback;
    protected Context mContext;
    protected volatile boolean mIsCancel;
    protected PlayerConfig mPlayerConfig;
    protected IVideoRequest.State mState = IVideoRequest.State.IDLE;

    public LiveVideoRequest(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
    }

    public static byte[] base64Decode(String str) {
        return Base64.decode(str, 2);
    }

    private void reportError(IVideoRequest.Callback callback, VideoRequestError videoRequestError) {
        if (callback != null && !this.mIsCancel) {
            callback.onFailure(videoRequestError);
        }
    }

    private void reportSuccess(IVideoRequest.Callback callback, LiveInfo liveInfo, List<LiveInfo> list) {
        if (callback != null && !this.mIsCancel) {
            callback.onSuccess(liveInfo, list);
        }
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    public IVideoRequest.State getState() {
        return this.mState;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void request(final PlayVideoInfo playVideoInfo, final Map map) {
        TLogUtil.playLog("request live liveId=" + playVideoInfo.getLiveId());
        this.mState = IVideoRequest.State.DOING;
        final String liveId = playVideoInfo.getLiveId();
        final String string = playVideoInfo.getString("sceneId");
        final String string2 = playVideoInfo.getString(TableField.PS_ID);
        final String valueOf = String.valueOf(playVideoInfo.getRequestLiveQuality());
        final String string3 = playVideoInfo.getString("params");
        new Thread() {
            /* class com.youku.alixplayer.opensdk.live.LiveVideoRequest.AnonymousClass1 */

            public void run() {
                String str;
                String str2 = liveId;
                LiveVideoRequest liveVideoRequest = LiveVideoRequest.this;
                LivePlayerController livePlayerController = new LivePlayerController(str2, liveVideoRequest.mContext, liveVideoRequest.mPlayerConfig.getLiveCCode(), LiveVideoRequest.this.mPlayerConfig.getAppKey());
                livePlayerController.setPlayControlListener(new LivePlayerController.IPlayControlListener() {
                    /* class com.youku.alixplayer.opensdk.live.LiveVideoRequest.AnonymousClass1.AnonymousClass1 */

                    @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
                    public void requestFailure(LivePlayControl livePlayControl, int i, String str) {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        LiveVideoRequest.this.requestFailure(playVideoInfo, livePlayControl, i, str);
                    }

                    @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
                    public void requestSuccess(VideoInfo videoInfo) {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        LiveVideoRequest.this.requestSuccess(playVideoInfo, videoInfo);
                    }
                });
                String json = map != null ? new JSONObject(map).toString() : null;
                PlayerConfig playerConfig = LiveVideoRequest.this.mPlayerConfig;
                if (playerConfig == null || TextUtils.isEmpty(playerConfig.getPlayAbilityJson())) {
                    str = PlayerUtil.getAbilityJson();
                } else {
                    str = LiveVideoRequest.this.mPlayerConfig.getPlayAbilityJson();
                }
                livePlayerController.getPlayControl(liveId, string, valueOf, json, str, string3, null, null, null, false, string2);
            }
        }.start();
    }

    /* access modifiers changed from: protected */
    public void requestFailure(PlayVideoInfo playVideoInfo, LivePlayControl livePlayControl, int i, String str) {
        this.mState = IVideoRequest.State.FINISH;
        VideoRequestError videoRequestError = new VideoRequestError(playVideoInfo);
        videoRequestError.setLivePlayControl(livePlayControl);
        videoRequestError.setErrorCode(i);
        videoRequestError.setErrorMsg(str);
        reportError(this.mCallback, videoRequestError);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017a  */
    public void requestSuccess(PlayVideoInfo playVideoInfo, VideoInfo videoInfo) {
        LiveInfo liveInfo;
        LiveInfo liveInfo2;
        LiveInfo liveInfo3;
        LiveInfo liveInfo4;
        this.mState = IVideoRequest.State.FINISH;
        ArrayList arrayList = new ArrayList();
        BypassPlayInfo bypassPlayInfo = videoInfo.bypassPlayInfo;
        if (bypassPlayInfo != null) {
            liveInfo = new LiveInfo(FileFormat.getFileFormatByProtocol(bypassPlayInfo.playType), videoInfo.livePlayControl);
            liveInfo.bypassPlayInfo = videoInfo.bypassPlayInfo;
            LivePlayControl livePlayControl = videoInfo.livePlayControl;
            liveInfo.playControl = livePlayControl;
            if (livePlayControl != null && !TextUtils.isEmpty(livePlayControl.adJsonStr)) {
                liveInfo.adInfo = videoInfo.livePlayControl.adJsonStr;
            }
            liveInfo.isTrail = videoInfo.isTrail;
            liveInfo.waterMarkV2List = videoInfo.waterMarkV2List;
            liveInfo.videoInfo = videoInfo;
            liveInfo.timeshift = (long) videoInfo.livePlayControl.timeShiftOffset;
        } else {
            List<MicPlayInfo> list = videoInfo.micPlayInfos;
            if (list == null || list.size() <= 0) {
                liveInfo = null;
            } else {
                String str = videoInfo.poList.get(0);
                if (videoInfo.micPlayInfos.size() > 0) {
                    if ("rtp".equals(str)) {
                        Logger.d(TAG, "choose rtp");
                        liveInfo2 = new LiveInfo(FileFormat.RTP, videoInfo.micPlayInfos.get(0).rtp.Url);
                    } else if ("httpFlv".equals(str)) {
                        Logger.d(TAG, "choose flv");
                        liveInfo2 = new LiveInfo(FileFormat.FLV, videoInfo.micPlayInfos.get(0).flv.Url);
                    } else if ("artp".equals(str)) {
                        Logger.d(TAG, "choose artp");
                        liveInfo2 = new LiveInfo(FileFormat.ARTP, videoInfo.micPlayInfos.get(0).artp.Url);
                    } else if ("grtn".equals(str)) {
                        Logger.d(TAG, "choose grtn");
                        liveInfo2 = new LiveInfo(FileFormat.GRTN, videoInfo.micPlayInfos.get(0).grtn.Url);
                    } else {
                        liveInfo2 = null;
                    }
                    if (liveInfo2 != null) {
                        liveInfo2.isTrail = videoInfo.isTrail;
                        liveInfo2.playControl = videoInfo.livePlayControl;
                        liveInfo2.videoInfo = videoInfo;
                    }
                } else {
                    liveInfo2 = null;
                }
                if (videoInfo.micPlayInfos.size() > 1) {
                    if ("rtp".equals(str)) {
                        Logger.d(TAG, "choose rtp");
                        liveInfo4 = new LiveInfo(FileFormat.RTP, videoInfo.micPlayInfos.get(1).rtp.Url);
                    } else if ("httpFlv".equals(str)) {
                        Logger.d(TAG, "choose flv");
                        liveInfo4 = new LiveInfo(FileFormat.FLV, videoInfo.micPlayInfos.get(1).flv.Url);
                    } else if ("artp".equals(str)) {
                        Logger.d(TAG, "choose artp");
                        liveInfo4 = new LiveInfo(FileFormat.ARTP, videoInfo.micPlayInfos.get(1).artp.Url);
                    } else if ("grtn".equals(str)) {
                        Logger.d(TAG, "choose grtn");
                        liveInfo4 = new LiveInfo(FileFormat.GRTN, videoInfo.micPlayInfos.get(1).grtn.Url);
                    } else {
                        liveInfo3 = null;
                        if (liveInfo3 != null) {
                            liveInfo3.playControl = videoInfo.livePlayControl;
                            liveInfo3.videoInfo = videoInfo;
                            arrayList.add(liveInfo3);
                        }
                    }
                    liveInfo3 = liveInfo4;
                    if (liveInfo3 != null) {
                    }
                }
                liveInfo = liveInfo2;
            }
        }
        if (liveInfo != null) {
            reportSuccess(this.mCallback, liveInfo, arrayList);
        } else {
            VideoRequestError videoRequestError = new VideoRequestError(playVideoInfo);
            videoRequestError.setErrorCode(0);
            videoRequestError.setErrorMsg("主麦数据构建失败");
            reportError(this.mCallback, videoRequestError);
        }
        Logger.d(TAG, "getPlayControlAndReplay done");
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void setVideoRequestListener(IVideoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
