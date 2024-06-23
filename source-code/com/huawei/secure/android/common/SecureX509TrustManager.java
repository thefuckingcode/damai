package com.huawei.secure.android.common;

import android.content.Context;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Deprecated
/* compiled from: Taobao */
public class SecureX509TrustManager extends com.huawei.secure.android.common.ssl.SecureX509TrustManager {
    @Deprecated
    public SecureX509TrustManager(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException {
        super(context);
    }
}
