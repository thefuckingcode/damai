package cn.damai.player.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.decor.HomeVideoUiFacade;
import cn.damai.player.video.listener.VideoListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FadeVideoView extends ResizeFrameLayout implements ApiPlayer {
    private static transient /* synthetic */ IpChange $ipChange;
    private HomeVideoUiFacade mFacade;
    private VideoInfo mVideoInfo;

    public FadeVideoView(@NonNull Context context) {
        this(context, null);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public int getDuration() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1669585021")) {
            return -1;
        }
        return ((Integer) ipChange.ipc$dispatch("1669585021", new Object[]{this})).intValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public VideoInfo getPlayInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1586352404")) {
            return this.mVideoInfo;
        }
        return (VideoInfo) ipChange.ipc$dispatch("-1586352404", new Object[]{this});
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public String getSessionId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1203877755")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1203877755", new Object[]{this});
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void idle(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515902036")) {
            ipChange.ipc$dispatch("1515902036", new Object[]{this, videoInfo});
        } else if (videoInfo != null) {
            this.mVideoInfo = videoInfo;
            this.mFacade.g(videoInfo);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isMute() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2004020617")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2004020617", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPaused() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1995971198")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1995971198", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPlaying() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "506485108")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("506485108", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void mute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1468248887")) {
            ipChange.ipc$dispatch("1468248887", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874835806")) {
            ipChange.ipc$dispatch("1874835806", new Object[]{this});
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void play(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315029772")) {
            ipChange.ipc$dispatch("-1315029772", new Object[]{this, videoInfo});
        } else if (videoInfo != null) {
            this.mVideoInfo = videoInfo;
            this.mFacade.g(videoInfo);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708953581")) {
            ipChange.ipc$dispatch("708953581", new Object[]{this});
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void setListener(VideoListener videoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200506926")) {
            ipChange.ipc$dispatch("-1200506926", new Object[]{this, videoListener});
            return;
        }
        this.mFacade.b(videoListener);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917940594")) {
            ipChange.ipc$dispatch("1917940594", new Object[]{this});
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-618070860")) {
            ipChange.ipc$dispatch("-618070860", new Object[]{this});
        }
    }

    public FadeVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FadeVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        HomeVideoUiFacade homeVideoUiFacade = new HomeVideoUiFacade(this);
        this.mFacade = homeVideoUiFacade;
        View a = homeVideoUiFacade.a();
        this.mFacade.p(false);
        addView(a, -1, -1);
    }
}
