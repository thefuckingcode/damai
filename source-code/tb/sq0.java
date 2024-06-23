package tb;

import app.visly.stretch.AlignContent;
import app.visly.stretch.AlignItems;
import app.visly.stretch.AlignSelf;
import app.visly.stretch.Direction;
import app.visly.stretch.Display;
import app.visly.stretch.FlexDirection;
import app.visly.stretch.FlexWrap;
import app.visly.stretch.JustifyContent;
import app.visly.stretch.Node;
import app.visly.stretch.Overflow;
import app.visly.stretch.PositionType;
import app.visly.stretch.Style;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class sq0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final Node a;
    @Nullable
    private r61 b;
    @Nullable
    private r61 c;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final Style c(wq0 wq0, xq0 xq0) {
            no0 b;
            cp0 cp0 = null;
            Style style = new Style(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, 2097151, null);
            d(wq0, xq0.b().a(), style);
            xq0 r = xq0.r();
            if (!(r == null || (b = r.b()) == null)) {
                cp0 = b.a();
            }
            if (cp0 != null) {
                sq0.Companion.d(wq0, cp0, style);
            }
            style.init();
            return style;
        }

        private final void d(wq0 wq0, cp0 cp0, Style style) {
            Display g = cp0.g();
            if (g != null) {
                style.setDisplay(g);
            }
            Float d = cp0.d();
            if (d != null) {
                style.setAspectRatio(Float.valueOf(d.floatValue()));
            }
            Direction f = cp0.f();
            if (f != null) {
                style.setDirection(f);
            }
            FlexDirection i = cp0.i();
            if (i != null) {
                style.setFlexDirection(i);
            }
            FlexWrap l = cp0.l();
            if (l != null) {
                style.setFlexWrap(l);
            }
            Overflow q = cp0.q();
            if (q != null) {
                style.setOverflow(q);
            }
            AlignItems b = cp0.b();
            if (b != null) {
                style.setAlignItems(b);
            }
            AlignSelf c = cp0.c();
            if (c != null) {
                style.setAlignSelf(c);
            }
            AlignContent a = cp0.a();
            if (a != null) {
                style.setAlignContent(a);
            }
            JustifyContent m = cp0.m();
            if (m != null) {
                style.setJustifyContent(m);
            }
            PositionType t = cp0.t();
            if (t != null) {
                style.setPositionType(t);
            }
            ox1<m70> s = cp0.s();
            if (s != null) {
                style.setPosition(s);
            }
            ox1<m70> n = cp0.n();
            if (n != null) {
                style.setMargin(n);
            }
            ox1<m70> r = cp0.r();
            if (r != null) {
                style.setPadding(r);
            }
            ox1<m70> e = cp0.e();
            if (e != null) {
                style.setBorder(e);
            }
            Float j = cp0.j();
            if (j != null) {
                style.setFlexGrow(j.floatValue());
                wq0.x(true);
            }
            Float k = cp0.k();
            if (k != null) {
                style.setFlexShrink(k.floatValue());
            }
            ob2<m70> u = cp0.u();
            if (u != null) {
                style.setSize(new ob2<>(u.b(), u.a()));
            }
            ob2<m70> p = cp0.p();
            if (p != null) {
                style.setMinSize(new ob2<>(p.b(), p.a()));
            }
            ob2<m70> o = cp0.o();
            if (o != null) {
                style.setMaxSize(new ob2<>(o.b(), o.a()));
            }
        }

        @NotNull
        public final sq0 b(@NotNull wq0 wq0, @NotNull xq0 xq0, @NotNull String str, @NotNull String str2) {
            k21.i(wq0, "gxTemplateContext");
            k21.i(xq0, "gxTemplateNode");
            k21.i(str, "id");
            k21.i(str2, "idPath");
            return new sq0(new Node(str, str2, c(wq0, xq0), new ArrayList()), null, null, 4, null);
        }
    }

    public sq0(@NotNull Node node, @Nullable r61 r61, @Nullable r61 r612) {
        k21.i(node, "node");
        this.a = node;
        this.b = r61;
        this.c = r612;
    }

    private final void g(wq0 wq0, xq0 xq0) {
        Style c2 = Companion.c(wq0, xq0);
        Style style = this.a.getStyle();
        this.a.setStyle(c2);
        this.a.markDirty();
        style.safeFree();
    }

    public final void a() {
        this.b = null;
        this.a.safeFree();
    }

    @Nullable
    public final r61 b() {
        return this.c;
    }

    @Nullable
    public final r61 c() {
        return this.b;
    }

    @NotNull
    public final Node d() {
        return this.a;
    }

    public final void e() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sq0)) {
            return false;
        }
        sq0 sq0 = (sq0) obj;
        return k21.d(this.a, sq0.a) && k21.d(this.b, sq0.b) && k21.d(this.c, sq0.c);
    }

    public final void f(@NotNull wq0 wq0, @NotNull xq0 xq0) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(xq0, "gxTemplateNode");
        g(wq0, xq0);
        this.c = null;
    }

    public final void h(@Nullable r61 r61) {
        this.c = r61;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        r61 r61 = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (r61 == null ? 0 : r61.hashCode())) * 31;
        r61 r612 = this.c;
        if (r612 != null) {
            i = r612.hashCode();
        }
        return hashCode2 + i;
    }

    public final void i(@Nullable r61 r61) {
        this.b = r61;
    }

    @NotNull
    public String toString() {
        return "GXStretchNode(node=" + this.a + ", layout=" + this.b + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sq0(Node node, r61 r61, r61 r612, int i, m40 m40) {
        this(node, (i & 2) != 0 ? null : r61, (i & 4) != 0 ? null : r612);
    }
}
