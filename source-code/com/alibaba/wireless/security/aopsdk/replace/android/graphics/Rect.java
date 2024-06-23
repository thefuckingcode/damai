package com.alibaba.wireless.security.aopsdk.replace.android.graphics;

import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class Rect {
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009d, code lost:
        if (r5.getTp() != false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009f, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        throw r0;
     */
    public static int height(android.graphics.Rect rect) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return rect.height();
        }
        Invocation invocation = new Invocation("android.graphics.Rect.height()", rect, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    int height = rect.height();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(height));
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
        int height2 = rect.height();
        if (!bridge.getTp()) {
            return height2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return height2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009d, code lost:
        if (r5.getTp() != false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009f, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        throw r0;
     */
    public static int width(android.graphics.Rect rect) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return rect.width();
        }
        Invocation invocation = new Invocation("android.graphics.Rect.width()", rect, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    int width = rect.width();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(width));
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
        int width2 = rect.width();
        if (!bridge.getTp()) {
            return width2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return width2;
    }
}
