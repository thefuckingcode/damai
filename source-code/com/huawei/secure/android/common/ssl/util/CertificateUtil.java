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
public final class CertificateUtil {
    private static final String a = "CertificateUtil";

    private CertificateUtil() {
    }

    public static X509Certificate getHwCbgRootCA(Context context) {
        Throwable th;
        InputStream inputStream;
        Exception e;
        X509Certificate x509Certificate = null;
        InputStream inputStream2 = null;
        try {
            KeyStore instance = KeyStore.getInstance(j.e);
            inputStream = context.getAssets().open("hmsrootcas.bks");
            try {
                inputStream.reset();
                instance.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) instance.getCertificate(j.f);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                e = e2;
                try {
                    g.b(a, "loadBksCA: exception : " + e.getMessage());
                    f.a(inputStream);
                    return x509Certificate;
                } catch (Throwable th2) {
                    inputStream2 = inputStream;
                    th = th2;
                    f.a(inputStream2);
                    throw th;
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e3) {
            e = e3;
            inputStream = null;
            g.b(a, "loadBksCA: exception : " + e.getMessage());
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
}
