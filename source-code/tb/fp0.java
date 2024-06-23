package tb;

import android.graphics.Rect;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fp0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final JSONObject a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    @NotNull
    private final Rect f;
    private final boolean g;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final fp0 a(@NotNull JSONObject jSONObject, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i, boolean z) {
            k21.i(jSONObject, "data");
            int max = Math.max(i, 1);
            mo0 mo0 = mo0.INSTANCE;
            int a = mo0.a(str == null ? LiveBundleLayout.TYPE_VERTICAL : str);
            int c = mo0.c(str3);
            int c2 = mo0.c(str4);
            Rect b = mo0.b(str2);
            if (b == null) {
                b = new Rect(0, 0, 0, 0);
            }
            return new fp0(jSONObject, max, a, c, c2, b, z);
        }

        @Nullable
        public final fp0 b(@NotNull fp0 fp0, @NotNull JSONObject jSONObject) {
            Rect rect;
            k21.i(fp0, "srcConfig");
            k21.i(jSONObject, "data");
            Integer integer = jSONObject.getInteger("column");
            Boolean bool = jSONObject.getBoolean("scroll-enable");
            String string = jSONObject.getString("edge-insets");
            String string2 = jSONObject.getString("item-spacing");
            if (string2 == null) {
                string2 = jSONObject.getString("line-spacing");
            }
            String string3 = jSONObject.getString("row-spacing");
            if (string3 == null) {
                string3 = jSONObject.getString("interitem-spacing");
            }
            JSONObject c = fp0.c();
            int max = integer != null ? Math.max(integer.intValue(), 1) : fp0.b();
            int d = fp0.d();
            int c2 = string2 != null ? mo0.INSTANCE.c(string2) : fp0.f();
            int c3 = string3 != null ? mo0.INSTANCE.c(string3) : fp0.g();
            if (string == null || (rect = mo0.INSTANCE.b(string)) == null) {
                rect = fp0.e();
            }
            return new fp0(c, max, d, c2, c3, rect, bool == null ? fp0.h() : bool.booleanValue());
        }
    }

    public fp0(@NotNull JSONObject jSONObject, int i, int i2, int i3, int i4, @NotNull Rect rect, boolean z) {
        k21.i(jSONObject, "data");
        k21.i(rect, "edgeInsets");
        this.a = jSONObject;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = rect;
        this.g = z;
    }

    public final int a(@NotNull wq0 wq0) {
        Object convert;
        k21.i(wq0, WPKFactory.INIT_KEY_CONTEXT);
        GXRegisterCenter.GXIExtensionGrid k = GXRegisterCenter.Companion.a().k();
        if (k == null || (convert = k.convert("column", wq0, this)) == null) {
            return this.b;
        }
        return ((Integer) convert).intValue();
    }

    public final int b() {
        return this.b;
    }

    @NotNull
    public final JSONObject c() {
        return this.a;
    }

    public final int d() {
        return this.c;
    }

    @NotNull
    public final Rect e() {
        return this.f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fp0)) {
            return false;
        }
        fp0 fp0 = (fp0) obj;
        return k21.d(this.a, fp0.a) && this.b == fp0.b && this.c == fp0.c && this.d == fp0.d && this.e == fp0.e && k21.d(this.f, fp0.f) && this.g == fp0.g;
    }

    public final int f() {
        return this.d;
    }

    public final int g() {
        return this.e;
    }

    public final boolean h() {
        return this.g;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
        boolean z = this.g;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public final boolean i() {
        return this.c == 0;
    }

    public final boolean j() {
        return this.c == 1;
    }

    @NotNull
    public String toString() {
        return "GXGridConfig(column=" + this.b + ", direction=" + this.c + ", itemSpacing=" + this.d + ", rowSpacing=" + this.e + ", edgeInsets=" + this.f + ')';
    }
}
