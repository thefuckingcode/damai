package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
public class iv extends jb {
    ByteArrayOutputStream a = new ByteArrayOutputStream();

    public iv() {
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.jb
    public byte[] a(byte[] bArr) {
        byte[] byteArray = this.a.toByteArray();
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.mapcore.util.jb
    public void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public iv(jb jbVar) {
        super(jbVar);
    }
}
