package com.alipay.sdk.m.y;

import com.alipay.sdk.m.z.a;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public final class b {
    public static String a(String str) {
        try {
            if (a.a(str)) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(String.format("%02x", Byte.valueOf(digest[i])));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
