package com.alibaba.wireless.security.aopsdk.replace.android.app;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.util.List;

public class ApplicationPackageManager {
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
    public static List getInstalledApplications(android.app.ApplicationPackageManager applicationPackageManager, int i) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return applicationPackageManager.getInstalledApplications(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.ApplicationPackageManager_getInstalledApplications_int, applicationPackageManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    List installedApplications = applicationPackageManager.getInstalledApplications(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(installedApplications);
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
        List installedApplications2 = applicationPackageManager.getInstalledApplications(i);
        if (!bridge.getTp()) {
            return installedApplications2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return installedApplications2;
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
    public static List getInstalledPackages(android.app.ApplicationPackageManager applicationPackageManager, int i) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return applicationPackageManager.getInstalledPackages(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.ApplicationPackageManager_getInstalledPackages_int, applicationPackageManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    List installedPackages = applicationPackageManager.getInstalledPackages(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(installedPackages);
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
        List installedPackages2 = applicationPackageManager.getInstalledPackages(i);
        if (!bridge.getTp()) {
            return installedPackages2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return installedPackages2;
    }
}
