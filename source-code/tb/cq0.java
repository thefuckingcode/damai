package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.common.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class cq0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final ko0 a;
    @NotNull
    private final ko0 b;
    @NotNull
    private final String c;
    private final boolean d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final cq0 a(@NotNull JSONObject jSONObject) {
            ko0 ko0;
            k21.i(jSONObject, "data");
            String string = jSONObject.getString("stroke-color");
            ko0 ko02 = null;
            if (string == null) {
                ko0 = null;
            } else {
                ko0 = ko0.Companion.a(string);
            }
            if (ko0 == null) {
                ko0 = ko0.Companion.b("#0000FF");
            }
            String string2 = jSONObject.getString("trail-color");
            if (string2 != null) {
                ko02 = ko0.Companion.a(string2);
            }
            if (ko02 == null) {
                ko02 = ko0.Companion.b("#BBBBBB");
            }
            String string3 = jSONObject.getString("progress-type");
            if (string3 == null) {
                string3 = "line";
            }
            Boolean bool = jSONObject.getBoolean(Constants.Name.ANIMATED);
            return new cq0(ko0, ko02, string3, bool == null ? true : bool.booleanValue());
        }

        @NotNull
        public final cq0 b(@NotNull cq0 cq0, @NotNull JSONObject jSONObject) {
            ko0 ko0;
            k21.i(cq0, "srcConfig");
            k21.i(jSONObject, "data");
            String string = jSONObject.getString("stroke-color");
            ko0 ko02 = null;
            if (string == null) {
                ko0 = null;
            } else {
                ko0 = ko0.Companion.a(string);
            }
            if (ko0 == null) {
                ko0 = cq0.c();
            }
            String string2 = jSONObject.getString("trail-color");
            if (string2 != null) {
                ko02 = ko0.Companion.a(string2);
            }
            if (ko02 == null) {
                ko02 = cq0.d();
            }
            String string3 = jSONObject.getString("progress-type");
            if (string3 == null) {
                string3 = cq0.b();
            }
            Boolean bool = jSONObject.getBoolean(Constants.Name.ANIMATED);
            return new cq0(ko0, ko02, string3, bool == null ? cq0.a() : bool.booleanValue());
        }
    }

    public cq0(@NotNull ko0 ko0, @NotNull ko0 ko02, @NotNull String str, boolean z) {
        k21.i(ko0, "strokeColor");
        k21.i(ko02, "trailColor");
        k21.i(str, "progressType");
        this.a = ko0;
        this.b = ko02;
        this.c = str;
        this.d = z;
    }

    public final boolean a() {
        return this.d;
    }

    @NotNull
    public final String b() {
        return this.c;
    }

    @NotNull
    public final ko0 c() {
        return this.a;
    }

    @NotNull
    public final ko0 d() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cq0)) {
            return false;
        }
        cq0 cq0 = (cq0) obj;
        return k21.d(this.a, cq0.a) && k21.d(this.b, cq0.b) && k21.d(this.c, cq0.c) && this.d == cq0.d;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "GXProgressConfig(strokeColor=" + this.a + ", trailColor=" + this.b + ", progressType=" + this.c + ", animated=" + this.d + ')';
    }
}
