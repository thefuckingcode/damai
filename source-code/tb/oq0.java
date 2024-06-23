package tb;

import android.graphics.Rect;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class oq0 {
    @NotNull
    public static final a Companion = new a(null);
    private final long a;
    private final boolean b;
    private final boolean c;
    private final int d;
    @NotNull
    private final ko0 e;
    @NotNull
    private final ko0 f;
    @NotNull
    private final Rect g;
    @NotNull
    private final GXSliderView.IndicatorPosition h;
    @Nullable
    private final String i;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final Boolean c(JSONObject jSONObject, String str) {
            if (jSONObject.containsKey(str)) {
                return jSONObject.getBoolean(str);
            }
            return null;
        }

        @NotNull
        public final oq0 a(@NotNull JSONObject jSONObject) {
            ko0 ko0;
            ko0 ko02;
            k21.i(jSONObject, "data");
            Long l = jSONObject.getLong("slider-scroll-time-interval");
            long longValue = l == null ? 3000 : l.longValue();
            Boolean c = c(jSONObject, "slider-infinity-scroll");
            boolean booleanValue = c == null ? true : c.booleanValue();
            Boolean c2 = c(jSONObject, "slider-has-indicator");
            boolean booleanValue2 = c2 == null ? true : c2.booleanValue();
            Integer integer = jSONObject.getInteger("slider-selected-index");
            int intValue = integer == null ? 0 : integer.intValue();
            String string = jSONObject.getString("slider-indicator-selected-color");
            Rect rect = null;
            if (string == null) {
                ko0 = null;
            } else {
                ko0 = ko0.Companion.a(string);
            }
            if (ko0 == null) {
                ko0 = ko0.Companion.b("#FFFFFF");
            }
            String string2 = jSONObject.getString("slider-indicator-unselected-color");
            if (string2 == null) {
                ko02 = null;
            } else {
                ko02 = ko0.Companion.a(string2);
            }
            if (ko02 == null) {
                ko02 = ko0.Companion.b("#BBBBBB");
            }
            String string3 = jSONObject.getString("slider-indicator-margin");
            if (string3 != null) {
                rect = mo0.INSTANCE.b(string3);
            }
            return new oq0(longValue, booleanValue, booleanValue2, intValue, ko0, ko02, rect == null ? new Rect() : rect, GXSliderView.IndicatorPosition.Companion.a(jSONObject.getString("slider-indicator-position")), jSONObject.getString("slider-indicator-class-android"));
        }

        @NotNull
        public final oq0 b(@NotNull oq0 oq0, @NotNull JSONObject jSONObject) {
            long j;
            boolean z;
            boolean z2;
            int i;
            ko0 ko0;
            ko0 ko02;
            Rect rect;
            k21.i(oq0, "srcConfig");
            k21.i(jSONObject, "data");
            Long l = jSONObject.getLong("slider-scroll-time-interval");
            if (l == null) {
                j = oq0.h();
            } else {
                j = l.longValue();
            }
            Boolean c = c(jSONObject, "slider-infinity-scroll");
            if (c == null) {
                z = oq0.g();
            } else {
                z = c.booleanValue();
            }
            Boolean c2 = c(jSONObject, "slider-has-indicator");
            if (c2 == null) {
                z2 = oq0.a();
            } else {
                z2 = c2.booleanValue();
            }
            Integer integer = jSONObject.getInteger("slider-selected-index");
            if (integer == null) {
                i = oq0.i();
            } else {
                i = integer.intValue();
            }
            String string = jSONObject.getString("slider-indicator-selected-color");
            GXSliderView.IndicatorPosition indicatorPosition = null;
            if (string == null) {
                ko0 = null;
            } else {
                ko0 = ko0.Companion.a(string);
            }
            if (ko0 == null) {
                ko0 = oq0.e();
            }
            String string2 = jSONObject.getString("slider-indicator-unselected-color");
            if (string2 == null) {
                ko02 = null;
            } else {
                ko02 = ko0.Companion.a(string2);
            }
            if (ko02 == null) {
                ko02 = oq0.f();
            }
            String string3 = jSONObject.getString("slider-indicator-margin");
            if (string3 == null) {
                rect = null;
            } else {
                rect = mo0.INSTANCE.b(string3);
            }
            if (rect == null) {
                rect = oq0.c();
            }
            String string4 = jSONObject.getString("slider-indicator-position");
            if (string4 != null) {
                indicatorPosition = GXSliderView.IndicatorPosition.Companion.a(string4);
            }
            GXSliderView.IndicatorPosition d = indicatorPosition == null ? oq0.d() : indicatorPosition;
            String string5 = jSONObject.getString("slider-indicator-class-android");
            return new oq0(j, z, z2, i, ko0, ko02, rect, d, string5 == null ? oq0.b() : string5);
        }
    }

    public oq0(long j, boolean z, boolean z2, int i2, @NotNull ko0 ko0, @NotNull ko0 ko02, @NotNull Rect rect, @NotNull GXSliderView.IndicatorPosition indicatorPosition, @Nullable String str) {
        k21.i(ko0, "indicatorSelectedColor");
        k21.i(ko02, "indicatorUnselectedColor");
        k21.i(rect, "indicatorMargin");
        k21.i(indicatorPosition, "indicatorPosition");
        this.a = j;
        this.b = z;
        this.c = z2;
        this.d = i2;
        this.e = ko0;
        this.f = ko02;
        this.g = rect;
        this.h = indicatorPosition;
        this.i = str;
    }

    public final boolean a() {
        return this.c;
    }

    @Nullable
    public final String b() {
        return this.i;
    }

    @NotNull
    public final Rect c() {
        return this.g;
    }

    @NotNull
    public final GXSliderView.IndicatorPosition d() {
        return this.h;
    }

    @NotNull
    public final ko0 e() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oq0)) {
            return false;
        }
        oq0 oq0 = (oq0) obj;
        return this.a == oq0.a && this.b == oq0.b && this.c == oq0.c && this.d == oq0.d && k21.d(this.e, oq0.e) && k21.d(this.f, oq0.f) && k21.d(this.g, oq0.g) && this.h == oq0.h && k21.d(this.i, oq0.i);
    }

    @NotNull
    public final ko0 f() {
        return this.f;
    }

    public final boolean g() {
        return this.b;
    }

    public final long h() {
        return this.a;
    }

    public int hashCode() {
        int a2 = tn.a(this.a) * 31;
        boolean z = this.b;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (a2 + i3) * 31;
        boolean z2 = this.c;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int hashCode = (((((((((((i6 + i2) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        String str = this.i;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final int i() {
        return this.d;
    }

    @NotNull
    public String toString() {
        return "GXSliderConfig(scrollTimeInterval=" + this.a + ", infinityScroll=" + this.b + ", hasIndicator=" + this.c + ", selectedIndex=" + this.d + ", indicatorSelectedColor=" + this.e + ", indicatorUnselectedColor=" + this.f + ", indicatorMargin=" + this.g + ", indicatorPosition=" + this.h + ", indicatorClass=" + ((Object) this.i) + ')';
    }
}
