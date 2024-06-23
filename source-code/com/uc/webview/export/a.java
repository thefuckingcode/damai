package com.uc.webview.export;

import java.util.HashMap;
import java.util.Locale;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class a extends HashMap<String, String> {
    a() {
        put("export.webview", String.format(Locale.CHINA, "total:%d, u4:%d, system:%d", Integer.valueOf(WebView.j.get()), Integer.valueOf(WebView.l.get()), Integer.valueOf(WebView.k.get())));
    }
}
