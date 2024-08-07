package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bp;

/* compiled from: Taobao */
public class bd {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f914a = "";

    public static String a() {
        if (TextUtils.isEmpty(f914a)) {
            f914a = bp.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f914a);
        long j = a;
        a = 1 + j;
        sb.append(j);
        return sb.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e) {
            b.d("Exception occurred when filtering registration packet id for log. " + e);
            return "UnexpectedId";
        }
    }

    public static String b() {
        return bp.a(32);
    }
}
