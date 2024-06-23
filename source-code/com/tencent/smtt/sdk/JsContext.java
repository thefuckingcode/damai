package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

public final class JsContext {
    private final JsVirtualMachine a;
    private final IX5JsContext b;
    private ExceptionHandler c;
    private String d;

    public interface ExceptionHandler {
        void handleException(JsContext jsContext, JsError jsError);
    }

    public JsContext(Context context) {
        this(new JsVirtualMachine(context));
    }

    public JsContext(JsVirtualMachine jsVirtualMachine) {
        if (jsVirtualMachine != null) {
            this.a = jsVirtualMachine;
            IX5JsContext a2 = jsVirtualMachine.a();
            this.b = a2;
            try {
                a2.setPerContextData(this);
            } catch (AbstractMethodError unused) {
            }
        } else {
            throw new IllegalArgumentException("The virtualMachine value can not be null");
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        this.b.addJavascriptInterface(obj, str);
    }

    public void destroy() {
        this.b.destroy();
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback, null);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        this.b.evaluateJavascript(str, valueCallback, url);
    }

    public JsValue evaluateScript(String str) {
        return evaluateScript(str, null);
    }

    public JsValue evaluateScript(String str, URL url) {
        IX5JsValue evaluateScript = this.b.evaluateScript(str, url);
        if (evaluateScript == null) {
            return null;
        }
        return new JsValue(this, evaluateScript);
    }

    public void evaluateScriptAsync(String str, final ValueCallback<JsValue> valueCallback, URL url) {
        this.b.evaluateScriptAsync(str, valueCallback == null ? null : new ValueCallback<IX5JsValue>() {
            /* class com.tencent.smtt.sdk.JsContext.AnonymousClass1 */

            /* renamed from: a */
            public void onReceiveValue(IX5JsValue iX5JsValue) {
                valueCallback.onReceiveValue(iX5JsValue == null ? null : new JsValue(JsContext.this, iX5JsValue));
            }
        }, url);
    }

    public ExceptionHandler exceptionHandler() {
        return this.c;
    }

    public String name() {
        return this.d;
    }

    public void removeJavascriptInterface(String str) {
        this.b.removeJavascriptInterface(str);
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler) {
        this.c = exceptionHandler;
        if (exceptionHandler == null) {
            this.b.setExceptionHandler(null);
        } else {
            this.b.setExceptionHandler(new ValueCallback<IX5JsError>() {
                /* class com.tencent.smtt.sdk.JsContext.AnonymousClass2 */

                /* renamed from: a */
                public void onReceiveValue(IX5JsError iX5JsError) {
                    JsContext.this.c.handleException(JsContext.this, new JsError(iX5JsError));
                }
            });
        }
    }

    public void setName(String str) {
        this.d = str;
        this.b.setName(str);
    }

    public void stealValueFromOtherCtx(String str, JsContext jsContext, String str2) {
        this.b.stealValueFromOtherCtx(str, jsContext.b, str2);
    }

    public int getNativeBufferId() {
        return this.b.getNativeBufferId();
    }

    public byte[] getNativeBuffer(int i) {
        return this.b.getNativeBuffer(i);
    }

    public int setNativeBuffer(int i, byte[] bArr) {
        return this.b.setNativeBuffer(i, bArr);
    }

    public JsVirtualMachine virtualMachine() {
        return this.a;
    }

    public static JsContext current() {
        return (JsContext) X5JsCore.a();
    }
}
