package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bk;

/* compiled from: Taobao */
public class ak {
    public static AbstractPushManager a(Context context, e eVar) {
        return b(context, eVar);
    }

    private static AbstractPushManager b(Context context, e eVar) {
        l.a a = l.m244a(eVar);
        if (a == null || TextUtils.isEmpty(a.a) || TextUtils.isEmpty(a.b)) {
            return null;
        }
        return (AbstractPushManager) bk.a(a.a, a.b, context);
    }
}
