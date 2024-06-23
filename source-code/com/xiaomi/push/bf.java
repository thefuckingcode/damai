package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.alipay.sdk.m.p0.b;
import com.alipay.sdk.m.p0.c;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class bf implements au {
    private static String a = "content://com.vivo.vms.IdProvider/IdentifierId/";
    private static String b = (a + "OAID");
    private static String c = (a + "VAID_");
    private static String d = (a + "AAID_");
    private static String e = (a + b.h);
    private static String f = c.c;

    /* renamed from: a  reason: collision with other field name */
    private Context f129a;

    public bf(Context context) {
        this.f129a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r10 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if (r10 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    private String a(String str) {
        Cursor cursor;
        Throwable th;
        String str2 = null;
        try {
            cursor = this.f129a.getContentResolver().query(Uri.parse(str), null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        str2 = cursor.getString(cursor.getColumnIndex("value"));
                    }
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    public String a() {
        return a(b);
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    /* renamed from: a  reason: collision with other method in class */
    public boolean m280a() {
        return "1".equals(u.a(f, "0"));
    }
}
