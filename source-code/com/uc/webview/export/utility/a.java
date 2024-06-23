package com.uc.webview.export.utility;

import java.util.Formatter;
import java.util.Locale;

/* compiled from: Taobao */
final class a extends ThreadLocal<Formatter> {
    StringBuilder a = new StringBuilder();

    a() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized Formatter initialValue() {
        return new Formatter(this.a, Locale.getDefault());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.lang.ThreadLocal
    public final /* synthetic */ Formatter get() {
        Formatter formatter = (Formatter) super.get();
        this.a.setLength(0);
        return formatter;
    }
}
