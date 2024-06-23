package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
public abstract class m0 {
    m0 a;
    byte[] b = null;

    m0() {
    }

    m0(m0 m0Var) {
        this.a = m0Var;
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] b2 = b(this.b);
        m0 m0Var = this.a;
        if (m0Var == null) {
            return b2;
        }
        m0Var.b = b2;
        return m0Var.a();
    }

    /* access modifiers changed from: protected */
    public abstract byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void c(byte[] bArr) {
    }
}
