package com.alipay.sdk.m.u;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.m.l.a;

/* compiled from: Taobao */
public class m {
    public static final String a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
        String str = null;
        if (query != null && query.getCount() > 0) {
            if (query.moveToFirst()) {
                str = query.getString(query.getColumnIndex("url"));
            }
            query.close();
        }
        return str;
    }

    public static String b(Context context) {
        if (EnvUtils.isSandBox()) {
            return a.b;
        }
        if (context == null) {
            return a.a;
        }
        String str = a.a;
        return TextUtils.isEmpty(str) ? a.a : str;
    }
}
