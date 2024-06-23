package tb;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXStyleConvert;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class uq0 {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private final nq0 a;
    @Nullable
    private final Typeface b;
    @Nullable
    private final Typeface c;
    @Nullable
    private final Integer d;
    @Nullable
    private final ko0 e;
    @Nullable
    private final TextUtils.TruncateAt f;
    @Nullable
    private final Integer g;
    @Nullable
    private final ko0 h;
    @Nullable
    private final ip0 i;
    @Nullable
    private final Float j;
    @Nullable
    private final Boolean k;
    @Nullable
    private final Integer l;
    @Nullable
    private final Integer m;
    @Nullable
    private final ox1<nq0> n;
    @Nullable
    private final nq0 o;
    @Nullable
    private final ko0 p;
    @Nullable
    private final jq0 q;
    @Nullable
    private final nq0 r;
    @Nullable
    private final Integer s;
    @Nullable
    private final tp0 t;
    @Nullable
    private final jo0 u;
    @Nullable
    private final ao0 v;
    @Nullable
    private final Boolean w;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final uq0 a(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "css");
            if (jSONObject.isEmpty()) {
                return new uq0(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
            }
            GXStyleConvert a = GXStyleConvert.Companion.a();
            nq0 l = a.l(jSONObject);
            Typeface n = a.n(jSONObject);
            Typeface t = a.t(jSONObject);
            Integer q = a.q(jSONObject);
            ko0 m = a.m(jSONObject);
            TextUtils.TruncateAt s = a.s(jSONObject);
            Integer r = a.r(jSONObject);
            ko0 c = a.c(jSONObject);
            ip0 d = a.d(jSONObject);
            tp0 A = a.A(jSONObject);
            return new uq0(l, n, t, q, m, s, r, c, d, a.B(jSONObject), a.C(jSONObject), a.j(jSONObject), a.y(jSONObject), a.D(jSONObject), a.g(jSONObject), a.e(jSONObject), a.f(jSONObject), a.p(jSONObject), a.F(jSONObject), A, a.h(jSONObject), a.b(jSONObject), a.k(jSONObject));
        }

        @NotNull
        public final uq0 b(@NotNull uq0 uq0, @NotNull uq0 uq02) {
            Boolean bool;
            k21.i(uq0, "lowPriorityStyle");
            k21.i(uq02, "heightPriorityStyle");
            nq0 n = uq02.n();
            if (n == null) {
                n = uq0.n();
            }
            Typeface k = uq02.k();
            if (k == null) {
                k = uq0.k();
            }
            Typeface r = uq02.r();
            if (r == null) {
                r = uq0.r();
            }
            Integer m = uq02.m();
            if (m == null) {
                m = uq0.m();
            }
            ko0 j = uq02.j();
            if (j == null) {
                j = uq0.j();
            }
            TextUtils.TruncateAt q = uq02.q();
            if (q == null) {
                q = uq0.q();
            }
            Integer o = uq02.o();
            if (o == null) {
                o = uq0.o();
            }
            ko0 b = uq02.b();
            if (b == null) {
                b = uq0.b();
            }
            ip0 c = uq02.c();
            if (c == null) {
                c = uq0.c();
            }
            tp0 t = uq02.t();
            if (t == null) {
                t = uq0.t();
            }
            Float u = uq02.u();
            if (u == null) {
                u = uq0.u();
            }
            Boolean v = uq02.v();
            if (v == null) {
                v = uq0.v();
            }
            Integer h = uq02.h();
            if (h == null) {
                h = uq0.h();
            }
            Integer s = uq02.s();
            if (s == null) {
                s = uq0.s();
            }
            ox1<nq0> b2 = yq0.INSTANCE.b(uq02.w(), uq0.w());
            nq0 f = uq02.f();
            if (f == null) {
                f = uq0.f();
            }
            ko0 d = uq02.d();
            if (d == null) {
                d = uq0.d();
            }
            nq0 l = uq02.l();
            if (l == null) {
                l = uq0.l();
            }
            Integer p = uq02.p();
            if (p == null) {
                p = uq0.p();
            }
            jq0 e = uq02.e();
            if (e == null) {
                e = uq0.e();
            }
            jo0 g = uq02.g();
            if (g == null) {
                g = uq0.g();
            }
            ao0 a = uq02.a();
            if (a == null) {
                a = uq0.a();
            }
            GXRegisterCenter.GXIExtensionCompatibility d2 = GXRegisterCenter.Companion.a().d();
            boolean z = true;
            if (d2 == null || !d2.isCompatibilityDataBindingFitContent()) {
                z = false;
            }
            if (!z) {
                bool = uq02.i();
                if (bool == null) {
                    bool = uq0.i();
                }
            } else if (!k21.d(uq0.i(), Boolean.TRUE) || !k21.d(uq02.i(), Boolean.FALSE)) {
                bool = uq02.i();
                if (bool == null) {
                    bool = uq0.i();
                }
            } else {
                bool = uq0.i();
            }
            return new uq0(n, k, r, m, j, q, o, b, c, u, v, h, s, b2, f, d, e, l, p, t, g, a, bool);
        }

        @NotNull
        public final uq0 c(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "css");
            if (jSONObject.isEmpty()) {
                return new uq0(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
            }
            GXStyleConvert a = GXStyleConvert.Companion.a();
            nq0 l = a.l(jSONObject);
            Typeface n = a.n(jSONObject);
            Typeface t = a.t(jSONObject);
            Integer q = a.q(jSONObject);
            ko0 m = a.m(jSONObject);
            TextUtils.TruncateAt s = a.s(jSONObject);
            Integer r = a.r(jSONObject);
            ko0 c = a.c(jSONObject);
            ip0 d = a.d(jSONObject);
            tp0 A = a.A(jSONObject);
            Float B = a.B(jSONObject);
            jq0 f = a.f(jSONObject);
            Boolean C = a.C(jSONObject);
            Integer j = a.j(jSONObject);
            Integer y = a.y(jSONObject);
            ox1<nq0> D = a.D(jSONObject);
            nq0 g = a.g(jSONObject);
            ko0 e = a.e(jSONObject);
            nq0 p = a.p(jSONObject);
            Integer F = a.F(jSONObject);
            jo0 h = a.h(jSONObject);
            ao0 b = a.b(jSONObject);
            GXRegisterCenter.GXIExtensionCompatibility d2 = GXRegisterCenter.Companion.a().d();
            boolean z = false;
            if (d2 != null && d2.isCompatibilityDataBindingFitContent()) {
                z = true;
            }
            return new uq0(l, n, t, q, m, s, r, c, d, B, C, j, y, D, g, e, f, p, F, A, h, b, z ? a.k(jSONObject) : null);
        }
    }

    public uq0() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    public uq0(@Nullable nq0 nq0, @Nullable Typeface typeface, @Nullable Typeface typeface2, @Nullable Integer num, @Nullable ko0 ko0, @Nullable TextUtils.TruncateAt truncateAt, @Nullable Integer num2, @Nullable ko0 ko02, @Nullable ip0 ip0, @Nullable Float f2, @Nullable Boolean bool, @Nullable Integer num3, @Nullable Integer num4, @Nullable ox1<nq0> ox1, @Nullable nq0 nq02, @Nullable ko0 ko03, @Nullable jq0 jq0, @Nullable nq0 nq03, @Nullable Integer num5, @Nullable tp0 tp0, @Nullable jo0 jo0, @Nullable ao0 ao0, @Nullable Boolean bool2) {
        this.a = nq0;
        this.b = typeface;
        this.c = typeface2;
        this.d = num;
        this.e = ko0;
        this.f = truncateAt;
        this.g = num2;
        this.h = ko02;
        this.i = ip0;
        this.j = f2;
        this.k = bool;
        this.l = num3;
        this.m = num4;
        this.n = ox1;
        this.o = nq02;
        this.p = ko03;
        this.q = jq0;
        this.r = nq03;
        this.s = num5;
        this.t = tp0;
        this.u = jo0;
        this.v = ao0;
        this.w = bool2;
    }

    @Nullable
    public final ao0 a() {
        return this.v;
    }

    @Nullable
    public final ko0 b() {
        return this.h;
    }

    @Nullable
    public final ip0 c() {
        return this.i;
    }

    @Nullable
    public final ko0 d() {
        return this.p;
    }

    @Nullable
    public final jq0 e() {
        return this.q;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uq0)) {
            return false;
        }
        uq0 uq0 = (uq0) obj;
        return k21.d(this.a, uq0.a) && k21.d(this.b, uq0.b) && k21.d(this.c, uq0.c) && k21.d(this.d, uq0.d) && k21.d(this.e, uq0.e) && this.f == uq0.f && k21.d(this.g, uq0.g) && k21.d(this.h, uq0.h) && k21.d(this.i, uq0.i) && k21.d(this.j, uq0.j) && k21.d(this.k, uq0.k) && k21.d(this.l, uq0.l) && k21.d(this.m, uq0.m) && k21.d(this.n, uq0.n) && k21.d(this.o, uq0.o) && k21.d(this.p, uq0.p) && k21.d(this.q, uq0.q) && k21.d(this.r, uq0.r) && k21.d(this.s, uq0.s) && k21.d(this.t, uq0.t) && k21.d(this.u, uq0.u) && k21.d(this.v, uq0.v) && k21.d(this.w, uq0.w);
    }

    @Nullable
    public final nq0 f() {
        return this.o;
    }

    @Nullable
    public final jo0 g() {
        return this.u;
    }

    @Nullable
    public final Integer h() {
        return this.l;
    }

    public int hashCode() {
        nq0 nq0 = this.a;
        int i2 = 0;
        int hashCode = (nq0 == null ? 0 : nq0.hashCode()) * 31;
        Typeface typeface = this.b;
        int hashCode2 = (hashCode + (typeface == null ? 0 : typeface.hashCode())) * 31;
        Typeface typeface2 = this.c;
        int hashCode3 = (hashCode2 + (typeface2 == null ? 0 : typeface2.hashCode())) * 31;
        Integer num = this.d;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        ko0 ko0 = this.e;
        int hashCode5 = (hashCode4 + (ko0 == null ? 0 : ko0.hashCode())) * 31;
        TextUtils.TruncateAt truncateAt = this.f;
        int hashCode6 = (hashCode5 + (truncateAt == null ? 0 : truncateAt.hashCode())) * 31;
        Integer num2 = this.g;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        ko0 ko02 = this.h;
        int hashCode8 = (hashCode7 + (ko02 == null ? 0 : ko02.hashCode())) * 31;
        ip0 ip0 = this.i;
        int hashCode9 = (hashCode8 + (ip0 == null ? 0 : ip0.hashCode())) * 31;
        Float f2 = this.j;
        int hashCode10 = (hashCode9 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Boolean bool = this.k;
        int hashCode11 = (hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num3 = this.l;
        int hashCode12 = (hashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.m;
        int hashCode13 = (hashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        ox1<nq0> ox1 = this.n;
        int hashCode14 = (hashCode13 + (ox1 == null ? 0 : ox1.hashCode())) * 31;
        nq0 nq02 = this.o;
        int hashCode15 = (hashCode14 + (nq02 == null ? 0 : nq02.hashCode())) * 31;
        ko0 ko03 = this.p;
        int hashCode16 = (hashCode15 + (ko03 == null ? 0 : ko03.hashCode())) * 31;
        jq0 jq0 = this.q;
        int hashCode17 = (hashCode16 + (jq0 == null ? 0 : jq0.hashCode())) * 31;
        nq0 nq03 = this.r;
        int hashCode18 = (hashCode17 + (nq03 == null ? 0 : nq03.hashCode())) * 31;
        Integer num5 = this.s;
        int hashCode19 = (hashCode18 + (num5 == null ? 0 : num5.hashCode())) * 31;
        tp0 tp0 = this.t;
        int hashCode20 = (hashCode19 + (tp0 == null ? 0 : tp0.hashCode())) * 31;
        jo0 jo0 = this.u;
        int hashCode21 = (hashCode20 + (jo0 == null ? 0 : jo0.hashCode())) * 31;
        ao0 ao0 = this.v;
        int hashCode22 = (hashCode21 + (ao0 == null ? 0 : ao0.hashCode())) * 31;
        Boolean bool2 = this.w;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        return hashCode22 + i2;
    }

    @Nullable
    public final Boolean i() {
        return this.w;
    }

    @Nullable
    public final ko0 j() {
        return this.e;
    }

    @Nullable
    public final Typeface k() {
        return this.b;
    }

    @Nullable
    public final nq0 l() {
        return this.r;
    }

    @Nullable
    public final Integer m() {
        return this.d;
    }

    @Nullable
    public final nq0 n() {
        return this.a;
    }

    @Nullable
    public final Integer o() {
        return this.g;
    }

    @Nullable
    public final Integer p() {
        return this.s;
    }

    @Nullable
    public final TextUtils.TruncateAt q() {
        return this.f;
    }

    @Nullable
    public final Typeface r() {
        return this.c;
    }

    @Nullable
    public final Integer s() {
        return this.m;
    }

    @Nullable
    public final tp0 t() {
        return this.t;
    }

    @NotNull
    public String toString() {
        return "GXStyle(fontSize=" + this.a + ", fontFamily=" + this.b + ", fontWeight=" + this.c + ", fontLines=" + this.d + ", fontColor=" + this.e + ", fontTextOverflow=" + this.f + ", fontTextAlign=" + this.g + ", backgroundColor=" + this.h + ", backgroundImage=" + this.i + ", opacity=" + this.j + ", overflow=" + this.k + ", display=" + this.l + ", hidden=" + this.m + ", padding=" + this.n + ", borderWidth=" + this.o + ", borderColor=" + this.p + ", borderRadius=" + this.q + ", fontLineHeight=" + this.r + ", fontTextDecoration=" + this.s + ", mode=" + this.t + ", boxShadow=" + this.u + ", backdropFilter=" + this.v + ", fitContent=" + this.w + ')';
    }

    @Nullable
    public final Float u() {
        return this.j;
    }

    @Nullable
    public final Boolean v() {
        return this.k;
    }

    @Nullable
    public final ox1<nq0> w() {
        return this.n;
    }

    public final boolean x() {
        return this.h == null && this.i == null && this.j == null && this.v == null && this.k == null && this.o == null && this.p == null && this.q == null && this.u == null;
    }

    public final boolean y() {
        Integer num;
        Integer num2;
        Integer num3 = this.l;
        return (num3 != null && num3.intValue() == 4) || ((num = this.l) != null && num.intValue() == 8) || ((num2 = this.m) != null && num2.intValue() == 4);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ uq0(nq0 nq0, Typeface typeface, Typeface typeface2, Integer num, ko0 ko0, TextUtils.TruncateAt truncateAt, Integer num2, ko0 ko02, ip0 ip0, Float f2, Boolean bool, Integer num3, Integer num4, ox1 ox1, nq0 nq02, ko0 ko03, jq0 jq0, nq0 nq03, Integer num5, tp0 tp0, jo0 jo0, ao0 ao0, Boolean bool2, int i2, m40 m40) {
        this((i2 & 1) != 0 ? null : nq0, (i2 & 2) != 0 ? null : typeface, (i2 & 4) != 0 ? null : typeface2, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : ko0, (i2 & 32) != 0 ? null : truncateAt, (i2 & 64) != 0 ? null : num2, (i2 & 128) != 0 ? null : ko02, (i2 & 256) != 0 ? null : ip0, (i2 & 512) != 0 ? null : f2, (i2 & 1024) != 0 ? null : bool, (i2 & 2048) != 0 ? null : num3, (i2 & 4096) != 0 ? null : num4, (i2 & 8192) != 0 ? null : ox1, (i2 & 16384) != 0 ? null : nq02, (i2 & 32768) != 0 ? null : ko03, (i2 & 65536) != 0 ? null : jq0, (i2 & 131072) != 0 ? null : nq03, (i2 & 262144) != 0 ? null : num5, (i2 & 524288) != 0 ? null : tp0, (i2 & 1048576) != 0 ? null : jo0, (i2 & 2097152) != 0 ? null : ao0, (i2 & 4194304) != 0 ? null : bool2);
    }
}
