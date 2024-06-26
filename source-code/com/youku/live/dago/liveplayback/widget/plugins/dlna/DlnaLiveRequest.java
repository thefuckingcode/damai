package com.youku.live.dago.liveplayback.widget.plugins.dlna;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.android.liveservice.LivePlayerController;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import java.util.Map;

/* compiled from: Taobao */
public class DlnaLiveRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "DlnaLiveRequest";
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private volatile boolean mIsCancel;
    private PlayerConfig mPlayerConfig;

    /* compiled from: Taobao */
    public interface Callback<T, E> {
        void onFailure(VideoRequestError videoRequestError);

        void onStat(Map<String, String> map);

        void onSuccess(T t, E e);
    }

    public DlnaLiveRequest(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportError(final Callback callback, final VideoRequestError videoRequestError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-520515437")) {
            ipChange.ipc$dispatch("-520515437", new Object[]{this, callback, videoRequestError});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-158924870")) {
                    ipChange.ipc$dispatch("-158924870", new Object[]{this});
                } else if (callback != null && !DlnaLiveRequest.this.mIsCancel) {
                    callback.onFailure(videoRequestError);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportSuccess(final Callback callback, final BypassPlayInfo bypassPlayInfo, final LivePlayControl livePlayControl) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-603970475")) {
            ipChange.ipc$dispatch("-603970475", new Object[]{this, callback, bypassPlayInfo, livePlayControl});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "37588635")) {
                    ipChange.ipc$dispatch("37588635", new Object[]{this});
                } else if (callback != null && !DlnaLiveRequest.this.mIsCancel) {
                    callback.onSuccess(bypassPlayInfo, livePlayControl);
                }
            }
        });
    }

    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918330684")) {
            ipChange.ipc$dispatch("1918330684", new Object[]{this});
            return;
        }
        this.mIsCancel = true;
    }

    public void request(final PlayVideoInfo playVideoInfo, Map map, final Callback callback) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114704974")) {
            ipChange.ipc$dispatch("-2114704974", new Object[]{this, playVideoInfo, map, callback});
            return;
        }
        Logger.d(TAG, "getPlayControlAndReplay");
        String liveId = playVideoInfo.getLiveId();
        String string = playVideoInfo.getString("sceneId");
        if (map == null || TextUtils.isEmpty((String) map.get("ccode"))) {
            str = "";
        } else {
            str = (String) map.get("ccode");
        }
        LivePlayerController livePlayerController = new LivePlayerController(liveId, this.mContext, str, this.mPlayerConfig.getAppKey());
        livePlayerController.setPlayControlListener(new LivePlayerController.IPlayControlListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
            public void requestFailure(LivePlayControl livePlayControl, int i, String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-919587954")) {
                    ipChange.ipc$dispatch("-919587954", new Object[]{this, livePlayControl, Integer.valueOf(i), str});
                    return;
                }
                VideoRequestError videoRequestError = new VideoRequestError(playVideoInfo);
                videoRequestError.setLivePlayControl(livePlayControl);
                videoRequestError.setErrorCode(i);
                videoRequestError.setErrorMsg(str);
                DlnaLiveRequest.this.reportError(callback, videoRequestError);
            }

            @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
            public void requestSuccess(VideoInfo videoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-905559686")) {
                    ipChange.ipc$dispatch("-905559686", new Object[]{this, videoInfo});
                    return;
                }
                Logger.d(DlnaLiveRequest.TAG, "getPlayControlAndReplay requestSuccess");
                if ("live".equals(videoInfo.livePlayControl.streamMode)) {
                    Logger.d(DlnaLiveRequest.TAG, "live playcontrol streamMode=live");
                }
                DlnaLiveRequest.this.reportSuccess(callback, videoInfo.bypassPlayInfo, videoInfo.livePlayControl);
            }
        });
        livePlayerController.getPlayControl(liveId, string, playVideoInfo.getRequestLiveQuality() + "", null, null, null, null, null, null, false);
    }
}
