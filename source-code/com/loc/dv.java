package com.loc;

/* compiled from: Taobao */
public final class dv extends dr {
    public int j = 0;
    public int k = 0;
    public int l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;

    public dv() {
    }

    public dv(boolean z, boolean z2) {
        super(z, z2);
    }

    @Override // com.loc.dr
    /* renamed from: a */
    public final dr clone() {
        dv dvVar = new dv(this.h, this.i);
        dvVar.a(this);
        dvVar.j = this.j;
        dvVar.k = this.k;
        dvVar.l = this.l;
        dvVar.m = this.m;
        return dvVar;
    }

    @Override // com.loc.dr
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + ", mcc='" + this.a + '\'' + ", mnc='" + this.b + '\'' + ", signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
