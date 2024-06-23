package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter {
    public static int DAY_COUNT = 5;
    private android.webkit.DateSorter a;
    private IX5DateSorter b;

    static {
        a();
    }

    public DateSorter(Context context) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            this.a = new android.webkit.DateSorter(context);
        } else {
            this.b = a2.c().h(context);
        }
    }

    public int getIndex(long j) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return this.a.getIndex(j);
        }
        return this.b.getIndex(j);
    }

    public String getLabel(int i) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return this.a.getLabel(i);
        }
        return this.b.getLabel(i);
    }

    public long getBoundary(int i) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return this.a.getBoundary(i);
        }
        return this.b.getBoundary(i);
    }

    private static boolean a() {
        u a2 = u.a();
        return a2 != null && a2.b();
    }
}
