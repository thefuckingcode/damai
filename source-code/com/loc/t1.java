package com.loc;

import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import tb.v13;

/* compiled from: Taobao */
public final class t1 {
    private static String a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            an.m(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    private static String b(String str) {
        return v1.v(str);
    }

    public static java.net.Proxy c(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 11 ? d(context, new URI("http://restsdk.amap.com")) : f(context);
        } catch (Throwable th) {
            an.m(th, "pu", "gp");
            return null;
        }
    }

    private static java.net.Proxy d(Context context, URI uri) {
        java.net.Proxy proxy;
        if (g(context)) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                an.m(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int e() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            an.m(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        if (r10 == -1) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0078, code lost:
        r18 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
        if (r10 == -1) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0115, code lost:
        if (r12 == -1) goto L_0x0134;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0146 A[SYNTHETIC, Splitter:B:104:0x0146] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0155 A[Catch:{ all -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7 A[SYNTHETIC, Splitter:B:53:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d2 A[SYNTHETIC, Splitter:B:65:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013a A[SYNTHETIC, Splitter:B:98:0x013a] */
    private static java.net.Proxy f(Context context) {
        String str;
        int i;
        Cursor cursor;
        SecurityException e;
        String c0;
        int i2;
        boolean z;
        boolean z2;
        Throwable th;
        int i3;
        boolean z3;
        boolean z4;
        if (g(context)) {
            boolean z5 = false;
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
                                i = e();
                                try {
                                    if (TextUtils.isEmpty(a) || a.equals("null")) {
                                        str = null;
                                        z4 = false;
                                    } else {
                                        str = a;
                                        z4 = true;
                                    }
                                    if (!z4) {
                                        try {
                                            str = b("QMTAuMC4wLjIwMA==");
                                        } catch (SecurityException e2) {
                                            e = e2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            try {
                                                an.m(th, "pu", "gPx1");
                                                th.printStackTrace();
                                                if (cursor != null) {
                                                }
                                                if (str != null) {
                                                }
                                                if (z5) {
                                                }
                                                return null;
                                            } catch (Throwable th3) {
                                                an.m(th3, "pu", "gPx2");
                                            }
                                        }
                                    }
                                } catch (SecurityException e3) {
                                    e = e3;
                                    str = null;
                                    an.m(e, "pu", "ghp");
                                    c0 = o.c0(context);
                                    if (c0 != null) {
                                    }
                                    if (cursor != null) {
                                    }
                                    i = i2;
                                    if (str != null) {
                                    }
                                    if (z5) {
                                    }
                                    return null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    str = null;
                                    an.m(th, "pu", "gPx1");
                                    th.printStackTrace();
                                    if (cursor != null) {
                                    }
                                    if (str != null) {
                                    }
                                    if (z5) {
                                    }
                                    return null;
                                }
                            } else if (string != null && string.contains("wap")) {
                                String a2 = a();
                                i = e();
                                if (TextUtils.isEmpty(a2) || a2.equals("null")) {
                                    str = null;
                                    z3 = false;
                                } else {
                                    str = a2;
                                    z3 = true;
                                }
                                if (!z3) {
                                    str = b("QMTAuMC4wLjE3Mg==");
                                }
                            }
                            i3 = 80;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable th5) {
                                    an.m(th5, "pu", "gPx2");
                                }
                            }
                            i = i3;
                            if (str != null) {
                                try {
                                    if (str.length() > 0 && i != -1) {
                                        z5 = true;
                                    }
                                } catch (Throwable th6) {
                                    v13.e(th6, "pu", "gp2");
                                    th6.printStackTrace();
                                }
                            }
                            if (z5) {
                                return new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i));
                            }
                        }
                    } catch (SecurityException e4) {
                        e = e4;
                        str = null;
                        i = -1;
                        an.m(e, "pu", "ghp");
                        c0 = o.c0(context);
                        if (c0 != null) {
                        }
                        if (cursor != null) {
                        }
                        i = i2;
                        if (str != null) {
                        }
                        if (z5) {
                        }
                        return null;
                    } catch (Throwable th7) {
                        th = th7;
                        str = null;
                        i = -1;
                        an.m(th, "pu", "gPx1");
                        th.printStackTrace();
                        if (cursor != null) {
                        }
                        if (str != null) {
                        }
                        if (z5) {
                        }
                        return null;
                    }
                }
                str = null;
                i3 = -1;
                if (cursor != null) {
                }
                i = i3;
            } catch (SecurityException e5) {
                e = e5;
                cursor = null;
                str = null;
                i = -1;
                an.m(e, "pu", "ghp");
                c0 = o.c0(context);
                if (c0 != null) {
                    String lowerCase = c0.toLowerCase(Locale.US);
                    String a3 = a();
                    i2 = e();
                    if (lowerCase.indexOf("ctwap") != -1) {
                        if (TextUtils.isEmpty(a3) || a3.equals("null")) {
                            z2 = false;
                        } else {
                            str = a3;
                            z2 = true;
                        }
                        if (!z2) {
                            str = b("QMTAuMC4wLjIwMA==");
                        }
                    } else if (lowerCase.indexOf("wap") != -1) {
                        if (TextUtils.isEmpty(a3) || a3.equals("null")) {
                            z = false;
                        } else {
                            str = a3;
                            z = true;
                        }
                        if (!z) {
                            str = b("QMTAuMC4wLjE3Mg==");
                        }
                    }
                    i2 = 80;
                } else {
                    i2 = i;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th8) {
                        an.m(th8, "pu", "gPx2");
                    }
                }
                i = i2;
                if (str != null) {
                }
                if (z5) {
                }
                return null;
            } catch (Throwable th9) {
                th = th9;
                cursor = null;
                str = null;
                i = -1;
                an.m(th, "pu", "gPx1");
                th.printStackTrace();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th10) {
                        an.m(th10, "pu", "gPx2");
                    }
                }
                if (str != null) {
                }
                if (z5) {
                }
                return null;
            }
            if (str != null) {
            }
            if (z5) {
            }
        }
        return null;
        throw th;
    }

    private static boolean g(Context context) {
        return o.a0(context) == 0;
    }
}
