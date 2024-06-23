package com.alibaba.wireless.security.aopsdk.replace.android.os;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class SystemProperties {
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
    public static String get(String str) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.SystemProperties.get(str);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.SystemProperties_get_String, null, str);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    if (bridge.getTp()) {
                        j = System.nanoTime();
                    }
                    String str3 = android.os.SystemProperties.get(str2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
                    }
                    invocation.setResult(str3);
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
        String str4 = android.os.SystemProperties.get(str);
        if (!bridge.getTp()) {
            return str4;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return str4;
    }
}
