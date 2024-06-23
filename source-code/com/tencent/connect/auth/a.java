package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hms.api.ConnectionResult;
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class a extends Dialog {
    private String a;
    private b b;
    private IUiListener c;
    private Handler d;
    private FrameLayout e;
    private LinearLayout f;
    private FrameLayout g;
    private ProgressBar h;
    private String i;
    private com.tencent.open.c.d j;
    private Context k;
    private com.tencent.open.web.security.b l;
    private boolean m = false;
    private int n;
    private String o;
    private String p;
    private long q = 0;
    private long r = 30000;
    private HashMap<String, Runnable> s;

    /* access modifiers changed from: private */
    /* renamed from: com.tencent.connect.auth.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0234a extends WebViewClient {
        private C0234a() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.g.setVisibility(8);
            if (a.this.j != null) {
                a.this.j.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str)) {
                a.this.d.removeCallbacks((Runnable) a.this.s.remove(str));
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.g.setVisibility(0);
            a.this.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.o)) {
                a.this.d.removeCallbacks((Runnable) a.this.s.remove(a.this.o));
            }
            a.this.o = str;
            a aVar = a.this;
            d dVar = new d(aVar.o);
            a.this.s.put(str, dVar);
            a.this.d.postDelayed(dVar, 120000);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!m.b(a.this.k)) {
                a.this.b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
            } else if (!a.this.o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.q;
                if (a.this.n >= 1 || elapsedRealtime >= a.this.r) {
                    a.this.j.loadUrl(a.this.a());
                    return;
                }
                a.m(a.this);
                a.this.d.postDelayed(new Runnable() {
                    /* class com.tencent.connect.auth.a.C0234a.AnonymousClass1 */

                    public void run() {
                        a.this.j.loadUrl(a.this.o);
                    }
                }, 500);
            } else {
                a.this.b.onError(new UiError(i, str, str2));
                a.this.dismiss();
            }
        }

        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri uri;
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c = m.c(str);
                a aVar = a.this;
                aVar.m = aVar.e();
                if (!a.this.m) {
                    if (c.optString("fail_cb", null) != null) {
                        a.this.a(c.optString("fail_cb"), "");
                    } else if (c.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(a.this.a);
                        String str2 = "?";
                        if (a.this.a.indexOf(str2) > -1) {
                            str2 = "&";
                        }
                        sb.append(str2);
                        aVar2.a = sb.toString();
                        a aVar3 = a.this;
                        aVar3.a = a.this.a + "browser_error=1";
                        a.this.j.loadUrl(a.this.a);
                    } else {
                        String optString = c.optString("redir", null);
                        if (optString != null) {
                            a.this.j.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.b.onComplete(m.c(str));
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.b.onCancel();
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.DOWNLOAD_URI) || str.endsWith(".apk")) {
                try {
                    if (str.startsWith(Constants.DOWNLOAD_URI)) {
                        uri = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        uri = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(268435456);
                    a.this.k.startActivity(intent);
                } catch (Exception e) {
                    SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                }
                return true;
            } else if (str.startsWith("auth://progress")) {
                try {
                    List<String> pathSegments = Uri.parse(str).getPathSegments();
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        a.this.g.setVisibility(8);
                        a.this.j.setVisibility(0);
                    } else if (intValue == 1) {
                        a.this.g.setVisibility(0);
                    }
                    return true;
                } catch (Exception unused) {
                }
            } else if (str.startsWith("auth://onLoginSubmit")) {
                try {
                    List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                    if (!pathSegments2.isEmpty()) {
                        a.this.p = pathSegments2.get(0);
                    }
                } catch (Exception unused2) {
                }
                return true;
            } else if (a.this.l.a(a.this.j, str)) {
                return true;
            } else {
                SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b extends DefaultUiListener {
        String a;
        String b;
        private String d;
        private IUiListener e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener, com.tencent.tauth.DefaultUiListener
        public void onCancel() {
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener, com.tencent.tauth.DefaultUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h a2 = h.a();
            a2.a(this.d + "_H5", SystemClock.elapsedRealtime(), 0, 0, jSONObject.optInt("ret", -6), this.a, false);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener, com.tencent.tauth.DefaultUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.a;
            } else {
                str = this.a;
            }
            h.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0, 0, uiError.errorCode, str, false);
            a.this.a((a) str);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.e = null;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(String str) {
            try {
                onComplete(m.d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: Taobao */
    private class c extends Handler {
        private b b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.b = bVar;
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.b.a((String) message.obj);
            } else if (i == 2) {
                this.b.onCancel();
            } else if (i == 3) {
                a.b(a.this.k, (String) message.obj);
            }
        }
    }

    /* compiled from: Taobao */
    class d implements Runnable {
        String a = "";

        public d(String str) {
            this.a = str;
        }

        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.a + " | mRetryUrl: " + a.this.o);
            if (this.a.equals(a.this.o)) {
                a.this.b.onError(new UiError(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, "请求页面超时，请稍后重试！", a.this.o));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.k = context;
        this.a = str2;
        this.b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.d = new c(this.b, context.getMainLooper());
        this.c = iUiListener;
        this.i = str;
        this.l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    static /* synthetic */ int m(a aVar) {
        int i2 = aVar.n;
        aVar.n = i2 + 1;
        return i2;
    }

    public void dismiss() {
        this.s.clear();
        this.d.removeCallbacksAndMessages(null);
        try {
            Context context = this.k;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e2);
        }
        com.tencent.open.c.d dVar = this.j;
        if (dVar != null) {
            dVar.destroy();
            this.j = null;
        }
    }

    public void onBackPressed() {
        if (!this.m) {
            this.b.onCancel();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.tencent.open.a.a(getWindow());
        b();
        d();
        this.s = new HashMap<>();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean e() {
        b a2 = b.a();
        String c2 = a2.c();
        b.a aVar = new b.a();
        aVar.a = this.c;
        aVar.b = this;
        aVar.c = c2;
        String a3 = a2.a(aVar);
        String str = this.a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b2 = m.b(this.a);
        b2.putString("token_key", c2);
        b2.putString("serial", a3);
        b2.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b2);
        this.a = str2;
        return m.a(this.k, str2);
    }

    private void b() {
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.d dVar = new com.tencent.open.c.d(this.k);
        this.j = dVar;
        if (Build.VERSION.SDK_INT >= 11) {
            dVar.setLayerType(1, null);
        }
        this.j.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.k);
        cVar.setLayoutParams(layoutParams);
        cVar.addView(this.j);
        FrameLayout frameLayout = new FrameLayout(this.k);
        this.e = frameLayout;
        frameLayout.addView(cVar);
        this.e.setBackgroundColor(-1);
        this.e.addView(this.g);
        String string = m.b(this.a).getString("style");
        if (string != null && "qr".equals(string)) {
            a(this.e);
        }
        setContentView(this.e);
    }

    private void c() {
        TextView textView;
        this.h = new ProgressBar(this.k);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f = new LinearLayout(this.k);
        if (this.i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f.setLayoutParams(layoutParams2);
        this.f.addView(this.h);
        if (textView != null) {
            this.f.addView(textView);
        }
        this.g = new FrameLayout(this.k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.g.setLayoutParams(layoutParams3);
        this.g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.g.addView(this.f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.j.setVerticalScrollBarEnabled(false);
        this.j.setHorizontalScrollBarEnabled(false);
        this.j.setWebViewClient(new C0234a());
        this.j.setWebChromeClient(new WebChromeClient());
        this.j.clearFormData();
        this.j.clearSslPreferences();
        this.j.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.connect.auth.a.AnonymousClass2 */

            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.j.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.connect.auth.a.AnonymousClass3 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        WebSettings settings = this.j.getSettings();
        com.tencent.open.web.a.a(this.j);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.a);
        String str = this.a;
        this.o = str;
        this.j.loadUrl(str);
        this.j.setVisibility(4);
        this.l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.connect.auth.a.AnonymousClass4 */

            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.isJniOk) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            String str2 = this.p;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String a() {
        String str = this.a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    private void a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.k);
        int a2 = com.tencent.connect.avatar.a.a(this.k, 15.6f);
        int a3 = com.tencent.connect.avatar.a.a(this.k, 25.2f);
        int a4 = com.tencent.connect.avatar.a.a(this.k, 10.0f);
        int i2 = a4 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2 + i2, a3 + i2);
        layoutParams.leftMargin = a4;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(a4, a4, a4, a4);
        imageView.setImageDrawable(m.a("h5_qr_back.png", this.k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.connect.auth.a.AnonymousClass1 */

            public void onClick(View view) {
                a.this.dismiss();
                if (!a.this.m && a.this.b != null) {
                    a.this.b.onCancel();
                }
            }
        });
        viewGroup.addView(imageView);
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject d2 = m.d(str);
            int i2 = d2.getInt("type");
            Toast.makeText(context.getApplicationContext(), d2.getString("msg"), i2).show();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.j.loadUrl("javascript:" + str + jl1.BRACKET_START_STR + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
