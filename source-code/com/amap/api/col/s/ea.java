package com.amap.api.col.s;

/* compiled from: Taobao */
public abstract class ea {
    ea c;

    public ea() {
    }

    public void a(boolean z) {
        ea eaVar = this.c;
        if (eaVar != null) {
            eaVar.a(z);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean a();

    public int b() {
        ea eaVar = this.c;
        return Math.min(Integer.MAX_VALUE, eaVar != null ? eaVar.b() : Integer.MAX_VALUE);
    }

    public final boolean c() {
        ea eaVar = this.c;
        if (!(eaVar != null ? eaVar.c() : true)) {
            return false;
        }
        return a();
    }

    public ea(ea eaVar) {
        this.c = eaVar;
    }

    public void a(int i) {
        ea eaVar = this.c;
        if (eaVar != null) {
            eaVar.a(i);
        }
    }
}
