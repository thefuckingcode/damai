package com.alipay.sdk.m.p0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* compiled from: Taobao */
public class b {
    public static final String b = "VMS_IDLG_SDK_DB";
    public static final String c = "content://com.vivo.vms.IdProvider/IdentifierId";
    public static final String d = "value";
    public static final String e = "OAID";
    public static final String f = "AAID";
    public static final String g = "VAID";
    public static final String h = "OAIDSTATUS";
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 4;
    public Context a;

    public b(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    public String a(int i2, String str) {
        Uri uri;
        Cursor query;
        Uri uri2;
        String str2 = null;
        if (i2 == 0) {
            uri2 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i2 == 1) {
            uri2 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i2 == 2) {
            uri2 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else if (i2 != 4) {
            uri = null;
            query = this.a.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                if (query.moveToNext()) {
                    str2 = query.getString(query.getColumnIndex("value"));
                }
                query.close();
            } else {
                Log.d(b, "return cursor is null,return");
            }
            return str2;
        } else {
            uri2 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
        }
        uri = uri2;
        query = this.a.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
        }
        return str2;
    }
}
