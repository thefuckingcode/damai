package com.alibaba.android.umbrella.performance;

import android.text.TextUtils;
import java.util.Map;
import tb.fr2;
import tb.zs1;

/* compiled from: Taobao */
public class b {
    public static void a(a aVar) {
        ProcessEntity c;
        if (!d(aVar) && (c = zs1.b().c(aVar.b)) != null) {
            c.addAbTest(aVar.d, aVar.e);
        }
    }

    protected static void b() {
        Map<String, ProcessEntity> d = zs1.b().d();
        if (d != null || d.size() <= 0) {
            for (String str : d.keySet()) {
                ProcessEntity processEntity = d.get(str);
                if (processEntity == null) {
                    d.remove(str);
                } else {
                    d.remove(str);
                    f(processEntity);
                }
            }
        }
    }

    protected static boolean c(a aVar) {
        fr2 fr2;
        if (aVar == null || TextUtils.isEmpty(aVar.b) || (fr2 = aVar.g) == null || TextUtils.isEmpty(fr2.a()) || !zs1.b().e(aVar.b)) {
            return true;
        }
        return false;
    }

    protected static boolean d(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.b) || !zs1.b().e(aVar.b)) {
            return true;
        }
        return false;
    }

    protected static void e(a aVar) {
        ProcessEntity c = zs1.b().c(aVar.b);
        if (c != null) {
            zs1.b().f(c);
            if (c.pageLoad > 0) {
                f(c);
            }
        }
    }

    protected static void f(ProcessEntity processEntity) {
        PerformanceEngine.commitPerformancePage(processEntity);
    }

    protected static void g(a aVar) {
        ProcessEntity c;
        Map<String, String> map;
        if (!d(aVar) && (c = zs1.b().c(aVar.b)) != null && (map = aVar.j) != null && map.size() > 0) {
            c.addArgs(aVar.j);
        }
    }

    protected static void h(a aVar) {
        ProcessEntity c;
        if (!c(aVar) && (c = zs1.b().c(aVar.b)) != null) {
            Map<String, String> map = aVar.j;
            if (map != null && map.size() > 0) {
                c.addArgs(aVar.j);
            }
            if (fr2.PAGELOAD.equals(aVar.g)) {
                c.addPageLoad(aVar.i);
            } else {
                c.addProcess(aVar.g.a(), aVar.i);
            }
        }
    }

    protected static void i(a aVar) {
        ProcessEntity c;
        if (!c(aVar) && !TextUtils.isEmpty(aVar.f) && (c = zs1.b().c(aVar.b)) != null) {
            Map<String, String> map = aVar.j;
            if (map != null && map.size() > 0) {
                c.addArgs(aVar.j);
            }
            fr2 fr2 = aVar.g;
            if (fr2 == fr2.INIT) {
                c.addInit(aVar.f, aVar.i);
            } else if (fr2 == fr2.LIFECYCLE) {
                c.addLifeCycle(aVar.f, aVar.i);
            } else if (fr2 == fr2.NETWORK) {
                c.addNetwork(aVar.f, aVar.i);
            } else if (fr2 == fr2.DATAPARSE) {
                c.addDataParse(aVar.f, aVar.i);
            } else if (fr2 == fr2.SUB_CREATE_VIEW) {
                c.addCreateView(aVar.f, aVar.i);
            } else if (fr2 == fr2.SUB_BIND_VIEW) {
                c.addBindView(aVar.f, aVar.i);
            }
        }
    }

    protected static void j(a aVar) {
        b();
        zs1.b().a(new ProcessEntity(aVar.b, aVar.h));
    }

    public static void k(a aVar) {
        ProcessEntity c;
        if (!d(aVar) && (c = zs1.b().c(aVar.b)) != null) {
            c.setChildBizName(aVar.c);
        }
    }
}
