package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* compiled from: Taobao */
public class d0 {
    public static d0 c;
    public String a;
    public String b;

    public static d0 f() {
        if (c == null) {
            g();
        }
        return c;
    }

    public static synchronized void g() {
        synchronized (d0.class) {
            if (c == null) {
                c = new d0();
            }
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = c();
        }
        return this.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (e() != false) goto L_0x003d;
     */
    public final String a(String str) {
        String decrypt = e() ? AesGcmKS.decrypt("analytics_keystore", str) : "";
        if (TextUtils.isEmpty(decrypt)) {
            y.c("hmsSdk", "deCrypt work key first");
            decrypt = d.a(str, d());
            if (TextUtils.isEmpty(decrypt)) {
                decrypt = EncryptUtil.generateSecureRandomStr(16);
                c(b(decrypt));
            } else if (e()) {
                c(b(decrypt));
            }
            c0.d();
        }
        return decrypt;
    }

    public final String b(String str) {
        return e() ? AesGcmKS.encrypt("analytics_keystore", str) : d.b(str, d());
    }

    public void b() {
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        if (c(b(generateSecureRandomStr))) {
            this.a = generateSecureRandomStr;
        }
    }

    public final String c() {
        String a2 = g0.a(b.i(), "Privacy_MY", "PrivacyData", "");
        if (!TextUtils.isEmpty(a2)) {
            return a(a2);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        c(b(generateSecureRandomStr));
        return generateSecureRandomStr;
    }

    public final boolean c(String str) {
        y.c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            y.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        g0.b(b.i(), "Privacy_MY", "PrivacyData", str);
        g0.b(b.i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = new c0().a();
        }
        return this.b;
    }

    public final boolean e() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
