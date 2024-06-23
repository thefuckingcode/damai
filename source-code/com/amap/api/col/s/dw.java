package com.amap.api.col.s;

import java.io.File;

/* compiled from: Taobao */
public final class dw extends ea {
    private int a = 30;
    private String b;

    public dw(String str, ea eaVar) {
        super(eaVar);
        this.b = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.ea
    public final boolean a() {
        return a(this.b) >= this.a;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            cl.c(th, "fus", "gfn");
            return 0;
        }
    }
}
