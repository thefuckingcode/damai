package com.alipay.sdk.m.x;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.jsbridge.api.WVFile;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alipay.sdk.m.u.k;
import com.alipay.sdk.m.u.n;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class e extends LinearLayout {
    public static Handler m = new Handler(Looper.getMainLooper());
    public ImageView a;
    public TextView b;
    public ImageView c;
    public ProgressBar d;
    public WebView e;
    public final C0141e f;
    public f g;
    public g h;
    public h i;
    public final com.alipay.sdk.m.s.a j;
    public View.OnClickListener k;
    public final float l;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {

        /* renamed from: com.alipay.sdk.m.x.e$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class RunnableC0140a implements Runnable {
            public final /* synthetic */ View a;

            public RunnableC0140a(View view) {
                this.a = view;
            }

            public void run() {
                this.a.setEnabled(true);
            }
        }

        public a() {
        }

        public void onClick(View view) {
            h hVar = e.this.i;
            if (hVar != null) {
                view.setEnabled(false);
                e.m.postDelayed(new RunnableC0140a(view), 256);
                if (view == e.this.a) {
                    hVar.b(e.this);
                } else if (view == e.this.c) {
                    hVar.a(e.this);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DownloadListener {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                this.a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public class c extends WebChromeClient {
        public c() {
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return e.this.g.a(e.this, str, str2, str3, jsPromptResult);
        }

        public void onProgressChanged(WebView webView, int i) {
            if (!e.this.f.b) {
                e.this.d.setVisibility(8);
            } else if (i > 90) {
                e.this.d.setVisibility(4);
            } else {
                if (e.this.d.getVisibility() == 4) {
                    e.this.d.setVisibility(0);
                }
                e.this.d.setProgress(i);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            e.this.g.c(e.this, str);
        }
    }

    /* compiled from: Taobao */
    public class d extends WebViewClient {
        public d() {
        }

        public void onPageFinished(WebView webView, String str) {
            if (!e.this.h.b(e.this, str)) {
                super.onPageFinished(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!e.this.h.d(e.this, str)) {
                super.onPageFinished(webView, str);
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (!e.this.h.a(e.this, i, str, str2)) {
                super.onReceivedError(webView, i, str, str2);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (!e.this.h.a(e.this, sslErrorHandler, sslError)) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!e.this.h.a(e.this, str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }
    }

    /* renamed from: com.alipay.sdk.m.x.e$e  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0141e {
        public boolean a;
        public boolean b;

        public C0141e(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }
    }

    /* compiled from: Taobao */
    public interface f {
        boolean a(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult);

        void c(e eVar, String str);
    }

    /* compiled from: Taobao */
    public interface g {
        boolean a(e eVar, int i, String str, String str2);

        boolean a(e eVar, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean a(e eVar, String str);

        boolean b(e eVar, String str);

        boolean d(e eVar, String str);
    }

    /* compiled from: Taobao */
    public interface h {
        void a(e eVar);

        void b(e eVar);
    }

    public e(Context context, com.alipay.sdk.m.s.a aVar, C0141e eVar) {
        this(context, null, aVar, eVar);
    }

    public ImageView getBackButton() {
        return this.a;
    }

    public ProgressBar getProgressbar() {
        return this.d;
    }

    public ImageView getRefreshButton() {
        return this.c;
    }

    public TextView getTitle() {
        return this.b;
    }

    public String getUrl() {
        return this.e.getUrl();
    }

    public WebView getWebView() {
        return this.e;
    }

    public void setChromeProxy(f fVar) {
        this.g = fVar;
        if (fVar == null) {
            this.e.setWebChromeClient(null);
        } else {
            this.e.setWebChromeClient(new c());
        }
    }

    public void setWebClientProxy(g gVar) {
        this.h = gVar;
        if (gVar == null) {
            this.e.setWebViewClient(null);
        } else {
            this.e.setWebViewClient(new d());
        }
    }

    public void setWebEventProxy(h hVar) {
        this.i = hVar;
    }

    public e(Context context, AttributeSet attributeSet, com.alipay.sdk.m.s.a aVar, C0141e eVar) {
        super(context, attributeSet);
        this.k = new a();
        this.f = eVar == null ? new C0141e(false, false) : eVar;
        this.j = aVar;
        this.l = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    private void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(this.f.a ? 0 : 8);
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        imageView.setOnClickListener(this.k);
        this.a.setScaleType(ImageView.ScaleType.CENTER);
        this.a.setImageDrawable(k.a(k.a, context));
        this.a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setTextColor(-15658735);
        this.b.setTextSize(17.0f);
        this.b.setMaxLines(1);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.c = imageView2;
        imageView2.setOnClickListener(this.k);
        this.c.setScaleType(ImageView.ScaleType.CENTER);
        this.c.setImageDrawable(k.a(k.b, context));
        this.c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0081 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0091  */
    private void c(Context context) {
        WebView webView = new WebView(context);
        this.e = webView;
        webView.setVerticalScrollbarOverlay(true);
        a(this.e, context);
        WebSettings settings = this.e.getSettings();
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(WVFile.FILE_MAX_SIZE);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(false);
        this.e.setVerticalScrollbarOverlay(true);
        this.e.setDownloadListener(new b(context));
        this.e.removeJavascriptInterface("searchBoxJavaBridge_");
        this.e.removeJavascriptInterface("accessibility");
        this.e.removeJavascriptInterface("accessibilityTraversal");
        try {
            Method method = this.e.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (method != null) {
                method.invoke(this.e, "searchBoxJavaBridge_");
                method.invoke(this.e, "accessibility");
                method.invoke(this.e, "accessibilityTraversal");
            }
        } catch (Throwable unused) {
        }
        c.a(this.e);
        addView(this.e, new LinearLayout.LayoutParams(-1, -1));
    }

    private void b(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, 16973855);
        this.d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(17301612));
        this.d.setMax(100);
        this.d.setBackgroundColor(-218103809);
        addView(this.d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    public void a(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(userAgentString + n.g(context));
    }

    public void a(String str) {
        this.e.loadUrl(str);
        c.a(this.e);
    }

    public void a(String str, byte[] bArr) {
        this.e.postUrl(str, bArr);
    }

    public void a() {
        removeAllViews();
        this.e.removeAllViews();
        this.e.setWebViewClient(null);
        this.e.setWebChromeClient(null);
        this.e.destroy();
    }

    private int a(int i2) {
        return (int) (((float) i2) * this.l);
    }
}
