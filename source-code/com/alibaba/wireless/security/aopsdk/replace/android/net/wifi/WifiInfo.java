package com.alibaba.wireless.security.aopsdk.replace.android.net.wifi;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class WifiInfo {
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        if (r5.getTp() != false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a2, code lost:
        throw r0;
     */
    public static String getMacAddress(android.net.wifi.WifiInfo wifiInfo) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return wifiInfo.getMacAddress();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.WifiInfo_getMacAddress, wifiInfo, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String macAddress = wifiInfo.getMacAddress();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(macAddress);
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
        } else {
            j = 0;
        }
        String macAddress2 = wifiInfo.getMacAddress();
        if (!bridge.getTp()) {
            return macAddress2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return macAddress2;
    }
}
