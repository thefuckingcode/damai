package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* compiled from: Taobao */
public class j {
    private static final String b = "X509CertificateUtil";
    public static final String c = "hmsrootcas.bks";
    public static final String d = "";
    public static final String e = "bks";
    public static final String f = "052root";
    private static final String g = "hmsincas.bks";
    private static final String h = "huawei cbg application integration ca";
    private Context a;

    public j(Context context) {
        this.a = context;
    }

    public X509Certificate a(String str, String str2) {
        Throwable th;
        InputStream inputStream;
        Exception e2;
        X509Certificate x509Certificate = null;
        InputStream inputStream2 = null;
        try {
            KeyStore instance = KeyStore.getInstance(e);
            inputStream = this.a.getAssets().open(str);
            try {
                inputStream.reset();
                instance.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) instance.getCertificate(str2);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e3) {
                e2 = e3;
                try {
                    g.b(b, "loadBksCA: exception : " + e2.getMessage());
                    f.a(inputStream);
                    return x509Certificate;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    f.a(inputStream2);
                    throw th;
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e4) {
            e2 = e4;
            inputStream = null;
            g.b(b, "loadBksCA: exception : " + e2.getMessage());
            f.a(inputStream);
            return x509Certificate;
        } catch (Throwable th3) {
            th = th3;
            f.a(inputStream2);
            throw th;
        }
        f.a(inputStream);
        return x509Certificate;
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f);
    }

    public X509Certificate a() {
        return a(g, h);
    }
}
