package com.alibaba.wireless.security.aopsdk.replace.android.location;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class Location {
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
    public static double getAltitude(android.location.Location location) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return location.getAltitude();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Location_getAltitude, location, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    double altitude = location.getAltitude();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(Double.valueOf(altitude));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Double) bridge.resultBridge(invocation)).doubleValue();
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        double altitude2 = location.getAltitude();
        if (!bridge.getTp()) {
            return altitude2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return altitude2;
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
    public static double getLatitude(android.location.Location location) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return location.getLatitude();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Location_getLatitude, location, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    double latitude = location.getLatitude();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(Double.valueOf(latitude));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Double) bridge.resultBridge(invocation)).doubleValue();
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        double latitude2 = location.getLatitude();
        if (!bridge.getTp()) {
            return latitude2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return latitude2;
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
    public static double getLongitude(android.location.Location location) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return location.getLongitude();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Location_getLongitude, location, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    double longitude = location.getLongitude();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(Double.valueOf(longitude));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Double) bridge.resultBridge(invocation)).doubleValue();
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        double longitude2 = location.getLongitude();
        if (!bridge.getTp()) {
            return longitude2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return longitude2;
    }
}
