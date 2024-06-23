package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
public final class dq extends du {
    private Context a;
    private String b;
    private cs e;
    private Object[] f;

    public dq(Context context, du duVar, cs csVar, String str, Object... objArr) {
        super(duVar);
        this.a = context;
        this.b = str;
        this.e = csVar;
        this.f = objArr;
    }

    private String b() {
        try {
            return String.format(bw.c(this.b), this.f);
        } catch (Throwable th) {
            th.printStackTrace();
            cl.c(th, "ofm", "gpj");
            return "";
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.du
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a2 = bw.a(bArr);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String a3 = bw.a(this.e.b(bw.a(b())));
        return bw.a("{\"pinfo\":\"" + a3 + "\",\"els\":[" + a2 + "]}");
    }
}
