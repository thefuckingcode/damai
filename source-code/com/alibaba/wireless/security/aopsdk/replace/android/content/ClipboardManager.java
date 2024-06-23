package com.alibaba.wireless.security.aopsdk.replace.android.content;

import android.content.ClipData;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

public class ClipboardManager {
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
    public static ClipData getPrimaryClip(android.content.ClipboardManager clipboardManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return clipboardManager.getPrimaryClip();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.ClipboardManager_getPrimaryClip, clipboardManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    ClipData primaryClip = clipboardManager.getPrimaryClip();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(primaryClip);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (ClipData) bridge.resultBridge(invocation);
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        ClipData primaryClip2 = clipboardManager.getPrimaryClip();
        if (!bridge.getTp()) {
            return primaryClip2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return primaryClip2;
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
    public static CharSequence getText(android.content.ClipboardManager clipboardManager) throws Throwable {
        long j;
        if (!ConfigManager.getInstance().isEnabled()) {
            return clipboardManager.getText();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.content_ClipboardManager_getText, clipboardManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        long j2 = 0;
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    if (bridge.getTp()) {
                        j2 = System.nanoTime();
                    }
                    CharSequence text = clipboardManager.getText();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - j2) / 1000;
                    }
                    invocation.setResult(text);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (CharSequence) bridge.resultBridge(invocation);
        }
        if (bridge.getTp()) {
            j = System.nanoTime();
        } else {
            j = 0;
        }
        CharSequence text2 = clipboardManager.getText();
        if (!bridge.getTp()) {
            return text2;
        }
        invocation.invokeTimeCost = (System.nanoTime() - j) / 1000;
        bridge.reportTimeCost(invocation);
        return text2;
    }
}
