package com.taobao.slide.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.j81;
import tb.o22;

/* compiled from: Taobao */
public class a {
    private static Map<String, j81> c = new ConcurrentHashMap();
    private List<UnitParse> a = new ArrayList();
    public boolean b = false;

    private a(String str) {
        try {
            for (String str2 : str.split("&")) {
                this.a.add(UnitParse.a(str2));
            }
        } catch (Throwable th) {
            this.b = true;
            o22.d("ExpParse", "ExpParse", th, new Object[0]);
        }
    }

    public static void a(j81... j81Arr) {
        if (j81Arr != null) {
            for (j81 j81 : j81Arr) {
                o22.c("ExpParse", "addProperty", "prop", j81);
                if (c.put(j81.b(), j81) != null) {
                    o22.i("ExpParse", "addProperty", "replace prop", j81);
                }
            }
        }
    }

    public static a b(String str) {
        return new a(str);
    }

    public static List<j81> c() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, j81> entry : c.entrySet()) {
            if (!entry.getValue().d()) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    public static String d(String str) {
        j81 j81 = c.get(str);
        if (j81 != null) {
            return j81.c();
        }
        o22.c("ExpParse", "getProperty null", "key", str);
        return null;
    }

    public boolean e() {
        if (this.b) {
            o22.e("ExpParse", "match error", new Object[0]);
            return false;
        }
        try {
            for (UnitParse unitParse : this.a) {
                if (!unitParse.b(c.get(unitParse.a))) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            o22.j("ExpParse", "match", th, new Object[0]);
            return false;
        }
    }
}
