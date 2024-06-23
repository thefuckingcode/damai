package com.vivo.push.c;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.ali.user.mobile.rpc.safe.AES;
import com.vivo.push.util.p;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: Taobao */
public final class e implements b {
    private static PrivateKey a;
    private static PublicKey b;
    private static KeyStore c;
    private static X500Principal d;
    private Context e;

    public e(Context context) {
        this.e = context;
        try {
            b();
            a(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "init error" + e2.getMessage());
        }
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (c == null) {
                b();
            }
            return c.containsAlias(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.c.b
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || b(this.e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey b2 = b(this.e);
            Signature instance = Signature.getInstance("SHA256withRSA");
            instance.initSign(b2);
            instance.update(bytes);
            String encodeToString = Base64.encodeToString(instance.sign(), 2);
            p.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "signClientSDK error" + e2.getMessage());
            return null;
        }
    }

    private static void b() {
        try {
            KeyStore instance = KeyStore.getInstance(AES.ANDROID_KEYSTORE);
            c = instance;
            instance.load(null);
            d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "initKeyStore error" + e2.getMessage());
        }
    }

    @Override // com.vivo.push.c.b
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature instance = Signature.getInstance("SHA256withRSA");
            instance.initVerify(publicKey);
            instance.update(bArr);
            return instance.verify(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "verifyClientSDK error" + e2.getMessage());
            return false;
        }
    }

    private static PrivateKey b(Context context) {
        try {
            PrivateKey privateKey = a;
            if (privateKey != null) {
                return privateKey;
            }
            if (context == null) {
                p.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                a(context);
            }
            KeyStore.Entry entry = c.getEntry("PushRsaKeyAlias", null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
                a = privateKey2;
                return privateKey2;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
        }
    }

    private static void a(Context context) {
        if (context == null) {
            try {
                p.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
            } catch (Exception e2) {
                e2.printStackTrace();
                p.a("RsaSecurity", "generateRSAKeyPairSign error" + e2.getMessage());
            }
        } else if (!b("PushRsaKeyAlias")) {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 999);
            if (Build.VERSION.SDK_INT >= 18) {
                KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(d).setSerialNumber(BigInteger.valueOf(1337)).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", AES.ANDROID_KEYSTORE);
                instance3.initialize(build);
                instance3.generateKeyPair();
            }
        } else {
            p.d("RsaSecurity", " generateRSAKeyPairSign this keyAlias PushRsaKeyAlias is Created ");
        }
    }

    @Override // com.vivo.push.c.b
    public final PublicKey a() {
        try {
            PublicKey publicKey = b;
            if (publicKey != null) {
                return publicKey;
            }
            if (!b("PushRsaKeyAlias")) {
                a(this.e);
            }
            KeyStore.Entry entry = c.getEntry("PushRsaKeyAlias", null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
                b = publicKey2;
                return publicKey2;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "getPublicKeySign error" + e2.getMessage());
        }
    }
}
