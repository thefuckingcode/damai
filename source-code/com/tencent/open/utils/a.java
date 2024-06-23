package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.ali.user.mobile.rpc.safe.AES;
import com.tencent.open.log.SLog;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class a {
    private KeyStore a;
    private SharedPreferences b;

    public a(Context context) {
        try {
            this.b = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            KeyStore instance = KeyStore.getInstance(AES.ANDROID_KEYSTORE);
            this.a = instance;
            instance.load(null);
            if (!this.a.containsAlias("KEYSTORE_AES")) {
                c("");
                a(context);
                a();
            }
        } catch (Exception e) {
            SLog.d("KEYSTORE", "Exception", e);
        }
    }

    private void a(Context context) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Build.VERSION.SDK_INT=");
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        SLog.d("KEYSTORE", sb.toString());
        if (i >= 23) {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", AES.ANDROID_KEYSTORE);
            instance.initialize(new KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests(MessageDigestAlgorithms.SHA_256, MessageDigestAlgorithms.SHA_512).setEncryptionPaddings("PKCS1Padding").build());
            instance.generateKeyPair();
        } else if (i >= 18) {
            KeyPairGenerator instance2 = KeyPairGenerator.getInstance("RSA", AES.ANDROID_KEYSTORE);
            Calendar instance3 = Calendar.getInstance();
            Calendar instance4 = Calendar.getInstance();
            instance4.add(1, 30);
            instance2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(instance3.getTime()).setEndDate(instance4.getTime()).build());
            instance2.generateKeyPair();
        }
    }

    private void c(String str) {
        this.b.edit().putString("PREF_KEY_IV", str).apply();
    }

    private void d(String str) {
        this.b.edit().putString("PREF_KEY_AES", str).apply();
    }

    public String b(String str) {
        try {
            byte[] decode = Base64.decode(str.getBytes(), 0);
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(2, c(), new IvParameterSpec(b()));
            return new String(instance.doFinal(decode));
        } catch (Exception e) {
            SLog.e("KEYSTORE", "Exception", e);
            return "";
        }
    }

    private SecretKeySpec c() throws Exception {
        String string = this.b.getString("PREF_KEY_AES", "");
        if (Build.VERSION.SDK_INT < 18) {
            return new SecretKeySpec(Base64.decode(string, 0), "AES/GCM/NoPadding");
        }
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, (PrivateKey) this.a.getKey("KEYSTORE_AES", null));
        return new SecretKeySpec(instance.doFinal(Base64.decode(string, 0)), "AES/GCM/NoPadding");
    }

    private byte[] b() {
        return Base64.decode(this.b.getString("PREF_KEY_IV", ""), 0);
    }

    public String a(String str) {
        try {
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(1, c(), new IvParameterSpec(b()));
            return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
        } catch (Exception e) {
            SLog.e("KEYSTORE", "Exception", e);
            return "";
        }
    }

    private void a() throws Exception {
        byte[] bArr = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bArr);
        c(Base64.encodeToString(secureRandom.generateSeed(12), 0));
        if (Build.VERSION.SDK_INT >= 18) {
            PublicKey publicKey = this.a.getCertificate("KEYSTORE_AES").getPublicKey();
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            d(Base64.encodeToString(instance.doFinal(bArr), 0));
            return;
        }
        MessageDigest instance2 = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        instance2.update(bArr);
        d(Base64.encodeToString(instance2.digest(), 0));
    }
}
