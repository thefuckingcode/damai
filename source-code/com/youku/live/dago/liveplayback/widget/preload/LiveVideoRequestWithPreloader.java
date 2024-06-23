package com.youku.live.dago.liveplayback.widget.preload;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.live.LiveVideoRequest;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.preloader.IPreloader;
import com.youku.live.dsl.preloader.IPreloaderMananger;
import com.youku.live.dsl.preloader.IResultCallback;
import java.util.Map;

/* compiled from: Taobao */
public class LiveVideoRequestWithPreloader extends LiveVideoRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "LiveVideoRequestWithPreloader";

    public LiveVideoRequestWithPreloader(Context context, PlayerConfig playerConfig) {
        super(context, playerConfig);
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest, com.youku.alixplayer.opensdk.live.LiveVideoRequest
    public void request(final PlayVideoInfo playVideoInfo, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "901831386")) {
            ipChange.ipc$dispatch("901831386", new Object[]{this, playVideoInfo, map});
            return;
        }
        TLogUtil.playLog("request live liveId=" + playVideoInfo.getLiveId());
        this.mState = IVideoRequest.State.DOING;
        String string = playVideoInfo.getString("playControlRequireId");
        if (!TextUtils.isEmpty(string)) {
            IPreloader iPreloader = null;
            IPreloaderMananger iPreloaderMananger = (IPreloaderMananger) Dsl.getService(IPreloaderMananger.class);
            if (iPreloaderMananger != null) {
                iPreloader = iPreloaderMananger.getLivePlayControlPreloader(string);
            }
            if (iPreloader != null) {
                iPreloader.isFinish();
                iPreloader.addResultCallback(new IResultCallback() {
                    /* class com.youku.live.dago.liveplayback.widget.preload.LiveVideoRequestWithPreloader.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dsl.preloader.IResultCallback
                    public void onResult(Map<String, Object> map) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1971554645")) {
                            ipChange.ipc$dispatch("-1971554645", new Object[]{this, map});
                            return;
                        }
                        VideoInfo videoInfo = null;
                        if (map != null) {
                            Object obj = map.get("videoInfo");
                            if (obj instanceof VideoInfo) {
                                videoInfo = (VideoInfo) obj;
                            }
                        }
                        LiveVideoRequestWithPreloader.this.requestSuccess(playVideoInfo, videoInfo);
                    }
                }, new IResultCallback() {
                    /* class com.youku.live.dago.liveplayback.widget.preload.LiveVideoRequestWithPreloader.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dsl.preloader.IResultCallback
                    public void onResult(Map<String, Object> map) {
                        String str;
                        Integer num;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1960238518")) {
                            ipChange.ipc$dispatch("-1960238518", new Object[]{this, map});
                            return;
                        }
                        LivePlayControl livePlayControl = null;
                        String str2 = null;
                        if (map != null) {
                            Object obj = map.get("livePlayControl");
                            LivePlayControl livePlayControl2 = obj instanceof LivePlayControl ? (LivePlayControl) obj : null;
                            Object obj2 = map.get("code");
                            num = obj2 instanceof Integer ? (Integer) obj2 : null;
                            Object obj3 = map.get("msg");
                            if (obj3 instanceof String) {
                                str2 = (String) obj3;
                            }
                            str = str2;
                            livePlayControl = livePlayControl2;
                        } else {
                            str = null;
                            num = null;
                        }
                        LiveVideoRequestWithPreloader.this.requestFailure(playVideoInfo, livePlayControl, num.intValue(), str);
                    }
                });
                return;
            }
        }
        super.request(playVideoInfo, map);
    }
}
