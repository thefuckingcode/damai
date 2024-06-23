package com.taobao.weex.bridge;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.base.CalledByNative;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.c;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.Locale;
import tb.jx2;

/* compiled from: Taobao */
public class RequestHandler {

    /* compiled from: Taobao */
    class OnHttpListenerInner extends c {
        private long sNativeCallback;

        OnHttpListenerInner(WXSDKInstance wXSDKInstance, long j, String str) {
            super(wXSDKInstance, str);
            this.sNativeCallback = j;
        }

        @Override // com.taobao.weex.c
        public void onFail(WXResponse wXResponse) {
            RequestHandler.this.nativeInvokeOnFailed(this.sNativeCallback);
        }

        @Override // com.taobao.weex.c
        public void onSuccess(WXResponse wXResponse) {
            final String str;
            final String str2 = new String(wXResponse.originalData);
            WXBridgeManager.BundType bundleType = WXBridgeManager.getInstance().getBundleType("", str2);
            if (bundleType == null) {
                str = "Others";
            } else {
                str = bundleType.toString();
            }
            if ("Others".equalsIgnoreCase(str) && getInstance() != null) {
                String instanceId = getInstance().getInstanceId();
                WXErrorCode wXErrorCode = WXErrorCode.WX_KEY_EXCEPTION_NO_BUNDLE_TYPE;
                WXExceptionUtils.commitCriticalExceptionRT(instanceId, wXErrorCode, "RequestHandler.onSuccess", "eagle ->" + wXErrorCode.getErrorMsg(), null);
            }
            WXBridgeManager.getInstance().post(new Runnable() {
                /* class com.taobao.weex.bridge.RequestHandler.OnHttpListenerInner.AnonymousClass1 */

                public void run() {
                    if (WXBridgeManager.getInstance().isJSFrameworkInit()) {
                        OnHttpListenerInner onHttpListenerInner = OnHttpListenerInner.this;
                        RequestHandler.this.nativeInvokeOnSuccess(onHttpListenerInner.sNativeCallback, str2, str);
                        return;
                    }
                    OnHttpListenerInner onHttpListenerInner2 = OnHttpListenerInner.this;
                    RequestHandler.this.nativeInvokeOnFailed(onHttpListenerInner2.sNativeCallback);
                }
            });
        }
    }

    @CalledByNative
    public static RequestHandler create() {
        return new RequestHandler();
    }

    @Keep
    @CalledByNative
    public void getBundleType(String str, final String str2, final long j) {
        final String str3;
        WXBridgeManager.BundType bundleType = WXBridgeManager.getInstance().getBundleType("", str2);
        if (bundleType == null) {
            str3 = "Others";
        } else {
            str3 = bundleType.toString();
        }
        WXSDKInstance y = WXSDKManager.v().y(str);
        if ("Others".equalsIgnoreCase(str3) && y != null) {
            WXErrorCode wXErrorCode = WXErrorCode.WX_KEY_EXCEPTION_NO_BUNDLE_TYPE;
            WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, "RequestHandler.onSuccess", "eagle ->" + wXErrorCode.getErrorMsg(), null);
        }
        WXBridgeManager.getInstance().post(new Runnable() {
            /* class com.taobao.weex.bridge.RequestHandler.AnonymousClass1 */

            public void run() {
                if (WXBridgeManager.getInstance().isJSFrameworkInit()) {
                    RequestHandler.this.nativeInvokeOnSuccess(j, str2, str3);
                } else {
                    RequestHandler.this.nativeInvokeOnFailed(j);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public native void nativeInvokeOnFailed(long j);

    /* access modifiers changed from: package-private */
    @Keep
    public native void nativeInvokeOnSuccess(long j, String str, String str2);

    @CalledByNative
    public void send(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j != 0 && WXSDKManager.v().i().containsKey(str)) {
            WXSDKManager v = WXSDKManager.v();
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y != null) {
                IWXHttpAdapter n = WXSDKManager.v().n();
                WXRequest wXRequest = new WXRequest();
                wXRequest.url = v.A().rewrite(y, "bundle", Uri.parse(str2)).toString();
                if (wXRequest.paramMap == null) {
                    wXRequest.paramMap = new HashMap();
                }
                wXRequest.paramMap.put("user-agent", jx2.a(y.getContext(), WXEnvironment.getConfig()));
                wXRequest.paramMap.put("isBundleRequest", "true");
                WXLogUtils.i("Eagle", String.format(Locale.ENGLISH, "Weex eagle is going to download script from %s", str2));
                n.sendRequest(wXRequest, new OnHttpListenerInner(y, j, str2));
            }
        }
    }
}
