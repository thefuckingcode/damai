package com.amap.api.mapcore.util;

/* compiled from: Taobao */
public abstract class jh {
    jh a;

    public jh() {
    }

    private boolean d() {
        jh jhVar = this.a;
        if (jhVar != null) {
            return jhVar.c();
        }
        return true;
    }

    public void a(boolean z) {
        jh jhVar = this.a;
        if (jhVar != null) {
            jhVar.a(z);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean a();

    public int b() {
        jh jhVar = this.a;
        return Math.min(Integer.MAX_VALUE, jhVar != null ? jhVar.b() : Integer.MAX_VALUE);
    }

    public boolean c() {
        if (!d()) {
            return false;
        }
        return a();
    }

    public jh(jh jhVar) {
        this.a = jhVar;
    }

    public void a(int i) {
        jh jhVar = this.a;
        if (jhVar != null) {
            jhVar.a(i);
        }
    }
}
