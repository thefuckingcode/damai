package cn.damai.player.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.NetStateReceiver;
import cn.damai.player.video.decor.HomeVideoUiFacade;
import cn.damai.player.video.listener.VideoListener;
import cn.damai.player.video.opt.PlayOptHelper;
import cn.damai.player.video.view.ApiPlayer;
import cn.damai.player.video.view.FadeVideoView;
import cn.damai.player.video.view.VideoView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gj1;
import tb.qh1;
import tb.xs0;

/* compiled from: Taobao */
public class ProxyVideoView extends FrameLayout implements ApiPlayer, Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int POST_DELAY = 200;
    private boolean isAttachedToWindow;
    private boolean isSetRealVideoPlayer;
    private ApiPlayer mApiPlayer;
    private VideoInfo mCurrentInfo;
    private Handler mHandler;
    private NetStateReceiver.OnNetStateChangeListener mListener;
    private PlayOptHelper mOptHelper;
    private VideoInfo mTarget;
    private VideoListener mVideoListener;

    /* compiled from: Taobao */
    public class a implements NetStateReceiver.OnNetStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.player.video.NetStateReceiver.OnNetStateChangeListener
        public void onNetWorkChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "89812374")) {
                ipChange.ipc$dispatch("89812374", new Object[]{this});
            } else if (ProxyVideoView.this.isPlaying()) {
                ToastUtil.a().e(xs0.a(), "当前处于非WIFI环境");
            }
        }
    }

    public ProxyVideoView(@NonNull Context context) {
        this(context, null);
    }

    private void ensureAddRealPlayerOnce() {
        Context context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707739175")) {
            ipChange.ipc$dispatch("-707739175", new Object[]{this});
        } else if (!this.isSetRealVideoPlayer && (context = getContext()) != null) {
            this.isSetRealVideoPlayer = true;
            removeAllViews();
            VideoView videoView = new VideoView(context);
            this.mApiPlayer = videoView;
            videoView.setUiFacade(new HomeVideoUiFacade(videoView));
            videoView.setListener(this.mVideoListener);
            addView(videoView, -1, -2);
        }
    }

    private boolean isConditionSupportPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1452432544")) {
            return ((Boolean) ipChange.ipc$dispatch("1452432544", new Object[]{this})).booleanValue();
        } else if (this.mCurrentInfo == null || !this.isAttachedToWindow || !qh1.a(xs0.a()) || !this.mOptHelper.isOutConditionSupportPlay()) {
            return false;
        } else {
            return true;
        }
    }

    private void removeRunnable(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845122379")) {
            ipChange.ipc$dispatch("1845122379", new Object[]{this, runnable});
            return;
        }
        this.mHandler.removeCallbacks(runnable);
    }

    private void runnablePost(Runnable runnable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276920204")) {
            ipChange.ipc$dispatch("-1276920204", new Object[]{this, runnable, Integer.valueOf(i)});
            return;
        }
        this.mHandler.postDelayed(runnable, (long) i);
    }

    public void autoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503346421")) {
            ipChange.ipc$dispatch("-1503346421", new Object[]{this});
            return;
        }
        removeRunnable(this);
        runnablePost(this, 200);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public int getDuration() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-100751483")) {
            return this.mApiPlayer.getDuration();
        }
        return ((Integer) ipChange.ipc$dispatch("-100751483", new Object[]{this})).intValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public VideoInfo getPlayInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1884279524")) {
            return this.mApiPlayer.getPlayInfo();
        }
        return (VideoInfo) ipChange.ipc$dispatch("1884279524", new Object[]{this});
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public String getSessionId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1768528499")) {
            return this.mApiPlayer.getSessionId();
        }
        return (String) ipChange.ipc$dispatch("-1768528499", new Object[]{this});
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void idle(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036388428")) {
            ipChange.ipc$dispatch("2036388428", new Object[]{this, videoInfo});
            return;
        }
        this.mApiPlayer.idle(videoInfo);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isMute() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1388248687")) {
            return this.mApiPlayer.isMute();
        }
        return ((Boolean) ipChange.ipc$dispatch("1388248687", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPaused() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1905347718")) {
            return this.mApiPlayer.isPaused();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1905347718", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPlaying() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-979154308")) {
            return this.mApiPlayer.isPlaying();
        }
        return ((Boolean) ipChange.ipc$dispatch("-979154308", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void mute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639080385")) {
            ipChange.ipc$dispatch("-639080385", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mApiPlayer.mute(z);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623459168")) {
            ipChange.ipc$dispatch("623459168", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        autoPlay();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234254467")) {
            ipChange.ipc$dispatch("1234254467", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        this.mTarget = null;
        this.mApiPlayer.pause();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-232493466")) {
            ipChange.ipc$dispatch("-232493466", new Object[]{this});
            return;
        }
        removeRunnable(this);
        this.mApiPlayer.pause();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void play(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794543380")) {
            ipChange.ipc$dispatch("-794543380", new Object[]{this, videoInfo});
            return;
        }
        removeRunnable(this);
        this.mCurrentInfo = videoInfo;
        this.mTarget = null;
        this.mApiPlayer.idle(videoInfo);
        if (qh1.a(xs0.a())) {
            run();
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1504880395")) {
            ipChange.ipc$dispatch("-1504880395", new Object[]{this});
            return;
        }
        removeRunnable(this);
        this.mApiPlayer.release();
        NetStateReceiver.b().d(this.mListener);
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894626959")) {
            ipChange.ipc$dispatch("-894626959", new Object[]{this});
        } else if (isConditionSupportPlay()) {
            ensureAddRealPlayerOnce();
            if (this.mTarget == null) {
                VideoInfo videoInfo = this.mCurrentInfo;
                this.mTarget = videoInfo;
                this.mApiPlayer.play(videoInfo);
                return;
            }
            boolean isPaused = this.mApiPlayer.isPaused();
            boolean isPlaying = this.mApiPlayer.isPlaying();
            if (isPaused || isPlaying) {
                this.mApiPlayer.start();
                return;
            }
            VideoInfo videoInfo2 = this.mCurrentInfo;
            this.mTarget = videoInfo2;
            this.mApiPlayer.play(videoInfo2);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void setListener(VideoListener videoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2049669338")) {
            ipChange.ipc$dispatch("2049669338", new Object[]{this, videoListener});
            return;
        }
        this.mVideoListener = videoListener;
        this.mApiPlayer.setListener(videoListener);
    }

    public void setOptHelper(PlayOptHelper playOptHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1981091512")) {
            ipChange.ipc$dispatch("-1981091512", new Object[]{this, playOptHelper});
        } else if (playOptHelper != null) {
            this.mOptHelper = playOptHelper;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334138823")) {
            ipChange.ipc$dispatch("-334138823", new Object[]{this, videoInfo});
            return;
        }
        this.mCurrentInfo = videoInfo;
        this.mTarget = null;
        idle(videoInfo);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189388678")) {
            ipChange.ipc$dispatch("-189388678", new Object[]{this});
            return;
        }
        run();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1101691220")) {
            ipChange.ipc$dispatch("-1101691220", new Object[]{this});
            return;
        }
        removeRunnable(this);
        this.mApiPlayer.stop();
    }

    public ProxyVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProxyVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSetRealVideoPlayer = false;
        this.mOptHelper = new gj1();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mListener = new a();
        FadeVideoView fadeVideoView = new FadeVideoView(context);
        this.mApiPlayer = fadeVideoView;
        addView(fadeVideoView, -1, -2);
        NetStateReceiver.b().c(this.mListener);
    }
}
