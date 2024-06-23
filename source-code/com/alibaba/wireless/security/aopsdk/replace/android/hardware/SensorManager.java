package com.alibaba.wireless.security.aopsdk.replace.android.hardware;

import android.hardware.Sensor;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class SensorManager {
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a1, code lost:
        if (r5.getTp() != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a3, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
        throw r0;
     */
    public static Sensor getDefaultSensor(android.hardware.SensorManager sensorManager, int i) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return sensorManager.getDefaultSensor(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.SensorManager_getDefaultSensor_int, sensorManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    Sensor defaultSensor = sensorManager.getDefaultSensor(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(defaultSensor);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (Sensor) bridge.resultBridge(invocation);
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(i);
        if (!bridge.getTp()) {
            return defaultSensor2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return defaultSensor2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ad, code lost:
        if (r5.getTp() != false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00af, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bb, code lost:
        throw r0;
     */
    public static Sensor getDefaultSensor(android.hardware.SensorManager sensorManager, int i, boolean z) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return sensorManager.getDefaultSensor(i, z);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.SensorManager_getDefaultSensor_int_boolean, sensorManager, Integer.valueOf(i), Boolean.valueOf(z));
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    boolean argZ = invocation.getArgZ(1);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    Sensor defaultSensor = sensorManager.getDefaultSensor(argI, argZ);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(defaultSensor);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (Sensor) bridge.resultBridge(invocation);
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(i, z);
        if (!bridge.getTp()) {
            return defaultSensor2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return defaultSensor2;
    }
}
