package com.vivo.push.d;

import com.vivo.push.b.t;
import com.vivo.push.e;
import com.vivo.push.m;
import com.vivo.push.o;
import java.util.ArrayList;
import java.util.List;

public final class aa extends z {
    aa(o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(o oVar) {
        t tVar = (t) oVar;
        ArrayList<String> d = tVar.d();
        List<String> e = tVar.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int h = tVar.h();
        String g = tVar.g();
        if (d != null) {
            for (String str : d) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (e != null) {
            for (String str2 : e) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            if (arrayList.size() > 0) {
                e.a().a(arrayList);
            }
            e.a().a(tVar.g(), arrayList3.size() > 0 ? 10000 : h);
            m.b(new ab(this, h, arrayList, arrayList3, g));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            if (arrayList2.size() > 0) {
                e.a().b((String) arrayList2.get(0));
            }
            e.a().a(tVar.g(), h);
            m.b(new ac(this, h, arrayList2, arrayList4, g));
        }
    }
}
