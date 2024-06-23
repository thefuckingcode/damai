package com.youku.live.dago.liveplayback.widget.plugins.hbr;

import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.view.ViewGroup;
import com.airbnb.lottie.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.OnChangeVideoListener;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.android.liveservice.bean.Quality;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import com.youku.kubus.ThreadMode;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipManager;
import com.youku.live.dago.liveplayback.widget.utils.HbrUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
public class HBRPlugin extends AbsPlugin implements HBRContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "HBRPlugin";
    private static final int mChangeTimeout = 15000;
    private int mFromQuality = -1;
    private Handler mHandler;
    private boolean mIsFromDolby = false;
    private IPlayer mPlayer;
    private IAlixPlayer.State mState;
    private Runnable mTimeoutRunnable = new Runnable() {
        /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1652646350")) {
                ipChange.ipc$dispatch("1652646350", new Object[]{this});
            } else if (HBRPlugin.this.mView != null && HBRPlugin.this.mView.isInflated()) {
                HBRPlugin.this.mView.hide();
            }
        }
    };
    private HBRPluginView mView;
    private YoukuVideoInfo mYoukuVideoInfo;

    public HBRPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        HBRPluginView hBRPluginView = new HBRPluginView(alixPlayerContext, alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId, R.layout.dago_frame_plugin_view, alixPlayerContext.getPluginManager(viewGroup).getViewPlaceholder(this.mName));
        this.mView = hBRPluginView;
        hBRPluginView.setPresenter((HBRContract.Presenter) this);
        this.mAttachToParent = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new OnVideoStreamListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1929501787")) {
                    ipChange.ipc$dispatch("-1929501787", new Object[]{this, videoRequestError});
                    return;
                }
                HBRPlugin.this.handleChangeCancelEvent();
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1059303452")) {
                    ipChange.ipc$dispatch("-1059303452", new Object[]{this, youkuVideoInfo});
                    return;
                }
                HBRPlugin.this.mYoukuVideoInfo = youkuVideoInfo;
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1322578205")) {
                    ipChange.ipc$dispatch("1322578205", new Object[]{this, playVideoInfo});
                }
            }
        });
        alixPlayerContext.getPlayerContainer().addChangeVideoListener(new OnChangeVideoListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideo(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "146488011")) {
                    ipChange.ipc$dispatch("146488011", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideoFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "623761084")) {
                    ipChange.ipc$dispatch("623761084", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                    HBRPlugin.this.handleChangeQualitySuccess();
                }
            }
        });
        IPlayer player = alixPlayerContext.getPlayerContainer().getPlayer();
        this.mPlayer = player;
        player.addOnPlayerStateListener(new OnStateChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2103433552")) {
                    ipChange.ipc$dispatch("2103433552", new Object[]{this, state, state2});
                    return;
                }
                HBRPlugin.this.mState = state2;
                if (HBRPlugin.this.mState == IAlixPlayer.State.STATE_RELEASED) {
                    if (!HBRPlugin.this.mIsFromDolby) {
                        HBRPlugin.this.handleChangeCancelEvent();
                    }
                    HBRPlugin.this.mIsFromDolby = false;
                    HBRPlugin.this.handleActivityDestroy();
                } else if (HBRPlugin.this.mState == IAlixPlayer.State.STATE_ERROR) {
                    HBRPlugin.this.handleChangeCancelEvent();
                    HBRPlugin.this.mIsFromDolby = false;
                } else if (HBRPlugin.this.mState == IAlixPlayer.State.STATE_VIDEO_STARTED && HBRPlugin.this.mPlayer != null && HBRPlugin.this.mPlayer.getVideoStream() != null && HBRPlugin.this.mPlayer.getVideoStream().getCurAlixVideoItem() != null && HBRPlugin.this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality() != HBRPlugin.this.mFromQuality) {
                    HBRPlugin.this.handleChangeQualitySuccess();
                }
            }
        });
        this.mPlayerContext.getEventBus().register(this);
        this.mView.hide();
        checkState();
        try {
            b.s(alixPlayerContext.getContext(), HBRPluginView.HBR_CHANGING_LOTTIE);
        } catch (Exception unused) {
        }
    }

    private void checkState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831813797")) {
            ipChange.ipc$dispatch("-1831813797", new Object[]{this});
        } else if (this.mPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mYoukuVideoInfo = this.mPlayer.getVideoStream().getYoukuVideoInfo();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleActivityDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557112413")) {
            ipChange.ipc$dispatch("-557112413", new Object[]{this});
            return;
        }
        HBRPluginView hBRPluginView = this.mView;
        if (hBRPluginView != null) {
            hBRPluginView.handleHBRDestroy();
        }
        HBRPluginView hBRPluginView2 = this.mView;
        if (hBRPluginView2 != null && hBRPluginView2.isInflated()) {
            this.mView.hide();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleChangeCancelEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515231422")) {
            ipChange.ipc$dispatch("515231422", new Object[]{this});
            return;
        }
        removeRunnable(this.mTimeoutRunnable);
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "473565320")) {
                    ipChange.ipc$dispatch("473565320", new Object[]{this});
                    return;
                }
                if (HBRPlugin.this.mView != null) {
                    HBRPlugin.this.mView.handleHBRCancel();
                }
                if (HBRPlugin.this.mView != null && HBRPlugin.this.mView.isInflated()) {
                    HBRPlugin.this.mView.hide();
                }
            }
        });
    }

    private void handleChangeFinishedEvent(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1725825794")) {
            ipChange.ipc$dispatch("-1725825794", new Object[]{this, event});
            return;
        }
        removeRunnable(this.mTimeoutRunnable);
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "670078825")) {
                    ipChange.ipc$dispatch("670078825", new Object[]{this});
                } else if (HBRPlugin.this.mView != null) {
                    HBRPlugin.this.mView.handleHBRChanged();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleChangeQualitySuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1224188216")) {
            ipChange.ipc$dispatch("-1224188216", new Object[]{this});
            return;
        }
        if (HbrUtil.isVideoHbr(this.mYoukuVideoInfo, this.mPlayerContext.getPlayerContainer().getPlayer().getVideoStream().getCurAlixVideoItem().getLiveQuality())) {
            handleChangeFinishedEvent(null);
        } else {
            this.mHandler.post(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "866592330")) {
                        ipChange.ipc$dispatch("866592330", new Object[]{this});
                    } else if (HBRPlugin.this.mView != null && HBRPlugin.this.mView.isInflated()) {
                        HBRPlugin.this.mView.hide();
                    }
                }
            });
        }
    }

    private void handleChangingEvent(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2014532787")) {
            ipChange.ipc$dispatch("2014532787", new Object[]{this, event});
            return;
        }
        this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.HIDE_CONTROL));
        Utils.hideTopTips(this.mPlayerContext);
        HBRPluginView hBRPluginView = this.mView;
        if (hBRPluginView != null) {
            if (!hBRPluginView.isInflated()) {
                this.mView.inflate();
            }
            this.mView.show();
            this.mView.handleStartHBRChanging();
            runDelay(this.mTimeoutRunnable, 15000);
        }
    }

    private void handleCloseHBREvent(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-638313184")) {
            ipChange.ipc$dispatch("-638313184", new Object[]{this, event});
            return;
        }
        PlayVideoInfo playVideoInfo = this.mPlayerContext.getPlayerContainer().getPlayVideoInfo();
        playVideoInfo.setRequestLiveQuality(this.mFromQuality);
        this.mPlayerContext.getPlayerContainer().play(playVideoInfo);
    }

    private void handleOpenHBREvent(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1320331460")) {
            ipChange.ipc$dispatch("1320331460", new Object[]{this, event});
            return;
        }
        AlixPlayerContext alixPlayerContext = this.mPlayerContext;
        if (alixPlayerContext != null && alixPlayerContext.getPlayerContainer() != null && this.mPlayerContext.getPlayerContainer().getVideoStream() != null && HbrUtil.hasHbr(this.mYoukuVideoInfo)) {
            this.mIsFromDolby = false;
            this.mFromQuality = this.mPlayerContext.getPlayerContainer().getPlayer().getVideoStream().getCurAlixVideoItem().getLiveQuality();
            handleChangingEvent(null);
        }
    }

    private void jumpHBRPay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934557360")) {
            ipChange.ipc$dispatch("-934557360", new Object[]{this, str});
        }
    }

    private void removeRunnable(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51823233")) {
            ipChange.ipc$dispatch("51823233", new Object[]{this, runnable});
            return;
        }
        this.mHandler.removeCallbacks(runnable);
    }

    private void runDelay(Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485743130")) {
            ipChange.ipc$dispatch("485743130", new Object[]{this, runnable, Long.valueOf(j)});
            return;
        }
        this.mHandler.postDelayed(runnable, j);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendQualityTipChangeEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019521664")) {
            ipChange.ipc$dispatch("-1019521664", new Object[]{this});
            return;
        }
        Event event = new Event(ApiConstants.EventType.ON_QUALITY_TIP_VISIBILITY_CHANGE);
        HashMap hashMap = new HashMap();
        hashMap.put("visible", Boolean.FALSE);
        event.data = hashMap;
        this.mPlayerContext.getEventBus().postSticky(event);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r0.equals(com.youku.live.dago.liveplayback.ApiConstants.EventType.HBR_QUALITY_CHANGE_CANCEL) == false) goto L_0x0027;
     */
    @Subscribe(eventType = {ApiConstants.EventType.REQUEST_OPEN_HBR, ApiConstants.EventType.REQUEST_CLOSE_HBR, ApiConstants.EventType.HBR_QUALITY_CHANGING, ApiConstants.EventType.HBR_QUALITY_CHANGE_FINISHED, ApiConstants.EventType.HBR_QUALITY_CHANGE_CANCEL}, priority = 1, threadMode = ThreadMode.MAIN)
    public void dispatchEvent(Event event) {
        IpChange ipChange = $ipChange;
        char c = 1;
        if (AndroidInstantRuntime.support(ipChange, "-227318386")) {
            ipChange.ipc$dispatch("-227318386", new Object[]{this, event});
        } else if (event != null) {
            String str = event.type;
            str.hashCode();
            switch (str.hashCode()) {
                case -974997404:
                    if (str.equals(ApiConstants.EventType.HBR_QUALITY_CHANGE_FINISHED)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -635077908:
                    break;
                case -178117789:
                    if (str.equals(ApiConstants.EventType.REQUEST_OPEN_HBR)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1040152529:
                    if (str.equals(ApiConstants.EventType.REQUEST_CLOSE_HBR)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1131084895:
                    if (str.equals(ApiConstants.EventType.HBR_QUALITY_CHANGING)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    handleChangeFinishedEvent(event);
                    return;
                case 1:
                    handleChangeCancelEvent();
                    this.mIsFromDolby = false;
                    return;
                case 2:
                    handleOpenHBREvent(event);
                    return;
                case 3:
                    handleCloseHBREvent(event);
                    return;
                case 4:
                    handleChangingEvent(event);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void doClickHdrInstructionClose() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193419423")) {
            ipChange.ipc$dispatch("-193419423", new Object[]{this});
        } else if (this.mState != IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mPlayerContext.getPlayerContainer().getPlayer().start();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void hideQualityView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631784188")) {
            ipChange.ipc$dispatch("-631784188", new Object[]{this});
            return;
        }
        this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.REQUEST_QUALITY_VIEW_HIDE));
    }

    @Subscribe(eventType = {ApiConstants.EventType.REQUEST_IS_CHANGING_HBR}, priority = 1, threadMode = ThreadMode.MAIN)
    public void isHBRChanging(Event event) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1987144887")) {
            ipChange.ipc$dispatch("-1987144887", new Object[]{this, event});
            return;
        }
        EventBus eventBus = this.mPlayerContext.getEventBus();
        HBRPluginView hBRPluginView = this.mView;
        if (hBRPluginView == null || !hBRPluginView.isShow()) {
            z = false;
        }
        eventBus.response(event, Boolean.valueOf(z));
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_HBR_INSTRUCTION}, priority = 1, threadMode = ThreadMode.MAIN)
    public void onShowHbrInstruction(Event event) {
        Map map;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829605602")) {
            ipChange.ipc$dispatch("1829605602", new Object[]{this, event});
            return;
        }
        if (this.mState == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.AnonymousClass8 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "277051815")) {
                        ipChange.ipc$dispatch("277051815", new Object[]{this});
                        return;
                    }
                    ((AbsPlugin) HBRPlugin.this).mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.HIDE_CONTROL));
                }
            }, 500);
        }
        Object obj = event.data;
        String str = (obj == null || (map = (Map) obj) == null) ? "" : (String) map.get("source_from");
        HBRPluginView hBRPluginView = this.mView;
        if (hBRPluginView != null) {
            hBRPluginView.inflate();
            if (this.mView != null) {
                AlixPlayerContext alixPlayerContext = this.mPlayerContext;
                if (alixPlayerContext == null || alixPlayerContext.getPlayerContainer() == null || this.mPlayerContext.getPlayerContainer().getVideoStream() == null) {
                    this.mView.showShowHBRIntroduction();
                    return;
                }
                boolean hasHbr = HbrUtil.hasHbr(this.mPlayerContext.getPlayerContainer().getVideoStream().getYoukuVideoInfo());
                this.mView.showShowHBRIntroduction(hasHbr, hasHbr, false, str);
            }
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void openHBR() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845715432")) {
            ipChange.ipc$dispatch("-845715432", new Object[]{this});
        } else if (HbrUtil.hasHbr(this.mYoukuVideoInfo) && !HbrUtil.isVideoHbr(this.mYoukuVideoInfo, this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality())) {
            this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.REQUEST_OPEN_HBR));
            PlayVideoInfo playVideoInfo = this.mPlayerContext.getPlayerContainer().getPlayVideoInfo();
            int i = -1;
            Iterator<Quality> it = this.mYoukuVideoInfo.getLivePlayControl().qualities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Quality next = it.next();
                if (next.hbr == 1) {
                    i = next.quality;
                    break;
                }
            }
            playVideoInfo.setRequestLiveQuality(i);
            this.mPlayerContext.getPlayerContainer().play(playVideoInfo);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void setOrientation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1698464864")) {
            ipChange.ipc$dispatch("1698464864", new Object[]{this, str});
            return;
        }
        this.mPlayerContext.getEventBus().post(new Event(str));
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract.Presenter
    public void showHBRChangedTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1373629645")) {
            ipChange.ipc$dispatch("-1373629645", new Object[]{this});
            return;
        }
        Utils.showVipTopTips(this.mPlayerContext, TopTipManager.TipName.CHANGE_QUALITY_TIP_PLUGIN, Html.fromHtml("<font color=#F7C3A7>" + "已为您开启VIP专属的帧享视听体验，请确保当前网络环境良好" + "</font>"), 52, -1, 3000, false, null, new TopTipInfo.DismissCallback() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo.DismissCallback
            public void onDismiss() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2122211162")) {
                    ipChange.ipc$dispatch("-2122211162", new Object[]{this});
                    return;
                }
                HBRPlugin.this.sendQualityTipChangeEvent();
            }
        });
    }
}
