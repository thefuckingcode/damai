package com.taobao.android.dinamic;

import android.view.View;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.log.DinamicLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tb.c80;
import tb.h80;
import tb.u70;
import tb.x70;
import tb.z70;

/* compiled from: Taobao */
final class c {
    static void a(View view, x70 x70) {
        z70 c = h80.c(view);
        Map<String, String> map = c.c;
        Map<String, String> map2 = c.d;
        DinamicViewAdvancedConstructor d = b.d(c.a);
        if (!map.isEmpty()) {
            HashMap hashMap = new HashMap();
            ArrayList<String> arrayList = new ArrayList<>(10);
            for (String str : map.keySet()) {
                Object a = u70.a(map.get(str), c.a, x70);
                hashMap.put(str, a);
                if (a == null && b.e()) {
                    DinamicLog.e(b.TAG, String.format("表达式 %s=%s 解析出来的结果为null", str, map.get(str)));
                }
            }
            arrayList.addAll(hashMap.keySet());
            hashMap.putAll(c.b);
            d.bindDataImpl(view, hashMap, arrayList, x70);
        }
        if (!map2.isEmpty()) {
            view.setTag(c80.SUBDATA, x70.a());
            d.setEvents(view, x70);
        }
    }
}
