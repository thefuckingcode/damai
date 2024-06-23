package tb;

import app.visly.stretch.AlignContent;
import app.visly.stretch.AlignItems;
import app.visly.stretch.AlignSelf;
import app.visly.stretch.Direction;
import app.visly.stretch.Display;
import app.visly.stretch.FlexDirection;
import app.visly.stretch.FlexWrap;
import app.visly.stretch.JustifyContent;
import app.visly.stretch.Overflow;
import app.visly.stretch.PositionType;
import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class cp0 {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private final Display a;
    @Nullable
    private final PositionType b;
    @Nullable
    private final Direction c;
    @Nullable
    private final FlexDirection d;
    @Nullable
    private final FlexWrap e;
    @Nullable
    private final Overflow f;
    @Nullable
    private final AlignItems g;
    @Nullable
    private final AlignSelf h;
    @Nullable
    private final AlignContent i;
    @Nullable
    private final JustifyContent j;
    @Nullable
    private final ox1<m70> k;
    @Nullable
    private final ox1<m70> l;
    @Nullable
    private final ox1<m70> m;
    @Nullable
    private final ox1<m70> n;
    @Nullable
    private final Float o;
    @Nullable
    private final Float p;
    @Nullable
    private final m70 q;
    @Nullable
    private final ob2<m70> r;
    @Nullable
    private final ob2<m70> s;
    @Nullable
    private final ob2<m70> t;
    @Nullable
    private final Float u;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final cp0 a(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "css");
            if (jSONObject.isEmpty()) {
                return new cp0(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
            }
            dp0 dp0 = dp0.INSTANCE;
            return new cp0(dp0.g(jSONObject), dp0.u(jSONObject), dp0.f(jSONObject), dp0.i(jSONObject), dp0.l(jSONObject), dp0.q(jSONObject), dp0.b(jSONObject), dp0.c(jSONObject), dp0.a(jSONObject), dp0.m(jSONObject), dp0.s(jSONObject), dp0.n(jSONObject), dp0.r(jSONObject), dp0.e(jSONObject), dp0.j(jSONObject), dp0.k(jSONObject), dp0.h(jSONObject), dp0.v(jSONObject), dp0.p(jSONObject), dp0.o(jSONObject), dp0.d(jSONObject));
        }

        @NotNull
        public final cp0 b(@NotNull cp0 cp0, @NotNull cp0 cp02) {
            k21.i(cp0, "lowPriorityStyle");
            k21.i(cp02, "heightPriorityStyle");
            Display g = cp02.g();
            if (g == null) {
                g = cp0.g();
            }
            PositionType t = cp02.t();
            if (t == null) {
                t = cp0.t();
            }
            Direction f = cp02.f();
            if (f == null) {
                f = cp0.f();
            }
            FlexDirection i = cp02.i();
            if (i == null) {
                i = cp0.i();
            }
            FlexWrap l = cp02.l();
            if (l == null) {
                l = cp0.l();
            }
            Overflow q = cp02.q();
            if (q == null) {
                q = cp0.q();
            }
            AlignItems b = cp02.b();
            if (b == null) {
                b = cp0.b();
            }
            AlignSelf c = cp02.c();
            if (c == null) {
                c = cp0.c();
            }
            AlignContent a = cp02.a();
            if (a == null) {
                a = cp0.a();
            }
            JustifyContent m = cp02.m();
            if (m == null) {
                m = cp0.m();
            }
            yq0 yq0 = yq0.INSTANCE;
            ox1<m70> a2 = yq0.a(cp02.s(), cp0.s());
            ox1<m70> a3 = yq0.a(cp02.n(), cp0.n());
            ox1<m70> a4 = yq0.a(cp02.r(), cp0.r());
            ox1<m70> a5 = yq0.a(cp02.e(), cp0.e());
            Float j = cp02.j();
            if (j == null) {
                j = cp0.j();
            }
            Float k = cp02.k();
            if (k == null) {
                k = cp0.k();
            }
            m70 h = cp02.h();
            if (h == null) {
                h = cp0.h();
            }
            ob2<m70> c2 = yq0.c(cp02.u(), cp0.u());
            ob2<m70> c3 = yq0.c(cp02.p(), cp0.p());
            ob2<m70> c4 = yq0.c(cp02.o(), cp0.o());
            Float d = cp02.d();
            if (d == null) {
                d = cp0.d();
            }
            return new cp0(g, t, f, i, l, q, b, c, a, m, a2, a3, a4, a5, j, k, h, c2, c3, c4, d);
        }

        @NotNull
        public final cp0 c(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "css");
            if (jSONObject.isEmpty()) {
                return new cp0(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
            }
            dp0 dp0 = dp0.INSTANCE;
            return new cp0(dp0.g(jSONObject), dp0.u(jSONObject), dp0.f(jSONObject), dp0.i(jSONObject), dp0.l(jSONObject), dp0.q(jSONObject), dp0.b(jSONObject), dp0.c(jSONObject), dp0.a(jSONObject), dp0.m(jSONObject), dp0.t(jSONObject), dp0.n(jSONObject), dp0.r(jSONObject), dp0.e(jSONObject), dp0.j(jSONObject), dp0.k(jSONObject), dp0.h(jSONObject), dp0.v(jSONObject), dp0.p(jSONObject), dp0.o(jSONObject), dp0.d(jSONObject));
        }
    }

    public cp0() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public cp0(@Nullable Display display, @Nullable PositionType positionType, @Nullable Direction direction, @Nullable FlexDirection flexDirection, @Nullable FlexWrap flexWrap, @Nullable Overflow overflow, @Nullable AlignItems alignItems, @Nullable AlignSelf alignSelf, @Nullable AlignContent alignContent, @Nullable JustifyContent justifyContent, @Nullable ox1<m70> ox1, @Nullable ox1<m70> ox12, @Nullable ox1<m70> ox13, @Nullable ox1<m70> ox14, @Nullable Float f2, @Nullable Float f3, @Nullable m70 m70, @Nullable ob2<m70> ob2, @Nullable ob2<m70> ob22, @Nullable ob2<m70> ob23, @Nullable Float f4) {
        this.a = display;
        this.b = positionType;
        this.c = direction;
        this.d = flexDirection;
        this.e = flexWrap;
        this.f = overflow;
        this.g = alignItems;
        this.h = alignSelf;
        this.i = alignContent;
        this.j = justifyContent;
        this.k = ox1;
        this.l = ox12;
        this.m = ox13;
        this.n = ox14;
        this.o = f2;
        this.p = f3;
        this.q = m70;
        this.r = ob2;
        this.s = ob22;
        this.t = ob23;
        this.u = f4;
    }

    @Nullable
    public final AlignContent a() {
        return this.i;
    }

    @Nullable
    public final AlignItems b() {
        return this.g;
    }

    @Nullable
    public final AlignSelf c() {
        return this.h;
    }

    @Nullable
    public final Float d() {
        return this.u;
    }

    @Nullable
    public final ox1<m70> e() {
        return this.n;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cp0)) {
            return false;
        }
        cp0 cp0 = (cp0) obj;
        return this.a == cp0.a && this.b == cp0.b && this.c == cp0.c && this.d == cp0.d && this.e == cp0.e && this.f == cp0.f && this.g == cp0.g && this.h == cp0.h && this.i == cp0.i && this.j == cp0.j && k21.d(this.k, cp0.k) && k21.d(this.l, cp0.l) && k21.d(this.m, cp0.m) && k21.d(this.n, cp0.n) && k21.d(this.o, cp0.o) && k21.d(this.p, cp0.p) && k21.d(this.q, cp0.q) && k21.d(this.r, cp0.r) && k21.d(this.s, cp0.s) && k21.d(this.t, cp0.t) && k21.d(this.u, cp0.u);
    }

    @Nullable
    public final Direction f() {
        return this.c;
    }

    @Nullable
    public final Display g() {
        return this.a;
    }

    @Nullable
    public final m70 h() {
        return this.q;
    }

    public int hashCode() {
        Display display = this.a;
        int i2 = 0;
        int hashCode = (display == null ? 0 : display.hashCode()) * 31;
        PositionType positionType = this.b;
        int hashCode2 = (hashCode + (positionType == null ? 0 : positionType.hashCode())) * 31;
        Direction direction = this.c;
        int hashCode3 = (hashCode2 + (direction == null ? 0 : direction.hashCode())) * 31;
        FlexDirection flexDirection = this.d;
        int hashCode4 = (hashCode3 + (flexDirection == null ? 0 : flexDirection.hashCode())) * 31;
        FlexWrap flexWrap = this.e;
        int hashCode5 = (hashCode4 + (flexWrap == null ? 0 : flexWrap.hashCode())) * 31;
        Overflow overflow = this.f;
        int hashCode6 = (hashCode5 + (overflow == null ? 0 : overflow.hashCode())) * 31;
        AlignItems alignItems = this.g;
        int hashCode7 = (hashCode6 + (alignItems == null ? 0 : alignItems.hashCode())) * 31;
        AlignSelf alignSelf = this.h;
        int hashCode8 = (hashCode7 + (alignSelf == null ? 0 : alignSelf.hashCode())) * 31;
        AlignContent alignContent = this.i;
        int hashCode9 = (hashCode8 + (alignContent == null ? 0 : alignContent.hashCode())) * 31;
        JustifyContent justifyContent = this.j;
        int hashCode10 = (hashCode9 + (justifyContent == null ? 0 : justifyContent.hashCode())) * 31;
        ox1<m70> ox1 = this.k;
        int hashCode11 = (hashCode10 + (ox1 == null ? 0 : ox1.hashCode())) * 31;
        ox1<m70> ox12 = this.l;
        int hashCode12 = (hashCode11 + (ox12 == null ? 0 : ox12.hashCode())) * 31;
        ox1<m70> ox13 = this.m;
        int hashCode13 = (hashCode12 + (ox13 == null ? 0 : ox13.hashCode())) * 31;
        ox1<m70> ox14 = this.n;
        int hashCode14 = (hashCode13 + (ox14 == null ? 0 : ox14.hashCode())) * 31;
        Float f2 = this.o;
        int hashCode15 = (hashCode14 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.p;
        int hashCode16 = (hashCode15 + (f3 == null ? 0 : f3.hashCode())) * 31;
        m70 m70 = this.q;
        int hashCode17 = (hashCode16 + (m70 == null ? 0 : m70.hashCode())) * 31;
        ob2<m70> ob2 = this.r;
        int hashCode18 = (hashCode17 + (ob2 == null ? 0 : ob2.hashCode())) * 31;
        ob2<m70> ob22 = this.s;
        int hashCode19 = (hashCode18 + (ob22 == null ? 0 : ob22.hashCode())) * 31;
        ob2<m70> ob23 = this.t;
        int hashCode20 = (hashCode19 + (ob23 == null ? 0 : ob23.hashCode())) * 31;
        Float f4 = this.u;
        if (f4 != null) {
            i2 = f4.hashCode();
        }
        return hashCode20 + i2;
    }

    @Nullable
    public final FlexDirection i() {
        return this.d;
    }

    @Nullable
    public final Float j() {
        return this.o;
    }

    @Nullable
    public final Float k() {
        return this.p;
    }

    @Nullable
    public final FlexWrap l() {
        return this.e;
    }

    @Nullable
    public final JustifyContent m() {
        return this.j;
    }

    @Nullable
    public final ox1<m70> n() {
        return this.l;
    }

    @Nullable
    public final ob2<m70> o() {
        return this.t;
    }

    @Nullable
    public final ob2<m70> p() {
        return this.s;
    }

    @Nullable
    public final Overflow q() {
        return this.f;
    }

    @Nullable
    public final ox1<m70> r() {
        return this.m;
    }

    @Nullable
    public final ox1<m70> s() {
        return this.k;
    }

    @Nullable
    public final PositionType t() {
        return this.b;
    }

    @NotNull
    public String toString() {
        return "GXFlexBox(display=" + this.a + ", positionType=" + this.b + ", direction=" + this.c + ", flexDirection=" + this.d + ", flexWrap=" + this.e + ", overflow=" + this.f + ", alignItems=" + this.g + ", alignSelf=" + this.h + ", alignContent=" + this.i + ", justifyContent=" + this.j + ", position=" + this.k + ", margin=" + this.l + ", padding=" + this.m + ", border=" + this.n + ", flexGrow=" + this.o + ", flexShrink=" + this.p + ", flexBasis=" + this.q + ", size=" + this.r + ", minSize=" + this.s + ", maxSize=" + this.t + ", aspectRatio=" + this.u + ')';
    }

    @Nullable
    public final ob2<m70> u() {
        return this.r;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cp0(Display display, PositionType positionType, Direction direction, FlexDirection flexDirection, FlexWrap flexWrap, Overflow overflow, AlignItems alignItems, AlignSelf alignSelf, AlignContent alignContent, JustifyContent justifyContent, ox1 ox1, ox1 ox12, ox1 ox13, ox1 ox14, Float f2, Float f3, m70 m70, ob2 ob2, ob2 ob22, ob2 ob23, Float f4, int i2, m40 m40) {
        this((i2 & 1) != 0 ? null : display, (i2 & 2) != 0 ? null : positionType, (i2 & 4) != 0 ? null : direction, (i2 & 8) != 0 ? null : flexDirection, (i2 & 16) != 0 ? null : flexWrap, (i2 & 32) != 0 ? null : overflow, (i2 & 64) != 0 ? null : alignItems, (i2 & 128) != 0 ? null : alignSelf, (i2 & 256) != 0 ? null : alignContent, (i2 & 512) != 0 ? null : justifyContent, (i2 & 1024) != 0 ? null : ox1, (i2 & 2048) != 0 ? null : ox12, (i2 & 4096) != 0 ? null : ox13, (i2 & 8192) != 0 ? null : ox14, (i2 & 16384) != 0 ? null : f2, (i2 & 32768) != 0 ? null : f3, (i2 & 65536) != 0 ? null : m70, (i2 & 131072) != 0 ? null : ob2, (i2 & 262144) != 0 ? null : ob22, (i2 & 524288) != 0 ? null : ob23, (i2 & 1048576) != 0 ? null : f4);
    }
}
