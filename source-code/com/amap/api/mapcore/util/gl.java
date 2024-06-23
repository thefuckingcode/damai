package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
public class gl {
    public static Proxy a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                return a(context, new URI("http://restapi.amap.com"));
            }
            return b(context);
        } catch (Throwable th) {
            hd.c(th, "pu", "gp");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        if (r10 == -1) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a8, code lost:
        if (r10 == -1) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0114, code lost:
        if (r12 == -1) goto L_0x0139;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x014a A[Catch:{ all -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b6 A[SYNTHETIC, Splitter:B:53:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d0 A[SYNTHETIC, Splitter:B:65:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013b A[SYNTHETIC, Splitter:B:98:0x013b] */
    private static Proxy b(Context context) {
        int i;
        String str;
        int i2;
        Cursor cursor;
        SecurityException e;
        String t;
        Throwable th;
        boolean z;
        Throwable th2;
        boolean z2;
        boolean z3;
        if (c(context)) {
            boolean z4 = true;
            int i3 = 80;
            i = -1;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndex("apn"));
                            if (string != null) {
                                string = string.toLowerCase(Locale.US);
                            }
                            if (string != null && string.contains("ctwap")) {
                                String a = a();
                                i2 = b();
                                try {
                                    if (TextUtils.isEmpty(a) || a.equals("null")) {
                                        str = null;
                                        z3 = false;
                                    } else {
                                        str = a;
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        try {
                                            str = a("QMTAuMC4wLjIwMA==");
                                        } catch (SecurityException e2) {
                                            e = e2;
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            i = i2;
                                            try {
                                                hd.c(th2, "pu", "gPx1");
                                                th2.printStackTrace();
                                                if (cursor != null) {
                                                }
                                                if (a(str, i)) {
                                                }
                                                return null;
                                            } catch (Throwable th4) {
                                                hd.c(th4, "pu", "gPx2");
                                            }
                                        }
                                    }
                                } catch (SecurityException e3) {
                                    e = e3;
                                    str = null;
                                    hd.c(e, "pu", "ghp");
                                    t = gg.t(context);
                                    if (t != null) {
                                    }
                                    if (cursor != null) {
                                    }
                                    i = i3;
                                    if (a(str, i)) {
                                    }
                                    return null;
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    str = null;
                                    i = i2;
                                    hd.c(th2, "pu", "gPx1");
                                    th2.printStackTrace();
                                    if (cursor != null) {
                                    }
                                    if (a(str, i)) {
                                    }
                                    return null;
                                }
                            } else if (string != null && string.contains("wap")) {
                                String a2 = a();
                                i2 = b();
                                if (TextUtils.isEmpty(a2) || a2.equals("null")) {
                                    str = null;
                                    z2 = false;
                                } else {
                                    str = a2;
                                    z2 = true;
                                }
                                if (!z2) {
                                    str = a("QMTAuMC4wLjE3Mg==");
                                }
                            }
                            i3 = i2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                            i = i3;
                            if (a(str, i)) {
                                return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i));
                            }
                        }
                    } catch (SecurityException e4) {
                        e = e4;
                        str = null;
                        i2 = -1;
                        hd.c(e, "pu", "ghp");
                        t = gg.t(context);
                        if (t != null) {
                        }
                        if (cursor != null) {
                        }
                        i = i3;
                        if (a(str, i)) {
                        }
                        return null;
                    } catch (Throwable th7) {
                        th2 = th7;
                        str = null;
                        hd.c(th2, "pu", "gPx1");
                        th2.printStackTrace();
                        if (cursor != null) {
                        }
                        if (a(str, i)) {
                        }
                        return null;
                    }
                }
                str = null;
                i3 = -1;
                if (cursor != null) {
                }
            } catch (SecurityException e5) {
                e = e5;
                cursor = null;
                str = null;
                i2 = -1;
                hd.c(e, "pu", "ghp");
                t = gg.t(context);
                if (t != null) {
                    String lowerCase = t.toLowerCase(Locale.US);
                    String a3 = a();
                    int b = b();
                    if (lowerCase.indexOf("ctwap") != -1) {
                        if (TextUtils.isEmpty(a3) || a3.equals("null")) {
                            z4 = false;
                        } else {
                            str = a3;
                        }
                        if (!z4) {
                            str = a("QMTAuMC4wLjIwMA==");
                        }
                    } else if (lowerCase.indexOf("wap") != -1) {
                        if (TextUtils.isEmpty(a3) || a3.equals("null")) {
                            z = false;
                        } else {
                            str = a3;
                            z = true;
                        }
                        if (!z) {
                            str = a("QMTAuMC4wLjE3Mg==");
                        }
                    }
                    i3 = b;
                } else {
                    i3 = i2;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
                i = i3;
                if (a(str, i)) {
                }
                return null;
            } catch (Throwable th9) {
                th2 = th9;
                cursor = null;
                str = null;
                hd.c(th2, "pu", "gPx1");
                th2.printStackTrace();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th10) {
                        hd.c(th10, "pu", "gPx2");
                    }
                }
                if (a(str, i)) {
                }
                return null;
            }
            i = i3;
            try {
                if (a(str, i)) {
                }
            } catch (Throwable th11) {
                ha.a(th11, "pu", "gp2");
                th11.printStackTrace();
            }
        }
        return null;
        hd.c(th, "pu", "gPx2");
        i = i3;
        if (a(str, i)) {
        }
        return null;
        throw th;
    }

    private static boolean c(Context context) {
        return gg.r(context) == 0;
    }

    public static String a(String str) {
        return gn.c(str);
    }

    private static boolean a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    private static String a() {
        String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            hd.c(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    private static Proxy a(Context context, URI uri) {
        Proxy proxy;
        if (c(context)) {
            try {
                List<Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                hd.c(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            hd.c(th, "pu", "gdp");
            return -1;
        }
    }
}
