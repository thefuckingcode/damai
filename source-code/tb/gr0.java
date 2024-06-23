package tb;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class gr0<T> {
    @NotNull
    private final wq0 a;
    @NotNull
    private final up0 b;

    public gr0(@NotNull wq0 wq0, @NotNull up0 up0) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "rootNode");
        this.a = wq0;
        this.b = up0;
    }

    private final void b(wq0 wq0, up0 up0, T t, List<r61> list) {
        Iterator<T> it;
        List<up0> d = up0.d();
        if (d != null) {
            Iterator<T> it2 = d.iterator();
            while (it2.hasNext()) {
                T next = it2.next();
                xq0 n = next.n();
                r61 b2 = next.m().b();
                if (b2 == null && (b2 = next.m().c()) == null) {
                    throw new IllegalArgumentException("Stretch layout info is null");
                }
                String f = n.n().f();
                String b3 = n.n().b();
                boolean t2 = n.t();
                boolean z = false;
                if (t2 && n.b().b().x() && (n.r() == null || n.r().b().b().x()) && n.a() == null && n.g() == null && n.e() == null && n.q() == null) {
                    List<r61> arrayList = new ArrayList<>();
                    arrayList.addAll(list);
                    arrayList.add(b2);
                    b(wq0, next, t, arrayList);
                    it = it2;
                } else {
                    float f2 = 0.0f;
                    float f3 = 0.0f;
                    for (T t3 : list) {
                        f2 += t3.f();
                        f3 += t3.g();
                    }
                    it = it2;
                    T d2 = d(wq0, t, f, b3, next, b2, f2, f3);
                    if (d2 != null) {
                        List<up0> d3 = next.d();
                        if (d3 != null && (!d3.isEmpty())) {
                            z = true;
                        }
                        if (z) {
                            if (t2) {
                                List<r61> arrayList2 = new ArrayList<>();
                                r61 b4 = r61.b(b2, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 127, null);
                                b4.j(0.0f);
                                b4.k(0.0f);
                                arrayList2.add(b4);
                                b(wq0, next, d2, arrayList2);
                            } else {
                                List<r61> arrayList3 = new ArrayList<>();
                                arrayList3.addAll(list);
                                b(wq0, next, t, arrayList3);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Create child view error");
                    }
                }
                it2 = it;
            }
        }
    }

    @NotNull
    public final View a() {
        r61 b2 = this.b.m().b();
        if (b2 == null && (b2 = this.b.m().c()) == null) {
            throw new IllegalArgumentException(k21.r("Stretch layout info is null gxTemplateContext = ", this.a));
        }
        T e = e(this.a, this.b, b2);
        if (e != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b2);
            b(this.a, this.b, e, arrayList);
            View p = this.b.p();
            if (p != null) {
                return p;
            }
            throw new IllegalArgumentException(k21.r("Create root view error, not found root view gxTemplateContext = ", this.a));
        }
        throw new IllegalArgumentException(k21.r("Create root view error gxTemplateContext = ", this.a));
    }

    @NotNull
    public final up0 c() {
        return this.b;
    }

    @Nullable
    public abstract T d(@NotNull wq0 wq0, T t, @NotNull String str, @Nullable String str2, @NotNull up0 up0, @NotNull r61 r61, float f, float f2);

    @Nullable
    public abstract T e(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull r61 r61);
}
