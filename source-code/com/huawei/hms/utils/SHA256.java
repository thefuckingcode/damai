package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public abstract class SHA256 {
    public static byte[] digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            HMSLog.e("SHA256", "NoSuchAlgorithmException" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] digest(File file) {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] bArr = new byte[4096];
                int i = 0;
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                    instance.update(bArr, 0, read);
                }
                if (i > 0) {
                    byte[] digest = instance.digest();
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    return digest;
                }
                IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                return new byte[0];
            } catch (IOException | NoSuchAlgorithmException unused) {
                bufferedInputStream = bufferedInputStream2;
                try {
                    HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    return new byte[0];
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                throw th;
            }
        } catch (IOException | NoSuchAlgorithmException unused2) {
            HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
            IOUtils.closeQuietly((InputStream) bufferedInputStream);
            return new byte[0];
        }
    }
}
