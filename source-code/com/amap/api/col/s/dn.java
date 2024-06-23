package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.cw;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public final class dn {
    public static void a(Context context, dh dhVar, String str, int i, int i2, String str2) {
        dhVar.a = cj.c(context, str);
        dhVar.d = i;
        dhVar.b = (long) i2;
        dhVar.c = str2;
    }

    public static dh a(WeakReference<dh> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new dh());
        }
        return weakReference.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0055 A[SYNTHETIC, Splitter:B:40:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x005f A[SYNTHETIC, Splitter:B:45:0x005f] */
    static byte[] a(cw cwVar, String str) {
        Throwable th;
        cw.b bVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            bVar = cwVar.a(str);
            if (bVar != null) {
                try {
                    InputStream a = bVar.a();
                    if (a == null) {
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        try {
                            bVar.close();
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
                        bVar.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    return bArr2;
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        cl.c(th, "sui", "rdS");
                        if (0 != 0) {
                        }
                        if (bVar != null) {
                        }
                        return bArr;
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                }
            } else {
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
                return bArr;
            }
        } catch (Throwable th9) {
            th = th9;
            bVar = null;
            cl.c(th, "sui", "rdS");
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
            }
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (Throwable th11) {
                    th11.printStackTrace();
                }
            }
            return bArr;
        }
        if (bVar != null) {
            bVar.close();
        }
        throw th;
        throw th;
    }

    public static String a() {
        return bw.a(System.currentTimeMillis());
    }

    public static String a(Context context, bv bvVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String f = bo.f(context);
            sb.append("\"sim\":\"");
            sb.append(f);
            sb.append("\",\"sdkversion\":\"");
            sb.append(bvVar.d());
            sb.append("\",\"product\":\"");
            sb.append(bvVar.b());
            sb.append("\",\"ed\":\"");
            sb.append(bvVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(bo.d(context));
            sb.append("\",\"np\":\"");
            sb.append(bo.b(context));
            sb.append("\",\"mnc\":\"");
            sb.append(bo.c(context));
            sb.append("\",\"ant\":\"");
            sb.append(bo.e(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, int i, String str3, String str4) {
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
}
