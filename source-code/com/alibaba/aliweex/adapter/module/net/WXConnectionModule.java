package com.alibaba.aliweex.adapter.module.net;

import androidx.annotation.VisibleForTesting;
import com.alibaba.aliweex.adapter.module.net.IWXConnection;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Map;

/* compiled from: Taobao */
public class WXConnectionModule extends WXSDKEngine.DestroyableModule {
    private static final String EVENT_CONNECTION_CHANGE = "change";
    private static final String TAG = "WXConnectionModule";
    private IWXConnection mWXConnectionImpl;

    /* compiled from: Taobao */
    class a implements IWXConnection.OnNetworkChangeListener {
        a() {
        }

        @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection.OnNetworkChangeListener
        public void onNetworkChange() {
            WXConnectionModule wXConnectionModule = WXConnectionModule.this;
            WXSDKInstance wXSDKInstance = wXConnectionModule.mWXSDKInstance;
            if (wXSDKInstance != null) {
                if (wXSDKInstance.checkModuleEventRegistered("change", wXConnectionModule)) {
                    WXConnectionModule wXConnectionModule2 = WXConnectionModule.this;
                    wXConnectionModule2.mWXSDKInstance.fireModuleEvent("change", wXConnectionModule2, null);
                    WXLogUtils.d(WXConnectionModule.TAG, "send connection change event success.");
                    return;
                }
                WXLogUtils.d(WXConnectionModule.TAG, "no listener found. drop the connection change event.");
            }
        }
    }

    private boolean createWXConnectionImpl() {
        if (this.mWXConnectionImpl != null) {
            return true;
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || wXSDKInstance.getContext() == null) {
            return false;
        }
        IWXConnection a2 = a.a(this.mWXSDKInstance.getContext());
        this.mWXConnectionImpl = a2;
        if (a2 != null) {
            return true;
        }
        return false;
    }

    @Override // com.taobao.weex.common.WXModule
    @JSMethod
    public void addEventListener(String str, String str2, Map<String, Object> map) {
        super.addEventListener(str, str2, map);
        if (createWXConnectionImpl()) {
            this.mWXConnectionImpl.addNetworkChangeListener(new a());
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.e(TAG, "addListener failed because of context or instance been destroyed.");
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IWXConnection iWXConnection = this.mWXConnectionImpl;
        if (iWXConnection != null) {
            iWXConnection.destroy();
            this.mWXConnectionImpl = null;
        }
    }

    @JSMethod(uiThread = false)
    public double getDownlinkMax() {
        if (createWXConnectionImpl()) {
            return this.mWXConnectionImpl.getDownlinkMax();
        }
        if (!WXEnvironment.isApkDebugable()) {
            return 0.0d;
        }
        WXLogUtils.e(TAG, "getDownlinkMax failed because of context or instance been destroyed.");
        return 0.0d;
    }

    @JSMethod(uiThread = false)
    public String getNetworkType() {
        if (createWXConnectionImpl()) {
            return this.mWXConnectionImpl.getNetworkType();
        }
        if (!WXEnvironment.isApkDebugable()) {
            return "unknown";
        }
        WXLogUtils.e(TAG, "getNetworkType failed because of context or instance been destroyed.");
        return "unknown";
    }

    @JSMethod(uiThread = false)
    public String getType() {
        if (createWXConnectionImpl()) {
            return this.mWXConnectionImpl.getType();
        }
        if (!WXEnvironment.isApkDebugable()) {
            return "none";
        }
        WXLogUtils.e(TAG, "getType failed because of context or instance been destroyed.");
        return "none";
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setConnectionImpl(IWXConnection iWXConnection) {
        this.mWXConnectionImpl = iWXConnection;
    }
}
