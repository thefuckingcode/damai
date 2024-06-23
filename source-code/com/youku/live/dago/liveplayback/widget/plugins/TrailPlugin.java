package com.youku.live.dago.liveplayback.widget.plugins;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
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
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.Utils;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class TrailPlugin extends AbsPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private CountDownTimer countDownTimer;
    private LivePlayControl livePlayControl;
    private EventBus mEventBus;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsTrailLive;
    private IPlayer mPlayer;
    private IPlayerContainer mPlayerContainer;
    private LinearLayout mTrailTimeContainer;
    private String mTrailTimeKey;
    private TextView mTrailTimeTv;

    public TrailPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mEventBus = alixPlayerContext.getEventBus();
        View inflate = LayoutInflater.from(alixPlayerContext.getActivity()).inflate(R.layout.trail_plugin, (ViewGroup) null);
        this.mHolderView = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.trail_time_container);
        this.mTrailTimeContainer = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1072604167")) {
                    ipChange.ipc$dispatch("1072604167", new Object[]{this, view});
                    return;
                }
                TrailPlugin trailPlugin = TrailPlugin.this;
                trailPlugin.sendCallBuyViewEvent(trailPlugin.livePlayControl, 2);
            }
        });
        this.mTrailTimeTv = (TextView) this.mHolderView.findViewById(R.id.trail_time_count_value);
        hideTrailTime();
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new OnVideoStreamListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1283435638")) {
                    ipChange.ipc$dispatch("-1283435638", new Object[]{this, videoRequestError});
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:27:0x00d7  */
            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1971533065")) {
                    ipChange.ipc$dispatch("1971533065", new Object[]{this, youkuVideoInfo});
                } else if (youkuVideoInfo.getPlayVideoInfo().getPlayType() == PlayType.LIVE) {
                    TrailPlugin.this.mIsTrailLive = youkuVideoInfo.getLiveInfo().isTrail;
                    if (TrailPlugin.this.mIsTrailLive && youkuVideoInfo.getLiveInfo().playControl != null) {
                        TrailPlugin.this.livePlayControl = youkuVideoInfo.getLiveInfo().playControl;
                        TrailPlugin trailPlugin = TrailPlugin.this;
                        trailPlugin.mTrailTimeKey = trailPlugin.livePlayControl.screenId;
                        long j = 120000;
                        try {
                            if (!TextUtils.isEmpty(TrailPlugin.this.livePlayControl.tryPlayTime)) {
                                j = Long.parseLong(TrailPlugin.this.livePlayControl.tryPlayTime) * DateUtils.MILLIS_PER_MINUTE;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        SharedPreferences sharedPreferences = ((AbsPlugin) TrailPlugin.this).mContext.getSharedPreferences(Utils.PLAYER_WIDGET_SP, 0);
                        long j2 = sharedPreferences.getLong(TrailPlugin.this.mTrailTimeKey, -1);
                        Log.e("testLeftTime", "countTime:" + j2);
                        if (j2 == -1) {
                            sharedPreferences.edit().putLong(TrailPlugin.this.mTrailTimeKey, j).apply();
                        } else {
                            if (j2 == 0) {
                                TrailPlugin trailPlugin2 = TrailPlugin.this;
                                trailPlugin2.sendCallBuyViewEvent(trailPlugin2.livePlayControl, 1);
                            }
                            if (TrailPlugin.this.countDownTimer != null) {
                                TrailPlugin.this.countDownTimer.cancel();
                            }
                            TrailPlugin.this.countDownTimer = new CountDownTimer(j2, 1000) {
                                /* class com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass2.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void onFinish() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-2006825902")) {
                                        ipChange.ipc$dispatch("-2006825902", new Object[]{this});
                                        return;
                                    }
                                    ((AbsPlugin) TrailPlugin.this).mContext.getSharedPreferences(Utils.PLAYER_WIDGET_SP, 0).edit().putLong(TrailPlugin.this.mTrailTimeKey, 0).apply();
                                    ((AbsPlugin) TrailPlugin.this).mPlayerContext.getPlayerContainer().getPlayer().stop();
                                    TrailPlugin trailPlugin = TrailPlugin.this;
                                    trailPlugin.sendCallBuyViewEvent(trailPlugin.livePlayControl, 1);
                                }

                                public void onTick(final long j) {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "604772540")) {
                                        ipChange.ipc$dispatch("604772540", new Object[]{this, Long.valueOf(j)});
                                        return;
                                    }
                                    TrailPlugin.this.mHandler.post(new Runnable() {
                                        /* class com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass2.AnonymousClass1.AnonymousClass1 */
                                        private static transient /* synthetic */ IpChange $ipChange;

                                        public void run() {
                                            IpChange ipChange = $ipChange;
                                            if (AndroidInstantRuntime.support(ipChange, "-1711644914")) {
                                                ipChange.ipc$dispatch("-1711644914", new Object[]{this});
                                                return;
                                            }
                                            TrailPlugin.this.mTrailTimeTv.setText(Utils.getFormatMinuteTime(j));
                                            ((AbsPlugin) TrailPlugin.this).mContext.getSharedPreferences(Utils.PLAYER_WIDGET_SP, 0).edit().putLong(TrailPlugin.this.mTrailTimeKey, j).apply();
                                            Log.e("testLeftTime", "mLeftTime:" + j);
                                        }
                                    });
                                }
                            };
                        }
                        j2 = j;
                        if (TrailPlugin.this.countDownTimer != null) {
                        }
                        TrailPlugin.this.countDownTimer = new CountDownTimer(j2, 1000) {
                            /* class com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass2.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void onFinish() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-2006825902")) {
                                    ipChange.ipc$dispatch("-2006825902", new Object[]{this});
                                    return;
                                }
                                ((AbsPlugin) TrailPlugin.this).mContext.getSharedPreferences(Utils.PLAYER_WIDGET_SP, 0).edit().putLong(TrailPlugin.this.mTrailTimeKey, 0).apply();
                                ((AbsPlugin) TrailPlugin.this).mPlayerContext.getPlayerContainer().getPlayer().stop();
                                TrailPlugin trailPlugin = TrailPlugin.this;
                                trailPlugin.sendCallBuyViewEvent(trailPlugin.livePlayControl, 1);
                            }

                            public void onTick(final long j) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "604772540")) {
                                    ipChange.ipc$dispatch("604772540", new Object[]{this, Long.valueOf(j)});
                                    return;
                                }
                                TrailPlugin.this.mHandler.post(new Runnable() {
                                    /* class com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass2.AnonymousClass1.AnonymousClass1 */
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    public void run() {
                                        IpChange ipChange = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange, "-1711644914")) {
                                            ipChange.ipc$dispatch("-1711644914", new Object[]{this});
                                            return;
                                        }
                                        TrailPlugin.this.mTrailTimeTv.setText(Utils.getFormatMinuteTime(j));
                                        ((AbsPlugin) TrailPlugin.this).mContext.getSharedPreferences(Utils.PLAYER_WIDGET_SP, 0).edit().putLong(TrailPlugin.this.mTrailTimeKey, j).apply();
                                        Log.e("testLeftTime", "mLeftTime:" + j);
                                    }
                                });
                            }
                        };
                    }
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "58447426")) {
                    ipChange.ipc$dispatch("58447426", new Object[]{this, playVideoInfo});
                    return;
                }
                TrailPlugin.this.hideTrailTime();
            }
        });
        IPlayerContainer playerContainer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContainer = playerContainer;
        IPlayer player = playerContainer.getPlayer();
        this.mPlayer = player;
        player.addOnPlayerStateListener(new OnStateChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "385349356")) {
                    ipChange.ipc$dispatch("385349356", new Object[]{this, state, state2});
                } else if (TrailPlugin.this.mIsTrailLive) {
                    if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED && state != IAlixPlayer.State.STATE_VIDEO_PAUSED) {
                        TrailPlugin.this.mHandler.post(new Runnable() {
                            /* class com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass3.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "845146010")) {
                                    ipChange.ipc$dispatch("845146010", new Object[]{this});
                                    return;
                                }
                                TrailPlugin.this.show();
                                if (TrailPlugin.this.countDownTimer != null) {
                                    TrailPlugin.this.countDownTimer.start();
                                }
                            }
                        });
                    }
                    if (state2 == IAlixPlayer.State.STATE_STOPPED && TrailPlugin.this.countDownTimer != null) {
                        TrailPlugin.this.countDownTimer.cancel();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hideTrailTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516029328")) {
            ipChange.ipc$dispatch("-516029328", new Object[]{this});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-537006362")) {
                    ipChange.ipc$dispatch("-537006362", new Object[]{this});
                } else if (TrailPlugin.this.mTrailTimeContainer != null) {
                    TrailPlugin.this.mTrailTimeContainer.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendCallBuyViewEvent(LivePlayControl livePlayControl2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1280474104")) {
            ipChange.ipc$dispatch("1280474104", new Object[]{this, livePlayControl2, Integer.valueOf(i)});
            return;
        }
        Event event = new Event(ApiConstants.EventType.SHOW_BUY_VIEW);
        HashMap hashMap = new HashMap();
        hashMap.put("playControl", livePlayControl2);
        hashMap.put("payType", Integer.valueOf(i));
        event.data = hashMap;
        this.mEventBus.post(event);
    }

    private void showTrailTime() {
        LinearLayout linearLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301986901")) {
            ipChange.ipc$dispatch("-1301986901", new Object[]{this});
        } else if (this.mIsTrailLive && (linearLayout = this.mTrailTimeContainer) != null) {
            linearLayout.setVisibility(0);
        }
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51708012")) {
            ipChange.ipc$dispatch("51708012", new Object[]{this});
            return;
        }
        showTrailTime();
    }
}
