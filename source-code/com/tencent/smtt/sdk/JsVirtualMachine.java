package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine {
    private final Context a;
    private final IX5JsVirtualMachine b;
    private final HashSet<WeakReference<a>> c;

    /* access modifiers changed from: private */
    public static class a implements IX5JsContext {
        private WebView a;

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public byte[] getNativeBuffer(int i) {
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int getNativeBufferId() {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setExceptionHandler(ValueCallback<IX5JsError> valueCallback) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setName(String str) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int setNativeBuffer(int i, byte[] bArr) {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setPerContextData(Object obj) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
        }

        public a(Context context) {
            WebView webView = new WebView(context);
            this.a = webView;
            webView.getSettings().setJavaScriptEnabled(true);
        }

        public void a() {
            WebView webView = this.a;
            if (webView != null) {
                webView.onPause();
            }
        }

        public void b() {
            WebView webView = this.a;
            if (webView != null) {
                webView.onResume();
            }
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void addJavascriptInterface(Object obj, String str) {
            WebView webView = this.a;
            if (webView != null) {
                webView.addJavascriptInterface(obj, str);
                this.a.loadUrl("about:blank");
            }
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void destroy() {
            WebView webView = this.a;
            if (webView != null) {
                webView.clearHistory();
                this.a.clearCache(true);
                this.a.loadUrl("about:blank");
                this.a.freeMemory();
                this.a.pauseTimers();
                this.a.destroy();
                this.a = null;
            }
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateJavascript(String str, final ValueCallback<String> valueCallback, URL url) {
            AnonymousClass1 r3;
            WebView webView = this.a;
            if (webView != null) {
                if (valueCallback == null) {
                    r3 = null;
                } else {
                    r3 = new ValueCallback<String>() {
                        /* class com.tencent.smtt.sdk.JsVirtualMachine.a.AnonymousClass1 */

                        /* renamed from: a */
                        public void onReceiveValue(String str) {
                            valueCallback.onReceiveValue(str);
                        }
                    };
                }
                webView.evaluateJavascript(str, r3);
            }
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public IX5JsValue evaluateScript(String str, URL url) {
            WebView webView = this.a;
            if (webView == null) {
                return null;
            }
            webView.evaluateJavascript(str, null);
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateScriptAsync(String str, final ValueCallback<IX5JsValue> valueCallback, URL url) {
            AnonymousClass2 r3;
            WebView webView = this.a;
            if (webView != null) {
                if (valueCallback == null) {
                    r3 = null;
                } else {
                    r3 = new ValueCallback<String>() {
                        /* class com.tencent.smtt.sdk.JsVirtualMachine.a.AnonymousClass2 */

                        /* renamed from: a */
                        public void onReceiveValue(String str) {
                            valueCallback.onReceiveValue(null);
                        }
                    };
                }
                webView.evaluateJavascript(str, r3);
            }
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void removeJavascriptInterface(String str) {
            WebView webView = this.a;
            if (webView != null) {
                webView.removeJavascriptInterface(str);
            }
        }
    }

    public JsVirtualMachine(Context context) {
        this(context, null);
    }

    public JsVirtualMachine(Context context, Looper looper) {
        this.c = new HashSet<>();
        this.a = context;
        this.b = X5JsCore.a(context, looper);
    }

    public boolean isFallback() {
        return this.b == null;
    }

    /* access modifiers changed from: protected */
    public IX5JsContext a() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            return iX5JsVirtualMachine.createJsContext();
        }
        a aVar = new a(this.a);
        this.c.add(new WeakReference<>(aVar));
        return aVar;
    }

    public void destroy() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.destroy();
            return;
        }
        Iterator<WeakReference<a>> it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() != null) {
                next.get().destroy();
            }
        }
    }

    public Looper getLooper() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            return iX5JsVirtualMachine.getLooper();
        }
        return Looper.myLooper();
    }

    public void onPause() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onPause();
            return;
        }
        Iterator<WeakReference<a>> it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() != null) {
                next.get().a();
            }
        }
    }

    public void onResume() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onResume();
            return;
        }
        Iterator<WeakReference<a>> it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() != null) {
                next.get().b();
            }
        }
    }
}
