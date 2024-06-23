package com.amap.api.mapcore.util;

/* compiled from: Taobao */
public final class ku extends ks {
    public int j = 0;
    public int k = 0;
    public int l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;
    public int o = Integer.MAX_VALUE;

    public ku(boolean z, boolean z2) {
        super(z, z2);
    }

    @Override // com.amap.api.mapcore.util.ks
    /* renamed from: a */
    public final ks clone() {
        ku kuVar = new ku(this.h, this.i);
        kuVar.a(this);
        kuVar.j = this.j;
        kuVar.k = this.k;
        kuVar.l = this.l;
        kuVar.m = this.m;
        kuVar.n = this.n;
        kuVar.o = this.o;
        return kuVar;
    }

    @Override // com.amap.api.mapcore.util.ks
    public final String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + '}' + super.toString();
    }
}
