package com.youku.live.dago.liveplayback.widget.plugins.verticalfull;

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
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.alixplugin.view.BaseView;
import com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.WeexWidget;
import com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullControlContract;
import java.util.List;

/* compiled from: Taobao */
public class VerticalFullscreenPlugin extends BaseScreenPlugin implements VerticalFullControlContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private IPlayer mPlayer;
    private IPlayerContainer mPlayerContainer;
    private IAlixPlayer.State mState;
    private VerticalFullControlView mView;

    public VerticalFullscreenPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        VerticalFullControlView verticalFullControlView = new VerticalFullControlView(alixPlayerContext.getContext(), alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId, alixPlayerContext.getPluginManager(viewGroup).getViewPlaceholder(this.mName));
        this.mView = verticalFullControlView;
        verticalFullControlView.setPresenter((VerticalFullControlContract.Presenter) this);
        this.mAttachToParent = true;
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new OnVideoStreamListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullscreenPlugin.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2025485598")) {
                    ipChange.ipc$dispatch("2025485598", new Object[]{this, videoRequestError});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-197088355")) {
                    ipChange.ipc$dispatch("-197088355", new Object[]{this, youkuVideoInfo});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2110173994")) {
                    ipChange.ipc$dispatch("-2110173994", new Object[]{this, playVideoInfo});
                    return;
                }
                ((BaseScreenPlugin) VerticalFullscreenPlugin.this).mHandler.post(new Runnable() {
                    /* class com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullscreenPlugin.AnonymousClass1.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1207860263")) {
                            ipChange.ipc$dispatch("1207860263", new Object[]{this});
                            return;
                        }
                        VerticalFullscreenPlugin.this.mView.hide();
                    }
                });
            }
        });
        IPlayerContainer playerContainer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContainer = playerContainer;
        IPlayer player = playerContainer.getPlayer();
        this.mPlayer = player;
        player.addOnCurrentPositionChangeListener(new OnCurrentPositionChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullscreenPlugin.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnCurrentPositionChangeListener
            public void onCurrentPostionChange(final int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "915063573")) {
                    ipChange.ipc$dispatch("915063573", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                ((BaseScreenPlugin) VerticalFullscreenPlugin.this).mHandler.post(new Runnable() {
                    /* class com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullscreenPlugin.AnonymousClass2.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1336942982")) {
                            ipChange.ipc$dispatch("1336942982", new Object[]{this});
                        } else if (VerticalFullscreenPlugin.this.mView.isShow()) {
                            VerticalFullscreenPlugin.this.mView.updateProgress(i);
                        }
                    }
                });
            }
        });
        this.mPlayer.addOnPlayerStateListener(new OnStateChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullscreenPlugin.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "182160695")) {
                    ipChange.ipc$dispatch("182160695", new Object[]{this, state, state2});
                    return;
                }
                VerticalFullscreenPlugin.this.mState = state2;
                if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    VerticalFullscreenPlugin.this.initShow();
                }
            }
        });
        hide();
        initShow();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2031141201")) {
            ipChange.ipc$dispatch("2031141201", new Object[]{this});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullscreenPlugin.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1510660879")) {
                    ipChange.ipc$dispatch("-1510660879", new Object[]{this});
                    return;
                }
                IAlixPlayer.State currentState = VerticalFullscreenPlugin.this.mPlayer.getCurrentState();
                if (((AbsPlugin) VerticalFullscreenPlugin.this).mPlayerContext.getPlayerContainer().getPlayVideoInfo() != null) {
                    PlayType playType = ((AbsPlugin) VerticalFullscreenPlugin.this).mPlayerContext.getPlayerContainer().getPlayVideoInfo().getPlayType();
                    if (currentState != IAlixPlayer.State.STATE_VIDEO_STARTED || playType != PlayType.VOD || ((AbsPlugin) VerticalFullscreenPlugin.this).mPlayerContext.isLandScreen() || ((AbsPlugin) VerticalFullscreenPlugin.this).mPlayerContext.isLandVideo()) {
                        VerticalFullscreenPlugin.this.mView.hide();
                    } else {
                        VerticalFullscreenPlugin.this.mView.show();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin
    public void addView(List<WeexWidget> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882862729")) {
            ipChange.ipc$dispatch("-882862729", new Object[]{this, list});
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin
    public BaseView getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1259071486")) {
            return this.mView;
        }
        return (BaseView) ipChange.ipc$dispatch("-1259071486", new Object[]{this});
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullControlContract.Presenter
    public void onControlBtnClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "661201603")) {
            ipChange.ipc$dispatch("661201603", new Object[]{this});
            return;
        }
        if (this.mState == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mPlayer.pause();
        } else {
            this.mPlayer.start();
        }
        this.mView.show();
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullControlContract.Presenter
    public void seekTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696911496")) {
            ipChange.ipc$dispatch("-696911496", new Object[]{this, Integer.valueOf(i)});
        } else if (((long) i) < this.mPlayer.getDuration()) {
            this.mPlayer.seekTo(i, 0);
        }
    }

    public void updateLayout(VerticalFullControlContract.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718950447")) {
            ipChange.ipc$dispatch("1718950447", new Object[]{this, layoutParams});
            return;
        }
        this.mView.updateLayoutParams(layoutParams);
    }
}
