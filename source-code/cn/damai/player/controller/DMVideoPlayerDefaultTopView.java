package cn.damai.player.controller;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import cn.damai.message.observer.Action;
import cn.damai.player.base.IVideoController;
import cn.damai.player.base.IVideoPlayer;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.videoplayer.R$id;
import cn.damai.videoplayer.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import tb.br;
import tb.bs;
import tb.cs;

/* compiled from: Taobao */
public class DMVideoPlayerDefaultTopView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private br dmMessage;
    private FragmentActivity mActivity;
    private IVideoController mController;
    private bs mDataHolder = cs.d().c();
    private e mHandler;
    private IVideoPlayer mPlayer;
    private DMIconFontTextView mToSmallScreen;
    private OnPlayerUTReportListener mUTReportListener;

    /* compiled from: Taobao */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "498994764")) {
                ipChange.ipc$dispatch("498994764", new Object[]{this, obj});
                return;
            }
            DMVideoPlayerDefaultTopView.this.showTopBar();
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1192096461")) {
                ipChange.ipc$dispatch("1192096461", new Object[]{this, obj});
                return;
            }
            DMVideoPlayerDefaultTopView.this.hideTopBar();
        }
    }

    /* compiled from: Taobao */
    public class c implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1885198158")) {
                ipChange.ipc$dispatch("1885198158", new Object[]{this, obj});
                return;
            }
            DMVideoPlayerDefaultTopView.this.removeMessage();
        }
    }

    /* compiled from: Taobao */
    public class d implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1716667441")) {
                ipChange.ipc$dispatch("-1716667441", new Object[]{this, obj});
                return;
            }
            DMVideoPlayerDefaultTopView.this.topBarDelayHide();
        }
    }

    /* compiled from: Taobao */
    public class e extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "586448361")) {
                ipChange.ipc$dispatch("586448361", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            DMVideoPlayerDefaultTopView.this.setVisibility(8);
        }
    }

    public DMVideoPlayerDefaultTopView(FragmentActivity fragmentActivity, IVideoPlayer iVideoPlayer) {
        super(fragmentActivity);
        this.mActivity = fragmentActivity;
        this.mPlayer = iVideoPlayer;
        initTopBar();
    }

    private void initTopBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852737069")) {
            ipChange.ipc$dispatch("-852737069", new Object[]{this});
            return;
        }
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) LayoutInflater.from(this.mActivity).inflate(R$layout.yk_player_topbar, this).findViewById(R$id.yk_player_back_btn);
        this.mToSmallScreen = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(this);
        setVisibility(8);
        this.mHandler = new e();
        registerDMMessage();
    }

    private void registerDMMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280167602")) {
            ipChange.ipc$dispatch("-1280167602", new Object[]{this});
            return;
        }
        br brVar = new br();
        this.dmMessage = brVar;
        brVar.b("topbar_show", new a());
        this.dmMessage.b("topbar_hide", new b());
        this.dmMessage.b("remove_show_message", new c());
        this.dmMessage.b("topbar_delay_hide", new d());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773502106")) {
            ipChange.ipc$dispatch("-773502106", new Object[]{this});
            return;
        }
        this.mHandler.removeMessages(1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showTopBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247357062")) {
            ipChange.ipc$dispatch("1247357062", new Object[]{this});
        } else if (this.mDataHolder.c().b()) {
            setVisibility(0);
            topBarDelayHide();
        }
    }

    private void smallScreen() {
        bs bsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841913590")) {
            ipChange.ipc$dispatch("841913590", new Object[]{this});
            return;
        }
        if (!(this.mUTReportListener == null || (bsVar = this.mDataHolder) == null || bsVar.e() == null)) {
            this.mUTReportListener.returnSmallScreen(this.mDataHolder.e().getVid());
        }
        this.mController.onScreenModeChanged(false);
        this.mPlayer.exitFullScreen();
    }

    public void hideTopBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2137777121")) {
            ipChange.ipc$dispatch("2137777121", new Object[]{this});
            return;
        }
        setVisibility(8);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1412673586")) {
            ipChange.ipc$dispatch("1412673586", new Object[]{this, view});
        } else if (view.getId() == R$id.yk_player_back_btn) {
            smallScreen();
        }
    }

    public void registerUTPlayerListener(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579626152")) {
            ipChange.ipc$dispatch("1579626152", new Object[]{this, onPlayerUTReportListener});
            return;
        }
        this.mUTReportListener = onPlayerUTReportListener;
    }

    public void setIVideoController(IVideoController iVideoController) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1082506895")) {
            ipChange.ipc$dispatch("1082506895", new Object[]{this, iVideoController});
            return;
        }
        this.mController = iVideoController;
    }

    public void setVisibilityByScreenMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122347983")) {
            ipChange.ipc$dispatch("122347983", new Object[]{this});
        } else if (this.mDataHolder.c().b()) {
            removeMessage();
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void topBarDelayHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193332802")) {
            ipChange.ipc$dispatch("193332802", new Object[]{this});
            return;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }
}
