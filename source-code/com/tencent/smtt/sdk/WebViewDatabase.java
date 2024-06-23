package com.tencent.smtt.sdk;

import android.content.Context;

public class WebViewDatabase {
    private static WebViewDatabase a;
    private Context b;

    protected WebViewDatabase(Context context) {
        this.b = context;
    }

    public static WebViewDatabase getInstance(Context context) {
        return a(context);
    }

    private static synchronized WebViewDatabase a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            if (a == null) {
                a = new WebViewDatabase(context);
            }
            webViewDatabase = a;
        }
        return webViewDatabase;
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword();
        }
        return a2.c().b(this.b);
    }

    @Deprecated
    public void clearUsernamePassword() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
        } else {
            a2.c().c(this.b);
        }
    }

    public boolean hasHttpAuthUsernamePassword() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword();
        }
        return a2.c().d(this.b);
    }

    public void clearHttpAuthUsernamePassword() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
        } else {
            a2.c().e(this.b);
        }
    }

    public boolean hasFormData() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.WebViewDatabase.getInstance(this.b).hasFormData();
        }
        return a2.c().f(this.b);
    }

    public void clearFormData() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
        } else {
            a2.c().g(this.b);
        }
    }
}
