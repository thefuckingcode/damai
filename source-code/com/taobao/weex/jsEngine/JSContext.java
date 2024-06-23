package com.taobao.weex.jsEngine;

import com.taobao.weex.base.CalledByNative;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.utils.WXLogUtils;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class JSContext implements Serializable {
    private ConcurrentHashMap<String, JSFunction> funcMap = new ConcurrentHashMap<>();
    private JSException mExceptionTransfer = null;
    private long mNativeContextPtr = 0;

    protected JSContext() {
        WXBridgeManager.getInstance().post(new Runnable() {
            /* class com.taobao.weex.jsEngine.JSContext.AnonymousClass1 */

            public void run() {
                JSContext jSContext = JSContext.this;
                jSContext.mNativeContextPtr = jSContext.nativeCreateContext();
                JSEngine.mCreatedJSContext.put(Long.valueOf(JSContext.this.mNativeContextPtr), JSContext.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeBindFunc(long j, String str);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native long nativeCreateContext();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeDestroyContext(long j);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeExecJS(long j, String str);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeUnBindFunc(long j, String str);

    public void Eval(final String str) {
        WXBridgeManager.getInstance().post(new Runnable() {
            /* class com.taobao.weex.jsEngine.JSContext.AnonymousClass5 */

            public void run() {
                JSContext jSContext = JSContext.this;
                jSContext.nativeExecJS(jSContext.mNativeContextPtr, str);
            }
        });
    }

    @CalledByNative
    public void Exception(String str) {
        JSException jSException;
        if (str != null && (jSException = this.mExceptionTransfer) != null) {
            jSException.exception(str);
        }
    }

    @CalledByNative
    public String Invoke(String str, String str2) {
        JSFunction jSFunction = this.funcMap.get(str);
        if (jSFunction == null) {
            return "";
        }
        WXLogUtils.d("jsEngine invoke " + str + " arg:" + str2);
        return jSFunction.invoke(str2);
    }

    public void bindFunction(final String str, final JSFunction jSFunction) {
        WXBridgeManager.getInstance().post(new Runnable() {
            /* class com.taobao.weex.jsEngine.JSContext.AnonymousClass3 */

            public void run() {
                JSContext.this.funcMap.put(str, jSFunction);
                JSContext jSContext = JSContext.this;
                jSContext.nativeBindFunc(jSContext.mNativeContextPtr, str);
            }
        });
    }

    public void destroy() {
        JSEngine.mCreatedJSContext.remove(Long.valueOf(this.mNativeContextPtr));
        this.mExceptionTransfer = null;
        WXBridgeManager.getInstance().post(new Runnable() {
            /* class com.taobao.weex.jsEngine.JSContext.AnonymousClass2 */

            public void run() {
                if (JSContext.this.mNativeContextPtr != 0) {
                    long j = JSContext.this.mNativeContextPtr;
                    JSContext.this.mNativeContextPtr = 0;
                    JSContext.this.nativeDestroyContext(j);
                }
            }
        });
    }

    public void registerException(JSException jSException) {
        this.mExceptionTransfer = jSException;
    }

    public void unBindFunction(final String str) {
        WXBridgeManager.getInstance().post(new Runnable() {
            /* class com.taobao.weex.jsEngine.JSContext.AnonymousClass4 */

            public void run() {
                JSContext.this.funcMap.remove(str);
                JSContext jSContext = JSContext.this;
                jSContext.nativeUnBindFunc(jSContext.mNativeContextPtr, str);
            }
        });
    }
}
