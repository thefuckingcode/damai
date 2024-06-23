package com.loc;

/* compiled from: Taobao */
public final class dt extends dr {
    public int j = 0;
    public int k = 0;
    public int l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;
    public int o = Integer.MAX_VALUE;

    public dt() {
    }

    public dt(boolean z, boolean z2) {
        super(z, z2);
    }

    @Override // com.loc.dr
    /* renamed from: a */
    public final dr clone() {
        dt dtVar = new dt(this.h, this.i);
        dtVar.a(this);
        dtVar.j = this.j;
        dtVar.k = this.k;
        dtVar.l = this.l;
        dtVar.m = this.m;
        dtVar.n = this.n;
        dtVar.o = this.o;
        return dtVar;
    }

    @Override // com.loc.dr
    public final String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + ", mcc='" + this.a + '\'' + ", mnc='" + this.b + '\'' + ", signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
