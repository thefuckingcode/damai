package cn.damai.player.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.decor.a;
import cn.damai.player.video.listener.VideoListener;
import cn.damai.videoplayer.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.youkuplayer.IYoukuPlayer;
import com.youku.youkuplayer.YoukuPlayer;
import com.youku.youkuplayer.data.PlayParam;
import tb.as;
import tb.bj1;
import tb.fs;
import tb.xs0;

/* compiled from: Taobao */
public class VideoView extends ResizeFrameLayout implements ApiPlayer {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isMute;
    private VideoInfo mInfo;
    private MainThreadVideoListener mMainEventDispatcher;
    private IYoukuPlayer mPlayer;
    private bj1 mUiFacade;
    private VideoListener mVideoListener;

    public VideoView(@NonNull Context context) {
        this(context, null);
    }

    private void removeDecorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "96555762")) {
            ipChange.ipc$dispatch("96555762", new Object[]{this});
            return;
        }
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() == R$id.id_video_decor) {
                view = childAt;
            }
        }
        if (view != null) {
            removeView(view);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public int getDuration() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-283407263")) {
            return this.mPlayer.getDuration();
        }
        return ((Integer) ipChange.ipc$dispatch("-283407263", new Object[]{this})).intValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public VideoInfo getPlayInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1923803000")) {
            return this.mInfo;
        }
        return (VideoInfo) ipChange.ipc$dispatch("-1923803000", new Object[]{this});
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public String getSessionId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2049854313")) {
            return this.mPlayer.getSessionId();
        }
        return (String) ipChange.ipc$dispatch("2049854313", new Object[]{this});
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void idle(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22797584")) {
            ipChange.ipc$dispatch("-22797584", new Object[]{this, videoInfo});
            return;
        }
        this.mUiFacade.g(videoInfo);
        this.mPlayer.pause();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isMute() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-295337965")) {
            return this.isMute;
        }
        return ((Boolean) ipChange.ipc$dispatch("-295337965", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPaused() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-629449698")) {
            return this.mPlayer.isPaused();
        }
        return ((Boolean) ipChange.ipc$dispatch("-629449698", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPlaying() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-81021352")) {
            return this.mPlayer.isStarted();
        }
        return ((Boolean) ipChange.ipc$dispatch("-81021352", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void mute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1940315621")) {
            ipChange.ipc$dispatch("-1940315621", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isMute = z;
        this.mPlayer.setMuted(z);
        this.mUiFacade.c(z);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1533728702")) {
            ipChange.ipc$dispatch("-1533728702", new Object[]{this});
            return;
        }
        this.mPlayer.pause();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void play(VideoInfo videoInfo) {
        PlayParam playVideoInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1441237904")) {
            ipChange.ipc$dispatch("1441237904", new Object[]{this, videoInfo});
        } else if (videoInfo != null && (playVideoInfo = videoInfo.toPlayVideoInfo()) != null) {
            this.mInfo = videoInfo;
            this.mUiFacade.g(videoInfo);
            this.mPlayer.playVideo(playVideoInfo);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138508241")) {
            ipChange.ipc$dispatch("2138508241", new Object[]{this});
            return;
        }
        this.mPlayer.release();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void setListener(VideoListener videoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655554890")) {
            ipChange.ipc$dispatch("-1655554890", new Object[]{this, videoListener});
            return;
        }
        this.mVideoListener = videoListener;
        this.mMainEventDispatcher.j(videoListener);
        this.mUiFacade.b(this.mVideoListener);
    }

    public void setUiFacade(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486930798")) {
            ipChange.ipc$dispatch("-486930798", new Object[]{this, aVar});
            return;
        }
        this.mUiFacade.l(aVar);
        removeDecorView();
        View a = this.mUiFacade.a();
        if (a != null) {
            if (a.getParent() instanceof ViewGroup) {
                ((ViewGroup) a.getParent()).removeView(a);
            }
            a.setId(R$id.id_video_decor);
            addView(a, -1, -1);
        }
        this.mUiFacade.c(this.isMute);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490623914")) {
            ipChange.ipc$dispatch("-1490623914", new Object[]{this});
            return;
        }
        this.mPlayer.start();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1211638096")) {
            ipChange.ipc$dispatch("1211638096", new Object[]{this});
            return;
        }
        this.mPlayer.stop();
    }

    public VideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUiFacade = new bj1(this);
        IYoukuPlayer create = YoukuPlayer.create(xs0.a(), new as().a(), null);
        this.mPlayer = create;
        create.setWaterMarkImageView(new fs(context));
        MainThreadVideoListener mainThreadVideoListener = new MainThreadVideoListener(this, this.mUiFacade);
        this.mMainEventDispatcher = mainThreadVideoListener;
        this.mPlayer.addPlayerEventListener(mainThreadVideoListener);
        addView(this.mPlayer.getView(), -1, -1);
        mute(true);
    }
}
