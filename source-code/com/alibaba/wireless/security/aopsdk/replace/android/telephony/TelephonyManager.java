package com.alibaba.wireless.security.aopsdk.replace.android.telephony;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.util.List;

public class TelephonyManager {
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
    public static List getAllCellInfo(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getAllCellInfo();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getAllCellInfo, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(allCellInfo);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (List) bridge.resultBridge(invocation);
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        List<CellInfo> allCellInfo2 = telephonyManager.getAllCellInfo();
        if (!bridge.getTp()) {
            return allCellInfo2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return allCellInfo2;
    }

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
    public static CellLocation getCellLocation(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getCellLocation();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getCellLocation, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(cellLocation);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (CellLocation) bridge.resultBridge(invocation);
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        CellLocation cellLocation2 = telephonyManager.getCellLocation();
        if (!bridge.getTp()) {
            return cellLocation2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return cellLocation2;
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
    public static int getDataNetworkType(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getDataNetworkType();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getDataNetworkType, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    int dataNetworkType = telephonyManager.getDataNetworkType();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(dataNetworkType));
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
        int dataNetworkType2 = telephonyManager.getDataNetworkType();
        if (!bridge.getTp()) {
            return dataNetworkType2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return dataNetworkType2;
    }

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
    public static String getDeviceId(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getDeviceId();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getDeviceId, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String deviceId = telephonyManager.getDeviceId();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(deviceId);
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
        String deviceId2 = telephonyManager.getDeviceId();
        if (!bridge.getTp()) {
            return deviceId2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return deviceId2;
    }

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
    public static String getImei(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getImei();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getImei, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String imei = telephonyManager.getImei();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(imei);
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
        String imei2 = telephonyManager.getImei();
        if (!bridge.getTp()) {
            return imei2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return imei2;
    }

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
    public static String getMeid(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getMeid();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getMeid, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String meid = telephonyManager.getMeid();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(meid);
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
        String meid2 = telephonyManager.getMeid();
        if (!bridge.getTp()) {
            return meid2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return meid2;
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
    public static int getNetworkType(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getNetworkType();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getNetworkType, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    int networkType = telephonyManager.getNetworkType();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(networkType));
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
        int networkType2 = telephonyManager.getNetworkType();
        if (!bridge.getTp()) {
            return networkType2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return networkType2;
    }

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
    public static String getSimOperator(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getSimOperator();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getSimOperator, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String simOperator = telephonyManager.getSimOperator();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(simOperator);
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
        String simOperator2 = telephonyManager.getSimOperator();
        if (!bridge.getTp()) {
            return simOperator2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return simOperator2;
    }

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
    public static String getSimOperatorName(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getSimOperatorName();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getSimOperatorName, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String simOperatorName = telephonyManager.getSimOperatorName();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(simOperatorName);
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
        String simOperatorName2 = telephonyManager.getSimOperatorName();
        if (!bridge.getTp()) {
            return simOperatorName2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return simOperatorName2;
    }

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
    public static String getSimSerialNumber(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getSimSerialNumber();
        }
        Invocation invocation = new Invocation("android.telephony.TelephonyManager.getSimSerialNumber()", telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String simSerialNumber = telephonyManager.getSimSerialNumber();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(simSerialNumber);
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
        String simSerialNumber2 = telephonyManager.getSimSerialNumber();
        if (!bridge.getTp()) {
            return simSerialNumber2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return simSerialNumber2;
    }

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
    public static String getSubscriberId(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getSubscriberId();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getSubscriberId, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String subscriberId = telephonyManager.getSubscriberId();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(subscriberId);
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
        String subscriberId2 = telephonyManager.getSubscriberId();
        if (!bridge.getTp()) {
            return subscriberId2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return subscriberId2;
    }

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
    public static String getDeviceId(android.telephony.TelephonyManager telephonyManager, int i) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getDeviceId(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getDeviceId_int, telephonyManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String deviceId = telephonyManager.getDeviceId(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(deviceId);
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
        String deviceId2 = telephonyManager.getDeviceId(i);
        if (!bridge.getTp()) {
            return deviceId2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return deviceId2;
    }

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
    public static String getImei(android.telephony.TelephonyManager telephonyManager, int i) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getImei(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getImei_int, telephonyManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String imei = telephonyManager.getImei(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(imei);
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
        String imei2 = telephonyManager.getImei(i);
        if (!bridge.getTp()) {
            return imei2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return imei2;
    }

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
    public static String getMeid(android.telephony.TelephonyManager telephonyManager, int i) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getMeid(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getMeid_int, telephonyManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String meid = telephonyManager.getMeid(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(meid);
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
        String meid2 = telephonyManager.getMeid(i);
        if (!bridge.getTp()) {
            return meid2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return meid2;
    }
}
