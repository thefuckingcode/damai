package com.youku.live.dago.liveplayback.widget.preload;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.live.LiveVideoRequest;

/* compiled from: Taobao */
public class FactoryWithPreloader implements IVideoRequest.Factory {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.alixplayer.opensdk.IVideoRequest.Factory
    public IVideoRequest create(Context context, PlayVideoInfo playVideoInfo, PlayerConfig playerConfig) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "707890086")) {
            return new LiveVideoRequest(context, playerConfig);
        }
        return (IVideoRequest) ipChange.ipc$dispatch("707890086", new Object[]{this, context, playVideoInfo, playerConfig});
    }
}
