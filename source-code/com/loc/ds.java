package com.loc;

/* compiled from: Taobao */
public final class ds extends dr {
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m;
    public int n;

    public ds() {
    }

    public ds(boolean z, boolean z2) {
        super(z, z2);
    }

    @Override // com.loc.dr
    /* renamed from: a */
    public final dr clone() {
        ds dsVar = new ds(this.h, this.i);
        dsVar.a(this);
        dsVar.j = this.j;
        dsVar.k = this.k;
        dsVar.l = this.l;
        dsVar.m = this.m;
        dsVar.n = this.n;
        return dsVar;
    }

    @Override // com.loc.dr
    public final String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + ", mcc='" + this.a + '\'' + ", mnc='" + this.b + '\'' + ", signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
