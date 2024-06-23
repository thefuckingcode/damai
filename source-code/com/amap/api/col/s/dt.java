package com.amap.api.col.s;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: Taobao */
public final class dt extends du {
    public dt() {
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.du
    public final byte[] a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] a = bw.a(stringBuffer.toString());
        byte[] bArr2 = new byte[(a.length + bArr.length)];
        System.arraycopy(a, 0, bArr2, 0, a.length);
        System.arraycopy(bArr, 0, bArr2, a.length, bArr.length);
        return bArr2;
    }

    public dt(du duVar) {
        super(duVar);
    }
}
