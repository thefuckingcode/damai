package com.youku.live.dago.liveplayback.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.compat.effects.a;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.OnVideoSizeChangedListener;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.fast.FastData;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.live.LiveVideoRequest;
import com.youku.alixplayer.opensdk.statistics.PlayTimeTrack;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.SystemUtils;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplayer.util.PlaybackParamKey;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.OnDataSourceListener;
import com.youku.android.liveservice.bean.BizSwitch;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Quality;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.kubus.ThreadMode;
import com.youku.live.arch.utils.ViewUtils;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.ConfigUtils;
import com.youku.live.dago.liveplayback.ToastUtil;
import com.youku.live.dago.liveplayback.UIUtils;
import com.youku.live.dago.liveplayback.widget.Constants;
import com.youku.live.dago.liveplayback.widget.model.LiveStateChangeBean;
import com.youku.live.dago.liveplayback.widget.model.RecordInfo;
import com.youku.live.dago.liveplayback.widget.model.RecordInfoWrapper;
import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import com.youku.live.dago.liveplayback.widget.plugins.audiofocus.PlayerAudioFocusManager;
import com.youku.live.dago.liveplayback.widget.plugins.danmu.DanmuPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin;
import com.youku.live.dago.liveplayback.widget.preload.FactoryWithPreloader;
import com.youku.live.dago.liveplayback.widget.preload.NewPlayInfoCache;
import com.youku.live.dago.liveplayback.widget.preload.PlayerContextContainer;
import com.youku.live.dago.liveplayback.widget.preload.PlayerContextPreloader;
import com.youku.live.dago.liveplayback.widget.preload.PlayerPreloader;
import com.youku.live.dago.liveplayback.widget.track.AlixPlayerTrack;
import com.youku.live.dago.liveplayback.widget.view.DagoLivePlaybackFrameLayout;
import com.youku.live.dago.liveplayback.widget.view.PlayBackCover;
import com.youku.live.dago.liveplayback.widget.view.PromptLayout;
import com.youku.live.dago.liveplayback.widget.view.TouchableCSSLayout;
import com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.log.PerfLogUtils;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.dsl.preloader.ILivePayControlPreloader;
import com.youku.live.dsl.preloader.IPreloader;
import com.youku.live.dsl.toast.IToast;
import com.youku.live.dsl.usertrack.IUserTracker;
import com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface;
import com.youku.live.livesdk.LiveRoomConstants;
import com.youku.live.livesdk.R;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.PlayerbackViewModel;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.ExtDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.TemplateDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.ThemeDTO;
import com.youku.live.livesdk.preloader.YKPrefReporter;
import com.youku.live.livesdk.util.LivePerfUtils;
import com.youku.live.livesdk.widgets.container.pager.model.AppKeyPlayInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.NewPlayInfoModel;
import com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin;
import com.youku.live.livesdk.wkit.widget.LiveWeexWidget;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.model.template.TemplateModel;
import com.youku.live.widgets.model.template.WidgetAttributesModel;
import com.youku.live.widgets.model.template.WidgetModel;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityKeyDownListener;
import com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityResultListener;
import com.youku.live.widgets.protocol.activity.IActivityStateReader;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.ntpsync.NtpSyncUtils;
import com.youku.tinywindow.TinyWindowConfig;
import com.youku.tinywindow.TinyWindowListener;
import com.youku.tinywindow.TinyWindowManager;
import com.youku.vpm.constants.TableField;
import com.youku.xadsdk.plugin.AdUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tb.cq1;
import tb.tp1;

/* compiled from: Taobao */
public class AlixLivePlayback extends BaseWidget implements IDagoLivePlaybackInjectorInterface, DagoChannelPlugin.Receiver, ICall, IDataHandler, IActivityConfigurationChangedListener, IActivityKeyDownListener, IActivityLifecycleStateChangedListener, IActivityResultListener, IActivityStateReader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ACTION_PARAMS_VALUE = "value";
    private static final String CALLBACK_CONTROLL_ATTENTION = "DAGOLiveEndPageCloseAction";
    private static final String CALLBACK_CONTROLL_PLAY_PAUSE = "DAGOPlayerPlayAndPause";
    private static final String CALLBACK_CONTROLL_SEEK = "DAGOPlayerSeek";
    private static final String CALLBACK_CONTROLL_TIME_SHIFT = "DAGOPlayerControlDidSelectTimeShift";
    private static final String CALLBACK_CONTROLL_VISIBLE_CHANGED = "DAGOPlayerControlViewHiddenDidChange";
    private static final String CALLBACK_OROTATE_EXIT = "DAGOExitOrotateAction";
    private static final String CALLBACK_OROTATE_FINISH = "DAGOFinishOrotateAction";
    private static final String CALLBACK_OROTATE_START = "DAGOStartOrotateAction";
    private static final String DAGO_LIVE_BACK_DATA = "mtop.youku.live.com.recordInfo";
    private static final long DEFAULT_COVER_HIDE_INTERVAL = 3000;
    public static final int FIRST_PLAYER_IDX = 0;
    private static final String IGNORE_TINYWINDOW = "ignore_tinywindow";
    private static final String KEY_PLAYER_CORE_FIRST_FRAME = "playerCoreFirstFrame";
    private static final String KEY_PLAYER_CORE_INFO = "playerCoreInfo";
    private static final String KEY_PLAYER_FIRST_ERROR = "playerFirstError";
    private static final String KEY_PLAYER_FIRST_FRAME = "playerFirstFrame";
    private static final String KEY_PLAYER_START = "playerLiveStart";
    private static final String LOG_TAG = "SlideOpAlix";
    private static final int MAX_PLAYER_COUNT = 2;
    private static final String METHOD_GET_VIEW = "getView";
    private static final String METHOD_MUTE_PLAYER = "mutePlayer";
    private static final int MSG_PLAY = 1;
    private static final int MSG_PLAY_VID = 3;
    private static final int MSG_RELEASE = 4;
    private static final int MSG_STOP = 2;
    private static final String PLAYER_THREAD_NAME = "DagoLive-Thread";
    private static final String RESULT_VIEW = "view";
    public static final int SECOND_PLAYER_IDX = 1;
    private static final String TAG = "AlixLivePlayback";
    private static final String TAG_COST = "AlixLivePlayback-Cost";
    private static final String VIEW_DANMU = "danmu";
    private static final String VIEW_TYPE = "type";
    public static final String WIDGET_NAME = "LivePlayback";
    private static PlayerAudioFocusManager mPlayerAudioFocusManager;
    private boolean hasJumpToPage;
    boolean isUnLimitedOpen = false;
    private Activity mActivity;
    private AlixPlayerTrack mAlixPlayerTrack;
    private CSSLayout mCSSRootView;
    private DagoChannelPlugin mChannelPlugin;
    private Context mContext;
    private PlayBackCover mCoverImageView;
    private int mCurScreenMode = 1;
    private EndPageView.OnEndPageClickListener mEndPageListener;
    private EndPageView mEndPageView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    Map<String, Object> mKeyDownDatas;
    private LayoutVariables mLayoutVariables = new LayoutVariables();
    private IVideoRequest.Callback<LiveInfo, List<LiveInfo>> mLiveRequestCallback;
    private ViewGroup mNonplayerViewContainer;
    private OnDataSourceListener mOnDataSourceListener;
    private OnInfoListener[] mOnInfoListeners;
    private OnStateChangeListener[] mOnStateChangeListeners;
    private OnVideoSizeChangedListener[] mOnVideoSizeChangedListeners;
    private OnVideoStreamListener mOnVideoStreamListener;
    private PlaybackVariables mPlaybackVariables = new PlaybackVariables();
    private IPlayerContainer mPlayerContainer;
    private AlixPlayerContext mPlayerContext;
    private Long mPlayerControlDidSelectTimeShiftSeekStartTime;
    private Long mPlayerControlDidSelectTimeShiftSeekTime;
    private Boolean mPlayerControlViewIsVisibility;
    private PlayerHandler mPlayerHandler;
    private StringBuilder mPlayerInfoSB;
    private View.OnTouchListener mPlayerLayoutTouchListener;
    private String mPlayerPlayAndPause;
    private Long mPlayerPlayAndPauseTS;
    private HandlerThread mPlayerThread = new HandlerThread(PLAYER_THREAD_NAME);
    private ViewGroup[] mPlayerViewContainers = new ViewGroup[2];
    private LinearLayout mPlayerViewRoot;
    private OnInfoListener mPrimaryInfoListener;
    private OnStateChangeListener mPrimaryStateChangeListener = new OnStateChangeListener() {
        /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass12 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.alixplayer.OnStateChangeListener
        public void onStateChange(final IAlixPlayer.State state, final IAlixPlayer.State state2) {
            final long j;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1068654017")) {
                ipChange.ipc$dispatch("1068654017", new Object[]{this, state, state2});
                return;
            }
            if (state2 == IAlixPlayer.State.STATE_PRE_AD_STARTED || state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            AlixLivePlayback.this.runOnUIThread(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass12.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    BizSwitch bizSwitch;
                    IpChange ipChange = $ipChange;
                    boolean z = true;
                    if (AndroidInstantRuntime.support(ipChange, "-764254865")) {
                        ipChange.ipc$dispatch("-764254865", new Object[]{this});
                        return;
                    }
                    switch (AnonymousClass28.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state2.ordinal()]) {
                        case 1:
                            AlixLivePlayback.this.updateCoverImageState(false);
                            AlixLivePlayback.this.perfMonitor("firstFrameWithAd");
                            if (AlixLivePlayback.this.getEngineInstance() != null && AlixLivePlayback.this.getEngineInstance().getOptions() != null) {
                                AlixLivePlayback.this.getEngineInstance().putData("playerFirstFrame", Long.valueOf(System.currentTimeMillis()));
                                AlixLivePlayback.this.getEngineInstance().putData(AlixLivePlayback.KEY_PLAYER_CORE_FIRST_FRAME, Long.valueOf(j));
                                YKPrefReporter.getInstance().getPlayBySessionId(AlixLivePlayback.this.getEngineInstance().getOptions().getString("onePlayId", "")).setADFirstFrameTime(System.currentTimeMillis());
                                YKPrefReporter.getInstance().getPlayBySessionId(AlixLivePlayback.this.getEngineInstance().getOptions().getString("onePlayId", "")).report();
                                return;
                            }
                            return;
                        case 2:
                            if (AlixLivePlayback.this.mAlixPlayerTrack != null) {
                                AlixLivePlayback.this.mAlixPlayerTrack.videoStarted();
                                if (!(AlixLivePlayback.this.mPlayerContainer.getPlayerTrack() == null || AlixLivePlayback.this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack() == null)) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long playStartTime = AlixLivePlayback.this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack().getPlayStartTime();
                                    long j = currentTimeMillis - playStartTime;
                                    AlixLivePlayback.this.mAlixPlayerTrack.setShownTime(j);
                                    Logger.d("showntime", "FirstPlayer's videostart showntime is:" + String.valueOf(j) + "|" + currentTimeMillis + "|" + playStartTime);
                                }
                            }
                            AlixLivePlayback.this.perfMonitor("firstFrame");
                            if (!(AlixLivePlayback.this.getEngineInstance() == null || AlixLivePlayback.this.getEngineInstance().getOptions() == null)) {
                                AlixLivePlayback.this.getEngineInstance().putData("playerFirstFrame", Long.valueOf(System.currentTimeMillis()));
                                AlixLivePlayback.this.getEngineInstance().putData(AlixLivePlayback.KEY_PLAYER_CORE_FIRST_FRAME, Long.valueOf(j));
                                YKPrefReporter.getInstance().getPlayBySessionId(AlixLivePlayback.this.getEngineInstance().getOptions().getString("onePlayId", "")).setFirstFrameTime(System.currentTimeMillis());
                                YKPrefReporter.getInstance().getPlayBySessionId(AlixLivePlayback.this.getEngineInstance().getOptions().getString("onePlayId", "")).report();
                            }
                            if (AlixLivePlayback.this.mPlayerContainer.getPlayVideoInfo().getPlayType() == PlayType.VOD) {
                                AlixLivePlayback.this.mPlayerContainer.getPlayer().setIsLoopPlay(true);
                            } else if (AlixLivePlayback.this.mPlayerContainer.getPlayVideoInfo().getPlayType() == PlayType.LIVE) {
                                LivePlayControl livePlayControl = AlixLivePlayback.this.mPlayerContainer.getVideoStream().getYoukuVideoInfo().getLivePlayControl();
                                VerticalSmallscreenPlugin verticalSmallscreenPlugin = (VerticalSmallscreenPlugin) AlixLivePlayback.this.mPlayerContext.getPluginManager(AlixLivePlayback.this.mNonplayerViewContainer).getPlugin(PluginName.PLAYER_VERTICAL_SMALLSCREEN_CONTROL);
                                HorizontalFullscreenPlugin horizontalFullscreenPlugin = (HorizontalFullscreenPlugin) AlixLivePlayback.this.mPlayerContext.getPluginManager(AlixLivePlayback.this.mNonplayerViewContainer).getPlugin(PluginName.PLAYER_HORIZONTAL_FULLSCREEN_CONTROL);
                                if (AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager != null) {
                                    AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager.setVSmallScreen(verticalSmallscreenPlugin);
                                    AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager.setHFullScreen(horizontalFullscreenPlugin);
                                }
                                if (!(livePlayControl == null || (bizSwitch = livePlayControl.bizSwitch) == null)) {
                                    if (bizSwitch.timeShift != 1) {
                                        z = false;
                                    }
                                    if (z && AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager != null) {
                                        PlayVideoInfo playVideoInfo = AlixLivePlayback.this.mPlayerContainer.getPlayVideoInfo();
                                        if ("1".equals(playVideoInfo.getString("timeShift"))) {
                                            if (AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager.getNowTime() == 0) {
                                                long j2 = livePlayControl.now * 1000;
                                                int i = livePlayControl.timeShiftOffset;
                                                if (i >= 0) {
                                                    j2 = (livePlayControl.startTimestamp * 1000) + ((long) (i * 1000));
                                                }
                                                AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager.initTimeShift(livePlayControl.startTimestamp * 1000, livePlayControl.endTimestamp * 1000, j2, livePlayControl.now * 1000);
                                            }
                                            AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager.setNowTime(((LiveInfo) playVideoInfo.getTag("liveInfo")).timeshift);
                                            AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager.startTimeTask();
                                        } else {
                                            long j3 = livePlayControl.now * 1000;
                                            int i2 = livePlayControl.timeShiftOffset;
                                            if (i2 >= 0) {
                                                j3 = (livePlayControl.startTimestamp * 1000) + ((long) (i2 * 1000));
                                            }
                                            AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager.initTimeShift(livePlayControl.startTimestamp * 1000, livePlayControl.endTimestamp * 1000, j3, livePlayControl.now * 1000);
                                        }
                                    }
                                }
                            }
                            AlixLivePlayback alixLivePlayback = AlixLivePlayback.this;
                            alixLivePlayback.injectorCallbackPlay(alixLivePlayback.getPlayer(0).getCurrentPosition(Aliplayer.PositionType.NORMAL));
                            if (state != IAlixPlayer.State.STATE_VIDEO_PAUSED && AlixLivePlayback.this.mCoverImageView.getVisibility() == 0) {
                                AlixLivePlayback.this.updateCoverImageState(false);
                            }
                            AlixLivePlayback.this.preparePreRequestLiveInfo();
                            AlixLivePlayback.this.adjustPlayerLayout();
                            AlixLivePlayback.this.loadLazyPlugins();
                            return;
                        case 3:
                            AlixLivePlayback alixLivePlayback2 = AlixLivePlayback.this;
                            alixLivePlayback2.injectorCallbackPause(alixLivePlayback2.getPlayer(0).getCurrentPosition(Aliplayer.PositionType.NORMAL));
                            return;
                        case 4:
                            if (AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager != null) {
                                AlixLivePlayback.this.mPlaybackVariables.localSeekBarProgressManager.stopTimeTask();
                                return;
                            }
                            return;
                        case 5:
                        case 6:
                            if (AlixLivePlayback.this.getEngineInstance() != null && AlixLivePlayback.this.getEngineInstance().getOptions() != null) {
                                AlixLivePlayback.this.getEngineInstance().putData("playerFirstError", Long.valueOf(System.currentTimeMillis()));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }, 0);
        }
    };
    private OnVideoSizeChangedListener mPrimaryVideoSizeChangedListener;
    private PromptLayout.OnPromptBtnClickListener mPromptBtnClickListener;
    private PromptLayout mPromptLayout;
    private CSSLayout.LayoutParams mRootViewLayoutParams;
    public DelayedRunnable mRotateFinishRunnable;
    private long mScreenModeTime = 0;
    private String[] mScreenPluginNames = {PluginName.PLAYER_HORIZONTAL_FULLSCREEN_CONTROL, PluginName.PLAYER_VERTICAL_FULLSCREEN_CONTROL, PluginName.PLAYER_VERTICAL_SMALLSCREEN_CONTROL};
    private OnStateChangeListener mSeconaryStateChangeListener;
    private ViewGroup mTopViewContainer;
    private String mUniqueKey;
    private boolean mUsingRemoteCover = false;
    private ViewGroup mWidgetRootView;
    private CostTime pageCostTs;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.live.dago.liveplayback.widget.AlixLivePlayback$28  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass28 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$IAlixPlayer$State;
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$opensdk$PlayType;
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$DataKey;
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey;
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$MessageKey;
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$widgets$ActivityLifecycleState;
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$widgets$protocol$Orientation;

        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|(2:31|32)|33|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|(2:61|62)|63|65|66|67|68|69|70|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|87|88|89|90|91|92|93|94|(3:95|96|98)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(75:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|(2:31|32)|33|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|87|88|89|90|91|92|93|94|(3:95|96|98)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|(2:31|32)|33|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|87|88|89|90|91|92|93|94|(3:95|96|98)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(77:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|87|88|89|90|91|92|93|94|(3:95|96|98)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(78:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|87|88|89|90|91|92|93|94|(3:95|96|98)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(81:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|87|88|89|90|91|92|93|94|95|96|98) */
        /* JADX WARNING: Can't wrap try/catch for region: R(82:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|87|88|89|90|91|92|93|94|95|96|98) */
        /* JADX WARNING: Can't wrap try/catch for region: R(85:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|(2:77|78)|79|81|82|83|84|85|87|88|89|90|91|92|93|94|95|96|98) */
        /* JADX WARNING: Can't wrap try/catch for region: R(86:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|81|82|83|84|85|87|88|89|90|91|92|93|94|95|96|98) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ae */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0116 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0134 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x013e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0148 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0163 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x017e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0188 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0192 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x019c */
        static {
            int[] iArr = new int[InjectKey.values().length];
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey = iArr;
            try {
                iArr[InjectKey.ACTION_GLOBAL_CALLBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.ACTION_PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.ACTION_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.ACTION_REPOWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.ACTION_TAKE_SHOT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.ACTION_OG_BACK_TO_MULTI_SCREEN_SELECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.ACTION_SWITCH_LIST_MULTI_SCREEN_WITH_SCENE_ID.ordinal()] = 7;
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.ACTION_SET_AHDR_STATE.ordinal()] = 8;
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.ACTION_SET_UNLIMIT_SCREEN.ordinal()] = 9;
            try {
                $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.ACTION_SET_PLAYER_CONTROL_VIEW_DISPLAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[PlayType.values().length];
            $SwitchMap$com$youku$alixplayer$opensdk$PlayType = iArr2;
            iArr2[PlayType.VOD.ordinal()] = 1;
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$PlayType[PlayType.LIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[IAlixPlayer.State.values().length];
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State = iArr3;
            iArr3[IAlixPlayer.State.STATE_PRE_AD_STARTED.ordinal()] = 1;
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_VIDEO_STARTED.ordinal()] = 2;
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_VIDEO_PAUSED.ordinal()] = 3;
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_STOPPED.ordinal()] = 4;
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_ERROR.ordinal()] = 5;
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_SOURCE_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[MessageKey.values().length];
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$MessageKey = iArr4;
            iArr4[MessageKey.MIC_CHANGE_V2.ordinal()] = 1;
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$MessageKey[MessageKey.LIVE_STATE_CHANGE.ordinal()] = 2;
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$MessageKey[MessageKey.LIVE_PLAY_REFRESH.ordinal()] = 3;
            try {
                $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$MessageKey[MessageKey.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr5 = new int[DataKey.values().length];
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$DataKey = iArr5;
            iArr5[DataKey.IS_SUPPORT_PIP.ordinal()] = 1;
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$DataKey[DataKey.ENTER_PIP_MODE.ordinal()] = 2;
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$DataKey[DataKey.ON_PIP_MODE_CHANGED.ordinal()] = 3;
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$DataKey[DataKey.FULL_DATA_INFO.ordinal()] = 4;
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$DataKey[DataKey.DAGO_LIVE_START_OR_STOP_PROP.ordinal()] = 5;
            $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$DataKey[DataKey.UN_LIMITED_SCREEN.ordinal()] = 6;
            try {
                $SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$DataKey[DataKey.NONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr6 = new int[Orientation.values().length];
            $SwitchMap$com$youku$live$widgets$protocol$Orientation = iArr6;
            iArr6[Orientation.ORIENTATION_LANDSCAPE.ordinal()] = 1;
            $SwitchMap$com$youku$live$widgets$protocol$Orientation[Orientation.ORIENTATION_PORTAIT.ordinal()] = 2;
            int[] iArr7 = new int[ActivityLifecycleState.values().length];
            $SwitchMap$com$youku$live$widgets$ActivityLifecycleState = iArr7;
            iArr7[ActivityLifecycleState.CREATED.ordinal()] = 1;
            $SwitchMap$com$youku$live$widgets$ActivityLifecycleState[ActivityLifecycleState.STARTED.ordinal()] = 2;
            $SwitchMap$com$youku$live$widgets$ActivityLifecycleState[ActivityLifecycleState.RESUMED.ordinal()] = 3;
            $SwitchMap$com$youku$live$widgets$ActivityLifecycleState[ActivityLifecycleState.PAUSED.ordinal()] = 4;
            try {
                $SwitchMap$com$youku$live$widgets$ActivityLifecycleState[ActivityLifecycleState.STOPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class CostTime {
        public long activityCreateTs;
        public long clickTs;
        public long navTs;

        private CostTime() {
        }

        /* access modifiers changed from: package-private */
        public long getStartTime() {
            return Math.max(this.clickTs, this.navTs);
        }
    }

    /* compiled from: Taobao */
    public enum DataKey {
        NONE("NONE"),
        FULL_DATA_INFO("mtop.youku.live.com.livefullinfo"),
        IS_SUPPORT_PIP("isSupportPip"),
        ENTER_PIP_MODE("enterPipMode"),
        ON_PIP_MODE_CHANGED("onPictureInPictureModeChanged"),
        UN_LIMITED_SCREEN("LFLWDataCenterUnlimitScreen"),
        DAGO_LIVE_START_OR_STOP_PROP(PipUtils.DAGO_LIVE_START_OR_STOP_PROP);
        
        String keyName;

        private DataKey(@NonNull String str) {
            this.keyName = str;
        }

        public static DataKey toDataKey(@NonNull String str) {
            DataKey[] values = values();
            for (DataKey dataKey : values) {
                if (dataKey.getKeyName().equals(str)) {
                    return dataKey;
                }
            }
            return NONE;
        }

        @NonNull
        public String getKeyName() {
            return this.keyName;
        }
    }

    /* compiled from: Taobao */
    private class DelayedRunnable implements Runnable {
        public Map<String, Object> params;

        private DelayedRunnable() {
        }

        public void run() {
        }
    }

    /* compiled from: Taobao */
    private enum InjectKey {
        NONE("NONE"),
        ACTION_GLOBAL_CALLBACK(LiveWeexWidget.GLOBAL_EVENT),
        ACTION_PLAY(Constants.Value.PLAY),
        ACTION_STOP("stop"),
        ACTION_REPOWER("rePower"),
        ACTION_INSERT_VIEW_TO_CONTROL_PLUGIN("insertView2ControlPlugin"),
        ACTION_TAKE_SHOT("takeShot"),
        ACTION_OG_BACK_TO_MULTI_SCREEN_SELECT(Constants.WEEX.ACTION.Multi_GO_BACK),
        ACTION_SET_AHDR_STATE("setAHDRState"),
        ACTION_SWITCH_LIST_MULTI_SCREEN_WITH_SCENE_ID("switchListMultiScreenWithSceneId"),
        ACTION_SET_UNLIMIT_SCREEN("setUnlimitScreen"),
        ACTION_SET_PLAYER_CONTROL_VIEW_DISPLAY("setPlayerControlViewDisplay");
        
        String keyName;

        private InjectKey(String str) {
            this.keyName = str;
        }

        public static InjectKey get(String str) {
            InjectKey[] values = values();
            for (InjectKey injectKey : values) {
                if (injectKey.keyName.equals(str)) {
                    return injectKey;
                }
            }
            return NONE;
        }

        public String getKeyName() {
            return this.keyName;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class LayoutVariables {
        String decodedLandscapeLayout;
        String decodedLayout;
        String decodedPortraitLayout;
        private WidgetAttributesModel landscapeLayoutModel;
        private WidgetAttributesModel layoutModel;
        cq1 phenixTicket;
        private WidgetAttributesModel portraitLayoutModel;
        int statusBarHeight;

        private LayoutVariables() {
            this.statusBarHeight = 0;
        }

        private static WidgetAttributesModel findWidgetAttributesByWidgetName(WidgetModel widgetModel) {
            WidgetAttributesModel widgetAttributesModel = null;
            if (widgetModel == null || TextUtils.isEmpty(widgetModel.name)) {
                return null;
            }
            if (AlixLivePlayback.WIDGET_NAME.equals(widgetModel.name)) {
                return widgetModel.atts;
            }
            List<WidgetModel> list = widgetModel.children;
            if (list == null) {
                return null;
            }
            for (WidgetModel widgetModel2 : list) {
                if (!(widgetModel2 == null || (widgetAttributesModel = findWidgetAttributesByWidgetName(widgetModel2)) == null)) {
                    return widgetAttributesModel;
                }
            }
            return widgetAttributesModel;
        }

        private WidgetAttributesModel generateWidgetAttributesModel(String str) {
            return findWidgetAttributesByWidgetName(((TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, TemplateModel.class)).widget);
        }

        /* access modifiers changed from: package-private */
        public WidgetAttributesModel getLandscapeLayoutModel() {
            String str = this.decodedLandscapeLayout;
            if (str != null && this.landscapeLayoutModel == null) {
                this.landscapeLayoutModel = generateWidgetAttributesModel(str);
            }
            return this.landscapeLayoutModel;
        }

        /* access modifiers changed from: package-private */
        public WidgetAttributesModel getLayoutModel() {
            String str = this.decodedLayout;
            if (str != null && this.layoutModel == null) {
                this.layoutModel = generateWidgetAttributesModel(str);
            }
            return this.layoutModel;
        }

        /* access modifiers changed from: package-private */
        public WidgetAttributesModel getPortraitLayoutModel() {
            String str = this.decodedPortraitLayout;
            if (str != null && this.portraitLayoutModel == null) {
                this.portraitLayoutModel = generateWidgetAttributesModel(str);
            }
            return this.portraitLayoutModel;
        }

        /* access modifiers changed from: package-private */
        public void updateLayout(String str, String str2, String str3) {
            this.decodedLayout = str;
            this.decodedLandscapeLayout = str2;
            this.decodedPortraitLayout = str3;
            this.layoutModel = null;
            this.landscapeLayoutModel = null;
            this.portraitLayoutModel = null;
        }
    }

    /* compiled from: Taobao */
    private enum MessageKey {
        NONE("NONE"),
        MIC_CHANGE_V2("mic_change_v2"),
        LIVE_STATE_CHANGE(LiveManager.LIVE_STATE_CHANGE),
        LIVE_PLAY_REFRESH(LiveManager.LIVE_PLAY_REFRESH);
        
        String keyName;

        private MessageKey(@NonNull String str) {
            this.keyName = str;
        }

        public static MessageKey toMessageKey(@NonNull String str) {
            MessageKey[] values = values();
            for (MessageKey messageKey : values) {
                if (messageKey.getKeyName().equals(str)) {
                    return messageKey;
                }
            }
            return NONE;
        }

        @NonNull
        public String getKeyName() {
            return this.keyName;
        }
    }

    /* compiled from: Taobao */
    private enum PageSource {
        SCROLL,
        WALL,
        UNKNOWN
    }

    /* compiled from: Taobao */
    public static class PlaybackVariables {
        String coverImageUrl;
        @NonNull
        String currentLiveId;
        boolean degradationByMsg;
        long didAppearTime;
        boolean enableBgPlay = true;
        Orientation firstVideoOrientation;
        boolean freeLayout;
        boolean hasTwoPlayer = false;
        boolean isMCU = false;
        boolean isPK = false;
        boolean isPlayerTakenByWindow;
        boolean isRapidPlay = false;
        LiveFullInfoData liveFullInfoData;
        LocalSeekBarProgressManager localSeekBarProgressManager;
        long mRotateStartTime;
        int mSystemUiVisibility;
        String micMode;
        PageSource pageSource = PageSource.UNKNOWN;
        boolean pipEnable;
        String playControlRequireId;
        boolean playRecord;
        long playerSeek;
        Protocol protocol = Protocol.UNKNOWN;
        String psid;
        String pushStreamType;
        NewPlayInfoModel rapidPlayInfo;
        int reqQuality;
        IDagoLivePlaybackInjectorInterface.IResultListener resultGlobalCallback;
        IDagoLivePlaybackInjectorInterface.IResultListener resultRotateCallback;
        IDagoLivePlaybackInjectorInterface.IResultListener resultSeiCallback;
        Orientation roomOrientation;
        String sceneId;
        String screenId;
        Orientation secondVideoOrientation;
        Orientation streamOrientation;
        String videoFormat;
        long willAppearTime;

        public PlaybackVariables() {
            Orientation orientation = Orientation.ORIENTATION_PORTAIT;
            this.streamOrientation = orientation;
            this.firstVideoOrientation = orientation;
            this.secondVideoOrientation = orientation;
            this.pipEnable = false;
        }

        public Orientation getFirstVideoOrientation() {
            return this.firstVideoOrientation;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class PlayerHandler extends Handler {
        private WeakReference<AlixLivePlayback> mAlixLivePlaybackRef;

        public PlayerHandler(Looper looper, AlixLivePlayback alixLivePlayback) {
            super(looper);
            this.mAlixLivePlaybackRef = new WeakReference<>(alixLivePlayback);
        }

        public void handleMessage(Message message) {
            if (this.mAlixLivePlaybackRef.get() != null) {
                Bundle data = message.getData();
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        AlixLivePlayback.this.stopPlaying();
                    } else if (i == 3 && data != null) {
                        String string = data.getString("vid");
                        if (!TextUtils.isEmpty(string)) {
                            AlixLivePlayback.this.playWithVid(string);
                        }
                    }
                } else if (data != null) {
                    AlixLivePlayback.this.startPlaying(data.getString("params"), data.getString(TableField.PLAY_FROM));
                } else {
                    AlixLivePlayback.this.startPlaying(null, null);
                }
            } else {
                Log.d(AlixLivePlayback.TAG, "AlixLivePlayback null in PlayerHandler");
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum Protocol {
        UNKNOWN("unknown"),
        RTP("rtp"),
        ARTP("artp"),
        GRTN("grtn"),
        HTTP_FLV("httpFlv");
        
        String protocolName;

        private Protocol(@NonNull String str) {
            this.protocolName = str;
        }

        @NonNull
        public static Protocol get(@NonNull String str) {
            Protocol[] values = values();
            for (Protocol protocol : values) {
                if (protocol.protocolName.equals(str)) {
                    return protocol;
                }
            }
            return UNKNOWN;
        }
    }

    public AlixLivePlayback() {
        AnonymousClass13 r3 = new OnStateChangeListener() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass13 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-130081248")) {
                    ipChange.ipc$dispatch("-130081248", new Object[]{this, state, state2});
                    return;
                }
                int i = AnonymousClass28.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state2.ordinal()];
                if (i == 1) {
                    AlixLivePlayback.this.updateCoverImageState(false);
                } else if (i == 2) {
                    if (!(AlixLivePlayback.this.mAlixPlayerTrack == null || AlixLivePlayback.this.mPlayerContainer.getPlayerTrack() == null || AlixLivePlayback.this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack() == null)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        long playStartTime = AlixLivePlayback.this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack().getPlayStartTime();
                        long j = currentTimeMillis - playStartTime;
                        AlixLivePlayback.this.mAlixPlayerTrack.setShownTime(j);
                        Logger.d("showntime", "SecondPlayer's videostart showntime is:" + String.valueOf(j) + "|" + currentTimeMillis + "|" + playStartTime);
                    }
                    AlixLivePlayback.this.runOnUIThread(new Runnable() {
                        /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass13.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-635172146")) {
                                ipChange.ipc$dispatch("-635172146", new Object[]{this});
                                return;
                            }
                            AlixLivePlayback.this.adjustPlayerLayout();
                            if (AlixLivePlayback.this.mCoverImageView.getVisibility() == 0) {
                                AlixLivePlayback.this.updateCoverImageState(false);
                            }
                        }
                    }, 0);
                }
            }
        };
        this.mSeconaryStateChangeListener = r3;
        this.mOnStateChangeListeners = new OnStateChangeListener[]{this.mPrimaryStateChangeListener, r3};
        AnonymousClass14 r1 = new OnVideoSizeChangedListener() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass14 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnVideoSizeChangedListener
            public void onVideoSizeChange(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1906781512")) {
                    ipChange.ipc$dispatch("-1906781512", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }
        };
        this.mPrimaryVideoSizeChangedListener = r1;
        this.mOnVideoSizeChangedListeners = new OnVideoSizeChangedListener[]{r1};
        AnonymousClass15 r12 = new OnInfoListener() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass15 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnInfoListener
            public void onInfo(int i, int i2, int i3, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1840436678")) {
                    ipChange.ipc$dispatch("1840436678", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
                } else if (i == 1017) {
                    if (AlixLivePlayback.this.getEngineInstance() != null) {
                        AlixLivePlayback.this.getEngineInstance().putData(AlixLivePlayback.KEY_PLAYER_CORE_INFO, obj);
                    }
                    if (obj != null) {
                        PerfLogUtils.log("AlixLivePlayback.onInfo.MEDIA_INFO_VIDEO_START object : " + obj.toString());
                    }
                } else if ((i == 2016 || i == 2017) && AlixLivePlayback.this.mAlixPlayerTrack != null) {
                    AlixLivePlayback.this.mAlixPlayerTrack.onInfo(i, i2, i3, obj);
                }
            }
        };
        this.mPrimaryInfoListener = r12;
        this.mOnInfoListeners = new OnInfoListener[]{r12};
        this.mPlayerLayoutTouchListener = new View.OnTouchListener() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass16 */
            private static transient /* synthetic */ IpChange $ipChange;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-501735128")) {
                    return ((Boolean) ipChange.ipc$dispatch("-501735128", new Object[]{this, view, motionEvent})).booleanValue();
                }
                AlixLivePlayback.this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.ON_SINGLE_TAP));
                return false;
            }
        };
        this.mOnVideoStreamListener = new OnVideoStreamListener() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass17 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                LivePlayControl livePlayControl;
                IpChange ipChange = $ipChange;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange, "-220258085")) {
                    ipChange.ipc$dispatch("-220258085", new Object[]{this, videoRequestError});
                } else if (videoRequestError != null) {
                    if (videoRequestError.getErrorCode() == 48703 || videoRequestError.getErrorCode() == 48704) {
                        AlixLivePlayback.this.mHandler.post(new Runnable() {
                            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass17.AnonymousClass2 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-315354775")) {
                                    ipChange.ipc$dispatch("-315354775", new Object[]{this});
                                } else if (AlixLivePlayback.this.getEngineInstance() != null && AlixLivePlayback.this.getEngineInstance().getOptions() != null) {
                                    AlixLivePlayback.this.getEngineInstance().putData("playerFirstError", Long.valueOf(System.currentTimeMillis()));
                                }
                            }
                        });
                        if (AlixLivePlayback.this.mPlaybackVariables.liveFullInfoData != null) {
                            if (videoRequestError.getLivePlayControl() != null) {
                                AlixLivePlayback.this.mPlaybackVariables.liveFullInfoData.liveStatus = Integer.valueOf(videoRequestError.getLivePlayControl().liveStatus);
                            }
                            AlixLivePlayback alixLivePlayback = AlixLivePlayback.this;
                            alixLivePlayback.updateRoomStateWithLiveFullInfo(alixLivePlayback.mPlaybackVariables.liveFullInfoData);
                        }
                    }
                    if (!(videoRequestError.getErrorCode() == 72001 || videoRequestError.getErrorCode() != 71001 || (livePlayControl = videoRequestError.getLivePlayControl()) == null)) {
                        int requestLiveQuality = AlixLivePlayback.this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getRequestLiveQuality();
                        for (Quality quality : livePlayControl.qualities) {
                            if (quality.bizSwitch.memberQuality == 1 && requestLiveQuality == quality.quality && quality.code == 1001) {
                                i = 3;
                            }
                        }
                    }
                    AlixLivePlayback.this.callBuyViewEvent(videoRequestError.getLivePlayControl(), i);
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(final YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1311187610")) {
                    ipChange.ipc$dispatch("1311187610", new Object[]{this, youkuVideoInfo});
                    return;
                }
                AlixLivePlayback.this.runOnUIThread(new Runnable() {
                    /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass17.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX WARNING: Removed duplicated region for block: B:54:0x023c  */
                    public void run() {
                        boolean z;
                        int i;
                        IpChange ipChange = $ipChange;
                        boolean z2 = true;
                        int i2 = 0;
                        if (AndroidInstantRuntime.support(ipChange, "-118841270")) {
                            ipChange.ipc$dispatch("-118841270", new Object[]{this});
                            return;
                        }
                        if (AlixLivePlayback.this.mPromptLayout != null) {
                            AlixLivePlayback.this.mPromptLayout.hide();
                        }
                        PlayType playType = youkuVideoInfo.getPlayVideoInfo().getPlayType();
                        AlixLivePlayback.this.mPlaybackVariables.isPK = false;
                        AlixLivePlayback.this.mPlaybackVariables.hasTwoPlayer = false;
                        int i3 = AnonymousClass28.$SwitchMap$com$youku$alixplayer$opensdk$PlayType[playType.ordinal()];
                        if (i3 != 1) {
                            int i4 = 2;
                            if (i3 == 2) {
                                VideoInfo videoInfo = youkuVideoInfo.getLiveInfo().videoInfo;
                                LivePlayControl livePlayControl = youkuVideoInfo.getLivePlayControl();
                                IPreloader instance = ILivePayControlPreloader.getInstance();
                                if (instance instanceof ILivePayControlPreloader) {
                                    ((ILivePayControlPreloader) instance).clearResult();
                                }
                                if (!(videoInfo == null || livePlayControl == null)) {
                                    if (AlixLivePlayback.this.mPlaybackVariables.liveFullInfoData != null) {
                                        AlixLivePlayback.this.mPlaybackVariables.liveFullInfoData.liveStatus = Integer.valueOf(livePlayControl.liveStatus);
                                        AlixLivePlayback alixLivePlayback = AlixLivePlayback.this;
                                        alixLivePlayback.updateRoomStateWithLiveFullInfo(alixLivePlayback.mPlaybackVariables.liveFullInfoData);
                                    }
                                    AlixLivePlayback.this.mPlaybackVariables.isPK = videoInfo.isLaifengPk;
                                    PlaybackVariables playbackVariables = AlixLivePlayback.this.mPlaybackVariables;
                                    int i5 = videoInfo.mcu;
                                    playbackVariables.isMCU = i5 == 1;
                                    if (i5 == 1 || (i5 == 0 && !videoInfo.isLaifengPk)) {
                                        AlixLivePlayback.this.mPlaybackVariables.hasTwoPlayer = false;
                                    } else {
                                        AlixLivePlayback.this.mPlaybackVariables.hasTwoPlayer = true;
                                    }
                                    AlixLivePlayback.this.mPlaybackVariables.protocol = Protocol.get(videoInfo.protocol);
                                    AlixLivePlayback.this.mPlaybackVariables.videoFormat = videoInfo.videoFormat;
                                    AlixLivePlayback.this.mPlaybackVariables.firstVideoOrientation = videoInfo.landscape ? Orientation.ORIENTATION_LANDSCAPE : Orientation.ORIENTATION_PORTAIT;
                                    AlixLivePlayback.this.mPlayerContext.setLandVideo(videoInfo.landscape);
                                    AlixLivePlayback.this.mPlaybackVariables.screenId = videoInfo.screenId;
                                    AlixLivePlayback.this.mPlaybackVariables.micMode = livePlayControl.micMode;
                                    AlixLivePlayback.this.mPlaybackVariables.pushStreamType = livePlayControl.pushStreamType;
                                    AlixLivePlayback.this.mPlaybackVariables.psid = livePlayControl.psid;
                                    AlixLivePlayback.this.mPlaybackVariables.sceneId = livePlayControl.sceneId;
                                    AlixLivePlayback.this.mPlaybackVariables.reqQuality = livePlayControl.dq;
                                    if (livePlayControl.playerWidget.bgPlay == 0) {
                                        AlixLivePlayback.this.mPlaybackVariables.enableBgPlay = false;
                                    } else {
                                        AlixLivePlayback.this.mPlaybackVariables.enableBgPlay = true;
                                    }
                                    if (!(AlixLivePlayback.this.getEngineInstance() == null || AlixLivePlayback.this.getEngineInstance().getOptions() == null)) {
                                        IEngineInstance engineInstance = AlixLivePlayback.this.getEngineInstance();
                                        boolean z3 = AlixLivePlayback.this.mPlaybackVariables.isPK;
                                        if (!AlixLivePlayback.this.mPlaybackVariables.isMCU) {
                                            i4 = 0;
                                        }
                                        engineInstance.putData("playerPkMcu", Integer.valueOf((z3 ? 1 : 0) + i4));
                                        YKPrefReporter.getInstance().getPlayBySessionId(AlixLivePlayback.this.getEngineInstance().getOptions().getString("onePlayId", "")).setFlowType(livePlayControl.pushStreamType);
                                    }
                                    AlixLivePlayback.this.getEngineInstance().asyncPutData("mtop.youku.live.com.liveplaycontrol", livePlayControl);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("playControl", livePlayControl);
                                    if (videoInfo.isTrail) {
                                        long j = AlixLivePlayback.this.mContext.getSharedPreferences(Utils.PLAYER_WIDGET_SP, 0).getLong(videoInfo.screenId, -1);
                                        Log.e("testLeftTime", "countTime:" + j);
                                        if (j == 0) {
                                            i = 1;
                                            z = false;
                                            hashMap.put("payType", Integer.valueOf(i));
                                            if (z) {
                                                AlixLivePlayback.this.injectorBroadcastPayment(hashMap);
                                            }
                                        }
                                    }
                                    i = 0;
                                    z = true;
                                    hashMap.put("payType", Integer.valueOf(i));
                                    if (z) {
                                    }
                                }
                                if (AlixLivePlayback.this.mPlaybackVariables.firstVideoOrientation == Orientation.ORIENTATION_LANDSCAPE) {
                                    i2 = -16777216;
                                }
                                AlixLivePlayback.this.mPlayerViewRoot.setBackgroundColor(i2);
                                if (AlixLivePlayback.this.mPlaybackVariables.hasTwoPlayer) {
                                    AlixLivePlayback.this.initPlayerPlugin(1);
                                }
                                AlixLivePlayback.this.adjustPlayerLayout();
                                AlixLivePlayback.this.notifyMicCountChanged();
                                return;
                            }
                            return;
                        }
                        BitStream currentBitStream = AlixLivePlayback.this.mPlayerContainer.getVideoStream().getCurrentBitStream();
                        if (currentBitStream != null) {
                            if (currentBitStream.getHeight() > currentBitStream.getWidth()) {
                                AlixLivePlayback.this.mPlaybackVariables.firstVideoOrientation = Orientation.ORIENTATION_PORTAIT;
                            } else {
                                AlixLivePlayback.this.mPlaybackVariables.firstVideoOrientation = Orientation.ORIENTATION_LANDSCAPE;
                            }
                        }
                        AlixPlayerContext alixPlayerContext = AlixLivePlayback.this.mPlayerContext;
                        Orientation orientation = AlixLivePlayback.this.mPlaybackVariables.firstVideoOrientation;
                        Orientation orientation2 = Orientation.ORIENTATION_LANDSCAPE;
                        if (orientation != orientation2) {
                            z2 = false;
                        }
                        alixPlayerContext.setLandVideo(z2);
                        if (AlixLivePlayback.this.mPlaybackVariables.firstVideoOrientation == orientation2) {
                            i2 = -16777216;
                        }
                        AlixLivePlayback.this.mPlayerViewRoot.setBackgroundColor(i2);
                    }
                }, 0);
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-601898029")) {
                    ipChange.ipc$dispatch("-601898029", new Object[]{this, playVideoInfo});
                }
            }
        };
        this.mPromptBtnClickListener = new PromptLayout.OnPromptBtnClickListener() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass18 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.view.PromptLayout.OnPromptBtnClickListener
            public void onBackHome() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1172330524")) {
                    ipChange.ipc$dispatch("-1172330524", new Object[]{this});
                } else if (AlixLivePlayback.this.mContext instanceof Activity) {
                    ((Activity) AlixLivePlayback.this.mContext).finish();
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PromptLayout.OnPromptBtnClickListener
            public void onRefresh() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "200269701")) {
                    ipChange.ipc$dispatch("200269701", new Object[]{this});
                    return;
                }
                AlixLivePlayback alixLivePlayback = AlixLivePlayback.this;
                alixLivePlayback.reqRecordInfo(alixLivePlayback.mPlaybackVariables.currentLiveId);
            }
        };
        this.mLiveRequestCallback = new IVideoRequest.Callback<LiveInfo, List<LiveInfo>>() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass19 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
            public void onFailure(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-73005553")) {
                    ipChange.ipc$dispatch("-73005553", new Object[]{this, videoRequestError});
                } else if (videoRequestError != null) {
                    if (videoRequestError.getErrorCode() != 72001) {
                        videoRequestError.getErrorCode();
                    }
                    AlixLivePlayback.this.callBuyViewEvent(videoRequestError.getLivePlayControl(), 0);
                }
            }

            @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
            public void onStat(Map<String, String> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-788162450")) {
                    ipChange.ipc$dispatch("-788162450", new Object[]{this, map});
                }
            }

            public void onSuccess(LiveInfo liveInfo, List<LiveInfo> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1720423774")) {
                    ipChange.ipc$dispatch("1720423774", new Object[]{this, liveInfo, list});
                }
            }
        };
        this.hasJumpToPage = false;
        this.mEndPageListener = new EndPageView.OnEndPageClickListener() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass24 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.OnEndPageClickListener
            public void onAttentionActor() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "710176590")) {
                    ipChange.ipc$dispatch("710176590", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.OnEndPageClickListener
            public void onExitPage() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1664092616")) {
                    ipChange.ipc$dispatch("-1664092616", new Object[]{this});
                    return;
                }
                AlixLivePlayback.this.showEndPageView(Boolean.FALSE);
                AlixLivePlayback alixLivePlayback = AlixLivePlayback.this;
                alixLivePlayback.reqRecordInfo(alixLivePlayback.mPlaybackVariables.currentLiveId);
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.OnEndPageClickListener
            public void onInjectorCallbackAttention(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1621950540")) {
                    ipChange.ipc$dispatch("-1621950540", new Object[]{this, Boolean.valueOf(z)});
                } else if (AlixLivePlayback.this.mPlaybackVariables != null && AlixLivePlayback.this.mPlaybackVariables.resultGlobalCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("key", AlixLivePlayback.CALLBACK_CONTROLL_ATTENTION);
                    AlixLivePlayback.this.mPlaybackVariables.resultGlobalCallback.onResult(hashMap);
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.OnEndPageClickListener
            public void onJumpToActorPage(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-4214956")) {
                    ipChange.ipc$dispatch("-4214956", new Object[]{this, str});
                    return;
                }
                StringBuilder sb = new StringBuilder("youku://personalchannel/openpersonalchannel?feedtype=YW_ZPD_VIDEO&uid=");
                sb.append(str);
                AlixLivePlayback.this.mContext.startActivity(new Intent((String) null, Uri.parse(String.valueOf(sb))));
                AlixLivePlayback.this.hasJumpToPage = true;
                ((ILog) Dsl.getService(ILog.class)).i(AlixLivePlayback.TAG, "jumpPersonPage  anchorID= " + str);
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.OnEndPageClickListener
            public void onJumpToRecommendPage(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "963936749")) {
                    ipChange.ipc$dispatch("963936749", new Object[]{this, str});
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.OnEndPageClickListener
            public void onJumpToReplayPage(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "652542106")) {
                    ipChange.ipc$dispatch("652542106", new Object[]{this, str, str2});
                } else if (AlixLivePlayback.this.mPlaybackVariables.playRecord) {
                    AlixLivePlayback.this.startPlayingVidBranch(str);
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.OnEndPageClickListener
            public void onJumpToShortVideoPage(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1213509416")) {
                    ipChange.ipc$dispatch("-1213509416", new Object[]{this, str});
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.OnEndPageClickListener
            public void onLogin() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1097173692")) {
                    ipChange.ipc$dispatch("1097173692", new Object[]{this});
                    return;
                }
                try {
                    ((ILogin) Dsl.getService(ILogin.class)).login();
                } catch (Throwable unused) {
                }
            }
        };
        this.mKeyDownDatas = new HashMap();
        this.mRotateFinishRunnable = new DelayedRunnable() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass26 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.AlixLivePlayback.DelayedRunnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-560929767")) {
                    ipChange.ipc$dispatch("-560929767", new Object[]{this});
                    return;
                }
                AlixLivePlayback.this.getEngineInstance().asyncPutData("LFLWDataCenterUnlimitRotate", this.params);
            }
        };
        this.mOnDataSourceListener = new OnDataSourceListener() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass27 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplugin.OnDataSourceListener
            public void onChanged(String str, Object obj, Object obj2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-983002064")) {
                    ipChange.ipc$dispatch("-983002064", new Object[]{this, str, obj, obj2});
                } else if ("isPickMode".equals(str) && AlixLivePlayback.this.mPlaybackVariables != null) {
                    AlixLivePlayback.this.mPlayerContext.put("pick_status", PickStatus.ROTATE_INIT);
                    if (obj2 instanceof Boolean) {
                        if (((Boolean) obj2).booleanValue()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("open", Boolean.TRUE);
                            AlixLivePlayback.this.getEngineInstance().asyncPutData("LFLWDataCenterUnlimitScreen", hashMap);
                            AlixLivePlayback.this.mPlaybackVariables.mRotateStartTime = System.currentTimeMillis();
                        } else {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("open", Boolean.FALSE);
                            AlixLivePlayback.this.getEngineInstance().asyncPutData("LFLWDataCenterUnlimitScreen", hashMap2);
                            if (!(AlixLivePlayback.this.mPlaybackVariables.mRotateStartTime == 0 || AlixLivePlayback.this.mPlayerContainer == null || AlixLivePlayback.this.mPlayerContainer.getPlayerTrack() == null || AlixLivePlayback.this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack() == null)) {
                                AlixLivePlayback.this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack().setRotateStayTime((System.currentTimeMillis() - AlixLivePlayback.this.mPlaybackVariables.mRotateStartTime) + AlixLivePlayback.this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack().getRotateStayTime());
                            }
                            if (AlixLivePlayback.this.mPlaybackVariables.resultRotateCallback != null) {
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("key", AlixLivePlayback.CALLBACK_OROTATE_EXIT);
                                AlixLivePlayback.this.mPlaybackVariables.resultRotateCallback.onResult(hashMap3);
                            }
                        }
                    }
                    AlixLivePlayback.this.adjustPlayerLayout();
                }
            }
        };
    }

    private void addEndPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163418933")) {
            ipChange.ipc$dispatch("-163418933", new Object[]{this});
            return;
        }
        ViewGroup rootView = getEngineInstance().getRootView();
        if (rootView != null) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "parentExist true");
            rootView.addView(this.mEndPageView, new ViewGroup.LayoutParams(-1, -1));
            this.mEndPageView.bringToFront();
        }
    }

    private void adjustCSSLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2119120312")) {
            ipChange.ipc$dispatch("2119120312", new Object[]{this});
        } else if (!this.isUnLimitedOpen) {
            PlaybackVariables playbackVariables = this.mPlaybackVariables;
            if (playbackVariables.freeLayout) {
                CSSLayout.LayoutParams layoutParams = new CSSLayout.LayoutParams(-1, -1);
                WidgetAttributesModel.OrientationModel orientationModel = new WidgetAttributesModel.OrientationModel();
                layoutParams.portraitModel = orientationModel;
                orientationModel.margin = new WidgetAttributesModel.MarginModel();
                layoutParams.portraitModel.margin.l = 0;
                layoutParams.portraitModel.margin.t = 0;
                layoutParams.portraitModel.margin.r = 0;
                layoutParams.portraitModel.margin.b = 0;
                this.mWidgetRootView.setLayoutParams(layoutParams);
                return;
            }
            LayoutVariables layoutVariables = this.mLayoutVariables;
            if (layoutVariables.decodedLayout != null) {
                adjustCSSLayoutWithModel(layoutVariables.getLayoutModel());
            } else if (playbackVariables.firstVideoOrientation == Orientation.ORIENTATION_PORTAIT) {
                adjustCSSLayoutWithModel(layoutVariables.getPortraitLayoutModel());
            } else {
                adjustCSSLayoutWithModel(layoutVariables.getLandscapeLayoutModel());
            }
        }
    }

    private void adjustCSSLayoutWithModel(WidgetAttributesModel widgetAttributesModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070906084")) {
            ipChange.ipc$dispatch("2070906084", new Object[]{this, widgetAttributesModel});
        } else if (this.mWidgetRootView != null && widgetAttributesModel != null) {
            Log.i("liulei-play", "adjustCSSLayoutWithModel");
            ViewGroup.LayoutParams layoutParams = this.mWidgetRootView.getLayoutParams();
            CSSLayout.LayoutParams layoutParams2 = null;
            if (layoutParams == null) {
                layoutParams2 = new CSSLayout.LayoutParams(UIUtils.getScreenWidth(this.mContext), UIUtils.getScreenHeight(this.mContext));
            } else if (layoutParams instanceof CSSLayout.LayoutParams) {
                Log.i("liulei-play", "clLp = (CSSLayout.LayoutParams)vgLp;");
                layoutParams2 = (CSSLayout.LayoutParams) layoutParams;
            }
            if (layoutParams2 != null) {
                WidgetAttributesModel.OrientationModel orientationModel = widgetAttributesModel.portrait;
                if (!(orientationModel == null || orientationModel.dimensions == null)) {
                    orientationModel.aspectRatio = Double.valueOf(1.0d);
                    widgetAttributesModel.portrait.dimensions.w = Integer.valueOf(UIUtils.getScreenWidth(this.mContext));
                    widgetAttributesModel.portrait.dimensions.h = Integer.valueOf(UIUtils.getScreenHeight(this.mContext));
                }
                WidgetAttributesModel.OrientationModel orientationModel2 = widgetAttributesModel.landscape;
                if (!(orientationModel2 == null || orientationModel2.dimensions == null)) {
                    orientationModel2.aspectRatio = Double.valueOf(1.0d);
                    widgetAttributesModel.landscape.dimensions.w = Integer.valueOf(UIUtils.getScreenWidth(this.mContext));
                    widgetAttributesModel.landscape.dimensions.h = Integer.valueOf(UIUtils.getScreenHeight(this.mContext));
                }
                WidgetAttributesModel.OrientationModel orientationModel3 = widgetAttributesModel.portrait;
                layoutParams2.portraitModel = orientationModel3;
                WidgetAttributesModel.OrientationModel orientationModel4 = widgetAttributesModel.landscape;
                if (orientationModel4 != null) {
                    orientationModel3 = orientationModel4;
                }
                layoutParams2.landscapeModel = orientationModel3;
                this.mWidgetRootView.setLayoutParams(layoutParams2);
                this.mWidgetRootView.requestLayout();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void adjustPlayerLayout() {
        int videoHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1871688774")) {
            ipChange.ipc$dispatch("-1871688774", new Object[]{this});
        } else if (!this.isUnLimitedOpen) {
            IPlayer player = getPlayer(0);
            if (!(player == null || player.getResizer() == null)) {
                if (isPickMode()) {
                    player.getResizer().setVideoCutMode(3);
                } else {
                    PlaybackVariables playbackVariables = this.mPlaybackVariables;
                    if (playbackVariables.firstVideoOrientation == Orientation.ORIENTATION_PORTAIT) {
                        int videoWidth = player.getVideoWidth();
                        if (videoWidth <= 0 || (videoHeight = player.getVideoHeight()) <= 0) {
                            player.getResizer().setVideoCutMode(4);
                        } else if ((((float) videoWidth) * 1.0f) / ((float) videoHeight) < 1.0f) {
                            player.getResizer().setVideoCutMode(4);
                        } else {
                            this.mPlaybackVariables.firstVideoOrientation = Orientation.ORIENTATION_LANDSCAPE;
                            player.getResizer().setVideoCutMode(0);
                        }
                    } else if (playbackVariables.isPK) {
                        player.getResizer().setVideoCutMode(4);
                    } else {
                        player.getResizer().setVideoCutMode(0);
                    }
                }
            }
            ViewGroup playerPluginLayout = getPlayerPluginLayout(1);
            if (this.mPlaybackVariables.hasTwoPlayer) {
                IPlayer player2 = getPlayer(1);
                if (!(player2 == null || player2.getResizer() == null)) {
                    if (this.mPlaybackVariables.secondVideoOrientation == Orientation.ORIENTATION_PORTAIT) {
                        player2.getResizer().setVideoCutMode(4);
                    } else {
                        player2.getResizer().setVideoCutMode(0);
                    }
                }
                if (playerPluginLayout != null) {
                    playerPluginLayout.setVisibility(0);
                    playerPluginLayout.requestLayout();
                }
            } else if (playerPluginLayout != null) {
                playerPluginLayout.setVisibility(8);
            }
            updatePlayerViewport();
        }
    }

    private void bindDagoChannel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104918645")) {
            ipChange.ipc$dispatch("1104918645", new Object[]{this});
            return;
        }
        DagoChannelPlugin dagoChannelPlugin = this.mChannelPlugin;
        if (dagoChannelPlugin == null || dagoChannelPlugin.getEngineInstance() != getEngineInstance()) {
            IPlugin findPluginByName = getEngineInstance().findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                this.mChannelPlugin = (DagoChannelPlugin) findPluginByName;
            }
        }
        DagoChannelPlugin dagoChannelPlugin2 = this.mChannelPlugin;
        if (dagoChannelPlugin2 != null) {
            dagoChannelPlugin2.addListener(this);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void callBuyViewEvent(LivePlayControl livePlayControl, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "719700325")) {
            ipChange.ipc$dispatch("719700325", new Object[]{this, livePlayControl, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("playControl", livePlayControl);
        hashMap.put("payType", Integer.valueOf(i));
        injectorBroadcastPayment(hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private PlayVideoInfo createDefaultVideoInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793945899")) {
            return (PlayVideoInfo) ipChange.ipc$dispatch("-793945899", new Object[]{this, str});
        }
        PlayVideoInfo playVideoInfo = new PlayVideoInfo(str);
        if (!TextUtils.isEmpty(this.mUniqueKey)) {
            playVideoInfo.putString("uniqueKey", this.mUniqueKey);
            playVideoInfo.putString("navthenplay", "1");
        }
        this.mUniqueKey = null;
        return playVideoInfo;
    }

    private void destoryPIP() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115272495")) {
            ipChange.ipc$dispatch("-115272495", new Object[]{this});
        }
    }

    private void ensureEndPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193464202")) {
            ipChange.ipc$dispatch("193464202", new Object[]{this});
            return;
        }
        if (this.mEndPageView == null) {
            this.mEndPageView = new EndPageView(this.mContext);
        }
        if (this.mEndPageView.getParent() == null) {
            this.mEndPageView.setOnEndPageClickListener(this.mEndPageListener);
            addEndPage();
        }
    }

    private void ensureHandlerThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199059936")) {
            ipChange.ipc$dispatch("-1199059936", new Object[]{this});
            return;
        }
        HandlerThread handlerThread = this.mPlayerThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            HandlerThread handlerThread2 = new HandlerThread(PLAYER_THREAD_NAME);
            this.mPlayerThread = handlerThread2;
            handlerThread2.start();
            this.mPlayerHandler = new PlayerHandler(this.mPlayerThread.getLooper(), this);
        }
    }

    private void getAttentionState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502235443")) {
            ipChange.ipc$dispatch("-502235443", new Object[]{this});
            return;
        }
        EndPageView endPageView = this.mEndPageView;
        if (endPageView != null && this.hasJumpToPage) {
            endPageView.getData(this.mPlaybackVariables.currentLiveId);
        }
    }

    private View getDanmuView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-368127090")) {
            return (View) ipChange.ipc$dispatch("-368127090", new Object[]{this});
        }
        DanmuPlugin danmuPlugin = (DanmuPlugin) this.mPlayerContext.getPluginManager(this.mNonplayerViewContainer).getPlugin("danmu");
        if (danmuPlugin != null) {
            return danmuPlugin.getDanmuView();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @Nullable
    private IPlayer getPlayer(@PlayerIndex int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519914326")) {
            return (IPlayer) ipChange.ipc$dispatch("519914326", new Object[]{this, Integer.valueOf(i)});
        } else if (i >= 2 || i < 0) {
            throw new IllegalArgumentException("Call getPlayer with index out of range(0-2)");
        } else if (i == 0) {
            return this.mPlayerContainer.getPlayer();
        } else {
            return this.mPlayerContainer.getMultiPlayer().getPlayer(i - 1);
        }
    }

    @Nullable
    private ViewGroup getPlayerPluginLayout(@PlayerIndex int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453569908")) {
            return (ViewGroup) ipChange.ipc$dispatch("1453569908", new Object[]{this, Integer.valueOf(i)});
        }
        ViewGroup[] viewGroupArr = this.mPlayerViewContainers;
        if (viewGroupArr.length > i && i >= 0) {
            return viewGroupArr[i];
        }
        throw new IllegalArgumentException("Call getPlayerPluginLayout with index out of range(0-2)");
    }

    private View getView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309939399")) {
            return (View) ipChange.ipc$dispatch("309939399", new Object[]{this, str});
        } else if ("danmu".equals(str)) {
            return getDanmuView();
        } else {
            return null;
        }
    }

    private void initMisc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802806344")) {
            ipChange.ipc$dispatch("-1802806344", new Object[]{this});
            return;
        }
        NtpSyncUtils.startNTPSync();
        if (mPlayerAudioFocusManager == null) {
            mPlayerAudioFocusManager = new PlayerAudioFocusManager(this.mContext.getApplicationContext());
        }
        IPlugin findPluginByName = getEngineInstance().findPluginByName("DagoChannel");
        if (findPluginByName instanceof DagoChannelPlugin) {
            this.mChannelPlugin = (DagoChannelPlugin) findPluginByName;
        }
        this.mPlayerThread.start();
        this.mPlayerHandler = new PlayerHandler(this.mPlayerThread.getLooper(), this);
        this.mUsingRemoteCover = "true".equals(ConfigFetcher.getInstance().getConfig("laifeng_config", "using_remote_cover", "false"));
    }

    private void initPIP(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231015425")) {
            ipChange.ipc$dispatch("1231015425", new Object[]{this, activity});
            return;
        }
        TinyWindowConfig tinyWindowConfig = new TinyWindowConfig(activity, TinyWindowConfig.TINYWINDOW_TYPE.FLOATINGWINDOW);
        tinyWindowConfig.setPlayerRootContainer(this.mWidgetRootView);
        tinyWindowConfig.setPlayerView(this.mPlayerViewRoot);
        tinyWindowConfig.setPlayerType(1);
        tinyWindowConfig.setPlayerId(this.mPlaybackVariables.currentLiveId);
        this.mPlayerContainer.getPlayVideoInfo().putString("isTinyWindowPlay", "1");
        tinyWindowConfig.setLivePlayer(this.mPlayerContainer);
        TinyWindowManager.getInstance().updateConfig(tinyWindowConfig);
        TinyWindowManager.getInstance().setTinyWindowListener(new TinyWindowListener() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.tinywindow.TinyWindowListener
            public void onTinyWindowShowFailed(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1354538635")) {
                    ipChange.ipc$dispatch("1354538635", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                AlixLivePlayback.this.getEngineInstance().asyncPutData("enterPipResult", 0);
            }

            @Override // com.youku.tinywindow.TinyWindowListener
            public void onTinyWindowShowSuccess() {
                IpChange ipChange = $ipChange;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange, "57008946")) {
                    ipChange.ipc$dispatch("57008946", new Object[]{this});
                    return;
                }
                AlixLivePlayback.this.mPlaybackVariables.isPlayerTakenByWindow = true;
                AlixLivePlayback.this.getEngineInstance().asyncPutData("enterPipResult", 0);
                if (AlixLivePlayback.this.mPlayerContainer.getPlayVideoInfo() != null) {
                    String string = AlixLivePlayback.this.mPlayerContainer.getPlayVideoInfo().getString("tinywindowNumOfEnter");
                    if (TextUtils.isEmpty(string)) {
                        i = 1;
                    } else {
                        try {
                            i = Integer.parseInt(string) + 1;
                        } catch (Exception unused) {
                        }
                    }
                    AlixLivePlayback.this.mPlayerContainer.getPlayVideoInfo().putString("tinywindowNumOfEnter", String.valueOf(i));
                    AlixLivePlayback.this.mPlayerContainer.getPlayVideoInfo().putString("tinyWindowType", "1");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initPlayerPlugin(@PlayerIndex int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246305325")) {
            ipChange.ipc$dispatch("-246305325", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mPlayerViewContainers.length <= i || i < 0) {
            throw new IllegalArgumentException("Call initPlayerPlugin with index out of range(0-2)");
        } else {
            IPlayer player = getPlayer(i);
            if (player != null) {
                OnStateChangeListener[] onStateChangeListenerArr = this.mOnStateChangeListeners;
                if (onStateChangeListenerArr.length > i) {
                    player.addOnPlayerStateListener(onStateChangeListenerArr[i]);
                }
                OnInfoListener[] onInfoListenerArr = this.mOnInfoListeners;
                if (onInfoListenerArr.length > i) {
                    player.addOnInfoListener(onInfoListenerArr[i]);
                }
                OnVideoSizeChangedListener[] onVideoSizeChangedListenerArr = this.mOnVideoSizeChangedListeners;
                if (onVideoSizeChangedListenerArr.length > i) {
                    player.addOnVideoSizeChangedListener(onVideoSizeChangedListenerArr[i]);
                }
                ViewGroup[] viewGroupArr = this.mPlayerViewContainers;
                if (viewGroupArr[i] == null) {
                    viewGroupArr[i] = new FrameLayout(this.mContext);
                    this.mPlayerViewRoot.addView(this.mPlayerViewContainers[i], new LinearLayout.LayoutParams(-1, -1, 1.0f));
                    this.mPlayerContext.loadPlugins(PluginsHelper.initPlayerPluginConfigs(this.mContext, i), this.mPlayerViewContainers[i]);
                    return;
                }
                ViewGroup viewGroup = viewGroupArr[i];
                if (!(viewGroup.getParent() == null || viewGroup.getParent() == this.mPlayerViewRoot)) {
                    ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                }
                if (viewGroup.getParent() == null) {
                    this.mPlayerViewRoot.addView(viewGroup, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0126  */
    private boolean initPlayerRelatedStuff() {
        String str;
        CostTime costTime;
        PlayerContextContainer playerContext;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "635214750")) {
            return ((Boolean) ipChange.ipc$dispatch("635214750", new Object[]{this})).booleanValue();
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            IProps options = getEngineInstance().getOptions();
            boolean z2 = options != null && isOnWall(options);
            if (options != null && isTiny(options)) {
                IPlayerContainer livePlayer = TinyWindowManager.getInstance().getConfig().getLivePlayer();
                this.mPlayerContainer = livePlayer;
                livePlayer.getVideoStreamListeners().clear();
                this.mPlayerContainer.resetListeners();
            } else if (z2) {
                try {
                    CostTime costTime2 = new CostTime();
                    this.pageCostTs = costTime2;
                    costTime2.clickTs = Long.parseLong(options.getString(LiveRoomConstants.PLAY_CLICK_TIME, "0"));
                    this.pageCostTs.navTs = Long.parseLong(options.getString(LiveRoomConstants.PLAY_NAV_TIME, "0"));
                    this.pageCostTs.activityCreateTs = Long.parseLong(options.getString(LiveRoomConstants.PLAY_ACTIVITY_CREATE_TIME, "0"));
                } catch (Exception unused) {
                    this.pageCostTs = null;
                }
                str = options.getString(Utils.DATA_COME_IN_PLAYCONTROLLER_UNIQUEKEY, null);
                if (!TextUtils.isEmpty(str)) {
                    IPlayerContainer playerContainer = PlayerPreloader.getInstance().getPlayerContainer(str, this.mContext);
                    this.mPlayerContainer = playerContainer;
                    if (playerContainer != null) {
                        playerContainer.setVideoRequestFactory(new FactoryWithPreloader());
                        if (this.mPlayerContainer == null) {
                            IPlayerContainer playerContainer2 = PlayerPreloader.getInstance().getPlayerContainer(this.mContext);
                            this.mPlayerContainer = playerContainer2;
                            playerContainer2.setVideoRequestFactory(new FactoryWithPreloader());
                        }
                        if (z2) {
                            this.mPlayerContainer.getPlayerTrack().putString("isOnWall", "1");
                        }
                        costTime = this.pageCostTs;
                        if (costTime != null) {
                            putTimestamp("clickTs", costTime.clickTs);
                            putTimestamp("navTs", this.pageCostTs.navTs);
                            putTimestamp("pageCreateTs", this.pageCostTs.activityCreateTs);
                            this.pageCostTs = null;
                        }
                        this.mPlayerContainer.addVideoStreamListener(this.mOnVideoStreamListener);
                        if (!TextUtils.isEmpty(str) && (playerContext = PlayerContextPreloader.INSTANCE.getPlayerContext(str)) != null) {
                            this.mPlayerContext = playerContext.getPlayerContext();
                            this.mPlayerViewContainers[0] = playerContext.getPlayerView();
                            this.mUniqueKey = str;
                        }
                        if (this.mPlayerContext == null) {
                            AlixPlayerContext alixPlayerContext = new AlixPlayerContext(activity, false, Utils.getDefaultPlayerConfig(this.mContext));
                            this.mPlayerContext = alixPlayerContext;
                            alixPlayerContext.setDefaultCreator(new AlixPluginCreator());
                        }
                        this.mPlayerContext.addDataSourceListener(this.mOnDataSourceListener);
                        this.mPlayerContext.setPlayerContainer(this.mPlayerContainer);
                        return z;
                    }
                }
                z = false;
                if (this.mPlayerContainer == null) {
                }
                if (z2) {
                }
                costTime = this.pageCostTs;
                if (costTime != null) {
                }
                this.mPlayerContainer.addVideoStreamListener(this.mOnVideoStreamListener);
                this.mPlayerContext = playerContext.getPlayerContext();
                this.mPlayerViewContainers[0] = playerContext.getPlayerView();
                this.mUniqueKey = str;
                if (this.mPlayerContext == null) {
                }
                this.mPlayerContext.addDataSourceListener(this.mOnDataSourceListener);
                this.mPlayerContext.setPlayerContainer(this.mPlayerContainer);
                return z;
            } else {
                this.pageCostTs = null;
            }
            str = null;
            z = false;
            if (this.mPlayerContainer == null) {
            }
            if (z2) {
            }
            costTime = this.pageCostTs;
            if (costTime != null) {
            }
            this.mPlayerContainer.addVideoStreamListener(this.mOnVideoStreamListener);
            this.mPlayerContext = playerContext.getPlayerContext();
            this.mPlayerViewContainers[0] = playerContext.getPlayerView();
            this.mUniqueKey = str;
            if (this.mPlayerContext == null) {
            }
            this.mPlayerContext.addDataSourceListener(this.mOnDataSourceListener);
            this.mPlayerContext.setPlayerContainer(this.mPlayerContainer);
            return z;
        }
        throw new RuntimeException("context not instance of Activity, abort");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initPlugins(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1392616754")) {
            ipChange.ipc$dispatch("-1392616754", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.mPlayerViewRoot = linearLayout;
        linearLayout.setContentDescription("playerViewRoot");
        this.mPlayerViewRoot.setTag("playerViewRoot");
        this.mPlayerViewRoot.setOrientation(0);
        this.mPlayerViewRoot.setOnTouchListener(this.mPlayerLayoutTouchListener);
        this.mNonplayerViewContainer = new FrameLayout(this.mContext);
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mTopViewContainer = frameLayout;
        frameLayout.setTag("topViewRoot");
        PlayBackCover playBackCover = new PlayBackCover(this.mContext);
        this.mCoverImageView = playBackCover;
        playBackCover.setScaleType(ImageView.ScaleType.CENTER_CROP);
        PromptLayout promptLayout = new PromptLayout(this.mContext);
        this.mPromptLayout = promptLayout;
        promptLayout.setOnPromptBtnClickListener(this.mPromptBtnClickListener);
        IProps options = getEngineInstance().getOptions();
        if (options != null) {
            options.getString("liveid", null);
        }
        if (this.mPlayerContainer.getPlayVideoInfo() != null && "1".equals(this.mPlayerContainer.getPlayVideoInfo().getString("isTinyWindowPlay"))) {
            TinyWindowManager.getInstance().closeTinyWindow();
        }
        this.mWidgetRootView.addView(this.mPlayerViewRoot, new ViewGroup.LayoutParams(-1, -1));
        this.mWidgetRootView.addView(this.mNonplayerViewContainer, new ViewGroup.LayoutParams(-1, -1));
        this.mWidgetRootView.addView(this.mPromptLayout, new ViewGroup.LayoutParams(-1, -1));
        getEngineInstance().getRootView().addView(this.mTopViewContainer, new ViewGroup.LayoutParams(-1, -1));
        this.mCSSRootView.addView(this.mCoverImageView, new ViewGroup.LayoutParams(-1, -1));
        putTimestamp("initPlayerPluginTs", System.currentTimeMillis());
        initPlayerPlugin(0);
        putTimestamp("loadPluginsTs", System.currentTimeMillis());
        this.mPlayerContext.loadPlugins(PluginsHelper.initNonPlayerPluginConfigs(this.mContext), this.mNonplayerViewContainer);
        this.mPlayerContext.loadPlugins(PluginsHelper.initTopLayerPluginConfigs(), this.mTopViewContainer);
        this.mAlixPlayerTrack = new AlixPlayerTrack(this.mPlayerContext, this.mPlayerContainer);
        if (this.mPlayerContainer.getPlayVideoInfo() == null) {
            return;
        }
        if (z) {
            this.mAlixPlayerTrack.onPreloadNewTrack(this.mPlayerContainer.getPlayVideoInfo());
            runOnUIThread(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "719572925")) {
                        ipChange.ipc$dispatch("719572925", new Object[]{this});
                        return;
                    }
                    if (!(AlixLivePlayback.this.mPlayerContainer.getPlayer() == null || AlixLivePlayback.this.mPlayerContainer.getPlayer().getVideoStream() == null || AlixLivePlayback.this.mPlayerContainer.getPlayer().getVideoStream().getYoukuVideoInfo() == null)) {
                        YoukuVideoInfo youkuVideoInfo = AlixLivePlayback.this.mPlayerContainer.getPlayer().getVideoStream().getYoukuVideoInfo();
                        for (OnVideoStreamListener onVideoStreamListener : AlixLivePlayback.this.mPlayerContainer.getVideoStreamListeners()) {
                            onVideoStreamListener.onDataReady(youkuVideoInfo);
                        }
                    }
                    IPlayer player = AlixLivePlayback.this.getPlayer(0);
                    if (player != null) {
                        IAlixPlayer.State currentState = player.getCurrentState();
                        if (currentState == IAlixPlayer.State.STATE_VIDEO_STARTED || currentState == IAlixPlayer.State.STATE_PRE_AD_STARTED) {
                            AlixLivePlayback.this.mOnStateChangeListeners[0].onStateChange(IAlixPlayer.State.STATE_PREPARED, currentState);
                        }
                    }
                }
            });
        } else if ("1".equals(this.mPlayerContainer.getPlayVideoInfo().getString("isTinyWindowPlay"))) {
            runOnUIThread(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IAlixPlayer.State currentState;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "523059420")) {
                        ipChange.ipc$dispatch("523059420", new Object[]{this});
                        return;
                    }
                    for (OnVideoStreamListener onVideoStreamListener : AlixLivePlayback.this.mPlayerContainer.getVideoStreamListeners()) {
                        onVideoStreamListener.onDataReady(TinyWindowManager.getInstance().getConfig().getLivePlayer().getVideoStream().getYoukuVideoInfo());
                    }
                    IPlayer player = AlixLivePlayback.this.getPlayer(0);
                    if (player != null && ((currentState = player.getCurrentState()) == IAlixPlayer.State.STATE_VIDEO_STARTED || currentState == IAlixPlayer.State.STATE_PRE_AD_STARTED)) {
                        for (OnVideoSizeChangedListener onVideoSizeChangedListener : player.getOnVideoSizeChangedListeners()) {
                            onVideoSizeChangedListener.onVideoSizeChange(player.getVideoWidth(), player.getVideoHeight());
                        }
                        for (OnStateChangeListener onStateChangeListener : player.getOnPlayerStateListeners()) {
                            onStateChangeListener.onStateChange(IAlixPlayer.State.STATE_PREPARED, currentState);
                        }
                    }
                    if (AlixLivePlayback.this.mPlayerContainer.getPlayVideoInfo().getString("sceneId") != null) {
                        AlixLivePlayback.this.mPlayerContext.put("sceneId", AlixLivePlayback.this.mPlayerContainer.getPlayVideoInfo().getString("sceneId"));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void injectorBroadcastPayment(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2015376586")) {
            ipChange.ipc$dispatch("2015376586", new Object[]{this, map});
            return;
        }
        getEngineInstance().asyncPutData("LFLWDataCenterPlayerPaymentStateKey", map, "javascript");
        getEngineInstance().asyncPutData("LFLWDataCenterPlayerPaymentStateKey", map);
    }

    private void injectorCallbackControllerVisible(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383973573")) {
            ipChange.ipc$dispatch("-1383973573", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mPlayerControlViewIsVisibility = Boolean.valueOf(z);
        IDagoLivePlaybackInjectorInterface.IResultListener iResultListener = this.mPlaybackVariables.resultGlobalCallback;
        if (iResultListener != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("key", CALLBACK_CONTROLL_VISIBLE_CHANGED);
            hashMap.put("hidden", z ? "0" : "1");
            iResultListener.onResult(hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void injectorCallbackPause(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "96764651")) {
            ipChange.ipc$dispatch("96764651", new Object[]{this, Long.valueOf(j)});
            return;
        }
        injectorCallbackPlayPause("pause", j);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void injectorCallbackPlay(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130920541")) {
            ipChange.ipc$dispatch("2130920541", new Object[]{this, Long.valueOf(j)});
            return;
        }
        injectorCallbackPlayPause(Constants.Value.PLAY, j);
    }

    private void injectorCallbackPlayPause(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587907021")) {
            ipChange.ipc$dispatch("587907021", new Object[]{this, str, Long.valueOf(j)});
            return;
        }
        this.mPlayerPlayAndPause = str;
        this.mPlayerPlayAndPauseTS = Long.valueOf(j);
        IDagoLivePlaybackInjectorInterface.IResultListener iResultListener = this.mPlaybackVariables.resultGlobalCallback;
        if (iResultListener != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("key", CALLBACK_CONTROLL_PLAY_PAUSE);
            hashMap.put("type", str);
            hashMap.put("ts", Long.valueOf(j));
            iResultListener.onResult(hashMap);
        }
    }

    private void injectorCallbackSeek(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248413089")) {
            ipChange.ipc$dispatch("1248413089", new Object[]{this, Long.valueOf(j)});
            return;
        }
        PlaybackVariables playbackVariables = this.mPlaybackVariables;
        playbackVariables.playerSeek = j;
        IDagoLivePlaybackInjectorInterface.IResultListener iResultListener = playbackVariables.resultGlobalCallback;
        if (iResultListener != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("key", CALLBACK_CONTROLL_SEEK);
            hashMap.put("value", Long.valueOf(j));
            iResultListener.onResult(hashMap);
        }
    }

    private void injectorCallbackTimeShift(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037707226")) {
            ipChange.ipc$dispatch("1037707226", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        this.mPlayerControlDidSelectTimeShiftSeekTime = Long.valueOf(j);
        this.mPlayerControlDidSelectTimeShiftSeekStartTime = Long.valueOf(j2);
        IDagoLivePlaybackInjectorInterface.IResultListener iResultListener = this.mPlaybackVariables.resultGlobalCallback;
        if (iResultListener != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("key", CALLBACK_CONTROLL_TIME_SHIFT);
            hashMap.put("seekTime", String.valueOf(j));
            hashMap.put("seekStartTime", String.valueOf(j2));
            iResultListener.onResult(hashMap);
        }
    }

    private void injectorInsertView2ControlPlugin(List<Map<String, Object>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1077182869")) {
            ipChange.ipc$dispatch("1077182869", new Object[]{this, list});
            return;
        }
        ((VerticalSmallscreenPlugin) this.mPlayerContext.getPluginManager(this.mNonplayerViewContainer).getPlugin(PluginName.PLAYER_VERTICAL_SMALLSCREEN_CONTROL)).bindData(list);
        ((HorizontalFullscreenPlugin) this.mPlayerContext.getPluginManager(this.mNonplayerViewContainer).getPlugin(PluginName.PLAYER_HORIZONTAL_FULLSCREEN_CONTROL)).bindData(list);
        adjustPlayerLayout();
    }

    private boolean isOnWall() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558285723")) {
            return ((Boolean) ipChange.ipc$dispatch("-558285723", new Object[]{this})).booleanValue();
        }
        IProps options = getEngineInstance().getOptions();
        if (options == null || !isOnWall(options)) {
            return false;
        }
        return true;
    }

    private boolean isPickMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2022205398")) {
            return ((Boolean) ipChange.ipc$dispatch("-2022205398", new Object[]{this})).booleanValue();
        }
        Object obj = this.mPlayerContext.get("isPickMode");
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    private boolean isPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012240042")) {
            return ((Boolean) ipChange.ipc$dispatch("-1012240042", new Object[]{this})).booleanValue();
        } else if (this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_STARTED || this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_MID_AD_STARTED || this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_POST_AD_STARTED || this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_PRE_VIP_STARTED || this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isTiny(@NotNull IProps iProps) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1348731250")) {
            return TinyWindowManager.getInstance().getConfig() != null && TinyWindowManager.getInstance().isInTinyWindowMode() && iProps != null && TinyWindowManager.getInstance().getConfig().getPlayerId().equals(iProps.getString("liveid", null));
        }
        return ((Boolean) ipChange.ipc$dispatch("-1348731250", new Object[]{this, iProps})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadLazyPlugins() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759181360")) {
            ipChange.ipc$dispatch("759181360", new Object[]{this});
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "326545915")) {
                    ipChange.ipc$dispatch("326545915", new Object[]{this});
                    return;
                }
                AlixLivePlayback.this.mPlayerContext.loadLazyPlugins(AlixLivePlayback.this.mNonplayerViewContainer);
            }
        }, 300);
    }

    private void mute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-621212647")) {
            ipChange.ipc$dispatch("-621212647", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        TLogUtil.playLog("静音：" + z + " liveId：" + this.mPlaybackVariables.currentLiveId, this.mPlayerContainer.getPlayer());
        try {
            this.mPlayerContainer.getPlayer().setMute(z);
            this.mPlayerContainer.getMultiPlayer().setMute(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyMicCountChanged() {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "566511379")) {
            ipChange.ipc$dispatch("566511379", new Object[]{this});
            return;
        }
        if (this.mPlaybackVariables.isPK) {
            i = 2;
        }
        Logger.d(WIDGET_NAME, "onMicCountNotify:" + i);
        getEngineInstance().asyncPutData("dagoLivePlaybackMicCountNotify", Integer.valueOf(i));
    }

    private void onLiveFullInfoAcquired(LiveFullInfoData liveFullInfoData) {
        TemplateDTO templateDTO;
        String str;
        Boolean bool;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237340764")) {
            ipChange.ipc$dispatch("237340764", new Object[]{this, liveFullInfoData});
            return;
        }
        if ((liveFullInfoData.liveId + "").equals(this.mPlaybackVariables.currentLiveId)) {
            PlaybackVariables playbackVariables = this.mPlaybackVariables;
            playbackVariables.liveFullInfoData = liveFullInfoData;
            TemplateDTO templateDTO2 = liveFullInfoData.template;
            if (templateDTO2 == null || (bool = templateDTO2.landScape) == null) {
                Orientation orientation = Orientation.ORIENTATION_PORTAIT;
                playbackVariables.streamOrientation = orientation;
                playbackVariables.firstVideoOrientation = orientation;
            } else {
                playbackVariables.streamOrientation = bool.booleanValue() ? Orientation.ORIENTATION_LANDSCAPE : Orientation.ORIENTATION_PORTAIT;
                PlaybackVariables playbackVariables2 = this.mPlaybackVariables;
                playbackVariables2.firstVideoOrientation = playbackVariables2.streamOrientation;
            }
            updateRoomStateWithLiveFullInfo(this.mPlaybackVariables.liveFullInfoData);
            this.mPlayerContext.getPlayerConfig().getExtras().putString(TableField.PLAYER_SOURCE, liveFullInfoData.bizType.intValue() == 3 ? "12" : "11");
            this.mAlixPlayerTrack.onLiveFullInfoReady(liveFullInfoData);
            LayoutVariables layoutVariables = this.mLayoutVariables;
            if (layoutVariables.decodedLayout == null && layoutVariables.decodedLandscapeLayout == null && layoutVariables.decodedPortraitLayout == null && (templateDTO = liveFullInfoData.template) != null) {
                String str2 = templateDTO.layout;
                List<LiveBundleLayout> list = templateDTO.layoutList;
                String str3 = null;
                if (list == null || list.size() <= 0) {
                    str = null;
                } else {
                    str = null;
                    for (LiveBundleLayout liveBundleLayout : liveFullInfoData.template.layoutList) {
                        String str4 = liveBundleLayout.type;
                        if (str4 == LiveBundleLayout.TYPE_LANDSCAPE) {
                            str3 = liveBundleLayout.layout;
                        } else if (str4 == LiveBundleLayout.TYPE_VERTICAL) {
                            str = liveBundleLayout.layout;
                        }
                    }
                }
                if (str2 != null && str3 != null && str != null) {
                    this.mLayoutVariables.updateLayout(new String(Base64.decode(str2, 0)), new String(Base64.decode(str3, 0)), new String(Base64.decode(str, 0)));
                    int i = AnonymousClass28.$SwitchMap$com$youku$live$widgets$protocol$Orientation[this.mPlaybackVariables.roomOrientation.ordinal()];
                    if (i == 1) {
                        LayoutVariables layoutVariables2 = this.mLayoutVariables;
                        adjustCSSLayoutWithModel(layoutVariables2.decodedLandscapeLayout == null ? layoutVariables2.getLayoutModel() : layoutVariables2.getLandscapeLayoutModel());
                    } else if (i == 2) {
                        LayoutVariables layoutVariables3 = this.mLayoutVariables;
                        adjustCSSLayoutWithModel(layoutVariables3.decodedPortraitLayout == null ? layoutVariables3.getLayoutModel() : layoutVariables3.getPortraitLayoutModel());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onLiveStateChange(LiveStateChangeBean liveStateChangeBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-835106112")) {
            ipChange.ipc$dispatch("-835106112", new Object[]{this, liveStateChangeBean});
            return;
        }
        if (liveStateChangeBean.st != 1) {
            z = false;
        }
        if (z) {
            LayoutVariables layoutVariables = this.mLayoutVariables;
            layoutVariables.updateLayout(liveStateChangeBean.ext.landScape ? layoutVariables.decodedLandscapeLayout : layoutVariables.decodedPortraitLayout, layoutVariables.decodedLandscapeLayout, layoutVariables.decodedPortraitLayout);
            PlaybackVariables playbackVariables = this.mPlaybackVariables;
            Orientation orientation = liveStateChangeBean.ext.landScape ? Orientation.ORIENTATION_LANDSCAPE : Orientation.ORIENTATION_PORTAIT;
            playbackVariables.streamOrientation = orientation;
            playbackVariables.firstVideoOrientation = orientation;
            adjustCSSLayout();
            updatePlayerViewport();
            updateNonplayerPluginsAppearance();
        }
        if (z) {
            startPlayingBranch(null, "stateChange");
        } else {
            if (isPickMode()) {
                switchPickMode(false);
            }
            stopPlayingBranch();
        }
        updateRoomStateWithLiveStateChange(liveStateChangeBean);
    }

    private void onReservePlay(String str, final String str2, LiveInfo liveInfo) {
        LivePlayControl livePlayControl;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-866126614")) {
            ipChange.ipc$dispatch("-866126614", new Object[]{this, str, str2, liveInfo});
        } else if (liveInfo == null || (livePlayControl = liveInfo.playControl) == null || !livePlayControl.ad || TextUtils.isEmpty(livePlayControl.adJsonStr)) {
            LiveVideoRequest liveVideoRequest = new LiveVideoRequest(this.mPlayerContext.getContext(), this.mPlayerContext.getPlayerConfig());
            liveVideoRequest.setVideoRequestListener(new IVideoRequest.Callback<LiveInfo, List<LiveInfo>>() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass25 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
                public void onFailure(VideoRequestError videoRequestError) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1340173972")) {
                        ipChange.ipc$dispatch("1340173972", new Object[]{this, videoRequestError});
                        return;
                    }
                    PlayVideoInfo createDefaultVideoInfo = AlixLivePlayback.this.createDefaultVideoInfo(str2);
                    LivePlayControl livePlayControl = videoRequestError.getLivePlayControl();
                    if (livePlayControl != null && livePlayControl.ad && !TextUtils.isEmpty(livePlayControl.adJsonStr)) {
                        createDefaultVideoInfo.putString("adJson", livePlayControl.adJsonStr);
                    }
                    createDefaultVideoInfo.setPlayType(PlayType.VOD);
                    AlixLivePlayback.this.mPlayerContainer.play(createDefaultVideoInfo);
                }

                @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
                public void onStat(Map map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "923885427")) {
                        ipChange.ipc$dispatch("923885427", new Object[]{this, map});
                    }
                }

                public void onSuccess(LiveInfo liveInfo, List<LiveInfo> list) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1593663075")) {
                        ipChange.ipc$dispatch("1593663075", new Object[]{this, liveInfo, list});
                    }
                }
            });
            PlayVideoInfo createDefaultVideoInfo = createDefaultVideoInfo(str);
            Map map = null;
            if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
                map = AdUtil.getPreAdParameter(this.mContext, createDefaultVideoInfo);
            }
            liveVideoRequest.request(createDefaultVideoInfo, map);
        } else {
            PlayVideoInfo createDefaultVideoInfo2 = createDefaultVideoInfo(str2);
            createDefaultVideoInfo2.putString("adJson", liveInfo.playControl.adJsonStr);
            createDefaultVideoInfo2.setPlayType(PlayType.VOD);
            this.mPlayerContainer.play(createDefaultVideoInfo2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void perfMonitor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "501474799")) {
            ipChange.ipc$dispatch("501474799", new Object[]{this, str});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        IPerfMonitor iPerfMonitor = null;
        if (engineInstance != null) {
            iPerfMonitor = engineInstance.getPerfMonitor();
        }
        if (iPerfMonitor != null) {
            iPerfMonitor.perfPointBegin(str).perfPointEnd(str, "").perfEnable(str, false).perfCommitSuccess();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void playWithVid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1405423543")) {
            ipChange.ipc$dispatch("-1405423543", new Object[]{this, str});
            return;
        }
        PlayVideoInfo createDefaultVideoInfo = createDefaultVideoInfo(str);
        createDefaultVideoInfo.setPlayType(PlayType.VOD);
        this.mPlayerContainer.play(createDefaultVideoInfo);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void preparePreRequestLiveInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "363147945")) {
            ipChange.ipc$dispatch("363147945", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.mPlaybackVariables.currentLiveId)) {
            IPreloader instance = ILivePayControlPreloader.getInstance();
            VideoInfo videoInfo = null;
            LiveInfo prefetchVideoInfo = instance instanceof ILivePayControlPreloader ? ((ILivePayControlPreloader) instance).getPrefetchVideoInfo() : null;
            if (prefetchVideoInfo != null) {
                videoInfo = prefetchVideoInfo.videoInfo;
            }
            if (videoInfo != null && this.mPlaybackVariables.currentLiveId.equals(videoInfo.liveId)) {
                PlaybackVariables playbackVariables = this.mPlaybackVariables;
                boolean z = videoInfo.isLaifengPk;
                playbackVariables.isPK = z;
                int i = videoInfo.mcu;
                playbackVariables.isMCU = i == 1;
                if (i == 1 || (i == 0 && !z)) {
                    playbackVariables.hasTwoPlayer = false;
                } else {
                    playbackVariables.hasTwoPlayer = true;
                }
                playbackVariables.protocol = Protocol.get(videoInfo.protocol);
                PlaybackVariables playbackVariables2 = this.mPlaybackVariables;
                playbackVariables2.videoFormat = videoInfo.videoFormat;
                boolean z2 = videoInfo.landscape;
                playbackVariables2.firstVideoOrientation = z2 ? Orientation.ORIENTATION_LANDSCAPE : Orientation.ORIENTATION_PORTAIT;
                this.mPlayerContext.setLandVideo(z2);
                this.mPlaybackVariables.screenId = videoInfo.screenId;
            }
        }
    }

    private void putTimestamp(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-368077459")) {
            ipChange.ipc$dispatch("-368077459", new Object[]{this, str, Long.valueOf(j)});
            return;
        }
        this.mPlayerContainer.getPlayerTrack().putTimestamp(str, j);
    }

    private void refreshViewLayout(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1003664340")) {
            ipChange.ipc$dispatch("-1003664340", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (!TinyWindowManager.getInstance().isInTinyWindowMode()) {
            ViewGroup.LayoutParams layoutParams = this.mPlayerViewRoot.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = i;
                layoutParams.height = i2;
                if (isPickMode()) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
                } else {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 48;
                }
                this.mPlayerViewRoot.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mNonplayerViewContainer.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i;
                layoutParams2.height = i2;
                this.mNonplayerViewContainer.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.mPromptLayout.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = i;
                layoutParams3.height = i2;
                this.mPromptLayout.setLayoutParams(layoutParams3);
            }
        }
    }

    private void registerDataHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168581767")) {
            ipChange.ipc$dispatch("-1168581767", new Object[]{this});
            return;
        }
        for (DataKey dataKey : DataKey.values()) {
            getEngineInstance().addDataHandler(dataKey.getKeyName(), this);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void releasePlayerSync() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1497931539")) {
            ipChange.ipc$dispatch("1497931539", new Object[]{this});
            return;
        }
        try {
            this.mPlayerContainer.getMultiPlayer().stop();
            this.mPlayerContainer.getMultiPlayer().release();
            this.mPlayerContainer.getPlayer().stop();
            if (!PlayerPreloader.getInstance().recyclePlayer(this.mPlayerContainer)) {
                this.mPlayerContainer.getPlayer().release();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            TLogUtil.playLog("release 失败：" + th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reqRecordInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "916089731")) {
            ipChange.ipc$dispatch("916089731", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        INetRequest createRequestWithMTop = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop(DAGO_LIVE_BACK_DATA, "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass23 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    RecordInfo recordInfo;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1935840089")) {
                        ipChange.ipc$dispatch("1935840089", new Object[]{this, iNetResponse});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).i(AlixLivePlayback.TAG, "reqRecordInfo  getRetCode = " + iNetResponse.getRetCode());
                    ((ILog) Dsl.getService(ILog.class)).i(AlixLivePlayback.TAG, "reqRecordInfo  getSource = " + iNetResponse.getSource());
                    try {
                        if ("SUCCESS".equals(iNetResponse.getRetCode()) && (recordInfo = ((RecordInfoWrapper) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iNetResponse.getSource(), RecordInfoWrapper.class)).data.data) != null) {
                            AlixLivePlayback.this.showPlaybackCoverLayout(recordInfo.isRecordOpen, recordInfo.videoUrlCode, true);
                        }
                    } catch (Exception e) {
                        ((IToast) Dsl.getService(IToast.class)).showCenterToast(AlixLivePlayback.this.mContext, "刷新失败");
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void requestLiveControlWithoutPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1021313212")) {
            ipChange.ipc$dispatch("1021313212", new Object[]{this});
            return;
        }
        LiveVideoRequest liveVideoRequest = new LiveVideoRequest(this.mPlayerContext.getContext(), this.mPlayerContext.getPlayerConfig());
        liveVideoRequest.setVideoRequestListener(this.mLiveRequestCallback);
        liveVideoRequest.request(createDefaultVideoInfo(this.mPlaybackVariables.currentLiveId), null);
    }

    private void retryCallbackControllerVisible() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1057058869")) {
            ipChange.ipc$dispatch("-1057058869", new Object[]{this});
            return;
        }
        Boolean bool = this.mPlayerControlViewIsVisibility;
        if (bool != null) {
            injectorCallbackControllerVisible(bool.booleanValue());
        }
    }

    private void retryCallbackPlayPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1167501729")) {
            ipChange.ipc$dispatch("-1167501729", new Object[]{this});
            return;
        }
        String str = this.mPlayerPlayAndPause;
        Long l = this.mPlayerPlayAndPauseTS;
        if (str != null && l != null) {
            injectorCallbackPlayPause(str, l.longValue());
        }
    }

    private void retryCallbackSeek() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40679119")) {
            ipChange.ipc$dispatch("-40679119", new Object[]{this});
            return;
        }
        Long valueOf = Long.valueOf(this.mPlaybackVariables.playerSeek);
        if (valueOf != null) {
            injectorCallbackSeek(valueOf.longValue());
        }
    }

    private void retryCallbackTimeShift() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923149076")) {
            ipChange.ipc$dispatch("-1923149076", new Object[]{this});
            return;
        }
        Long l = this.mPlayerControlDidSelectTimeShiftSeekTime;
        Long l2 = this.mPlayerControlDidSelectTimeShiftSeekStartTime;
        if (l != null && l2 != null) {
            injectorCallbackTimeShift(l.longValue(), l2.longValue());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void runOnUIThread(@NonNull Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078633896")) {
            ipChange.ipc$dispatch("-2078633896", new Object[]{this, runnable, Long.valueOf(j)});
            return;
        }
        this.mHandler.postDelayed(runnable, j);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showEndPageView(Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640526359")) {
            ipChange.ipc$dispatch("-640526359", new Object[]{this, bool});
        } else if (!bool.booleanValue()) {
            EndPageView endPageView = this.mEndPageView;
            if (endPageView != null) {
                endPageView.setVisibility(8);
            }
        } else if (this.mPlaybackVariables.liveFullInfoData != null) {
            ensureEndPage();
            this.mEndPageView.setVisibility(0);
            this.mEndPageView.setActorId(this.mPlaybackVariables.liveFullInfoData.anchorYtid.longValue());
            this.mEndPageView.getData(this.mPlaybackVariables.currentLiveId);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "screenLand " + this.mPlaybackVariables.streamOrientation);
            if (this.mPlaybackVariables.streamOrientation == Orientation.ORIENTATION_LANDSCAPE) {
                Context context = this.mContext;
                if (context instanceof Activity) {
                    ((Activity) context).setRequestedOrientation(1);
                }
            }
        }
    }

    private void showPlaybackCoverLayout(boolean z) {
        String str;
        ExtDTO extDTO;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1882433991")) {
            ipChange.ipc$dispatch("1882433991", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        LiveFullInfoData liveFullInfoData = this.mPlaybackVariables.liveFullInfoData;
        if (liveFullInfoData == null || (extDTO = liveFullInfoData.ext) == null) {
            str = "";
        } else {
            i = extDTO.isRecordOpen.intValue();
            str = liveFullInfoData.ext.recordVideoCode;
        }
        showPlaybackCoverLayout(i, str, z);
    }

    private void showPreviewCoverImage(boolean z) {
        String str;
        Boolean bool;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-626805651")) {
            ipChange.ipc$dispatch("-626805651", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        String str2 = null;
        LiveFullInfoData liveFullInfoData = this.mPlaybackVariables.liveFullInfoData;
        if (liveFullInfoData != null) {
            TemplateDTO templateDTO = liveFullInfoData.template;
            if (!(templateDTO == null || (bool = templateDTO.landScape) == null)) {
                z2 = bool.booleanValue();
            }
            ThemeDTO themeDTO = liveFullInfoData.theme;
            if (themeDTO != null && (!z2 ? (str = themeDTO.play916ImgUrl) != null : (str = themeDTO.play169ImgUrl) != null)) {
                str2 = str;
            }
        }
        if (z) {
            PromptLayout promptLayout = this.mPromptLayout;
            if (promptLayout != null) {
                promptLayout.setCover(str2).showCover();
                return;
            }
            return;
        }
        PromptLayout promptLayout2 = this.mPromptLayout;
        if (promptLayout2 != null) {
            promptLayout2.hideCover();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startOrStopPlayLive(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931937595")) {
            ipChange.ipc$dispatch("-931937595", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            startPlayingBranch(null, PipUtils.DAGO_LIVE_START_OR_STOP_PROP);
        } else {
            stopPlayingBranch();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startPlaying(String str, String str2) {
        AppKeyPlayInfoModel appKeyPlayInfoModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583503356")) {
            ipChange.ipc$dispatch("1583503356", new Object[]{this, str, str2});
            return;
        }
        PerfLogUtils.log("AlixLivePlayback.startPlaying ... ");
        if (getEngineInstance() != null) {
            getEngineInstance().putData(KEY_PLAYER_START, Long.valueOf(System.currentTimeMillis()));
        }
        PlayVideoInfo playVideoInfo = new PlayVideoInfo(this.mPlaybackVariables.currentLiveId);
        PlayType playType = PlayType.LIVE;
        playVideoInfo.setPlayType(playType);
        StringBuilder sb = new StringBuilder();
        sb.append(this.mPlaybackVariables.willAppearTime);
        String str3 = "";
        sb.append(str3);
        playVideoInfo.putMonitor("willAppearTime", sb.toString());
        playVideoInfo.putMonitor("didAppearTime", this.mPlaybackVariables.didAppearTime + str3);
        playVideoInfo.setTag("willAppearTs", Long.valueOf(this.mPlaybackVariables.willAppearTime));
        playVideoInfo.setTag("didAppearTs", Long.valueOf(this.mPlaybackVariables.didAppearTime));
        playVideoInfo.putString(TableField.PLAY_FROM, str2);
        PlayVideoInfo playVideoInfo2 = this.mPlayerContainer.getPlayVideoInfo();
        if (isOnWall() && playVideoInfo2 != null && playVideoInfo2.getPlayType() == playType && playVideoInfo2.getLiveId().equals(playVideoInfo.getLiveId())) {
            String string = playVideoInfo2.getString("uniqueKey");
            if ("1".equals(playVideoInfo.getString("navthenplay")) || ((!TextUtils.isEmpty(string) && string.equals(this.mUniqueKey)) || ("willAppear".equals(str2) && "preloader".equals(playVideoInfo2.getString(TableField.PLAY_FROM))))) {
                playVideoInfo2.putString("uniqueKey", null);
                playVideoInfo.putString("isNavPlay", "1");
                playVideoInfo.setForceReplay(false);
            } else if ("willAppear".equals(str2) && "preloaderById".equals(playVideoInfo2.getString(TableField.PLAY_FROM))) {
                TLogUtil.playLog("墙外已经通过liveId播放了，这里拦住第二次播放");
                return;
            }
        }
        PlaybackVariables playbackVariables = this.mPlaybackVariables;
        NewPlayInfoModel newPlayInfoModel = playbackVariables.rapidPlayInfo;
        if (newPlayInfoModel == null || (appKeyPlayInfoModel = newPlayInfoModel.playInfo) == null) {
            String str4 = playbackVariables.playControlRequireId;
            if (str4 != null) {
                if (str4 != null) {
                    str3 = str4;
                }
                playVideoInfo.putString("playControlRequireId", str3);
                this.mPlaybackVariables.playControlRequireId = null;
            }
            if (!TextUtils.isEmpty(str)) {
                playVideoInfo.putString("params", str);
            }
            PlaybackVariables playbackVariables2 = this.mPlaybackVariables;
            if (playbackVariables2 != null && playbackVariables2.degradationByMsg) {
                playbackVariables2.degradationByMsg = false;
                if (!TextUtils.isEmpty(playbackVariables2.psid)) {
                    playVideoInfo.putString(TableField.PS_ID, this.mPlaybackVariables.psid);
                }
                if (!TextUtils.isEmpty(this.mPlaybackVariables.sceneId)) {
                    playVideoInfo.putString("sceneId", this.mPlaybackVariables.sceneId);
                }
                int i = this.mPlaybackVariables.reqQuality;
                if (i != 0) {
                    playVideoInfo.setRequestLiveQuality(i);
                }
            }
            if (!(this.mPlaybackVariables == null || str2 == null || !str2.equals("start"))) {
                if (!TextUtils.isEmpty(this.mPlaybackVariables.sceneId)) {
                    playVideoInfo.putString("sceneId", this.mPlaybackVariables.sceneId);
                }
                int i2 = this.mPlaybackVariables.reqQuality;
                if (i2 != 0) {
                    playVideoInfo.setRequestLiveQuality(i2);
                }
            }
        } else {
            FileFormat fileFormatByProtocol = FileFormat.getFileFormatByProtocol(appKeyPlayInfoModel.format);
            String str5 = this.mPlaybackVariables.playControlRequireId;
            if (str5 != null) {
                if (str5 != null) {
                    str3 = str5;
                }
                playVideoInfo.putString("playControlRequireId", str3);
                this.mPlaybackVariables.playControlRequireId = null;
            }
            if (fileFormatByProtocol != FileFormat.UNKNOWN && !TextUtils.isEmpty(appKeyPlayInfoModel.url)) {
                playVideoInfo.setFastData(new FastData(fileFormatByProtocol, appKeyPlayInfoModel.url, true));
                if (this.mPlaybackVariables.rapidPlayInfo.seiDecode == 1) {
                    playVideoInfo.putMonitor("seidecode", "1");
                } else {
                    playVideoInfo.putMonitor("seidecode", "0");
                }
            }
        }
        this.mPlayerContainer.play(playVideoInfo);
        BusinessTrack.mVVTrigger = true;
        if (this.mPlayerInfoSB == null) {
            this.mPlayerInfoSB = new StringBuilder();
        }
        StringBuilder sb2 = this.mPlayerInfoSB;
        sb2.append(this.mCurScreenMode);
        sb2.append(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        this.mScreenModeTime = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startPlayingBranch(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678548038")) {
            ipChange.ipc$dispatch("-678548038", new Object[]{this, str, str2});
            return;
        }
        ensureHandlerThread();
        if (ConfigUtils.enableAsyncPlayer()) {
            this.mPlayerHandler.removeMessages(2);
            Message message = new Message();
            message.what = 1;
            Bundle bundle = new Bundle();
            bundle.putString("params", str);
            bundle.putString(TableField.PLAY_FROM, str2);
            message.setData(bundle);
            this.mPlayerHandler.sendMessage(message);
            return;
        }
        startPlaying(str, str2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startPlayingVidBranch(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244614041")) {
            ipChange.ipc$dispatch("244614041", new Object[]{this, str});
            return;
        }
        ensureHandlerThread();
        if (ConfigUtils.enableAsyncPlayer()) {
            this.mPlayerHandler.removeMessages(2);
            Message message = new Message();
            message.what = 3;
            Bundle bundle = new Bundle();
            bundle.putString("vid", str);
            message.setData(bundle);
            this.mPlayerHandler.sendMessage(message);
            return;
        }
        playWithVid(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void stopPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738803222")) {
            ipChange.ipc$dispatch("-738803222", new Object[]{this});
            return;
        }
        updatePlayTimeTrackInfo();
        try {
            this.mPlayerContainer.stop();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void stopPlayingBranch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "637130024")) {
            ipChange.ipc$dispatch("637130024", new Object[]{this});
            return;
        }
        ensureHandlerThread();
        if (ConfigUtils.enableAsyncPlayer()) {
            this.mPlayerHandler.removeMessages(1);
            this.mPlayerHandler.sendEmptyMessage(2);
            return;
        }
        stopPlaying();
    }

    private void switchPickMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-336772616")) {
            ipChange.ipc$dispatch("-336772616", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mPlayerContext.put("isPickMode", Boolean.valueOf(z));
    }

    private void unbindDagoChannel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741232498")) {
            ipChange.ipc$dispatch("-1741232498", new Object[]{this});
            return;
        }
        DagoChannelPlugin dagoChannelPlugin = this.mChannelPlugin;
        if (dagoChannelPlugin != null) {
            dagoChannelPlugin.removeListener(this);
        }
    }

    private void unregisterDataHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-187869934")) {
            ipChange.ipc$dispatch("-187869934", new Object[]{this});
            return;
        }
        for (DataKey dataKey : DataKey.values()) {
            getEngineInstance().removeDataHandler(dataKey.getKeyName(), this);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateCoverImageState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215931742")) {
            ipChange.ipc$dispatch("-215931742", new Object[]{this, Boolean.valueOf(z)});
        } else if (!z) {
            this.mCoverImageView.hide();
        } else if (this.mUsingRemoteCover) {
            cq1 cq1 = this.mLayoutVariables.phenixTicket;
            if (cq1 != null) {
                cq1.cancel();
            }
            this.mCoverImageView.setAlpha(1.0f);
            this.mCoverImageView.setVisibility(0);
            this.mLayoutVariables.phenixTicket = tp1.o().s(this.mPlaybackVariables.coverImageUrl).H(R.drawable.dago_container_live_room_common_bg).h(new ScaleCropBitmapProcessor(80, 45), new a(this.mContext, 15, 1)).y(this.mCoverImageView);
        } else {
            cq1 cq12 = this.mLayoutVariables.phenixTicket;
            if (cq12 != null) {
                cq12.cancel();
            }
            this.mCoverImageView.setAlpha(1.0f);
            this.mCoverImageView.setVisibility(0);
        }
    }

    private void updateNonplayerPluginsAppearance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271193717")) {
            ipChange.ipc$dispatch("1271193717", new Object[]{this});
        } else if (!this.mPlaybackVariables.isPK) {
            this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.REFRESH_CONTROL_VIEW));
        }
    }

    private void updatePlayTimeTrackInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052809127")) {
            ipChange.ipc$dispatch("1052809127", new Object[]{this});
        } else if (this.mPlayerContainer.getPlayerTrack() != null && this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack() != null) {
            PlayTimeTrack playTimeTrack = this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack();
            playTimeTrack.setDidAppearTime(this.mPlaybackVariables.didAppearTime);
            playTimeTrack.setWillAppearTime(this.mPlaybackVariables.willAppearTime);
            playTimeTrack.putTimestamp("willAppearTs", this.mPlaybackVariables.willAppearTime);
            playTimeTrack.putTimestamp("didAppearTs", this.mPlaybackVariables.didAppearTime);
        }
    }

    private void updatePlayerViewport() {
        PlayerbackViewModel.Rect rect;
        PlayerbackViewModel.Rect rect2;
        PlayerbackViewModel.Rect rect3;
        ViewGroup.LayoutParams layoutParams;
        PlayerbackViewModel.Rect rect4;
        int i;
        FrameLayout.LayoutParams layoutParams2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1152169732")) {
            ipChange.ipc$dispatch("1152169732", new Object[]{this});
        } else if (!this.isUnLimitedOpen) {
            PlaybackVariables playbackVariables = this.mPlaybackVariables;
            Orientation orientation = playbackVariables.roomOrientation;
            Orientation orientation2 = Orientation.ORIENTATION_LANDSCAPE;
            boolean z2 = orientation == orientation2;
            if (playbackVariables.firstVideoOrientation != orientation2) {
                z = false;
            }
            Context context = getEngineInstance().getContext();
            int screenWidth = ViewUtils.getScreenWidth(context);
            int measuredHeight = this.mCSSRootView.getMeasuredHeight();
            if (z2) {
                int i2 = (measuredHeight - measuredHeight) / 2;
                rect2 = new PlayerbackViewModel.Rect(i2, 0, measuredHeight, screenWidth);
                rect = new PlayerbackViewModel.Rect(i2, 0, measuredHeight, screenWidth, FeatureFactory.PRIORITY_ABOVE_NORMAL, screenWidth);
                this.mWidgetRootView.setPadding(0, 0, 0, 0);
                refreshViewLayout(-1, -1);
            } else {
                if (this.mPlaybackVariables.isPK) {
                    i = UIUtils.dip2px(95, context) + this.mLayoutVariables.statusBarHeight;
                    measuredHeight = ((screenWidth / 2) * 16) / 9;
                    rect4 = new PlayerbackViewModel.Rect(0, i, screenWidth, measuredHeight);
                    rect3 = new PlayerbackViewModel.Rect(0, i, screenWidth, measuredHeight, FeatureFactory.PRIORITY_ABOVE_NORMAL, screenWidth);
                    layoutParams = new ViewGroup.LayoutParams(screenWidth, measuredHeight);
                } else if (z) {
                    if (isPickMode()) {
                        int i3 = (screenWidth * 16) / 9;
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(screenWidth, i3);
                        layoutParams3.gravity = 17;
                        measuredHeight = i3;
                        i = 0;
                        layoutParams2 = layoutParams3;
                    } else {
                        WidgetAttributesModel layoutModel = this.mLayoutVariables.getLandscapeLayoutModel() == null ? this.mLayoutVariables.getLayoutModel() : this.mLayoutVariables.getLandscapeLayoutModel();
                        if (layoutModel != null) {
                            i = layoutModel.portrait.compute(screenWidth, measuredHeight, ((float) screenWidth) / ((float) getEngineInstance().getStandardWidth())).t + this.mLayoutVariables.statusBarHeight;
                        } else {
                            i = UIUtils.dip2px(115, context);
                        }
                        int i4 = (screenWidth * 9) / 16;
                        measuredHeight = i4;
                        layoutParams2 = new ViewGroup.LayoutParams(screenWidth, i4);
                    }
                    layoutParams = layoutParams2;
                    rect4 = new PlayerbackViewModel.Rect(0, i, screenWidth, measuredHeight);
                    rect3 = new PlayerbackViewModel.Rect(0, i, screenWidth, measuredHeight, FeatureFactory.PRIORITY_ABOVE_NORMAL, screenWidth);
                } else {
                    PlayerbackViewModel.Rect rect5 = new PlayerbackViewModel.Rect(0, 0, screenWidth, measuredHeight);
                    PlayerbackViewModel.Rect rect6 = new PlayerbackViewModel.Rect(0, 0, screenWidth, measuredHeight, FeatureFactory.PRIORITY_ABOVE_NORMAL, screenWidth);
                    layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    rect3 = rect6;
                    rect4 = rect5;
                    i = 0;
                }
                PlaybackVariables playbackVariables2 = this.mPlaybackVariables;
                if (playbackVariables2.freeLayout || playbackVariables2.isPK) {
                    ViewGroup viewGroup = this.mWidgetRootView;
                    if (viewGroup != null) {
                        viewGroup.setPadding(0, i, 0, 0);
                    }
                    refreshViewLayout(layoutParams.width, layoutParams.height);
                } else {
                    ViewGroup viewGroup2 = this.mWidgetRootView;
                    if (viewGroup2 != null) {
                        viewGroup2.setPadding(0, i, 0, 0);
                    }
                    refreshViewLayout(screenWidth, measuredHeight);
                }
                rect2 = rect4;
                rect = rect3;
            }
            this.mWidgetRootView.requestLayout();
            getEngineInstance().asyncPutData("LFLWDataCenterPlaybackViewStateKey", new PlayerbackViewModel(rect2, rect, z, this.mPlaybackVariables.isPK));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateRoomStateWithLiveFullInfo(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392857024")) {
            ipChange.ipc$dispatch("1392857024", new Object[]{this, liveFullInfoData});
        } else if (liveFullInfoData != null) {
            if (liveFullInfoData.liveStatus.intValue() == 0) {
                ExtDTO extDTO = liveFullInfoData.ext;
                if (extDTO == null || TextUtils.isEmpty(extDTO.broadcastVideoCode)) {
                    adjustCSSLayout();
                    updatePlayerViewport();
                    updateNonplayerPluginsAppearance();
                    showPlaybackCoverLayout(false);
                    showPreviewCoverImage(true);
                    showEndPageView(Boolean.FALSE);
                    return;
                }
                requestLiveControlWithoutPlay();
                onReservePlay(liveFullInfoData.liveId + "", liveFullInfoData.ext.broadcastVideoCode, null);
            } else if (liveFullInfoData.liveStatus.intValue() == 1) {
                showPreviewCoverImage(false);
                showPlaybackCoverLayout(false);
                showEndPageView(Boolean.FALSE);
            } else if (liveFullInfoData.liveStatus.intValue() == 2) {
                showPreviewCoverImage(false);
                if (liveFullInfoData.ext != null) {
                    ((ILog) Dsl.getService(ILog.class)).i(TAG, "endPageType= " + liveFullInfoData.ext.endPageType);
                    Integer num = liveFullInfoData.ext.endPageType;
                    if (num == null || 1 != num.intValue()) {
                        showPlaybackCoverLayout(true);
                    } else {
                        showEndPageView(Boolean.TRUE);
                    }
                } else {
                    showPlaybackCoverLayout(true);
                }
            }
        }
    }

    private void updateRoomStateWithLiveStateChange(LiveStateChangeBean liveStateChangeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718578222")) {
            ipChange.ipc$dispatch("1718578222", new Object[]{this, liveStateChangeBean});
        } else if (liveStateChangeBean == null) {
        } else {
            if (liveStateChangeBean.st == 1) {
                PromptLayout promptLayout = this.mPromptLayout;
                if (promptLayout != null) {
                    promptLayout.hide();
                }
                showEndPageView(Boolean.FALSE);
                return;
            }
            LiveFullInfoData liveFullInfoData = this.mPlaybackVariables.liveFullInfoData;
            if (liveFullInfoData != null && liveFullInfoData.ext != null) {
                ((ILog) Dsl.getService(ILog.class)).i(TAG, "endPageType= " + this.mPlaybackVariables.liveFullInfoData.ext.endPageType);
                Integer num = this.mPlaybackVariables.liveFullInfoData.ext.endPageType;
                if (num != null && 1 == num.intValue()) {
                    this.mHandler.postDelayed(new Runnable() {
                        /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass21 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "421637758")) {
                                ipChange.ipc$dispatch("421637758", new Object[]{this});
                                return;
                            }
                            AlixLivePlayback.this.showEndPageView(Boolean.TRUE);
                        }
                    }, (long) ((int) (((double) liveStateChangeBean.dt) * Math.random())));
                } else if (this.mPromptLayout != null) {
                    this.mPromptLayout.postDelayed(new Runnable() {
                        /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass22 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "225124253")) {
                                ipChange.ipc$dispatch("225124253", new Object[]{this});
                                return;
                            }
                            AlixLivePlayback alixLivePlayback = AlixLivePlayback.this;
                            alixLivePlayback.reqRecordInfo(alixLivePlayback.mPlaybackVariables.currentLiveId);
                        }
                    }, (long) ((int) (((double) liveStateChangeBean.dt) * Math.random())));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // com.youku.live.widgets.protocol.ICall
    public void call(IEngineInstance iEngineInstance, String str, Map<String, Object> map, IResult iResult, IResult iResult2) {
        String str2;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1993045864")) {
            ipChange.ipc$dispatch("1993045864", new Object[]{this, iEngineInstance, str, map, iResult, iResult2});
        } else if (METHOD_GET_VIEW.equals(str)) {
            if (map != null && map.containsKey("type")) {
                Object obj = map.get("type");
                if (obj instanceof String) {
                    str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        View view = getView(str2);
                        if (view != null) {
                            if (iResult != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("view", view);
                                iResult.onResult(hashMap);
                                return;
                            }
                            return;
                        } else if (iResult2 != null) {
                            iResult2.onResult(null);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            str2 = null;
            if (TextUtils.isEmpty(str2)) {
            }
        } else if (METHOD_MUTE_PLAYER.equals(str)) {
            if (map != null && map.containsKey(IGNORE_TINYWINDOW)) {
                Object obj2 = map.get(IGNORE_TINYWINDOW);
                if (obj2 instanceof Boolean) {
                    z = ((Boolean) obj2).booleanValue();
                }
            }
            if (z || !TinyWindowManager.getInstance().isInTinyWindowMode()) {
                Object obj3 = map.get("mute");
                if (obj3 instanceof Boolean) {
                    mute(((Boolean) obj3).booleanValue());
                }
            }
        }
    }

    @Override // com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.protocol.IDestroyable, com.youku.live.widgets.impl.BaseWidget
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1463356796")) {
            ipChange.ipc$dispatch("1463356796", new Object[]{this});
            return;
        }
        try {
            Log.d(LOG_TAG, "AlixLivePlayback@" + hashCode() + ".destroy");
            unregisterDataHandler();
            updatePlayTimeTrackInfo();
            if (!this.mPlaybackVariables.isPlayerTakenByWindow) {
                destroyPlayer();
            }
            mPlayerAudioFocusManager.abandonAudioFocus();
            this.mAlixPlayerTrack.destory();
            this.mPlayerHandler.removeCallbacksAndMessages(null);
            this.mPlayerContext.destory();
        } catch (Throwable th) {
            TLogUtil.loge(TAG, th.getMessage());
        }
    }

    public void destroyPlayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "230865307")) {
            ipChange.ipc$dispatch("230865307", new Object[]{this});
        } else if (ConfigUtils.enableAsyncStopAndRelease()) {
            this.mPlayerThread.quit();
            WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass6 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-66481095")) {
                        ipChange.ipc$dispatch("-66481095", new Object[]{this});
                        return;
                    }
                    AlixLivePlayback.this.releasePlayerSync();
                }
            });
        } else {
            releasePlayerSync();
            this.mPlayerThread.quit();
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756376578")) {
            ipChange.ipc$dispatch("756376578", new Object[]{this});
            return;
        }
        Log.i("lwj", "AlixLivePlayback did appear begin " + this);
        Log.d(LOG_TAG, "AlixLivePlayback@" + hashCode() + ".didAppear, liveID:" + this.mPlaybackVariables.currentLiveId);
        this.mPlaybackVariables.didAppearTime = System.currentTimeMillis();
        if (!this.mPlayerContext.getEventBus().isRegistered(this)) {
            this.mPlayerContext.getEventBus().register(this);
        }
        mute(false);
        this.mAlixPlayerTrack.didAppear();
        mPlayerAudioFocusManager.requestAudioFocus(this.mPlayerContainer);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "130032410")) {
                    ipChange.ipc$dispatch("130032410", new Object[]{this});
                    return;
                }
                AlixLivePlayback.this.updateCoverImageState(false);
            }
        }, 3000);
        if (!(this.mPlayerContainer.getPlayerTrack() == null || this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack() == null)) {
            updatePlayTimeTrackInfo();
        }
        Log.i("lwj", "AlixLivePlayback did appear end " + this);
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "343862128")) {
            ipChange.ipc$dispatch("343862128", new Object[]{this});
            return;
        }
        Log.d(LOG_TAG, "AlixLivePlayback@" + hashCode() + ".didDisappear, liveID:" + this.mPlaybackVariables.currentLiveId);
        if (this.mPlayerContext.getEventBus().isRegistered(this)) {
            this.mPlayerContext.getEventBus().unregister(this);
        }
        this.mAlixPlayerTrack.didDisappear();
        stopPlayingBranch();
        unbindDagoChannel();
        unregisterDataHandler();
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void didMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1221587514")) {
            ipChange.ipc$dispatch("1221587514", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580265555")) {
            ipChange.ipc$dispatch("1580265555", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public ViewGroup.LayoutParams getLayoutParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923381059")) {
            return (ViewGroup.LayoutParams) ipChange.ipc$dispatch("-1923381059", new Object[]{this});
        }
        if (this.mRootViewLayoutParams == null) {
            CSSLayout.LayoutParams layoutParams = new CSSLayout.LayoutParams(-1, -1);
            this.mRootViewLayoutParams = layoutParams;
            layoutParams.portraitModel = new WidgetAttributesModel.OrientationModel();
            this.mRootViewLayoutParams.portraitModel.margin = new WidgetAttributesModel.MarginModel();
            this.mRootViewLayoutParams.portraitModel.margin.l = 0;
            this.mRootViewLayoutParams.portraitModel.margin.t = 0;
            this.mRootViewLayoutParams.portraitModel.margin.r = 0;
            this.mRootViewLayoutParams.portraitModel.margin.b = 0;
        }
        return this.mRootViewLayoutParams;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107004051")) {
            return (View) ipChange.ipc$dispatch("2107004051", new Object[]{this, context});
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!(getEngineInstance() == null || getEngineInstance().getOptions() == null)) {
            YKPrefReporter.getInstance().getPlayBySessionId(getEngineInstance().getOptions().getString("onePlayId", "")).setInitHostViewStartTime(System.currentTimeMillis());
        }
        Logger.setDebugMode(SystemUtils.isDebug());
        Log.i("lwj", "init host view begin " + this);
        Log.d(LOG_TAG, "AlixLivePlayback@" + hashCode() + ".initHostView");
        Utils.initRemoteLogger();
        this.mContext = context;
        this.mActivity = (Activity) context;
        TouchableCSSLayout touchableCSSLayout = new TouchableCSSLayout(this.mContext);
        this.mCSSRootView = touchableCSSLayout;
        touchableCSSLayout.setLayoutParams(new CSSLayout.LayoutParams(UIUtils.getScreenWidth(this.mContext), UIUtils.getScreenHeight(this.mContext)));
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        DagoLivePlaybackFrameLayout dagoLivePlaybackFrameLayout = new DagoLivePlaybackFrameLayout(this.mContext);
        this.mWidgetRootView = dagoLivePlaybackFrameLayout;
        frameLayout.addView(dagoLivePlaybackFrameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.mCSSRootView.addView(frameLayout, new CSSLayout.LayoutParams(-1, -1));
        long currentTimeMillis2 = System.currentTimeMillis();
        boolean initPlayerRelatedStuff = initPlayerRelatedStuff();
        putTimestamp("initPlayerTs", currentTimeMillis2);
        putTimestamp("initPluginsTs", System.currentTimeMillis());
        initPlugins(initPlayerRelatedStuff);
        putTimestamp("initMiscTs", System.currentTimeMillis());
        initMisc();
        if (getEngineInstance() != null) {
            getEngineInstance().asyncPutData("dagoLivePlayerbackInitHostViewEnd", "1");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("enable", Boolean.valueOf(ConfigUtils.enablePickMode()));
        if (getEngineInstance() != null) {
            getEngineInstance().asyncPutData("LFLWDataCenterUnlimitScreenEnable", hashMap);
        }
        Log.i("lwj", "init host view end " + this);
        if (!(getEngineInstance() == null || getEngineInstance().getOptions() == null)) {
            YKPrefReporter.getInstance().getPlayBySessionId(getEngineInstance().getOptions().getString("onePlayId", "")).setInitHostViewEndTime(System.currentTimeMillis());
        }
        Log.v(TAG_COST, String.format("cost %5d ms for initHostView [%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(hashCode())));
        putTimestamp("initHostViewTs", currentTimeMillis);
        putTimestamp("initHostViewEndTs", System.currentTimeMillis());
        return this.mCSSRootView;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1451891947")) {
            ipChange.ipc$dispatch("1451891947", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
            return;
        }
        if (getEngineInstance().getRootView().findViewWithTag("topViewRoot") == null && this.mTopViewContainer != null) {
            getEngineInstance().getRootView().addView(this.mTopViewContainer, new ViewGroup.LayoutParams(-1, -1));
        }
        if (!(getEngineInstance() == null || getEngineInstance().getOptions() == null)) {
            YKPrefReporter.getInstance().getPlayBySessionId(getEngineInstance().getOptions().getString("onePlayId", "")).setInitWithDataStartTime(System.currentTimeMillis());
        }
        Log.i("lwj", "init with data begin " + this);
        super.initWithData(iEngineInstance, iWidget, iWidgetData);
        HandlerThread handlerThread = this.mPlayerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mPlayerThread = null;
        }
        ensureHandlerThread();
        this.mPlaybackVariables = new PlaybackVariables();
        int i = this.mContext.getResources().getConfiguration().orientation;
        if (i == 1) {
            this.mPlaybackVariables.roomOrientation = Orientation.ORIENTATION_PORTAIT;
        } else if (i == 2) {
            this.mPlaybackVariables.roomOrientation = Orientation.ORIENTATION_LANDSCAPE;
        }
        this.mAlixPlayerTrack.setPlaybackVariables(this.mPlaybackVariables);
        IProps options = iEngineInstance.getOptions();
        boolean isOnWall = isOnWall(options);
        if (isOnWall) {
            this.mPlaybackVariables.pageSource = PageSource.WALL;
        } else {
            this.mPlaybackVariables.pageSource = PageSource.SCROLL;
        }
        this.mPlaybackVariables.currentLiveId = options.getString("liveid", null);
        this.mPlaybackVariables.playControlRequireId = options.getString("playControlRequireId", null);
        this.mPlaybackVariables.coverImageUrl = options.getString("dagoPlayerCoverImage", null);
        this.mPlaybackVariables.rapidPlayInfo = (NewPlayInfoModel) options.getValue("dagoLiveIdPlayerModel", NewPlayInfoModel.class, null);
        if (this.mPlaybackVariables.rapidPlayInfo == null && !isOnWall && LivePerfUtils.findRapidPlayInfoFromCache()) {
            String string = options.getString(Utils.DATA_COME_IN_PLAYCONTROLLER_UNIQUEKEY, null);
            if (!TextUtils.isEmpty(string)) {
                this.mPlaybackVariables.rapidPlayInfo = NewPlayInfoCache.getInstance().get(string);
            }
        }
        "1".equals(getEngineInstance().getOptions().getString("isFirstLiveRoom", "null"));
        PlayBackCover playBackCover = this.mCoverImageView;
        if (!(playBackCover == null || this.mPlaybackVariables.coverImageUrl == null)) {
            playBackCover.setPlaceHoldImageResId(com.youku.live.dago.liveplayback.R.drawable.cover_bg);
            this.mCoverImageView.setImageUrl(this.mPlaybackVariables.coverImageUrl);
        }
        this.mPlaybackVariables.localSeekBarProgressManager = new LocalSeekBarProgressManager();
        this.mAlixPlayerTrack.setSdkVersion(options.getString(SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION, null));
        this.mWidgetRootView.setContentDescription(this.mPlaybackVariables.currentLiveId);
        this.mLayoutVariables.updateLayout(options.getString("layout", null), options.getString("layoutLandscape", null), options.getString("layoutPortrait", null));
        if ("1".equals(options.getString("isImmerse", "1"))) {
            this.mLayoutVariables.statusBarHeight = UIUtils.getStatusBarHeight(this.mContext);
        } else {
            this.mLayoutVariables.statusBarHeight = 0;
        }
        IProps props = getProps();
        if (props != null) {
            boolean parseBoolean = Boolean.parseBoolean(props.getString("exitPlayerEnable", "false"));
            Log.d(TAG, "pipEnable: " + parseBoolean);
            this.mPlaybackVariables.pipEnable = parseBoolean;
            this.mPlaybackVariables.freeLayout = Boolean.parseBoolean(props.getString("freeLayout", "false"));
            this.mPlaybackVariables.playRecord = Boolean.parseBoolean(props.getString("playRecord", "false"));
        }
        NewPlayInfoModel newPlayInfoModel = this.mPlaybackVariables.rapidPlayInfo;
        if (newPlayInfoModel != null) {
            this.mPlayerContext.getPlayerConfig().getExtras().putString(TableField.PLAYER_SOURCE, newPlayInfoModel.bizType == 3 ? "12" : "11");
        }
        this.mPlayerContext.getPlayerConfig().getExtras().putBoolean("isLaifeng", "1".endsWith(options.getString("isLaifeng", "0")));
        Log.d(LOG_TAG, "AlixLivePlayback@" + hashCode() + ".initWithData, liveID:" + this.mPlaybackVariables.currentLiveId);
        StringBuilder sb = new StringBuilder();
        sb.append("init with data end ");
        sb.append(this);
        Log.i("lwj", sb.toString());
        if (!(getEngineInstance() == null || getEngineInstance().getOptions() == null)) {
            YKPrefReporter.getInstance().getPlayBySessionId(getEngineInstance().getOptions().getString("onePlayId", "")).setInitHostViewEndTime(System.currentTimeMillis());
        }
        if (this.mPlayerContainer.getPlayVideoInfo() != null && "1".equals(this.mPlayerContainer.getPlayVideoInfo().getString("isTinyWindowPlay"))) {
            this.mPlayerContainer.getPlayVideoInfo().putString("isTinyWindowPlay", "0");
        } else if (isOnWall) {
            startPlayingBranch(null, "willAppear");
            mute(true);
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorChangeMoreView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1129255786")) {
            ipChange.ipc$dispatch("-1129255786", new Object[]{this});
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorClearDanmu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1874987116")) {
            ipChange.ipc$dispatch("-1874987116", new Object[]{this});
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorInsertDanmu(List<Map<String, Object>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-860086853")) {
            ipChange.ipc$dispatch("-860086853", new Object[]{this, list});
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorInsertView2ControlPlugin(View view, LinearLayout.LayoutParams layoutParams, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30685120")) {
            ipChange.ipc$dispatch("-30685120", new Object[]{this, view, layoutParams, Integer.valueOf(i)});
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorInsertView2DanmuPlugin(View view, RelativeLayout.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214291814")) {
            ipChange.ipc$dispatch("1214291814", new Object[]{this, view, layoutParams});
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorPlayerAction(String str, Map<String, Object> map) {
        boolean z;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-641066382")) {
            ipChange.ipc$dispatch("-641066382", new Object[]{this, str, map});
            return;
        }
        switch (AnonymousClass28.$SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$InjectKey[InjectKey.get(str).ordinal()]) {
            case 1:
                this.mPlaybackVariables.resultGlobalCallback = (IDagoLivePlaybackInjectorInterface.IResultListener) map.get("value");
                retryCallbackControllerVisible();
                retryCallbackTimeShift();
                retryCallbackPlayPause();
                retryCallbackSeek();
                return;
            case 2:
                startPlayingBranch(null, "injectorPlayerAction");
                return;
            case 3:
                stopPlayingBranch();
                return;
            case 4:
                if (!this.mPlayerContext.isDlnaMode()) {
                    if (this.mPlaybackVariables.liveFullInfoData.liveStatus.intValue() != 0 || TextUtils.isEmpty(this.mPlaybackVariables.liveFullInfoData.ext.broadcastVideoCode)) {
                        startPlayingBranch(null, "rePower");
                        return;
                    }
                    requestLiveControlWithoutPlay();
                    startPlayingVidBranch(this.mPlaybackVariables.liveFullInfoData.ext.broadcastVideoCode);
                    return;
                }
                return;
            case 5:
                if (map != null) {
                    String str2 = (String) Utils.reinterpretCast(map.get(com.alibaba.security.realidentity.jsbridge.a.V));
                    int intValue = ((Integer) Utils.reinterpretCast(map.get("width"))).intValue();
                    int intValue2 = ((Integer) Utils.reinterpretCast(map.get("height"))).intValue();
                    int videoWidth = getPlayer(0).getVideoWidth();
                    int videoHeight = getPlayer(0).getVideoHeight();
                    if (videoWidth == 0 || videoHeight == 0) {
                        z = false;
                        intValue2 = 0;
                    } else {
                        if (intValue == 0 && intValue2 == 0) {
                            i = videoWidth;
                            intValue2 = videoHeight;
                        } else {
                            float f = ((float) intValue) / ((float) intValue2);
                            float f2 = (float) videoWidth;
                            float f3 = (float) videoHeight;
                            if (f > f2 / f3) {
                                intValue = (int) (f2 / f);
                            } else {
                                intValue2 = (int) (f3 * f);
                            }
                            i = intValue;
                        }
                        z = this.mPlayerContainer.snapshot(i, intValue2, str2);
                    }
                    map.put("width", Integer.valueOf(i));
                    map.put("height", Integer.valueOf(intValue2));
                    map.put("success", Boolean.valueOf(z));
                    return;
                }
                return;
            case 6:
                try {
                    if (this.mPlayerContext != null) {
                        this.mPlayerContext.onNotify(new Intent(InjectKey.ACTION_OG_BACK_TO_MULTI_SCREEN_SELECT.getKeyName()), map);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastUtil.showToast(this.mContext, "ACTION_OG_BACK_TO_MULTI_SCREEN_SELECT error");
                    return;
                }
            case 7:
                try {
                    if (this.mPlayerContext != null) {
                        this.mPlayerContext.onNotify(new Intent(InjectKey.ACTION_SWITCH_LIST_MULTI_SCREEN_WITH_SCENE_ID.getKeyName()), map);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ToastUtil.showToast(this.mContext, "ACTION_SWITCH_LIST_MULTI_SCREEN_WITH_SCENE_ID error");
                    return;
                }
            case 8:
                try {
                    if (this.mPlayerContext != null) {
                        this.mPlayerContext.onNotify(new Intent(InjectKey.ACTION_SET_AHDR_STATE.getKeyName()), map);
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    ToastUtil.showToast(this.mContext, "ACTION_SET_AHDR_STATE error");
                    return;
                }
            case 9:
                try {
                    if (this.mPlayerContext != null && map != null && map.containsKey("open")) {
                        switchPickMode(((Boolean) map.get("open")).booleanValue());
                        return;
                    }
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    ToastUtil.showToast(this.mContext, "ACTION_SET_UNLIMIT_SCREEN error");
                    return;
                }
            case 10:
                try {
                    if (this.mPlayerContext != null && map != null && map.containsKey("show")) {
                        setPlayerControlViewDisplay(((Boolean) map.get("show")).booleanValue());
                        return;
                    }
                    return;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    ToastUtil.showToast(this.mContext, "ACTION_SET_PLAYER_CONTROL_VIEW_DISPLAY error");
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorSetProgressListener(IDagoLivePlaybackInjectorInterface.IResultListener iResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1915508467")) {
            ipChange.ipc$dispatch("1915508467", new Object[]{this, iResultListener});
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorSetPtsEventListener(IDagoLivePlaybackInjectorInterface.IResultListener iResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62382129")) {
            ipChange.ipc$dispatch("62382129", new Object[]{this, iResultListener});
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorSetRotateEventListener(IDagoLivePlaybackInjectorInterface.IResultListener iResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453007221")) {
            ipChange.ipc$dispatch("-1453007221", new Object[]{this, iResultListener});
            return;
        }
        this.mPlaybackVariables.resultRotateCallback = iResultListener;
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorSetSeiEventListener(IDagoLivePlaybackInjectorInterface.IResultListener iResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931665463")) {
            ipChange.ipc$dispatch("-931665463", new Object[]{this, iResultListener});
            return;
        }
        PlaybackVariables playbackVariables = this.mPlaybackVariables;
        if (playbackVariables != null) {
            playbackVariables.resultSeiCallback = iResultListener;
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorSupplyTopLayer(FrameLayout frameLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749966680")) {
            ipChange.ipc$dispatch("1749966680", new Object[]{this, frameLayout});
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorUpdateDanmuConfig(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-703843315")) {
            ipChange.ipc$dispatch("-703843315", new Object[]{this, map});
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorUpdateProgram(Map<String, Object> map, IDagoLivePlaybackInjectorInterface.IResultListener iResultListener, IDagoLivePlaybackInjectorInterface.IResultListener iResultListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1725918218")) {
            ipChange.ipc$dispatch("-1725918218", new Object[]{this, map, iResultListener, iResultListener2});
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.INTERACT_SEI_NOTIFY}, priority = 1, threadMode = ThreadMode.POSTING)
    public void interactSeiNotify(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91370856")) {
            ipChange.ipc$dispatch("91370856", new Object[]{this, event});
            return;
        }
        PlaybackVariables playbackVariables = this.mPlaybackVariables;
        if (playbackVariables != null && playbackVariables.resultSeiCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sei", event.data);
            this.mPlaybackVariables.resultSeiCallback.onResult(hashMap);
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.ROTATE_FINISH}, priority = 1, threadMode = ThreadMode.POSTING)
    public void notifyRotateFinish(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1659534871")) {
            ipChange.ipc$dispatch("1659534871", new Object[]{this, event});
            return;
        }
        Logger.d("rotategy", "finishrotate:" + ((Integer) event.data).intValue());
        AlixPlayerContext alixPlayerContext = this.mPlayerContext;
        if (alixPlayerContext != null) {
            alixPlayerContext.put("pick_status", PickStatus.ROTATE_FINISH);
        }
        PlaybackVariables playbackVariables = this.mPlaybackVariables;
        if (!(playbackVariables == null || playbackVariables.resultRotateCallback == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("key", CALLBACK_OROTATE_FINISH);
            hashMap.put(Constants.ACTION_PARAMS_SCREENMODE, event.data);
            this.mPlaybackVariables.resultRotateCallback.onResult(hashMap);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("isStartRotate", Boolean.FALSE);
        DelayedRunnable delayedRunnable = this.mRotateFinishRunnable;
        delayedRunnable.params = hashMap2;
        this.mHandler.postDelayed(delayedRunnable, 300);
    }

    @Subscribe(eventType = {ApiConstants.EventType.ROTATE_START}, priority = 1, threadMode = ThreadMode.POSTING)
    public void notifyRotateStart(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1925792708")) {
            ipChange.ipc$dispatch("-1925792708", new Object[]{this, event});
            return;
        }
        Logger.d("rotategy", "startrotate");
        AlixPlayerContext alixPlayerContext = this.mPlayerContext;
        if (alixPlayerContext != null) {
            alixPlayerContext.put("pick_status", PickStatus.ROTATE_START);
        }
        PlaybackVariables playbackVariables = this.mPlaybackVariables;
        if (!(playbackVariables == null || playbackVariables.resultRotateCallback == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("key", CALLBACK_OROTATE_START);
            this.mPlaybackVariables.resultRotateCallback.onResult(hashMap);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("isStartRotate", Boolean.TRUE);
        this.mHandler.removeCallbacks(this.mRotateFinishRunnable);
        getEngineInstance().asyncPutData("LFLWDataCenterUnlimitRotate", hashMap2);
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener
    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1038131608")) {
            ipChange.ipc$dispatch("-1038131608", new Object[]{this, configuration});
            return;
        }
        this.mPlayerContext.onConfigurationChanged(configuration);
        int i2 = configuration.orientation;
        if (i2 == 2) {
            this.mPlaybackVariables.roomOrientation = Orientation.ORIENTATION_LANDSCAPE;
        } else if (i2 == 1) {
            this.mPlaybackVariables.roomOrientation = Orientation.ORIENTATION_PORTAIT;
        }
        this.mAlixPlayerTrack.onActivityConfigurationChanged(configuration);
        long currentTimeMillis = System.currentTimeMillis() - this.mScreenModeTime;
        this.mScreenModeTime = System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            if (this.mPlayerInfoSB == null) {
                this.mPlayerInfoSB = new StringBuilder();
            }
            if (!this.mPlayerInfoSB.toString().endsWith("0#") && !this.mPlayerInfoSB.toString().endsWith("1#") && !this.mPlayerInfoSB.toString().endsWith("2#") && !this.mPlayerInfoSB.toString().endsWith("3#")) {
                this.mPlayerInfoSB.append("1#");
            }
            StringBuilder sb = this.mPlayerInfoSB;
            sb.append(currentTimeMillis);
            sb.append(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            sb.append(this.mScreenModeTime);
            sb.append(";");
            Orientation orientation = this.mPlaybackVariables.roomOrientation;
            if (orientation == Orientation.ORIENTATION_PORTAIT) {
                this.mCurScreenMode = 1;
                StringBuilder sb2 = this.mPlayerInfoSB;
                sb2.append(1);
                sb2.append(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            } else if (orientation == Orientation.ORIENTATION_LANDSCAPE) {
                this.mCurScreenMode = 2;
                StringBuilder sb3 = this.mPlayerInfoSB;
                sb3.append(2);
                sb3.append(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            }
        }
        int i3 = AnonymousClass28.$SwitchMap$com$youku$live$widgets$protocol$Orientation[this.mPlaybackVariables.roomOrientation.ordinal()];
        if (i3 == 1) {
            this.mPlayerContext.setLandScreen(true);
            i = 1;
        } else if (i3 == 2) {
            this.mPlayerContext.setLandScreen(false);
        }
        Event event = new Event(ApiConstants.EventType.ON_SCREEN_MODE_CHANGE);
        event.data = Integer.valueOf(i);
        this.mPlayerContext.getEventBus().post(event);
        adjustCSSLayout();
        updatePlayerViewport();
        if (!isPickMode()) {
            updateNonplayerPluginsAppearance();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityKeyDownListener
    public boolean onActivityKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "723237184")) {
            return ((Boolean) ipChange.ipc$dispatch("723237184", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        } else if (!this.mPlayerContext.isDlnaMode() || (i != 25 && i != 24)) {
            return false;
        } else {
            Event event = new Event();
            event.type = ApiConstants.EventType.ON_ACTIVITY_KEY_DOWN;
            this.mKeyDownDatas.clear();
            this.mKeyDownDatas.put(ApiConstants.EventParams.KEY_CODE, Integer.valueOf(i));
            this.mKeyDownDatas.put(ApiConstants.EventParams.KEY_EVENT, keyEvent);
            event.data = this.mKeyDownDatas;
            this.mPlayerContext.getEventBus().post(event);
            return true;
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener
    public void onActivityLifecycleStateChanged(ActivityLifecycleState activityLifecycleState) {
        LiveFullInfoData liveFullInfoData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1087545403")) {
            ipChange.ipc$dispatch("-1087545403", new Object[]{this, activityLifecycleState});
            return;
        }
        Log.d(TAG, "onActivityLifecycleStateChanged " + activityLifecycleState.name());
        this.mAlixPlayerTrack.onActivityLifecycleStateChanged(activityLifecycleState);
        PlayVideoInfo playVideoInfo = this.mPlayerContainer.getPlayVideoInfo();
        int i = AnonymousClass28.$SwitchMap$com$youku$live$widgets$ActivityLifecycleState[activityLifecycleState.ordinal()];
        if (i != 2) {
            int i2 = 3;
            if (i == 3) {
                this.mPlayerContext.onActivityResume();
                if (mPlayerAudioFocusManager.isAudioFocusLoss()) {
                    mPlayerAudioFocusManager.setAudioFocusLoss(false);
                    if (this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                        this.mPlayerContainer.getPlayer().setMute(false);
                    } else {
                        startPlayingBranch(null, "audioFocus");
                    }
                }
                getAttentionState();
                if (this.mWidgetRootView.findViewWithTag("playerViewRoot") == null) {
                    if (TinyWindowManager.getInstance().isInTinyWindowMode()) {
                        TinyWindowManager.getInstance().closeTinyWindow();
                    }
                    if (TinyWindowManager.getInstance().getConfig() != null) {
                        this.mWidgetRootView.addView(TinyWindowManager.getInstance().getConfig().getPlayerView(), 0, new ViewGroup.LayoutParams(-1, -1));
                        updatePlayerViewport();
                    }
                    if (!isPlaying()) {
                        startPlayingBranch(null, "tinywindownotplaying");
                    } else {
                        this.mPlayerContainer.getPlayVideoInfo().putString("isTinyWindowPlay", "0");
                    }
                    this.mPlaybackVariables.isPlayerTakenByWindow = false;
                }
            } else if (i == 4) {
                this.mPlayerContext.onActivityPause();
            } else if (i == 5) {
                this.mPlayerContext.onActivityStop();
                if (this.mWidgetRootView.findViewWithTag("playerViewRoot") != null && playVideoInfo != null) {
                    if (playVideoInfo.getPlayType() == PlayType.LIVE) {
                        if (this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                            PlaybackVariables playbackVariables = this.mPlaybackVariables;
                            if (!(playbackVariables == null || (liveFullInfoData = playbackVariables.liveFullInfoData) == null)) {
                                i2 = liveFullInfoData.bizType.intValue();
                            }
                            if (!ConfigUtils.enableBackgroundPlay(i2) || !this.mPlaybackVariables.enableBgPlay) {
                                this.mPlayerContainer.getPlayer().stop();
                                this.mPlayerContainer.getMultiPlayer().stop();
                                return;
                            }
                            this.mPlayerContainer.getPlayer().setPlaybackParam(PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH, "1");
                            this.mPlayerContainer.getMultiPlayer().setPlaybackParam(PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH, "1");
                        }
                    } else if (this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                        this.mPlayerContainer.getPlayer().pause();
                    }
                }
            }
        } else {
            this.mPlayerContext.onActivityStart();
            if (!mPlayerAudioFocusManager.isAudioFocusLoss() && this.mWidgetRootView.findViewWithTag("playerViewRoot") != null && playVideoInfo != null) {
                if (playVideoInfo.getPlayType() == PlayType.LIVE) {
                    if (this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                        this.mPlayerContainer.getPlayer().setPlaybackParam(PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH, "0");
                        this.mPlayerContainer.getMultiPlayer().setPlaybackParam(PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH, "0");
                    } else if (this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_STOPPED) {
                        startPlayingBranch(null, "start");
                    }
                } else if (this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_VIDEO_PAUSED) {
                    this.mPlayerContainer.getPlayer().start();
                }
            }
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResultListener
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163921798")) {
            ipChange.ipc$dispatch("163921798", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        this.mPlayerContext.onActivityResult(i, i2, intent);
    }

    @Subscribe(eventType = {ApiConstants.EventType.ON_CONTROL_VISIBILITY_CHANGE}, priority = 1, threadMode = ThreadMode.POSTING)
    public void onControlVisibilityChange(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1375581698")) {
            ipChange.ipc$dispatch("-1375581698", new Object[]{this, event});
            return;
        }
        injectorCallbackControllerVisible(((Boolean) event.data).booleanValue());
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, final Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243819507")) {
            ipChange.ipc$dispatch("-1243819507", new Object[]{this, str, obj, obj2});
            return;
        }
        int i = AnonymousClass28.$SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$DataKey[DataKey.toDataKey(str).ordinal()];
        if (i == 1) {
            final boolean isSurportTinyWindow = TinyWindowManager.isSurportTinyWindow(this.mActivity, TinyWindowConfig.TINYWINDOW_TYPE.FLOATINGWINDOW);
            this.mHandler.post(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass7 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-262994600")) {
                        ipChange.ipc$dispatch("-262994600", new Object[]{this});
                        return;
                    }
                    AlixLivePlayback.this.getEngineInstance().asyncPutData("isSupportPipResult", Boolean.valueOf(isSurportTinyWindow));
                }
            });
        } else if (i == 2) {
            getEngineInstance().removeData("enterPipMode");
            if (!this.mPlayerContainer.getPlayer().getCurrentState().equals(IAlixPlayer.State.STATE_VIDEO_STARTED) || TinyWindowManager.getInstance().isInTinyWindowMode()) {
                getEngineInstance().asyncPutData("enterPipResult", 0);
                return;
            }
            initPIP((Activity) this.mContext);
            TinyWindowManager.getInstance().showTinyWindow();
        } else if (i == 4) {
            onLiveFullInfoAcquired((LiveFullInfoData) Utils.reinterpretCast(obj));
        } else if (i != 5) {
            if (i == 6 && obj != null) {
                this.isUnLimitedOpen = ((Boolean) ((Map) obj).get("open")).booleanValue();
                this.isUnLimitedOpen = false;
            }
        } else if (obj instanceof Boolean) {
            this.mHandler.post(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass8 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-459508105")) {
                        ipChange.ipc$dispatch("-459508105", new Object[]{this});
                        return;
                    }
                    AlixLivePlayback.this.startOrStopPlayLive(((Boolean) obj).booleanValue());
                }
            });
        }
    }

    @Override // com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.Receiver
    public void onMessage(DagoChannelPlugin.Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-510892789")) {
            ipChange.ipc$dispatch("-510892789", new Object[]{this, message});
            return;
        }
        int i = AnonymousClass28.$SwitchMap$com$youku$live$dago$liveplayback$widget$AlixLivePlayback$MessageKey[MessageKey.toMessageKey(message.msgType).ordinal()];
        if (i == 1) {
            JSONObject parseObject = JSON.parseObject(message.data);
            int intValue = parseObject.getIntValue("dt");
            final String string = parseObject.getString("params");
            runOnUIThread(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass9 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-656021610")) {
                        ipChange.ipc$dispatch("-656021610", new Object[]{this});
                        return;
                    }
                    AlixLivePlayback.this.startPlayingBranch(string, "micChange");
                }
            }, (long) ((int) (Math.random() * ((double) (intValue * 1000)))));
        } else if (i == 2) {
            final LiveStateChangeBean liveStateChangeBean = (LiveStateChangeBean) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(message.data, LiveStateChangeBean.class);
            runOnUIThread(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass10 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1879864674")) {
                        ipChange.ipc$dispatch("-1879864674", new Object[]{this});
                        return;
                    }
                    AlixLivePlayback.this.onLiveStateChange(liveStateChangeBean);
                }
            }, (long) ((int) (Math.random() * ((double) (liveStateChangeBean.dt * 1000)))));
        } else if (i == 3) {
            JSONObject parseObject2 = JSON.parseObject(message.data);
            int intValue2 = parseObject2.getIntValue("dt");
            final String string2 = parseObject2.getString("params");
            runOnUIThread(new Runnable() {
                /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass11 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2076378179")) {
                        ipChange.ipc$dispatch("-2076378179", new Object[]{this});
                        return;
                    }
                    if (AlixLivePlayback.this.mPlaybackVariables != null) {
                        AlixLivePlayback.this.mPlaybackVariables.degradationByMsg = true;
                    }
                    AlixLivePlayback.this.startPlayingBranch(string2, "refresh");
                }
            }, (long) ((int) (Math.random() * ((double) (intValue2 * 1000)))));
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.ENGINE_PUT_DATA}, priority = 1, threadMode = ThreadMode.POSTING)
    public void putAsyncPutData(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241701974")) {
            ipChange.ipc$dispatch("-241701974", new Object[]{this, event});
            return;
        }
        String str = event.message;
        Object obj = event.data;
        if (TextUtils.isEmpty(str)) {
            str = "LFLWDataCenterPlayerStateKey";
        }
        getEngineInstance().asyncPutData(str, obj);
    }

    @Subscribe(eventType = {ApiConstants.EventType.HBR_QUALITY_CHANGE_CLICK}, priority = 1, threadMode = ThreadMode.POSTING)
    public void reportChangeQualityClick(Event event) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011826189")) {
            ipChange.ipc$dispatch("1011826189", new Object[]{this, event});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", "a2h08.8176999.custom.qualities");
        hashMap.put("spm-name", "custom");
        PlaybackVariables playbackVariables = this.mPlaybackVariables;
        if (playbackVariables != null) {
            hashMap.put("liveid", playbackVariables.currentLiveId);
            hashMap.put("roomid", this.mPlaybackVariables.currentLiveId);
            hashMap.put("screenid", this.mPlaybackVariables.screenId);
            LiveFullInfoData liveFullInfoData = this.mPlaybackVariables.liveFullInfoData;
            if (liveFullInfoData != null) {
                if (liveFullInfoData.liveStatus.intValue() == 1) {
                    hashMap.put("type", "直播中");
                } else if (this.mPlaybackVariables.liveFullInfoData.liveStatus.intValue() == 0) {
                    hashMap.put("type", "预约");
                } else if (this.mPlaybackVariables.liveFullInfoData.liveStatus.intValue() == 2) {
                    hashMap.put("type", "回看");
                }
            }
            PlaybackVariables playbackVariables2 = this.mPlaybackVariables;
            if (!(playbackVariables2.roomOrientation == null || playbackVariables2.getFirstVideoOrientation() == null)) {
                Orientation firstVideoOrientation = this.mPlaybackVariables.getFirstVideoOrientation();
                Orientation orientation = Orientation.ORIENTATION_LANDSCAPE;
                if (firstVideoOrientation == orientation && this.mPlaybackVariables.roomOrientation == orientation) {
                    hashMap.put("direction", "fplayer");
                } else {
                    PlaybackVariables playbackVariables3 = this.mPlaybackVariables;
                    Orientation orientation2 = playbackVariables3.roomOrientation;
                    Orientation orientation3 = Orientation.ORIENTATION_PORTAIT;
                    if (orientation2 == orientation3) {
                        if (playbackVariables3.getFirstVideoOrientation() == orientation3) {
                            hashMap.put("direction", "vplayer");
                        } else {
                            hashMap.put("direction", "vhplayer");
                        }
                    }
                }
            }
        }
        if (!(event == null || (obj = event.data) == null)) {
            hashMap.put(Constants.Name.QUALITY, (String) ((HashMap) obj).get(Constants.Name.QUALITY));
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click("a2h08.8176999.custom.qualities", "custom", hashMap);
    }

    @Subscribe(eventType = {ApiConstants.EventType.REQUEST_DLNA_SHOW_SMALL, ApiConstants.EventType.REQUEST_DLNA_SHOW_FULLSCREEN}, priority = 1, threadMode = ThreadMode.POSTING)
    public void reportDlnaClick(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624255817")) {
            ipChange.ipc$dispatch("-1624255817", new Object[]{this, event});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", "a2h08.8176999.hplayer.castscreen");
        hashMap.put("spm-name", "hplayer");
        PlaybackVariables playbackVariables = this.mPlaybackVariables;
        if (playbackVariables != null) {
            hashMap.put("liveid", playbackVariables.currentLiveId);
            hashMap.put("roomid", this.mPlaybackVariables.currentLiveId);
            hashMap.put("screenid", this.mPlaybackVariables.screenId);
            LiveFullInfoData liveFullInfoData = this.mPlaybackVariables.liveFullInfoData;
            if (liveFullInfoData != null) {
                if (liveFullInfoData.liveStatus.intValue() == 1) {
                    hashMap.put("type", "直播中");
                } else if (this.mPlaybackVariables.liveFullInfoData.liveStatus.intValue() == 0) {
                    hashMap.put("type", "预约");
                } else if (this.mPlaybackVariables.liveFullInfoData.liveStatus.intValue() == 2) {
                    hashMap.put("type", "回看");
                }
            }
            PlaybackVariables playbackVariables2 = this.mPlaybackVariables;
            if (!(playbackVariables2.roomOrientation == null || playbackVariables2.getFirstVideoOrientation() == null)) {
                Orientation firstVideoOrientation = this.mPlaybackVariables.getFirstVideoOrientation();
                Orientation orientation = Orientation.ORIENTATION_LANDSCAPE;
                if (firstVideoOrientation == orientation && this.mPlaybackVariables.roomOrientation == orientation) {
                    hashMap.put("direction", "fplayer");
                } else {
                    PlaybackVariables playbackVariables3 = this.mPlaybackVariables;
                    Orientation orientation2 = playbackVariables3.roomOrientation;
                    Orientation orientation3 = Orientation.ORIENTATION_PORTAIT;
                    if (orientation2 == orientation3) {
                        if (playbackVariables3.getFirstVideoOrientation() == orientation3) {
                            hashMap.put("direction", "vplayer");
                        } else {
                            hashMap.put("direction", "vhplayer");
                        }
                    }
                }
            }
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click("a2h08.8176999.hplayer.castscreen", "hplayer_castscreen", hashMap);
    }

    public void setPlayerControlViewDisplay(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-72132895")) {
            ipChange.ipc$dispatch("-72132895", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mPlayerContext.getEventBus().post(new Event(z ? ApiConstants.EventType.SHOW_CONTROL : ApiConstants.EventType.HIDE_CONTROL));
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_BUY_VIEW}, priority = 1, threadMode = ThreadMode.POSTING)
    public void showBuyView(Event event) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1703605428")) {
            ipChange.ipc$dispatch("-1703605428", new Object[]{this, event});
        } else if (event != null && (obj = event.data) != null) {
            injectorBroadcastPayment((Map) obj);
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_ERROR}, priority = 1, threadMode = ThreadMode.POSTING)
    public void showError(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237732169")) {
            ipChange.ipc$dispatch("237732169", new Object[]{this, event});
        }
    }

    @Subscribe(eventType = {ApiConstants.EventType.SHOW_FREE_FLOW}, priority = 1, threadMode = ThreadMode.POSTING)
    public void showFreeFlow(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426206967")) {
            ipChange.ipc$dispatch("426206967", new Object[]{this, event});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.AlixLivePlayback.AnonymousClass20 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "618151263")) {
                    ipChange.ipc$dispatch("618151263", new Object[]{this});
                    return;
                }
                AlixLivePlayback.this.updateCoverImageState(false);
            }
        });
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-333068755")) {
            ipChange.ipc$dispatch("-333068755", new Object[]{this});
            return;
        }
        PerfLogUtils.log("AlixLivePlayback willAppear ... ");
        Log.i("lwj", "AlixLivePlayback will appear begin " + this);
        Log.d(LOG_TAG, "AlixLivePlayback@" + hashCode() + ".willAppear, liveID:" + this.mPlaybackVariables.currentLiveId);
        this.mPlaybackVariables.willAppearTime = System.currentTimeMillis();
        registerDataHandler();
        bindDagoChannel();
        if (!isOnWall(getEngineInstance().getOptions())) {
            startPlayingBranch(null, "willAppear");
            mute(true);
        }
        updateCoverImageState(true);
        showPreviewCoverImage(false);
        showPlaybackCoverLayout(false);
        adjustCSSLayout();
        preparePreRequestLiveInfo();
        adjustPlayerLayout();
        if (getEngineInstance() != null) {
            Log.d(TAG, "asyncPutData DAGO_NOTIFY_LAYOUT_PIP_ENABLE: " + this.mPlaybackVariables.pipEnable);
            getEngineInstance().asyncPutData("dagoNotifyLayoutPipEnable", Boolean.valueOf(this.mPlaybackVariables.pipEnable));
        }
        Log.i("lwj", "AlixLivePlayback will appear end " + this);
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void willDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1745802597")) {
            ipChange.ipc$dispatch("1745802597", new Object[]{this});
            return;
        }
        Log.d(LOG_TAG, "AlixLivePlayback@" + hashCode() + ".willDisappear, liveID:" + this.mPlaybackVariables.currentLiveId);
        updatePlayTimeTrackInfo();
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void willMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-60481873")) {
            ipChange.ipc$dispatch("-60481873", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void willUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127768696")) {
            ipChange.ipc$dispatch("-2127768696", new Object[]{this});
        }
    }

    private void runOnUIThread(@NonNull Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1036885012")) {
            ipChange.ipc$dispatch("-1036885012", new Object[]{this, runnable});
            return;
        }
        this.mHandler.post(runnable);
    }

    private boolean isOnWall(@NotNull IProps iProps) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "945586277")) {
            return !iProps.containsKey("is_key_read");
        }
        return ((Boolean) ipChange.ipc$dispatch("945586277", new Object[]{this, iProps})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPlaybackCoverLayout(int i, String str, boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "289323156")) {
            ipChange.ipc$dispatch("289323156", new Object[]{this, Integer.valueOf(i), str, Boolean.valueOf(z)});
            return;
        }
        PromptLayout promptLayout = this.mPromptLayout;
        if (promptLayout == null) {
            return;
        }
        if (z) {
            PlaybackVariables playbackVariables = this.mPlaybackVariables;
            if (!playbackVariables.playRecord) {
                return;
            }
            if (i != 1) {
                if (playbackVariables.streamOrientation != Orientation.ORIENTATION_LANDSCAPE) {
                    z3 = false;
                }
                promptLayout.updateView(z3);
                this.mPromptLayout.showPrompt(false);
            } else if (TextUtils.isEmpty(str)) {
                PromptLayout promptLayout2 = this.mPromptLayout;
                if (this.mPlaybackVariables.streamOrientation == Orientation.ORIENTATION_LANDSCAPE) {
                    z2 = true;
                }
                promptLayout2.updateView(z2);
                this.mPromptLayout.showPrompt(true);
            } else {
                startPlayingVidBranch(str);
            }
        } else {
            promptLayout.hidePrompt();
        }
    }

    @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface
    public void injectorPlayerAction(String str, List<Map<String, Object>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "947792804")) {
            ipChange.ipc$dispatch("947792804", new Object[]{this, str, list});
            return;
        }
        injectorInsertView2ControlPlugin(list);
    }
}
