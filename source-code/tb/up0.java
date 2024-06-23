package tb;

import android.animation.AnimatorSet;
import android.view.View;
import app.visly.stretch.Display;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.alibaba.gaiax.render.view.GXIRelease;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class up0 {
    @Nullable
    private Map<GXTemplateEngine.h, r61> a;
    @Nullable
    private AnimatorSet b;
    private boolean c;
    @NotNull
    private String d = "";
    @NotNull
    private String e = "";
    private boolean f;
    private boolean g;
    @Nullable
    private View h;
    @Nullable
    private GXShadowLayout i;
    @Nullable
    private View j;
    public xq0 k;
    public sq0 l;
    @Nullable
    private up0 m;
    @Nullable
    private List<up0> n;
    @Nullable
    private GXINodeEvent o;
    @Nullable
    private List<Pair<GXTemplateEngine.h, xq0>> p;

    private final boolean C(up0 up0) {
        if (up0.m().d().getStyle().getDisplay() == Display.None) {
            return false;
        }
        up0 up02 = up0.m;
        if (up02 == null) {
            return true;
        }
        return C(up02);
    }

    public final boolean A() {
        return this.g;
    }

    public final boolean B() {
        return C(this);
    }

    public final boolean D() {
        return n().A();
    }

    public final boolean E() {
        return n().B();
    }

    public final boolean F() {
        return n().C();
    }

    public final boolean G() {
        return n().D();
    }

    public final boolean H() {
        return n().E();
    }

    public final boolean I() {
        return n().F();
    }

    public final void J() {
        this.c = false;
        this.e = "";
        View view = this.h;
        if (view instanceof GXIRelease) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type com.alibaba.gaiax.render.view.GXIRelease");
            ((GXIRelease) view).release();
        }
        this.h = null;
        this.i = null;
        m().a();
        List<up0> list = this.n;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                it.next().J();
            }
        }
        List<up0> list2 = this.n;
        if (list2 != null) {
            list2.clear();
        }
        this.m = null;
    }

    public final void K(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        n().G();
        m().f(wq0, n());
        List<up0> list = this.n;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                it.next().K(wq0);
            }
        }
    }

    public final void L(boolean z) {
        this.c = z;
    }

    public final void M(@Nullable GXShadowLayout gXShadowLayout) {
        this.i = gXShadowLayout;
    }

    public final void N(@Nullable List<up0> list) {
        this.n = list;
    }

    public final void O(@Nullable GXINodeEvent gXINodeEvent) {
        this.o = gXINodeEvent;
    }

    public final void P(@Nullable up0 up0, @NotNull hp0 hp0) {
        String str;
        k21.i(hp0, "layer");
        this.d = hp0.d();
        boolean z = true;
        if (up0 != null) {
            if (this.e.length() <= 0) {
                z = false;
            }
            if (z) {
                str = up0.e + '@' + this.e + '@' + hp0.d();
            } else {
                str = up0.e + '@' + hp0.d();
            }
        } else {
            if (this.e.length() <= 0) {
                z = false;
            }
            if (z) {
                str = this.e + '@' + hp0.d();
            } else {
                str = hp0.d();
            }
        }
        this.e = str;
    }

    public final void Q(@Nullable View view) {
        this.j = view;
    }

    public final void R(@Nullable Map<GXTemplateEngine.h, r61> map) {
        this.a = map;
    }

    public final void S(boolean z) {
        this.g = z;
    }

    public final void T(@Nullable up0 up0) {
        this.m = up0;
    }

    public final void U(@Nullable AnimatorSet animatorSet) {
        this.b = animatorSet;
    }

    public final void V(boolean z) {
        this.f = z;
    }

    public final void W(@NotNull sq0 sq0) {
        k21.i(sq0, "<set-?>");
        this.l = sq0;
    }

    public final void X(@NotNull xq0 xq0) {
        k21.i(xq0, "<set-?>");
        this.k = xq0;
    }

    public final void Y(@Nullable View view) {
        this.h = view;
    }

    public final void a(@NotNull GXTemplateEngine.h hVar, @NotNull xq0 xq0) {
        k21.i(hVar, "templateItem");
        k21.i(xq0, "visualTemplateNode");
        if (this.p == null) {
            this.p = new ArrayList();
        }
        List<Pair<GXTemplateEngine.h, xq0>> list = this.p;
        if (list != null) {
            list.add(new Pair<>(hVar, xq0));
        }
    }

    @Nullable
    public final GXShadowLayout b() {
        return this.i;
    }

    @Nullable
    public final List<Pair<GXTemplateEngine.h, xq0>> c() {
        return this.p;
    }

    @Nullable
    public final List<up0> d() {
        return this.n;
    }

    @Nullable
    public final String e() {
        return n().c();
    }

    @Nullable
    public final GXINodeEvent f() {
        return this.o;
    }

    @NotNull
    public final String g() {
        return this.d;
    }

    @NotNull
    public final String h() {
        return this.e;
    }

    @Nullable
    public final View i() {
        return this.j;
    }

    @Nullable
    public final Map<GXTemplateEngine.h, r61> j() {
        return this.a;
    }

    @Nullable
    public final up0 k() {
        return this.m;
    }

    @Nullable
    public final AnimatorSet l() {
        return this.b;
    }

    @NotNull
    public final sq0 m() {
        sq0 sq0 = this.l;
        if (sq0 != null) {
            return sq0;
        }
        k21.A("stretchNode");
        return null;
    }

    @NotNull
    public final xq0 n() {
        xq0 xq0 = this.k;
        if (xq0 != null) {
            return xq0;
        }
        k21.A("templateNode");
        return null;
    }

    @NotNull
    public final String o() {
        return n().p();
    }

    @Nullable
    public final View p() {
        return this.h;
    }

    public final void q() {
        if (this.o == null) {
            GXRegisterCenter.GXIExtensionNodeEvent m2 = GXRegisterCenter.Companion.a().m();
            this.o = m2 == null ? null : m2.create();
        }
    }

    public final boolean r() {
        return this.c;
    }

    public final boolean s() {
        return n().u();
    }

    public final boolean t() {
        return n().v();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GXNode(id='");
        sb.append(this.d);
        sb.append("', idPath='");
        sb.append(this.e);
        sb.append("', isRoot=");
        sb.append(this.f);
        sb.append(", isNestRoot=");
        sb.append(this.g);
        sb.append(", templateNode=");
        sb.append(n());
        sb.append(", stretchNode=");
        sb.append(m());
        sb.append(", children=");
        List<up0> list = this.n;
        sb.append(list == null ? null : Integer.valueOf(list.size()));
        sb.append(')');
        return sb.toString();
    }

    public final boolean u() {
        return n().w();
    }

    public final boolean v() {
        return n().x();
    }

    public final boolean w() {
        return n().y();
    }

    public final boolean x() {
        return n().z();
    }

    public final boolean y() {
        String b2;
        wn0 a2 = n().a();
        return (a2 == null || (b2 = a2.b()) == null || !(o.w(b2, k61.TAG, true))) ? false : true;
    }

    public final boolean z() {
        return (I() || x()) && n().b().b().g() != null;
    }
}
