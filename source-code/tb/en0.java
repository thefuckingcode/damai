package tb;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class en0 {
    public static final en0 ROOT = new en0("");
    @NotNull
    private final fn0 a;
    private transient en0 b;

    public en0(@NotNull String str) {
        if (str == null) {
            a(1);
        }
        this.a = new fn0(str, this);
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            case 8:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            case 8:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    public static en0 k(@NotNull og1 og1) {
        if (og1 == null) {
            a(13);
        }
        return new en0(fn0.m(og1));
    }

    @NotNull
    public String b() {
        String b2 = this.a.b();
        if (b2 == null) {
            a(4);
        }
        return b2;
    }

    @NotNull
    public en0 c(@NotNull og1 og1) {
        if (og1 == null) {
            a(8);
        }
        return new en0(this.a.c(og1), this);
    }

    public boolean d() {
        return this.a.e();
    }

    @NotNull
    public en0 e() {
        en0 en0 = this.b;
        if (en0 != null) {
            if (en0 == null) {
                a(6);
            }
            return en0;
        } else if (!d()) {
            en0 en02 = new en0(this.a.g());
            this.b = en02;
            return en02;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof en0) && this.a.equals(((en0) obj).a);
    }

    @NotNull
    public List<og1> f() {
        List<og1> h = this.a.h();
        if (h == null) {
            a(11);
        }
        return h;
    }

    @NotNull
    public og1 g() {
        og1 i = this.a.i();
        if (i == null) {
            a(9);
        }
        return i;
    }

    @NotNull
    public og1 h() {
        og1 j = this.a.j();
        if (j == null) {
            a(10);
        }
        return j;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i(@NotNull og1 og1) {
        if (og1 == null) {
            a(12);
        }
        return this.a.k(og1);
    }

    @NotNull
    public fn0 j() {
        fn0 fn0 = this.a;
        if (fn0 == null) {
            a(5);
        }
        return fn0;
    }

    public String toString() {
        return this.a.toString();
    }

    public en0(@NotNull fn0 fn0) {
        if (fn0 == null) {
            a(2);
        }
        this.a = fn0;
    }

    private en0(@NotNull fn0 fn0, en0 en0) {
        if (fn0 == null) {
            a(3);
        }
        this.a = fn0;
        this.b = en0;
    }
}
