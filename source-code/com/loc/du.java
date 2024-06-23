package com.loc;

/* compiled from: Taobao */
public final class du extends dr {
    public int j = 0;
    public int k = 0;
    public int l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;
    public int n = Integer.MAX_VALUE;

    public du() {
    }

    public du(boolean z) {
        super(z, true);
    }

    @Override // com.loc.dr
    /* renamed from: a */
    public final dr clone() {
        du duVar = new du(this.h);
        duVar.a(this);
        duVar.j = this.j;
        duVar.k = this.k;
        duVar.l = this.l;
        duVar.m = this.m;
        duVar.n = this.n;
        return duVar;
    }

    @Override // com.loc.dr
    public final String toString() {
        return "AmapCellLte{tac=" + this.j + ", ci=" + this.k + ", pci=" + this.l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + ", mcc='" + this.a + '\'' + ", mnc='" + this.b + '\'' + ", signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
