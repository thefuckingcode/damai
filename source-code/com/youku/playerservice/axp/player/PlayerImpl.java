package com.youku.playerservice.axp.player;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.AlixPlayer;
import com.youku.alixplayer.AlixPlayerHolderUnbindListener;
import com.youku.alixplayer.AndroidXPlayer;
import com.youku.alixplayer.ConfigCenter;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.OnAdEventListener;
import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnLocalConfigCenterListener;
import com.youku.alixplayer.OnSeekCompleteListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.OnVideoSizeChangedListener;
import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.middleware.DefaultRenderMiddleware;
import com.youku.alixplayer.middleware.IRenderMiddleware;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.util.NativeMap;
import com.youku.arch.analysis.net.b;
import com.youku.arch.analysis.net.c;
import com.youku.arch.beast.apas.ApasConfigure;
import com.youku.arch.probe.plugins.a;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter;
import com.youku.live.livesdk.util.DebugViewHelper;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.phone.freeflow.utils.NetworkUtils;
import com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol;
import com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.axpinterface.PlayerAction;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.cellular.CellularPlayUtils;
import com.youku.playerservice.axp.drm.ProvisionAuthenticator;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.SliceItem;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.mediasource.AxpMediaSource;
import com.youku.playerservice.axp.mediasource.BaseMediaSource;
import com.youku.playerservice.axp.mediasource.LiveMediaSource;
import com.youku.playerservice.axp.mediasource.SystemUrlMediaSource;
import com.youku.playerservice.axp.mediasource.UpsMediaSource;
import com.youku.playerservice.axp.mediasource.UrlMediaSource;
import com.youku.playerservice.axp.modules.ModuleManager;
import com.youku.playerservice.axp.modules.postprocessing.FrameProcessingModule;
import com.youku.playerservice.axp.p2p.FreeFlowUtil;
import com.youku.playerservice.axp.p2p.P2pManager;
import com.youku.playerservice.axp.p2p.PcdnType;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playinfo.Point;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.NetworkDeviceInfoUtil;
import com.youku.playerservice.axp.utils.NetworkUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.vpm.Callable;
import com.youku.vpm.IPlayer;
import com.youku.vpm.PlayerTrack;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.TableId;
import java.util.HashMap;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class PlayerImpl implements AlixPlayerHolderUnbindListener, IPlayerImplProtocol, Callable, IPlayer {
    public static final int KEY_PARAMETER_SET_REAL_DRMKEY = 551;
    public static final int KEY_PARAMETER_SET_REAL_STARTTIME = 552;
    public static final int KEY_PARAMETER_SET_REAL_URL = 510;
    private static final String TAG = "PlayerImpl";
    private int abrCode;
    private IAlixPlayer mAlixPlayer;
    private Context mContext;
    private FrameProcessingModule mFrameProcessingModule;
    private Handler mHandler;
    private InternalPlayerEventListener mInternalPlayerEventListener;
    private volatile boolean mIsAutoPlay;
    private volatile boolean mIsLoopPlay;
    private volatile boolean mIsMuted;
    private volatile boolean mIsPreload;
    private Map<String, String> mLocalConfigCenter;
    private BaseMediaSource mMediaSource;
    private ModuleManager mModuleManager;
    private boolean mNotStopFlag;
    private OnAdEventListener mOnAdEventListener;
    private OnCurrentPositionChangeListener mOnCurrentPositionChangeListener;
    private OnInfoListener mOnInfoListener;
    private final OnLocalConfigCenterListener mOnLocalConfigCenterListener;
    private BaseMediaSource.OnMediaSourceListener mOnMediaSourceListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private OnStateChangeListener mOnStateChangeListener;
    private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private OtherFunc mOtherFunc;
    private PlayInfo mPlayInfo;
    private volatile double mPlaySpeed;
    private PlayerTrack mPlayerTrack;
    private IRenderMiddleware mRenderMiddleware;
    private volatile Surface mSurface;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.playerservice.axp.player.PlayerImpl$10  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$vpm$framework$TableId;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[TableId.values().length];
            $SwitchMap$com$youku$vpm$framework$TableId = iArr;
            iArr[TableId.ONEPLAY.ordinal()] = 1;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.IMPAIRMENT.ordinal()] = 2;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.BEFORE_PLAY.ordinal()] = 3;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.PLAYING.ordinal()] = 4;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.ONECHANGE_SEEK.ordinal()] = 5;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.ONECHANGE_QUALITY.ordinal()] = 6;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.PLAYHEARTBEAT.ordinal()] = 7;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.ONEEVENT.ordinal()] = 8;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.AD_PLAY.ordinal()] = 9;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.AD_ERROR.ordinal()] = 10;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.AD_IMPAIRMENT.ordinal()] = 11;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.START_LOADING.ordinal()] = 12;
            $SwitchMap$com$youku$vpm$framework$TableId[TableId.PLAY_ABNORMAL_DETAIL.ordinal()] = 13;
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.PLAY_ABNORMAL_SUMMARY.ordinal()] = 14;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    private class YKRenderMiddleware extends DefaultRenderMiddleware {
        private YKRenderMiddleware() {
        }

        @Override // com.youku.alixplayer.middleware.DefaultRenderMiddleware
        public boolean processData(byte[] bArr, Map<Integer, String> map, long j, long j2, long j3, long j4, long j5) {
            if (PlayerImpl.this.mFrameProcessingModule == null) {
                return false;
            }
            PlayerImpl.this.mFrameProcessingModule.processData(bArr, map, j, j2, j3, j4, j5);
            return false;
        }
    }

    private PlayerImpl(Context context) {
        this(context, null, false);
    }

    private PlayerImpl(Context context, Handler handler) {
        this(context, handler, false);
    }

    private PlayerImpl(Context context, Handler handler, boolean z) {
        this.mPlaySpeed = 1.0d;
        this.mNotStopFlag = false;
        this.mIsAutoPlay = true;
        this.mLocalConfigCenter = new HashMap();
        this.mOtherFunc = new OtherFunc();
        this.mOnLocalConfigCenterListener = new OnLocalConfigCenterListener() {
            /* class com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00d7  */
            @Override // com.youku.alixplayer.OnLocalConfigCenterListener
            public String getLocalConfig(String str, String str2, String str3) {
                int i;
                Object obj;
                if ("host".equals(str)) {
                    Map parse = PlayerImpl.this.parse(str2);
                    if ("doubleChannelEnable".equals(parse.get("queryType"))) {
                        return PlayerImpl.this.isDoubleChannelEnable(parse) ? "1" : "0";
                    }
                    String str4 = (String) parse.get("url");
                    if (!TextUtils.isEmpty(str4)) {
                        return PlayerImpl.this.getDomain(str4, str2);
                    }
                    return null;
                }
                boolean z = false;
                if ("downloader_info".equals(str)) {
                    String str5 = (String) PlayerImpl.this.mLocalConfigCenter.get(str2);
                    if ("isFeedMode".equals(str2)) {
                        return PlayerImpl.this.mPlayInfo.getPlayParams().getPlayScene() == PlayDefinition.PlayScene.SHORT_VIDEO ? "1" : "0";
                    }
                    if ("isFreeFlow".equals(str2)) {
                        try {
                            if (Utils.isYoukuOrHuaweiBaipai(PlayerImpl.this.mContext)) {
                                String str6 = FreeFlowUtil.FREEFLOWCALLER_ONDEMAND;
                                if (PlayerImpl.this.mPlayInfo.getPlayParams().getPlayScene() == PlayDefinition.PlayScene.SHORT_VIDEO) {
                                    str6 = "feed";
                                } else if (PlayerImpl.this.mPlayInfo.getPlayParams().getPlayScene() == PlayDefinition.PlayScene.LIVE_YOUKU || PlayerImpl.this.mPlayInfo.getPlayParams().getPlayScene() == PlayDefinition.PlayScene.LIVE_LAIFENG) {
                                    str6 = "live";
                                }
                                if (FreeFlowUtil.isFreeFlow(PlayerImpl.this.mContext, str6)) {
                                    obj = "1";
                                    return !"0".equals(obj) ? "0" : "1";
                                }
                            }
                        } catch (Exception unused) {
                        }
                        obj = "0";
                        if (!"0".equals(obj)) {
                        }
                    } else if (!"canUseP2P".equals(str2)) {
                        return null;
                    } else {
                        try {
                            if (Utils.isYoukuOrHuaweiBaipai(PlayerImpl.this.mContext)) {
                                PcdnType pcdnType = PcdnType.NONE;
                                if (PlayerImpl.this.mPlayInfo.getPlayParams().getPlayScene() != PlayDefinition.PlayScene.LONG_VIDEO) {
                                    if (PlayerImpl.this.mPlayInfo.getPlayParams().getPlayScene() != PlayDefinition.PlayScene.SHORT_VIDEO) {
                                        if (PlayerImpl.this.mPlayInfo.getPlayParams().getPlayScene() == PlayDefinition.PlayScene.LIVE_YOUKU || PlayerImpl.this.mPlayInfo.getPlayParams().getPlayScene() == PlayDefinition.PlayScene.LIVE_LAIFENG) {
                                            pcdnType = PcdnType.LIVE;
                                        }
                                        z = P2pManager.getInstance(PlayerImpl.this.mContext).canUseP2PWithNetStatus(PlayerImpl.this.mContext, pcdnType);
                                    }
                                }
                                pcdnType = PcdnType.VOD;
                                z = P2pManager.getInstance(PlayerImpl.this.mContext).canUseP2PWithNetStatus(PlayerImpl.this.mContext, pcdnType);
                            }
                        } catch (Exception unused2) {
                        }
                        return z ? "1" : "0";
                    }
                } else if ("device_info".equals(str)) {
                    if ("ip_mac_sim".equals(str2)) {
                        return Utils.isYoukuOrHuaweiBaipai(PlayerImpl.this.mContext) ? NetworkDeviceInfoUtil.getCacheIpAndMacAndSimInfo() : "";
                    }
                    return null;
                } else if (!DebugViewHelper.PLAY_INFO_TAG.equals(str)) {
                    return null;
                } else {
                    try {
                        if (Utils.isYoukuOrHuaweiBaipai(PlayerImpl.this.mContext)) {
                            if ("netHighLatency".equals(str2)) {
                                return String.valueOf(c.a().b().a());
                            }
                            if ("hms_bandwidth".equals(str2)) {
                                if (com.youku.arch.probe.plugins.c.a(a.c) != null) {
                                    return String.valueOf(((a) com.youku.arch.probe.plugins.c.a(a.c)).b());
                                }
                                return null;
                            } else if ("net_score".equals(str2)) {
                                return String.valueOf(b.a().b());
                            } else {
                                if ("net_bandwidth".equals(str2)) {
                                    String str7 = com.youku.arch.probe.plugins.b.c;
                                    if (com.youku.arch.probe.plugins.c.a(str7) == null) {
                                        return null;
                                    }
                                    double[] d = ((com.youku.arch.probe.plugins.b) com.youku.arch.probe.plugins.c.a(str7)).d();
                                    if (d[1] != -1.0d) {
                                        return String.valueOf(d[1]);
                                    }
                                    return null;
                                } else if ("net_bw_range".equals(str2)) {
                                    String str8 = com.youku.arch.probe.plugins.b.c;
                                    if (com.youku.arch.probe.plugins.c.a(str8) == null) {
                                        return null;
                                    }
                                    double[] d2 = ((com.youku.arch.probe.plugins.b) com.youku.arch.probe.plugins.c.a(str8)).d();
                                    if (d2[1] == -1.0d) {
                                        return null;
                                    }
                                    return d2[0] + "-" + d2[2];
                                } else if ("enableNetDetection".equals(str2)) {
                                    return ConfigFetcher.getInstance().getConfig("speed_test", "enable_wifi_monitor", "0");
                                } else {
                                    if ("nwNetCost".equals(str2)) {
                                        com.youku.arch.analysis.net.a b = c.a().b();
                                        if (b == null || (i = b.c) <= 0) {
                                            return null;
                                        }
                                        return String.valueOf(i);
                                    } else if ("uplayer_ups_net_cost".equals(str2)) {
                                        PlayInfoResponse playInfoResponse = PlayerImpl.this.mPlayInfo.getPlayInfoResponse();
                                        if (playInfoResponse == null) {
                                            return null;
                                        }
                                        if (playInfoResponse.getInfoType() == PlayDefinition.PlayInfoType.UPS && playInfoResponse.getUpsInfo() != null) {
                                            NetUpsInfo upsInfo = playInfoResponse.getUpsInfo();
                                            if (upsInfo == null || upsInfo.getVideoInfo() == null || upsInfo.getVideoInfo().getConnectStat().mUpsTimeTraceBean.timeStartParseResult <= 0) {
                                                return null;
                                            }
                                            return String.valueOf(upsInfo.getVideoInfo().getConnectStat().mUpsTimeTraceBean.timeStartParseResult);
                                        } else if (playInfoResponse.getInfoType() != PlayDefinition.PlayInfoType.LIVE || playInfoResponse.getDurationOfRequest() <= 0) {
                                            return null;
                                        } else {
                                            return String.valueOf(playInfoResponse.getDurationOfRequest());
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception unused3) {
                    }
                    return "";
                }
            }
        };
        this.mOnMediaSourceListener = new BaseMediaSource.OnMediaSourceListener() {
            /* class com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass3 */

            @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource.OnMediaSourceListener
            public void onPlaylistFailed(int i) {
                if (PlayerImpl.this.mPlayerTrack != null) {
                    PlayerImpl.this.mPlayerTrack.onError(0, i, null);
                }
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onError(i);
                }
            }
        };
        this.mOnStateChangeListener = new OnStateChangeListener() {
            /* class com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass4 */

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                if (ApsUtil.handleStateChangedSyncEnable()) {
                    synchronized (PlayerImpl.this) {
                        PlayerImpl.this.handleStateChanged(state, state2);
                    }
                    return;
                }
                PlayerImpl.this.handleStateChanged(state, state2);
            }
        };
        this.mOnVideoSizeChangedListener = new OnVideoSizeChangedListener() {
            /* class com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass5 */

            @Override // com.youku.alixplayer.OnVideoSizeChangedListener
            public void onVideoSizeChange(int i, int i2) {
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onVideoSizeChanged(i, i2);
                }
            }
        };
        this.mOnAdEventListener = new OnAdEventListener() {
            /* class com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass6 */

            @Override // com.youku.alixplayer.OnAdEventListener
            public void onAdCountDown(int i) {
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onAdCountDown(i);
                }
            }

            @Override // com.youku.alixplayer.OnAdEventListener
            public void onAdEnd(int i, int i2) {
                InternalPlayerEventListener internalPlayerEventListener;
                InternalPlayerEventListener.ADType aDType;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4 && PlayerImpl.this.mInternalPlayerEventListener != null) {
                                internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                                aDType = InternalPlayerEventListener.ADType.POST_AD;
                            } else {
                                return;
                            }
                        } else if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                            internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                            aDType = InternalPlayerEventListener.ADType.MID_AD;
                        } else {
                            return;
                        }
                    } else if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                        internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                        aDType = InternalPlayerEventListener.ADType.PRE_VIPAD;
                    } else {
                        return;
                    }
                } else if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                    aDType = InternalPlayerEventListener.ADType.PRE_AD;
                } else {
                    return;
                }
                internalPlayerEventListener.onAdEnd(aDType, i);
            }

            @Override // com.youku.alixplayer.OnAdEventListener
            public void onAdStart(int i, int i2) {
                InternalPlayerEventListener internalPlayerEventListener;
                InternalPlayerEventListener.ADType aDType;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4 && PlayerImpl.this.mInternalPlayerEventListener != null) {
                                internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                                aDType = InternalPlayerEventListener.ADType.POST_AD;
                            } else {
                                return;
                            }
                        } else if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                            internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                            aDType = InternalPlayerEventListener.ADType.MID_AD;
                        } else {
                            return;
                        }
                    } else if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                        internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                        aDType = InternalPlayerEventListener.ADType.PRE_VIPAD;
                    } else {
                        return;
                    }
                } else if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                    aDType = InternalPlayerEventListener.ADType.PRE_AD;
                } else {
                    return;
                }
                internalPlayerEventListener.onAdStart(aDType, i);
            }
        };
        this.mOnCurrentPositionChangeListener = new OnCurrentPositionChangeListener() {
            /* class com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass7 */

            @Override // com.youku.alixplayer.OnCurrentPositionChangeListener
            public void onCurrentPostionChange(int i) {
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onPositionChange(i);
                }
            }
        };
        this.mOnSeekCompleteListener = new OnSeekCompleteListener() {
            /* class com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass8 */

            @Override // com.youku.alixplayer.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onSeekFinish(true, new HashMap());
                }
            }
        };
        this.mOnInfoListener = new OnInfoListener() {
            /* class com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass9 */

            /* JADX WARNING: Code restructure failed: missing block: B:111:0x0296, code lost:
                if (r5.this$0.mInternalPlayerEventListener == null) goto L_0x02a1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:78:0x017c, code lost:
                if (r5.this$0.mInternalPlayerEventListener != null) goto L_0x0298;
             */
            /* JADX WARNING: Removed duplicated region for block: B:115:0x02a9  */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x02b3  */
            @Override // com.youku.alixplayer.OnInfoListener
            public void onInfo(int i, int i2, int i3, Object obj) {
                if (MsgIdGroup.isErrorCode(i)) {
                    PlayerImpl.this.stop();
                    if (PlayerImpl.this.mModuleManager != null) {
                        PlayInfo playInfo = PlayerImpl.this.mPlayInfo;
                        if (playInfo.getPlayType() == PlayDefinition.PlayType.VOD && ((VodItem) playInfo.getPlayItem()).getBitStream().onlyHasSliceItem()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("fastTsUrlRetry", i2 + "");
                            hashMap.put("disableAd", "1");
                            PlayerImpl.this.logWithSessionId("唤端首分片起播失败，进行ups大刷重试 errorCode=" + i2);
                            PlayerImpl.this.replayWithRequest(hashMap);
                            return;
                        } else if (PlayerImpl.this.mModuleManager.onError(i, i2, obj)) {
                            PlayerImpl.this.logWithSessionId("错误拦截，不对外通知错误码 " + i2);
                            return;
                        }
                    }
                    if (PlayerImpl.this.mPlayerTrack != null) {
                        try {
                            PlayerImpl.this.mPlayerTrack.onError(i, i2, obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                        PlayerImpl.this.mInternalPlayerEventListener.onError(i2);
                    }
                } else if (!(i == -4 || i == 4 || i == 1024 || i == 1031 || i == 2006 || i == 2012 || i == 3200 || i == 60100)) {
                    if (i == 1003) {
                        if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                            if (NetworkUtil.hasInternet(PlayerImpl.this.mContext) || PlayerImpl.this.mPlayInfo == null || PlayerImpl.this.mPlayInfo.getPlayItem() == null || !(PlayerImpl.this.mPlayInfo.getPlayItem() instanceof VodItem) || ((VodItem) PlayerImpl.this.mPlayInfo.getPlayItem()).isCache()) {
                                String str = "卡顿开始  arg1:" + i2 + " arg2:" + i3 + " obj" + obj;
                                if (i2 != 1) {
                                    str = "[realLoadingStart]" + str;
                                }
                                PlayerImpl.this.logWithSessionId(str);
                                PlayerImpl.this.mInternalPlayerEventListener.onStartLoading();
                                PlayerImpl.this.mInternalPlayerEventListener.onInfo(i, i2, i3, obj);
                            } else {
                                PlayerImpl.this.stop();
                                if (PlayerImpl.this.mPlayerTrack != null) {
                                    PlayerImpl.this.mPlayerTrack.onError(0, ErrorCode.NO_NETWORK_LOADING, null);
                                }
                                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                                    PlayerImpl.this.mInternalPlayerEventListener.onError(ErrorCode.NO_NETWORK_LOADING);
                                    return;
                                }
                                return;
                            }
                        }
                        if (PlayerImpl.this.mPlayerTrack != null) {
                        }
                    } else if (i != 1004) {
                        if (i != 1021) {
                            if (i != 1022) {
                                if (i != 2016) {
                                    if (!(i == 2017 || i == 3011 || i == 3012 || i == 3015 || i == 3016)) {
                                        switch (i) {
                                            case 3003:
                                                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                                                    PlayerImpl.this.mInternalPlayerEventListener.onScreenShotFinished();
                                                    break;
                                                }
                                                break;
                                            case 3004:
                                            case 3005:
                                                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                                                    PlayerImpl.this.mInternalPlayerEventListener.onScreenShotProgress(i2);
                                                    break;
                                                }
                                                break;
                                            case 3006:
                                                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                                                    PlayerImpl.this.mInternalPlayerEventListener.onPreviewEnd();
                                                    break;
                                                }
                                                break;
                                            case 3007:
                                                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                                                    PlayerImpl.this.mInternalPlayerEventListener.onPreviewChange(obj);
                                                    break;
                                                }
                                                break;
                                            case 3008:
                                                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                                                    PlayerImpl.this.mInternalPlayerEventListener.onScreenShotVideoEncoderMode(i2);
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (i) {
                                                    default:
                                                        switch (i) {
                                                        }
                                                    case 60001:
                                                    case 60002:
                                                    case 60003:
                                                        break;
                                                }
                                        }
                                    }
                                } else {
                                    PlayerImpl.this.abrCode = i2;
                                }
                            } else if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                                PlayerImpl.this.mInternalPlayerEventListener.onQualityChangeFinish(false, null);
                            }
                        } else if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                            PlayerImpl.this.mInternalPlayerEventListener.onQualityChangeFinish(true, null);
                        }
                        if (PlayerImpl.this.mPlayerTrack != null) {
                            PlayerImpl.this.mPlayerTrack.onInfo(i, i2, i3, obj);
                        } else {
                            PlayerImpl.this.mPlayInfo.putString("prePlayerCoreParams", String.valueOf(obj));
                        }
                    } else {
                        if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                            PlayerImpl.this.logWithSessionId("卡顿结束 arg1:" + i2 + " arg2:" + i3 + " obj:" + obj);
                            PlayerImpl.this.mInternalPlayerEventListener.onEndLoading();
                            PlayerImpl.this.mInternalPlayerEventListener.onInfo(i, i2, i3, obj);
                        }
                        if (PlayerImpl.this.mPlayerTrack != null) {
                        }
                    }
                }
            }
        };
        ProvisionAuthenticator.checkProvision();
        this.mContext = context;
        this.mIsPreload = z;
        if (!this.mIsPreload) {
            this.mPlayerTrack = new PlayerTrack(context, this);
            this.mModuleManager = new ModuleManager(context, this, handler);
            if (ModuleManager.enable("frame_processing", "0")) {
                FrameProcessingModule frameProcessingModule = new FrameProcessingModule(context, this);
                this.mFrameProcessingModule = frameProcessingModule;
                this.mModuleManager.add(frameProcessingModule);
            }
        }
        this.mHandler = handler;
        if (RemoteLogger.getRemoteAdaptor() == null) {
            RemoteLogger.setRemoteAdapter(RemoteAdapter.getInstance());
        }
    }

    private PlayerImpl(Context context, boolean z) {
        this(context, null, z);
    }

    private void continuePlayRealVideo(VodItem vodItem, SliceItem sliceItem) {
        BitStream bitStream = vodItem.getBitStream();
        String m3u8Url = bitStream.getM3u8Url();
        if (!TextUtils.isEmpty(m3u8Url)) {
            long tsDurSeconds = ((long) (((int) sliceItem.getTsDurSeconds()) * 1000)) + sliceItem.getStartPos();
            String drmKey = bitStream.getDrmKey();
            if (TextUtils.isEmpty(drmKey)) {
                drmKey = "";
            }
            logWithSessionId((((("正片续播：" + " startTime=" + tsDurSeconds) + " streamType=" + bitStream.getStreamType()) + " duration=" + sliceItem.getTotalDuration()) + " drmKey=" + drmKey) + " url=\n" + m3u8Url);
            PlayerTrack playerTrack = this.mPlayerTrack;
            if (playerTrack != null) {
                playerTrack.putTimestamp("realVideoResultTs", System.currentTimeMillis());
            }
            this.mAlixPlayer.setPlaybackParam(552, tsDurSeconds + "");
            this.mAlixPlayer.setPlaybackParam(551, drmKey);
            this.mAlixPlayer.setPlaybackParam(510, m3u8Url);
            return;
        }
        InternalPlayerEventListener internalPlayerEventListener = this.mInternalPlayerEventListener;
        if (internalPlayerEventListener != null) {
            internalPlayerEventListener.onError(28001);
        }
    }

    public static IPlayerImplProtocol createPlayer(Context context) {
        return new PlayerImpl(context);
    }

    public static IPlayerImplProtocol createPlayer(Context context, Handler handler) {
        return new PlayerImpl(context, handler);
    }

    public static IPlayerImplProtocol createPlayer(Context context, boolean z) {
        return new PlayerImpl(context, z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b5 A[RETURN] */
    private String getDomain(String str, String str2) {
        String host;
        String str3;
        Logger.d(TAG, "get host for single slice called with:" + str);
        Map<String, String> parse = parse(str2);
        if (this.mPlayInfo.getPlayInfoResponse() != null) {
            if (!(this.mPlayInfo.getPlayInfoResponse().getInfoType() != PlayDefinition.PlayInfoType.UPS || this.mPlayInfo.getPlayInfoResponse().getUpsInfo() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo() == null)) {
                String domainController = this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getDomainController();
                if (!TextUtils.isEmpty(domainController)) {
                    parse.put("domainController", domainController);
                }
            }
            parse.put(TLogEventConst.PARAM_UPLOAD_FILE_TYPE, getFileFormat(str));
            if (this.mPlayInfo.getPlayScene() == PlayDefinition.PlayScene.SHORT_VIDEO) {
                str3 = "feed";
            } else {
                if (!TextUtils.isEmpty(str)) {
                    String queryParameter = Uri.parse(str).getQueryParameter("ykVideoShowType");
                    str3 = ("2".equals(queryParameter) || "3".equals(queryParameter)) ? PluginName.AD : "video";
                }
                host = CellularPlayUtils.getHost(str, parse);
                if (!TextUtils.isEmpty(host)) {
                    return host;
                }
            }
            parse.put("playMode", str3);
            host = CellularPlayUtils.getHost(str, parse);
            if (!TextUtils.isEmpty(host)) {
            }
        }
        boolean z = false;
        if (FeatureManager.getInstance().hasFreeFlow()) {
            z = NetworkUtils.isConnectedCellular();
        }
        return z ? this.mPlayInfo.getPlayItem().getCellularDomain() : this.mPlayInfo.getPlayItem().getWifiDomain();
    }

    private String getFileFormat(String str) {
        return (TextUtils.isEmpty(str) || (!str.contains(".m3u8") && !str.contains(".ts"))) ? YKLAnimationViewAdapter.TYPE_MP4 : LiveManager.StreamConfig.FORMAT_HLS;
    }

    private Reporter.MonitorTableName getTableName(TableId tableId) {
        switch (AnonymousClass10.$SwitchMap$com$youku$vpm$framework$TableId[tableId.ordinal()]) {
            case 1:
                return Reporter.MonitorTableName.ONE_PLAY;
            case 2:
                return Reporter.MonitorTableName.IMPAIRMENT;
            case 3:
                return Reporter.MonitorTableName.BEFORE_PLAY;
            case 4:
                return Reporter.MonitorTableName.PLAYING;
            case 5:
                return Reporter.MonitorTableName.ONE_CHANGE_SEEK;
            case 6:
                return Reporter.MonitorTableName.ONE_CHANGE_QUALITY;
            case 7:
                return Reporter.MonitorTableName.PLAY_HEART_BEAT;
            case 8:
                return Reporter.MonitorTableName.ONE_EVENT;
            case 9:
                return Reporter.MonitorTableName.AD_PLAY;
            case 10:
                return Reporter.MonitorTableName.AD_ERROR;
            case 11:
                return Reporter.MonitorTableName.AD_IMPAIRMENT;
            case 12:
            default:
                return null;
            case 13:
                return Reporter.MonitorTableName.PLAY_ABNORMAL_DETAIL;
            case 14:
                return Reporter.MonitorTableName.PLAY_ABNORMAL_SUMMARY;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleStateChanged(IAlixPlayer.State state, IAlixPlayer.State state2) {
        InternalPlayerEventListener internalPlayerEventListener;
        if (this.mAlixPlayer != null) {
            TLogUtil.loge(CacheManager.TAG_PLAYER, "playerImpl:" + hashCode() + " player:" + this.mAlixPlayer.hashCode() + "-state-" + state2);
            if (state2 == IAlixPlayer.State.STATE_SOURCE_READY) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d(TAG, "prepare called:" + currentTimeMillis);
                PlayerTrack playerTrack = this.mPlayerTrack;
                if (playerTrack != null) {
                    playerTrack.putTimestamp("playlistEndTs", currentTimeMillis);
                    this.mPlayerTrack.putTimestamp("playerPrepareTs", currentTimeMillis);
                } else {
                    this.mPlayInfo.putString("prePlaylistEndTs", String.valueOf(currentTimeMillis));
                    this.mPlayInfo.putString("prePlayerPrepareTs", String.valueOf(currentTimeMillis));
                }
                logWithSessionId("prepare");
                this.mAlixPlayer.prepareAsync();
            } else if (state2 == IAlixPlayer.State.STATE_PREPARED) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d(TAG, "start called:" + currentTimeMillis2);
                logWithSessionId("内核准备完成，player调用start开始播放");
                PlayerTrack playerTrack2 = this.mPlayerTrack;
                if (playerTrack2 != null) {
                    playerTrack2.putTimestamp("playerPreparedTs", currentTimeMillis2);
                } else {
                    this.mPlayInfo.putString("prePlayerPreparedTs", String.valueOf(currentTimeMillis2));
                }
                if (this.mIsAutoPlay) {
                    logWithSessionId("first start");
                    this.mAlixPlayer.start();
                }
                InternalPlayerEventListener internalPlayerEventListener2 = this.mInternalPlayerEventListener;
                if (internalPlayerEventListener2 != null) {
                    internalPlayerEventListener2.onPrepared();
                }
            } else if (state != IAlixPlayer.State.STATE_VIDEO_PAUSED && state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                this.mAlixPlayer.setIsLoopPlay(this.mIsLoopPlay);
                InternalPlayerEventListener internalPlayerEventListener3 = this.mInternalPlayerEventListener;
                if (internalPlayerEventListener3 != null) {
                    internalPlayerEventListener3.onRealVideoStart();
                }
            } else if (state2 == IAlixPlayer.State.STATE_VIDEO_COMPLETED && (internalPlayerEventListener = this.mInternalPlayerEventListener) != null) {
                internalPlayerEventListener.onComplete();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isDoubleChannelEnable(Map<String, String> map) {
        return CellularPlayUtils.isDoubleChannelEnable(map);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void logWithSessionId(String str) {
        PlayInfo playInfo = this.mPlayInfo;
        logWithSessionId(playInfo != null ? playInfo.getPlayParams().getSessionId() : null, str);
    }

    private void logWithSessionId(String str, String str2) {
        if (this.mIsPreload) {
            str2 = "预播放 " + str2;
        }
        TLogUtil.flowLog(str, str2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<String, String> parse(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(";")) {
                String[] split = str2.split("=", 2);
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    private void setDataSource(PlayInfo playInfo) {
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.putTimestamp("playWithMediaSourceTs", System.currentTimeMillis());
        }
        BaseMediaSource systemUrlMediaSource = PlayerManager.getInstance().useSystemPlayer() ? new SystemUrlMediaSource(this.mContext, playInfo) : playInfo.getPlayType() == PlayDefinition.PlayType.VOD ? new UpsMediaSource(this.mContext, playInfo) : playInfo.getPlayType() == PlayDefinition.PlayType.LIVE ? new LiveMediaSource(this.mContext, playInfo) : new UrlMediaSource(this.mContext, playInfo);
        systemUrlMediaSource.setOnMediaSourceListener(this.mOnMediaSourceListener);
        this.mMediaSource = systemUrlMediaSource;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            PlayerTrack playerTrack2 = this.mPlayerTrack;
            if (playerTrack2 != null) {
                playerTrack2.putTimestamp("playlistStartTs", currentTimeMillis);
            } else {
                playInfo.putString("prePlaylistStartTs", currentTimeMillis + "");
            }
            this.mAlixPlayer.setDataSource(systemUrlMediaSource);
        } catch (Exception unused) {
            PlayerTrack playerTrack3 = this.mPlayerTrack;
            if (playerTrack3 != null) {
                playerTrack3.onError(0, ErrorCode.PLAY_LIST_CONSTRUCT_ERROR, null);
            }
            InternalPlayerEventListener internalPlayerEventListener = this.mInternalPlayerEventListener;
            if (internalPlayerEventListener != null) {
                internalPlayerEventListener.onError(ErrorCode.PLAY_LIST_CONSTRUCT_ERROR);
            }
        }
    }

    @Override // com.youku.vpm.Callable
    public String call(String str) {
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo == null || playInfo.getPlayerConfig() == null) {
            return null;
        }
        return this.mPlayInfo.getPlayerConfig().getDynamicProperty(str);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void changeVideoSize(int i, int i2) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.changeVideoSize(i, i2);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized Object doAction(PlayerAction playerAction, Map<String, Object> map) {
        IAlixPlayer iAlixPlayer;
        Period period;
        if (playerAction == PlayerAction.GET_PLAYER_HASHCODE) {
            IAlixPlayer iAlixPlayer2 = this.mAlixPlayer;
            if (iAlixPlayer2 != null) {
                return Integer.valueOf(iAlixPlayer2.hashCode());
            }
            return null;
        } else if (playerAction == PlayerAction.SWITCH_PLAYER_MODE) {
            if (this.mAlixPlayer != null) {
                try {
                    this.mAlixPlayer.switchPlayerMode(((Integer) map.get("vrMode")).intValue(), ((Integer) map.get("vrType")).intValue());
                } catch (Exception unused) {
                }
            }
            return null;
        } else if (playerAction == PlayerAction.SET_BINOCULAR_MODE) {
            if (this.mAlixPlayer != null) {
                try {
                    this.mAlixPlayer.setBinocularMode(((Boolean) map.get("sw")).booleanValue());
                } catch (Exception unused2) {
                }
            }
            return null;
        } else if (playerAction == PlayerAction.GET_RENDER_TYPE) {
            IAlixPlayer iAlixPlayer3 = this.mAlixPlayer;
            if (iAlixPlayer3 != null) {
                return Integer.valueOf(iAlixPlayer3.getCurrentRenderType());
            }
            return null;
        } else if (playerAction == PlayerAction.QUERY_SIX_DOF_ANGLE) {
            IAlixPlayer iAlixPlayer4 = this.mAlixPlayer;
            return iAlixPlayer4 != null ? Float.valueOf(iAlixPlayer4.querySixDofAngle()) : Float.valueOf(-1.0f);
        } else if (playerAction == PlayerAction.SCREENSHOT_ONE_FRAME) {
            try {
                IAlixPlayer iAlixPlayer5 = this.mAlixPlayer;
                if (iAlixPlayer5 != null && !isFree(iAlixPlayer5)) {
                    return Integer.valueOf(this.mAlixPlayer.screenShotOneFrame((AssetManager) map.get("assetManager"), (String) map.get("outPath"), ((Integer) map.get("outWidth")).intValue(), ((Integer) map.get("outHeight")).intValue(), ((Integer) map.get("outFmt")).intValue(), (String) map.get("logoPath"), ((Integer) map.get("logoWidth")).intValue(), ((Integer) map.get("logoHeight")).intValue(), ((Integer) map.get("logoLeft")).intValue(), ((Integer) map.get("logoTop")).intValue()));
                }
            } catch (Exception unused3) {
            }
            return -1;
        } else {
            if (playerAction == PlayerAction.SCREENSHOT_MULTI_FRAMES_BEGIN) {
                try {
                    IAlixPlayer iAlixPlayer6 = this.mAlixPlayer;
                    if (iAlixPlayer6 != null && !isFree(iAlixPlayer6)) {
                        String str = (String) map.get("outPath");
                        int intValue = ((Integer) map.get("outWidth")).intValue();
                        int intValue2 = ((Integer) map.get("outHeight")).intValue();
                        int intValue3 = ((Integer) map.get(LoginConstant.START_TIME)).intValue();
                        int intValue4 = ((Integer) map.get("endTime")).intValue();
                        int intValue5 = ((Integer) map.get("mode")).intValue();
                        BitStream bitStream = ((PlayInfoUpsResponse) this.mPlayInfo.getPlayInfoResponse()).getPlayItem(this.mPlayInfo.getPlayParams(), Quality.HD2, (String) null).getBitStream();
                        Period period2 = new Period();
                        period2.setType(0);
                        period2.addSource(new Source(bitStream.getM3u8Url(), (double) bitStream.getDuration()));
                        return Integer.valueOf(this.mAlixPlayer.screenShotMultiFramesBegin(str, intValue, intValue2, period2, intValue3, intValue4, intValue5));
                    }
                } catch (Exception unused4) {
                }
                return -1;
            } else if (playerAction == PlayerAction.SCREENSHOT_MULTI_FRAMES_END) {
                try {
                    IAlixPlayer iAlixPlayer7 = this.mAlixPlayer;
                    if (iAlixPlayer7 != null && !isFree(iAlixPlayer7)) {
                        return Integer.valueOf(this.mAlixPlayer.screenShotMultiFramesEnd(((Integer) map.get("formatType")).intValue(), ((Integer) map.get("endType")).intValue(), ((Integer) map.get(LoginConstant.START_TIME)).intValue(), ((Integer) map.get("endTime")).intValue(), ((Integer) map.get("mode")).intValue(), (Map) map.get("params")));
                    }
                } catch (Exception unused5) {
                }
                return -1;
            } else if (playerAction == PlayerAction.SET_NOTSTOPFLAG) {
                this.mNotStopFlag = true;
                return -1;
            } else {
                if (playerAction == PlayerAction.DO_AD) {
                    try {
                        if (!(this.mPlayInfo == null || (iAlixPlayer = this.mAlixPlayer) == null || isFree(iAlixPlayer))) {
                            String str2 = (String) map.get("mode");
                            AdInfo adInfo = (AdInfo) map.get("adInfo");
                            if ("set".equals(str2)) {
                                Period period3 = new Period();
                                period3.setType(3);
                                for (int i = 0; i < adInfo.getBidInfoList().size(); i++) {
                                    BidInfo bidInfo = adInfo.getBidInfoList().get(i);
                                    if (!TextUtils.isEmpty(bidInfo.getCreativeUrl())) {
                                        String trim = bidInfo.getCreativeUrl().trim();
                                        BaseMediaSource baseMediaSource = this.mMediaSource;
                                        if (baseMediaSource instanceof AxpMediaSource) {
                                            trim = ((AxpMediaSource) baseMediaSource).appendUrlParams(trim, "ykVideoShowType=4");
                                        }
                                        period3.addSource(new Source(trim, (double) bidInfo.getDuration()));
                                        period3.setMixedCodec(true);
                                    }
                                }
                                NativeMap nativeMap = new NativeMap();
                                nativeMap.put("enable_auto_start", "0");
                                nativeMap.put("player_source", "1");
                                period3.setHeader(nativeMap);
                                period3.setFeatureFlags(0);
                                this.mPlayInfo.setTag("midAdPeriod", period3);
                            } else if (Constants.Value.PLAY.equals(str2) && (period = (Period) this.mPlayInfo.getTag("midAdPeriod")) != null) {
                                this.mAlixPlayer.playMidAd(period);
                            }
                        }
                    } catch (Exception unused6) {
                    }
                } else if (playerAction == PlayerAction.RAPHAEL_SET_PARAMS) {
                    try {
                        if (this.mAlixPlayer != null) {
                            HashMap hashMap = new HashMap();
                            for (Map.Entry<String, Object> entry : map.entrySet()) {
                                hashMap.put(entry.getKey(), entry.getValue());
                            }
                            this.mAlixPlayer.setExtraParam(hashMap);
                        }
                    } catch (Exception unused7) {
                    }
                    return -1;
                }
                return null;
            }
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public Object doAction(String str, Map<String, Object> map) {
        if ("continuePlayRealVideo".equals(str)) {
            continuePlayRealVideo((VodItem) map.get("vodItem"), (SliceItem) map.get("sliceItem"));
            return null;
        }
        if ("setVideoRendCutMode".equals(str) && this.mAlixPlayer != null) {
            this.mAlixPlayer.setVideoRendCutMode(((Integer) map.get("mode")).intValue(), ((Float) map.get("xoffset")).floatValue(), ((Float) map.get("yoffset")).floatValue());
        }
        return this.mOtherFunc.doAction(this.mAlixPlayer, str, map);
    }

    @Override // com.youku.vpm.IPlayer
    public synchronized Map<String, String> getAllDims(TableId tableId) {
        try {
            IAlixPlayer iAlixPlayer = this.mAlixPlayer;
            if (!(iAlixPlayer == null || iAlixPlayer.getReporter() == null)) {
                return this.mAlixPlayer.getReporter().getAllDims(getTableName(tableId));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    @Override // com.youku.vpm.IPlayer
    public synchronized Map<String, String> getAllValues(TableId tableId) {
        try {
            IAlixPlayer iAlixPlayer = this.mAlixPlayer;
            if (!(iAlixPlayer == null || iAlixPlayer.getReporter() == null)) {
                return this.mAlixPlayer.getReporter().getAllValues(getTableName(tableId));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized long getCurrentPosition() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null) {
            return 0;
        }
        return iAlixPlayer.getCurrentPosition(Aliplayer.PositionType.NORMAL);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized float getCurrentZoomScale() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null) {
            return 1.0f;
        }
        return iAlixPlayer.getCurrentZoomScale();
    }

    @Override // com.youku.vpm.IMonitor
    public double getDouble(String str, double d) {
        return 0.0d;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public int getDuration() {
        PlayInfo playInfo = this.mPlayInfo;
        int duration = playInfo != null ? playInfo.getDuration() : 0;
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        return (iAlixPlayer == null || duration > 0) ? duration : (int) iAlixPlayer.getDuration();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public ModuleManager getModuleManager() {
        return this.mModuleManager;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public PlayInfo getPlayInfo() {
        return this.mPlayInfo;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public synchronized PlayInfo getPlayInfoOfReuse(String str) {
        IMediaSource currentMediaSource;
        if (PlayerManager.getInstance().useSystemPlayer()) {
            Logger.d(TAG, "getPlayInfoOfReuse use system player!");
            return null;
        }
        IAlixPlayer c = com.youku.a.a.a(this.mContext).c(str);
        if (c == null || isFree(c) || (currentMediaSource = c.getCurrentMediaSource()) == null || !(currentMediaSource instanceof BaseMediaSource)) {
            return null;
        }
        return ((BaseMediaSource) currentMediaSource).getPlayInfo();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public PlayParams getPlayParams() {
        return this.mPlayInfo.getPlayParams();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public double getPlaySpeed() {
        return this.mPlaySpeed;
    }

    @Override // com.youku.vpm.IPlayer
    public String getPlayerInfoByKey(int i) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null || !ApsUtil.enableSameThreadSync()) {
            return null;
        }
        return iAlixPlayer.getPlayerInfoByKey(i);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public PlayerTrack getPlayerTrack() {
        return this.mPlayerTrack;
    }

    @Override // com.youku.vpm.IExt, com.youku.vpm.IMonitor
    public String getString(String str, String str2) {
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized int getVideoHeight() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null) {
            return 0;
        }
        return iAlixPlayer.getVideoHeight();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized int getVideoWidth() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null) {
            return 0;
        }
        return iAlixPlayer.getVideoWidth();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized float getVolume() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null) {
            return 0.0f;
        }
        return iAlixPlayer.getVolume();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void hideZoomPickWind() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setZoomPickWind(1, 0, 0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public boolean isFree(IAlixPlayer iAlixPlayer) {
        return iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_IDLE || iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_STOPPED || iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_RELEASED || iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_ERROR || iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_SOURCE_FAILED;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized boolean isMuted() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null) {
            return false;
        }
        return iAlixPlayer.isMuted();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized boolean isPaused() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        boolean z = false;
        if (iAlixPlayer == null) {
            return false;
        }
        if (iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_PAUSED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_MID_AD_PAUSED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_POST_AD_PAUSED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_PAUSED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PRE_VIP_PAUSED) {
            z = true;
        }
        return z;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized boolean isStarted() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        boolean z = false;
        if (iAlixPlayer == null) {
            return false;
        }
        if (iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_MID_AD_STARTED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_POST_AD_STARTED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_STARTED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PRE_VIP_STARTED) {
            z = true;
        }
        return z;
    }

    @Override // com.youku.alixplayer.AlixPlayerHolderUnbindListener
    public synchronized void onHolderUnbindNotify() {
        if (this.mAlixPlayer != null) {
            TLogUtil.loge(CacheManager.TAG_PLAYER, "playerimpl:" + hashCode() + " unbind AlixPlayer: " + this.mAlixPlayer.hashCode() + "-state-" + this.mAlixPlayer.getCurrentState());
            this.mAlixPlayer.removeOnPlayerStateListener(this.mOnStateChangeListener);
            this.mAlixPlayer.removeOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
            this.mAlixPlayer.removeOnInfoListener(this.mOnInfoListener);
            this.mAlixPlayer.removeOnAdEventListener(this.mOnAdEventListener);
            IRenderMiddleware iRenderMiddleware = this.mRenderMiddleware;
            if (iRenderMiddleware != null) {
                this.mAlixPlayer.removeRenderMiddleware(iRenderMiddleware);
            }
            CacheManager.getInstance().removePoolId(this.mAlixPlayer.getPlayerId());
            if (ApsUtil.setAlixplayerNullEnable()) {
                this.mAlixPlayer = null;
            }
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void pause() {
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.onPause();
        }
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.pause();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:149:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x032a A[Catch:{ Exception -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0393 A[ADDED_TO_REGION] */
    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public synchronized void playWithPlayInfo(PlayInfo playInfo) {
        IAlixPlayer iAlixPlayer;
        IMediaSource currentMediaSource;
        int i;
        VodItem vodItem;
        String str;
        String str2;
        PlayParams playParams;
        String str3;
        String str4;
        IRenderMiddleware iRenderMiddleware;
        IAlixPlayer iAlixPlayer2;
        logWithSessionId(playInfo.getPlayParams().getSessionId(), "playWithPlayInfo");
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.putTimestamp("playWithPlayInfoTs", System.currentTimeMillis());
            this.mPlayerTrack.onDataReady(playInfo.getVpmFullInfo());
        }
        ModuleManager moduleManager = this.mModuleManager;
        if (moduleManager != null) {
            moduleManager.onDataReady(playInfo);
        }
        this.mPlayInfo = playInfo;
        String playId = playInfo.getPlayParams().getPlayIdParams() != null ? playInfo.getPlayId() : playInfo.getPlayItem().getPlayUrl();
        boolean z = true;
        if (this.mPlayInfo.getPlayParams().isUseSystemPlayer()) {
            PlayerManager.getInstance().setUseSystemPlayer(true);
        }
        if (PlayerManager.getInstance().useSystemPlayer()) {
            iAlixPlayer = new AndroidXPlayer(this.mContext);
            Logger.d(TAG, "playWithPlayInfo use system player!");
        } else {
            iAlixPlayer = new AlixPlayer(this.mContext);
        }
        IAlixPlayer iAlixPlayer3 = this.mAlixPlayer;
        int i2 = 0;
        boolean z2 = iAlixPlayer == iAlixPlayer3;
        if (iAlixPlayer3 != null && !z2) {
            if (!isFree(iAlixPlayer3)) {
                this.mAlixPlayer.stop();
            }
            com.youku.a.a.a(this.mContext).a(this.mAlixPlayer);
            TLogUtil.loge(CacheManager.TAG_PLAYER, "returnAlixPlayer: " + this.mAlixPlayer.hashCode() + " id:" + this.mAlixPlayer.getPlayerId());
        }
        this.mAlixPlayer = iAlixPlayer;
        if (iAlixPlayer.getHolder() == null) {
            iAlixPlayer2 = this.mAlixPlayer;
        } else {
            if (!(this.mAlixPlayer.getHolder() == null || this.mAlixPlayer.getHolder() == this)) {
                if (this.mIsPreload) {
                    if (!this.mIsPreload || !isFree(this.mAlixPlayer)) {
                        TLogUtil.loge(CacheManager.TAG_PLAYER, "playerimpl:" + hashCode() + " bind AlixPlayer: " + this.mAlixPlayer.hashCode() + jl1.BLOCK_START_STR + playId + "}" + "-stolen failed" + "-state-" + this.mAlixPlayer.getCurrentState());
                        InternalPlayerEventListener internalPlayerEventListener = this.mInternalPlayerEventListener;
                        if (internalPlayerEventListener != null) {
                            internalPlayerEventListener.onError(ErrorCode.STOLEN_BY_PRELOAD_ERR);
                        }
                        return;
                    }
                }
                if (this.mAlixPlayer.getHolder() != null) {
                    this.mAlixPlayer.getHolder().onHolderUnbindNotify();
                }
                iAlixPlayer2 = this.mAlixPlayer;
            }
            currentMediaSource = this.mAlixPlayer.getCurrentMediaSource();
            if (currentMediaSource != null) {
                if (currentMediaSource instanceof BaseMediaSource) {
                    BaseMediaSource baseMediaSource = (BaseMediaSource) currentMediaSource;
                    PlayItem.Result match = baseMediaSource.getPlayInfo().getPlayItem().match(playInfo.getPlayItem());
                    String str5 = (String) match.getValue(PlayItem.Result.FIRST_URL);
                    String str6 = (String) match.getValue(PlayItem.Result.SECOND_URL);
                    PlayerTrack playerTrack2 = this.mPlayerTrack;
                    if (!(playerTrack2 == null || playerTrack2.getTrack() == null)) {
                        this.mPlayerTrack.getTrack().putString(PlayItem.Result.FIRST_URL, str5);
                        this.mPlayerTrack.getTrack().putString(PlayItem.Result.SECOND_URL, str6);
                    }
                    if (!match.isSame()) {
                        TLogUtil.loge(CacheManager.TAG_PLAYER, "playerImpl:" + hashCode() + " and AlixPlayer: " + this.mAlixPlayer.hashCode() + jl1.BLOCK_START_STR + playId + "}" + "-changeUrl:" + "-oldUrl-" + baseMediaSource.getPlayInfo().getPlayItem().getPlayUrl() + "-newUrl-" + playInfo.getPlayItem().getPlayUrl());
                        playInfo.putString("fastUrlError", (String) match.getValue("code"));
                        TLogUtil.loge(CacheManager.TAG_PLAYER, "playerimpl:" + hashCode() + " bind AlixPlayer: " + this.mAlixPlayer.hashCode() + jl1.BLOCK_START_STR + playId + "}" + "-reuse" + "-state-" + this.mAlixPlayer.getCurrentState());
                        this.mAlixPlayer.setMute(this.mIsMuted);
                        if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
                            this.mAlixPlayer.setConfigCenter(new ApasConfigure());
                        } else if (!(getPlayParams() == null || getPlayParams().getExtConfigMap() == null || (this.mAlixPlayer instanceof AndroidXPlayer))) {
                            ConfigCenter configCenter = new ConfigCenter();
                            configCenter.setExtConfigMap(getPlayParams().getExtConfigMap());
                            this.mAlixPlayer.setConfigCenter(configCenter);
                        }
                        this.mAlixPlayer.removeOnPlayerStateListener(this.mOnStateChangeListener);
                        this.mAlixPlayer.removeOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
                        this.mAlixPlayer.removeOnAdEventListener(this.mOnAdEventListener);
                        this.mAlixPlayer.removeOnInfoListener(this.mOnInfoListener);
                        this.mAlixPlayer.removeOnSeekCompleteListener(this.mOnSeekCompleteListener);
                        iRenderMiddleware = this.mRenderMiddleware;
                        if (iRenderMiddleware != null) {
                            this.mAlixPlayer.removeRenderMiddleware(iRenderMiddleware);
                        }
                        this.mAlixPlayer.addOnPlayerStateListener(this.mOnStateChangeListener);
                        this.mAlixPlayer.addOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
                        this.mAlixPlayer.addOnAdEventListener(this.mOnAdEventListener);
                        this.mAlixPlayer.addOnInfoListener(this.mOnInfoListener);
                        this.mAlixPlayer.addOnCurrentPositionChangeListener(this.mOnCurrentPositionChangeListener);
                        if (this.mAlixPlayer instanceof AlixPlayer) {
                            ((AlixPlayer) this.mAlixPlayer).setOnPlayerHostUpdateListener(new Aliplayer.OnPlayerHostUpdateListener() {
                                /* class com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass1 */

                                @Override // com.youku.alixplayer.instances.Aliplayer.OnPlayerHostUpdateListener
                                public String getDomain(String str, String str2) {
                                    return PlayerImpl.this.getDomain(str, str2);
                                }
                            });
                            ((AlixPlayer) this.mAlixPlayer).setOnLocalConfigCenterListener(this.mOnLocalConfigCenterListener);
                            if (FeatureManager.getInstance().hasOpr()) {
                                YKRenderMiddleware yKRenderMiddleware = new YKRenderMiddleware();
                                this.mRenderMiddleware = yKRenderMiddleware;
                                this.mAlixPlayer.addRenderMiddleware(yKRenderMiddleware);
                            }
                        }
                        this.mAlixPlayer.addOnSeekCompleteListener(this.mOnSeekCompleteListener);
                        if (!isFree(this.mAlixPlayer) || z) {
                            if (z) {
                                TLogUtil.loge(CacheManager.TAG_PLAYER, "player:needReplay and stop");
                                this.mAlixPlayer.stop();
                            }
                            this.mPlayInfo.getPlayParams().putString(TableField.PRELOAD_INFO, "newPlay");
                            logWithSessionId("setDataSource newPlay");
                            setDataSource(playInfo);
                            str = CacheManager.TAG_PLAYER;
                            str2 = "player:setDataSource";
                        } else {
                            PlayerTrack playerTrack3 = this.mPlayerTrack;
                            if (playerTrack3 != null) {
                                playerTrack3.putTimestamp("playWithPreloadTs", System.currentTimeMillis());
                            }
                            if (isPaused() || isStarted()) {
                                this.mPlayInfo.getPlayParams().putString(TableField.PRELOAD_INFO, "playSuccess");
                                if (isPaused()) {
                                    logWithSessionId("暂停态接管的时候start");
                                    this.mAlixPlayer.start();
                                    TLogUtil.loge(CacheManager.TAG_PLAYER, "player:pause to start");
                                }
                                TLogUtil.loge(CacheManager.TAG_PLAYER, "player:append callback");
                                InternalPlayerEventListener internalPlayerEventListener2 = this.mInternalPlayerEventListener;
                                if (internalPlayerEventListener2 != null) {
                                    internalPlayerEventListener2.onVideoSizeChanged(this.mAlixPlayer.getVideoWidth(), this.mAlixPlayer.getVideoHeight());
                                }
                                if (this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_STARTED) {
                                    InternalPlayerEventListener internalPlayerEventListener3 = this.mInternalPlayerEventListener;
                                    if (internalPlayerEventListener3 != null) {
                                        internalPlayerEventListener3.onAdStart(InternalPlayerEventListener.ADType.PRE_AD, 0);
                                    }
                                } else if (this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                                    PlayerTrack playerTrack4 = this.mPlayerTrack;
                                    if (playerTrack4 != null) {
                                        playerTrack4.onInfo(1017, 0, 0, null);
                                    }
                                    this.mAlixPlayer.setIsLoopPlay(this.mIsLoopPlay);
                                    InternalPlayerEventListener internalPlayerEventListener4 = this.mInternalPlayerEventListener;
                                    if (internalPlayerEventListener4 != null) {
                                        internalPlayerEventListener4.onRealVideoStart();
                                    }
                                    InternalPlayerEventListener internalPlayerEventListener5 = this.mInternalPlayerEventListener;
                                    if (internalPlayerEventListener5 != null) {
                                        internalPlayerEventListener5.onInfo(1024, 0, 0, null);
                                        this.mInternalPlayerEventListener.onInfo(2016, this.abrCode, 0, null);
                                    }
                                }
                                PlayInfo playInfo2 = this.mPlayInfo;
                                if (playInfo2 != null && playInfo2.getPlayType() == PlayDefinition.PlayType.VOD && this.mPlayInfo.getPlayItem() != null && (this.mPlayInfo.getPlayItem() instanceof VodItem) && (this.mPlayInfo.getPlayInfoResponse() == null || !(this.mPlayInfo.getPlayInfoResponse() instanceof PlayInfoUpsResponse) || !((PlayInfoUpsResponse) this.mPlayInfo.getPlayInfoResponse()).hasVideoFeature(Point.FVV_TIPS))) {
                                    vodItem = (VodItem) this.mPlayInfo.getPlayItem();
                                    if (vodItem.getBitStream() != null && vodItem.getBitStream().getWidth() > 0 && vodItem.getBitStream().getHeight() > 0) {
                                        i2 = vodItem.getBitStream().getWidth();
                                        i = vodItem.getBitStream().getHeight();
                                        if (i2 > 0 && i > 0) {
                                            this.mAlixPlayer.changeVideoSize(i2, i);
                                        }
                                        if (this.mSurface != null) {
                                            PlayerTrack playerTrack5 = this.mPlayerTrack;
                                            if (playerTrack5 != null) {
                                                playerTrack5.putTimestamp("setDisplayTs", System.currentTimeMillis());
                                            }
                                            this.mAlixPlayer.setDisplay(this.mSurface);
                                        }
                                    }
                                }
                                i = 0;
                                this.mAlixPlayer.changeVideoSize(i2, i);
                                if (this.mSurface != null) {
                                }
                            } else if (this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_SOURCE_READY) {
                                this.mPlayInfo.getPlayParams().putString(TableField.PRELOAD_INFO, "sourceReadyAndPrepare");
                                this.mAlixPlayer.prepareAsync();
                                str = CacheManager.TAG_PLAYER;
                                str2 = "player:prepareAsync";
                            } else {
                                if (this.mAlixPlayer.getCurrentState() != IAlixPlayer.State.STATE_PREPARED) {
                                    if (this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PREPARING) {
                                        playParams = this.mPlayInfo.getPlayParams();
                                        str3 = TableField.PRELOAD_INFO;
                                        str4 = "playerPreparing";
                                    } else if (this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_STARTING) {
                                        playParams = this.mPlayInfo.getPlayParams();
                                        str3 = TableField.PRELOAD_INFO;
                                        str4 = "playerStarting";
                                    } else {
                                        playParams = this.mPlayInfo.getPlayParams();
                                        str3 = TableField.PRELOAD_INFO;
                                        str4 = "playerOtherState";
                                    }
                                    playParams.putString(str3, str4);
                                } else if (this.mIsAutoPlay) {
                                    this.mPlayInfo.getPlayParams().putString(TableField.PRELOAD_INFO, "preparedAndStart");
                                    logWithSessionId("预播放已经prepared,调用start起播");
                                    this.mAlixPlayer.start();
                                    str = CacheManager.TAG_PLAYER;
                                    str2 = "player:start";
                                } else {
                                    InternalPlayerEventListener internalPlayerEventListener6 = this.mInternalPlayerEventListener;
                                    if (internalPlayerEventListener6 != null) {
                                        internalPlayerEventListener6.onPrepared();
                                    }
                                }
                                PlayInfo playInfo22 = this.mPlayInfo;
                                vodItem = (VodItem) this.mPlayInfo.getPlayItem();
                                i2 = vodItem.getBitStream().getWidth();
                                i = vodItem.getBitStream().getHeight();
                                this.mAlixPlayer.changeVideoSize(i2, i);
                                if (this.mSurface != null) {
                                }
                            }
                        }
                        TLogUtil.loge(str, str2);
                        PlayInfo playInfo222 = this.mPlayInfo;
                        vodItem = (VodItem) this.mPlayInfo.getPlayItem();
                        i2 = vodItem.getBitStream().getWidth();
                        i = vodItem.getBitStream().getHeight();
                        this.mAlixPlayer.changeVideoSize(i2, i);
                        if (this.mSurface != null) {
                        }
                    } else if (z2 && !isFree(this.mAlixPlayer)) {
                        TLogUtil.loge(CacheManager.TAG_PLAYER, "playerImpl:" + hashCode() + " and AlixPlayer: " + this.mAlixPlayer.hashCode() + jl1.BLOCK_START_STR + playId + "}" + "-noNeedChangeUrl:return");
                        return;
                    } else if (!isFree(this.mAlixPlayer)) {
                        this.mMediaSource = (BaseMediaSource) currentMediaSource;
                    }
                } else {
                    this.mAlixPlayer.stop();
                }
            }
            z = false;
            TLogUtil.loge(CacheManager.TAG_PLAYER, "playerimpl:" + hashCode() + " bind AlixPlayer: " + this.mAlixPlayer.hashCode() + jl1.BLOCK_START_STR + playId + "}" + "-reuse" + "-state-" + this.mAlixPlayer.getCurrentState());
            this.mAlixPlayer.setMute(this.mIsMuted);
            if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
            }
            this.mAlixPlayer.removeOnPlayerStateListener(this.mOnStateChangeListener);
            this.mAlixPlayer.removeOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
            this.mAlixPlayer.removeOnAdEventListener(this.mOnAdEventListener);
            this.mAlixPlayer.removeOnInfoListener(this.mOnInfoListener);
            this.mAlixPlayer.removeOnSeekCompleteListener(this.mOnSeekCompleteListener);
            iRenderMiddleware = this.mRenderMiddleware;
            if (iRenderMiddleware != null) {
            }
            this.mAlixPlayer.addOnPlayerStateListener(this.mOnStateChangeListener);
            this.mAlixPlayer.addOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
            this.mAlixPlayer.addOnAdEventListener(this.mOnAdEventListener);
            this.mAlixPlayer.addOnInfoListener(this.mOnInfoListener);
            this.mAlixPlayer.addOnCurrentPositionChangeListener(this.mOnCurrentPositionChangeListener);
            if (this.mAlixPlayer instanceof AlixPlayer) {
            }
            this.mAlixPlayer.addOnSeekCompleteListener(this.mOnSeekCompleteListener);
            if (!isFree(this.mAlixPlayer)) {
            }
            if (z) {
            }
            this.mPlayInfo.getPlayParams().putString(TableField.PRELOAD_INFO, "newPlay");
            logWithSessionId("setDataSource newPlay");
            setDataSource(playInfo);
            str = CacheManager.TAG_PLAYER;
            str2 = "player:setDataSource";
            TLogUtil.loge(str, str2);
            PlayInfo playInfo2222 = this.mPlayInfo;
            vodItem = (VodItem) this.mPlayInfo.getPlayItem();
            i2 = vodItem.getBitStream().getWidth();
            i = vodItem.getBitStream().getHeight();
            this.mAlixPlayer.changeVideoSize(i2, i);
            if (this.mSurface != null) {
            }
        }
        iAlixPlayer2.setHolder(this);
        currentMediaSource = this.mAlixPlayer.getCurrentMediaSource();
        if (currentMediaSource != null) {
        }
        z = false;
        TLogUtil.loge(CacheManager.TAG_PLAYER, "playerimpl:" + hashCode() + " bind AlixPlayer: " + this.mAlixPlayer.hashCode() + jl1.BLOCK_START_STR + playId + "}" + "-reuse" + "-state-" + this.mAlixPlayer.getCurrentState());
        this.mAlixPlayer.setMute(this.mIsMuted);
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
        }
        try {
            this.mAlixPlayer.removeOnPlayerStateListener(this.mOnStateChangeListener);
            this.mAlixPlayer.removeOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
            this.mAlixPlayer.removeOnAdEventListener(this.mOnAdEventListener);
            this.mAlixPlayer.removeOnInfoListener(this.mOnInfoListener);
            this.mAlixPlayer.removeOnSeekCompleteListener(this.mOnSeekCompleteListener);
            iRenderMiddleware = this.mRenderMiddleware;
            if (iRenderMiddleware != null) {
            }
        } catch (Exception unused) {
        }
        this.mAlixPlayer.addOnPlayerStateListener(this.mOnStateChangeListener);
        this.mAlixPlayer.addOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
        this.mAlixPlayer.addOnAdEventListener(this.mOnAdEventListener);
        this.mAlixPlayer.addOnInfoListener(this.mOnInfoListener);
        this.mAlixPlayer.addOnCurrentPositionChangeListener(this.mOnCurrentPositionChangeListener);
        if (this.mAlixPlayer instanceof AlixPlayer) {
        }
        this.mAlixPlayer.addOnSeekCompleteListener(this.mOnSeekCompleteListener);
        if (!isFree(this.mAlixPlayer)) {
        }
        if (z) {
        }
        this.mPlayInfo.getPlayParams().putString(TableField.PRELOAD_INFO, "newPlay");
        logWithSessionId("setDataSource newPlay");
        setDataSource(playInfo);
        str = CacheManager.TAG_PLAYER;
        str2 = "player:setDataSource";
        TLogUtil.loge(str, str2);
        PlayInfo playInfo22222 = this.mPlayInfo;
        vodItem = (VodItem) this.mPlayInfo.getPlayItem();
        i2 = vodItem.getBitStream().getWidth();
        i = vodItem.getBitStream().getHeight();
        this.mAlixPlayer.changeVideoSize(i2, i);
        if (this.mSurface != null) {
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void release() {
        if (this.mPlayerTrack != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("stopFrom", "release");
            this.mPlayerTrack.onStop(hashMap);
        }
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null && !this.mNotStopFlag) {
            if (iAlixPlayer instanceof AndroidXPlayer) {
                iAlixPlayer.release();
            } else if (this.mPlayInfo != null) {
                com.youku.a.a.a(this.mContext).a(this.mAlixPlayer);
                TLogUtil.loge(CacheManager.TAG_PLAYER, "player:release");
                TLogUtil.loge(CacheManager.TAG_PLAYER, "returnAlixPlayer: " + this.mAlixPlayer.hashCode() + " id:" + this.mAlixPlayer.getPlayerId() + "|||TotalleftInusePlayer-" + com.youku.a.a.a(this.mContext).a());
            }
        }
    }

    public void replayWithRequest(Map<String, String> map) {
        if (this.mInternalPlayerEventListener != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            this.mInternalPlayerEventListener.onNotify("replayWithRequest", hashMap);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void seekTo(int i, boolean z) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            if (z) {
                iAlixPlayer.seekTo(i, 1);
            } else {
                iAlixPlayer.seekTo(i, 0);
            }
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setAutoPlay(boolean z) {
        this.mIsAutoPlay = z;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setDisplay(Surface surface) {
        this.mSurface = surface;
        if (this.mAlixPlayer != null) {
            PlayerTrack playerTrack = this.mPlayerTrack;
            if (playerTrack != null) {
                playerTrack.putTimestamp("setDisplayTs", System.currentTimeMillis());
            }
            this.mAlixPlayer.setDisplay(surface);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public int setFilter(int i, Map<String, String> map) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null) {
            return -1;
        }
        return iAlixPlayer.setFilter(i, map);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public void setInternalPlayEventListener(InternalPlayerEventListener internalPlayerEventListener) {
        this.mInternalPlayerEventListener = internalPlayerEventListener;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setLooping(boolean z) {
        this.mIsLoopPlay = z;
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null && iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mAlixPlayer.setIsLoopPlay(this.mIsLoopPlay);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setMaxZoomScale(float f) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setZoom(4, (double) f, 0.0d, 0.0d);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setMuted(boolean z) {
        this.mIsMuted = z;
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setMute(this.mIsMuted);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setPlaySpeed(double d) {
        this.mPlaySpeed = d;
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setPlaySpeed(this.mPlaySpeed);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setPlaybackParam(int i, String str) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setPlaybackParam(i, str);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setVolume(float f) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setVolume(f);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setZoom(int i, double d, double d2, double d3) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setZoom(i, d, d2, d3);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void showZoomPickWind(int i, float f, float f2, float f3, float f4) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setZoomPickWind(0, i, f, f2, f3, f4);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void skipAD(int i) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.skipAd(i);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void start() {
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.onStart();
        }
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.start();
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void stop() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (!(iAlixPlayer == null || iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_STOPPED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_RELEASED)) {
            if (!this.mNotStopFlag) {
                this.mAlixPlayer.stop();
                TLogUtil.loge(CacheManager.TAG_PLAYER, "player:stop");
                this.mAlixPlayer.reset();
            }
            this.mAlixPlayer.setHolder(null);
            this.mAlixPlayer.setDisplay(null);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public synchronized void switchPlayItem(PlayItem playItem) {
        if (((UpsMediaSource) this.mMediaSource).switchDataSource((VodItem) playItem, getCurrentPosition() + 10000) != 0) {
            this.mInternalPlayerEventListener.onQualityChangeFinish(false, null);
        }
    }
}
