package com.alibaba.wireless.security.aopsdk.replace.android.graphics;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class Point {
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
    public static int getx(android.graphics.Point point) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return point.x;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Point_getx, point, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    int i = point.x;
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
        int i2 = point.x;
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
    public static int gety(android.graphics.Point point) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return point.y;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Point_gety, point, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    int i = point.y;
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
        int i2 = point.y;
        if (!bridge.getTp()) {
            return i2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return i2;
    }
}
