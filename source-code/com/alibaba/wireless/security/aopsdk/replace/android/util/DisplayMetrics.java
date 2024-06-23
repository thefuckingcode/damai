package com.alibaba.wireless.security.aopsdk.replace.android.util;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class DisplayMetrics {
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        if (r5.getTp() != false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0099, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a5, code lost:
        throw r0;
     */
    public static int getheightPixels(android.util.DisplayMetrics displayMetrics) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return displayMetrics.heightPixels;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.DisplayMetrics_getheightPixels, displayMetrics, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    int i = displayMetrics.heightPixels;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(i));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Integer) bridge.resultBridge(invocation)).intValue();
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        int i2 = displayMetrics.heightPixels;
        if (!bridge.getTp()) {
            return i2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        if (r5.getTp() != false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0099, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a5, code lost:
        throw r0;
     */
    public static int getwidthPixels(android.util.DisplayMetrics displayMetrics) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return displayMetrics.widthPixels;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.DisplayMetrics_getwidthPixels, displayMetrics, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    int i = displayMetrics.widthPixels;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(i));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Integer) bridge.resultBridge(invocation)).intValue();
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        int i2 = displayMetrics.widthPixels;
        if (!bridge.getTp()) {
            return i2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return i2;
    }
}
