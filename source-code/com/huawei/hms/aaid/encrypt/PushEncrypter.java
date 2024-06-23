package com.huawei.hms.aaid.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.c;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;

/* compiled from: Taobao */
public class PushEncrypter {
    public static String decrypter(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return AesCbc.decrypt(str, c.b(context));
    }

    public static String encrypter(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return AesCbc.encrypt(str, c.b(context));
    }

    public static String encrypterOld(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return AesCbc.encrypt(str, c.a(context));
    }
}
