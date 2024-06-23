package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
public final class f0 extends m0 {
    ByteArrayOutputStream c = new ByteArrayOutputStream();

    public f0(m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: protected */
    @Override // com.loc.m0
    public final byte[] b(byte[] bArr) {
        byte[] byteArray = this.c.toByteArray();
        try {
            this.c.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.c = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.loc.m0
    public final void c(byte[] bArr) {
        try {
            this.c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
