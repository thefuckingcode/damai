package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.ag;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.hu;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class bb {
    public static int a(ba baVar, hp hpVar) {
        int i = 1;
        if (bc.a[hpVar.ordinal()] != 1) {
            i = 0;
        }
        return baVar.a(hpVar, i);
    }

    private static List<Pair<Integer, Object>> a(List<hu> list, boolean z) {
        if (ag.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (hu huVar : list) {
            int a = huVar.a();
            hq a2 = hq.a(huVar.b());
            if (a2 != null) {
                if (!z || !huVar.f503a) {
                    int i = bc.b[a2.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a), Boolean.valueOf(huVar.g())) : new Pair(Integer.valueOf(a), huVar.m569a()) : new Pair(Integer.valueOf(a), Long.valueOf(huVar.m568a())) : new Pair(Integer.valueOf(a), Integer.valueOf(huVar.c())));
                } else {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                }
            }
        }
        return arrayList;
    }

    public static void a(ba baVar, ig igVar) {
        baVar.a(a(igVar.a(), true));
        baVar.b();
    }

    public static void a(ba baVar, ih ihVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (hs hsVar : ihVar.a()) {
            arrayList.add(new Pair<>(hsVar.m564a(), Integer.valueOf(hsVar.a())));
            List<Pair<Integer, Object>> a = a(hsVar.f495a, false);
            if (!ag.a(a)) {
                arrayList2.addAll(a);
            }
        }
        baVar.a(arrayList, arrayList2);
        baVar.b();
    }
}
