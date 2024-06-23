package com.alibaba.wireless.security.aopsdk.replace.android.provider;

import android.content.ContentResolver;
import android.provider.Settings;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class Settings {

    public static class Secure {
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a5, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
            if (r5.getTp() != false) goto L_0x00ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ac, code lost:
            r4.invokeTimeCost = (java.lang.System.nanoTime() - r2) / 1000;
            r5.reportTimeCost(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b8, code lost:
            throw r0;
         */
        public static String getString(ContentResolver contentResolver, String str) throws Throwable {
            if (!ConfigManager.getInstance().isEnabled()) {
                return Settings.Secure.getString(contentResolver, str);
            }
            Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Settings_Secure_getString_ContentResolver_String, null, contentResolver, str);
            AopBridge bridge = AopManager.getInstance().getBridge();
            long j = 0;
            if (bridge.callBeforeBridge(invocation)) {
                if (!invocation.shouldBlock()) {
                    try {
                        ContentResolver contentResolver2 = (ContentResolver) invocation.getArgL(0);
                        String str2 = (String) invocation.getArgL(1);
                        if (bridge.getTp()) {
                            j = System.nanoTime();
                        }
                        String string = Settings.Secure.getString(contentResolver2, str2);
                        if (bridge.getTp()) {
                            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
                        }
                        invocation.setResult(string);
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
            }
            String string2 = Settings.Secure.getString(contentResolver, str);
            if (!bridge.getTp()) {
                return string2;
            }
            invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
            bridge.reportTimeCost(invocation);
            return string2;
        }
    }
}
