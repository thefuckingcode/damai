package tb;

import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.monitor.impl.data.calculator.ICalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: Taobao */
public class l92 implements ICalculator {
    private final View a;
    private final View b;
    private final boolean c;
    private final List<a> d = new ArrayList();
    private final List<a> e = new ArrayList();
    private final List<a> f = new ArrayList();
    private final List<a> g = new ArrayList();

    /* compiled from: Taobao */
    public static class a implements Comparable<a> {
        private static Queue<a> c = new LinkedList();
        int a;
        int b;

        public static a b(int i, int i2) {
            a poll = c.poll();
            if (poll == null) {
                poll = new a();
            }
            poll.a = i;
            poll.b = i2;
            return poll;
        }

        /* renamed from: a */
        public int compareTo(@NonNull a aVar) {
            int i = this.a;
            int i2 = aVar.a;
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 0 : -1;
        }

        public void c() {
            if (c.size() < 100) {
                c.add(this);
            }
            this.a = 0;
            this.b = 0;
        }
    }

    public l92(View view, View view2, boolean z) {
        this.a = view;
        this.b = view2;
        this.c = z;
    }

    private int a(List<a> list, List<a> list2, boolean z) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            a aVar = list.get(i5);
            if (i4 <= aVar.a) {
                i = (i + i2) - b(i3, i4, list2, z);
                int i6 = aVar.a;
                int i7 = aVar.b;
                int i8 = i7 - i6;
                i3 = i6;
                i2 = i8;
                i4 = i7;
            } else {
                int i9 = aVar.b;
                if (i4 < i9) {
                    i2 = i9 - i3;
                    i4 = i9;
                }
            }
        }
        return (i + i2) - b(i3, i4, list2, z);
    }

    private int b(int i, int i2, List<a> list, boolean z) {
        int i3 = 0;
        if (z && list != null) {
            for (a aVar : list) {
                if (aVar.b >= i) {
                    int i4 = aVar.a;
                    if (i2 < i4) {
                        break;
                    }
                    i3 += Math.min(aVar.b, i2) - Math.max(i4, i);
                }
            }
        }
        return i3;
    }

    private void c(List<zv2> list, List<a> list2, List<a> list3) {
        if (list != null) {
            for (zv2 zv2 : list) {
                a b2 = a.b(zv2.c, zv2.d);
                a b3 = a.b(zv2.a, zv2.b);
                list2.add(b2);
                list3.add(b3);
            }
            Collections.sort(list2);
            Collections.sort(list3);
        }
    }

    private List<a> d(List<a> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            a aVar = list.get(i3);
            if (i2 <= aVar.a) {
                arrayList.add(a.b(i, i2));
                i = aVar.a;
                i2 = aVar.b;
            } else {
                int i4 = aVar.b;
                if (i2 < i4) {
                    i2 = i4;
                }
            }
        }
        if (i != i2) {
            arrayList.add(a.b(i, i2));
        }
        return arrayList;
    }

    private void e(List<a> list) {
        if (list != null) {
            for (a aVar : list) {
                aVar.c();
            }
            list.clear();
        }
    }

    private void f(List<zv2> list, List<a> list2, List<a> list3) {
        if (list != null) {
            for (zv2 zv2 : list) {
                zv2.c();
            }
            list.clear();
        }
        e(list2);
        e(list3);
    }

    @Override // com.taobao.monitor.impl.data.calculator.ICalculator
    public ne calculate() {
        aw2 aw2 = new aw2(this.a, this.b);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        aw2.b(arrayList, arrayList2);
        View f2 = aw2.f();
        c(arrayList, this.d, this.e);
        c(arrayList2, this.f, this.g);
        List<a> d2 = d(this.f);
        List<a> d3 = d(this.g);
        float a2 = ((float) a(this.d, d2, this.c)) / ((float) nw2.screenWidth);
        float a3 = ((float) a(this.e, d3, this.c)) / ((float) nw2.screenHeight);
        f(arrayList, this.d, this.e);
        f(arrayList2, this.f, this.g);
        e(d2);
        e(d3);
        aw2.n();
        float f3 = 0.4f;
        float f4 = a2 > 0.6f ? 0.4f : a2 * 0.5f;
        if (a3 <= 0.8f) {
            f3 = a3 * 0.5f;
        }
        float f5 = f4 + f3;
        boolean g2 = aw2.g();
        View e2 = aw2.e();
        if (f2 == this.b) {
            f2 = null;
        }
        return new ne(l92.class, f5, g2, e2, f2);
    }
}
