package com.uc.webview.export.internal.setup;

import android.util.Pair;
import com.uc.webview.export.cyclone.UCLoader;
import com.uc.webview.export.internal.uc.startup.b;
import com.uc.webview.export.internal.utility.Log;
import java.io.File;

/* compiled from: Taobao */
public class m extends a {
    ClassLoader c = null;
    private String d = null;
    private String e = null;
    private String f = null;

    public m(String str, String str2, String str3) {
        this.a = "LoadDexJob";
        this.b = new Pair<>(257, 258);
        this.d = str;
        this.e = str2;
        this.f = str3;
        String str4 = this.a;
        Log.i(str4, "<init> dexPath:" + this.d + ", odexPath:" + this.e + ", soDir:" + this.f);
    }

    /* access modifiers changed from: protected */
    @Override // com.uc.webview.export.internal.setup.a
    public final void a() {
        ClassLoader classLoader = m.class.getClassLoader();
        String absolutePath = new File(this.d).getAbsolutePath();
        b.a(26);
        this.c = new UCLoader(absolutePath, this.e, this.f, classLoader);
        b.a(27);
    }
}
