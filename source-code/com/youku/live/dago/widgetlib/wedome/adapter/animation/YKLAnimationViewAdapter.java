package com.youku.live.dago.widgetlib.wedome.adapter.animation;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.animate.AnimatedLoopListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.AlixPlayer;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.PlayerView;
import com.youku.alixplayer.filter.BuiltInRenderFilter;
import com.youku.live.animation.AnimationError;
import com.youku.live.animation.AnimationFileType;
import com.youku.live.animation.AnimationProperties;
import com.youku.live.animation.AnimationView;
import com.youku.live.animation.IAnimationCallback;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.doodle.RobotPainter;
import com.youku.live.dago.widgetlib.doodle.SplashItemParser;
import com.youku.live.dago.widgetlib.doodle.SplashScheduler;
import com.youku.live.dago.widgetlib.doodle.drawable.TUrlDrawable;
import com.youku.live.dago.widgetlib.doodle.impl.LaifengSplashItemParser;
import com.youku.live.dago.widgetlib.doodle.impl.LaifengSplashScheduler;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.MineLotteryData;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.view.MineLotteryView;
import com.youku.live.dago.widgetlib.interactive.gift.view.BigGiftNumLayout;
import com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadListener;
import com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourceManager;
import com.youku.live.dago.widgetlib.interactive.resource.utils.ResourceOrangeUtils;
import com.youku.live.dago.widgetlib.interactive.resource.utils.YKLMD5Utils;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol;
import com.youku.live.dago.widgetlib.util.OrangeUtil;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.playerservice.player.UrlMediaSource;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;
import tb.io1;

/* compiled from: Taobao */
public class YKLAnimationViewAdapter implements YKLAnimationViewProtocol {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_MP4 = "mp4";
    public static final String TYPE_MP4GIFT = "mp4gift";
    public static final String TYPE_WEBP = "webp";
    private final int WEEX_LENGTH = FeatureFactory.PRIORITY_ABOVE_NORMAL;
    private AnimationView mAnimationView;
    private IAnimationCallback mCallback;
    private String mComboCount;
    private Context mContext;
    private AlixPlayer mGiftPlayer;
    private SquareLayout mGiftPlayerContainer;
    private PlayerView mGiftPlayerView;
    private SplashItemParser<String, String> mSplashItemParser;
    private SplashScheduler<String, String> mSplashScheduler;
    private int mViewHeight = -1;
    private int mViewWidth = -1;
    private int mWeexHeight = -1;
    private int mWeexWidth = -1;

    /* renamed from: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter$10  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[YKLAnimationViewProtocol.GiftType.values().length];
            $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType = iArr;
            iArr[YKLAnimationViewProtocol.GiftType.GRAFFITI.ordinal()] = 1;
            $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.MP4_GIFT.ordinal()] = 2;
            $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.MP4.ordinal()] = 3;
            $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.LOTTIE.ordinal()] = 4;
            $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.SVGA.ordinal()] = 5;
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.WEBP.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SquareLayout extends FrameLayout {
        public SquareLayout(@NonNull Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (size <= size2) {
                size = size2;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size, mode2));
        }
    }

    public YKLAnimationViewAdapter(Context context) {
        this.mContext = context;
        init();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addNumView(AnimationView animationView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584807083")) {
            ipChange.ipc$dispatch("-584807083", new Object[]{this, animationView, str});
        } else if (ParseUtils.parse2Int(str) >= 2) {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-bignum", "addNumView comboNum = " + str);
            if (animationView != null && !TextUtils.isEmpty(str)) {
                BigGiftNumLayout bigGiftNumLayout = new BigGiftNumLayout(animationView.getContext());
                bigGiftNumLayout.setNum(str);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                layoutParams.bottomMargin = DensityUtil.dip2px(this.mContext, 20.0f);
                animationView.addView(bigGiftNumLayout, layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void cancelGiftPlayer() {
        SquareLayout squareLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119637514")) {
            ipChange.ipc$dispatch("119637514", new Object[]{this});
            return;
        }
        AlixPlayer alixPlayer = this.mGiftPlayer;
        if (alixPlayer != null) {
            alixPlayer.stop();
            this.mGiftPlayer = null;
        }
        PlayerView playerView = this.mGiftPlayerView;
        if (!(playerView == null || this.mGiftPlayerContainer == null)) {
            if (this.mGiftPlayerContainer.equals(playerView.getParent())) {
                this.mGiftPlayerContainer.removeView(this.mGiftPlayerView);
            }
            this.mGiftPlayerView = null;
        }
        if (this.mAnimationView != null && (squareLayout = this.mGiftPlayerContainer) != null) {
            if (this.mAnimationView.equals(squareLayout.getParent())) {
                this.mAnimationView.removeView(this.mGiftPlayerContainer);
            }
            this.mGiftPlayerContainer = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doGestureGiftDisappearAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193632262")) {
            ipChange.ipc$dispatch("193632262", new Object[]{this});
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "849029306")) {
                    ipChange.ipc$dispatch("849029306", new Object[]{this});
                    return;
                }
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f));
                animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
                animationSet.setDuration(300);
                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass4.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onAnimationEnd(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-547484516")) {
                            ipChange.ipc$dispatch("-547484516", new Object[]{this, animation});
                            return;
                        }
                        if (YKLAnimationViewAdapter.this.mCallback != null) {
                            YKLAnimationViewAdapter.this.mCallback.onAnimationEnd();
                        }
                        YKLAnimationViewAdapter.this.mAnimationView.postDelayed(new Runnable() {
                            /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass4.AnonymousClass1.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1220157984")) {
                                    ipChange.ipc$dispatch("1220157984", new Object[]{this});
                                    return;
                                }
                                YKLAnimationViewAdapter.this.mAnimationView.removeView(YKLAnimationViewAdapter.this.mSplashScheduler.getContentView());
                            }
                        }, 150);
                    }

                    public void onAnimationRepeat(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1661967704")) {
                            ipChange.ipc$dispatch("1661967704", new Object[]{this, animation});
                        }
                    }

                    public void onAnimationStart(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "643557621")) {
                            ipChange.ipc$dispatch("643557621", new Object[]{this, animation});
                        }
                    }
                });
                YKLAnimationViewAdapter.this.mSplashScheduler.getContentView().startAnimation(animationSet);
            }
        }, 1000);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22538971")) {
            ipChange.ipc$dispatch("-22538971", new Object[]{this});
            return;
        }
        this.mAnimationView = new AnimationView(this.mContext);
        this.mAnimationView.useCache(OrangeUtil.isUseCacheInSVGAAnim());
        this.mAnimationView.setFocusable(false);
        this.mAnimationView.setClickable(false);
        this.mAnimationView.isWeex(true);
    }

    private void playGraffiti(String str, final String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609885422")) {
            ipChange.ipc$dispatch("1609885422", new Object[]{this, str, str2, str3, map});
            return;
        }
        if (this.mSplashScheduler == null) {
            this.mSplashItemParser = LaifengSplashItemParser.getInstance();
            LaifengSplashScheduler laifengSplashScheduler = new LaifengSplashScheduler(this.mContext);
            this.mSplashScheduler = laifengSplashScheduler;
            laifengSplashScheduler.setParser(this.mSplashItemParser);
            this.mSplashScheduler.enableTouch(false);
            this.mSplashScheduler.setRenderScaleType(RobotPainter.ScaleType.CENTER_INSIDE);
            this.mSplashScheduler.addOnSplashUpdateListener(new SplashScheduler.OnSplashUpdateListener() {
                /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler.OnSplashUpdateListener
                public void onPaintingEnd() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1538865999")) {
                        ipChange.ipc$dispatch("1538865999", new Object[]{this});
                        return;
                    }
                    YKLAnimationViewAdapter.this.doGestureGiftDisappearAnimation();
                }

                @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler.OnSplashUpdateListener
                public void onPaintingStart() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1025715496")) {
                        ipChange.ipc$dispatch("1025715496", new Object[]{this});
                    } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                        YKLAnimationViewAdapter.this.mCallback.onAnimationStart();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler.OnSplashUpdateListener
                public void onSplashUpdate(float f, float f2, int i, int i2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-953439948")) {
                        ipChange.ipc$dispatch("-953439948", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
                    }
                }
            });
        }
        SplashScheduler.IconItem[] iconItemArr = new SplashScheduler.IconItem[map.size()];
        int dip2px = DensityUtil.dip2px(AppContextUtils.getApp(), 34.0f);
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            iconItemArr[i] = new SplashScheduler.IconItem();
            iconItemArr[i].icon = new TUrlDrawable(entry.getValue(), null);
            iconItemArr[i].icon.setBounds(0, 0, dip2px, dip2px);
            iconItemArr[i].stringId = entry.getKey();
            iconItemArr[i].iconIdentity = entry.getKey().hashCode();
            i++;
        }
        this.mSplashScheduler.setIcons(iconItemArr);
        this.mSplashScheduler.getSketchBoard().clear();
        this.mSplashScheduler.getContentView().setVisibility(0);
        this.mAnimationView.addView(this.mSplashScheduler.getContentView(), new ViewGroup.LayoutParams(-1, -1));
        this.mSplashScheduler.updateCanvasSize(str);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1045542811")) {
                    ipChange.ipc$dispatch("1045542811", new Object[]{this});
                    return;
                }
                YKLAnimationViewAdapter.this.mSplashScheduler.render(str2);
            }
        }, 500);
    }

    private void playMp4Gift(String str) {
        File file;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1766443378")) {
            ipChange.ipc$dispatch("1766443378", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            IAnimationCallback iAnimationCallback = this.mCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationError(new AnimationError());
            }
        } else {
            File file2 = new File(str);
            String str2 = null;
            if (!file2.exists()) {
                IAnimationCallback iAnimationCallback2 = this.mCallback;
                if (iAnimationCallback2 != null) {
                    iAnimationCallback2.onAnimationError(new AnimationError());
                    return;
                }
                return;
            }
            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "file.exists()");
            if (file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    IAnimationCallback iAnimationCallback3 = this.mCallback;
                    if (iAnimationCallback3 != null) {
                        iAnimationCallback3.onAnimationError(new AnimationError());
                        return;
                    }
                    return;
                }
                while (true) {
                    if (i >= listFiles.length) {
                        break;
                    }
                    file = listFiles[i];
                    if (file == null || (!file.getAbsolutePath().endsWith(".mp4gift") && !file.getAbsolutePath().endsWith(".mp4"))) {
                        i++;
                    }
                }
                str2 = file.getAbsolutePath();
            } else {
                str2 = file2.getAbsolutePath();
            }
            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation resourcePath = " + str2);
            this.mAnimationView.removeAllViews();
            AlixPlayer alixPlayer = new AlixPlayer(this.mContext);
            alixPlayer.addRenderFilter(new BuiltInRenderFilter(BuiltInRenderFilter.VideoFilter.ALPHA));
            alixPlayer.addOnPlayerStateListener(new OnStateChangeListener() {
                /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.alixplayer.OnStateChangeListener
                public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-870666114")) {
                        ipChange.ipc$dispatch("-870666114", new Object[]{this, state, state2});
                        return;
                    }
                    if (state2 == IAlixPlayer.State.STATE_SOURCE_READY) {
                        YKLAnimationViewAdapter.this.mGiftPlayer.prepareAsync();
                    }
                    if (state2 == IAlixPlayer.State.STATE_PREPARED) {
                        YKLAnimationViewAdapter.this.mGiftPlayer.start();
                        if (YKLAnimationViewAdapter.this.mAnimationView != null) {
                            YKLAnimationViewAdapter.this.mAnimationView.post(new Runnable() {
                                /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass5.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "1643726636")) {
                                        ipChange.ipc$dispatch("1643726636", new Object[]{this});
                                    } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                                        YKLAnimationViewAdapter.this.mCallback.onAnimationStart();
                                    }
                                }
                            });
                        }
                    }
                    if (state2 == IAlixPlayer.State.STATE_VIDEO_COMPLETED && YKLAnimationViewAdapter.this.mAnimationView != null) {
                        YKLAnimationViewAdapter.this.mAnimationView.post(new Runnable() {
                            /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass5.AnonymousClass2 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1447213131")) {
                                    ipChange.ipc$dispatch("1447213131", new Object[]{this});
                                    return;
                                }
                                YKLAnimationViewAdapter.this.cancelGiftPlayer();
                                if (YKLAnimationViewAdapter.this.mCallback != null) {
                                    YKLAnimationViewAdapter.this.mCallback.onAnimationEnd();
                                }
                            }
                        });
                    }
                }
            });
            alixPlayer.addOnInfoListener(new OnInfoListener() {
                /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass6 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.alixplayer.OnInfoListener
                public void onInfo(int i, int i2, int i3, Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-657878139")) {
                        ipChange.ipc$dispatch("-657878139", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
                        return;
                    }
                    if (!(i == 503 || i == 1002 || i == 1023 || i == 2205 || i == 3002 || i == 70000 || i == 1110 || i == 1111 || i == 2004 || i == 2005 || i == 2200 || i == 2201 || i == 16005 || i == 16006 || i == 30000 || i == 30001)) {
                        switch (i) {
                            case 1005:
                            case 1006:
                            case 1007:
                            case 1008:
                            case 1009:
                            case 1010:
                                break;
                            default:
                                return;
                        }
                    }
                    if (YKLAnimationViewAdapter.this.mCallback != null) {
                        ((ILog) Dsl.getService(ILog.class)).e("liulei-anim-mp4", "MP4 ANIM ERROR CODE = " + i);
                        final IAnimationCallback iAnimationCallback = YKLAnimationViewAdapter.this.mCallback;
                        WidgetSDKEngine.getInstance().getRenderMananger().postOnUiThread(new Runnable() {
                            /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass6.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1772809355")) {
                                    ipChange.ipc$dispatch("1772809355", new Object[]{this});
                                    return;
                                }
                                IAnimationCallback iAnimationCallback = iAnimationCallback;
                                if (iAnimationCallback != null) {
                                    iAnimationCallback.onAnimationError(new AnimationError());
                                }
                            }
                        });
                    }
                }
            });
            PlayerView playerView = new PlayerView(this.mContext);
            playerView.setPlayer(alixPlayer);
            playerView.setRenderDevice(PlayerView.RenderDeviceType.TEXTURE);
            playerView.setProportionRelation(PlayerView.ProportionRelation.FILL_SCREEN);
            this.mGiftPlayer = alixPlayer;
            this.mGiftPlayerView = playerView;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            SquareLayout squareLayout = new SquareLayout(this.mContext);
            this.mGiftPlayerContainer = squareLayout;
            squareLayout.addView(this.mGiftPlayerView, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 81;
            this.mAnimationView.addView(this.mGiftPlayerContainer, layoutParams2);
            alixPlayer.setDataSource(new UrlMediaSource(str2));
        }
    }

    private void playWebPAnim(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1412930978")) {
            ipChange.ipc$dispatch("-1412930978", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "playWebPAnim");
        if (this.mAnimationView.getParent() != null) {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "mAnimationView.getParent() = " + this.mAnimationView.getParent().getClass());
        }
        if (TextUtils.isEmpty(str)) {
            IAnimationCallback iAnimationCallback = this.mCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationError(new AnimationError());
                return;
            }
            return;
        }
        File file = new File(str);
        String str2 = null;
        if (!file.exists()) {
            IAnimationCallback iAnimationCallback2 = this.mCallback;
            if (iAnimationCallback2 != null) {
                iAnimationCallback2.onAnimationError(new AnimationError());
                return;
            }
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "file.exists()");
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                while (true) {
                    if (i < listFiles.length) {
                        File file2 = listFiles[i];
                        if (file2 != null && file2.exists()) {
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation animFile 5555 = " + file2.getAbsolutePath());
                        }
                        if (file2 != null && file2.getAbsolutePath().endsWith(".webp")) {
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation resourcePath 11111 = " + ((String) null));
                            str2 = file2.getAbsolutePath();
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            } else {
                IAnimationCallback iAnimationCallback3 = this.mCallback;
                if (iAnimationCallback3 != null) {
                    iAnimationCallback3.onAnimationError(new AnimationError());
                    return;
                }
                return;
            }
        } else {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation resourcePath 2222 = " + ((String) null));
            str2 = file.getAbsolutePath();
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation resourcePath = " + str2);
        this.mAnimationView.removeAllViews();
        final TUrlImageView tUrlImageView = new TUrlImageView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mAnimationView.addView(tUrlImageView, layoutParams);
        DagoImageLoader.getInstance().load(this.mContext, str2, new ImageLoadListener() {
            /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onFail() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-681230459")) {
                    ipChange.ipc$dispatch("-681230459", new Object[]{this});
                } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                    YKLAnimationViewAdapter.this.mCallback.onAnimationError(new AnimationError());
                }
            }

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onSuccess(BitmapDrawable bitmapDrawable) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-618227751")) {
                    ipChange.ipc$dispatch("-618227751", new Object[]{this, bitmapDrawable});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "PhenixTicket  ");
                if (bitmapDrawable instanceof AnimatedImageDrawable) {
                    AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) bitmapDrawable;
                    animatedImageDrawable.v(1);
                    animatedImageDrawable.u(new AnimatedLoopListener() {
                        /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass1.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.taobao.phenix.animate.AnimatedLoopListener
                        public boolean onLoopCompleted(int i, int i2) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "415026519")) {
                                return ((Boolean) ipChange.ipc$dispatch("415026519", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
                            }
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onSuccess onLoopCompleted " + i + "     " + "    " + i2);
                            if (i == 1 && YKLAnimationViewAdapter.this.mCallback != null) {
                                YKLAnimationViewAdapter.this.mCallback.onAnimationEnd();
                            }
                            return true;
                        }
                    });
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onSuccess AnimatedImageDrawable ");
                }
                if (YKLAnimationViewAdapter.this.mCallback != null) {
                    YKLAnimationViewAdapter.this.mCallback.onAnimationStart();
                }
                tUrlImageView.setImageDrawable(bitmapDrawable);
            }
        });
    }

    private void setViewLayoutParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-100496834")) {
            ipChange.ipc$dispatch("-100496834", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-anim", "WIDTH = " + this.mViewWidth + "   HEIGHT = " + this.mViewHeight);
        AnimationView animationView = this.mAnimationView;
        if (animationView != null && animationView.getParent() != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mAnimationView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
            } else {
                layoutParams.width = this.mViewWidth;
                layoutParams.height = this.mViewHeight;
            }
            layoutParams.gravity = 17;
            this.mAnimationView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602123131")) {
            ipChange.ipc$dispatch("602123131", new Object[]{this});
            return;
        }
        cancelGiftPlayer();
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            animationView.cancel();
            this.mAnimationView.removeAllViews();
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void defaultPlay(YKLAnimationViewProtocol.GiftAnimationItem giftAnimationItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "118735017")) {
            ipChange.ipc$dispatch("118735017", new Object[]{this, giftAnimationItem});
        } else if (AnonymousClass10.$SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[giftAnimationItem.type.ordinal()] == 1) {
        } else {
            if (!TextUtils.isEmpty(giftAnimationItem.localPath)) {
                defaultPlayByLocalPah(giftAnimationItem.type.getTypeString(), giftAnimationItem.localPath, giftAnimationItem.isZip, giftAnimationItem.autoPlay, giftAnimationItem.properties);
            } else if (TextUtils.isEmpty(giftAnimationItem.data)) {
                defaultPlayById(giftAnimationItem.type.getTypeString(), giftAnimationItem.id, giftAnimationItem.properties);
            } else {
                defaultPlayByUrl(giftAnimationItem.type.getTypeString(), giftAnimationItem.data, giftAnimationItem.isZip, giftAnimationItem.autoPlay, giftAnimationItem.properties);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void defaultPlayById(String str, String str2, Map map) {
        int i;
        List<String> resourcePath;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-114567581")) {
            ipChange.ipc$dispatch("-114567581", new Object[]{this, str, str2, map});
        } else if (TextUtils.isEmpty(str2)) {
            AnimationError animationError = new AnimationError();
            animationError.errorMessage = "id is null";
            this.mCallback.onAnimationError(animationError);
        } else {
            AnimationFileType animationFileType = AnimationFileType.TYPE_SVGA;
            if (!TextUtils.isEmpty(str) && !str.equals(animationFileType.getFileName())) {
                AnimationFileType animationFileType2 = AnimationFileType.TYPE_LOTTIE;
                if (str.equals(animationFileType2.getFileName())) {
                    animationFileType = animationFileType2;
                }
            }
            AnimationProperties animationProperties = null;
            if (map != null) {
                String valueOf = String.valueOf(map.get(IWXAudio.KEY_LOOP));
                if (!TextUtils.isEmpty(valueOf)) {
                    animationProperties = new AnimationProperties();
                    i = Integer.parseInt(valueOf);
                    animationProperties.loopCount = i;
                    resourcePath = YKLResourceManager.getInstance().getResourcePath(str2);
                    ILog iLog = (ILog) Dsl.getService(ILog.class);
                    StringBuilder sb = new StringBuilder();
                    sb.append("animation pathes is null = ");
                    if (resourcePath != null) {
                        z = false;
                    }
                    sb.append(z);
                    iLog.d("liulei-anim", sb.toString());
                    if (resourcePath != null || resourcePath.size() <= 0) {
                        YKLResourceManager.getInstance().getResourcePath(str2);
                        this.mCallback.onAnimationError(new AnimationError());
                    }
                    String str3 = resourcePath.get(0);
                    if (!TextUtils.isEmpty(str3)) {
                        AnimationView animationView = this.mAnimationView;
                        if (animationView != null) {
                            animationView.setLoopCount(i);
                            this.mAnimationView.play(animationFileType, str3, animationProperties);
                            return;
                        }
                        return;
                    }
                    this.mCallback.onAnimationError(new AnimationError());
                    return;
                }
            }
            i = 1;
            resourcePath = YKLResourceManager.getInstance().getResourcePath(str2);
            ILog iLog2 = (ILog) Dsl.getService(ILog.class);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("animation pathes is null = ");
            if (resourcePath != null) {
            }
            sb2.append(z);
            iLog2.d("liulei-anim", sb2.toString());
            if (resourcePath != null) {
            }
            YKLResourceManager.getInstance().getResourcePath(str2);
            this.mCallback.onAnimationError(new AnimationError());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void defaultPlayByLocalPah(String str, String str2, boolean z, String str3, Map map) {
        AnimationFileType animationFileType;
        AnimationView animationView;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1282116456")) {
            ipChange.ipc$dispatch("-1282116456", new Object[]{this, str, str2, Boolean.valueOf(z), str3, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "defaultPlayByUrl");
        if (TextUtils.isEmpty(str2)) {
            AnimationError animationError = new AnimationError();
            animationError.errorMessage = "localPath is null";
            this.mCallback.onAnimationError(animationError);
            return;
        }
        AnimationFileType animationFileType2 = AnimationFileType.TYPE_SVGA;
        if (!TextUtils.isEmpty(str) && !str.equals(animationFileType2.getFileName())) {
            AnimationFileType animationFileType3 = AnimationFileType.TYPE_LOTTIE;
            if (str.equals(animationFileType3.getFileName())) {
                animationFileType = animationFileType3;
                AnimationProperties animationProperties = null;
                if (map != null) {
                    String valueOf = String.valueOf(map.get(IWXAudio.KEY_LOOP));
                    if (!TextUtils.isEmpty(valueOf)) {
                        animationProperties = new AnimationProperties();
                        i = Integer.parseInt(valueOf);
                        animationProperties.loopCount = i;
                    }
                }
                animationView = this.mAnimationView;
                if (animationView == null) {
                    animationView.setLoopCount(i);
                    if ("1".equals(str3)) {
                        this.mAnimationView.play(animationFileType, str2, animationProperties);
                    } else if ("0".equals(str3)) {
                        this.mAnimationView.stepFramePlay(1, false, animationFileType, str2, animationProperties);
                    }
                    this.mCallback.onAnimationStart();
                    return;
                }
                return;
            }
        }
        animationFileType = animationFileType2;
        AnimationProperties animationProperties2 = null;
        if (map != null) {
        }
        animationView = this.mAnimationView;
        if (animationView == null) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c5  */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void defaultPlayByUrl(final String str, final String str2, final boolean z, final String str3, final Map map) {
        AnimationProperties animationProperties;
        int i;
        List<String> resourcesPath;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1258061171")) {
            ipChange.ipc$dispatch("-1258061171", new Object[]{this, str, str2, Boolean.valueOf(z), str3, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "defaultPlayByUrl");
        if (TextUtils.isEmpty(str2)) {
            AnimationError animationError = new AnimationError();
            animationError.errorMessage = "url is null";
            this.mCallback.onAnimationError(animationError);
            return;
        }
        AnimationFileType animationFileType = AnimationFileType.TYPE_SVGA;
        if (!TextUtils.isEmpty(str) && !str.equals(animationFileType.getFileName())) {
            AnimationFileType animationFileType2 = AnimationFileType.TYPE_LOTTIE;
            if (str.equals(animationFileType2.getFileName())) {
                animationFileType = animationFileType2;
            }
        }
        if (map != null) {
            String valueOf = String.valueOf(map.get(IWXAudio.KEY_LOOP));
            if (!TextUtils.isEmpty(valueOf)) {
                AnimationProperties animationProperties2 = new AnimationProperties();
                int parseInt = Integer.parseInt(valueOf);
                animationProperties2.loopCount = parseInt;
                animationProperties = animationProperties2;
                i = parseInt;
                String md5 = YKLMD5Utils.md5(str2);
                resourcesPath = YKLResourceManager.getInstance().getResourcesPath("youku", str2, z, md5, animationFileType.getFileName());
                ILog iLog = (ILog) Dsl.getService(ILog.class);
                StringBuilder sb = new StringBuilder();
                sb.append("animation pathes is null = ");
                sb.append(resourcesPath != null);
                iLog.d("liulei-anim", sb.toString());
                if (resourcesPath != null || resourcesPath.size() <= 0) {
                    YKLResourceManager.getInstance().reloadResouce("youku", str2, z, animationFileType.getFileName(), md5, new YKLDownloadListener() {
                        /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass9 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.taobao.downloader.request.DownloadListener
                        public void onDownloadError(String str, int i, String str2) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1228376700")) {
                                ipChange.ipc$dispatch("-1228376700", new Object[]{this, str, Integer.valueOf(i), str2});
                            }
                        }

                        @Override // com.taobao.downloader.request.DownloadListener
                        public void onDownloadFinish(String str, String str2) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1271050268")) {
                                ipChange.ipc$dispatch("-1271050268", new Object[]{this, str, str2});
                            }
                        }

                        @Override // com.taobao.downloader.request.DownloadListener
                        public void onDownloadProgress(int i) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1923739213")) {
                                ipChange.ipc$dispatch("1923739213", new Object[]{this, Integer.valueOf(i)});
                            }
                        }

                        @Override // com.taobao.downloader.request.DownloadListener
                        public void onDownloadStateChange(String str, boolean z) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "465996900")) {
                                ipChange.ipc$dispatch("465996900", new Object[]{this, str, Boolean.valueOf(z)});
                            }
                        }

                        @Override // com.taobao.downloader.request.DownloadListener
                        public void onFinish(boolean z) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1780488540")) {
                                ipChange.ipc$dispatch("1780488540", new Object[]{this, Boolean.valueOf(z)});
                            }
                        }

                        @Override // com.taobao.downloader.request.DownloadListener
                        public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1132305080")) {
                                ipChange.ipc$dispatch("1132305080", new Object[]{this, Integer.valueOf(i), io1, networkLimitCallback});
                            }
                        }

                        @Override // com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadListener
                        public void onProcessFailure(String str, int i, String str2) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-931797997")) {
                                ipChange.ipc$dispatch("-931797997", new Object[]{this, str, Integer.valueOf(i), str2});
                            } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                                AnimationError animationError = new AnimationError();
                                animationError.errorCode = 1001;
                                animationError.errorMessage = "解析资源失败";
                                YKLAnimationViewAdapter.this.mCallback.onAnimationError(animationError);
                            }
                        }

                        @Override // com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadListener
                        public void onProcessSuccess(String str, int i, String str2) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "654132620")) {
                                ipChange.ipc$dispatch("654132620", new Object[]{this, str, Integer.valueOf(i), str2});
                            } else if (YKLAnimationViewAdapter.this.mAnimationView != null) {
                                YKLAnimationViewAdapter.this.mAnimationView.post(new Runnable() {
                                    /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass9.AnonymousClass1 */
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    public void run() {
                                        IpChange ipChange = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange, "-2134909784")) {
                                            ipChange.ipc$dispatch("-2134909784", new Object[]{this});
                                            return;
                                        }
                                        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "after download PLAY  ==");
                                        AnonymousClass9 r0 = AnonymousClass9.this;
                                        YKLAnimationViewAdapter.this.defaultPlayByUrl(str, str2, z, str3, map);
                                    }
                                });
                            }
                        }
                    }, true);
                }
                String str4 = resourcesPath.get(0);
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "path  ==" + str4);
                if (!TextUtils.isEmpty(str4)) {
                    AnimationView animationView = this.mAnimationView;
                    if (animationView != null) {
                        animationView.setLoopCount(i);
                        if ("1".equals(str3)) {
                            this.mAnimationView.play(animationFileType, str4, animationProperties);
                        } else if ("0".equals(str3)) {
                            this.mAnimationView.stepFramePlay(1, false, animationFileType, str4, animationProperties);
                        }
                        this.mCallback.onAnimationStart();
                        return;
                    }
                    return;
                }
                IAnimationCallback iAnimationCallback = this.mCallback;
                if (iAnimationCallback != null) {
                    iAnimationCallback.onAnimationError(new AnimationError());
                    return;
                }
                return;
            }
        }
        animationProperties = null;
        i = 1;
        String md52 = YKLMD5Utils.md5(str2);
        resourcesPath = YKLResourceManager.getInstance().getResourcesPath("youku", str2, z, md52, animationFileType.getFileName());
        ILog iLog2 = (ILog) Dsl.getService(ILog.class);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("animation pathes is null = ");
        sb2.append(resourcesPath != null);
        iLog2.d("liulei-anim", sb2.toString());
        if (resourcesPath != null) {
        }
        YKLResourceManager.getInstance().reloadResouce("youku", str2, z, animationFileType.getFileName(), md52, new YKLDownloadListener() {
            /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.downloader.request.DownloadListener
            public void onDownloadError(String str, int i, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1228376700")) {
                    ipChange.ipc$dispatch("-1228376700", new Object[]{this, str, Integer.valueOf(i), str2});
                }
            }

            @Override // com.taobao.downloader.request.DownloadListener
            public void onDownloadFinish(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1271050268")) {
                    ipChange.ipc$dispatch("-1271050268", new Object[]{this, str, str2});
                }
            }

            @Override // com.taobao.downloader.request.DownloadListener
            public void onDownloadProgress(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1923739213")) {
                    ipChange.ipc$dispatch("1923739213", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // com.taobao.downloader.request.DownloadListener
            public void onDownloadStateChange(String str, boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "465996900")) {
                    ipChange.ipc$dispatch("465996900", new Object[]{this, str, Boolean.valueOf(z)});
                }
            }

            @Override // com.taobao.downloader.request.DownloadListener
            public void onFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1780488540")) {
                    ipChange.ipc$dispatch("1780488540", new Object[]{this, Boolean.valueOf(z)});
                }
            }

            @Override // com.taobao.downloader.request.DownloadListener
            public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1132305080")) {
                    ipChange.ipc$dispatch("1132305080", new Object[]{this, Integer.valueOf(i), io1, networkLimitCallback});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadListener
            public void onProcessFailure(String str, int i, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-931797997")) {
                    ipChange.ipc$dispatch("-931797997", new Object[]{this, str, Integer.valueOf(i), str2});
                } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                    AnimationError animationError = new AnimationError();
                    animationError.errorCode = 1001;
                    animationError.errorMessage = "解析资源失败";
                    YKLAnimationViewAdapter.this.mCallback.onAnimationError(animationError);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadListener
            public void onProcessSuccess(String str, int i, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "654132620")) {
                    ipChange.ipc$dispatch("654132620", new Object[]{this, str, Integer.valueOf(i), str2});
                } else if (YKLAnimationViewAdapter.this.mAnimationView != null) {
                    YKLAnimationViewAdapter.this.mAnimationView.post(new Runnable() {
                        /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass9.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-2134909784")) {
                                ipChange.ipc$dispatch("-2134909784", new Object[]{this});
                                return;
                            }
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "after download PLAY  ==");
                            AnonymousClass9 r0 = AnonymousClass9.this;
                            YKLAnimationViewAdapter.this.defaultPlayByUrl(str, str2, z, str3, map);
                        }
                    });
                }
            }
        }, true);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-587445380")) {
            return this.mAnimationView;
        }
        return (View) ipChange.ipc$dispatch("-587445380", new Object[]{this});
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void play(YKLAnimationViewProtocol.GiftAnimationItem giftAnimationItem) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818291704")) {
            ipChange.ipc$dispatch("-818291704", new Object[]{this, giftAnimationItem});
            return;
        }
        int screenWidth = UIUtil.getScreenWidth(this.mContext);
        int screenHeight = UIUtil.getScreenHeight(this.mContext);
        if (screenWidth > screenHeight) {
            screenWidth = screenHeight;
        }
        int i2 = this.mWeexWidth;
        if (i2 <= 0 || (i = this.mWeexHeight) <= 0) {
            this.mViewHeight = -1;
            this.mViewWidth = -1;
        } else {
            this.mViewHeight = (i * screenWidth) / FeatureFactory.PRIORITY_ABOVE_NORMAL;
            this.mViewWidth = (i2 * screenWidth) / FeatureFactory.PRIORITY_ABOVE_NORMAL;
        }
        setViewLayoutParams();
        switch (AnonymousClass10.$SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[giftAnimationItem.type.ordinal()]) {
            case 1:
                try {
                    ILog iLog = (ILog) Dsl.getService(ILog.class);
                    StringBuilder sb = new StringBuilder();
                    sb.append("animation playback:");
                    String str = giftAnimationItem.data;
                    if (str == null) {
                        str = "null";
                    }
                    sb.append(str);
                    iLog.d("GRAFFITI", sb.toString());
                    JSONObject parseObject = JSON.parseObject(giftAnimationItem.data);
                    if (parseObject != null) {
                        String string = parseObject.getString("canvas");
                        String string2 = parseObject.getString("points");
                        JSONArray jSONArray = parseObject.getJSONArray("iconUrls");
                        HashMap hashMap = new HashMap();
                        for (int i3 = 0; i3 < jSONArray.size(); i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            String next = jSONObject.keySet().iterator().next();
                            hashMap.put(next, jSONObject.getString(next));
                        }
                        playGraffiti(string, string2, parseObject.containsKey(Constants.Name.INTERVAL) ? parseObject.getString(Constants.Name.INTERVAL) : MessageService.MSG_DB_COMPLETE, hashMap);
                        return;
                    }
                    IAnimationCallback iAnimationCallback = this.mCallback;
                    if (iAnimationCallback != null) {
                        iAnimationCallback.onAnimationError(new AnimationError());
                        return;
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.mCallback.onAnimationError(new AnimationError());
                    return;
                }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (TextUtils.isEmpty(giftAnimationItem.data)) {
                    playById(giftAnimationItem.type.getTypeString(), giftAnimationItem.id, giftAnimationItem.properties);
                    return;
                } else {
                    playByUrl(giftAnimationItem.type.getTypeString(), giftAnimationItem.data, giftAnimationItem.isZip, giftAnimationItem.properties);
                    return;
                }
            default:
                this.mCallback.onAnimationError(new AnimationError());
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b3  */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void playById(String str, String str2, Map map) {
        int i;
        List<String> resourcePath;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-954833342")) {
            ipChange.ipc$dispatch("-954833342", new Object[]{this, str, str2, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "playById fileType = " + str + "   id = " + str2);
        if (TextUtils.isEmpty(str2)) {
            AnimationError animationError = new AnimationError();
            animationError.errorMessage = "id is null";
            this.mCallback.onAnimationError(animationError);
            return;
        }
        AnimationFileType animationFileType = AnimationFileType.TYPE_SVGA;
        if (!TextUtils.isEmpty(str) && !str.equals(animationFileType.getFileName())) {
            AnimationFileType animationFileType2 = AnimationFileType.TYPE_LOTTIE;
            if (str.equals(animationFileType2.getFileName())) {
                animationFileType = animationFileType2;
            }
        }
        AnimationProperties animationProperties = null;
        if (map != null) {
            String valueOf = String.valueOf(map.get(IWXAudio.KEY_LOOP));
            if (!TextUtils.isEmpty(valueOf)) {
                animationProperties = new AnimationProperties();
                i = Integer.parseInt(valueOf);
                animationProperties.loopCount = i;
                resourcePath = YKLResourceManager.getInstance().getResourcePath(str2);
                ILog iLog = (ILog) Dsl.getService(ILog.class);
                StringBuilder sb = new StringBuilder();
                sb.append("animation pathes is null = ");
                if (resourcePath != null) {
                    z = false;
                }
                sb.append(z);
                iLog.d("liulei-anim", sb.toString());
                if (resourcePath != null || resourcePath.size() <= 0) {
                    YKLResourceManager.getInstance().getResourcePath(str2);
                    this.mCallback.onAnimationError(new AnimationError());
                }
                String str3 = resourcePath.get(0);
                if (TextUtils.isEmpty(str3)) {
                    this.mCallback.onAnimationError(new AnimationError());
                    return;
                } else if (this.mAnimationView == null) {
                    return;
                } else {
                    if ("webp".equals(animationFileType.getFileName())) {
                        this.mAnimationView.removeAllViews();
                        new TUrlImageView(this.mContext);
                        new FrameLayout.LayoutParams(-1, -1);
                        return;
                    }
                    this.mAnimationView.setLoopCount(i);
                    this.mAnimationView.play(animationFileType, str3, animationProperties);
                    return;
                }
            }
        }
        i = 1;
        resourcePath = YKLResourceManager.getInstance().getResourcePath(str2);
        ILog iLog2 = (ILog) Dsl.getService(ILog.class);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("animation pathes is null = ");
        if (resourcePath != null) {
        }
        sb2.append(z);
        iLog2.d("liulei-anim", sb2.toString());
        if (resourcePath != null) {
        }
        YKLResourceManager.getInstance().getResourcePath(str2);
        this.mCallback.onAnimationError(new AnimationError());
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0117  */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void playByUrl(String str, String str2, boolean z, Map map) {
        AnimationFileType animationFileType;
        AnimationProperties animationProperties;
        int i;
        List<String> resourcesPath;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-3371466")) {
            ipChange.ipc$dispatch("-3371466", new Object[]{this, str, str2, Boolean.valueOf(z), map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "playByUrl fileType = " + str + "    isZIp = " + z + " url = " + str2);
        if (TextUtils.isEmpty(str2)) {
            AnimationError animationError = new AnimationError();
            animationError.errorMessage = "url is null";
            this.mCallback.onAnimationError(animationError);
            return;
        }
        AnimationFileType animationFileType2 = AnimationFileType.TYPE_SVGA;
        if (!TextUtils.isEmpty(str) && !str.equals(animationFileType2.getFileName())) {
            AnimationFileType animationFileType3 = AnimationFileType.TYPE_LOTTIE;
            if (str.equals(animationFileType3.getFileName())) {
                animationFileType = animationFileType3;
                AnimationProperties animationProperties2 = null;
                this.mComboCount = "1";
                if (map == null) {
                    String valueOf = String.valueOf(map.get(IWXAudio.KEY_LOOP));
                    if (!TextUtils.isEmpty(valueOf)) {
                        animationProperties2 = new AnimationProperties();
                        i = Integer.parseInt(valueOf);
                        animationProperties2.loopCount = i;
                    } else {
                        i = 1;
                    }
                    if (map.containsKey("comboNum")) {
                        this.mComboCount = (String) map.get("comboNum");
                    }
                    animationProperties = animationProperties2;
                } else {
                    animationProperties = null;
                    i = 1;
                }
                String md5 = YKLMD5Utils.md5(str2);
                resourcesPath = YKLResourceManager.getInstance().getResourcesPath("youku", str2, z, md5, animationFileType.getFileName());
                ILog iLog = (ILog) Dsl.getService(ILog.class);
                StringBuilder sb = new StringBuilder();
                sb.append("animation pathes is null = ");
                sb.append(resourcesPath != null);
                iLog.d("liulei-anim", sb.toString());
                if (resourcesPath != null || resourcesPath.size() <= 0) {
                    YKLResourceManager.getInstance().reloadResouce("youku", str2, z, str, md5, null, ResourceOrangeUtils.isDownLoadIn4G());
                    this.mCallback.onAnimationError(new AnimationError());
                }
                String str3 = resourcesPath.get(0);
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation path = " + str3);
                if (TextUtils.isEmpty(str3)) {
                    this.mCallback.onAnimationError(new AnimationError());
                    return;
                } else if (this.mAnimationView == null) {
                    return;
                } else {
                    if (TYPE_MP4.equals(str) || "mp4gift".equals(str)) {
                        try {
                            playMp4Gift(str3);
                            return;
                        } catch (Throwable th) {
                            ((ILog) Dsl.getService(ILog.class)).e("liulei-anim-mp4", "MP4 ANIM ERROR");
                            th.printStackTrace();
                            this.mCallback.onAnimationError(new AnimationError());
                            return;
                        }
                    } else if ("webp".equals(str)) {
                        playWebPAnim(str3);
                        return;
                    } else {
                        this.mAnimationView.setLoopCount(i);
                        this.mAnimationView.play(animationFileType, str3, animationProperties);
                        return;
                    }
                }
            } else if (!"webp".equals(str) && !TYPE_MP4.equals(str)) {
                "mp4gift".equals(str);
            }
        }
        animationFileType = animationFileType2;
        AnimationProperties animationProperties22 = null;
        this.mComboCount = "1";
        if (map == null) {
        }
        String md52 = YKLMD5Utils.md5(str2);
        resourcesPath = YKLResourceManager.getInstance().getResourcesPath("youku", str2, z, md52, animationFileType.getFileName());
        ILog iLog2 = (ILog) Dsl.getService(ILog.class);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("animation pathes is null = ");
        sb2.append(resourcesPath != null);
        iLog2.d("liulei-anim", sb2.toString());
        if (resourcesPath != null) {
        }
        YKLResourceManager.getInstance().reloadResouce("youku", str2, z, str, md52, null, ResourceOrangeUtils.isDownLoadIn4G());
        this.mCallback.onAnimationError(new AnimationError());
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void playLottery(List<MineLotteryData> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164182511")) {
            ipChange.ipc$dispatch("-164182511", new Object[]{this, list});
            return;
        }
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            if (animationView.getChildCount() != 0) {
                this.mAnimationView.removeAllViews();
            }
            MineLotteryView mineLotteryView = new MineLotteryView(this.mContext);
            mineLotteryView.setOnAnimationStateListener(new MineLotteryView.OnAnimationStateListener() {
                /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass8 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.lottery.view.MineLotteryView.OnAnimationStateListener
                public void onEnd() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "726218917")) {
                        ipChange.ipc$dispatch("726218917", new Object[]{this});
                    } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                        YKLAnimationViewAdapter.this.mCallback.onAnimationEnd();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.lottery.view.MineLotteryView.OnAnimationStateListener
                public void onStart() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1755917566")) {
                        ipChange.ipc$dispatch("1755917566", new Object[]{this});
                    } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                        YKLAnimationViewAdapter.this.mCallback.onAnimationStart();
                    }
                }
            });
            mineLotteryView.setData(list);
            this.mAnimationView.addView(mineLotteryView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void setAnimationCallback(final IAnimationCallback iAnimationCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-560621671")) {
            ipChange.ipc$dispatch("-560621671", new Object[]{this, iAnimationCallback});
            return;
        }
        AnonymousClass7 r0 = new IAnimationCallback() {
            /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationCancel() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "430529571")) {
                    ipChange.ipc$dispatch("430529571", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onAnimationCancel ");
                IAnimationCallback iAnimationCallback = iAnimationCallback;
                if (iAnimationCallback != null) {
                    iAnimationCallback.onAnimationCancel();
                }
            }

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationEnd() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2037112750")) {
                    ipChange.ipc$dispatch("-2037112750", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onAnimationEnd ");
                if (!(YKLAnimationViewAdapter.this.mAnimationView == null || YKLAnimationViewAdapter.this.mAnimationView.getHandler() == null)) {
                    YKLAnimationViewAdapter.this.mAnimationView.postDelayed(new Runnable() {
                        /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass7.AnonymousClass2 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1705378569")) {
                                ipChange.ipc$dispatch("1705378569", new Object[]{this});
                                return;
                            }
                            YKLAnimationViewAdapter.this.mAnimationView.removeAllViews();
                        }
                    }, 150);
                }
                IAnimationCallback iAnimationCallback = iAnimationCallback;
                if (iAnimationCallback != null) {
                    iAnimationCallback.onAnimationEnd();
                }
            }

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationError(AnimationError animationError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1614431806")) {
                    ipChange.ipc$dispatch("1614431806", new Object[]{this, animationError});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onAnimationError ");
                IAnimationCallback iAnimationCallback = iAnimationCallback;
                if (iAnimationCallback != null) {
                    iAnimationCallback.onAnimationError(animationError);
                }
            }

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationStart() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "483974507")) {
                    ipChange.ipc$dispatch("483974507", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onAnimationStart ");
                IAnimationCallback iAnimationCallback = iAnimationCallback;
                if (iAnimationCallback != null) {
                    iAnimationCallback.onAnimationStart();
                }
                if (YKLAnimationViewAdapter.this.mAnimationView != null && YKLAnimationViewAdapter.this.mAnimationView.getHandler() != null) {
                    YKLAnimationViewAdapter.this.mAnimationView.post(new Runnable() {
                        /* class com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.AnonymousClass7.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1901892074")) {
                                ipChange.ipc$dispatch("1901892074", new Object[]{this});
                                return;
                            }
                            YKLAnimationViewAdapter yKLAnimationViewAdapter = YKLAnimationViewAdapter.this;
                            yKLAnimationViewAdapter.addNumView(yKLAnimationViewAdapter.mAnimationView, YKLAnimationViewAdapter.this.mComboCount);
                        }
                    });
                }
            }
        };
        this.mCallback = r0;
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            animationView.setAnimationCallback(r0);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void setSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1418732494")) {
            ipChange.ipc$dispatch("-1418732494", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i == -1 || i2 == -1) {
            this.mWeexWidth = -1;
            this.mWeexHeight = -1;
            this.mViewWidth = -1;
            this.mViewHeight = -1;
        } else {
            this.mWeexWidth = i;
            this.mWeexHeight = i2;
            ((ILog) Dsl.getService(ILog.class)).i("liulei-anim", "REAL size = " + this.mViewWidth + "    " + this.mViewHeight);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void stepToFrame(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485658656")) {
            ipChange.ipc$dispatch("1485658656", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            animationView.stepToFrame(i, z);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void stepToPercentge(double d, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188591601")) {
            ipChange.ipc$dispatch("-1188591601", new Object[]{this, Double.valueOf(d), Boolean.valueOf(z)});
            return;
        }
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            animationView.stepToPercentage(d, z);
        }
    }
}
