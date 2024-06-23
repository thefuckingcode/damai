package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import tb.t13;
import tb.u13;
import tb.v13;

/* compiled from: Taobao */
public final class o1 {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;
        String z;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = "1";
            if (!l.d()) {
                str = "0";
            }
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            v13.e(th, "CI", "TS");
            return null;
        }
    }

    public static String b(Context context) {
        return i(context);
    }

    public static String c(Context context, String str, String str2) {
        try {
            String i = l.i(context);
            return r1.a(i + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            v13.e(th, "CI", "Sco");
            return null;
        }
    }

    private static String d(a aVar) {
        return p1.f(j(aVar));
    }

    private static void e(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            v1.k(byteArrayOutputStream, str.getBytes().length > 255 ? -1 : (byte) str.getBytes().length, v1.p(str));
        } else {
            v1.k(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    public static byte[] f(Context context, boolean z, boolean z2) {
        try {
            return j(h(context, z, z2));
        } catch (Throwable th) {
            v13.e(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] g(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return p1.b(bArr);
    }

    private static a h(Context context, boolean z, boolean z2) {
        a aVar = new a((byte) 0);
        aVar.a = o.h0(context);
        aVar.b = o.W(context);
        String R = o.R(context);
        if (R == null) {
            R = "";
        }
        aVar.c = R;
        aVar.d = l.g(context);
        aVar.e = Build.getMODEL();
        aVar.f = Build.getMANUFACTURER();
        aVar.g = android.os.Build.DEVICE;
        aVar.h = l.e(context);
        aVar.i = l.h(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = o.k0(context);
        aVar.l = o.d0(context);
        StringBuilder sb = new StringBuilder();
        sb.append(o.a0(context));
        aVar.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(o.Z(context));
        aVar.n = sb2.toString();
        aVar.o = o.a(context);
        aVar.p = o.Y(context);
        aVar.q = "";
        aVar.r = "";
        if (z) {
            aVar.s = "";
            aVar.t = "";
        } else {
            String[] K = o.K();
            aVar.s = K[0];
            aVar.t = K[1];
        }
        aVar.w = o.v();
        String w = o.w(context);
        if (!TextUtils.isEmpty(w)) {
            aVar.x = w;
        } else {
            aVar.x = "";
        }
        aVar.y = "aid=" + o.V(context);
        if ((z2 && t13.e) || t13.k) {
            String Q = o.Q(context);
            if (!TextUtils.isEmpty(Q)) {
                aVar.y += "|oaid=" + Q;
            }
        }
        String y = o.y(context, ",");
        if (!TextUtils.isEmpty(y)) {
            aVar.y += "|multiImeis=" + y;
        }
        String j0 = o.j0(context);
        if (!TextUtils.isEmpty(j0)) {
            aVar.y += "|meid=" + j0;
        }
        aVar.y += "|serial=" + o.T(context);
        String C = o.C();
        if (!TextUtils.isEmpty(C)) {
            aVar.y += "|adiuExtras=" + C;
        }
        aVar.y += "|storage=" + o.N() + "|ram=" + o.l0(context) + "|arch=" + o.P();
        String b = u13.a().b();
        if (!TextUtils.isEmpty(b)) {
            aVar.z = b;
        } else {
            aVar.z = "";
        }
        return aVar;
    }

    private static String i(Context context) {
        try {
            return d(h(context, false, false));
        } catch (Throwable th) {
            v13.e(th, "CI", "gCXi");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00aa A[SYNTHETIC, Splitter:B:17:0x00aa] */
    private static byte[] j(a aVar) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                e(byteArrayOutputStream, aVar.a);
                e(byteArrayOutputStream, aVar.b);
                e(byteArrayOutputStream, aVar.c);
                e(byteArrayOutputStream, aVar.d);
                e(byteArrayOutputStream, aVar.e);
                e(byteArrayOutputStream, aVar.f);
                e(byteArrayOutputStream, aVar.g);
                e(byteArrayOutputStream, aVar.h);
                e(byteArrayOutputStream, aVar.i);
                e(byteArrayOutputStream, aVar.j);
                e(byteArrayOutputStream, aVar.k);
                e(byteArrayOutputStream, aVar.l);
                e(byteArrayOutputStream, aVar.m);
                e(byteArrayOutputStream, aVar.n);
                e(byteArrayOutputStream, aVar.o);
                e(byteArrayOutputStream, aVar.p);
                e(byteArrayOutputStream, aVar.q);
                e(byteArrayOutputStream, aVar.r);
                e(byteArrayOutputStream, aVar.s);
                e(byteArrayOutputStream, aVar.t);
                e(byteArrayOutputStream, aVar.u);
                e(byteArrayOutputStream, aVar.v);
                e(byteArrayOutputStream, aVar.w);
                e(byteArrayOutputStream, aVar.x);
                e(byteArrayOutputStream, aVar.y);
                e(byteArrayOutputStream, aVar.z);
                byte[] k = k(v1.u(byteArrayOutputStream.toByteArray()));
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return k;
            } catch (Throwable th3) {
                th = th3;
                try {
                    v13.e(th, "CI", "gzx");
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
            v13.e(th, "CI", "gzx");
            if (byteArrayOutputStream != null) {
            }
            return null;
        }
        throw th;
    }

    private static byte[] k(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey y = v1.y();
        if (bArr.length <= 117) {
            return p1.c(bArr, y);
        }
        byte[] bArr2 = new byte[117];
        System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] c = p1.c(bArr2, y);
        byte[] bArr3 = new byte[((bArr.length + 128) - 117)];
        System.arraycopy(c, 0, bArr3, 0, 128);
        System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }
}
