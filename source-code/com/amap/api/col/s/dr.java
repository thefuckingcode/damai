package com.amap.api.col.s;

/* compiled from: Taobao */
public final class dr extends du {
    private StringBuilder a = new StringBuilder();
    private boolean b = true;

    public dr() {
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.du
    public final byte[] a(byte[] bArr) {
        byte[] a2 = bw.a(this.a.toString());
        this.d = a2;
        this.b = true;
        StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a2;
    }

    @Override // com.amap.api.col.s.du
    public final void b(byte[] bArr) {
        String a2 = bw.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.a.append(",");
        }
        StringBuilder sb = this.a;
        sb.append("{\"log\":\"");
        sb.append(a2);
        sb.append("\"}");
    }

    public dr(du duVar) {
        super(duVar);
    }
}
