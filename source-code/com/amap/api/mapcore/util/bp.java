package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class bp {
    private static volatile bp a;
    private static hg b;
    private Context c;

    private bp(Context context) {
        this.c = context;
        b = b(context);
    }

    public static bp a(Context context) {
        if (a == null) {
            synchronized (bp.class) {
                if (a == null) {
                    a = new bp(context);
                }
            }
        }
        return a;
    }

    private hg b(Context context) {
        try {
            return new hg(context, bo.a());
        } catch (Throwable th) {
            hd.c(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    public synchronized void c(String str) {
        if (b()) {
            b.a(bn.e(str), bn.class);
            b.a(bm.a(str), bm.class);
            b.a(bl.a(str), bl.class);
        }
    }

    public synchronized String d(String str) {
        String str2 = null;
        if (!b()) {
            return null;
        }
        List b2 = b.b(bn.f(str), bn.class);
        if (b2.size() > 0) {
            str2 = ((bn) b2.get(0)).e();
        }
        return str2;
    }

    private boolean b() {
        if (b == null) {
            b = b(this.c);
        }
        return b != null;
    }

    public ArrayList<bk> a() {
        ArrayList<bk> arrayList = new ArrayList<>();
        if (!b()) {
            return arrayList;
        }
        for (bk bkVar : b.b("", bk.class)) {
            arrayList.add(bkVar);
        }
        return arrayList;
    }

    public synchronized List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (!b()) {
            return arrayList;
        }
        arrayList.addAll(a(b.b(bm.a(str), bm.class)));
        return arrayList;
    }

    public synchronized bk a(String str) {
        if (!b()) {
            return null;
        }
        List b2 = b.b(bn.e(str), bk.class);
        if (b2.size() <= 0) {
            return null;
        }
        return (bk) b2.get(0);
    }

    public synchronized void b(bk bkVar) {
        if (b()) {
            b.a(bn.f(bkVar.i()), bn.class);
            b.a(bm.a(bkVar.f()), bm.class);
            b.a(bl.a(bkVar.f()), bl.class);
        }
    }

    public synchronized void a(bk bkVar) {
        if (b()) {
            b.a(bkVar, bn.f(bkVar.i()));
            a(bkVar.f(), bkVar.b());
        }
    }

    private void a(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            String a2 = bm.a(str);
            if (b.b(a2, bm.class).size() > 0) {
                b.a(a2, bm.class);
            }
            String[] split = str2.split(";");
            ArrayList arrayList = new ArrayList();
            for (String str3 : split) {
                arrayList.add(new bm(str, str3));
            }
            b.a((List) arrayList);
        }
    }

    private List<String> a(List<bm> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (bm bmVar : list) {
                arrayList.add(bmVar.a());
            }
        }
        return arrayList;
    }

    public void a(String str, int i, long j, long j2, long j3) {
        if (b()) {
            a(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
        }
    }

    public synchronized void a(String str, int i, long j, long[] jArr, long[] jArr2) {
        if (b()) {
            b.a(new bl(str, j, i, jArr[0], jArr2[0]), bl.a(str));
        }
    }
}
