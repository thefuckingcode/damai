package com.tencent.smtt.sdk;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.a.b;
import com.tencent.smtt.sdk.a.c;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.d;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.o;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class WebView extends FrameLayout implements View.OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    private static final Lock c = new ReentrantLock();
    private static OutputStream d = null;
    private static Context j = null;
    private static o l = null;
    private static Method m = null;
    public static boolean mSysWebviewCreated = false;
    public static boolean mWebViewCreated = false;
    private static String p = null;
    private static Paint v = null;
    private static boolean w = true;
    int a;
    private final String b;
    private boolean e;
    private IX5WebViewBase f;
    private a g;
    private WebSettings h;
    private Context i;
    private boolean k;
    public WebViewCallbackClient mWebViewCallbackClient;
    private WebViewClient n;
    private WebChromeClient o;
    private final int q;
    private final int r;
    private final int s;
    private final String t;
    private final String u;
    private Object x;
    private View.OnLongClickListener y;

    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    public static int getTbsSDKVersion(Context context) {
        return 43903;
    }

    /* access modifiers changed from: package-private */
    public void a(android.webkit.WebView webView) {
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public class WebViewTransport {
        private WebView b;

        public WebViewTransport() {
        }

        public synchronized void setWebView(WebView webView) {
            this.b = webView;
        }

        public synchronized WebView getWebView() {
            return this.b;
        }
    }

    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private IX5WebViewBase.HitTestResult a;
        private WebView.HitTestResult b;

        public HitTestResult() {
            this.b = null;
            this.a = null;
            this.b = null;
        }

        public HitTestResult(IX5WebViewBase.HitTestResult hitTestResult) {
            this.b = null;
            this.a = hitTestResult;
            this.b = null;
        }

        public HitTestResult(WebView.HitTestResult hitTestResult) {
            this.b = null;
            this.a = null;
            this.b = hitTestResult;
        }

        public int getType() {
            IX5WebViewBase.HitTestResult hitTestResult = this.a;
            if (hitTestResult != null) {
                return hitTestResult.getType();
            }
            WebView.HitTestResult hitTestResult2 = this.b;
            if (hitTestResult2 != null) {
                return hitTestResult2.getType();
            }
            return 0;
        }

        public String getExtra() {
            IX5WebViewBase.HitTestResult hitTestResult = this.a;
            if (hitTestResult != null) {
                return hitTestResult.getExtra();
            }
            WebView.HitTestResult hitTestResult2 = this.b;
            return hitTestResult2 != null ? hitTestResult2.getExtra() : "";
        }
    }

    public WebView(Context context, boolean z) {
        super(context);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.a = 0;
        this.k = false;
        this.n = null;
        this.o = null;
        this.q = 1;
        this.r = 2;
        this.s = 3;
        this.t = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.u = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.x = null;
        this.y = null;
    }

    public WebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, false);
    }

    public WebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        this(context, attributeSet, i2, null, z);
    }

    public WebView(Context context, AttributeSet attributeSet, int i2, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i2);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.a = 0;
        this.k = false;
        this.n = null;
        this.o = null;
        this.q = 1;
        this.r = 2;
        this.s = 3;
        this.t = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.u = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.x = null;
        this.y = null;
        mWebViewCreated = true;
        if (!QbSdk.getIsSysWebViewForcedByOuter() || !TbsShareManager.isThirdPartyApp(context)) {
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsLog.setWriteLogJIT(true);
            } else {
                TbsLog.setWriteLogJIT(false);
            }
            TbsLog.initIfNeed(context);
            if (context != null) {
                if (l == null) {
                    l = o.a(context);
                }
                if (l.a) {
                    TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
                    QbSdk.a(context, "debug.conf force syswebview!");
                }
                c(context);
                this.i = context;
                if (context != null) {
                    j = context.getApplicationContext();
                }
                if (!this.e || QbSdk.a) {
                    this.f = null;
                    if (TbsShareManager.isThirdPartyApp(this.i)) {
                        this.g = new a(context, attributeSet);
                    } else {
                        this.g = new a(this, context);
                    }
                    TbsLog.i("WebView", "SystemWebView Created Success! #2");
                    CookieManager.getInstance().a(context, true, false);
                    CookieManager.getInstance().a();
                    this.g.setFocusableInTouchMode(true);
                    addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                    setDownloadListener(null);
                    TbsLog.writeLogToDisk();
                    m.a(context);
                } else {
                    IX5WebViewBase a2 = u.a().a(true).a(context);
                    this.f = a2;
                    if (a2 == null || a2.getView() == null) {
                        TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                        this.f = null;
                        this.e = false;
                        QbSdk.a(context, "failed to createTBSWebview!");
                        c(context);
                        if (TbsShareManager.isThirdPartyApp(this.i)) {
                            this.g = new a(context, attributeSet);
                        } else {
                            this.g = new a(this, context);
                        }
                        TbsLog.i("WebView", "SystemWebView Created Success! #1");
                        CookieManager.getInstance().a(context, true, false);
                        CookieManager.getInstance().a();
                        this.g.setFocusableInTouchMode(true);
                        addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                        try {
                            if (Build.VERSION.SDK_INT >= 11) {
                                removeJavascriptInterface("searchBoxJavaBridge_");
                                removeJavascriptInterface("accessibility");
                                removeJavascriptInterface("accessibilityTraversal");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        TbsLog.writeLogToDisk();
                        m.a(context);
                        return;
                    }
                    TbsLog.i("WebView", "X5 WebView Created Success!!");
                    this.f.getView().setFocusableInTouchMode(true);
                    a(attributeSet);
                    addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
                    this.f.setDownloadListener(new b(this, null, this.e));
                    this.f.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(u.a().a(true).k()) {
                        /* class com.tencent.smtt.sdk.WebView.AnonymousClass1 */

                        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                        public void invalidate() {
                        }

                        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                        public void onScrollChanged(int i, int i2, int i3, int i4) {
                            super.onScrollChanged(i, i2, i3, i4);
                            WebView.this.onScrollChanged(i3, i4, i, i2);
                        }
                    });
                }
                try {
                    if (Build.VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if ((TbsConfig.APP_QQ.equals(this.i.getApplicationInfo().packageName) || TbsConfig.APP_WX.equals(this.i.getApplicationInfo().packageName)) && d.a(true).h() && Build.VERSION.SDK_INT >= 11) {
                    setLayerType(1, null);
                }
                if (this.f != null) {
                    TbsLog.writeLogToDisk();
                    if (!TbsShareManager.isThirdPartyApp(context)) {
                        int i3 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                        if (i3 <= 0 || i3 == m.a().h(context) || i3 != m.a().i(context)) {
                            TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + i3 + " getTbsCoreShareDecoupleCoreVersion is " + m.a().h(context) + " getTbsCoreInstalledVerInNolock is " + m.a().i(context));
                        } else {
                            m.a().n(context);
                        }
                    }
                }
                QbSdk.continueLoadSo(context);
                return;
            }
            throw new IllegalArgumentException("Invalid context argument");
        }
        this.i = context;
        this.f = null;
        this.e = false;
        QbSdk.a(context, "failed to createTBSWebview!");
        this.g = new a(context, attributeSet);
        CookieManager.getInstance().a(context, true, false);
        CookieSyncManager.createInstance(this.i).startSync();
        try {
            Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
            declaredMethod.setAccessible(true);
            ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new e());
            mSysWebviewCreated = true;
        } catch (Exception unused) {
        }
        CookieManager.getInstance().a();
        this.g.setFocusableInTouchMode(true);
        addView(this.g, new FrameLayout.LayoutParams(-1, -1));
        TbsLog.i("WebView", "SystemWebView Created Success! #3");
        TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_OUTER, new Throwable());
    }

    public Object createPrintDocumentAdapter(String str) {
        if (this.e) {
            try {
                return this.f.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            return null;
        } else {
            return k.a(this.g, "createPrintDocumentAdapter", new Class[]{String.class}, str);
        }
    }

    public int computeHorizontalScrollOffset() {
        try {
            if (this.e) {
                Method a2 = k.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = k.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int computeVerticalScrollOffset() {
        try {
            if (this.e) {
                Method a2 = k.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = k.a(this.g, "computeVerticalScrollOffset", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int computeVerticalScrollExtent() {
        try {
            if (this.e) {
                Method a2 = k.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = k.a(this.g, "computeVerticalScrollExtent", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int computeHorizontalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) k.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method a2 = k.a(this.g, "computeHorizontalScrollRange", new Class[0]);
            a2.setAccessible(true);
            return ((Integer) a2.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int computeHorizontalScrollExtent() {
        try {
            if (this.e) {
                Method a2 = k.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = k.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int computeVerticalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) k.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method a2 = k.a(this.g, "computeVerticalScrollRange", new Class[0]);
            a2.setAccessible(true);
            return ((Integer) a2.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private boolean b(Context context) {
        try {
            if (context.getPackageName().indexOf(TbsConfig.APP_QQ) >= 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT >= 21 && b(this.i) && isHardwareAccelerated() && i2 > 0 && i3 > 0) {
            getLayerType();
        }
    }

    private void c(Context context) {
        if (QbSdk.i && TbsShareManager.isThirdPartyApp(context)) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
        }
        u a2 = u.a();
        a2.a(context);
        this.e = a2.b();
    }

    public void setScrollBarStyle(int i2) {
        if (this.e) {
            this.f.getView().setScrollBarStyle(i2);
        } else {
            this.g.setScrollBarStyle(i2);
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (!this.e) {
            this.g.setHorizontalScrollbarOverlay(z);
        } else {
            this.f.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (!this.e) {
            this.g.setVerticalScrollbarOverlay(z);
        } else {
            this.f.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean overlayHorizontalScrollbar() {
        if (!this.e) {
            return this.g.overlayHorizontalScrollbar();
        }
        return this.f.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        if (this.e) {
            return this.f.overlayVerticalScrollbar();
        }
        return this.g.overlayVerticalScrollbar();
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.e) {
            View view2 = this.f.getView();
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (view == this) {
                view = view2;
            }
            return viewGroup.requestChildRectangleOnScreen(view, rect, z);
        }
        a aVar = this.g;
        if (view == this) {
            view = aVar;
        }
        return aVar.requestChildRectangleOnScreen(view, rect, z);
    }

    public int getWebScrollX() {
        if (this.e) {
            return this.f.getView().getScrollX();
        }
        return this.g.getScrollX();
    }

    public int getWebScrollY() {
        if (this.e) {
            return this.f.getView().getScrollY();
        }
        return this.g.getScrollY();
    }

    public int getVisibleTitleHeight() {
        if (this.e) {
            return this.f.getVisibleTitleHeight();
        }
        Object a2 = k.a(this.g, "getVisibleTitleHeight");
        if (a2 == null) {
            return 0;
        }
        return ((Integer) a2).intValue();
    }

    public SslCertificate getCertificate() {
        if (!this.e) {
            return this.g.getCertificate();
        }
        return this.f.getCertificate();
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (!this.e) {
            this.g.setCertificate(sslCertificate);
        } else {
            this.f.setCertificate(sslCertificate);
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (!this.e) {
            k.a(this.g, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
            return;
        }
        this.f.savePassword(str, str2, str3);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (!this.e) {
            this.g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.f.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        if (!this.e) {
            return this.g.getHttpAuthUsernamePassword(str, str2);
        }
        return this.f.getHttpAuthUsernamePassword(str, str2);
    }

    public void tbsWebviewDestroy(boolean z) {
        boolean z2;
        Bundle sdkQBStatisticsInfo;
        if (!this.k && this.a != 0) {
            this.k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.e && (sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                str = sdkQBStatisticsInfo.getString("guid");
                str2 = sdkQBStatisticsInfo.getString("qua2");
                str3 = sdkQBStatisticsInfo.getString("lc");
            }
            if (TbsConfig.APP_QZONE.equals(this.i.getApplicationInfo().packageName)) {
                int e2 = e(this.i);
                if (e2 == -1) {
                    e2 = this.a;
                }
                this.a = e2;
                f(this.i);
            }
            try {
                z2 = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (Throwable th) {
                TbsLog.w("tbsWebviewDestroy", "exception: " + th);
                z2 = false;
            }
            b.a(this.i, str, str2, str3, this.a, this.e, h(), z2);
            this.a = 0;
            this.k = false;
        }
        if (!this.e) {
            try {
                Class<?> cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", android.webkit.WebView.class);
                method.setAccessible(true);
                Object invoke = method.invoke(null, this.g);
                if (invoke != null) {
                    Field declaredField = cls.getDeclaredField("mListBoxDialog");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(invoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class<?> cls2 = Class.forName("android.app.Dialog");
                        Field declaredField2 = cls2.getDeclaredField("CANCEL");
                        declaredField2.setAccessible(true);
                        int intValue = ((Integer) declaredField2.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception unused) {
            }
            if (z) {
                this.g.destroy();
            }
            try {
                Field declaredField4 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField4.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField4.get(null);
                if (componentCallbacks != null) {
                    declaredField4.set(null, null);
                    Field declaredField5 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField5.setAccessible(true);
                    Object obj2 = declaredField5.get(null);
                    if (obj2 != null) {
                        List list = (List) obj2;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        } else if (z) {
            this.f.destroy();
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.b());
    }

    public void destroy() {
        try {
            if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName)) {
                new Thread("WebviewDestroy") {
                    /* class com.tencent.smtt.sdk.WebView.AnonymousClass2 */

                    public void run() {
                        WebView.this.tbsWebviewDestroy(false);
                    }
                }.start();
                if (this.e) {
                    this.f.destroy();
                } else {
                    this.g.destroy();
                }
            } else {
                tbsWebviewDestroy(true);
            }
        } catch (Throwable unused) {
            tbsWebviewDestroy(true);
        }
    }

    private long h() {
        long j2;
        synchronized (QbSdk.h) {
            if (QbSdk.e) {
                QbSdk.g += System.currentTimeMillis() - QbSdk.f;
                TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.g);
            }
            j2 = QbSdk.g / 1000;
            QbSdk.g = 0;
            QbSdk.f = System.currentTimeMillis();
        }
        return j2;
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (!u.a().b()) {
            k.a("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (!u.a().b()) {
            k.a("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    public void setNetworkAvailable(boolean z) {
        if (this.e) {
            this.f.setNetworkAvailable(z);
        } else if (Build.VERSION.SDK_INT >= 3) {
            this.g.setNetworkAvailable(z);
        }
    }

    public WebBackForwardList saveState(Bundle bundle) {
        if (!this.e) {
            return WebBackForwardList.a(this.g.saveState(bundle));
        }
        return WebBackForwardList.a(this.f.saveState(bundle));
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (this.e) {
            return this.f.savePicture(bundle, file);
        }
        Object a2 = k.a(this.g, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        if (a2 == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (this.e) {
            return this.f.restorePicture(bundle, file);
        }
        Object a2 = k.a(this.g, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        if (a2 == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        if (!this.e) {
            return WebBackForwardList.a(this.g.restoreState(bundle));
        }
        return WebBackForwardList.a(this.f.restoreState(bundle));
    }

    public JSONObject reportInitPerformance(long j2, int i2, long j3, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IS_X5", this.e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (str != null && !showDebugView(str)) {
            if (this.e) {
                this.f.loadUrl(str, map);
            } else if (Build.VERSION.SDK_INT >= 8) {
                this.g.loadUrl(str, map);
            }
        }
    }

    public void loadUrl(String str) {
        if (str != null && !showDebugView(str)) {
            if (!this.e) {
                this.g.loadUrl(str);
            } else {
                this.f.loadUrl(str);
            }
        }
    }

    public boolean showDebugView(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            d.a(this.i).a(lowerCase, this, this.i, l.a().getLooper());
            return true;
        } else if (!lowerCase.startsWith("http://debugx5.qq.com") || this.e) {
            return false;
        } else {
            loadDataWithBaseURL(null, "<!DOCTYPE html><html><body>" + "<head>" + "<title>无法打开debugx5</title>" + "<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />" + "</head>" + "<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />" + "尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>" + "</body></html>", "text/html", "utf-8", null);
            return true;
        }
    }

    public void postUrl(String str, byte[] bArr) {
        if (!this.e) {
            this.g.postUrl(str, bArr);
        } else {
            this.f.postUrl(str, bArr);
        }
    }

    public void loadData(String str, String str2, String str3) {
        if (!this.e) {
            this.g.loadData(str, str2, str3);
        } else {
            this.f.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.e) {
            this.g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.f.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void saveWebArchive(String str) {
        if (this.e) {
            this.f.saveWebArchive(str);
        } else if (Build.VERSION.SDK_INT >= 11) {
            k.a(this.g, "saveWebArchive", new Class[]{String.class}, str);
        }
    }

    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        if (this.e) {
            this.f.saveWebArchive(str, z, valueCallback);
        } else if (Build.VERSION.SDK_INT >= 11) {
            k.a(this.g, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, str, Boolean.valueOf(z), valueCallback);
        }
    }

    public void stopLoading() {
        if (!this.e) {
            this.g.stopLoading();
        } else {
            this.f.stopLoading();
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        u a2 = u.a();
        if (a2 != null && a2.b()) {
            a2.c().a(z);
        } else if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", Boolean.TYPE);
                m = declaredMethod;
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    m.invoke(null, Boolean.valueOf(z));
                }
            } catch (Exception e2) {
                TbsLog.e("QbSdk", "Exception:" + e2.getStackTrace());
                e2.printStackTrace();
            }
        }
    }

    public void reload() {
        if (!this.e) {
            this.g.reload();
        } else {
            this.f.reload();
        }
    }

    public boolean canGoBack() {
        if (!this.e) {
            return this.g.canGoBack();
        }
        return this.f.canGoBack();
    }

    public void goBack() {
        if (!this.e) {
            this.g.goBack();
        } else {
            this.f.goBack();
        }
    }

    public boolean canGoForward() {
        if (!this.e) {
            return this.g.canGoForward();
        }
        return this.f.canGoForward();
    }

    public void goForward() {
        if (!this.e) {
            this.g.goForward();
        } else {
            this.f.goForward();
        }
    }

    public boolean canGoBackOrForward(int i2) {
        if (!this.e) {
            return this.g.canGoBackOrForward(i2);
        }
        return this.f.canGoBackOrForward(i2);
    }

    public void goBackOrForward(int i2) {
        if (!this.e) {
            this.g.goBackOrForward(i2);
        } else {
            this.f.goBackOrForward(i2);
        }
    }

    public boolean pageUp(boolean z) {
        if (!this.e) {
            return this.g.pageUp(z);
        }
        return this.f.pageUp(z, -1);
    }

    public boolean pageDown(boolean z) {
        if (!this.e) {
            return this.g.pageDown(z);
        }
        return this.f.pageDown(z, -1);
    }

    @Deprecated
    public void clearView() {
        if (!this.e) {
            k.a(this.g, "clearView");
        } else {
            this.f.clearView();
        }
    }

    @Deprecated
    public Picture capturePicture() {
        if (this.e) {
            return this.f.capturePicture();
        }
        Object a2 = k.a(this.g, "capturePicture");
        if (a2 == null) {
            return null;
        }
        return (Picture) a2;
    }

    @Deprecated
    public float getScale() {
        if (this.e) {
            return this.f.getScale();
        }
        Object a2 = k.a(this.g, "getScale");
        if (a2 == null) {
            return 0.0f;
        }
        return ((Float) a2).floatValue();
    }

    public void setInitialScale(int i2) {
        if (!this.e) {
            this.g.setInitialScale(i2);
        } else {
            this.f.setInitialScale(i2);
        }
    }

    public void invokeZoomPicker() {
        if (!this.e) {
            this.g.invokeZoomPicker();
        } else {
            this.f.invokeZoomPicker();
        }
    }

    public HitTestResult getHitTestResult() {
        if (!this.e) {
            return new HitTestResult(this.g.getHitTestResult());
        }
        return new HitTestResult(this.f.getHitTestResult());
    }

    public IX5WebViewBase.HitTestResult getX5HitTestResult() {
        if (!this.e) {
            return null;
        }
        return this.f.getHitTestResult();
    }

    public void requestFocusNodeHref(Message message) {
        if (!this.e) {
            this.g.requestFocusNodeHref(message);
        } else {
            this.f.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (!this.e) {
            this.g.requestImageRef(message);
        } else {
            this.f.requestImageRef(message);
        }
    }

    public String getUrl() {
        if (!this.e) {
            return this.g.getUrl();
        }
        return this.f.getUrl();
    }

    public String getOriginalUrl() {
        if (!this.e) {
            return this.g.getOriginalUrl();
        }
        return this.f.getOriginalUrl();
    }

    public String getTitle() {
        if (!this.e) {
            return this.g.getTitle();
        }
        return this.f.getTitle();
    }

    public Bitmap getFavicon() {
        if (!this.e) {
            return this.g.getFavicon();
        }
        return this.f.getFavicon();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        if (u.a().b() || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) k.a("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void setRendererPriorityPolicy(int i2, boolean z) {
        try {
            if (!this.e && Build.VERSION.SDK_INT >= 26) {
                k.a(this.g, "setRendererPriorityPolicy", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i2), Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int getRendererRequestedPriority() {
        try {
            if (this.e || Build.VERSION.SDK_INT < 26) {
                return 0;
            }
            Object a2 = k.a(this.g, "getRendererRequestedPriority");
            if (a2 == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        try {
            if (this.e || Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Object a2 = k.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public WebChromeClient getWebChromeClient() {
        return this.o;
    }

    public WebViewClient getWebViewClient() {
        return this.n;
    }

    public int getProgress() {
        if (!this.e) {
            return this.g.getProgress();
        }
        return this.f.getProgress();
    }

    public int getContentHeight() {
        if (!this.e) {
            return this.g.getContentHeight();
        }
        return this.f.getContentHeight();
    }

    public int getContentWidth() {
        if (this.e) {
            return this.f.getContentWidth();
        }
        Object a2 = k.a(this.g, "getContentWidth");
        if (a2 == null) {
            return 0;
        }
        return ((Integer) a2).intValue();
    }

    public void pauseTimers() {
        if (!this.e) {
            this.g.pauseTimers();
        } else {
            this.f.pauseTimers();
        }
    }

    public void resumeTimers() {
        if (!this.e) {
            this.g.resumeTimers();
        } else {
            this.f.resumeTimers();
        }
    }

    public void onPause() {
        if (!this.e) {
            k.a(this.g, "onPause");
        } else {
            this.f.onPause();
        }
    }

    public void onResume() {
        if (!this.e) {
            k.a(this.g, "onResume");
        } else {
            this.f.onResume();
        }
    }

    @Deprecated
    public void freeMemory() {
        if (!this.e) {
            k.a(this.g, "freeMemory");
        } else {
            this.f.freeMemory();
        }
    }

    public void clearCache(boolean z) {
        if (!this.e) {
            this.g.clearCache(z);
        } else {
            this.f.clearCache(z);
        }
    }

    public void clearFormData() {
        if (!this.e) {
            this.g.clearFormData();
        } else {
            this.f.clearFormData();
        }
    }

    public void clearHistory() {
        if (!this.e) {
            this.g.clearHistory();
        } else {
            this.f.clearHistory();
        }
    }

    public void clearSslPreferences() {
        if (!this.e) {
            this.g.clearSslPreferences();
        } else {
            this.f.clearSslPreferences();
        }
    }

    public WebBackForwardList copyBackForwardList() {
        if (this.e) {
            return WebBackForwardList.a(this.f.copyBackForwardList());
        }
        return WebBackForwardList.a(this.g.copyBackForwardList());
    }

    public void setFindListener(final IX5WebViewBase.FindListener findListener) {
        if (this.e) {
            this.f.setFindListener(findListener);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.g.setFindListener(new WebView.FindListener() {
                /* class com.tencent.smtt.sdk.WebView.AnonymousClass3 */

                public void onFindResultReceived(int i, int i2, boolean z) {
                    findListener.onFindResultReceived(i, i2, z);
                }
            });
        }
    }

    public void findNext(boolean z) {
        if (!this.e) {
            this.g.findNext(z);
        } else {
            this.f.findNext(z);
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (this.e) {
            return this.f.findAll(str);
        }
        Object a2 = k.a(this.g, "findAll", new Class[]{String.class}, str);
        if (a2 == null) {
            return 0;
        }
        return ((Integer) a2).intValue();
    }

    public static String findAddress(String str) {
        if (!u.a().b()) {
            return android.webkit.WebView.findAddress(str);
        }
        return null;
    }

    public void findAllAsync(String str) {
        if (this.e) {
            this.f.findAllAsync(str);
        } else if (Build.VERSION.SDK_INT >= 16) {
            k.a(this.g, "findAllAsync", new Class[]{String.class}, str);
        }
    }

    public void clearMatches() {
        if (!this.e) {
            this.g.clearMatches();
        } else {
            this.f.clearMatches();
        }
    }

    public void documentHasImages(Message message) {
        if (!this.e) {
            this.g.documentHasImages(message);
        } else {
            this.f.documentHasImages(message);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        SystemWebViewClient systemWebViewClient = null;
        g gVar = null;
        if (this.e) {
            IX5WebViewBase iX5WebViewBase = this.f;
            if (webViewClient != null) {
                gVar = new g(u.a().a(true).j(), this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(gVar);
        } else {
            a aVar = this.g;
            if (webViewClient != null) {
                systemWebViewClient = new SystemWebViewClient(this, webViewClient);
            }
            aVar.setWebViewClient(systemWebViewClient);
        }
        this.n = webViewClient;
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (this.e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        if (this.e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", z);
            bundle.putString("path", str);
            getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
        }
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        boolean z = this.e;
        if (!z) {
            this.g.setDownloadListener(new DownloadListener() {
                /* class com.tencent.smtt.sdk.WebView.AnonymousClass4 */

                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    DownloadListener downloadListener = downloadListener;
                    if (downloadListener == null) {
                        ApplicationInfo applicationInfo = WebView.this.i == null ? null : WebView.this.i.getApplicationInfo();
                        if (applicationInfo == null || !TbsConfig.APP_WX.equals(applicationInfo.packageName)) {
                            c.a(WebView.this.i, str, null, null);
                            return;
                        }
                        return;
                    }
                    downloadListener.onDownloadStart(str, str2, str3, str4, j);
                }
            });
        } else {
            this.f.setDownloadListener(new b(this, downloadListener, z));
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        SystemWebChromeClient systemWebChromeClient = null;
        f fVar = null;
        if (this.e) {
            IX5WebViewBase iX5WebViewBase = this.f;
            if (webChromeClient != null) {
                fVar = new f(u.a().a(true).i(), this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(fVar);
        } else {
            a aVar = this.g;
            if (webChromeClient != null) {
                systemWebChromeClient = new SystemWebChromeClient(this, webChromeClient);
            }
            aVar.setWebChromeClient(systemWebChromeClient);
        }
        this.o = webChromeClient;
    }

    public void setPictureListener(final PictureListener pictureListener) {
        if (!this.e) {
            if (pictureListener == null) {
                this.g.setPictureListener(null);
            } else {
                this.g.setPictureListener(new WebView.PictureListener() {
                    /* class com.tencent.smtt.sdk.WebView.AnonymousClass5 */

                    public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                        WebView.this.a(webView);
                        pictureListener.onNewPicture(WebView.this, picture);
                    }
                });
            }
        } else if (pictureListener == null) {
            this.f.setPictureListener(null);
        } else {
            this.f.setPictureListener(new IX5WebViewBase.PictureListener() {
                /* class com.tencent.smtt.sdk.WebView.AnonymousClass6 */

                @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                }

                @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
                    WebView.this.a(iX5WebViewBase);
                    pictureListener.onNewPicture(WebView.this, picture);
                }
            });
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (!this.e) {
            this.g.addJavascriptInterface(obj, str);
        } else {
            this.f.addJavascriptInterface(obj, str);
        }
    }

    public void removeJavascriptInterface(String str) {
        if (this.e) {
            this.f.removeJavascriptInterface(str);
        } else if (Build.VERSION.SDK_INT >= 11) {
            k.a(this.g, "removeJavascriptInterface", new Class[]{String.class}, str);
        }
    }

    public WebSettings getSettings() {
        WebSettings webSettings = this.h;
        if (webSettings != null) {
            return webSettings;
        }
        if (this.e) {
            WebSettings webSettings2 = new WebSettings(this.f.getSettings());
            this.h = webSettings2;
            return webSettings2;
        }
        WebSettings webSettings3 = new WebSettings(this.g.getSettings());
        this.h = webSettings3;
        return webSettings3;
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        synchronized (WebView.class) {
            if (u.a().b()) {
                return null;
            }
            return k.a("android.webkit.WebView", "getPluginList");
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (!this.e) {
            k.a(this.g, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            return;
        }
        this.f.refreshPlugins(z);
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (!this.e) {
            k.a(this.g, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            return;
        }
        this.f.setMapTrackballToArrowKeys(z);
    }

    public void flingScroll(int i2, int i3) {
        if (!this.e) {
            this.g.flingScroll(i2, i3);
        } else {
            this.f.flingScroll(i2, i3);
        }
    }

    @Deprecated
    public View getZoomControls() {
        if (!this.e) {
            return (View) k.a(this.g, "getZoomControls");
        }
        return this.f.getZoomControls();
    }

    @Deprecated
    public boolean canZoomIn() {
        Object a2;
        if (this.e) {
            return this.f.canZoomIn();
        }
        if (Build.VERSION.SDK_INT < 11 || (a2 = k.a(this.g, "canZoomIn")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public boolean isPrivateBrowsingEnabled() {
        Object a2;
        if (this.e) {
            return this.f.isPrivateBrowsingEnable();
        }
        if (Build.VERSION.SDK_INT < 11 || (a2 = k.a(this.g, "isPrivateBrowsingEnabled")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    @Deprecated
    public boolean canZoomOut() {
        Object a2;
        if (this.e) {
            return this.f.canZoomOut();
        }
        if (Build.VERSION.SDK_INT < 11 || (a2 = k.a(this.g, "canZoomOut")) == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public boolean zoomIn() {
        if (!this.e) {
            return this.g.zoomIn();
        }
        return this.f.zoomIn();
    }

    public boolean zoomOut() {
        if (!this.e) {
            return this.g.zoomOut();
        }
        return this.f.zoomOut();
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i2) {
        if (!this.e) {
            k.a(this.g, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i2));
            return;
        }
        this.f.dumpViewHierarchyWithProperties(bufferedWriter, i2);
    }

    public View findHierarchyView(String str, int i2) {
        if (this.e) {
            return this.f.findHierarchyView(str, i2);
        }
        return (View) k.a(this.g, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i2));
    }

    public void computeScroll() {
        if (!this.e) {
            this.g.computeScroll();
        } else {
            this.f.computeScroll();
        }
    }

    public void setBackgroundColor(int i2) {
        if (!this.e) {
            this.g.setBackgroundColor(i2);
        } else {
            this.f.setBackgroundColor(i2);
        }
        super.setBackgroundColor(i2);
    }

    public View getView() {
        if (!this.e) {
            return this.g;
        }
        return this.f.getView();
    }

    /* access modifiers changed from: protected */
    public void a() {
        String str;
        String str2;
        String str3;
        boolean z;
        Bundle sdkQBStatisticsInfo;
        if (!this.k && this.a != 0) {
            this.k = true;
            if (!this.e || (sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo()) == null) {
                str3 = "";
                str2 = str3;
                str = str2;
            } else {
                String string = sdkQBStatisticsInfo.getString("guid");
                String string2 = sdkQBStatisticsInfo.getString("qua2");
                str = sdkQBStatisticsInfo.getString("lc");
                str3 = string;
                str2 = string2;
            }
            if (TbsConfig.APP_QZONE.equals(this.i.getApplicationInfo().packageName)) {
                int e2 = e(this.i);
                if (e2 == -1) {
                    e2 = this.a;
                }
                this.a = e2;
                f(this.i);
            }
            try {
                z = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (Throwable th) {
                TbsLog.w("tbsOnDetachedFromWindow", "exception: " + th);
                z = false;
            }
            b.a(this.i, str3, str2, str, this.a, this.e, h(), z);
            this.a = 0;
            this.k = false;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName)) {
                new Thread("onDetachedFromWindow") {
                    /* class com.tencent.smtt.sdk.WebView.AnonymousClass7 */

                    public void run() {
                        try {
                            WebView.this.a();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            } else {
                a();
            }
        } catch (Throwable unused) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        String str;
        String str2;
        String str3;
        boolean z;
        Bundle sdkQBStatisticsInfo;
        Context context = this.i;
        if (context == null) {
            super.onVisibilityChanged(view, i2);
            return;
        }
        if (p == null) {
            p = context.getApplicationInfo().packageName;
        }
        String str4 = p;
        if (str4 == null || (!str4.equals(TbsConfig.APP_WX) && !p.equals(TbsConfig.APP_QQ))) {
            if (!(i2 == 0 || this.k || this.a == 0)) {
                this.k = true;
                if (!this.e || (sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo()) == null) {
                    str3 = "";
                    str2 = str3;
                    str = str2;
                } else {
                    String string = sdkQBStatisticsInfo.getString("guid");
                    String string2 = sdkQBStatisticsInfo.getString("qua2");
                    str = sdkQBStatisticsInfo.getString("lc");
                    str3 = string;
                    str2 = string2;
                }
                if (TbsConfig.APP_QZONE.equals(this.i.getApplicationInfo().packageName)) {
                    int e2 = e(this.i);
                    if (e2 == -1) {
                        e2 = this.a;
                    }
                    this.a = e2;
                    f(this.i);
                }
                try {
                    z = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
                } catch (Throwable th) {
                    TbsLog.w("onVisibilityChanged", "exception: " + th);
                    z = false;
                }
                b.a(this.i, str3, str2, str, this.a, this.e, h(), z);
                this.a = 0;
                this.k = false;
            }
            super.onVisibilityChanged(view, i2);
            return;
        }
        super.onVisibilityChanged(view, i2);
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        if (!this.e) {
            return null;
        }
        return this.f.getX5WebViewExtension();
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        if (!this.e) {
            return null;
        }
        return this.f.getX5WebViewExtension().getSettingsExtension();
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        if (!this.e) {
            return null;
        }
        return this.f.getX5WebViewExtension().getWebChromeClientExtension();
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        if (!this.e) {
            return null;
        }
        return this.f.getX5WebViewExtension().getWebViewClientExtension();
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.e) {
            try {
                Method a2 = k.a(this.f.getView(), "evaluateJavascript", String.class, ValueCallback.class);
                a2.setAccessible(true);
                a2.invoke(this.f.getView(), str, valueCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
                loadUrl(str);
            }
        } else if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", String.class, ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.g, str, valueCallback);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    /* access modifiers changed from: package-private */
    public android.webkit.WebView b() {
        if (!this.e) {
            return this.g;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(IX5WebViewBase iX5WebViewBase) {
        this.f = iX5WebViewBase;
    }

    /* access modifiers changed from: package-private */
    public IX5WebViewBase c() {
        return this.f;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    if (attributeSet.getAttributeName(i2).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i2, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                            this.f.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.f.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Context d(Context context) {
        return (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 22) ? context : context.createConfigurationContext(new Configuration());
    }

    /* access modifiers changed from: private */
    public class a extends android.webkit.WebView {
        public a(WebView webView, Context context) {
            this(context, null);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(WebView.this.d(context), attributeSet);
            if (!QbSdk.getIsSysWebViewForcedByOuter() || !TbsShareManager.isThirdPartyApp(context)) {
                CookieSyncManager.createInstance(WebView.this.i).startSync();
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                    declaredMethod.setAccessible(true);
                    ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new e());
                    WebView.mSysWebviewCreated = true;
                } catch (Exception unused) {
                }
            }
        }

        public void invalidate() {
            super.invalidate();
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.invalidate();
            }
        }

        public WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
                return;
            }
            super.onScrollChanged(i, i2, i3, i4);
            WebView.this.onScrollChanged(i, i2, i3, i4);
        }

        public void a(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        public void computeScroll() {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        public void a() {
            super.computeScroll();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean a(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (!WebView.w && WebView.v != null) {
                    canvas.save();
                    canvas.drawPaint(WebView.v);
                    canvas.restore();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        public boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
            } else if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        public void a(int i, int i2, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.dispatchTouchEvent(motionEvent, this);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(motionEvent, this);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public boolean c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setOverScrollMode(int i) {
            try {
                super.setOverScrollMode(i);
            } catch (Exception unused) {
            }
        }
    }

    public void switchNightMode(boolean z) {
        if (z != w) {
            w = z;
            if (z) {
                TbsLog.e("QB_SDK", "deleteNightMode");
                loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
                return;
            }
            TbsLog.e("QB_SDK", "nightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (!w) {
            TbsLog.e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        synchronized (WebView.class) {
            if (z != w) {
                w = z;
                if (v == null) {
                    Paint paint = new Paint();
                    v = paint;
                    paint.setColor(-16777216);
                }
                if (!z) {
                    int alpha = v.getAlpha();
                    int i2 = NIGHT_MODE_ALPHA;
                    if (alpha != i2) {
                        v.setAlpha(i2);
                    }
                } else if (v.getAlpha() != 255) {
                    v.setAlpha(255);
                }
            }
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setARModeEnable(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setARModeEnable(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isDayMode() {
        return w;
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public void setSysNightModeAlpha(int i2) {
        NIGHT_MODE_ALPHA = i2;
    }

    public boolean onLongClick(View view) {
        View.OnLongClickListener onLongClickListener = this.y;
        if (onLongClickListener == null) {
            return a(view);
        }
        if (!onLongClickListener.onLongClick(view)) {
            return a(view);
        }
        return true;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (!this.e) {
            this.g.setOnLongClickListener(onLongClickListener);
            return;
        }
        View view = this.f.getView();
        try {
            if (this.x == null) {
                Method a2 = k.a(view, "getListenerInfo", new Class[0]);
                a2.setAccessible(true);
                Object invoke = a2.invoke(view, null);
                Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                declaredField.setAccessible(true);
                this.x = declaredField.get(invoke);
            }
            this.y = onLongClickListener;
            getView().setOnLongClickListener(this);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0 A[SYNTHETIC, Splitter:B:40:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00dd A[SYNTHETIC, Splitter:B:45:0x00dd] */
    private int e(Context context) {
        FileLock a2;
        Throwable th;
        Exception e2;
        StringBuilder sb;
        FileOutputStream b2 = f.b(context, true, "tbslock.txt");
        if (b2 == null || (a2 = f.a(context, b2)) == null) {
            return -1;
        }
        Lock lock = c;
        if (lock.tryLock()) {
            FileInputStream fileInputStream = null;
            try {
                File tbsFolderDir = QbSdk.getTbsFolderDir(context);
                File file = new File(tbsFolderDir + File.separator + "core_private", "pv.db");
                if (!file.exists()) {
                    lock.unlock();
                    f.a(a2, b2);
                    return -1;
                }
                Properties properties = new Properties();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                    String property = properties.getProperty("PV");
                    if (property == null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            e = e3;
                            sb = new StringBuilder();
                        }
                        c.unlock();
                        f.a(a2, b2);
                        return -1;
                    }
                    int parseInt = Integer.parseInt(property);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e4.toString());
                    }
                    c.unlock();
                    f.a(a2, b2);
                    return parseInt;
                } catch (Exception e5) {
                    e2 = e5;
                    fileInputStream = fileInputStream2;
                    try {
                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e2.toString());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                e = e6;
                                sb = new StringBuilder();
                            }
                        }
                        c.unlock();
                        f.a(a2, b2);
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e7) {
                                TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e7.toString());
                            }
                        }
                        c.unlock();
                        f.a(a2, b2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    c.unlock();
                    f.a(a2, b2);
                    throw th;
                }
            } catch (Exception e8) {
                e2 = e8;
                TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e2.toString());
                if (fileInputStream != null) {
                }
                c.unlock();
                f.a(a2, b2);
                return -1;
            }
        } else {
            f.a(a2, b2);
            return -1;
        }
        sb.append("TbsInstaller--getTbsCorePV IOException=");
        sb.append(e.toString());
        TbsLog.e("getTbsCorePV", sb.toString());
        c.unlock();
        f.a(a2, b2);
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        String str;
        int e2 = e(context);
        if (e2 != -1) {
            str = "PV=" + String.valueOf(e2 + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(QbSdk.getTbsFolderDir(context) + File.separator + "core_private", "pv.db");
        try {
            file.getParentFile().mkdirs();
            if (!file.isFile() || !file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            d = fileOutputStream;
            fileOutputStream.write(str.getBytes());
            OutputStream outputStream = d;
            if (outputStream != null) {
                outputStream.flush();
            }
        } catch (Throwable unused) {
        }
    }

    private void f(Context context) {
        try {
            File tbsFolderDir = QbSdk.getTbsFolderDir(context);
            File file = new File(tbsFolderDir + File.separator + "core_private", "pv.db");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e2.toString());
        }
    }

    private boolean a(View view) {
        Object a2;
        Context context = this.i;
        if ((context == null || getTbsCoreVersion(context) <= 36200) && (a2 = k.a(this.x, "onLongClick", new Class[]{View.class}, view)) != null) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }

    public void addView(View view) {
        if (!this.e) {
            this.g.addView(view);
            return;
        }
        View view2 = this.f.getView();
        try {
            Method a2 = k.a(view2, "addView", View.class);
            a2.setAccessible(true);
            a2.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    public void removeView(View view) {
        if (!this.e) {
            this.g.removeView(view);
            return;
        }
        View view2 = this.f.getView();
        try {
            Method a2 = k.a(view2, "removeView", View.class);
            a2.setAccessible(true);
            a2.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    public static String getCrashExtraMessage(Context context) {
        if (context == null) {
            return "";
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";" + "tbs_sdk_version:" + 43903 + ";";
        boolean z = false;
        if (TbsConfig.APP_WX.equals(context.getApplicationInfo().packageName)) {
            try {
                Class.forName("de.robv.android.xposed.XposedBridge");
                z = true;
            } catch (ClassNotFoundException unused) {
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z) {
            return str + "isXposed=true;";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d.a(true).e());
        sb.append("\n");
        sb.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && QbSdk.n != null && QbSdk.n.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.n.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            sb.append("\n");
            sb.append("weapp_id:" + QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";");
        }
        if (sb.length() > 8192) {
            return sb.substring(sb.length() - 8192);
        }
        return sb.toString();
    }

    public static boolean getTbsNeedReboot() {
        d();
        return d.a(true).f();
    }

    static void d() {
        try {
            new Thread(new Runnable() {
                /* class com.tencent.smtt.sdk.WebView.AnonymousClass8 */

                public void run() {
                    if (WebView.j == null) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                        return;
                    }
                    d a = d.a(true);
                    if (d.b) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                        return;
                    }
                    k a2 = k.a(WebView.j);
                    int c = a2.c();
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + c);
                    if (c == 2) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                        a.a(String.valueOf(a2.b()));
                        a.b(true);
                        return;
                    }
                    int b = a2.b("copy_status");
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + b);
                    if (b == 1) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                        a.a(String.valueOf(a2.c("copy_core_ver")));
                        a.b(true);
                    } else if (u.a().b()) {
                    } else {
                        if (c == 3 || b == 3) {
                            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                            a.a(String.valueOf(d.d()));
                            a.b(true);
                        }
                    }
                }
            }).start();
        } catch (Throwable th) {
            TbsLog.e("webview", "updateRebootStatus excpetion: " + th);
        }
    }

    public void super_onScrollChanged(int i2, int i3, int i4, int i5) {
        if (!this.e) {
            this.g.a(i2, i3, i4, i5);
            return;
        }
        View view = this.f.getView();
        try {
            k.a(view, "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        if (!this.e) {
            return this.g.a(i2, i3, i4, i5, i6, i7, i8, i9, z);
        }
        View view = this.f.getView();
        try {
            Object a2 = k.a(view, "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Boolean.valueOf(z));
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void super_onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        if (!this.e) {
            this.g.a(i2, i3, z, z2);
            return;
        }
        View view = this.f.getView();
        try {
            k.a(view, "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.b(motionEvent);
        }
        try {
            Object a2 = k.a(this.f.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.c(motionEvent);
        }
        try {
            Object a2 = k.a(this.f.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.a(motionEvent);
        }
        try {
            Object a2 = k.a(this.f.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void super_computeScroll() {
        if (!this.e) {
            this.g.a();
            return;
        }
        try {
            k.a(this.f.getView(), "super_computeScroll");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    public int getScrollBarFadeDuration() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarFadeDuration();
    }

    public int getScrollBarSize() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarSize();
    }

    public int getScrollBarStyle() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarStyle();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (getView() != null) {
            getView().setVisibility(i2);
        }
    }
}
