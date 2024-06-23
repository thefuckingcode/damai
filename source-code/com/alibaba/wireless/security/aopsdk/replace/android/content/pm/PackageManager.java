package com.alibaba.wireless.security.aopsdk.replace.android.content.pm;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.util.List;

public class PackageManager {
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
    public static List getInstalledApplications(android.content.pm.PackageManager packageManager, int i) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return packageManager.getInstalledApplications(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.PackageManager_getInstalledApplications_int, packageManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(argI);
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
        List<ApplicationInfo> installedApplications2 = packageManager.getInstalledApplications(i);
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
    public static List getInstalledPackages(android.content.pm.PackageManager packageManager, int i) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return packageManager.getInstalledPackages(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.PackageManager_getInstalledPackages_int, packageManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    List<PackageInfo> installedPackages = packageManager.getInstalledPackages(argI);
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
        List<PackageInfo> installedPackages2 = packageManager.getInstalledPackages(i);
        if (!bridge.getTp()) {
            return installedPackages2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return installedPackages2;
    }
}
