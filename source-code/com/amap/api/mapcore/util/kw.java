package com.amap.api.mapcore.util;

/* compiled from: Taobao */
public final class kw extends ks {
    public int j = 0;
    public int k = 0;
    public int l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;

    public kw(boolean z, boolean z2) {
        super(z, z2);
    }

    @Override // com.amap.api.mapcore.util.ks
    /* renamed from: a */
    public final ks clone() {
        kw kwVar = new kw(this.h, this.i);
        kwVar.a(this);
        kwVar.j = this.j;
        kwVar.k = this.k;
        kwVar.l = this.l;
        kwVar.m = this.m;
        return kwVar;
    }

    @Override // com.amap.api.mapcore.util.ks
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + '}' + super.toString();
    }
}
