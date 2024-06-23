package com.loc;

import android.content.Context;
import com.loc.v;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import tb.r23;

/* compiled from: Taobao */
public final class e0 {
    public static String a() {
        return v1.b(System.currentTimeMillis());
    }

    public static String b(Context context, u1 u1Var) {
        StringBuilder sb = new StringBuilder();
        try {
            String O = o.O(context);
            sb.append("\"sim\":\"");
            sb.append(O);
            sb.append("\",\"sdkversion\":\"");
            sb.append(u1Var.f());
            sb.append("\",\"product\":\"");
            sb.append(u1Var.a());
            sb.append("\",\"ed\":\"");
            sb.append(u1Var.g());
            sb.append("\",\"nt\":\"");
            sb.append(o.J(context));
            sb.append("\",\"np\":\"");
            sb.append(o.D(context));
            sb.append("\",\"mnc\":\"");
            sb.append(o.H(context));
            sb.append("\",\"ant\":\"");
            sb.append(o.L(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String c(String str, String str2, int i, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static r23 d(WeakReference<r23> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new r23());
        }
        return weakReference.get();
    }

    public static void e(Context context, r23 r23, String str, int i, int i2, String str2) {
        r23.a = al.i(context, str);
        r23.d = i;
        r23.b = (long) i2;
        r23.c = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0055 A[SYNTHETIC, Splitter:B:40:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x005f A[SYNTHETIC, Splitter:B:45:0x005f] */
    static byte[] f(v vVar, String str) {
        Throwable th;
        v.e eVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            eVar = vVar.a(str);
            if (eVar != null) {
                try {
                    InputStream a = eVar.a();
                    if (a == null) {
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        try {
                            eVar.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                        return bArr;
                    }
                    byte[] bArr2 = new byte[a.available()];
                    a.read(bArr2);
                    try {
                        a.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    try {
                        eVar.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    return bArr2;
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        an.m(th, "sui", "rdS");
                        if (0 != 0) {
                        }
                        if (eVar != null) {
                        }
                        return bArr;
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                }
            } else {
                if (eVar != null) {
                    try {
                        eVar.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
                return bArr;
            }
        } catch (Throwable th9) {
            th = th9;
            eVar = null;
            an.m(th, "sui", "rdS");
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
            }
            if (eVar != null) {
                try {
                    eVar.close();
                } catch (Throwable th11) {
                    th11.printStackTrace();
                }
            }
            return bArr;
        }
        if (eVar != null) {
            eVar.close();
        }
        throw th;
        throw th;
    }
}
