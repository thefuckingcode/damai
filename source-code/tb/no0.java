package tb;

import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class no0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final uq0 a;
    @NotNull
    private final cp0 b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public static /* synthetic */ no0 c(a aVar, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONObject = new JSONObject();
            }
            return aVar.a(jSONObject);
        }

        @NotNull
        public final no0 a(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "data");
            return new no0(uq0.Companion.a(jSONObject), cp0.Companion.a(jSONObject));
        }

        @NotNull
        public final no0 b(@NotNull no0 no0, @Nullable no0 no02) {
            k21.i(no0, "lowPriorityCss");
            if (no02 == null) {
                return no0;
            }
            return new no0(uq0.Companion.b(no0.b(), no02.b()), cp0.Companion.b(no0.a(), no02.a()));
        }

        @NotNull
        public final no0 d(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "data");
            return new no0(uq0.Companion.c(jSONObject), cp0.Companion.c(jSONObject));
        }
    }

    public no0(@NotNull uq0 uq0, @NotNull cp0 cp0) {
        k21.i(uq0, "style");
        k21.i(cp0, "flexBox");
        this.a = uq0;
        this.b = cp0;
    }

    @NotNull
    public final cp0 a() {
        return this.b;
    }

    @NotNull
    public final uq0 b() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof no0)) {
            return false;
        }
        no0 no0 = (no0) obj;
        return k21.d(this.a, no0.a) && k21.d(this.b, no0.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @NotNull
    public String toString() {
        return "GXCss(style=" + this.a + ", flexBox=" + this.b + ')';
    }
}
