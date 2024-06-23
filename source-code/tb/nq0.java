package tb;

import android.content.res.Resources;
import android.util.TypedValue;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.m;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m70;

/* compiled from: Taobao */
public abstract class nq0 {
    @NotNull
    public static final b Companion = new b(null);

    /* compiled from: Taobao */
    public static final class a extends nq0 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        private final float a(String str) {
            return Float.parseFloat(g(str)) / 100.0f;
        }

        private final float b(String str) {
            return Float.parseFloat(h(str));
        }

        private final float c(String str) {
            return e(Float.parseFloat(i(str)));
        }

        private final String g(String str) {
            String substring = str.substring(0, str.length() - 1);
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        private final String h(String str) {
            String substring = str.substring(0, str.length() - 2);
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        private final String i(String str) {
            String substring = str.substring(0, str.length() - 2);
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        @NotNull
        public final nq0 d(@NotNull String str) {
            Float create;
            k21.i(str, "targetSize");
            String obj = StringsKt__StringsKt.T0(str).toString();
            if (o.v(obj, "px", false, 2, null)) {
                return new e(obj, c(obj));
            }
            if (o.v(obj, "pt", false, 2, null)) {
                return new d(obj, b(obj));
            }
            if (o.v(obj, "%", false, 2, null)) {
                return new c(obj, a(obj));
            }
            if (k21.d(obj, "auto")) {
                return a.INSTANCE;
            }
            if (!(!o.y(obj))) {
                return f.INSTANCE;
            }
            Float f = m.i(obj);
            if (f != null) {
                return new e(obj, nq0.Companion.e(f.floatValue()));
            }
            GXRegisterCenter.GXIExtensionSize o = GXRegisterCenter.Companion.a().o();
            if (o == null || (create = o.create(obj)) == null) {
                return f.INSTANCE;
            }
            return new e(obj, create.floatValue());
        }

        public final float e(float f) {
            return (float) rb1.b(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
        }

        public final float f(float f) {
            Float convert;
            kq0 kq0 = kq0.INSTANCE;
            GXTemplateEngine.a aVar = GXTemplateEngine.Companion;
            float min = Math.min(kq0.c(aVar.a().k()), kq0.b(aVar.a().k())) / e(375.0f);
            GXRegisterCenter.GXIExtensionSize o = GXRegisterCenter.Companion.a().o();
            if (!(o == null || (convert = o.convert(min)) == null)) {
                min = convert.floatValue();
            }
            return ((float) rb1.b(e(f))) * Math.max(min, 1.0f);
        }
    }

    /* compiled from: Taobao */
    public static final class c extends nq0 {
        @NotNull
        private final String a;
        private final float b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull String str, float f) {
            super(null);
            k21.i(str, "targetName");
            this.a = str;
            this.b = f;
        }

        @NotNull
        public final String e() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return k21.d(this.a, cVar.a) && k21.d(Float.valueOf(this.b), Float.valueOf(cVar.b));
        }

        public final float f() {
            return this.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.floatToIntBits(this.b);
        }

        @NotNull
        public String toString() {
            return "PE(targetName=" + this.a + ", targetValue=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class d extends nq0 {
        @NotNull
        private final String a;
        private final float b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(@NotNull String str, float f) {
            super(null);
            k21.i(str, "targetName");
            this.a = str;
            this.b = f;
        }

        @NotNull
        public final String e() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return k21.d(this.a, dVar.a) && k21.d(Float.valueOf(this.b), Float.valueOf(dVar.b));
        }

        public final float f() {
            return this.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.floatToIntBits(this.b);
        }

        @NotNull
        public String toString() {
            return "PT(targetName=" + this.a + ", targetValue=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class e extends nq0 {
        @NotNull
        private final String a;
        private final float b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(@NotNull String str, float f) {
            super(null);
            k21.i(str, "targetName");
            this.a = str;
            this.b = f;
        }

        @NotNull
        public final String e() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return k21.d(this.a, eVar.a) && k21.d(Float.valueOf(this.b), Float.valueOf(eVar.b));
        }

        public final float f() {
            return this.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.floatToIntBits(this.b);
        }

        @NotNull
        public String toString() {
            return "PX(targetName=" + this.a + ", targetValue=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class f extends nq0 {
        @NotNull
        public static final f INSTANCE = new f();

        private f() {
            super(null);
        }
    }

    private nq0() {
    }

    public /* synthetic */ nq0(m40 m40) {
        this();
    }

    @NotNull
    public final String a() {
        if (this instanceof e) {
            return ((e) this).e();
        }
        if (this instanceof c) {
            return ((c) this).e();
        }
        if (this instanceof d) {
            return ((d) this).e();
        }
        if (this instanceof a) {
            return "Auto";
        }
        if (this instanceof f) {
            return "Undefined";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final m70 b() {
        if (this instanceof e) {
            return new m70.c(((e) this).f());
        }
        if (this instanceof c) {
            return new m70.b(((c) this).f());
        }
        if (this instanceof d) {
            return new m70.c(Companion.f(((d) this).f()));
        }
        if (this instanceof a) {
            return m70.a.INSTANCE;
        }
        if (this instanceof f) {
            return m70.d.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final float c() {
        if (this instanceof e) {
            return ((e) this).f();
        }
        if (this instanceof c) {
            return ((c) this).f();
        }
        if (this instanceof d) {
            return Companion.f(((d) this).f());
        }
        return 0.0f;
    }

    public final int d() {
        float f2;
        if (this instanceof e) {
            f2 = ((e) this).f();
        } else if (this instanceof c) {
            f2 = ((c) this).f();
        } else if (!(this instanceof d)) {
            return 0;
        } else {
            f2 = Companion.f(((d) this).f());
        }
        return (int) f2;
    }
}
