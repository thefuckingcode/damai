package tb;

import android.content.Context;
import android.graphics.Color;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.List;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ko0 {
    public static final int COLOR_TYPE_DYNAMIC = 1;
    public static final int COLOR_TYPE_STATIC = 0;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final ko0 c = new ko0(0, 0);
    private final int a;
    @NotNull
    private final Object b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final String d(String str) {
            if (!o.y(str)) {
                return str;
            }
            return null;
        }

        private final Integer e(String str) {
            if (!(o.L(str, Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, false, 2, null))) {
                return null;
            }
            if (str.length() != 9) {
                return Integer.valueOf(Color.parseColor(str));
            }
            String substring = str.substring(7, str.length());
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring2 = str.substring(1, str.length() - 2);
            k21.h(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return Integer.valueOf(Color.parseColor('#' + substring + substring2));
        }

        private final Integer f(String str) {
            if (!(o.L(str, "rgba(", false, 2, null)) || !(o.v(str, jl1.BRACKET_END_STR, false, 2, null))) {
                return null;
            }
            int i = StringsKt__StringsKt.l0(str, jl1.BRACKET_END_STR, 0, false, 6, null);
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(5, i);
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            List list = StringsKt__StringsKt.z0(substring, new String[]{","}, false, 0, 6, null);
            String str2 = (String) list.get(3);
            Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
            String str3 = (String) list.get(0);
            Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.CharSequence");
            int parseInt = Integer.parseInt(StringsKt__StringsKt.T0(str3).toString());
            String str4 = (String) list.get(1);
            Objects.requireNonNull(str4, "null cannot be cast to non-null type kotlin.CharSequence");
            int parseInt2 = Integer.parseInt(StringsKt__StringsKt.T0(str4).toString());
            String str5 = (String) list.get(2);
            Objects.requireNonNull(str5, "null cannot be cast to non-null type kotlin.CharSequence");
            return Integer.valueOf(Color.argb((int) (Float.parseFloat(StringsKt__StringsKt.T0(str2).toString()) * ((float) 255)), parseInt, parseInt2, Integer.parseInt(StringsKt__StringsKt.T0(str5).toString())));
        }

        private final Integer g(String str) {
            if (!(o.L(str, "rgb(", false, 2, null)) || !(o.v(str, jl1.BRACKET_END_STR, false, 2, null))) {
                return null;
            }
            int i = StringsKt__StringsKt.l0(str, jl1.BRACKET_END_STR, 0, false, 6, null);
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(4, i);
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            List list = StringsKt__StringsKt.z0(substring, new String[]{","}, false, 0, 6, null);
            String str2 = (String) list.get(0);
            Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
            int parseInt = Integer.parseInt(StringsKt__StringsKt.T0(str2).toString());
            String str3 = (String) list.get(1);
            Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.CharSequence");
            int parseInt2 = Integer.parseInt(StringsKt__StringsKt.T0(str3).toString());
            String str4 = (String) list.get(2);
            Objects.requireNonNull(str4, "null cannot be cast to non-null type kotlin.CharSequence");
            return Integer.valueOf(Color.rgb(parseInt, parseInt2, Integer.parseInt(StringsKt__StringsKt.T0(str4).toString())));
        }

        private final Integer h(String str) {
            if (o.w(str, "BLACK", true)) {
                return -16777216;
            }
            if (o.w(str, "DKGRAY", true)) {
                return -12303292;
            }
            if (o.w(str, "GRAY", true)) {
                return -7829368;
            }
            if (o.w(str, "LTGRAY", true)) {
                return -3355444;
            }
            if (o.w(str, "WHITE", true)) {
                return -1;
            }
            if (o.w(str, "RED", true)) {
                return Integer.valueOf((int) SupportMenu.CATEGORY_MASK);
            }
            if (o.w(str, "GREEN", true)) {
                return -16711936;
            }
            if (o.w(str, "BLUE", true)) {
                return -16776961;
            }
            if (o.w(str, "YELLOW", true)) {
                return Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY);
            }
            if (o.w(str, "CYAN", true)) {
                return -16711681;
            }
            if (o.w(str, "MAGENTA", true)) {
                return -65281;
            }
            return o.w(str, "TRANSPARENT", true) ? 0 : null;
        }

        @Nullable
        public final ko0 a(@NotNull String str) {
            k21.i(str, "targetColor");
            String obj = StringsKt__StringsKt.T0(str).toString();
            if (StringsKt__StringsKt.Q(obj, "%", false, 2, null)) {
                List list = StringsKt__StringsKt.z0(obj, new String[]{" "}, false, 0, 6, null);
                if (list.size() == 2) {
                    obj = (String) list.get(0);
                }
            }
            Integer e = e(obj);
            if (e != null) {
                return new ko0(0, Integer.valueOf(e.intValue()), null);
            }
            Integer f = f(obj);
            if (f != null) {
                return new ko0(0, Integer.valueOf(f.intValue()), null);
            }
            Integer g = g(obj);
            if (g != null) {
                return new ko0(0, Integer.valueOf(g.intValue()), null);
            }
            Integer h = h(obj);
            if (h != null) {
                return new ko0(0, Integer.valueOf(h.intValue()), null);
            }
            String d = d(obj);
            if (d == null) {
                return null;
            }
            return new ko0(1, d, null);
        }

        @NotNull
        public final ko0 b(@NotNull String str) {
            k21.i(str, "color");
            Integer e = e(str);
            if (e != null) {
                return new ko0(0, Integer.valueOf(e.intValue()), null);
            }
            throw new IllegalArgumentException("Create hex color error");
        }

        @NotNull
        public final ko0 c() {
            return ko0.c;
        }
    }

    private ko0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public /* synthetic */ ko0(int i, Object obj, m40 m40) {
        this(i, obj);
    }

    public static /* synthetic */ int c(ko0 ko0, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return ko0.b(context);
    }

    public final int b(@Nullable Context context) {
        Integer d = d(context);
        if (d == null) {
            return 0;
        }
        return d.intValue();
    }

    @Nullable
    public final Integer d(@Nullable Context context) {
        GXRegisterCenter.GXIExtensionColor c2;
        Integer convert;
        int i = this.a;
        if (i == 0) {
            return (Integer) this.b;
        }
        if (i != 1 || (c2 = GXRegisterCenter.Companion.a().c()) == null || (convert = c2.convert(context, (String) this.b)) == null) {
            return null;
        }
        return Integer.valueOf(convert.intValue());
    }

    @NotNull
    public String toString() {
        return "GXColor(type=" + this.a + ", value=" + this.b + ')';
    }
}
