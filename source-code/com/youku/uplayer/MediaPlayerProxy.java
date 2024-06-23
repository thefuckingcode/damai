package com.youku.uplayer;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.youku.alixplayer.AlixPlayer;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnAdEventListener;
import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnQualityChangeListener;
import com.youku.alixplayer.OnSeekCompleteListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.OnVideoSizeChangedListener;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Playlist;
import com.youku.alixplayer.model.Source;
import com.youku.arch.beast.apas.ApasConfigure;
import com.youku.e.a;
import com.youku.player.util.TLogUtilNative;
import com.youku.player.util.c;
import com.youku.player.util.d;
import com.youku.vpm.constants.TableField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.apache.commons.lang3.StringUtils;
import tv.cjump.jni.DeviceUtils;

@SuppressLint({"DefaultLocale"})
/* compiled from: Taobao */
public class MediaPlayerProxy implements Mediaplayer {
    private static final HashSet<String> HD2_BLACK_LIST = new HashSet<>();
    private static double HD2_CORES_REQUIREMENT = 4.0d;
    private static double HD2_H265_HLS_CORES_REQUIREMENT = 6.0d;
    private static double HD2_H265_HLS_FREQUENCY_REQUIREMENT = 2200.0d;
    private static double HD2_RAM_REQUIREMENT = 1258291.2d;
    private static double HD3_RAM_REQUIREMENT = 2831155.2d;
    private static final HashSet<String> HD3_WHITE_LIST = new HashSet<>();
    public static final String NET_TYPE_NONET = "0";
    public static final String NET_TYPE_NOTWIFI = "2";
    public static final String NET_TYPE_WIFI = "1";
    private static final String TAG = "MediaPlayerProxy";
    public static int[] Versions = {1000, 1022, 1023, 1030, 1040, 1041, 1042, 1043, 1044, 1050, 1099};
    public static int freq;
    private static boolean initialized;
    private static boolean isCpuinfoReaded = false;
    private static boolean isUplayerSupported = false;
    private static int mNumCores;
    private static int mScreenHeight;
    private static int mScreenWidth;
    private static double mTotalRAM;
    private static MediaPlayerProxy sPlayer;
    private String copyright_key_client;
    private String drmLicenseUri;
    private boolean isDRM;
    private boolean isFeedsMode = false;
    private boolean isHLS;
    private volatile boolean isReleased;
    private boolean isVerticalFeedMode = false;
    private OnADPlayListener mADPlayListener = new OnADPlayListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass9 */

        @Override // com.youku.uplayer.OnADPlayListener
        public boolean onEndPlayAD(int i) {
            return false;
        }

        @Override // com.youku.uplayer.OnADPlayListener
        public boolean onStartPlayAD(int i) {
            return false;
        }
    };
    private AlixPlayer mAlixPlayer = null;
    private int mAudioMute = 0;
    private int mAudioStatus = 1;
    private int mAudioStreamType = -1;
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass1 */

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            c.a(MediaPlayerProxy.TAG, "onBufferingUpdate, " + i + "% bufferred.");
            if (MediaPlayerProxy.this.mOuterBufferingUpdateListener != null) {
                MediaPlayerProxy.this.mOuterBufferingUpdateListener.onBufferingUpdate(null, i);
            }
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass2 */

        public void onCompletion(MediaPlayer mediaPlayer) {
            MediaPlayerProxy.this.mMPState = 9;
            if (MediaPlayerProxy.this.mOuterCompletionListener != null) {
                MediaPlayerProxy.this.mOuterCompletionListener.onCompletion(null);
            } else {
                MediaPlayerProxy.this.release();
            }
        }
    };
    private Context mContext;
    private String mCronetSoPath;
    private int mCurrentOrientation;
    private boolean mEnableSEI;
    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass3 */

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            c.b(MediaPlayerProxy.TAG, "Bug fix: Error received in MediaPlayerProxy what=" + i + " extra=" + i2);
            if (MediaPlayerProxy.this.mOuterErrorListener == null || MediaPlayerProxy.this.mOuterErrorListener.onError(null, i, i2)) {
                return true;
            }
            MediaPlayerProxy.this.mMPState = -1;
            return true;
        }
    };
    private String mFirstSubtitle;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private SurfaceHolder mHolder = null;
    private MediaPlayer.OnInfoListener mInfoListener = new MediaPlayer.OnInfoListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass4 */

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (MediaPlayerProxy.this.mOuterInfoListener != null) {
                return MediaPlayerProxy.this.mOuterInfoListener.onInfo(null, i, i2);
            }
            return false;
        }
    };
    private OnCurrentPositionChangeListener mInnerCurrentPositionListener = new OnCurrentPositionChangeListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass44 */

        @Override // com.youku.alixplayer.OnCurrentPositionChangeListener
        public void onCurrentPostionChange(final int i) {
            MediaPlayerProxy.this.mHandler.post(new Runnable() {
                /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass44.AnonymousClass1 */

                public void run() {
                    if (MediaPlayerProxy.this.mOnCurrentPositionUpdateListener != null) {
                        MediaPlayerProxy.this.mOnCurrentPositionUpdateListener.onCurrentPositionUpdate(i, 0);
                    }
                }
            });
        }
    };
    private boolean mInnerDisplaySet = false;
    private OnAdEventListener mInnerOnAdEventListener = new OnAdEventListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass39 */

        @Override // com.youku.alixplayer.OnAdEventListener
        public void onAdCountDown(final int i) {
            MediaPlayerProxy.this.mHandler.post(new Runnable() {
                /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass39.AnonymousClass7 */

                public void run() {
                    if (MediaPlayerProxy.this.mOnADCountListener != null) {
                        MediaPlayerProxy.this.mOnADCountListener.onCountUpdate(i);
                    }
                }
            });
        }

        @Override // com.youku.alixplayer.OnAdEventListener
        public void onAdEnd(final int i, int i2) {
            Handler handler;
            Runnable runnable;
            if (i2 == 1) {
                handler = MediaPlayerProxy.this.mHandler;
                runnable = new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass39.AnonymousClass4 */

                    public void run() {
                        if (MediaPlayerProxy.this.mADPlayListener != null) {
                            MediaPlayerProxy.this.mADPlayListener.onEndPlayAD(i);
                        }
                    }
                };
            } else if (i2 == 3) {
                handler = MediaPlayerProxy.this.mHandler;
                runnable = new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass39.AnonymousClass5 */

                    public void run() {
                        if (MediaPlayerProxy.this.mMidADPlayListener != null) {
                            MediaPlayerProxy.this.mMidADPlayListener.onEndPlayMidAD(i);
                        }
                    }
                };
            } else if (i2 == 4) {
                handler = MediaPlayerProxy.this.mHandler;
                runnable = new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass39.AnonymousClass6 */

                    public void run() {
                        if (MediaPlayerProxy.this.mOnPostADPlayListener != null) {
                            MediaPlayerProxy.this.mOnPostADPlayListener.onEndPlayPostAD(i);
                        }
                    }
                };
            } else {
                return;
            }
            handler.post(runnable);
        }

        @Override // com.youku.alixplayer.OnAdEventListener
        public void onAdStart(final int i, int i2) {
            Handler handler;
            Runnable runnable;
            if (i2 == 1) {
                handler = MediaPlayerProxy.this.mHandler;
                runnable = new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass39.AnonymousClass1 */

                    public void run() {
                        if (MediaPlayerProxy.this.mADPlayListener != null) {
                            MediaPlayerProxy.this.mADPlayListener.onStartPlayAD(i);
                        }
                    }
                };
            } else if (i2 == 3) {
                handler = MediaPlayerProxy.this.mHandler;
                runnable = new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass39.AnonymousClass2 */

                    public void run() {
                        if (MediaPlayerProxy.this.mMidADPlayListener != null) {
                            MediaPlayerProxy.this.mMidADPlayListener.onStartPlayMidAD(i);
                        }
                    }
                };
            } else if (i2 == 4) {
                handler = MediaPlayerProxy.this.mHandler;
                runnable = new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass39.AnonymousClass3 */

                    public void run() {
                        if (MediaPlayerProxy.this.mOnPostADPlayListener != null) {
                            MediaPlayerProxy.this.mOnPostADPlayListener.onStartPlayPostAD(i);
                        }
                    }
                };
            } else {
                return;
            }
            handler.post(runnable);
        }
    };
    private OnInfoListener mInnerOnInfoListener = new OnInfoListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass42 */

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00cc A[FALL_THROUGH] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4  */
        @Override // com.youku.alixplayer.OnInfoListener
        public void onInfo(int i, int i2, int i3, Object obj) {
            Handler handler;
            Runnable r4;
            final Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            message.obj = obj;
            if (!(i == 949 || i == 950 || i == 1102 || i == 1103)) {
                if (!(i == 1110 || i == 1111 || i == 2004 || i == 2005 || i == 2200 || i == 2201)) {
                    if (!(i == 3011 || i == 3012)) {
                        switch (i) {
                            case -1012:
                            case 4:
                            case 952:
                            case 1011:
                            case 1012:
                            case 1015:
                            case 1017:
                            case 1019:
                            case 2110:
                            case 2303:
                            case 2400:
                            case 3015:
                            case 3200:
                            case 9001:
                            case 9003:
                            case 50004:
                            case 80001:
                            case 80002:
                            case 80003:
                            case 80004:
                            case 80005:
                            case 81001:
                            case 81002:
                            case 81003:
                            case 81004:
                            case 82000:
                            case 90000:
                                break;
                            case 309:
                                TLogUtilNative.aliplayerLog(obj.toString());
                                return;
                            case 503:
                                if (MediaPlayerProxy.this.mOnTimeoutListener != null) {
                                    MediaPlayerProxy.this.mOnTimeoutListener.onNotifyChangeVideoQuality();
                                    return;
                                }
                                return;
                            case 1002:
                            case 1005:
                            case 1006:
                            case 1007:
                            case 1008:
                            case 1009:
                            case 1010:
                            case 2205:
                            case 3002:
                            case 16005:
                            case 16006:
                            case 30000:
                            case 30001:
                            case 70000:
                                break;
                            case 1003:
                                MediaPlayerProxy.this.mLoadingStartMsg = message;
                                int i4 = 100;
                                try {
                                    i4 = Integer.parseInt(d.a().a("youku_player_config", "loading_start_delay", String.valueOf(100)));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                MediaPlayerProxy.this.mHandler.postDelayed(MediaPlayerProxy.this.mStartLoadingRunnable, (long) i4);
                                return;
                            case 1004:
                                MediaPlayerProxy.this.mHandler.removeCallbacks(MediaPlayerProxy.this.mStartLoadingRunnable);
                                handler = MediaPlayerProxy.this.mHandler;
                                r4 = new Runnable() {
                                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass42.AnonymousClass2 */

                                    public void run() {
                                        if (MediaPlayerProxy.this.mOnLodingStatusListener != null) {
                                            MediaPlayerProxy.this.mOnLodingStatusListener.onEndLoading(message.obj);
                                        }
                                        if (MediaPlayerProxy.this.mOnLodingStatusListenerNoTrack != null) {
                                            MediaPlayerProxy.this.mOnLodingStatusListenerNoTrack.onEndLoading();
                                        }
                                        if (MediaPlayerProxy.this.mOuterInfoListener != null) {
                                            MediaPlayer.OnInfoListener onInfoListener = MediaPlayerProxy.this.mOuterInfoListener;
                                            Message message = message;
                                            onInfoListener.onInfo(null, message.what, message.arg1);
                                        }
                                        if (MediaPlayerProxy.this.mOnCoreMsgListener != null) {
                                            MediaPlayerProxy.this.mOnCoreMsgListener.onMsg(message, -1);
                                        }
                                    }
                                };
                                break;
                            default:
                                switch (i) {
                                    case 1023:
                                        break;
                                    default:
                                        switch (i) {
                                            case 1031:
                                                handler = MediaPlayerProxy.this.mHandler;
                                                r4 = new Runnable() {
                                                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass42.AnonymousClass3 */

                                                    public void run() {
                                                        if (MediaPlayerProxy.this.mBufferingUpdateListener != null) {
                                                            MediaPlayerProxy.this.mBufferingUpdateListener.onBufferingUpdate(null, message.arg1);
                                                        }
                                                    }
                                                };
                                                break;
                                            default:
                                                switch (i) {
                                                    case 2008:
                                                    case 2009:
                                                    case 2010:
                                                    case 2011:
                                                    case 2012:
                                                    case 2013:
                                                    case 2014:
                                                    case 2015:
                                                    case 2016:
                                                    case 2017:
                                                        break;
                                                    default:
                                                        return;
                                                }
                                            case 1032:
                                            case 1033:
                                            case 1034:
                                                if (MediaPlayerProxy.this.mOnCoreMsgListener != null) {
                                                    MediaPlayerProxy.this.mOnCoreMsgListener.onMsg(message, -1);
                                                }
                                                handler = MediaPlayerProxy.this.mHandler;
                                                r4 = new Runnable() {
                                                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass42.AnonymousClass4 */

                                                    public void run() {
                                                        if (MediaPlayerProxy.this.mOuterInfoListener != null) {
                                                            MediaPlayer.OnInfoListener onInfoListener = MediaPlayerProxy.this.mOuterInfoListener;
                                                            Message message = message;
                                                            onInfoListener.onInfo(null, message.what, message.arg1);
                                                        }
                                                    }
                                                };
                                                break;
                                        }
                                    case 1024:
                                    case 1025:
                                        break;
                                }
                        }
                        handler.post(r4);
                    }
                }
                handler = MediaPlayerProxy.this.mHandler;
                r4 = new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass42.AnonymousClass1 */

                    public void run() {
                        if (MediaPlayerProxy.this.mPrivateOnErrorListener != null) {
                            MediaPlayerProxy.this.mPrivateOnErrorListener.onError(null, message);
                        }
                        if (MediaPlayerProxy.this.mOuterErrorListener != null) {
                            MediaPlayer.OnErrorListener onErrorListener = MediaPlayerProxy.this.mOuterErrorListener;
                            Message message = message;
                            onErrorListener.onError(null, message.what, message.arg1);
                        }
                    }
                };
                handler.post(r4);
            }
            if (MediaPlayerProxy.this.mOnCoreMsgListener != null) {
            }
            handler = MediaPlayerProxy.this.mHandler;
            r4 = new Runnable() {
                /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass42.AnonymousClass4 */

                public void run() {
                    if (MediaPlayerProxy.this.mOuterInfoListener != null) {
                        MediaPlayer.OnInfoListener onInfoListener = MediaPlayerProxy.this.mOuterInfoListener;
                        Message message = message;
                        onInfoListener.onInfo(null, message.what, message.arg1);
                    }
                }
            };
            handler.post(r4);
        }
    };
    private OnQualityChangeListener mInnerOnQualityChangeListener = new OnQualityChangeListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass41 */

        @Override // com.youku.alixplayer.OnQualityChangeListener
        public void onQualityChangeFailed() {
            MediaPlayerProxy.this.mHandler.post(new Runnable() {
                /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass41.AnonymousClass2 */

                public void run() {
                    if (MediaPlayerProxy.this.mOnQualityChangeListener != null) {
                        MediaPlayerProxy.this.mOnQualityChangeListener.onQualitySmoothChangeFail();
                    }
                }
            });
        }

        @Override // com.youku.alixplayer.OnQualityChangeListener
        public void onQualityChangeSuccess() {
            MediaPlayerProxy.this.mHandler.post(new Runnable() {
                /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass41.AnonymousClass1 */

                public void run() {
                    if (MediaPlayerProxy.this.mOnQualityChangeListener != null) {
                        MediaPlayerProxy.this.mOnQualityChangeListener.onQualityChangeSuccess();
                    }
                }
            });
        }
    };
    private OnSeekCompleteListener mInnerOnSeekCompleteListener = new OnSeekCompleteListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass40 */

        @Override // com.youku.alixplayer.OnSeekCompleteListener
        public void onSeekComplete() {
            MediaPlayerProxy.this.mHandler.post(new Runnable() {
                /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass40.AnonymousClass1 */

                public void run() {
                    if (MediaPlayerProxy.this.mOuterSeekCompleteListener != null) {
                        MediaPlayerProxy.this.mOuterSeekCompleteListener.onSeekComplete(null);
                    }
                }
            });
        }
    };
    private OnVideoSizeChangedListener mInnerVideoSizeChangedListener = new OnVideoSizeChangedListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass43 */

        @Override // com.youku.alixplayer.OnVideoSizeChangedListener
        public void onVideoSizeChange(final int i, final int i2) {
            MediaPlayerProxy.this.mHandler.post(new Runnable() {
                /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass43.AnonymousClass1 */

                public void run() {
                    if (MediaPlayerProxy.this.mOuterVideoSizeChangedListener != null) {
                        MediaPlayerProxy.this.mOuterVideoSizeChangedListener.onVideoSizeChanged(null, i, i2);
                    }
                }
            });
        }
    };
    private boolean mIsLoopPlay = false;
    private HashMap<Integer, String> mKeyMap;
    private Message mLoadingStartMsg;
    private int mMPState = 0;
    private OnMidADPlayListener mMidADPlayListener = new OnMidADPlayListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass12 */

        @Override // com.youku.uplayer.OnMidADPlayListener
        public boolean onEndPlayMidAD(int i) {
            return false;
        }

        @Override // com.youku.uplayer.OnMidADPlayListener
        public void onLoadingMidADStart() {
        }

        @Override // com.youku.uplayer.OnMidADPlayListener
        public boolean onStartPlayMidAD(int i) {
            return false;
        }
    };
    private OnADCountListener mOnADCountListener = new OnADCountListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass19 */

        @Override // com.youku.uplayer.OnADCountListener
        public void onCountUpdate(int i) {
            c.a(MediaPlayerProxy.TAG, "onCountUpdate-->" + i);
        }
    };
    private OnBufferPercentUpdateListener mOnBufferPercentUpdateListener = new OnBufferPercentUpdateListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass22 */

        @Override // com.youku.uplayer.OnBufferPercentUpdateListener
        public void onPercentUpdate(int i) {
            c.a(MediaPlayerProxy.TAG, "onPercentUpdate-->" + i);
        }
    };
    private OnCdnSwitchListener mOnCdnSwitchListener = new OnCdnSwitchListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass27 */

        @Override // com.youku.uplayer.OnCdnSwitchListener
        public void onCdnSwitch() {
            c.a(MediaPlayerProxy.TAG, "onCdnSwitch--> ");
        }
    };
    private OnCombineVideoListener mOnCombineVideoListener = new OnCombineVideoListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass8 */

        @Override // com.youku.uplayer.OnCombineVideoListener
        public void onCombineError(int i) {
        }

        @Override // com.youku.uplayer.OnCombineVideoListener
        public void onCombineProgress(int i) {
        }

        @Override // com.youku.uplayer.OnCombineVideoListener
        public void onCombineVideoFinish() {
        }
    };
    private OnConnectDelayListener mOnConnectDelayListener = new OnConnectDelayListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass32 */

        @Override // com.youku.uplayer.OnConnectDelayListener
        public void onAdConnectDelay(int i) {
            c.a(MediaPlayerProxy.TAG, "onAdConnectDelay-->" + i);
        }

        @Override // com.youku.uplayer.OnConnectDelayListener
        public void onVideoConnectDelay(int i) {
            c.a(MediaPlayerProxy.TAG, "onVideoConnectDelay-->" + i);
        }
    };
    private OnCoreMsgListener mOnCoreMsgListener;
    private OnCpuUsageListener mOnCpuUsageListener = new OnCpuUsageListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass36 */

        @Override // com.youku.uplayer.OnCpuUsageListener
        public void onCpuUsage(int i) {
            c.a(MediaPlayerProxy.TAG, "onCpuUsage-->" + i);
        }
    };
    private OnCurrentPositionUpdateListener mOnCurrentPositionUpdateListener = new OnCurrentPositionUpdateListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass14 */

        @Override // com.youku.uplayer.OnCurrentPositionUpdateListener
        public void onCurrentPositionUpdate(int i, int i2) {
            c.a(MediaPlayerProxy.TAG, "onCurrentPositionUpdate-->" + i);
        }
    };
    private OnDropVideoFramesListener mOnDropVideoFramesListener = new OnDropVideoFramesListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass35 */

        @Override // com.youku.uplayer.OnDropVideoFramesListener
        public void onDropVideoFrames(int i) {
            c.a(MediaPlayerProxy.TAG, "onDropVideoFrames-->" + i);
        }
    };
    private OnFirstFrameListener mOnFirstFrameListener = new OnFirstFrameListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass25 */

        @Override // com.youku.uplayer.OnFirstFrameListener
        public void onFirstFrame() {
            c.a(MediaPlayerProxy.TAG, "onFirstFrame-->");
        }
    };
    private OnHttp302DelayListener mOnHttp302DelayListener = new OnHttp302DelayListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass33 */

        @Override // com.youku.uplayer.OnHttp302DelayListener
        public void onAd302Delay(int i) {
            c.a(MediaPlayerProxy.TAG, "onAd302Delay-->" + i);
        }

        @Override // com.youku.uplayer.OnHttp302DelayListener
        public void onVideo302Delay(int i) {
            c.a(MediaPlayerProxy.TAG, "onVideo302Delay-->" + i);
        }
    };
    private OnHwDecodeErrorListener mOnHwDecodeErrorListener = new OnHwDecodeErrorListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass31 */

        @Override // com.youku.uplayer.OnHwDecodeErrorListener
        public void OnHwDecodeError() {
            c.a(MediaPlayerProxy.TAG, "OnHwDecodeError-->");
        }

        @Override // com.youku.uplayer.OnHwDecodeErrorListener
        public void onHwPlayError() {
            c.b(MediaPlayerProxy.TAG, "onHwPlayError-->");
        }
    };
    private OnIsInitialListener mOnIsInitialListener = new OnIsInitialListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass23 */

        @Override // com.youku.uplayer.OnIsInitialListener
        public void onIsInitial(int i) {
            c.a(MediaPlayerProxy.TAG, "onIsInitial-->");
        }
    };
    private OnLoadingStatusListener mOnLodingStatusListener = new OnLoadingStatusListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass15 */

        @Override // com.youku.uplayer.OnLoadingStatusListener
        public void onEndLoading(Object obj) {
            c.a(MediaPlayerProxy.TAG, "onEndLoading-->" + obj);
        }

        @Override // com.youku.uplayer.OnLoadingStatusListener
        public void onStartLoading() {
            c.a(MediaPlayerProxy.TAG, "onStartLoading-->");
        }
    };
    private OnLoadingStatusListenerNoTrack mOnLodingStatusListenerNoTrack = new OnLoadingStatusListenerNoTrack() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass16 */

        @Override // com.youku.uplayer.OnLoadingStatusListenerNoTrack
        public void onEndLoading() {
            c.a(MediaPlayerProxy.TAG, "onEndLoading-->");
        }

        @Override // com.youku.uplayer.OnLoadingStatusListenerNoTrack
        public void onStartLoading() {
            c.a(MediaPlayerProxy.TAG, "onStartLoading-->");
        }
    };
    private OnNativeShotDownListener mOnNativeShotDownListener = null;
    private OnNetworkErrorListener mOnNetworkErrorListener = new OnNetworkErrorListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass13 */

        @Override // com.youku.uplayer.OnNetworkErrorListener
        public void onError(MediaPlayer mediaPlayer, int i, int i2, int i3, Object obj) {
        }

        @Override // com.youku.uplayer.OnNetworkErrorListener
        public void onStartLoading(Object obj) {
        }
    };
    private OnNetworkSpeedListener mOnNetworkSpeedListener = new OnNetworkSpeedListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass20 */

        @Override // com.youku.uplayer.OnNetworkSpeedListener
        public void onSpeedUpdate(int i) {
            c.a(MediaPlayerProxy.TAG, "onSpeedUpdate-->" + i + "kb/s");
        }
    };
    private OnNetworkSpeedPerMinute mOnNetworkSpeedPerMinute = new OnNetworkSpeedPerMinute() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass21 */

        @Override // com.youku.uplayer.OnNetworkSpeedPerMinute
        public void onNetWorkIncome(int i) {
            c.a(MediaPlayerProxy.TAG, "onNetWorkIncome-->" + i);
        }

        @Override // com.youku.uplayer.OnNetworkSpeedPerMinute
        public void onNetWorkSpeed(Object obj) {
            c.a(MediaPlayerProxy.TAG, "onNetWorkSpeed-->" + obj);
        }

        @Override // com.youku.uplayer.OnNetworkSpeedPerMinute
        public void onSpeedUpdate(int i) {
            c.a(MediaPlayerProxy.TAG, "onSpeedUpdate-->" + i);
        }
    };
    private OnPlayerHostListener mOnPlayerHostListener;
    private OnPlayerP2PListener mOnPlayerP2PListener;
    private OnPostADPlayListener mOnPostADPlayListener = new OnPostADPlayListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass10 */

        @Override // com.youku.uplayer.OnPostADPlayListener
        public boolean onEndPlayPostAD(int i) {
            return false;
        }

        @Override // com.youku.uplayer.OnPostADPlayListener
        public boolean onStartPlayPostAD(int i) {
            return false;
        }
    };
    private OnPreLoadPlayListener mOnPreLoadPlayListener = new OnPreLoadPlayListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass11 */

        @Override // com.youku.uplayer.OnPreLoadPlayListener
        public void onReceivePlayByPreload(String str) {
        }
    };
    private OnQualityChangeListener mOnQualityChangeListener = new OnQualityChangeListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass34 */

        @Override // com.youku.uplayer.OnQualityChangeListener
        public void onQualityChangeSuccess() {
        }

        @Override // com.youku.uplayer.OnQualityChangeListener
        public void onQualitySmoothChangeFail() {
        }
    };
    private OnRealVideoCompletionListener mOnRealVideoCompletionListener = new OnRealVideoCompletionListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass17 */

        @Override // com.youku.uplayer.OnRealVideoCompletionListener
        public void onRealVideoCompletion() {
            c.a(MediaPlayerProxy.TAG, "OnRealVideoCompletionListener -->");
        }
    };
    private OnRealVideoStartListener mOnRealVideoStartListener = new OnRealVideoStartListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass24 */

        @Override // com.youku.uplayer.OnRealVideoStartListener
        public void onRealVideoStart() {
            c.a(MediaPlayerProxy.TAG, "onRealVideoStart-->");
        }
    };
    private OnScreenShotFinishListener mOnScreenShotFinishListener = new OnScreenShotFinishListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass7 */

        @Override // com.youku.uplayer.OnScreenShotFinishListener
        public void onPreviewChange(Object obj) {
        }

        @Override // com.youku.uplayer.OnScreenShotFinishListener
        public void onPreviewEnd() {
        }

        @Override // com.youku.uplayer.OnScreenShotFinishListener
        public void onScreenShotError(int i) {
        }

        @Override // com.youku.uplayer.OnScreenShotFinishListener
        public void onScreenShotFinished() {
        }

        @Override // com.youku.uplayer.OnScreenShotFinishListener
        public void onScreenShotProgress(int i) {
        }

        @Override // com.youku.uplayer.OnScreenShotFinishListener
        public void onScreenShotVideoEncoderMode(int i) {
        }
    };
    private OnSliceUpdateListener mOnSliceUpdateListener = new OnSliceUpdateListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass18 */

        @Override // com.youku.uplayer.OnSliceUpdateListener
        public void onVideoSliceEnd(int i, int i2) {
        }

        @Override // com.youku.uplayer.OnSliceUpdateListener
        public void onVideoSliceStart(int i, int i2) {
        }
    };
    private OnTimeoutListener mOnTimeoutListener = new OnTimeoutListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass30 */

        @Override // com.youku.uplayer.OnTimeoutListener
        public void onNotifyChangeVideoQuality() {
            c.a(MediaPlayerProxy.TAG, "onNotifyChangeVideoQuality--> ");
        }

        @Override // com.youku.uplayer.OnTimeoutListener
        public void onTimeOut() {
            c.a(MediaPlayerProxy.TAG, "onTimeOut-->");
        }
    };
    private OnVideoCurrentIndexUpdateListener mOnVideoCurrentIndexUpdateListener = new OnVideoCurrentIndexUpdateListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass26 */

        @Override // com.youku.uplayer.OnVideoCurrentIndexUpdateListener
        public void onVideoCurrentIndexUpdate(int i) {
            c.a(MediaPlayerProxy.TAG, "onVideoCurrentIndexUpdate--> " + i);
        }
    };
    private OnVideoIndexUpdateListener mOnVideoIndexUpdateListener = new OnVideoIndexUpdateListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass28 */

        @Override // com.youku.uplayer.OnVideoIndexUpdateListener
        public void onVideoIndexUpdate(int i, int i2) {
            c.a(MediaPlayerProxy.TAG, "onVideoIndexUpdate--> " + i + AltriaXLaunchTime.SPACE + i2);
        }
    };
    private OnVideoRealIpUpdateListener mOnVideoRealIpUpdateListener = new OnVideoRealIpUpdateListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass29 */

        @Override // com.youku.uplayer.OnVideoRealIpUpdateListener
        public void onVideoRealIpUpdate(int i, int i2) {
            c.a(MediaPlayerProxy.TAG, "onVideoRealIpUpdate--> " + i + AltriaXLaunchTime.SPACE + i2);
        }
    };
    private MediaPlayer.OnBufferingUpdateListener mOuterBufferingUpdateListener = null;
    private MediaPlayer.OnCompletionListener mOuterCompletionListener = null;
    private MediaPlayer.OnErrorListener mOuterErrorListener = null;
    private MediaPlayer.OnInfoListener mOuterInfoListener = null;
    private OnPreparedListener mOuterPreparedListener = null;
    private MediaPlayer.OnSeekCompleteListener mOuterSeekCompleteListener = null;
    private MediaPlayer.OnVideoSizeChangedListener mOuterVideoSizeChangedListener = null;
    private String mPath = null;
    private MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass5 */

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (MediaPlayerProxy.this.isValidToChangeState()) {
                MediaPlayerProxy.this.mMPState = 4;
                if (MediaPlayerProxy.this.mOuterPreparedListener != null) {
                    MediaPlayerProxy.this.mOuterPreparedListener.onPrepared(MediaPlayerProxy.this);
                }
            }
        }
    };
    private OnErrorListener mPrivateOnErrorListener;
    private OnInfoListener mPrivateOnInfoListener = new OnInfoListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass37 */

        @Override // com.youku.uplayer.OnInfoListener
        public void onInfo(int i, int i2, int i3, Object obj, long j) {
            String str = LogTag.TAG_PLAYER;
            c.a(str, "onInfo what: arg1: arg2:" + i3 + " object:" + obj + " nativeStartTime:" + j);
        }
    };
    private Map<Integer, String> mPropertyMap = null;
    private int mPursueType = -1;
    private long mSEIInterval;
    private String mSecondSubtitle;
    private Runnable mStartLoadingRunnable = new Runnable() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass45 */

        public void run() {
            c.a(MediaPlayerProxy.TAG, "send Loading Start!");
            if (MediaPlayerProxy.this.mOnLodingStatusListener != null) {
                MediaPlayerProxy.this.mOnLodingStatusListener.onStartLoading();
            }
            if (MediaPlayerProxy.this.mOnLodingStatusListenerNoTrack != null) {
                MediaPlayerProxy.this.mOnLodingStatusListenerNoTrack.onStartLoading();
            }
            if (MediaPlayerProxy.this.mOuterInfoListener != null) {
                MediaPlayerProxy.this.mOuterInfoListener.onInfo(null, MediaPlayerProxy.this.mLoadingStartMsg.what, MediaPlayerProxy.this.mLoadingStartMsg.arg1);
            }
            if (MediaPlayerProxy.this.mOnCoreMsgListener != null) {
                MediaPlayerProxy.this.mOnCoreMsgListener.onMsg(MediaPlayerProxy.this.mLoadingStartMsg, -1);
            }
        }
    };
    private OnStateChangeListener mStateChangeListener = new OnStateChangeListener() {
        /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass38 */

        @Override // com.youku.alixplayer.OnStateChangeListener
        public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
            if (state2 == IAlixPlayer.State.STATE_PREPARED) {
                if (MediaPlayerProxy.this.mAlixPlayer != null) {
                    MediaPlayerProxy.this.mAlixPlayer.setIsLoopPlay(MediaPlayerProxy.this.mIsLoopPlay);
                }
                MediaPlayerProxy.this.mHandler.post(new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass38.AnonymousClass1 */

                    public void run() {
                        if (MediaPlayerProxy.this.mOuterPreparedListener != null) {
                            MediaPlayerProxy.this.mOuterPreparedListener.onPrepared(MediaPlayerProxy.this);
                        }
                    }
                });
            }
            if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED && state != IAlixPlayer.State.STATE_VIDEO_PAUSED) {
                MediaPlayerProxy.this.mHandler.post(new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass38.AnonymousClass2 */

                    public void run() {
                        if (MediaPlayerProxy.this.mOnRealVideoStartListener != null) {
                            MediaPlayerProxy.this.mOnRealVideoStartListener.onRealVideoStart();
                        }
                    }
                });
            }
            if (state2 == IAlixPlayer.State.STATE_VIDEO_COMPLETED) {
                MediaPlayerProxy.this.mHandler.post(new Runnable() {
                    /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass38.AnonymousClass3 */

                    public void run() {
                        if (MediaPlayerProxy.this.mOuterCompletionListener != null) {
                            MediaPlayerProxy.this.mOuterCompletionListener.onCompletion(null);
                        }
                    }
                });
            }
        }
    };
    private boolean mSubtitleNativeRender = true;
    private String mSubtitleSoPath;
    private Surface mSurface = null;
    private HashMap<String, String> mTmpExtInfo = new HashMap<>();
    private int mVideoType = 0;
    private String nativeLibPath;
    private String positionFrequency = "500000";
    private String renderUsingHwc;
    private int stream_type = 0;
    private String tcConfigPath;
    private boolean useHardwareDecode;

    /* compiled from: Taobao */
    private class MPAction {
        public static final int GETAVGKEYFRAMESIZE = 110;
        public static final int GETAVGVIDEOBITRATE = 115;
        public static final int GETCURRENTPOSITION = 30;
        public static final int GETDURATION = 35;
        public static final int GETVIDEOCODE = 105;
        public static final int GETVIDEOFRAMERATE = 120;
        public static final int GETVIDEOHEIGHT = 40;
        public static final int GETVIDEOWIDTH = 45;
        public static final int ISPLAYING = 50;
        public static final int PAUSE = 55;
        public static final int PREPARE = 60;
        public static final int PREPAREASYNC = 65;
        public static final int RELEASE = 70;
        public static final int RESET = 75;
        public static final int SEEKTO = 80;
        public static final int SETAUDIOSTREAMTYPE = 85;
        public static final int SETDATASOURCE = 90;
        public static final int START = 95;
        public static final int STOP = 100;

        private MPAction() {
        }
    }

    /* compiled from: Taobao */
    private class MPS {
        public static final int END = 8;
        public static final int ERROR = -1;
        public static final int IDLE = 1;
        public static final int INITIALIZED = 2;
        public static final int PAUSED = 6;
        public static final int PLAYBACKCOMPLETED = 9;
        public static final int PREPARED = 4;
        public static final int PREPARING = 3;
        public static final int STARTED = 5;
        public static final int STOPPED = 7;
        public static final int UNINITIALIZED = 0;

        private MPS() {
        }
    }

    static {
        String[] strArr = {"HM 1SW", "2014501", "2014011", "HM 1SC", "HM 1STD"};
        for (int i = 0; i < 5; i++) {
            HD2_BLACK_LIST.add(strArr[i]);
        }
        String[] strArr2 = {"Nexus 9", "MI NOTE LTE", "SM-N9100", "HUAWEI NXT-AL10", "HUAWEI GRA-UL10", "SM-G935T", "SM-G9350", "SM-G930Т", "SM-G930"};
        for (int i2 = 0; i2 < 9; i2++) {
            HD3_WHITE_LIST.add(strArr2[i2]);
        }
    }

    @Deprecated
    public MediaPlayerProxy() {
        createMethod();
    }

    public MediaPlayerProxy(Context context) {
        this.mContext = context;
        createMethod();
    }

    public MediaPlayerProxy(boolean z) {
        createMethod();
        this.isFeedsMode = z;
    }

    private void _release() {
        TLogUtilNative.playLog("MediaPlayerProxy release");
        this.mStateChangeListener = null;
        this.mInnerOnAdEventListener = null;
        this.mInnerOnSeekCompleteListener = null;
        this.mInnerOnQualityChangeListener = null;
        this.mInnerOnInfoListener = null;
        this.mInnerVideoSizeChangedListener = null;
        this.mInnerCurrentPositionListener = null;
        this.mOuterPreparedListener = null;
        this.mOnRealVideoStartListener = null;
        this.mOuterCompletionListener = null;
        this.mADPlayListener = null;
        this.mMidADPlayListener = null;
        this.mOnPostADPlayListener = null;
        this.mOnADCountListener = null;
        this.mOnLodingStatusListener = null;
        this.mOnLodingStatusListenerNoTrack = null;
        this.mOuterSeekCompleteListener = null;
        this.mOnQualityChangeListener = null;
        this.mOnTimeoutListener = null;
        this.mPrivateOnErrorListener = null;
        this.mOuterErrorListener = null;
        this.mOuterInfoListener = null;
        this.mOuterVideoSizeChangedListener = null;
        this.mOnCurrentPositionUpdateListener = null;
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.release();
            this.mAlixPlayer.setDisplay(null);
            synchronized (this) {
                this.mAlixPlayer = null;
            }
        } else {
            TLogUtilNative.playLog("MediaPlayerProxy mAlixPlayer is null");
        }
        this.mHolder = null;
        this.mSurface = null;
        this.mPursueType = -1;
    }

    private void addPropertyNotNone(Integer num, String str) {
        if (num != null) {
            if (str == null) {
                this.mPropertyMap.remove(num);
            } else {
                this.mPropertyMap.put(num, str);
            }
        }
    }

    public static MediaPlayerProxy create(Context context, String str, SurfaceHolder surfaceHolder) {
        try {
            MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy(context);
            sPlayer = mediaPlayerProxy;
            if (surfaceHolder != null) {
                mediaPlayerProxy.setDisplay(surfaceHolder);
            }
            sPlayer.setDataSource(str);
            sPlayer.prepare();
            return sPlayer;
        } catch (IOException | IllegalArgumentException | SecurityException e) {
            c.a(TAG, "failed to create MediaPlayerProxy:", e);
            return null;
        }
    }

    private void createAlixPlayer() {
        if (this.mAlixPlayer == null) {
            c.a(LogTag.TAG_TIME, "createAlixPlayer");
            AlixPlayer alixPlayer = new AlixPlayer(a.a);
            this.mAlixPlayer = alixPlayer;
            alixPlayer.addOnPlayerStateListener(this.mStateChangeListener);
            this.mAlixPlayer.addOnAdEventListener(this.mInnerOnAdEventListener);
            this.mAlixPlayer.addOnSeekCompleteListener(this.mInnerOnSeekCompleteListener);
            this.mAlixPlayer.addOnQualityChangeListener(this.mInnerOnQualityChangeListener);
            this.mAlixPlayer.addOnInfoListener(this.mInnerOnInfoListener);
            this.mAlixPlayer.addOnVideoSizeChangedListener(this.mInnerVideoSizeChangedListener);
            this.mAlixPlayer.setOnCurrentPostionChangeListener(this.mInnerCurrentPositionListener);
        }
    }

    private HashMap<String, String> createHashMapParam(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hardwareDecode", this.useHardwareDecode ? "1" : "0");
        hashMap.put("isLiveSource", bundle.getString("isLiveSource"));
        hashMap.put("LiveSEIInfo", bundle.getString("LiveSEIInfo"));
        return hashMap;
    }

    private void createMethod() {
        this.mAlixPlayer = null;
        this.mHolder = null;
        this.mSurface = null;
        this.mInnerDisplaySet = false;
        this.mPath = null;
        this.isFeedsMode = false;
        this.mTmpExtInfo.clear();
        c.a(TAG, isUplayerSupported() ? "UPlayer is supported." : "UPlyaer may not be supported.");
    }

    private String createPlayList(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#PLSEXTM3U\n");
        stringBuffer.append("#EXT-X-TARGETDURATION:");
        stringBuffer.append("0");
        stringBuffer.append("\n#EXT-X-VERSION:2\n#EXT-X-DISCONTINUITY\n");
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append("#EXTINF:");
            stringBuffer.append("0");
            stringBuffer.append(StringUtils.LF);
            stringBuffer.append(list.get(i));
        }
        stringBuffer.append("#EXT-X-ENDLIST\n");
        return stringBuffer.toString();
    }

    private static int getNumCores() {
        int i = mNumCores;
        if (i != 0) {
            return i;
        }
        try {
            mNumCores = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                /* class com.youku.uplayer.MediaPlayerProxy.AnonymousClass6 */

                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            mNumCores = 1;
        }
        c.a(TAG, "NumCores=" + mNumCores);
        return mNumCores;
    }

    private long getSdAvailableSize() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    private static double getTotalRAM() {
        double d = mTotalRAM;
        if (d != 0.0d) {
            return d;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"));
            Matcher matcher = Pattern.compile("(\\d+)").matcher(bufferedReader.readLine());
            String str = "";
            while (matcher.find()) {
                str = matcher.group(1);
            }
            bufferedReader.close();
            double parseDouble = Double.parseDouble(str);
            mTotalRAM = parseDouble;
            mTotalRAM = parseDouble + 512000.0d;
        } catch (IOException e) {
            e.printStackTrace();
        }
        DecimalFormat decimalFormat = new DecimalFormat(PurchaseConstants.NULL_PRICE);
        c.a(TAG, "total RAM=" + decimalFormat.format((mTotalRAM / 1024.0d) / 1024.0d) + "GB");
        return mTotalRAM;
    }

    public static boolean is3GRAM() {
        double totalRAM = getTotalRAM();
        return totalRAM >= 2621440.0d && totalRAM <= 3670016.0d;
    }

    public static boolean is4GRAM() {
        return getTotalRAM() > 3670016.0d;
    }

    private boolean isArchaicDevice() {
        boolean z;
        boolean z2;
        try {
            Context context = a.a;
            if (context != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                z2 = memoryInfo.totalMem < ((Long.parseLong(d.a().a("youku_player_config", "low_mem_limit", "1")) * 1024) * 1024) * 1024;
                if (Build.VERSION.SDK_INT < 21) {
                    z = true;
                    return (!d.a().a("youku_player_config", "low_mem_judge", "1").equals("1") && z2) || (d.a().a("youku_player_config", "low_os_judge", "1").equals("1") && z);
                }
            } else {
                z2 = false;
            }
            z = false;
            if (!d.a().a("youku_player_config", "low_mem_judge", "1").equals("1")) {
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isHD2Supported() {
        return !HD2_BLACK_LIST.contains(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()) && (getTotalRAM() >= HD2_RAM_REQUIREMENT || ((double) getNumCores()) >= HD2_CORES_REQUIREMENT);
    }

    public static boolean isHD3Supported() {
        return getTotalRAM() >= HD3_RAM_REQUIREMENT;
    }

    private boolean isLoopPlay() {
        return this.mIsLoopPlay;
    }

    public static boolean isUplayerSupported() {
        boolean z;
        int i;
        int i2;
        boolean z2;
        int indexOf;
        if (isCpuinfoReaded) {
            return isUplayerSupported;
        }
        boolean z3 = true;
        isCpuinfoReaded = true;
        c.a(TAG, "--------------------------------------------");
        StringBuilder sb = new StringBuilder();
        sb.append("CPU_ABI: ");
        String cpu_abi = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
        sb.append(cpu_abi);
        c.a(TAG, sb.toString());
        c.a(TAG, "CPU_ABI2: " + Build.CPU_ABI2);
        if (cpu_abi.toLowerCase().equals(DeviceUtils.ABI_X86)) {
            isUplayerSupported = true;
            return true;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = false;
                    break;
                } else if (strArr[i3].toLowerCase().equals("armeabi-v7a")) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            z = cpu_abi.toLowerCase().equals("armeabi-v7a");
        }
        try {
            i = Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException unused) {
            i = 0;
        }
        if (i < 8) {
            c.b(TAG, "Android version is less than 2.2, not supported by Uplayer!!");
            return false;
        }
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            loop1:
            while (true) {
                z2 = false;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break loop1;
                        }
                        str = str + readLine + StringUtils.LF;
                        String upperCase = readLine.toUpperCase();
                        if (upperCase.startsWith("FEATURES") && (indexOf = upperCase.indexOf(58)) != -1) {
                            String substring = upperCase.substring(indexOf + 1);
                            if (substring.contains("NEON") || substring.contains("ASIMD")) {
                                z2 = true;
                            }
                        }
                    } catch (IOException unused2) {
                        i2 = 0;
                        c.a(TAG, str);
                        freq = (i2 + 999) / 1000;
                        z3 = false;
                        isUplayerSupported = z3;
                        return z3;
                    }
                }
                c.a(TAG, str);
                freq = (i2 + 999) / 1000;
                if (!z || !z2) {
                    z3 = false;
                }
                isUplayerSupported = z3;
                return z3;
            }
            bufferedReader.close();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            String readLine2 = bufferedReader2.readLine();
            if (readLine2 != null) {
                String trim = readLine2.trim();
                i2 = Integer.parseInt(trim);
                try {
                    str = str + "cpu0 max frequency: " + trim;
                } catch (IOException unused3) {
                }
            } else {
                i2 = 0;
            }
            bufferedReader2.close();
        } catch (IOException unused4) {
            z2 = false;
            i2 = 0;
            c.a(TAG, str);
            freq = (i2 + 999) / 1000;
            z3 = false;
            isUplayerSupported = z3;
            return z3;
        }
        c.a(TAG, str);
        freq = (i2 + 999) / 1000;
        z3 = false;
        isUplayerSupported = z3;
        return z3;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isValidToChangeState() {
        int i = this.mMPState;
        return (i == 1 || i == 7 || i == 8) ? false : true;
    }

    public static void setPlayerConfig(int i, String str) {
    }

    public static void setScreenHeight(int i) {
        if (mScreenHeight == 0) {
            mScreenHeight = i;
        }
    }

    public static void setScreenWidth(int i) {
        if (mScreenWidth == 0) {
            mScreenWidth = i;
        }
    }

    public static boolean supportH265() {
        return isHD2Supported();
    }

    public static boolean supportH265ForHlsHD2() {
        return ((double) freq) >= HD2_H265_HLS_FREQUENCY_REQUIREMENT && ((double) getNumCores()) >= HD2_H265_HLS_CORES_REQUIREMENT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0 != -1) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (r0 != 7) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r7.mMPState == -1) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        if (r0 != -1) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (r0 != 7) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        if (r6 != 3) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0050, code lost:
        if (r7.mMPState == -1) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0055, code lost:
        if (r7.mMPState == -1) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0060, code lost:
        if (r1 != 3) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0065, code lost:
        if (r7.mMPState == -1) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r0 != -1) goto L_0x0068;
     */
    private void verifyState(int i) {
        boolean z = false;
        switch (i) {
            case 30:
                break;
            case 35:
                int i2 = this.mMPState;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != -1) {
                        }
                    }
                }
                z = true;
                break;
            case 40:
            case 45:
                break;
            case 50:
                break;
            case 55:
                int i3 = this.mMPState;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 7) {
                            if (i3 != 9) {
                                if (i3 != -1) {
                                }
                            }
                        }
                    }
                }
                z = true;
                break;
            case 60:
            case 65:
                int i4 = this.mMPState;
                if (i4 != 2) {
                }
                break;
            case 80:
                int i5 = this.mMPState;
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 7) {
                        }
                    }
                }
                z = true;
                break;
            case 85:
                break;
            case 90:
                int i6 = this.mMPState;
                if (i6 != 1) {
                }
                break;
            case 95:
                int i7 = this.mMPState;
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 7) {
                        }
                    }
                }
                z = true;
                break;
            case 100:
                int i8 = this.mMPState;
                if (i8 != 1) {
                    if (i8 != 2) {
                    }
                }
                z = true;
                break;
        }
        if (z) {
            throw new IllegalStateException("mCurrentAction:" + i + ", mMPState=" + this.mMPState);
        }
    }

    public void accSeekTo(int i) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.seekTo(i, 0);
        }
    }

    @Deprecated
    public void addDataSource(String str) {
    }

    public void addDataSource(String str, Map<String, String> map) {
    }

    public void addDataSourceOnlay(String str, Map<String, String> map) {
    }

    @Deprecated
    public void addPostADUrl(String str, double d, int i) {
    }

    public void addPostADUrl(String str, double d, int i, boolean z) {
    }

    public void addProperty(Integer num, String str) {
        if (this.mPropertyMap == null) {
            this.mPropertyMap = new ConcurrentHashMap();
        }
        addPropertyNotNone(num, str);
    }

    public void addPropertyMap(Map<Integer, String> map) {
        if (this.mPropertyMap == null) {
            this.mPropertyMap = new ConcurrentHashMap();
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                addPropertyNotNone(entry.getKey(), entry.getValue());
            }
        }
    }

    public void addSubtitle(String str) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.addSubtitle(str);
        }
    }

    public void changeVideoSize(int i, int i2) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.changeVideoSize(i, i2);
        }
    }

    public void checkSource(String str) {
    }

    public void closePreloadDataSource(int i) {
    }

    public int combineVideoBegin(String str, int i, int i2, String str2, String str3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        return -1;
    }

    public int combineVideoEnd() {
        return -1;
    }

    public int cropTheImage(int i, String str, int i2, int i3, int i4, int i5) {
        return -1;
    }

    public void enableVoice(int i) {
        this.mAudioStatus = i;
        this.mAudioMute = i == 0 ? 1 : 0;
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.enableVoice(i);
        }
    }

    public int generateCacheFile(String str, String str2) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.generateCacheFile(str, str2);
        }
        return -1;
    }

    public double getAvgKeyFrameSize() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.getAvgKeyFrameSize();
        }
        return 0.0d;
    }

    public double getAvgVideoBitrate() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.getAvgVideoBitrate();
        }
        return 0.0d;
    }

    public String getCopyright_key_client() {
        return this.copyright_key_client;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getCurrentPosition() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer == null) {
            return 0;
        }
        try {
            return (int) alixPlayer.getCurrentPosition(Aliplayer.PositionType.NORMAL);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getCurrentRenderType() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.getCurrentRenderType();
        }
        return -1;
    }

    public int getCurrentVideoPosition() {
        return 0;
    }

    public int getCurrentVideoRealPts() {
        return 0;
    }

    public int getDownloadSpeed(int[] iArr) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.getDownloadSpeed(iArr);
        }
        return -1;
    }

    public String getDrmLicenseUri() {
        return this.drmLicenseUri;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getDuration() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer == null) {
            return 0;
        }
        try {
            return (int) alixPlayer.getDuration();
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getPlayerInfoByKey(int i) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        return alixPlayer != null ? alixPlayer.getPlayerInfoByKey(i) : "";
    }

    public String getTcConfigPath() {
        return this.tcConfigPath;
    }

    public int getVideoCode() {
        return 0;
    }

    public double getVideoFrameRate() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.getVideoFrameRate();
        }
        return 0.0d;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getVideoHeight() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer == null) {
            return 0;
        }
        return alixPlayer.getVideoHeight();
    }

    public int getVideoOrientation() {
        return this.mCurrentOrientation;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getVideoWidth() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer == null) {
            return 0;
        }
        return alixPlayer.getVideoWidth();
    }

    public int getVoiceStatus() {
        return this.mAudioStatus;
    }

    public float getVolume() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.getVolume();
        }
        return -1.0f;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public boolean isLooping() {
        return this.mIsLoopPlay;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public boolean isPlaying() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        boolean z = false;
        if (alixPlayer == null) {
            return false;
        }
        synchronized (alixPlayer) {
            AlixPlayer alixPlayer2 = this.mAlixPlayer;
            if (alixPlayer2 != null) {
                if (alixPlayer2.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_STARTED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_PRE_VIP_STARTED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_MID_AD_STARTED || this.mAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_POST_AD_STARTED) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean isReleased() {
        return this.isReleased;
    }

    public String isRenderUsingHwc() {
        return this.renderUsingHwc;
    }

    public boolean isUsingUMediaplayer() {
        return isUplayerSupported();
    }

    public void onAdInteract() {
    }

    public void panGuesture(int i, float f, float f2) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.panGuesture(i, f, f2);
        }
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void pause() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.pause();
        }
    }

    public void pinchForZoom(int i, float f) {
    }

    public void playBackupAD(String str, int i) {
    }

    public void playMidADConfirm(int i, int i2) {
    }

    public void playPostAD() {
    }

    public int preloadDataSource(String str, int i) {
        return -1;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void prepare() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void prepareAsync() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.prepareAsync();
        }
        if (!this.mInnerDisplaySet) {
            SurfaceHolder surfaceHolder = this.mHolder;
            if (surfaceHolder != null) {
                setDisplay(surfaceHolder);
                return;
            }
            Surface surface = this.mSurface;
            if (surface != null) {
                setTextureViewSurface(surface);
            }
        }
    }

    public void prepareMidAD() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void release() {
        this.mAudioMute = 0;
        this.mAudioStatus = 1;
        this.isReleased = true;
        _release();
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
        }
        sPlayer = null;
        this.isFeedsMode = false;
        this.isVerticalFeedMode = false;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void reset() {
    }

    public void resetPanoramic() {
    }

    public int screenShotMultiFramesBegin(String str, int i, int i2, String str2, int i3, int i4, int i5) {
        return -1;
    }

    public int screenShotMultiFramesEnd(int i, int i2, int i3, int i4, int i5, Map<String, String> map) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.screenShotMultiFramesEnd(i, i2, i3, i4, i5, map);
        }
        return -1;
    }

    public int screenShotOneFrame(AssetManager assetManager, String str, int i, int i2, int i3, String str2, int i4, int i5, int i6, int i7) {
        c.a("PlayFlow", "screenShotOneFrame outPath : " + str + " , logoPath : " + str2);
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.screenShotOneFrame(assetManager, str, i, i2, i3, str2, i4, i5, i6, i7);
        }
        return -1;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void seekTo(int i) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.seekTo(i, 0);
        }
    }

    public void setAdjectiveSource(String str, HashMap<String, String> hashMap, String str2, HashMap<String, String> hashMap2) {
    }

    public void setAdjectiveSource(List<String> list, Bundle bundle, List<String> list2, Bundle bundle2) {
        setAdjectiveSource(createPlayList(list), createHashMapParam(bundle), createPlayList(list2), createHashMapParam(bundle2));
    }

    public int setAudioCallback(AudioCallback audioCallback) {
        if (!"1".equals(d.a().a("audio_callback", "enable_callback", "1"))) {
            return -2;
        }
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer == null) {
            return -1;
        }
        alixPlayer.setAudioCallback(audioCallback);
        return 0;
    }

    public void setAudioEnhance(boolean z) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setAudioEnhance(z);
        }
    }

    public int setAudioInfo(int i, int i2) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer == null) {
            return -1;
        }
        alixPlayer.setAudioInfo(i, i2);
        return 0;
    }

    public void setAudioMode(boolean z) {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setAudioStreamType(int i) {
    }

    public void setBinocularMode(boolean z) {
        if (this.mAlixPlayer != null) {
            c.a(LogTag.TAG_PLAYER, "setBinocularMode");
            this.mAlixPlayer.setBinocularMode(z);
        }
    }

    public void setBufferProperty(String str, String str2) {
    }

    public int setColorBlindType(int i, int i2) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer == null) {
            return -1;
        }
        alixPlayer.setColorBlindType(i, i2);
        return 0;
    }

    public void setCopyright_key_client(String str) {
        this.copyright_key_client = str;
    }

    public void setCronetSoPath(String str) {
        this.mCronetSoPath = str;
    }

    public void setDRM(boolean z) {
        this.isDRM = z;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setDataSource(String str) {
        if (this.mAlixPlayer == null) {
            createAlixPlayer();
        }
        this.mAlixPlayer.setConfigCenter(new ApasConfigure());
        String str2 = LogTag.TAG_PLAYER;
        c.a(str2, "AlixPlayer path :" + str);
        String str3 = LogTag.TAG_PLAYER;
        c.a(str3, "AlixPlayer useHardwareDecode:" + this.useHardwareDecode + " isHLS:" + this.isHLS);
        Period period = new Period(new Source(str));
        period.addHeader("source force hardware decode", this.useHardwareDecode ? "1" : "0");
        period.addHeader("datasource_live_type", this.isHLS ? "1" : "0");
        if (this.isHLS) {
            period.addHeader("player_source", "3");
            period.setFeatureFlags(0);
            period.addHeader("enable get laifeng live sei info", "1");
        }
        if (!TextUtils.isEmpty(this.mFirstSubtitle)) {
            period.addHeader("uplayer_subtitle_path", this.mFirstSubtitle);
            period.addHeader("uplayer_report_sub_retry", "1");
        }
        if (!TextUtils.isEmpty(this.mSecondSubtitle)) {
            period.addHeader("uplayer_subtitle_path2", this.mSecondSubtitle);
        }
        if (!TextUtils.isEmpty(this.mSubtitleSoPath)) {
            period.addHeader("uplayer_subtitle_lib_path", this.mSubtitleSoPath);
        }
        if (!TextUtils.isEmpty(this.mCronetSoPath)) {
            period.addHeader("uplayer_cronet_lib_path", this.mCronetSoPath);
        }
        period.addHeader("AudioMute", String.valueOf(this.mAudioMute));
        period.addHeader(TableField.VIDEO_TYPE, String.valueOf(this.mVideoType));
        period.addHeader("videoRenderType", this.renderUsingHwc);
        if (getDrmLicenseUri() != null) {
            period.addHeader("drm_license_url", getDrmLicenseUri());
        }
        if (getCopyright_key_client() != null) {
            period.addHeader("drm_key", getCopyright_key_client());
        }
        period.addHeader("uplayer_ad_position_update_interval", String.valueOf(800));
        period.addHeader("uplayer_feeds_mode", this.isFeedsMode ? "1" : "0");
        period.addHeader("uplayer_vertical_feeds_mode", this.isVerticalFeedMode ? "1" : "0");
        if (!TextUtils.isEmpty(this.tcConfigPath)) {
            period.addHeader("tcConfigPath", this.tcConfigPath);
        }
        int i = this.mPursueType;
        if (i != -1) {
            period.addHeader("uplayer_live_pursue_video_frame_type", String.valueOf(i));
        }
        if (isArchaicDevice()) {
            period.addHeader("archaic_device", "1");
        } else {
            period.addHeader("archaic_device", "0");
        }
        if (!TextUtils.isEmpty(this.nativeLibPath)) {
            period.addHeader("artp_so_path", this.nativeLibPath);
        }
        Playlist playlist = new Playlist();
        playlist.addPeriod(period);
        this.mAlixPlayer.setDataSource(new ProxyMediaSource(playlist, "proxy"));
        if (this.mAudioMute == 1) {
            this.mAlixPlayer.enableVoice(0);
        }
    }

    public void setDataSource(String str, Map<String, String> map) {
    }

    public void setDataSourceOnlay(String str, Map<String, String> map) {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mHolder = surfaceHolder;
        if (this.mAlixPlayer != null && surfaceHolder != null) {
            c.a(TAG, "<********> mAlixPlayer.setDisplay(mHolder)");
            try {
                this.mAlixPlayer.setDisplay(this.mHolder.getSurface());
                this.mInnerDisplaySet = true;
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    public void setDomainStrategyAfterNetChanged(String str) {
    }

    public void setDomainStrategyAfterNetChangedM(Object obj) {
    }

    public void setDrmLicenseUri(String str) {
        this.drmLicenseUri = str;
    }

    public void setEnableSEI(boolean z) {
        this.mEnableSEI = z;
    }

    public void setEnhanceMode(boolean z, float f, float f2) {
        c.a("nightMode", "setEnhanceMode isEnhance :" + z + " / percent : " + f + " / ratio : " + f2);
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setEnhanceMode(z, f, f2);
        }
    }

    public void setExtraInfo(String str, String str2) {
    }

    public void setFilter(int i, Object obj) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setFilter(i, (Map) obj);
        }
    }

    public void setFirstSubtitleUrl(String str) {
        this.mFirstSubtitle = str;
    }

    public void setGyroscope(float f, float f2, float f3, float f4) {
    }

    public void setGyroscopeActive(boolean z) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setGyroscopeActive(z);
        }
    }

    public void setHLS(boolean z) {
        this.isHLS = z;
    }

    public void setHardwareDecode(boolean z) {
        this.useHardwareDecode = z;
    }

    public void setHttpUserAgent(String str) {
    }

    public void setInterfaceOrientation(int i) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setInterfaceOrientation(i);
        }
    }

    public void setIsLoopPlay(boolean z) {
        this.mIsLoopPlay = z;
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setIsLoopPlay(z);
        }
    }

    public void setLaifengTSMode(boolean z) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setLaifengTSMode(z ? 1 : 0);
        }
    }

    public void setLiveBufferProperty(String str, String str2) {
    }

    public void setLiveSeiGettingMode(boolean z) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setLiveSEIGettingMode(z);
        }
    }

    public void setLocalSource(String str) {
    }

    public void setMidADDataSource(String str) {
    }

    public void setNativeLibPath(String str) {
        this.nativeLibPath = str;
    }

    public void setNetProto(String str) {
    }

    public void setNetType(String str) {
    }

    public void setNightMode(int i) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setNightMode(i);
        }
    }

    public void setOnADCountListener(OnADCountListener onADCountListener) {
        this.mOnADCountListener = onADCountListener;
    }

    public void setOnADPlayListener(OnADPlayListener onADPlayListener) {
        this.mADPlayListener = onADPlayListener;
    }

    public void setOnBufferPercentUpdateListener(OnBufferPercentUpdateListener onBufferPercentUpdateListener) {
        this.mOnBufferPercentUpdateListener = onBufferPercentUpdateListener;
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOuterBufferingUpdateListener = onBufferingUpdateListener;
    }

    public void setOnCdnSwitchListener(OnCdnSwitchListener onCdnSwitchListener) {
        this.mOnCdnSwitchListener = onCdnSwitchListener;
    }

    public void setOnCombineVideoListener(OnCombineVideoListener onCombineVideoListener) {
        this.mOnCombineVideoListener = onCombineVideoListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOuterCompletionListener = onCompletionListener;
    }

    public void setOnConnectDelayListener(OnConnectDelayListener onConnectDelayListener) {
        this.mOnConnectDelayListener = onConnectDelayListener;
    }

    public void setOnCoreMsgListener(OnCoreMsgListener onCoreMsgListener) {
        this.mOnCoreMsgListener = onCoreMsgListener;
    }

    public void setOnCpuUsageListener(OnCpuUsageListener onCpuUsageListener) {
        this.mOnCpuUsageListener = onCpuUsageListener;
    }

    public void setOnCurrentPositionUpdateListener(OnCurrentPositionUpdateListener onCurrentPositionUpdateListener) {
        this.mOnCurrentPositionUpdateListener = onCurrentPositionUpdateListener;
    }

    public void setOnDropVideoFramesListener(OnDropVideoFramesListener onDropVideoFramesListener) {
        this.mOnDropVideoFramesListener = onDropVideoFramesListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mOuterErrorListener = onErrorListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mPrivateOnErrorListener = onErrorListener;
    }

    public void setOnFirstFrameListener(OnFirstFrameListener onFirstFrameListener) {
        this.mOnFirstFrameListener = onFirstFrameListener;
    }

    public void setOnHttp302DelayListener(OnHttp302DelayListener onHttp302DelayListener) {
        this.mOnHttp302DelayListener = onHttp302DelayListener;
    }

    public void setOnHwDecodeErrorListener(OnHwDecodeErrorListener onHwDecodeErrorListener) {
        this.mOnHwDecodeErrorListener = onHwDecodeErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.mOuterInfoListener = onInfoListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mPrivateOnInfoListener = onInfoListener;
    }

    public void setOnIsInitialListener(OnIsInitialListener onIsInitialListener) {
        this.mOnIsInitialListener = onIsInitialListener;
    }

    public void setOnLodingStatusListener(OnLoadingStatusListener onLoadingStatusListener) {
        this.mOnLodingStatusListener = onLoadingStatusListener;
    }

    public void setOnMidADPlayListener(OnMidADPlayListener onMidADPlayListener) {
        this.mMidADPlayListener = onMidADPlayListener;
    }

    public void setOnNetworkErrorListener(OnNetworkErrorListener onNetworkErrorListener) {
        this.mOnNetworkErrorListener = onNetworkErrorListener;
    }

    public void setOnNetworkSpeedListener(OnNetworkSpeedListener onNetworkSpeedListener) {
        this.mOnNetworkSpeedListener = onNetworkSpeedListener;
    }

    public void setOnNetworkSpeedPerMinute(OnNetworkSpeedPerMinute onNetworkSpeedPerMinute) {
        this.mOnNetworkSpeedPerMinute = onNetworkSpeedPerMinute;
    }

    public void setOnPlayerHostListener(OnPlayerHostListener onPlayerHostListener) {
        this.mOnPlayerHostListener = onPlayerHostListener;
    }

    public void setOnPlayerP2PListener(OnPlayerP2PListener onPlayerP2PListener) {
        this.mOnPlayerP2PListener = onPlayerP2PListener;
    }

    public void setOnPostADPlayListener(OnPostADPlayListener onPostADPlayListener) {
        this.mOnPostADPlayListener = onPostADPlayListener;
    }

    public void setOnPreLoadPlayListener(OnPreLoadPlayListener onPreLoadPlayListener) {
        this.mOnPreLoadPlayListener = onPreLoadPlayListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mOuterPreparedListener = onPreparedListener;
    }

    public void setOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener) {
        this.mOnQualityChangeListener = onQualityChangeListener;
    }

    public void setOnRealVideoCompletionListener(OnRealVideoCompletionListener onRealVideoCompletionListener) {
        this.mOnRealVideoCompletionListener = onRealVideoCompletionListener;
    }

    public void setOnRealVideoStartListener(OnRealVideoStartListener onRealVideoStartListener) {
        this.mOnRealVideoStartListener = onRealVideoStartListener;
    }

    public void setOnScreenShotFinishListener(OnScreenShotFinishListener onScreenShotFinishListener) {
        this.mOnScreenShotFinishListener = onScreenShotFinishListener;
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOuterSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnSliceUpdateListener(OnSliceUpdateListener onSliceUpdateListener) {
        this.mOnSliceUpdateListener = onSliceUpdateListener;
    }

    public void setOnTimeoutListener(OnTimeoutListener onTimeoutListener) {
        this.mOnTimeoutListener = onTimeoutListener;
    }

    public void setOnVideoCurrentIndexUpdateListener(OnVideoCurrentIndexUpdateListener onVideoCurrentIndexUpdateListener) {
        this.mOnVideoCurrentIndexUpdateListener = onVideoCurrentIndexUpdateListener;
    }

    public void setOnVideoIndexUpdateListener(OnVideoIndexUpdateListener onVideoIndexUpdateListener) {
        this.mOnVideoIndexUpdateListener = onVideoIndexUpdateListener;
    }

    public void setOnVideoRealIpUpdateListener(OnVideoRealIpUpdateListener onVideoRealIpUpdateListener) {
        this.mOnVideoRealIpUpdateListener = onVideoRealIpUpdateListener;
    }

    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOuterVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    public void setPlayRate(int i) {
    }

    public void setPlaySpeed(double d) {
        try {
            if (this.mAlixPlayer != null) {
                String str = LogTag.TAG_PLAYER;
                c.a(str, "setPlaySpeed --> playSpeed :" + d);
                this.mAlixPlayer.setPlaySpeed(d);
            }
        } catch (Exception e) {
            c.a(TAG, e);
        }
    }

    public void setPlaybackParam(int i, String str) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setPlaybackParam(i, str);
        }
    }

    public void setPlayerTimeoutProperty(Map<Integer, String> map) {
        addPropertyMap(map);
    }

    public void setPositionFrequency(String str) {
        this.positionFrequency = str;
    }

    public void setPropertyMap(Map<Integer, String> map) {
        this.mPropertyMap = map;
    }

    public void setPursueVideoFrameType(int i) {
        this.mPursueType = i;
    }

    public void setRenderUsingHwc(String str) {
        this.renderUsingHwc = str;
    }

    public void setRenderVideo(boolean z) {
    }

    public void setRotationMatrix(int i, float[] fArr) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setRotationMatrix(i, fArr);
        }
    }

    public void setSEIInterval(long j) {
        this.mSEIInterval = j;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setScreenOnWhilePlaying(boolean z) {
        SurfaceHolder surfaceHolder = this.mHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(z);
        }
    }

    public void setSecondSubtitleUrl(String str) {
        this.mSecondSubtitle = str;
    }

    public void setStremType(int i) {
        this.stream_type = i;
    }

    public void setSubtitleNativeRender(boolean z) {
        this.mSubtitleNativeRender = z;
    }

    public void setSubtitleSoPath(String str) {
        this.mSubtitleSoPath = str;
    }

    public int setTcConfigParam(int i) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer == null) {
            return -1;
        }
        alixPlayer.setTcConfigParam(i);
        return 0;
    }

    public void setTcConfigPath(String str) {
        this.tcConfigPath = str;
    }

    public void setTextureViewSurface(Surface surface) {
        this.mSurface = surface;
        if (this.mAlixPlayer != null && surface != null) {
            c.a(TAG, "<********> mAlixPlayer.setDisplay()---" + surface);
            this.mAlixPlayer.setDisplay(this.mSurface);
            this.mInnerDisplaySet = true;
        }
    }

    public void setTimeout(int i, int i2) {
    }

    public void setUseAliPlayer(boolean z) {
    }

    public void setVerticalFeedMode(boolean z) {
        this.isVerticalFeedMode = z;
    }

    public void setVideoOrientation(int i) {
        this.mCurrentOrientation = i;
    }

    public void setVideoRendCutMode(int i, float f, float f2) {
        try {
            AlixPlayer alixPlayer = this.mAlixPlayer;
            if (alixPlayer != null) {
                alixPlayer.setVideoRendCutMode(i, f, f2);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void setVideoRendMove(float f, float f2) {
        try {
            AlixPlayer alixPlayer = this.mAlixPlayer;
            if (alixPlayer != null) {
                alixPlayer.setVideoRendMove(f, f2);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void setVideoType(int i) {
        this.mVideoType = i;
    }

    public int setVideoVisionIndex(int i) {
        return -1;
    }

    public void setVolume(float f) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.setVolume(f);
        }
    }

    public int setWaterMarkInfo(int i, String str, int i2, int i3, float f, float f2, float f3) {
        return -1;
    }

    public void setmOnLodingStatusListenerNoTrack(OnLoadingStatusListenerNoTrack onLoadingStatusListenerNoTrack) {
        this.mOnLodingStatusListenerNoTrack = onLoadingStatusListenerNoTrack;
    }

    public void setmOnNativeShotDownListener(OnNativeShotDownListener onNativeShotDownListener) {
        this.mOnNativeShotDownListener = onNativeShotDownListener;
    }

    public void setsystemMediaplayerClose(boolean z) {
    }

    public void skipAd(int i) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.skipAd(i);
        }
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void start() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.start();
        }
    }

    public int startDetectImage(int i, int i2) {
        return 0;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void stop() {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            this.mAudioMute = 0;
            this.mAudioStatus = 1;
            alixPlayer.stop();
        }
    }

    public int stopDetectImage() {
        return 0;
    }

    public void stopVideoSurface(Surface surface) {
    }

    public int switchDataSource(String str) {
        return -1;
    }

    @Deprecated
    public int switchDataSource(String str, int i, String str2) {
        return -1;
    }

    @Deprecated
    public int switchDataSource(String str, String str2) {
        return -1;
    }

    public int switchDataSource(String str, Map<String, String> map) {
        return -1;
    }

    public void switchPlayerMode(int i) {
        switchPlayerMode(i, 0);
    }

    public void switchPlayerMode(int i, int i2) {
        if (this.mAlixPlayer != null) {
            String str = LogTag.TAG_PLAYER;
            c.a(str, "new switchPlayerMode --> mode :" + i + " / vrType: " + i2);
            if (!this.useHardwareDecode) {
                this.mAlixPlayer.switchPlayerMode(i, i2);
            }
        }
    }

    public void switchSubtitle(boolean z) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            alixPlayer.switchSubtitle(z);
        }
    }

    public int switchSubtitleUrl(String str) {
        AlixPlayer alixPlayer = this.mAlixPlayer;
        if (alixPlayer != null) {
            return alixPlayer.switchSubtitleUrl(str);
        }
        return -1;
    }

    public void testGetKey() {
    }

    public void testPutKey() {
    }
}
