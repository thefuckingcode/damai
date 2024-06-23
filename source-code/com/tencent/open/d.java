package com.tencent.open;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b;
import com.tencent.open.b.h;
import com.tencent.open.c.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class d extends c implements a.AbstractC0239a {
    static Toast c;
    private String d;
    private IUiListener e;
    private c f;
    private Handler g;
    private com.tencent.open.c.a h;
    private com.tencent.open.c.b i;
    private WeakReference<Context> j;
    private int k;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a extends WebViewClient {
        private a() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            d.this.i.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            d.this.f.onError(new UiError(i, str, str2));
            if (!(d.this.j == null || d.this.j.get() == null)) {
                Toast.makeText((Context) d.this.j.get(), "网络连接异常或系统错误", 0).show();
            }
            d.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) d.this.j.get(), "auth://tauth.qq.com/"))) {
                d.this.f.onComplete(m.c(str));
                d.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                d.this.f.onCancel();
                d.this.dismiss();
                return true;
            } else if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            } else {
                d.this.dismiss();
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b extends b.C0238b {
        private b() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c extends DefaultUiListener {
        String a;
        String b;
        private WeakReference<Context> c;
        private String d;
        private IUiListener e;

        public c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.c = new WeakReference<>(context);
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

    /* renamed from: com.tencent.open.d$d  reason: collision with other inner class name */
    /* compiled from: Taobao */
    private class HandlerC0240d extends Handler {
        private c b;

        public HandlerC0240d(c cVar, Looper looper) {
            super(looper);
            this.b = cVar;
        }

        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.b.a((String) message.obj);
            } else if (i == 2) {
                this.b.onCancel();
            } else if (i != 3) {
                if (i == 5 && d.this.j != null && d.this.j.get() != null) {
                    d.d((Context) d.this.j.get(), (String) message.obj);
                }
            } else if (d.this.j != null && d.this.j.get() != null) {
                d.c((Context) d.this.j.get(), (String) message.obj);
            }
        }
    }

    public d(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.j = new WeakReference<>(context);
        this.d = str2;
        this.f = new c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.g = new HandlerC0240d(this.f, context.getMainLooper());
        this.e = iUiListener;
        this.k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.k);
    }

    /* access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context != null && str != null) {
            try {
                JSONObject d2 = m.d(str);
                d2.getInt("action");
                d2.getString("msg");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.open.c
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.i.setVerticalScrollBarEnabled(false);
        this.i.setHorizontalScrollBarEnabled(false);
        this.i.setWebViewClient(new a());
        this.i.setWebChromeClient(this.b);
        this.i.clearFormData();
        WebSettings settings = this.i.getSettings();
        if (settings != null) {
            com.tencent.open.web.a.a(this.i);
            settings.setSaveFormData(false);
            settings.setCacheMode(-1);
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            WeakReference<Context> weakReference = this.j;
            if (!(weakReference == null || weakReference.get() == null)) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(this.j.get().getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.a.a(new b(), "sdk_js_if");
            this.i.clearView();
            this.i.loadUrl(this.d);
        }
    }

    private void b() {
        com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.j.get());
        this.h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.j.get());
        this.i = bVar;
        bVar.setBackgroundColor(0);
        this.i.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.i, 1, new Paint());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.k);
        layoutParams.addRule(13, -1);
        this.i.setLayoutParams(layoutParams);
        this.h.addView(this.i);
        this.h.a(this);
        setContentView(this.h);
    }

    @Override // com.tencent.open.c.a.AbstractC0239a
    public void a(int i2) {
        WeakReference<Context> weakReference = this.j;
        if (!(weakReference == null || weakReference.get() == null)) {
            if (i2 >= this.k || 2 != this.j.get().getResources().getConfiguration().orientation) {
                this.i.getLayoutParams().height = this.k;
            } else {
                this.i.getLayoutParams().height = i2;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.AbstractC0239a
    public void a() {
        this.i.getLayoutParams().height = this.k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.open.c
    public void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.i, str);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d2 = m.d(str);
            int i2 = d2.getInt("type");
            String string = d2.getString("msg");
            if (i2 == 0) {
                Toast toast = c;
                if (toast == null) {
                    c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    c.setText(string);
                    c.setDuration(0);
                }
                c.show();
            } else if (i2 == 1) {
                Toast toast2 = c;
                if (toast2 == null) {
                    c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    c.setText(string);
                    c.setDuration(1);
                }
                c.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
