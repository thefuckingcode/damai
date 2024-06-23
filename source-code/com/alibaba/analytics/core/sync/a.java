package com.alibaba.analytics.core.sync;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.b;
import com.alibaba.analytics.core.config.f;
import com.alibaba.analytics.core.config.timestamp.ConfigTimeStampMgr;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.WXBridgeManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import tb.cz1;
import tb.h82;
import tb.i82;
import tb.jl1;
import tb.kq2;
import tb.ot0;
import tb.pm2;
import tb.sr2;
import tb.t6;
import tb.tq2;
import tb.yd;

/* compiled from: Taobao */
public class a {
    static String a = null;
    private static long b = 0;
    private static boolean c = false;
    private static Class d = null;
    private static final String e = String.valueOf((char) 1);
    private static GZIPOutputStream f = null;
    private static ByteArrayOutputStream g = null;
    public static final i82 mMonitor = new i82();

    static void a() {
        b(f);
        b(g);
    }

    static void b(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String c() {
        String str;
        String str2;
        String a2 = t6.a();
        Context j = Variables.n().j();
        String f2 = Variables.n().f();
        String str3 = "";
        if (f2 == null) {
            f2 = str3;
        }
        Map<String, String> b2 = tq2.b(j);
        if (b2 == null || (str = b2.get(LogField.APPVERSION.toString())) == null) {
            str = str3;
        }
        String b3 = t6.b();
        if (b3 == null) {
            b3 = str3;
        }
        if (b2 != null) {
            str3 = b2.get(LogField.UTDID.toString());
        }
        String fullSDKVersion = kq2.a().getFullSDKVersion();
        String str4 = pm2.b().d() ? "1" : "0";
        if (!Variables.n().M() || b.a()) {
            str2 = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s&ipv6=%s&ao=a", a2, f2, str, b3, str3, fullSDKVersion, str4);
        } else {
            str2 = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s&ipv6=%s&dk=%s&ao=a", a2, f2, str, b3, str3, fullSDKVersion, str4, Variables.n().l());
        }
        StringBuilder sb = new StringBuilder(str2);
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ut_sample");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ut_sample"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("utap_system");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("utap_system"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ap_stat");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ap_stat"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ap_alarm");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ap_alarm"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ap_counter");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ap_counter"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ut_bussiness");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ut_bussiness"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ut_realtime");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ut_realtime"));
        if (!Variables.n().J()) {
            sb.append("&");
            sb.append("_sip");
            sb.append("=");
            sb.append(c.b().d());
            sb.append("&");
            sb.append("_sipnw");
            sb.append("=");
            sb.append(c.b().c());
            sb.append("&");
            sb.append("_fo");
            sb.append("=");
            sb.append(c.b().a());
        }
        String sb2 = sb.toString();
        Logger.m("PostData", "send url :" + sb2);
        return sb2;
    }

    public static byte[] d(Map<String, String> map) throws Exception {
        return e(map, 1);
    }

    static byte[] e(Map<String, String> map, int i) throws Exception {
        byte[] bArr;
        int i2;
        int i3;
        if (Variables.n().I() || Variables.n().J()) {
            bArr = ot0.a(g(map));
            i3 = 1;
            i2 = 1;
        } else {
            d.s();
            GZIPOutputStream gZIPOutputStream = f;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.write(h(map));
                f.flush();
                bArr = g.toByteArray();
                g.reset();
                i3 = 2;
            } else {
                bArr = ot0.a(h(map));
                i3 = 1;
            }
            i2 = 2;
        }
        if (bArr == null) {
            return null;
        }
        if (bArr.length >= 16777216) {
            if (Variables.n().O()) {
                mMonitor.onEvent(h82.a(h82.r, String.valueOf(bArr.length), Double.valueOf(1.0d)));
            }
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(i2);
        byteArrayOutputStream.write(yd.e(bArr.length));
        byteArrayOutputStream.write(i);
        byte b2 = (byte) (i3 | 8);
        if (Variables.n().M()) {
            b2 = (byte) (b2 | 16);
        }
        byteArrayOutputStream.write((byte) (b2 | 32));
        byteArrayOutputStream.write(0);
        if (Variables.n().J()) {
            byteArrayOutputStream.write(0);
        } else {
            String j = j(bArr, i);
            Logger.f("BizRequest", WXBridgeManager.OPTIONS, j);
            if (j == null || j.isEmpty()) {
                byteArrayOutputStream.write(0);
            } else {
                byteArrayOutputStream.write(1);
                byteArrayOutputStream.write(com.alibaba.analytics.utils.b.f(j.getBytes().length));
                byteArrayOutputStream.write(j.getBytes());
            }
        }
        byteArrayOutputStream.write(bArr);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            Logger.h(null, e2, new Object[0]);
        }
        return byteArray;
    }

    static byte[] f(Map<String, String> map) throws Exception {
        return e(map, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        com.alibaba.analytics.utils.Logger.m("BizRequest", "EventId NumberFormatException. eventId", r3, ",eventLogs", r8.get(r3));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x007c */
    private static byte[] g(Map<String, String> map) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String c2 = c();
        if (c2 == null || c2.length() <= 0) {
            byteArrayOutputStream.write(yd.d(0));
        } else {
            byteArrayOutputStream.write(yd.d(c2.getBytes().length));
            byteArrayOutputStream.write(c2.getBytes());
        }
        if (map != null && map.size() > 0) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                byteArrayOutputStream.write(yd.f(Integer.valueOf(next).intValue()));
                String str = map.get(next);
                if (str != null) {
                    byteArrayOutputStream.write(yd.f(str.getBytes().length));
                    byteArrayOutputStream.write(str.getBytes());
                } else {
                    byteArrayOutputStream.write(yd.f(0));
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArray;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        com.alibaba.analytics.utils.Logger.m("BizRequest", "EventId NumberFormatException. eventId", r3, ",eventLogs", r11.get(r3));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0096 */
    private static byte[] h(Map<String, String> map) throws Exception {
        String[] i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(com.alibaba.analytics.utils.b.e(c()));
        if (map != null && map.size() > 0) {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                byteArrayOutputStream.write(com.alibaba.analytics.utils.b.f(Integer.valueOf(next).intValue()));
                String str = map.get(next);
                if (str != null) {
                    String[] split = str.split(e);
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2) && (i = i(str2)) != null && 34 == i.length) {
                            for (String str3 : i) {
                                byteArrayOutputStream2.write(com.alibaba.analytics.utils.b.c(str3));
                            }
                            byteArrayOutputStream2.write(0);
                        }
                    }
                    byteArrayOutputStream.write(com.alibaba.analytics.utils.b.f(byteArrayOutputStream2.size()));
                    byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
                    byteArrayOutputStream2.reset();
                } else {
                    byteArrayOutputStream.write(0);
                }
            }
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return byteArray;
    }

    private static String[] i(String str) {
        String[] strArr = new String[34];
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= 33) {
                break;
            }
            int indexOf = str.indexOf(jl1.OR, i2);
            if (indexOf == -1) {
                strArr[i] = str.substring(i2);
                break;
            }
            strArr[i] = str.substring(i2, indexOf);
            i2 = indexOf + 2;
            i++;
        }
        strArr[33] = str.substring(i2);
        return strArr;
    }

    private static String j(byte[] bArr, int i) {
        HashMap<String, String> c2;
        if (i == 2 || !f.a() || (c2 = sr2.b().c()) == null || c2.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : c2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null || value.isEmpty()) {
                value = "";
            }
            if (z) {
                sb.append(key);
                sb.append("=");
                sb.append(value);
                z = false;
            } else {
                sb.append("&");
                sb.append(key);
                sb.append("=");
                sb.append(value);
            }
        }
        return sb.toString();
    }

    @TargetApi(19)
    static void k() {
        if (Build.VERSION.SDK_INT >= 19) {
            a();
            g = new ByteArrayOutputStream();
            try {
                f = new GZIPOutputStream((OutputStream) g, true);
            } catch (Exception unused) {
            }
        }
    }

    static int l(byte[] bArr) {
        int i = -1;
        if (bArr == null || bArr.length < 12) {
            Logger.i("", "recv errCode UNKNOWN_ERROR");
        } else {
            b = (long) bArr.length;
            if (yd.b(bArr, 1, 3) + 8 != bArr.length) {
                Logger.i("", "recv len error");
            } else {
                boolean z = 1 == (bArr[5] & 1);
                int b2 = yd.b(bArr, 8, 4);
                int length = bArr.length - 12 >= 0 ? bArr.length - 12 : 0;
                if (length <= 0) {
                    a = null;
                } else if (z) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, 12, bArr2, 0, length);
                    byte[] b3 = ot0.b(bArr2);
                    a = new String(b3, 0, b3.length);
                } else {
                    a = new String(bArr, 12, length);
                }
                i = b2;
            }
        }
        if (107 == i) {
            Variables.n().X(true);
        }
        if (109 == i) {
            Variables.n().W(true);
        }
        if (115 == i) {
            Variables.n().b0(true);
        }
        if (116 == i) {
            Variables.n().Q(true);
        }
        Logger.f("", "errCode", Integer.valueOf(i));
        return i;
    }

    static void m(long j) {
        Object c2;
        try {
            Context j2 = Variables.n().j();
            if (j2 != null) {
                if (!c && d != null) {
                    d = Class.forName("com.taobao.analysis.FlowCenter");
                    c = true;
                }
                Class cls = d;
                if (!(cls == null || (c2 = cz1.c(cls, "getInstance")) == null)) {
                    Logger.f("", "sendBytes", Long.valueOf(j), "mReceivedDataLen", Long.valueOf(b));
                    Object[] objArr = {j2, "ut", Boolean.TRUE, "ut", Long.valueOf(j), Long.valueOf(b)};
                    Class cls2 = Long.TYPE;
                    cz1.b(c2, "commitFlow", objArr, Context.class, String.class, Boolean.TYPE, String.class, cls2, cls2);
                }
            }
        } catch (Throwable unused) {
        }
        b = 0;
    }
}
