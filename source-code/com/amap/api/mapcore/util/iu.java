package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.hy;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class iu {
    public static void a(Context context, in inVar, String str, int i, int i2, String str2) {
        inVar.a = hb.c(context, str);
        inVar.d = i;
        inVar.b = (long) i2;
        inVar.c = str2;
    }

    public static in a(WeakReference<in> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new in());
        }
        return weakReference.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x005a A[SYNTHETIC, Splitter:B:42:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0064 A[SYNTHETIC, Splitter:B:47:0x0064] */
    static byte[] a(hy hyVar, String str, boolean z) {
        Throwable th;
        hy.b bVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            bVar = hyVar.a(str);
            if (bVar == null) {
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream a = bVar.a(0);
                if (a == null) {
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    try {
                        bVar.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    return bArr;
                }
                byte[] bArr2 = new byte[a.available()];
                a.read(bArr2);
                if (z) {
                    hyVar.c(str);
                }
                try {
                    a.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                try {
                    bVar.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
                return bArr2;
            } catch (Throwable th7) {
                th = th7;
                try {
                    hd.c(th, "sui", "rdS");
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Throwable th9) {
                            th9.printStackTrace();
                        }
                    }
                    return bArr;
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
            }
        } catch (Throwable th11) {
            th = th11;
            bVar = null;
            hd.c(th, "sui", "rdS");
            if (0 != 0) {
            }
            if (bVar != null) {
            }
            return bArr;
        }
        throw th;
        if (bVar != null) {
            bVar.close();
        }
        throw th;
    }

    public static String a() {
        return gn.a(System.currentTimeMillis());
    }

    public static String a(Context context, gm gmVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String g = gg.g(context);
            sb.append("\"sim\":\"");
            sb.append(g);
            sb.append("\",\"sdkversion\":\"");
            sb.append(gmVar.c());
            sb.append("\",\"product\":\"");
            sb.append(gmVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(gmVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(gg.e(context));
            sb.append("\",\"np\":\"");
            sb.append(gg.c(context));
            sb.append("\",\"mnc\":\"");
            sb.append(gg.d(context));
            sb.append("\",\"ant\":\"");
            sb.append(gg.f(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append(",");
        stringBuffer.append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }
}
