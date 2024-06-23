package com.amap.api.mapcore.util;

/* compiled from: Taobao */
public final class kv extends ks {
    public int j = 0;
    public int k = 0;
    public int l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;

    public kv(boolean z) {
        super(z, true);
    }

    @Override // com.amap.api.mapcore.util.ks
    /* renamed from: a */
    public final ks clone() {
        kv kvVar = new kv(this.h);
        kvVar.a(this);
        kvVar.j = this.j;
        kvVar.k = this.k;
        kvVar.l = this.l;
        kvVar.m = this.m;
        kvVar.n = this.n;
        return kvVar;
    }

    @Override // com.amap.api.mapcore.util.ks
    public final String toString() {
        return "AmapCellLte{lac=" + this.j + ", cid=" + this.k + ", pci=" + this.l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + '}' + super.toString();
    }
}
