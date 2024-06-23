package tb;

import android.graphics.Rect;
import com.alibaba.fastjson.JSONObject;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class lq0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final JSONObject a;
    private final int b;
    private final int c;
    @NotNull
    private final Rect d;
    private int e;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final lq0 a(@NotNull JSONObject jSONObject, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num) {
            int i;
            k21.i(jSONObject, "data");
            mo0 mo0 = mo0.INSTANCE;
            if (str == null) {
                str = LiveBundleLayout.TYPE_VERTICAL;
            }
            int a = mo0.a(str);
            int c = mo0.c(str3);
            Rect b = mo0.b(str2);
            if (b == null) {
                b = new Rect(0, 0, 0, 0);
            }
            if (num == null) {
                i = 48;
            } else {
                i = num.intValue();
            }
            return new lq0(jSONObject, a, c, b, i);
        }

        @NotNull
        public final lq0 b(@NotNull lq0 lq0, @NotNull JSONObject jSONObject) {
            Rect rect;
            k21.i(lq0, "srcConfig");
            k21.i(jSONObject, "data");
            String string = jSONObject.getString("edge-insets");
            String string2 = jSONObject.getString("item-spacing");
            if (string2 == null) {
                string2 = jSONObject.getString("line-spacing");
            }
            JSONObject a = lq0.a();
            int b = lq0.b();
            int c = string2 != null ? mo0.INSTANCE.c(string2) : lq0.e();
            if (string == null || (rect = mo0.INSTANCE.b(string)) == null) {
                rect = lq0.c();
            }
            return new lq0(a, b, c, rect, lq0.d());
        }
    }

    public lq0(@NotNull JSONObject jSONObject, int i, int i2, @NotNull Rect rect, int i3) {
        k21.i(jSONObject, "data");
        k21.i(rect, "edgeInsets");
        this.a = jSONObject;
        this.b = i;
        this.c = i2;
        this.d = rect;
        this.e = i3;
    }

    @NotNull
    public final JSONObject a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    @NotNull
    public final Rect c() {
        return this.d;
    }

    public final int d() {
        return this.e;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lq0)) {
            return false;
        }
        lq0 lq0 = (lq0) obj;
        return k21.d(this.a, lq0.a) && this.b == lq0.b && this.c == lq0.c && k21.d(this.d, lq0.d) && this.e == lq0.e;
    }

    public final boolean f() {
        return this.b == 0;
    }

    public final boolean g() {
        return this.b == 1;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e;
    }

    @NotNull
    public String toString() {
        return "GXScrollConfig(direction=" + this.b + ", itemSpacing=" + this.c + ", edgeInsets=" + this.d + ')';
    }
}
