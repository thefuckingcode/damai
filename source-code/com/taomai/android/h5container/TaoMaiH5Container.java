package com.taomai.android.h5container;

import android.app.Application;
import android.content.Context;
import android.taobao.windvane.WindVaneSDK;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.extra.config.TBConfigManager;
import android.taobao.windvane.extra.jsbridge.TBJsApiManager;
import android.taobao.windvane.extra.jsbridge.TBUploadService;
import android.taobao.windvane.file.WVFileUtils;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.jsbridge.api.WVCamera;
import android.taobao.windvane.monitor.WVMonitor;
import android.taobao.windvane.packageapp.WVPackageAppConfig;
import android.taobao.windvane.packageapp.WVPackageAppManager;
import android.taobao.windvane.packageapp.WVPackageAppService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.log.AndroidLog;
import android.taobao.windvane.webview.IWVWebView;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.taomai.android.h5container.api.TMActionPlugin;
import com.taomai.android.h5container.api.TMCamera;
import com.taomai.android.h5container.utils.ActivityStackManager;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.pk;
import tb.pq2;
import tb.vf1;
import tb.xi2;
import tb.yi2;
import tb.yl;

/* compiled from: Taobao */
public final class TaoMaiH5Container {
    @NotNull
    public static final TaoMaiH5Container INSTANCE = new TaoMaiH5Container();
    @Nullable
    private static NavHandler a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lcom/taomai/android/h5container/TaoMaiH5Container$NavHandler;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "url", "", "fromOverrideUrlLoading", "Ltb/ur2;", "handleUrl", "Landroid/taobao/windvane/webview/IWVWebView;", "webView", "shouldOverrideUrlLoading", "h5container_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface NavHandler {
        void handleUrl(@NotNull Context context, @NotNull String str, boolean z);

        boolean shouldOverrideUrlLoading(@NotNull Context context, @NotNull String str, @NotNull IWVWebView iWVWebView);
    }

    private TaoMaiH5Container() {
    }

    @JvmStatic
    private static final void a() {
        WVConfigManager.getInstance().setUpdateConfigEnable(true);
        WVServerConfig.DOMAIN_PATTERN = "^https?:\\/\\/(([^/\\?#]+\\.)*((taobao|taopiaopiao|damai|piao|youku|alimebot|ycceleb|tmall|juhuasuan|xiami|amap|taobaocdn|alipay|etao|alibaba|aliyun|alimama|weibo|tanx|laiwang|alicdn|mmstat|yunos|alibaba-inc|alitrip|aliloan|kanbox|wirlesshare|dingtalk|alimei|cnzz|kuaidadi|autonavi|m\\.yintai|polyinno|spdyidea|h5util|h5tool|5945i|miaostreet|1688|yuekeyun)\\.com|(taopiaopiao|damai|piao|tb|tbcdn|weibo|mashort|mybank|ba\\.ugame\\.uc|game\\.uc)\\.cn|(fastidea|juzone)\\.(me|cc)|lwurl\\.to|taobao\\.net|tdd\\.la|yao\\.95095\\.com|tmall\\.hk|ahd\\.so|atb\\.so|mshare\\.cc|juhs\\.me|h5.guobei.com.cn|xianyu\\.mobi)([\\?|#|/].*)?|go(/.*)?)$";
    }

    @Nullable
    public static final NavHandler b() {
        return a;
    }

    @JvmStatic
    public static final void c(@NotNull Context context, @NotNull yi2 yi2) {
        Application application;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(yi2, "params");
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            Context applicationContext = context.getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            application = (Application) applicationContext;
        }
        xi2.a = application;
        xi2.d(yi2.b());
        xi2.INSTANCE.e(yi2.c());
        yi2.reducePermission = true;
        WindVaneSDK.init(context, yi2);
        a();
        d(context);
        if (!yi2.a()) {
            TaoLog.setImpl(new AndroidLog());
            TaoLog.setLogSwitcher(true);
        }
        f();
        Context applicationContext2 = context.getApplicationContext();
        if (!(applicationContext2 instanceof Application)) {
            applicationContext2 = null;
        }
        Application application2 = (Application) applicationContext2;
        if (application2 != null) {
            application2.registerActivityLifecycleCallbacks(ActivityStackManager.Companion.a());
        }
        yl.Companion.a();
    }

    @JvmStatic
    private static final void d(Context context) {
        WVAPI.setup();
        WVMonitor.init();
        WVCamera.registerUploadService(TBUploadService.class);
        TMCamera.registerUploadService(TBUploadService.class);
        GlobalConfig.zType = "3";
        WVPackageAppService.registerWvPackageAppConfig(new WVPackageAppConfig());
        WVPackageAppManager.getInstance().init(context, true);
        TBJsApiManager.initJsApi();
        TBConfigManager.getInstance().init(context);
        MotuCrashReporter.getInstance().setCrashCaughtListener(new pq2());
        vf1.a();
    }

    @JvmStatic
    public static final void e(@NotNull String str, @NotNull TMActionPlugin.IWVAPIPlugin iWVAPIPlugin) {
        k21.i(str, "actionName");
        k21.i(iWVAPIPlugin, "impl");
        TMActionPlugin.Companion.a().put(str, iWVAPIPlugin);
    }

    @JvmStatic
    private static final void f() {
        pk.a();
    }

    @JvmStatic
    public static final void g(@NotNull String str) {
        k21.i(str, "authority");
        WVFileUtils.setAuthority(str);
    }

    public static final void h(@Nullable NavHandler navHandler) {
        a = navHandler;
    }
}
