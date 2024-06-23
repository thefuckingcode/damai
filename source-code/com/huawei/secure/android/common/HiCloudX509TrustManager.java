package com.huawei.secure.android.common;

import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Deprecated
/* compiled from: Taobao */
public class HiCloudX509TrustManager extends SecureX509TrustManager {
    @Deprecated
    public HiCloudX509TrustManager(InputStream inputStream, String str) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        super(inputStream, str);
    }
}
