package com.alibaba.wireless.security.aopsdk.replace.android.os;

import android.os.Build;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class Build {

    public static class VERSION {
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
            if (r5.getTp() != false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
            r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
            r5.reportTimeCost(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
            throw r0;
         */
        public static String getRELEASE() throws Throwable {
            long j;
            if (!ConfigManager.getInstance().isEnabled()) {
                return Build.VERSION.RELEASE;
            }
            Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_VERSION_getRELEASE, null, new Object[0]);
            AopBridge bridge = AopManager.getInstance().getBridge();
            long j2 = 0;
            if (bridge.callBeforeBridge(invocation)) {
                if (!invocation.shouldBlock()) {
                    try {
                        if (bridge.getTp()) {
                            j2 = System.nanoTime();
                        }
                        String str = Build.VERSION.RELEASE;
                        if (bridge.getTp()) {
                            invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                        }
                        invocation.setResult(str);
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
            String str2 = Build.VERSION.RELEASE;
            if (!bridge.getTp()) {
                return str2;
            }
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
            return str2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
            if (r5.getTp() != false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
            r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
            r5.reportTimeCost(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
            throw r0;
         */
        public static String getRELEASE_OR_CODENAME() throws Throwable {
            long j;
            if (!ConfigManager.getInstance().isEnabled()) {
                return Build.VERSION.RELEASE_OR_CODENAME;
            }
            Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_VERSION_getRELEASE_OR_CODENAME, null, new Object[0]);
            AopBridge bridge = AopManager.getInstance().getBridge();
            long j2 = 0;
            if (bridge.callBeforeBridge(invocation)) {
                if (!invocation.shouldBlock()) {
                    try {
                        if (bridge.getTp()) {
                            j2 = System.nanoTime();
                        }
                        String str = Build.VERSION.RELEASE_OR_CODENAME;
                        if (bridge.getTp()) {
                            invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                        }
                        invocation.setResult(str);
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
            String str2 = Build.VERSION.RELEASE_OR_CODENAME;
            if (!bridge.getTp()) {
                return str2;
            }
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
            return str2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r5.getTp() != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        throw r0;
     */
    public static String getBRAND() throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.BRAND;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getBRAND, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String str = android.os.Build.BRAND;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(str);
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
        String str2 = android.os.Build.BRAND;
        if (!bridge.getTp()) {
            return str2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r5.getTp() != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        throw r0;
     */
    public static String getCPU_ABI() throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.CPU_ABI;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getCPU_ABI, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String str = android.os.Build.CPU_ABI;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(str);
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
        String str2 = android.os.Build.CPU_ABI;
        if (!bridge.getTp()) {
            return str2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r5.getTp() != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        throw r0;
     */
    public static String getMANUFACTURER() throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.MANUFACTURER;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getMANUFACTURER, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String str = android.os.Build.MANUFACTURER;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(str);
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
        String str2 = android.os.Build.MANUFACTURER;
        if (!bridge.getTp()) {
            return str2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r5.getTp() != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        throw r0;
     */
    public static String getMODEL() throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.MODEL;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getMODEL, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String str = android.os.Build.MODEL;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(str);
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
        String str2 = android.os.Build.MODEL;
        if (!bridge.getTp()) {
            return str2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r5.getTp() != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        throw r0;
     */
    public static String getPRODUCT() throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.PRODUCT;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getPRODUCT, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String str = android.os.Build.PRODUCT;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(str);
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
        String str2 = android.os.Build.PRODUCT;
        if (!bridge.getTp()) {
            return str2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r5.getTp() != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        throw r0;
     */
    public static String getSERIAL() throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.SERIAL;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getSERIAL, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String str = android.os.Build.SERIAL;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(str);
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
        String str2 = android.os.Build.SERIAL;
        if (!bridge.getTp()) {
            return str2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0096, code lost:
        if (r5.getTp() != false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0098, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        throw r0;
     */
    public static String getSerial() throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.getSerial();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Build_getSerial, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    String serial = android.os.Build.getSerial();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(serial);
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
        String serial2 = android.os.Build.getSerial();
        if (!bridge.getTp()) {
            return serial2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return serial2;
    }
}
