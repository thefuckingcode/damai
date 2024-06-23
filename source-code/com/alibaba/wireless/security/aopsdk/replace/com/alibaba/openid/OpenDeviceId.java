package com.alibaba.wireless.security.aopsdk.replace.com.alibaba.openid;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class OpenDeviceId {
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        if (r5.getTp() != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a2, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ae, code lost:
        throw r0;
     */
    public static String getOAID(Context context) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return com.alibaba.openid.OpenDeviceId.getOAID(context);
        }
        Invocation invocation = new Invocation("com.alibaba.openid.OpenDeviceId.getOAID(android.content.Context)", null, context);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Context context2 = (Context) invocation.getArgL(0);
                    if (bridge.getTp()) {
                        j = System.nanoTime();
                    }
                    String oaid = com.alibaba.openid.OpenDeviceId.getOAID(context2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
                    }
                    invocation.setResult(oaid);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (String) bridge.resultBridge(invocation);
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        }
        String oaid2 = com.alibaba.openid.OpenDeviceId.getOAID(context);
        if (!bridge.getTp()) {
            return oaid2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return oaid2;
    }
}
