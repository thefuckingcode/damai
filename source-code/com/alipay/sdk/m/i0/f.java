package com.alipay.sdk.m.i0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.realidentity.jsbridge.a;
import com.alimm.xadsdk.request.builder.IRequestConst;

/* compiled from: Taobao */
public class f {
    public static volatile f g;
    public static boolean h;
    public a a = new a("udid");
    public a b = new a(IRequestConst.OAID);
    public a c = new a("aaid");
    public a d = new a("vaid");
    public c e = new c();
    public BroadcastReceiver f;

    public static d a(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else if (cursor.isClosed()) {
            str = "parseValue fail, cursor is closed.";
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                dVar.a = cursor.getString(columnIndex);
            } else {
                a("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                dVar.b = cursor.getInt(columnIndex2);
            } else {
                a("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex(a.S);
            if (columnIndex3 >= 0) {
                dVar.c = cursor.getLong(columnIndex3);
            } else {
                a("parseExpired fail, index < 0.");
            }
            return dVar;
        }
        a(str);
        return dVar;
    }

    public static final f a() {
        if (g == null) {
            synchronized (f.class) {
                if (g == null) {
                    g = new f();
                }
            }
        }
        return g;
    }

    public static String a(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    public static void a(String str) {
        if (h) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void a(boolean z) {
        h = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        if (r7 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (0 == 0) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        return false;
     */
    public static boolean a(Context context) {
        a("querySupport version : 1.0.8");
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
            if (cursor != null) {
                d a2 = a(cursor);
                if (1000 != a2.b || "0".equals(a2.a)) {
                    z = true;
                }
                cursor.close();
                return z;
            }
        } catch (Exception e2) {
            a("querySupport, Exception : " + e2.getMessage());
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    private String b(Context context, a aVar) {
        Throwable th;
        Cursor cursor;
        String str;
        Exception e2;
        String str2;
        String valueOf;
        a("queryId : " + aVar.c);
        Cursor cursor2 = null;
        r0 = null;
        String str3 = null;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{aVar.c}, null);
            if (cursor != null) {
                try {
                    d a2 = a(cursor);
                    str3 = a2.a;
                    aVar.a(str3);
                    aVar.a(a2.c);
                    aVar.a(a2.b);
                    a(aVar.c + " errorCode : " + aVar.d);
                    if (a2.b != 1000) {
                        c(context);
                        if (!a(context, false)) {
                            str2 = "not support, forceQuery isSupported: ";
                            valueOf = String.valueOf(a(context, true));
                        }
                    }
                    if (cursor == null) {
                        return str3;
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    str = null;
                    cursor2 = cursor;
                    try {
                        a("queryId, Exception : " + e2.getMessage());
                        if (cursor2 != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
                cursor.close();
                return str3;
            }
            if (a(context, false)) {
                str2 = "forceQuery isSupported : ";
                valueOf = String.valueOf(a(context, true));
            }
            if (cursor == null) {
            }
            cursor.close();
            return str3;
            a(str2.concat(valueOf));
            if (cursor == null) {
            }
        } catch (Exception e4) {
            e2 = e4;
            str = null;
            a("queryId, Exception : " + e2.getMessage());
            if (cursor2 != null) {
                return str;
            }
            cursor = cursor2;
            str3 = str;
            cursor.close();
            return str3;
        }
        cursor.close();
        return str3;
    }

    public static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            a("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    private synchronized void c(Context context) {
        if (this.f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            e eVar = new e();
            this.f = eVar;
            context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
        }
    }

    public final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else if (aVar.a()) {
            return aVar.b;
        } else {
            if (a(context, true)) {
                return b(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    public final boolean a(Context context, boolean z) {
        if (this.e.a() && !z) {
            return this.e.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String a2 = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String b2 = b(packageManager, a2);
        if (!this.e.a() || !this.e.a(b2)) {
            this.e.b(b2);
            boolean a3 = a(context);
            a("query support, result : ".concat(String.valueOf(a3)));
            this.e.a(a3);
            return a3;
        }
        a("use same version cache, safeVersion : ".concat(String.valueOf(b2)));
        return this.e.b();
    }
}
