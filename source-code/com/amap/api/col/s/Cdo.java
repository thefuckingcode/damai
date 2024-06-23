package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.amap.api.col.s.do  reason: invalid class name */
/* compiled from: Taobao */
public final class Cdo extends du {
    ByteArrayOutputStream a = new ByteArrayOutputStream();

    public Cdo() {
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.du
    public final byte[] a(byte[] bArr) {
        byte[] byteArray = this.a.toByteArray();
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.s.du
    public final void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Cdo(du duVar) {
        super(duVar);
    }
}
