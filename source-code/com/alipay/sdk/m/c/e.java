package com.alipay.sdk.m.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.alipay.sdk.m.b.b;

/* compiled from: Taobao */
public class e implements b {
    public static final String a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
        if (query != null) {
            if (query.moveToNext()) {
                str = query.getString(query.getColumnIndex("device_ids_grndid"));
            }
            query.close();
        }
        return str;
    }
}
