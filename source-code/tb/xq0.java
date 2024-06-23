package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.youku.arch.v3.data.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.no0;

/* compiled from: Taobao */
public final class xq0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final hp0 a;
    @NotNull
    private final no0 b;
    @Nullable
    private po0 c;
    @Nullable
    private final xo0 d;
    @Nullable
    private final ar0 e;
    @Nullable
    private final wn0 f;
    @Nullable
    private final xq0 g;
    @Nullable
    private JSONObject h;
    @Nullable
    private JSON i;
    @Nullable
    private JSONObject j;
    @Nullable
    private fp0 k;
    @Nullable
    private lq0 l;
    @Nullable
    private oq0 m;
    @Nullable
    private cq0 n;
    @Nullable
    private no0 o;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public static /* synthetic */ xq0 b(a aVar, String str, GXTemplateInfo gXTemplateInfo, xq0 xq0, int i, Object obj) {
            if ((i & 4) != 0) {
                xq0 = null;
            }
            return aVar.a(str, gXTemplateInfo, xq0);
        }

        @NotNull
        public final xq0 a(@NotNull String str, @NotNull GXTemplateInfo gXTemplateInfo, @Nullable xq0 xq0) {
            k21.i(str, "viewId");
            k21.i(gXTemplateInfo, Constants.TEMPLATE);
            hp0 g = gXTemplateInfo.g(str);
            if (g != null) {
                no0 d = gXTemplateInfo.d(str);
                if (d == null) {
                    d = no0.a.c(no0.Companion, null, 1, null);
                }
                return new xq0(g, d, gXTemplateInfo.e(str), gXTemplateInfo.f(str), gXTemplateInfo.i(str), gXTemplateInfo.c(str), xq0);
            }
            throw new IllegalArgumentException(k21.r("Not found layer by view id, viewId = ", str));
        }
    }

    public xq0(@NotNull hp0 hp0, @NotNull no0 no0, @Nullable po0 po0, @Nullable xo0 xo0, @Nullable ar0 ar0, @Nullable wn0 wn0, @Nullable xq0 xq0) {
        k21.i(hp0, "layer");
        k21.i(no0, "css");
        this.a = hp0;
        this.b = no0;
        this.c = po0;
        this.d = xo0;
        this.e = ar0;
        this.f = wn0;
        this.g = xq0;
    }

    public final boolean A() {
        return this.a.t();
    }

    public final boolean B() {
        return this.a.u();
    }

    public final boolean C() {
        return this.a.v();
    }

    public final boolean D() {
        return this.a.w();
    }

    public final boolean E() {
        return this.a.x();
    }

    public final boolean F() {
        return this.a.y();
    }

    public final void G() {
        H();
        xq0 xq0 = this.g;
        if (xq0 != null) {
            xq0.G();
        }
    }

    public final void H() {
        this.j = null;
        this.i = null;
        this.h = null;
    }

    public final void I(@Nullable po0 po0) {
        this.c = po0;
    }

    public final void J(@Nullable fp0 fp0) {
        this.k = fp0;
    }

    public final void K(@Nullable cq0 cq0) {
        this.n = cq0;
    }

    public final void L(@Nullable lq0 lq0) {
        this.l = lq0;
    }

    public final void M(@Nullable oq0 oq0) {
        this.m = oq0;
    }

    @Nullable
    public final wn0 a() {
        return this.f;
    }

    @NotNull
    public final no0 b() {
        return this.b;
    }

    @Nullable
    public final String c() {
        return this.a.b();
    }

    @Nullable
    public final JSONObject d(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "templateData");
        if (this.h == null) {
            po0 po0 = this.c;
            this.h = po0 == null ? null : po0.getData(jSONObject);
        }
        return this.h;
    }

    @Nullable
    public final po0 e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xq0)) {
            return false;
        }
        xq0 xq0 = (xq0) obj;
        return k21.d(this.a, xq0.a) && k21.d(this.b, xq0.b) && k21.d(this.c, xq0.c) && k21.d(this.d, xq0.d) && k21.d(this.e, xq0.e) && k21.d(this.f, xq0.f) && k21.d(this.g, xq0.g);
    }

    @Nullable
    public final JSON f(@NotNull JSONObject jSONObject) {
        JSONObject data;
        k21.i(jSONObject, "templateData");
        if (this.i == null) {
            po0 po0 = this.c;
            JSON json = null;
            Object obj = (po0 == null || (data = po0.getData(jSONObject)) == null) ? null : data.get("value");
            if (obj instanceof JSON) {
                json = (JSON) obj;
            }
            this.i = json;
        }
        return this.i;
    }

    @Nullable
    public final xo0 g() {
        return this.d;
    }

    @Nullable
    public final JSONObject h(@Nullable JSON json) {
        if (this.j == null) {
            po0 po0 = this.c;
            this.j = po0 == null ? null : po0.getExtend(json);
        }
        return this.j;
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        po0 po0 = this.c;
        int i2 = 0;
        int hashCode2 = (hashCode + (po0 == null ? 0 : po0.hashCode())) * 31;
        xo0 xo0 = this.d;
        int hashCode3 = (hashCode2 + (xo0 == null ? 0 : xo0.hashCode())) * 31;
        ar0 ar0 = this.e;
        int hashCode4 = (hashCode3 + (ar0 == null ? 0 : ar0.hashCode())) * 31;
        wn0 wn0 = this.f;
        int hashCode5 = (hashCode4 + (wn0 == null ? 0 : wn0.hashCode())) * 31;
        xq0 xq0 = this.g;
        if (xq0 != null) {
            i2 = xq0.hashCode();
        }
        return hashCode5 + i2;
    }

    @Nullable
    public final no0 i() {
        return this.o;
    }

    @Nullable
    public final fp0 j() {
        return this.k;
    }

    @Nullable
    public final cq0 k() {
        return this.n;
    }

    @Nullable
    public final lq0 l() {
        return this.l;
    }

    @Nullable
    public final oq0 m() {
        return this.m;
    }

    @NotNull
    public final hp0 n() {
        return this.a;
    }

    @NotNull
    public final String o() {
        return this.a.d();
    }

    @NotNull
    public final String p() {
        return this.a.f();
    }

    @Nullable
    public final ar0 q() {
        return this.e;
    }

    @Nullable
    public final xq0 r() {
        return this.g;
    }

    public final void s(@NotNull wq0 wq0, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        no0 no0;
        k21.i(wq0, "gxTemplateContext");
        po0 po0 = this.c;
        no0 no02 = null;
        JSONObject extend = po0 == null ? null : po0.getExtend(jSONObject2);
        if (extend != null) {
            no0.a aVar = no0.Companion;
            no0 d2 = aVar.d(extend);
            fp0 c2 = this.a.c();
            if (c2 != null) {
                J(fp0.Companion.b(c2, extend));
            }
            lq0 h2 = this.a.h();
            if (h2 != null) {
                L(lq0.Companion.b(h2, extend));
            }
            oq0 i2 = this.a.i();
            if (i2 != null) {
                M(oq0.Companion.b(i2, extend));
            }
            cq0 g2 = this.a.g();
            if (g2 != null) {
                K(cq0.Companion.b(g2, extend));
            }
            no0 = aVar.b(this.b, d2);
        } else {
            fp0 c3 = this.a.c();
            if (c3 != null) {
                J(c3);
            }
            lq0 h3 = this.a.h();
            if (h3 != null) {
                L(h3);
            }
            oq0 i3 = this.a.i();
            if (i3 != null) {
                M(i3);
            }
            cq0 g3 = this.a.g();
            if (g3 != null) {
                K(g3);
            }
            no0 = this.b;
        }
        xq0 xq0 = this.g;
        if (xq0 != null) {
            xq0.s(wq0, null, jSONObject);
        }
        no0.a aVar2 = no0.Companion;
        xq0 xq02 = this.g;
        if (xq02 != null) {
            no02 = xq02.o;
        }
        this.o = aVar2.b(no0, no02);
    }

    public final boolean t() {
        return this.a.l();
    }

    @NotNull
    public String toString() {
        return "GXTemplateNode(layer=" + this.a + ", css=" + this.b + ", dataBinding=" + this.c + ", eventBinding=" + this.d + ", animationBinding=" + this.f + ", visualTemplateNode=" + this.g + ", finalCss=" + this.o + ')';
    }

    public final boolean u() {
        return this.a.m();
    }

    public final boolean v() {
        return this.a.n();
    }

    public final boolean w() {
        return this.a.o();
    }

    public final boolean x() {
        return this.a.p();
    }

    public final boolean y() {
        return this.a.q();
    }

    public final boolean z() {
        return this.a.r();
    }
}
