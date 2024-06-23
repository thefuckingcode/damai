package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class JNIBridgeModuleHelper {
    private static BridgeModuleListener moduleListener;

    private static long callAsync(long j, long j2, String str) {
        BridgeModuleListener bridgeModuleListener = moduleListener;
        if (bridgeModuleListener != null) {
            return bridgeModuleListener.callAsync(j, j2, str);
        }
        return -1;
    }

    private static long callPromise(long j, String str) {
        BridgeModuleListener bridgeModuleListener = moduleListener;
        if (bridgeModuleListener != null) {
            return bridgeModuleListener.callPromise(j, str);
        }
        return -1;
    }

    private static long callSync(long j, String str) {
        BridgeModuleListener bridgeModuleListener = moduleListener;
        if (bridgeModuleListener != null) {
            return bridgeModuleListener.callSync(j, str);
        }
        return -1;
    }

    public static void setListener(BridgeModuleListener bridgeModuleListener) {
        moduleListener = bridgeModuleListener;
    }

    public static void wrapAsJSValueException(Exception exc) {
        BridgeModuleListener bridgeModuleListener = moduleListener;
        if (bridgeModuleListener != null) {
            bridgeModuleListener.wrapAsJSValueException(exc);
        }
    }
}
