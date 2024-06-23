package com.alibaba.wireless.security.aopsdk.replace.android.view;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class Display {
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0093, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0098, code lost:
        if (r5.getTp() != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009a, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a6, code lost:
        throw r2;
     */
    public static void getMetrics(android.view.Display display, DisplayMetrics displayMetrics) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            display.getMetrics(displayMetrics);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Display_getMetrics_DisplayMetrics, display, displayMetrics);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    DisplayMetrics displayMetrics2 = (DisplayMetrics) invocation.getArgL(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    display.getMetrics(displayMetrics2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        display.getMetrics(displayMetrics);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0093, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0098, code lost:
        if (r5.getTp() != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009a, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a6, code lost:
        throw r2;
     */
    public static void getRealMetrics(android.view.Display display, DisplayMetrics displayMetrics) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            display.getRealMetrics(displayMetrics);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Display_getRealMetrics_DisplayMetrics, display, displayMetrics);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    DisplayMetrics displayMetrics2 = (DisplayMetrics) invocation.getArgL(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    display.getRealMetrics(displayMetrics2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        display.getRealMetrics(displayMetrics);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0093, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0098, code lost:
        if (r5.getTp() != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009a, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a6, code lost:
        throw r2;
     */
    public static void getRealSize(android.view.Display display, Point point) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            display.getRealSize(point);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Display_getRealSize_Point, display, point);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Point point2 = (Point) invocation.getArgL(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    display.getRealSize(point2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        display.getRealSize(point);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0093, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0098, code lost:
        if (r5.getTp() != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009a, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r0) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a6, code lost:
        throw r2;
     */
    public static void getSize(android.view.Display display, Point point) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            display.getSize(point);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Display_getSize_Point, display, point);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Point point2 = (Point) invocation.getArgL(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    display.getSize(point2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        display.getSize(point);
        if (bridge.getTp()) {
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
        }
    }
}
