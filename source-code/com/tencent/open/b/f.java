package com.tencent.open.b;

import com.tencent.open.utils.g;
import com.tencent.open.utils.i;

/* compiled from: Taobao */
public class f {
    public static int a(String str) {
        int a;
        if (g.a() == null || (a = i.a(g.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a;
    }

    public static int a() {
        int a = i.a(g.a(), (String) null).a("Common_HttpRetryCount");
        if (a == 0) {
            return 2;
        }
        return a;
    }
}
