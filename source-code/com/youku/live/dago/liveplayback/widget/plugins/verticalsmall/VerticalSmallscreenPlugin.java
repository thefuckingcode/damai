package com.youku.live.dago.liveplayback.widget.plugins.verticalsmall;

import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.OnDataSourceListener;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.alixplugin.view.BaseView;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import com.youku.kubus.ThreadMode;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.widget.PickStatus;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.WeexWidget;
import com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract;
import java.util.List;

/* compiled from: Taobao */
public class VerticalSmallscreenPlugin extends BaseScreenPlugin implements VerticalSmallControlContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private EventBus mEventBus;
    private OnDataSourceListener mOnDataSourceListener = new OnDataSourceListener() {
        /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass7 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.alixplugin.OnDataSourceListener
        public void onChanged(String str, Object obj, Object obj2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1280259390")) {
                ipChange.ipc$dispatch("-1280259390", new Object[]{this, str, obj, obj2});
            } else if (!"pick_status".equals(str) || !(obj2 instanceof PickStatus)) {
                if ("isPickMode".equals(str) && (obj2 instanceof Boolean)) {
                    if (((Boolean) obj2).booleanValue()) {
                        VerticalSmallscreenPlugin.this.mView.hide(false);
                    } else {
                        VerticalSmallscreenPlugin.this.mView.show(false);
                    }
                }
            } else if (obj2 == PickStatus.ROTATE_INIT || obj2 == PickStatus.ROTATE_START) {
                VerticalSmallscreenPlugin.this.mView.hide(false);
            }
        }
    };
    private IPlayer mPlayer;
    private IPlayerContainer mPlayerContainer;
    private IAlixPlayer.State mState;
    private VerticalSmallControlView mView;

    public VerticalSmallscreenPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        VerticalSmallControlView verticalSmallControlView = new VerticalSmallControlView(alixPlayerContext.getContext(), alixPlayerContext.getActivity(), alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId, alixPlayerContext.getPluginManager(viewGroup).getViewPlaceholder(this.mName));
        this.mView = verticalSmallControlView;
        verticalSmallControlView.setPresenter((VerticalSmallControlContract.Presenter) this);
        this.mAttachToParent = true;
        this.mEventBus = alixPlayerContext.getEventBus();
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new OnVideoStreamListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1868411102")) {
                    ipChange.ipc$dispatch("-1868411102", new Object[]{this, videoRequestError});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(final YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-375441759")) {
                    ipChange.ipc$dispatch("-375441759", new Object[]{this, youkuVideoInfo});
                    return;
                }
                ((BaseScreenPlugin) VerticalSmallscreenPlugin.this).mHandler.post(new Runnable() {
                    /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass1.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "187975874")) {
                            ipChange.ipc$dispatch("187975874", new Object[]{this});
                            return;
                        }
                        ((BaseScreenPlugin) VerticalSmallscreenPlugin.this).mHandler.post(new Runnable() {
                            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass1.AnonymousClass2.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1897455573")) {
                                    ipChange.ipc$dispatch("1897455573", new Object[]{this});
                                    return;
                                }
                                AnonymousClass2 r0 = AnonymousClass2.this;
                                VerticalSmallscreenPlugin.this.onGetVideoInfoSuccess(youkuVideoInfo);
                                VerticalSmallscreenPlugin.this.checkAndShow();
                            }
                        });
                    }
                });
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2006439898")) {
                    ipChange.ipc$dispatch("2006439898", new Object[]{this, playVideoInfo});
                    return;
                }
                ((BaseScreenPlugin) VerticalSmallscreenPlugin.this).mHandler.post(new Runnable() {
                    /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass1.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "384489379")) {
                            ipChange.ipc$dispatch("384489379", new Object[]{this});
                            return;
                        }
                        VerticalSmallscreenPlugin.this.mView.hide();
                    }
                });
            }
        });
        getPlayerContext().addDataSourceListener(this.mOnDataSourceListener);
        IPlayerContainer playerContainer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContainer = playerContainer;
        IPlayer player = playerContainer.getPlayer();
        this.mPlayer = player;
        player.addOnCurrentPositionChangeListener(new OnCurrentPositionChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnCurrentPositionChangeListener
            public void onCurrentPostionChange(final int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-776095855")) {
                    ipChange.ipc$dispatch("-776095855", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                ((BaseScreenPlugin) VerticalSmallscreenPlugin.this).mHandler.post(new Runnable() {
                    /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass2.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "513572098")) {
                            ipChange.ipc$dispatch("513572098", new Object[]{this});
                            return;
                        }
                        VerticalSmallscreenPlugin.this.mView.updateProgress(i);
                    }
                });
            }
        });
        this.mPlayer.addOnPlayerStateListener(new OnStateChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "412243123")) {
                    ipChange.ipc$dispatch("412243123", new Object[]{this, state, state2});
                    return;
                }
                VerticalSmallscreenPlugin.this.mState = state2;
                if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    VerticalSmallscreenPlugin.this.initShow();
                }
            }
        });
        this.mEventBus.register(this);
        initShow();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkAndShow() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-146416810")) {
            ipChange.ipc$dispatch("-146416810", new Object[]{this});
            return;
        }
        IAlixPlayer.State currentState = this.mPlayer.getCurrentState();
        if (currentState != IAlixPlayer.State.STATE_VIDEO_STARTED && currentState != IAlixPlayer.State.STATE_VIDEO_PAUSED) {
            this.mView.hide();
        } else if (!canShow()) {
            hide();
        } else {
            Object obj = this.mPlayerContext.get("isPickMode");
            if (obj != null) {
                z = ((Boolean) obj).booleanValue();
            }
            if (this.mPlayerContext.isLandScreen() || !this.mPlayerContext.isLandVideo() || this.mPlayerContext.getPlayerContainer().getPlayVideoInfo() == null || z) {
                hide();
                return;
            }
            PlayType playType = this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getPlayType();
            YoukuVideoInfo youkuVideoInfo = this.mPlayerContainer.getVideoStream().getYoukuVideoInfo();
            if (playType == PlayType.LIVE) {
                VideoInfo videoInfo = youkuVideoInfo.getLiveInfo().videoInfo;
                if (youkuVideoInfo.getLivePlayControl() == null || (videoInfo != null && videoInfo.isLaifengPk)) {
                    this.mView.hide();
                    return;
                }
            }
            onGetVideoInfoSuccess(this.mPlayerContainer.getVideoStream().getYoukuVideoInfo());
            show();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2018519723")) {
            ipChange.ipc$dispatch("-2018519723", new Object[]{this});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1643786093")) {
                    ipChange.ipc$dispatch("1643786093", new Object[]{this});
                } else if (VerticalSmallscreenPlugin.this.mPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    VerticalSmallscreenPlugin.this.checkAndShow();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onGetVideoInfoSuccess(YoukuVideoInfo youkuVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127480597")) {
            ipChange.ipc$dispatch("-2127480597", new Object[]{this, youkuVideoInfo});
            return;
        }
        LivePlayControl livePlayControl = youkuVideoInfo.getLivePlayControl();
        boolean z = youkuVideoInfo.getPlayVideoInfo().getPlayType() == PlayType.LIVE ? youkuVideoInfo.getLiveInfo().isTrail : false;
        if (!Utils.isYoukuOrHuaweiBaipai(this.mContext) || livePlayControl == null || !"1".equals(livePlayControl.playerWidget.castScreen) || z) {
            this.mView.setCastMode(false);
        } else {
            this.mHandler.post(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1447272588")) {
                        ipChange.ipc$dispatch("1447272588", new Object[]{this});
                        return;
                    }
                    VerticalSmallscreenPlugin.this.mView.setCastMode(true);
                    VerticalSmallscreenPlugin.this.mView.showDisplayButton(true);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin
    public void addView(List<WeexWidget> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1233225485")) {
            ipChange.ipc$dispatch("-1233225485", new Object[]{this, list});
            return;
        }
        this.mView.addView(list);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.Presenter, com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin
    public void addViewGroup(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498786696")) {
            ipChange.ipc$dispatch("498786696", new Object[]{this, viewGroup});
            return;
        }
        super.addViewGroup(viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin
    public BaseView getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-432985338")) {
            return this.mView;
        }
        return (BaseView) ipChange.ipc$dispatch("-432985338", new Object[]{this});
    }

    @Subscribe(eventType = {ApiConstants.EventType.HIDE_CONTROL}, priority = 1, threadMode = ThreadMode.POSTING)
    public void hidePlayControl(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "513727411")) {
            ipChange.ipc$dispatch("513727411", new Object[]{this, event});
        } else if (this.mView.isShow()) {
            hide();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.Presenter
    public void onControlBtnClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "253502527")) {
            ipChange.ipc$dispatch("253502527", new Object[]{this});
        } else if (this.mState == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mPlayer.pause();
        } else if (this.mPlayerContainer.getPlayVideoInfo().getPlayType() == PlayType.LIVE) {
            LiveInfo liveInfo = this.mPlayerContainer.getVideoStream().getYoukuVideoInfo().getLiveInfo();
            if (liveInfo == null || liveInfo.timeshift != -1) {
                this.mPlayer.start();
                return;
            }
            VerticalSmallControlView verticalSmallControlView = this.mView;
            verticalSmallControlView.dragEndForTimeShift(verticalSmallControlView.getLiveTime(), this.mView.getLiveTime(), true);
        } else {
            this.mPlayer.start();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.Presenter
    public void onDisplayBtnClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-37102342")) {
            ipChange.ipc$dispatch("-37102342", new Object[]{this});
        } else if (this.mPlayerContext.isDlnaMode()) {
            this.mEventBus.post(new Event(ApiConstants.EventType.CLOSE_DLNA_MODE));
        } else {
            this.mEventBus.post(new Event(ApiConstants.EventType.REQUEST_DLNA_SHOW_SMALL));
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.Presenter
    public void onDlnaCtrlBtnClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610325714")) {
            ipChange.ipc$dispatch("1610325714", new Object[]{this});
            return;
        }
        this.mEventBus.post(new Event(ApiConstants.EventType.TOGGLE_DLNA_PLAY_PAUSE_STATUS));
    }

    @Subscribe(eventType = {ApiConstants.EventType.DLNA_PLAYER_PAUSE}, priority = 1, threadMode = ThreadMode.MAIN)
    public void onDlnaPlayerPause(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264722695")) {
            ipChange.ipc$dispatch("1264722695", new Object[]{this, event});
        } else if (this.mPlayerContext.isDlnaMode()) {
            this.mView.onDlnaPlayerPause();
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.DLNA_PLAYER_START}, priority = 1, threadMode = ThreadMode.MAIN)
    public void onDlnaPlayerStart(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945925517")) {
            ipChange.ipc$dispatch("-945925517", new Object[]{this, event});
        } else if (this.mPlayerContext.isDlnaMode()) {
            this.mView.onDlnaPlayerStart();
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.ON_SINGLE_TAP}, priority = 1, threadMode = ThreadMode.POSTING)
    public void onSingleTap(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1079979992")) {
            ipChange.ipc$dispatch("-1079979992", new Object[]{this, event});
        } else if (this.mView.isShow()) {
            hide();
        } else {
            checkAndShow();
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.REFRESH_CONTROL_VIEW}, priority = 1, threadMode = ThreadMode.POSTING)
    public void refreshControl(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1746409836")) {
            ipChange.ipc$dispatch("-1746409836", new Object[]{this, event});
            return;
        }
        checkAndShow();
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.Presenter
    public void seekTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1520282380")) {
            ipChange.ipc$dispatch("-1520282380", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (((long) i) < this.mPlayer.getDuration()) {
            this.mPlayer.seekTo(i, 0);
        }
        hideControlDelay();
    }

    public void setLiveTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136213641")) {
            ipChange.ipc$dispatch("-2136213641", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mView.setLiveTime(j);
    }

    public void setNowTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185618653")) {
            ipChange.ipc$dispatch("-1185618653", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mView.setNowTime(j);
    }

    public void setStartTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529401233")) {
            ipChange.ipc$dispatch("-529401233", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mView.setStartTime(j);
    }

    public void setSumTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1864846440")) {
            ipChange.ipc$dispatch("-1864846440", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mView.setSumTime(j);
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_ERROR}, priority = 1, threadMode = ThreadMode.POSTING)
    public void showError(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326577303")) {
            ipChange.ipc$dispatch("326577303", new Object[]{this, event});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1250759083")) {
                    ipChange.ipc$dispatch("1250759083", new Object[]{this});
                    return;
                }
                VerticalSmallscreenPlugin.this.mView.hideControl();
            }
        });
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_CONTROL}, priority = 1, threadMode = ThreadMode.POSTING)
    public void showPlayControl(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295804120")) {
            ipChange.ipc$dispatch("1295804120", new Object[]{this, event});
            return;
        }
        checkAndShow();
    }
}
