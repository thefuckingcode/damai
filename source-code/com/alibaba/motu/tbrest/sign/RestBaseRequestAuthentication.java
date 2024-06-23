package com.alibaba.motu.tbrest.sign;

import com.alibaba.motu.tbrest.utils.LogUtil;
import com.alibaba.motu.tbrest.utils.MD5Utils;
import com.alibaba.motu.tbrest.utils.RC4;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import tb.ok1;

/* compiled from: Taobao */
public class RestBaseRequestAuthentication {
    private String mAppSecret = null;
    private String mAppkey = null;
    private byte[] mDefaultAppAppSecret = null;
    private boolean mEncode = false;

    public RestBaseRequestAuthentication(String str, String str2) {
        this.mAppkey = str;
        this.mAppSecret = str2;
    }

    public static String calcHmac(byte[] bArr, byte[] bArr2) throws Exception {
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(bArr, instance.getAlgorithm()));
        return MD5Utils.toHexString(instance.doFinal(bArr2));
    }

    private byte[] getDefaultAppAppSecret() {
        if (this.mDefaultAppAppSecret == null) {
            this.mDefaultAppAppSecret = RC4.rc4(new byte[]{66, ok1.OP_UNARY_MIN, ok1.OP_GET_OPT_JUMP, -119, 118, -104, -30, 4, -95, 15, -26, -12, -75, -102, 71, 23, -3, -120, -1, -57, ok1.OP_GET_OPT_JUMP, 99, -16, -101, 103, -74, 93, -114, 112, -26, -24, -24});
        }
        return this.mDefaultAppAppSecret;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public String getAppkey() {
        return this.mAppkey;
    }

    public String getSign(String str) {
        String str2;
        if (this.mAppkey == null || (str2 = this.mAppSecret) == null) {
            LogUtil.e("There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            try {
                if (this.mEncode) {
                    return calcHmac(str2.getBytes(), str.getBytes());
                }
                return calcHmac(getDefaultAppAppSecret(), str.getBytes());
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public boolean isEncode() {
        return this.mEncode;
    }

    public RestBaseRequestAuthentication(String str, String str2, boolean z) {
        this.mAppkey = str;
        this.mAppSecret = str2;
        this.mEncode = z;
    }
}
