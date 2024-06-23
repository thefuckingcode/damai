package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a {
    private static a a;
    private static final Object b = new Object();
    private byte[] c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private PublicKey h;
    private final SharedPreferences i;
    private final SharedPreferences j;
    private long k = 0;

    private a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.x.y.1", 0);
        this.i = sharedPreferences;
        this.j = context.getSharedPreferences("com.x.y.2", 0);
        Integer.parseInt(sharedPreferences.getString("keyTimeout", "0"));
        sharedPreferences.getLong("createDate", 0);
        e();
        byte[] bArr = this.c;
        if (bArr == null || bArr.length == 0) {
            PublicKey b2 = b(context);
            this.h = b2;
            if (b2 != null) {
                f();
                return;
            }
            sharedPreferences.edit().clear().apply();
            try {
                d();
                PublicKey b3 = b(context);
                this.h = b3;
                if (b3 != null) {
                    f();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
            byte[] bArr2 = this.d;
            if (bArr2 == null || bArr2.length == 0) {
                PublicKey b4 = b(context);
                this.h = b4;
                if (b4 != null) {
                    h();
                }
            }
        }
    }

    public static a a() {
        a aVar = a;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
    private String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    try {
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream2;
                    } catch (IOException unused) {
                        return byteArrayOutputStream2;
                    }
                }
            } catch (IOException unknown) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused2) {
                }
                return null;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }
    }

    public static void a(Context context) {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
    }

    private PublicKey b(Context context) {
        b("load publicKey from preference");
        String string = this.j.getString("publicKey", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 2)));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void b(String str) {
        DebugLogger.d("HttpKeyMgr", str);
    }

    private void c(String str) {
        DebugLogger.e("HttpKeyMgr", str);
    }

    private void d() throws IOException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(PushConstants.URL_DOWNLOAD_PUBLIC_KEY).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            try {
                httpURLConnection.setRequestMethod("GET");
            } catch (ProtocolException e2) {
                e2.printStackTrace();
            }
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            InputStream inputStream = null;
            try {
                int responseCode = httpURLConnection.getResponseCode();
                b("code = " + responseCode);
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    String a2 = a(inputStream);
                    b("body = " + a2);
                    if (!TextUtils.isEmpty(a2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(a2);
                            if (jSONObject.getInt("code") == 200) {
                                String string = jSONObject.getString("value");
                                SharedPreferences.Editor edit = this.j.edit();
                                edit.putString("publicKey", string);
                                edit.apply();
                            }
                        } catch (Exception e3) {
                            c("downloadPublicKey message error " + e3.getMessage());
                        }
                    }
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                httpURLConnection.disconnect();
            }
        } catch (MalformedURLException unused2) {
        }
    }

    private void e() {
        b("loadKeys");
        String string = this.i.getString("sKey64", "");
        b("saved sKey64: " + string);
        if (!TextUtils.isEmpty(string)) {
            this.g = string.getBytes();
        }
        String string2 = this.i.getString("aKey64", "");
        b("saved aKey64: " + string2);
        if (!TextUtils.isEmpty(string2)) {
            byte[] bytes = string2.getBytes();
            this.f = bytes;
            this.d = Base64.decode(bytes, 2);
        }
        String string3 = this.i.getString("rKey64", "");
        b("saved rKey64: " + string3);
        if (!TextUtils.isEmpty(string3)) {
            byte[] bytes2 = string3.getBytes();
            this.e = bytes2;
            this.c = Base64.decode(bytes2, 2);
            b("saved rKey: " + new String(this.c));
        }
    }

    private void f() {
        g();
        h();
    }

    private void g() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128);
            byte[] encoded = instance.generateKey().getEncoded();
            this.c = encoded;
            this.e = Base64.encode(encoded, 2);
            b("***** rKey64: " + new String(this.e));
            SharedPreferences.Editor edit = this.i.edit();
            edit.putString("rKey64", new String(this.e));
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, this.h);
            byte[] doFinal = instance.doFinal(this.c);
            this.d = doFinal;
            this.f = Base64.encode(doFinal, 2);
            b("***** aKey64: " + new String(this.f));
            SharedPreferences.Editor edit = this.i.edit();
            edit.putString("aKey64", new String(this.f));
            edit.apply();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
        } catch (InvalidKeyException e6) {
            e6.printStackTrace();
        }
    }

    public void a(String str) {
        this.g = str.getBytes();
        SharedPreferences.Editor edit = this.i.edit();
        edit.putString("sKey64", new String(this.g));
        edit.apply();
    }

    public byte[] a(byte[] bArr) {
        String str;
        byte[] bArr2 = this.c;
        if (bArr2 == null || bArr2.length == 0) {
            str = "rKey null!";
        } else if (bArr == null || bArr.length == 0) {
            str = "input null!";
        } else {
            b(">>>>>>>>>> encrypt input >>>>>>>>>>\n" + new String(Base64.encode(bArr, 2)));
            b("<<<<<<<<<< encrypt input <<<<<<<<<<");
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, new SecretKeySpec(this.c, "AES"), new IvParameterSpec(this.c));
                byte[] doFinal = instance.doFinal(bArr);
                b(">>>>>>>>>> encrypt output >>>>>>>>>>\n" + new String(Base64.encode(doFinal, 2)));
                b("<<<<<<<<<< encrypt output <<<<<<<<<<");
                return doFinal;
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvalidKeyException e4) {
                e4.printStackTrace();
                return null;
            } catch (BadPaddingException e5) {
                e5.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e6) {
                e6.printStackTrace();
                return null;
            } catch (InvalidAlgorithmParameterException e7) {
                e7.printStackTrace();
                return null;
            }
        }
        c(str);
        return null;
    }

    public byte[] b() {
        return this.f;
    }

    public byte[] c() {
        return this.g;
    }
}
