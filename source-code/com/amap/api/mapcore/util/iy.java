package com.amap.api.mapcore.util;

/* compiled from: Taobao */
public class iy extends jb {
    private StringBuilder a = new StringBuilder();
    private boolean b = true;

    public iy() {
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.jb
    public byte[] a(byte[] bArr) {
        byte[] a2 = gn.a(this.a.toString());
        c(a2);
        this.b = true;
        StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a2;
    }

    @Override // com.amap.api.mapcore.util.jb
    public void b(byte[] bArr) {
        String a2 = gn.a(bArr);
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

    public iy(jb jbVar) {
        super(jbVar);
    }
}
