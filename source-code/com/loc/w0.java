package com.loc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import tb.p43;

/* compiled from: Taobao */
public final class w0 {
    private List<y0> a = new ArrayList();
    private p43 b;
    private ArrayList<y0> c = new ArrayList<>();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Comparator<y0> {
        a(w0 w0Var) {
        }

        private static int a(y0 y0Var, y0 y0Var2) {
            return y0Var2.c - y0Var.c;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(y0 y0Var, y0 y0Var2) {
            return a(y0Var, y0Var2);
        }
    }

    private static List<y0> a(List<y0> list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            y0 y0Var = list.get(i);
            hashMap.put(Integer.valueOf(y0Var.c), y0Var);
        }
        arrayList.addAll(hashMap.values());
        return arrayList;
    }

    private static boolean c(List<y0> list, List<y0> list2) {
        if (!(list == null || list2 == null)) {
            int size = list.size();
            int size2 = list2.size();
            int i = size + size2;
            if (size <= size2) {
                list2 = list;
                list = list2;
            }
            HashMap hashMap = new HashMap(list.size());
            for (y0 y0Var : list) {
                hashMap.put(Long.valueOf(y0Var.a), 1);
            }
            int i2 = 0;
            for (y0 y0Var2 : list2) {
                if (((Integer) hashMap.get(Long.valueOf(y0Var2.a))) != null) {
                    i2++;
                }
            }
            if (((double) i2) * 2.0d >= ((double) i) * 0.5d) {
                return true;
            }
        }
        return false;
    }

    private boolean d(p43 p43) {
        float f = p43.e;
        float f2 = 10.0f;
        if (f > 10.0f) {
            f2 = 200.0f;
        } else if (f > 2.0f) {
            f2 = 50.0f;
        }
        return p43.a(this.b) > ((double) f2);
    }

    private static boolean e(p43 p43, long j, long j2) {
        return j > 0 && j2 - j < ((long) ((p43.e > 10.0f ? 1 : (p43.e == 10.0f ? 0 : -1)) >= 0 ? 2000 : 3500));
    }

    private List<y0> f(List<y0> list) {
        Collections.sort(list, new a(this));
        return list;
    }

    private void g(List<y0> list, List<y0> list2) {
        list.clear();
        if (list2 != null) {
            List<y0> f = f(a(list2));
            int size = f.size();
            if (size > 40) {
                size = 40;
            }
            for (int i = 0; i < size; i++) {
                list.add(f.get(i));
            }
        }
    }

    private boolean h(p43 p43, List<y0> list, boolean z, long j, long j2) {
        if (!z || !e(p43, j, j2) || list == null || list.size() <= 0) {
            return false;
        }
        if (this.b == null) {
            return true;
        }
        boolean d = d(p43);
        return !d ? !c(list, this.a) : d;
    }

    /* access modifiers changed from: package-private */
    public final List<y0> b(p43 p43, List<y0> list, boolean z, long j, long j2) {
        if (!h(p43, list, z, j, j2)) {
            return null;
        }
        g(this.c, list);
        this.a.clear();
        this.a.addAll(list);
        this.b = p43;
        return this.c;
    }
}
