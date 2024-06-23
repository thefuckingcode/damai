package com.alibaba.wireless.security.aopsdk.replace.com.google.android.gms.ads.identifier;

import android.content.Context;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class AdvertisingIdClient {
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        if (r5.getTp() != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a2, code lost:
        r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
        r5.reportTimeCost(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ae, code lost:
        throw r0;
     */
    public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context context) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(context);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.AdvertisingIdClient_getAdvertisingIdInfo_Context, null, context);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Context context2 = (Context) invocation.getArgL(0);
                    if (bridge.getTp()) {
                        j = System.nanoTime();
                    }
                    AdvertisingIdClient.Info advertisingIdInfo = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(context2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
                    }
                    invocation.setResult(advertisingIdInfo);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (AdvertisingIdClient.Info) bridge.resultBridge(invocation);
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        }
        AdvertisingIdClient.Info advertisingIdInfo2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(context);
        if (!bridge.getTp()) {
            return advertisingIdInfo2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return advertisingIdInfo2;
    }
}
