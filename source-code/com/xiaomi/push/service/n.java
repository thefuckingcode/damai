package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bm;
import com.xiaomi.push.i;
import com.xiaomi.push.ik;
import com.xiaomi.push.it;
import com.xiaomi.push.iz;

/* compiled from: Taobao */
public class n {
    public static ik a(Cif ifVar) {
        byte[] a = ifVar.m623a();
        ik ikVar = new ik();
        try {
            it.a(ikVar, a);
            return ikVar;
        } catch (iz unused) {
            return null;
        }
    }

    static void a(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
            String stringExtra2 = intent.getStringExtra("mipush_app_package");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                try {
                    byte[] b = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
                    if (b != null) {
                        al.m792a(context, y.a(b), b);
                    } else {
                        b.m182a("notify fcm notification error ：dencrypt failed");
                    }
                } catch (Throwable th) {
                    b.a("notify fcm notification error ", th);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            b.m182a("secret is empty, return null");
            return null;
        }
        try {
            return i.b(bm.m290a(str), bArr);
        } catch (Exception e) {
            b.a("encryption error. ", e);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            b.m182a("secret is empty, return null");
            return null;
        }
        try {
            return i.a(bm.m290a(str), bArr);
        } catch (Exception e) {
            b.a("dencryption error. ", e);
            return null;
        }
    }
}
