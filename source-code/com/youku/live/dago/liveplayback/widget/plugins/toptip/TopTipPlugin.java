package com.youku.live.dago.liveplayback.widget.plugins.toptip;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.alixplugin.view.OnInflateListener;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.kubus.ThreadMode;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.KubusUtils;
import com.youku.live.dago.liveplayback.YoukuUtil;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipContract;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo;
import java.util.HashMap;

/* compiled from: Taobao */
public class TopTipPlugin extends AbsPlugin implements OnInflateListener, TopTipContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "TopTipPlugin";
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsEnableTipTop = true;
    private IPlayerContainer mPlayer;
    private TopTipInfo mShowingInfo = null;
    private TopTipInfo mStickyInfo = null;
    private TopTipView mView;

    public TopTipPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mView = new TopTipView(alixPlayerContext, alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), pluginConfig.getLayerId(), alixPlayerContext.getPluginManager(viewGroup).getViewPlaceholder(this.mName));
        this.mAttachToParent = true;
        this.mPlayer = alixPlayerContext.getPlayerContainer();
        this.mView.enableTipBg(!isFeedOrSmallVideoMode());
        this.mView.setPresenter((TopTipContract.Presenter) this);
        this.mView.setOnInflateListener(this);
        this.mActivity = alixPlayerContext.getActivity();
        this.mPlayer.addVideoStreamListener(new OnVideoStreamListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipPlugin.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1860624430")) {
                    ipChange.ipc$dispatch("-1860624430", new Object[]{this, videoRequestError});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1309510831")) {
                    ipChange.ipc$dispatch("-1309510831", new Object[]{this, youkuVideoInfo});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1072370826")) {
                    ipChange.ipc$dispatch("1072370826", new Object[]{this, playVideoInfo});
                    return;
                }
                TopTipPlugin.this.mHandler.post(new Runnable() {
                    /* class com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipPlugin.AnonymousClass1.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1894136051")) {
                            ipChange.ipc$dispatch("1894136051", new Object[]{this});
                            return;
                        }
                        TopTipPlugin.this.onNewRequest();
                    }
                });
            }
        });
        this.mPlayer.getPlayer().addOnPlayerStateListener(new OnStateChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipPlugin.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1525447260")) {
                    ipChange.ipc$dispatch("-1525447260", new Object[]{this, state, state2});
                } else if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    TopTipPlugin.this.onRealVideoStart();
                } else if (state2 == IAlixPlayer.State.STATE_RELEASED) {
                    TopTipPlugin.this.onRelease();
                }
            }
        });
        alixPlayerContext.getEventBus().register(this);
    }

    private boolean isFeedOrSmallVideoMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1177467156")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1177467156", new Object[]{this})).booleanValue();
    }

    private boolean isPlayer3gDataTipShowing() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1251090909")) {
            return KubusUtils.requestBoolean(this.mPlayerContext, ApiConstants.EventType.IS_PLAYER_3G_DATA_TIP_SHOWING);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1251090909", new Object[]{this})).booleanValue();
    }

    private boolean isShowingChangeQualityTip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-801422955")) {
            return KubusUtils.requestBoolean(this.mPlayerContext, ApiConstants.EventType.IS_CHANGE_QUALITY_TIP_SHOWING);
        }
        return ((Boolean) ipChange.ipc$dispatch("-801422955", new Object[]{this})).booleanValue();
    }

    private boolean isShowingPlayNextTip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1599266147")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1599266147", new Object[]{this})).booleanValue();
    }

    private boolean isShowingProtectEyesTip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-888108361")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-888108361", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onNewRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "422105092")) {
            ipChange.ipc$dispatch("422105092", new Object[]{this});
            return;
        }
        this.mIsEnableTipTop = false;
        this.mHandler.removeCallbacksAndMessages(null);
        this.mView.hideTopTip();
        this.mShowingInfo = null;
        this.mStickyInfo = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onRealVideoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2029121838")) {
            ipChange.ipc$dispatch("2029121838", new Object[]{this});
            return;
        }
        this.mIsEnableTipTop = true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "818643728")) {
            ipChange.ipc$dispatch("818643728", new Object[]{this});
            return;
        }
        this.mIsEnableTipTop = false;
        this.mHandler.removeCallbacksAndMessages(null);
        this.mView.hideTopTip();
        this.mShowingInfo = null;
        this.mStickyInfo = null;
    }

    private void onShowTopTip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964077852")) {
            ipChange.ipc$dispatch("-1964077852", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mShowingInfo != null && !isPlayer3gDataTipShowing()) {
            if (z && !TopTipManager.canShowWhenControlBarVisible(this.mShowingInfo.tipType)) {
                this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.HIDE_CONTROL));
            }
            this.mView.showTopTip(this.mShowingInfo);
            TopTipInfo topTipInfo = this.mShowingInfo;
            if (topTipInfo.isSticky) {
                this.mStickyInfo = topTipInfo;
            }
            topTipInfo.lastShowTime = System.currentTimeMillis();
            this.mShowingInfo.showCount++;
            this.mHandler.removeCallbacksAndMessages(null);
            Handler handler = this.mHandler;
            AnonymousClass3 r0 = new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipPlugin.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-88853602")) {
                        ipChange.ipc$dispatch("-88853602", new Object[]{this});
                        return;
                    }
                    TopTipPlugin.this.mView.hideTopTip();
                    TopTipManager.recordHasShown(((AbsPlugin) TopTipPlugin.this).mPlayerContext, TopTipPlugin.this.mShowingInfo);
                    if (!(TopTipPlugin.this.mShowingInfo == null || TopTipPlugin.this.mShowingInfo.dismissCallback == null)) {
                        TopTipPlugin.this.mShowingInfo.dismissCallback.onDismiss();
                    }
                    TopTipPlugin.this.mShowingInfo = null;
                }
            };
            int i = this.mShowingInfo.time;
            handler.postDelayed(r0, i > 0 ? (long) i : 3000);
        }
    }

    private boolean showToast(TopTipInfo topTipInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966892825")) {
            return ((Boolean) ipChange.ipc$dispatch("-966892825", new Object[]{this, topTipInfo})).booleanValue();
        } else if (topTipInfo.tipType != 1001) {
            return false;
        } else {
            YoukuUtil.showTipsForKanDan(this.mContext, topTipInfo.text.toString());
            return true;
        }
    }

    public TopTipInfo getShowingInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1524732662")) {
            return this.mShowingInfo;
        }
        return (TopTipInfo) ipChange.ipc$dispatch("1524732662", new Object[]{this});
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipContract.Presenter
    public boolean isSmallScreen() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1853072979")) {
            return !this.mPlayerContext.isLandScreen();
        }
        return ((Boolean) ipChange.ipc$dispatch("1853072979", new Object[]{this})).booleanValue();
    }

    @Subscribe(eventType = {ApiConstants.EventType.REQUEST_IS_TOP_TIP_SHOWING}, priority = 1, threadMode = ThreadMode.POSTING)
    public void isTopTipShowing(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525008687")) {
            ipChange.ipc$dispatch("-1525008687", new Object[]{this, event});
            return;
        }
        Object obj = event.data;
        if (obj != null) {
            TopTipInfo topTipInfo = this.mShowingInfo;
            if (topTipInfo == null || !topTipInfo.text.equals(obj)) {
                this.mPlayerContext.getEventBus().response(event, Boolean.FALSE);
            } else {
                this.mPlayerContext.getEventBus().response(event, Boolean.TRUE);
            }
        } else {
            this.mPlayerContext.getEventBus().response(event, Boolean.valueOf(this.mView.isShow()));
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.ON_CONTROL_VISIBILITY_CHANGE}, priority = 1, threadMode = ThreadMode.MAIN)
    public void onControlVisibilityChange(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300230652")) {
            ipChange.ipc$dispatch("1300230652", new Object[]{this, event});
        }
    }

    @Override // com.youku.alixplugin.view.OnInflateListener
    public void onInflate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743368432")) {
            ipChange.ipc$dispatch("-743368432", new Object[]{this});
            return;
        }
        this.mHolderView = this.mView.getInflatedView();
    }

    @Subscribe(eventType = {ApiConstants.EventType.ON_SCREEN_MODE_CHANGE}, priority = 1, threadMode = ThreadMode.MAIN)
    public void onScreenModeChange(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577643552")) {
            ipChange.ipc$dispatch("1577643552", new Object[]{this, event});
            return;
        }
        Integer num = (Integer) event.data;
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 0) {
                this.mView.setLayout(true);
            } else if (intValue == 1) {
                this.mView.setLayout(false);
            }
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.REQUEST_TOP_TIP_HIDE}, priority = 1, threadMode = ThreadMode.MAIN)
    public void onTopTipHide(Event event) {
        TopTipInfo.DismissCallback dismissCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1455494921")) {
            ipChange.ipc$dispatch("1455494921", new Object[]{this, event});
            return;
        }
        this.mView.hideTopTipQuickly();
        TopTipManager.recordHasShown(this.mPlayerContext, this.mShowingInfo);
        TopTipInfo topTipInfo = this.mShowingInfo;
        if (!(topTipInfo == null || (dismissCallback = topTipInfo.dismissCallback) == null)) {
            dismissCallback.onDismiss();
        }
        this.mShowingInfo = null;
        this.mStickyInfo = null;
    }

    @Subscribe(eventType = {ApiConstants.EventType.REQUEST_TOP_TIP_SHOW}, priority = 1000, threadMode = ThreadMode.MAIN)
    public void onTopTipShow(Event event) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1786048252")) {
            ipChange.ipc$dispatch("-1786048252", new Object[]{this, event});
            return;
        }
        TopTipInfo topTipInfo = (TopTipInfo) ((HashMap) event.data).get("object");
        if (topTipInfo != null) {
            boolean z2 = !this.mIsEnableTipTop;
            if (!z2 || !topTipInfo.isNextSticky) {
                z = z2;
            }
            if (!z) {
                topTipInfo.level = TopTipManager.getTipLevel(topTipInfo.tipName);
                if (topTipInfo.style != 6) {
                    TopTipManager.customTopTip(topTipInfo, this.mPlayerContext.getContext());
                }
                if (TopTipManager.canShowTopTip(this.mPlayerContext, topTipInfo) && !showToast(topTipInfo)) {
                    TopTipInfo topTipInfo2 = this.mShowingInfo;
                    if (topTipInfo2 == null || topTipInfo2.level <= topTipInfo.level) {
                        this.mShowingInfo = topTipInfo;
                        onShowTopTip(true);
                    }
                }
            }
        }
    }
}
