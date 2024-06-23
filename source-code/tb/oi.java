package tb;

import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class oi {
    private final en0 a;
    private final en0 b;
    private final boolean c;

    public oi(@NotNull en0 en0, @NotNull en0 en02, boolean z) {
        if (en0 == null) {
            a(1);
        }
        if (en02 == null) {
            a(2);
        }
        this.a = en0;
        this.b = en02;
        this.c = z;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? 2 : 3)];
        switch (i) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i == 7) {
            objArr[1] = "getShortClassName";
        } else if (i == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i == 13 || i == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static oi e(@NotNull String str) {
        if (str == null) {
            a(11);
        }
        return f(str, false);
    }

    @NotNull
    public static oi f(@NotNull String str, boolean z) {
        if (str == null) {
            a(12);
        }
        return new oi(new en0(StringsKt__StringsKt.R0(str, v00.DIR, "").replace(v00.DIR, '.')), new en0(StringsKt__StringsKt.L0(str, v00.DIR, str)), z);
    }

    @NotNull
    public static oi m(@NotNull en0 en0) {
        if (en0 == null) {
            a(0);
        }
        return new oi(en0.e(), en0.g());
    }

    @NotNull
    public en0 b() {
        if (this.a.d()) {
            en0 en0 = this.b;
            if (en0 == null) {
                a(9);
            }
            return en0;
        }
        return new en0(this.a.b() + "." + this.b.b());
    }

    @NotNull
    public String c() {
        if (this.a.d()) {
            String b2 = this.b.b();
            if (b2 == null) {
                a(13);
            }
            return b2;
        }
        String str = this.a.b().replace('.', v00.DIR) + "/" + this.b.b();
        if (str == null) {
            a(14);
        }
        return str;
    }

    @NotNull
    public oi d(@NotNull og1 og1) {
        if (og1 == null) {
            a(8);
        }
        return new oi(h(), this.b.c(og1), this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || oi.class != obj.getClass()) {
            return false;
        }
        oi oiVar = (oi) obj;
        if (!this.a.equals(oiVar.a) || !this.b.equals(oiVar.b) || this.c != oiVar.c) {
            return false;
        }
        return true;
    }

    @Nullable
    public oi g() {
        en0 e = this.b.e();
        if (e.d()) {
            return null;
        }
        return new oi(h(), e, this.c);
    }

    @NotNull
    public en0 h() {
        en0 en0 = this.a;
        if (en0 == null) {
            a(5);
        }
        return en0;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.valueOf(this.c).hashCode();
    }

    @NotNull
    public en0 i() {
        en0 en0 = this.b;
        if (en0 == null) {
            a(6);
        }
        return en0;
    }

    @NotNull
    public og1 j() {
        og1 g = this.b.g();
        if (g == null) {
            a(7);
        }
        return g;
    }

    public boolean k() {
        return this.c;
    }

    public boolean l() {
        return !this.b.e().d();
    }

    public String toString() {
        if (!this.a.d()) {
            return c();
        }
        return "/" + c();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public oi(@NotNull en0 en0, @NotNull og1 og1) {
        this(en0, en0.k(og1), false);
        if (en0 == null) {
            a(3);
        }
        if (og1 == null) {
            a(4);
        }
    }
}
