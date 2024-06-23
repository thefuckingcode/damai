package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.log.SLog;

/* compiled from: Taobao */
public abstract class c extends Dialog {
    protected b a;
    @SuppressLint({"NewApi"})
    protected final WebChromeClient b = new WebChromeClient() {
        /* class com.tencent.open.c.AnonymousClass1 */

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            if (Build.VERSION.SDK_INT <= 7) {
                return true;
            }
            c.this.a(consoleMessage.message());
            return true;
        }

        public void onConsoleMessage(String str, int i, String str2) {
            SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i + " of " + str2);
            if (Build.VERSION.SDK_INT == 7) {
                c.this.a(str);
            }
        }
    };

    public c(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new b();
    }
}
