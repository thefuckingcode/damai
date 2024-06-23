package com.huawei.hms.opendevice;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public final class r {
    public static String a(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (TextUtils.isEmpty(str2)) {
                str2 = MessageDigestAlgorithms.SHA_256;
            }
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(bytes);
            return HEX.encodeHexString(instance.digest(), false);
        } catch (NoSuchAlgorithmException unused) {
            HMSLog.e("SHACoder", "encrypt failed .");
            return null;
        } catch (UnsupportedEncodingException unused2) {
            HMSLog.e("SHACoder", "trans failed .");
            return null;
        }
    }
}
