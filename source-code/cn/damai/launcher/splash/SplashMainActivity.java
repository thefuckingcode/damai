package cn.damai.launcher.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import cn.damai.common.AppConfig;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.blur.ImageBlurHelper;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.common.util.PriorityTask;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.launcher.LauncherApplication;
import cn.damai.launcher.splash.api.GetTimeStampRequest;
import cn.damai.launcher.splash.api.GetTimeStampResponse;
import cn.damai.launcher.splash.api.GuideResponse;
import cn.damai.launcher.splash.api.ItemInfo;
import cn.damai.launcher.splash.api.SplashApi;
import cn.damai.launcher.splash.api.SplashResponse;
import cn.damai.launcher.splash.model.AdBitmapResTool;
import cn.damai.launcher.splash.model.AdLoader;
import cn.damai.launcher.splash.model.bean.AdBitmapRes;
import cn.damai.launcher.splash.model.listener.OnAdSetUpUiListener;
import cn.damai.launcher.ut.LauncherUTHelper;
import cn.damai.launcher.utils.InitUtils;
import cn.damai.launcher.utils.PrivacyUtils;
import cn.damai.launcher.utils.SplashSchemaUtil;
import cn.damai.launcher.utils.SplashXFlushHelper;
import cn.damai.wantsee.StartConfig;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.android.alibaba.ip.server.InstantPatcher;
import com.ut.mini.module.appstatus.UTAppStatusMonitor;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.bx0;
import tb.d20;
import tb.f20;
import tb.g91;
import tb.gr;
import tb.i3;
import tb.m6;
import tb.n42;
import tb.nc;
import tb.ne2;
import tb.ns1;
import tb.rs1;
import tb.s41;
import tb.wk;
import tb.xf2;
import tb.xs0;
import tb.yz2;

/* compiled from: Taobao */
public class SplashMainActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOMEPAGE_OUTER_URL = "HOMEPAGE_OUTER_URL";
    public static final int RECHECK_GUIDEDATA_WHAT = 101;
    private static final String TAG = "Splash";
    DelayHandler delayHandler;
    @SuppressLint({"HandlerLeak"})
    Handler handler = new Handler();
    private boolean isAdWidthResized = false;
    private boolean isDraw = false;
    private long mAdsDisplayStartTs;
    private TextView mAdsLabel;
    private View mClickZone;
    private TextView mClickZoneLabel;
    private AtomicBoolean mHasDone = new AtomicBoolean(false);
    private ViewStub mSplashAdStub;
    private ImageView mSplashImage;
    private View mSplashLayout;
    private SplashResponse mSplashResp;
    private SplashRoundProgressBar mSplashRoundProgressBar;

    /* compiled from: Taobao */
    public static class DelayHandler extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        SplashMainActivity a;
        int b = 0;

        DelayHandler(SplashMainActivity splashMainActivity) {
            this.a = splashMainActivity;
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1292657279")) {
                ipChange.ipc$dispatch("-1292657279", new Object[]{this, message});
                return;
            }
            LauncherApplication launcherApplication = (LauncherApplication) xs0.a();
            g91.c("qiguaia", this.b + " : afterQueryFinish HAS DONE, DelayHandler !" + launcherApplication.getRequestFinished().get() + " , : " + this.a.validateData());
            if (!launcherApplication.getRequestFinished().get() || !this.a.validateData()) {
                int i = this.b;
                if (i < 2) {
                    this.b = i + 1;
                    removeMessages(101);
                    sendEmptyMessageDelayed(101, 100);
                    String str = this.b == 1 ? "-1011" : SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE2;
                    SplashXFlushHelper.c("无广告,重试:" + this.b, d20.c(), str);
                    return;
                }
                removeMessages(101);
                this.a.gotoNextPage(true);
                SplashXFlushHelper.c("无广告,超时", d20.c(), SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE3);
                return;
            }
            this.a.checkShowGuide();
            this.a.closeMe();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void ShowPrivacyDialogStageTwo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520441769")) {
            ipChange.ipc$dispatch("1520441769", new Object[]{this});
            return;
        }
        new DMDialog(this).o(false).v("您需要同意相关协议才能继续使用大麦").x(2).q("若您不同意，很遗憾我们将无法为您提供服务。").t(3).n("查看协议", new DialogInterface.OnClickListener() {
            /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1789181555")) {
                    ipChange.ipc$dispatch("-1789181555", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                SplashMainActivity.this.showPrivacyDialogStageOne();
            }
        }).i("退出应用", new DialogInterface.OnClickListener(this) {
            /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1536204718")) {
                    ipChange.ipc$dispatch("1536204718", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                i3.b().clearStack();
                System.exit(0);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void afterSplashDisplayFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295007730")) {
            ipChange.ipc$dispatch("-295007730", new Object[]{this});
            return;
        }
        g91.b(TAG, "afterSplashDisplayFinish/in hasDone?" + this.mHasDone.get());
        if (!this.mHasDone.get()) {
            String str = null;
            this.mSplashImage.setOnClickListener(null);
            this.mSplashRoundProgressBar.setOnClickListener(null);
            gotoNextPage(true);
            long currentTimeMillis = System.currentTimeMillis() - this.mAdsDisplayStartTs;
            SplashResponse splashResponse = this.mSplashResp;
            String pic = splashResponse != null ? splashResponse.getPic() : null;
            SplashResponse splashResponse2 = this.mSplashResp;
            if (splashResponse2 != null) {
                str = splashResponse2.getSchema();
            }
            LauncherUTHelper.getInstance().i(currentTimeMillis, pic, str);
            setAPMAdTime(currentTimeMillis);
        }
    }

    private void afterSplashImageReady(Drawable drawable, final SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        int i = 3;
        if (AndroidInstantRuntime.support(ipChange, "1483230733")) {
            ipChange.ipc$dispatch("1483230733", new Object[]{this, drawable, splashResponse});
            return;
        }
        g91.b(TAG, "afterSplashImageReady d:" + drawable);
        if (this.mHasDone.get()) {
            g91.b(TAG, "afterSplashImageReady HAS DONE, GOTO NEXT PAGE!");
            gotoNextPage(true);
        } else if (drawable == null) {
            g91.b(TAG, "afterSplashImageReady d is NULL!");
            gotoNextPage(true);
        } else {
            ensureInflateViewStub();
            this.mSplashLayout.setVisibility(0);
            this.mSplashImage.setImageDrawable(drawable);
            fillAdBlurBgWhenFoldMode(drawable, this.mSplashLayout);
            if (splashResponse == null || splashResponse.getShowLabelInt() != 0) {
                this.mAdsLabel.setVisibility(0);
            } else {
                this.mAdsLabel.setVisibility(8);
            }
            this.mAdsDisplayStartTs = System.currentTimeMillis();
            if (splashResponse == null || xf2.j(splashResponse.getSchema())) {
                this.mClickZone.setVisibility(8);
                findViewById(R$id.iv_splash_ad_logo_layout).setVisibility(8);
                findViewById(R$id.iv_splash_arc).setVisibility(8);
            } else {
                if (!xf2.j(splashResponse.getClickJumpDescription())) {
                    this.mClickZoneLabel.setText(splashResponse.getClickJumpDescription());
                }
                this.mClickZone.setOnClickListener(new View.OnClickListener() {
                    /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass9 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1393653414")) {
                            ipChange.ipc$dispatch("1393653414", new Object[]{this, view});
                            return;
                        }
                        SplashResponse splashResponse = splashResponse;
                        if (splashResponse != null && !xf2.j(splashResponse.getSchema())) {
                            SplashMainActivity.this.mHasDone.compareAndSet(false, true);
                            try {
                                SplashMainActivity.this.gotoNextPage(false);
                                Bundle bundle = new Bundle();
                                bundle.putBoolean(MonitorType.SKIP, true);
                                bundle.putString("from_page", "welcome");
                                DMNav.from(SplashMainActivity.this.mContext).withExtras(bundle).toUri(splashResponse.getSchema());
                            } catch (Exception e) {
                                g91.b(SplashMainActivity.TAG, "afterSplashImageReady.onClick EXCEPTION:" + e.getMessage());
                                e.printStackTrace();
                                SplashXFlushHelper.a(e.getMessage(), d20.c(), splashResponse.getSchema());
                            }
                            long currentTimeMillis = System.currentTimeMillis() - SplashMainActivity.this.mAdsDisplayStartTs;
                            LauncherUTHelper.getInstance().i(currentTimeMillis, splashResponse.getPic(), splashResponse.getSchema());
                            c.e().x(LauncherUTHelper.getInstance().h(splashResponse, d20.d(), splashResponse.getPic()));
                            SplashMainActivity.this.setAPMAdTime(currentTimeMillis);
                        }
                    }
                });
                this.mClickZone.setVisibility(0);
                if (SplashSchemaUtil.a(splashResponse.getSchema())) {
                    this.mClickZone.setVisibility(8);
                    findViewById(R$id.iv_splash_ad_logo_layout).setVisibility(8);
                    findViewById(R$id.iv_splash_arc).setVisibility(8);
                }
            }
            if (splashResponse == null || splashResponse.getSkippableInt() != 0) {
                this.mSplashRoundProgressBar.setOnClickListener(new View.OnClickListener() {
                    /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass10 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1923340678")) {
                            ipChange.ipc$dispatch("1923340678", new Object[]{this, view});
                            return;
                        }
                        SplashMainActivity.this.mHasDone.compareAndSet(false, true);
                        SplashMainActivity.this.gotoNextPage(true);
                        long currentTimeMillis = System.currentTimeMillis() - SplashMainActivity.this.mAdsDisplayStartTs;
                        SplashResponse splashResponse = splashResponse;
                        String str = null;
                        String pic = splashResponse != null ? splashResponse.getPic() : null;
                        SplashResponse splashResponse2 = splashResponse;
                        if (splashResponse2 != null) {
                            str = splashResponse2.getSchema();
                        }
                        LauncherUTHelper.getInstance().i(currentTimeMillis, pic, str);
                        SplashMainActivity.this.setAPMAdTime(currentTimeMillis);
                    }
                });
            } else {
                this.mSplashRoundProgressBar.setVisibility(8);
            }
            if (splashResponse != null) {
                i = splashResponse.getDisplayDurationInt();
            }
            doSplashCountDown(i);
            LauncherUTHelper.f(this.mClickZone, splashResponse);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkGuideThenGoNext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589824564")) {
            ipChange.ipc$dispatch("1589824564", new Object[]{this});
            return;
        }
        g91.c("qiguaia", "afterQueryFinish HAS DONE, checkGuideThenGoNext!");
        if (validateData()) {
            checkShowGuide();
            closeMe();
            g91.c("qiguaia", "afterQueryFinish HAS DONE, validateData!");
            SplashXFlushHelper.c("无广告时请求完毕", d20.c(), SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE0);
            return;
        }
        DelayHandler delayHandler2 = new DelayHandler(this);
        this.delayHandler = delayHandler2;
        delayHandler2.removeMessages(101);
        this.delayHandler.sendEmptyMessageDelayed(101, 100);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkShowGuide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722011863")) {
            ipChange.ipc$dispatch("-722011863", new Object[]{this});
        } else if (!isFinishing()) {
            c.e().x(wk.j().t("首页", 0));
            Intent intent = new Intent();
            intent.setClass(this, GuideActivity.class);
            intent.putExtra(HOMEPAGE_OUTER_URL, getIntent().getStringExtra(HOMEPAGE_OUTER_URL));
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void closeMe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-556864710")) {
            ipChange.ipc$dispatch("-556864710", new Object[]{this});
            return;
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.postDelayed(new Runnable() {
                /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass15 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1342971525")) {
                        ipChange.ipc$dispatch("1342971525", new Object[]{this});
                        return;
                    }
                    SplashMainActivity.this.finish();
                }
            }, 100);
        } else {
            finish();
        }
    }

    private void doSplashCountDown(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139033672")) {
            ipChange.ipc$dispatch("-139033672", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mSplashLayout.getVisibility() == 0) {
            final long j = (long) (i * 1000);
            this.mSplashRoundProgressBar.setMax(100);
            new CountDownTimer(50, j) {
                /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass13 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onFinish() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1776136646")) {
                        ipChange.ipc$dispatch("1776136646", new Object[]{this});
                        return;
                    }
                    SplashMainActivity.this.afterSplashDisplayFinish();
                }

                public void onTick(long j) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1351406392")) {
                        ipChange.ipc$dispatch("-1351406392", new Object[]{this, Long.valueOf(j)});
                        return;
                    }
                    SplashMainActivity.this.mSplashRoundProgressBar.setProgress((int) ((((float) j) / ((float) j)) * 100.0f));
                }
            }.start();
        }
    }

    private void ensureInflateViewStub() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450616494")) {
            ipChange.ipc$dispatch("450616494", new Object[]{this});
            return;
        }
        ViewStub viewStub = this.mSplashAdStub;
        if (viewStub != null && this.mSplashLayout == null) {
            View inflate = viewStub.inflate();
            this.mSplashLayout = inflate.findViewById(R$id.splash_layout);
            this.mSplashImage = (ImageView) inflate.findViewById(R$id.splash_image);
            this.mSplashRoundProgressBar = (SplashRoundProgressBar) inflate.findViewById(R$id.homepage_advert_pb);
            this.mAdsLabel = (TextView) inflate.findViewById(R$id.tv_splash_ads_label);
            this.mClickZone = inflate.findViewById(R$id.splash_ads_click_zone);
            this.mClickZoneLabel = (TextView) inflate.findViewById(R$id.tv_splash_ads_click);
            resizeAdWidthWhenFoldMode(this.mSplashImage);
            this.mSplashImage.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
                /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass11 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onDraw() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1208509581")) {
                        ipChange.ipc$dispatch("-1208509581", new Object[]{this});
                    } else if (SplashMainActivity.this.mSplashImage != null && SplashMainActivity.this.mSplashImage.getTag() == null && SplashMainActivity.this.mSplashImage.getDrawable() != null) {
                        SplashMainActivity.this.mSplashImage.setTag(Boolean.TRUE);
                        nc.a("App onCreate -> Splash AD ImageView draw with drawable", 100);
                    }
                }
            });
            setAdMarginTop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r5 = ((android.graphics.drawable.BitmapDrawable) r8).getBitmap();
     */
    private void fillAdBlurBgWhenFoldMode(Drawable drawable, final View view) {
        final Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854845438")) {
            ipChange.ipc$dispatch("1854845438", new Object[]{this, drawable, view});
        } else if (this.isAdWidthResized && (drawable instanceof BitmapDrawable) && bitmap != null && !bitmap.isRecycled()) {
            nc.e(SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR);
            ns1.a(new PriorityTask("workerThread2", xs0.a(), 1) {
                /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass12 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.util.PriorityTask
                public void doTask() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-507212313")) {
                        ipChange.ipc$dispatch("-507212313", new Object[]{this});
                        return;
                    }
                    try {
                        final Bitmap g = ImageBlurHelper.g(xs0.a(), null, bitmap, 16, 20);
                        if (g != null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass12.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-935501637")) {
                                        ipChange.ipc$dispatch("-935501637", new Object[]{this});
                                        return;
                                    }
                                    view.setBackground(new BitmapDrawable(SplashMainActivity.this.getResources(), g));
                                    nc.a("广告高斯背景生成", SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR);
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gotoNextPage(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-589940263")) {
            ipChange.ipc$dispatch("-589940263", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        startNextActivity(z);
    }

    private void hideSystemBars() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251074639")) {
            ipChange.ipc$dispatch("251074639", new Object[]{this});
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
    }

    private void initEvn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1381655837")) {
            ipChange.ipc$dispatch("1381655837", new Object[]{this});
            return;
        }
        ns1.a(new PriorityTask("ApnInit", this) {
            /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass14 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.util.PriorityTask
            public void doTask() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1094018327")) {
                    ipChange.ipc$dispatch("-1094018327", new Object[]{this});
                    return;
                }
                m6.g();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initSetting() {
        BitmapDrawable bitmapDrawable;
        SplashResponse splashResponse;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007275338")) {
            ipChange.ipc$dispatch("1007275338", new Object[]{this});
            return;
        }
        initEvn();
        try {
            if (!rs1.d()) {
                InitUtils.d();
            }
            UpdateUtil.h(this);
            InstantPatcher.create(xs0.a()).applyPatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (HomeGrabTicketHideAdUtil.isHideAd()) {
            g91.c(TAG, "Ticket Grab，cancel splash request!!!");
            gotoNextPage(false);
        } else {
            AdBitmapRes cacheGet = AdBitmapResTool.cacheGet();
            if (cacheGet == null || (bitmapDrawable = cacheGet.mAdBitmapDrawable) == null || (splashResponse = cacheGet.mAdSplashRes) == null) {
                g91.c(nc.TAG, "Splash Ad No Use Provider preprocess bitmap");
                startSplashQuery();
            } else {
                showAdLayoutNow(bitmapDrawable, splashResponse);
                g91.c(nc.TAG, "Splash Ad Use Provider preprocess bitmap");
                new Handler().postDelayed(new Runnable() {
                    /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass6 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-623559571")) {
                            ipChange.ipc$dispatch("-623559571", new Object[]{this});
                            return;
                        }
                        new AdLoader(SplashMainActivity.this, null).autoFetch(false);
                    }
                }, 200);
            }
        }
        startTimeStampQuery();
        if (StartConfig.isUseNewHomePreload()) {
            preloadHome();
        }
    }

    private void preloadHome() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "951711970")) {
            ipChange.ipc$dispatch("951711970", new Object[]{this});
            return;
        }
        try {
            bx0.class.getMethod("preload", Activity.class).invoke(null, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resizeAdWidthWhenFoldMode(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412109385")) {
            ipChange.ipc$dispatch("-412109385", new Object[]{this, imageView});
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            DisplayMetrics c = n42.c(this);
            int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(c);
            int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(c);
            float f = (float) i2;
            float f2 = ((float) i) / f;
            if (f2 > 0.78749996f) {
                layoutParams.width = (int) (f * 0.5625f);
                layoutParams.height = -1;
                this.isAdWidthResized = true;
            } else {
                layoutParams.height = -1;
                layoutParams.width = -1;
                this.isAdWidthResized = false;
            }
            if (AppConfig.v()) {
                String str = this.isAdWidthResized ? "whRatio>limitWhRatio 广告发生适配+高斯生成" : "whRatio<=limitWhRatio保持广告全屏";
                g91.c("ScreenMode", "screen w=" + i + " h=" + i2 + " whRatio=" + f2 + " limitWhRatio=" + 0.78749996f + " betterWhRatio=" + 0.5625f + " " + str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setAPMAdTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1134100816")) {
            ipChange.ipc$dispatch("-1134100816", new Object[]{this, Long.valueOf(j)});
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("splash_ad", "闪屏停留时间");
        hashMap.put("闪屏停留时间", String.valueOf(j));
        f20.a().c("splash_ad", hashMap);
    }

    private void setAdMarginTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008958722")) {
            ipChange.ipc$dispatch("-2008958722", new Object[]{this});
            return;
        }
        int a = ne2.a(this);
        if (a > 0) {
            ViewGroup.LayoutParams layoutParams = this.mAdsLabel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a;
            }
            ViewGroup.LayoutParams layoutParams2 = this.mSplashRoundProgressBar.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = a;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showAdLayoutNow(Drawable drawable, @NonNull SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24483282")) {
            ipChange.ipc$dispatch("-24483282", new Object[]{this, drawable, splashResponse});
            return;
        }
        this.mSplashResp = splashResponse;
        try {
            afterSplashImageReady(drawable, splashResponse);
            yz2.e(yz2.a, SplashXFlushHelper.BUSINESS_NAME_MONITORPOINT, "homepage" + ":jsondata={apiName: " + SplashXFlushHelper.SPLASH_ADS_DOWNLOAD_API_NAME + ", pic:" + splashResponse.getPic() + ", cityId:" + d20.c() + "}");
        } catch (Exception e) {
            e.printStackTrace();
            SplashXFlushHelper.e(SplashApi.API_SPLASH_ADVERT, "", e.getMessage(), s41.e(splashResponse), d20.c());
            gotoNextPage(true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPrivacyDialogStageOne() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807051567")) {
            ipChange.ipc$dispatch("1807051567", new Object[]{this});
            return;
        }
        new DMDialog(this).o(false).v("温馨提示").u(PrivacyUtils.b(this)).n("同意", new DialogInterface.OnClickListener() {
            /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "566623695")) {
                    ipChange.ipc$dispatch("566623695", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                SplashMainActivity.this.initSetting();
                UTAppStatusMonitor.getInstance().onActivityStarted(null);
                rs1.l(true);
                rs1.a();
            }
        }).i("不同意", new DialogInterface.OnClickListener() {
            /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-402957328")) {
                    ipChange.ipc$dispatch("-402957328", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                SplashMainActivity.this.ShowPrivacyDialogStageTwo();
            }
        }).show();
    }

    private void startNextActivity(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "781280782")) {
            ipChange.ipc$dispatch("781280782", new Object[]{this, Boolean.valueOf(z)});
        } else if (!z || !validateData()) {
            c.e().x(wk.j().t("首页", 0));
            Bundle bundle = new Bundle();
            bundle.putString(HOMEPAGE_OUTER_URL, getIntent().getStringExtra(HOMEPAGE_OUTER_URL));
            DMNav.from(this).withExtras(bundle).setTransition(0, 0).toUri(NavUri.b(gr.n));
            if (z) {
                SplashXFlushHelper.c("有广告,下载/解析/请求超时", d20.c(), SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE4);
            }
            closeMe();
        } else {
            checkShowGuide();
        }
    }

    private void startSplashQuery() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931165281")) {
            ipChange.ipc$dispatch("1931165281", new Object[]{this});
            return;
        }
        nc.e(205);
        new AdLoader(this, new OnAdSetUpUiListener() {
            /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.launcher.splash.model.listener.OnAdSetUpUiListener
            public void dispatchNoneAdAction(int i, String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "894467406")) {
                    ipChange.ipc$dispatch("894467406", new Object[]{this, Integer.valueOf(i), str, str2});
                    return;
                }
                SplashMainActivity.this.checkGuideThenGoNext();
            }

            @Override // cn.damai.launcher.splash.model.listener.OnAdSetUpUiListener
            public void dispatchShowAdAction(boolean z, Drawable drawable, @NonNull SplashResponse splashResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1873219164")) {
                    ipChange.ipc$dispatch("1873219164", new Object[]{this, Boolean.valueOf(z), drawable, splashResponse});
                    return;
                }
                nc.a("Splash get Ad drawable isUseCache=" + z, 205);
                SplashMainActivity.this.showAdLayoutNow(drawable, splashResponse);
            }
        }).start();
    }

    private void startTimeStampQuery() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506466186")) {
            ipChange.ipc$dispatch("-506466186", new Object[]{this});
            return;
        }
        GetTimeStampRequest getTimeStampRequest = new GetTimeStampRequest();
        final long currentTimeMillis = System.currentTimeMillis();
        getTimeStampRequest.request(new DMMtopRequestListener<GetTimeStampResponse>(GetTimeStampResponse.class) {
            /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1476249846")) {
                    ipChange.ipc$dispatch("-1476249846", new Object[]{this, str, str2});
                    return;
                }
                g91.c("requestServerTimeStamp", "requestServerTimeStamp failed" + str2);
            }

            public void onSuccess(GetTimeStampResponse getTimeStampResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "136293156")) {
                    ipChange.ipc$dispatch("136293156", new Object[]{this, getTimeStampResponse});
                    return;
                }
                long currentTimeMillis = (System.currentTimeMillis() - currentTimeMillis) >> 1;
                if (getTimeStampResponse != null) {
                    try {
                        if (!TextUtils.isEmpty(getTimeStampResponse.t)) {
                            d20.T("serverTimeDiff", String.valueOf((Long.parseLong(getTimeStampResponse.t) + currentTimeMillis) - System.currentTimeMillis()));
                        }
                    } catch (Exception unused) {
                        g91.c("requestServerTimeStamp", "requestServerTimeStamp format failed");
                    }
                }
            }
        });
    }

    private void useSpecialScreen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494289058")) {
            ipChange.ipc$dispatch("1494289058", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean validateData() {
        List<ItemInfo> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355202884")) {
            return ((Boolean) ipChange.ipc$dispatch("355202884", new Object[]{this})).booleanValue();
        }
        GuideResponse guideData = ((LauncherApplication) getApplication()).getGuideData();
        if (guideData == null || !guideData.newUser || (list = guideData.categoryList) == null || list.size() <= 0) {
            g91.c("requestGuideData", "requestGuideData: validateData false ");
            return false;
        }
        g91.c("requestGuideData", "requestGuideData: validateData true ");
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public void addContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1244938781")) {
            ipChange.ipc$dispatch("-1244938781", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "943261128")) {
            ipChange.ipc$dispatch("943261128", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610213357")) {
            ipChange.ipc$dispatch("1610213357", new Object[]{this});
            return;
        }
        super.finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1446047522")) {
            return R$layout.splash_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("1446047522", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15801497")) {
            ipChange.ipc$dispatch("15801497", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860707506")) {
            ipChange.ipc$dispatch("1860707506", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1706179243")) {
            ipChange.ipc$dispatch("1706179243", new Object[]{this});
            return;
        }
        ((ViewGroup) findViewById(R$id.splash_layout_container)).getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
            /* class cn.damai.launcher.splash.SplashMainActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onDraw() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1805897226")) {
                    ipChange.ipc$dispatch("1805897226", new Object[]{this});
                } else if (!SplashMainActivity.this.isDraw) {
                    SplashMainActivity.this.isDraw = true;
                    nc.a("Splash onCreate -> firstDraw", 201);
                    nc.a("App onCreate -> Splash first draw", 100);
                }
            }
        });
        this.mSplashAdStub = (ViewStub) findViewById(R$id.id_splash_ad_view_stub);
        ((ImageView) findViewById(R$id.id_splash_holder_view)).setImageDrawable(new ShapeDrawable());
        if (rs1.d()) {
            initSetting();
        } else {
            showPrivacyDialogStageOne();
        }
        hideSystemBars();
        useSpecialScreen();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426403794")) {
            ipChange.ipc$dispatch("426403794", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434899025")) {
            ipChange.ipc$dispatch("-434899025", new Object[]{this, bundle});
            return;
        }
        nc.e(201);
        super.onCreate(bundle);
        if (rs1.d()) {
            setDamaiUTKeyBuilder(LauncherUTHelper.getInstance().g("welcome"));
            c.e().K(this);
        }
        nc.a("Splash onCreate finish", 201);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603744081")) {
            ipChange.ipc$dispatch("-1603744081", new Object[]{this});
            return;
        }
        super.onDestroy();
        DelayHandler delayHandler2 = this.delayHandler;
        if (delayHandler2 != null) {
            delayHandler2.removeMessages(101);
        }
        this.delayHandler = null;
        AdBitmapResTool.cache(null);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1258352072")) {
            ipChange.ipc$dispatch("1258352072", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368428877")) {
            ipChange.ipc$dispatch("368428877", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917961164")) {
            ipChange.ipc$dispatch("-1917961164", new Object[]{this});
            return;
        }
        super.onResume();
        nc.a("App onCreate -> Splash onResume", 100);
    }

    @Override // androidx.activity.ComponentActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068897183")) {
            ipChange.ipc$dispatch("1068897183", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setContentView(R$layout.splash_activity);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1170689514")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1170689514", new Object[]{this});
    }
}
