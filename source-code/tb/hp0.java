package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class hp0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final String a;
    @NotNull
    private final String b;
    @NotNull
    private final String c;
    @Nullable
    private final String d;
    @Nullable
    private final String e;
    @Nullable
    private final lq0 f;
    @Nullable
    private final fp0 g;
    @Nullable
    private final oq0 h;
    @Nullable
    private final cq0 i;
    @NotNull
    private final List<hp0> j;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final hp0 b(JSONObject jSONObject) {
            String string = jSONObject.getString("id");
            if (string != null) {
                String string2 = jSONObject.getString("type");
                if (string2 != null) {
                    hp0 d = d(string, jSONObject.getString("class"), string2, jSONObject.getString("sub-type"), jSONObject.getString("view-class-android"), jSONObject);
                    c(jSONObject, d);
                    return d;
                }
                throw new IllegalArgumentException("Layer must have type property");
            }
            throw new IllegalArgumentException("Layer must have id property");
        }

        private final void c(JSONObject jSONObject, hp0 hp0) {
            JSONArray jSONArray = jSONObject.getJSONArray("layers");
            if (jSONArray != null) {
                for (Object obj : jSONArray) {
                    JSONObject jSONObject2 = obj instanceof JSONObject ? (JSONObject) obj : null;
                    if (jSONObject2 != null) {
                        hp0.e().add(hp0.Companion.b(jSONObject2));
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
        private final hp0 d(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
            int i;
            hp0 hp0;
            String string = jSONObject.getString("direction");
            String string2 = jSONObject.getString("edge-insets");
            String string3 = jSONObject.getString("item-spacing");
            if (string3 == null) {
                string3 = jSONObject.getString("line-spacing");
            }
            String string4 = jSONObject.getString("row-spacing");
            if (string4 == null) {
                string4 = jSONObject.getString("interitem-spacing");
            }
            Integer integer = jSONObject.getInteger("column");
            int intValue = integer == null ? 1 : integer.intValue();
            Boolean bool = jSONObject.getBoolean("scroll-enable");
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            String string5 = jSONObject.getString("gravity");
            if (string5 != null) {
                int hashCode = string5.hashCode();
                if (hashCode != -1383228885) {
                    if (hashCode != -1364013995) {
                        if (hashCode == 115029 && string5.equals("top")) {
                            i = 48;
                            if (!g(str3, str4)) {
                                hp0 = new hp0(str, str2 == null ? str : str2, str3, str4, str5, lq0.Companion.a(jSONObject, string, string2, string3, i), null, null, null, null, 896, null);
                            } else if (e(str3, str4)) {
                                hp0 = new hp0(str, str2 == null ? str : str2, str3, str4, str5, null, fp0.Companion.a(jSONObject, string, string2, string3, string4, intValue, booleanValue), null, null, null, 896, null);
                            } else if (h(str3, str4)) {
                                hp0 = new hp0(str, str2 == null ? str : str2, str3, str4, str5, null, null, oq0.Companion.a(jSONObject), null, null, 864, null);
                            } else if (f(str3)) {
                                hp0 = new hp0(str, str2 == null ? str : str2, str3, str4, str5, null, null, null, cq0.Companion.a(jSONObject), null, 736, null);
                            } else {
                                hp0 = new hp0(str, str2 == null ? str : str2, str3, str4, str5, null, null, null, null, null, 896, null);
                            }
                            return hp0;
                        }
                    } else if (string5.equals("center")) {
                        i = 17;
                        if (!g(str3, str4)) {
                        }
                        return hp0;
                    }
                } else if (string5.equals("bottom")) {
                    i = 80;
                    if (!g(str3, str4)) {
                    }
                    return hp0;
                }
            }
            i = null;
            if (!g(str3, str4)) {
            }
            return hp0;
        }

        private final boolean e(String str, String str2) {
            return k21.d(str, "gaia-template") && k21.d(str2, "grid");
        }

        private final boolean f(String str) {
            return k21.d(str, "progress");
        }

        private final boolean g(String str, String str2) {
            return k21.d(str, "gaia-template") && k21.d(str2, "scroll");
        }

        private final boolean h(String str, String str2) {
            return k21.d(str, "gaia-template") && k21.d(str2, "slider");
        }

        @NotNull
        public final hp0 a(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "data");
            return b(jSONObject);
        }
    }

    public hp0(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable lq0 lq0, @Nullable fp0 fp0, @Nullable oq0 oq0, @Nullable cq0 cq0, @NotNull List<hp0> list) {
        k21.i(str, "id");
        k21.i(str2, "css");
        k21.i(str3, "type");
        k21.i(list, "layers");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = lq0;
        this.g = fp0;
        this.h = oq0;
        this.i = cq0;
        this.j = list;
    }

    @NotNull
    public final String a() {
        return this.b;
    }

    @Nullable
    public final String b() {
        return this.e;
    }

    @Nullable
    public final fp0 c() {
        return this.g;
    }

    @NotNull
    public final String d() {
        return this.a;
    }

    @NotNull
    public final List<hp0> e() {
        return this.j;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hp0)) {
            return false;
        }
        hp0 hp0 = (hp0) obj;
        return k21.d(this.a, hp0.a) && k21.d(this.b, hp0.b) && k21.d(this.c, hp0.c) && k21.d(this.d, hp0.d) && k21.d(this.e, hp0.e) && k21.d(this.f, hp0.f) && k21.d(this.g, hp0.g) && k21.d(this.h, hp0.h) && k21.d(this.i, hp0.i) && k21.d(this.j, hp0.j);
    }

    @NotNull
    public final String f() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        return this.c;
    }

    @Nullable
    public final cq0 g() {
        return this.i;
    }

    @Nullable
    public final lq0 h() {
        return this.f;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        lq0 lq0 = this.f;
        int hashCode4 = (hashCode3 + (lq0 == null ? 0 : lq0.hashCode())) * 31;
        fp0 fp0 = this.g;
        int hashCode5 = (hashCode4 + (fp0 == null ? 0 : fp0.hashCode())) * 31;
        oq0 oq0 = this.h;
        int hashCode6 = (hashCode5 + (oq0 == null ? 0 : oq0.hashCode())) * 31;
        cq0 cq0 = this.i;
        if (cq0 != null) {
            i2 = cq0.hashCode();
        }
        return ((hashCode6 + i2) * 31) + this.j.hashCode();
    }

    @Nullable
    public final oq0 i() {
        return this.h;
    }

    @Nullable
    public final String j() {
        return this.d;
    }

    @NotNull
    public final String k() {
        return this.c;
    }

    public final boolean l() {
        return !m() && (k21.d("view", this.c) || k21.d(this.c, "gaia-template"));
    }

    public final boolean m() {
        return v() || p() || w();
    }

    public final boolean n() {
        return k21.d(this.c, "custom") && this.e != null;
    }

    public final boolean o() {
        return k21.d("gaia-template", this.c);
    }

    public final boolean p() {
        return k21.d(this.c, "gaia-template") && k21.d(this.d, "grid");
    }

    public final boolean q() {
        return k21.d("iconfont", this.c);
    }

    public final boolean r() {
        return k21.d("image", this.c);
    }

    public final boolean s() {
        GXRegisterCenter.GXIExtensionCompatibility d2 = GXRegisterCenter.Companion.a().d();
        if (d2 != null && d2.isCompatibilityContainerNestTemplateJudgementCondition()) {
            if ((!k21.d(this.c, "gaia-template") || !k21.d(this.d, "custom") || this.e != null) && (!k21.d(this.c, "gaia-template") || this.d != null || this.e != null)) {
                return false;
            }
            return true;
        } else if (!k21.d(this.c, "gaia-template") || !k21.d(this.d, "custom") || this.e != null) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean t() {
        return k21.d("progress", this.c);
    }

    @NotNull
    public String toString() {
        return "GXLayer(id='" + this.a + "', css='" + this.b + "', type='" + this.c + "', subType=" + ((Object) this.d) + ", customNodeClass=" + ((Object) this.e) + ", scrollConfig=" + this.f + ", gridConfig=" + this.g + ", sliderConfig=" + this.h + ", layers=" + this.j + ')';
    }

    public final boolean u() {
        return k21.d(WXBasicComponentType.RICHTEXT, this.c);
    }

    public final boolean v() {
        return k21.d(this.c, "gaia-template") && k21.d(this.d, "scroll");
    }

    public final boolean w() {
        return k21.d(this.c, "gaia-template") && k21.d(this.d, "slider");
    }

    public final boolean x() {
        return k21.d("text", this.c);
    }

    public final boolean y() {
        return k21.d("view", this.c) || (k21.d("gaia-template", this.c) && this.d == null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hp0(String str, String str2, String str3, String str4, String str5, lq0 lq0, fp0 fp0, oq0 oq0, cq0 cq0, List list, int i2, m40 m40) {
        this(str, str2, str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : lq0, (i2 & 64) != 0 ? null : fp0, (i2 & 128) != 0 ? null : oq0, (i2 & 256) != 0 ? null : cq0, (i2 & 512) != 0 ? new ArrayList() : list);
    }
}
