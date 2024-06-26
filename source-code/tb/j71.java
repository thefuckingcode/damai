package tb;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: Taobao */
public class j71 {
    private static final boolean a = true;
    private static final boolean b = false;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static Queue<b> e = new LinkedList();
        int a;
        int b;
        int c;
        int d;

        private b() {
        }

        /* access modifiers changed from: private */
        public static b c(int i, int i2, int i3) {
            b poll = e.poll();
            if (poll == null) {
                poll = new b();
            }
            poll.a = i;
            poll.b = i2;
            poll.c = i3;
            return poll;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void d() {
            if (e.size() < 100) {
                e.add(this);
            }
        }
    }

    /* compiled from: Taobao */
    private static class c implements Comparator<b> {
        private c() {
        }

        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            int i = bVar.a;
            int i2 = bVar2.a;
            if (i < i2) {
                return -1;
            }
            if (i == i2) {
                int i3 = bVar.d;
                if (i3 == bVar2.d) {
                    return 0;
                }
                if (i3 == 0) {
                    return -1;
                }
            }
            return 1;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d {
        int a;
        int b;
        int c;
        int d;
        d e = null;
        d f = null;

        d(int i, int i2, int i3) {
            if (i > 0) {
                this.a = (i3 - i2) + 1;
            }
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    private List<b> b(int i, int i2, int i3, int i4, List<zv2> list) {
        ArrayList arrayList = new ArrayList();
        for (zv2 zv2 : list) {
            int max = Math.max(i, zv2.a - zv2.f);
            int min = Math.min(i2, zv2.b + zv2.h);
            if (max <= min) {
                int i5 = zv2.c;
                int i6 = zv2.e;
                b c2 = b.c(i5 - i6 >= i3 ? i5 - i6 : i3, max, min);
                c2.d = 0;
                int i7 = zv2.d + zv2.g;
                if (i7 > i4) {
                    i7 = i4;
                }
                b c3 = b.c(i7, max, min);
                c3.d = 1;
                arrayList.add(c2);
                arrayList.add(c3);
            }
        }
        return arrayList;
    }

    private void c(d dVar, b bVar, boolean z) {
        int i = dVar.c;
        int i2 = dVar.d;
        int i3 = bVar.b;
        if (i3 > i || bVar.c < i2) {
            int i4 = (i + i2) / 2;
            if (i4 >= i3) {
                if (dVar.e == null) {
                    dVar.e = new d(dVar.b, i, i4);
                }
                c(dVar.e, bVar, z);
            }
            if (i4 < bVar.c) {
                if (dVar.f == null) {
                    dVar.f = new d(dVar.b, i4 + 1, dVar.d);
                }
                c(dVar.f, bVar, z);
            }
            int d2 = d(dVar);
            dVar.b = d2;
            if (d2 > 0) {
                dVar.a = (i2 - i) + 1;
                return;
            }
            dVar.a = 0;
            d dVar2 = dVar.e;
            if (dVar2 != null) {
                dVar.a = 0 + dVar2.a;
            }
            d dVar3 = dVar.f;
            if (dVar3 != null) {
                dVar.a += dVar3.a;
                return;
            }
            return;
        }
        if (z) {
            dVar.b++;
        } else {
            dVar.b--;
        }
        d dVar4 = dVar.e;
        if (dVar4 != null) {
            c(dVar4, bVar, z);
        }
        d dVar5 = dVar.f;
        if (dVar5 != null) {
            c(dVar5, bVar, z);
        }
        if (dVar.b > 0) {
            dVar.a = (i2 - i) + 1;
            return;
        }
        dVar.a = 0;
        d dVar6 = dVar.e;
        if (dVar6 != null) {
            dVar.a = 0 + dVar6.a;
        }
        d dVar7 = dVar.f;
        if (dVar7 != null) {
            dVar.a += dVar7.a;
        }
    }

    private int d(d dVar) {
        d dVar2 = dVar.e;
        d dVar3 = dVar.f;
        return Math.min(dVar2 == null ? dVar.b : dVar2.b, dVar3 == null ? dVar.b : dVar3.b);
    }

    private int e(int i, int i2, List<b> list) {
        int i3 = 0;
        d dVar = new d(0, i, i2);
        int i4 = 0;
        for (b bVar : list) {
            int i5 = bVar.a;
            if (i5 > i4) {
                int i6 = dVar.a;
                if (i6 > 1) {
                    i3 += (i5 - i4) * (i6 - 1);
                }
                i4 = i5;
            }
            c(dVar, bVar, bVar.d == 0 ? a : b);
        }
        return i3;
    }

    public float a(View view, List<zv2> list, View view2) {
        float f = 0.0f;
        if (!(list == null || list.size() == 0)) {
            int[] b2 = nw2.b(view, view2);
            int i = 0;
            int max = Math.max(0, b2[1]);
            int min = Math.min(nw2.screenHeight, b2[1] + view.getHeight());
            int max2 = Math.max(0, b2[0]);
            int min2 = Math.min(nw2.screenWidth, b2[0] + view.getWidth());
            int i2 = min2 - max2;
            if (i2 <= 0) {
                i2 = 0;
            }
            int i3 = min - max;
            if (i3 > 0) {
                i = i3;
            }
            int i4 = i2 * i;
            if (i4 == 0) {
                return 0.0f;
            }
            List<b> b3 = b(max, min, max2, min2, list);
            if (b3.size() == 0) {
                return 0.0f;
            }
            Collections.sort(b3, new c());
            f = (((float) e(max, min, b3)) * 1.0f) / ((float) i4);
            for (b bVar : b3) {
                if (bVar != null) {
                    bVar.d();
                }
            }
        }
        return f;
    }
}
