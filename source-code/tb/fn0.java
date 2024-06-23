package tb;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class fn0 {
    private static final og1 e = og1.i("<root>");
    private static final Pattern f = Pattern.compile("\\.");
    private static final Function1<String, og1> g = new a();
    @NotNull
    private final String a;
    private transient en0 b;
    private transient fn0 c;
    private transient og1 d;

    /* compiled from: Taobao */
    static class a implements Function1<String, og1> {
        a() {
        }

        /* renamed from: a */
        public og1 invoke(String str) {
            return og1.e(str);
        }
    }

    fn0(@NotNull String str, @NotNull en0 en0) {
        if (str == null) {
            a(0);
        }
        if (en0 == null) {
            a(1);
        }
        this.a = str;
        this.b = en0;
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(format);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    private void d() {
        int lastIndexOf = this.a.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.d = og1.e(this.a.substring(lastIndexOf + 1));
            this.c = new fn0(this.a.substring(0, lastIndexOf));
            return;
        }
        this.d = og1.e(this.a);
        this.c = en0.ROOT.j();
    }

    @NotNull
    public static fn0 m(@NotNull og1 og1) {
        if (og1 == null) {
            a(16);
        }
        return new fn0(og1.b(), en0.ROOT.j(), og1);
    }

    @NotNull
    public String b() {
        String str = this.a;
        if (str == null) {
            a(4);
        }
        return str;
    }

    @NotNull
    public fn0 c(@NotNull og1 og1) {
        String str;
        if (og1 == null) {
            a(9);
        }
        if (e()) {
            str = og1.b();
        } else {
            str = this.a + "." + og1.b();
        }
        return new fn0(str, this, og1);
    }

    public boolean e() {
        return this.a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof fn0) && this.a.equals(((fn0) obj).a);
    }

    public boolean f() {
        return this.b != null || b().indexOf(60) < 0;
    }

    @NotNull
    public fn0 g() {
        fn0 fn0 = this.c;
        if (fn0 != null) {
            if (fn0 == null) {
                a(7);
            }
            return fn0;
        } else if (!e()) {
            d();
            fn0 fn02 = this.c;
            if (fn02 == null) {
                a(8);
            }
            return fn02;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @NotNull
    public List<og1> h() {
        List<og1> emptyList = e() ? Collections.emptyList() : ArraysKt___ArraysKt.J(f.split(this.a), g);
        if (emptyList == null) {
            a(14);
        }
        return emptyList;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public og1 i() {
        og1 og1 = this.d;
        if (og1 != null) {
            if (og1 == null) {
                a(10);
            }
            return og1;
        } else if (!e()) {
            d();
            og1 og12 = this.d;
            if (og12 == null) {
                a(11);
            }
            return og12;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @NotNull
    public og1 j() {
        if (e()) {
            og1 og1 = e;
            if (og1 == null) {
                a(12);
            }
            return og1;
        }
        og1 i = i();
        if (i == null) {
            a(13);
        }
        return i;
    }

    public boolean k(@NotNull og1 og1) {
        if (og1 == null) {
            a(15);
        }
        if (e()) {
            return false;
        }
        int indexOf = this.a.indexOf(46);
        String str = this.a;
        String b2 = og1.b();
        if (indexOf == -1) {
            indexOf = this.a.length();
        }
        return str.regionMatches(0, b2, 0, indexOf);
    }

    @NotNull
    public en0 l() {
        en0 en0 = this.b;
        if (en0 != null) {
            if (en0 == null) {
                a(5);
            }
            return en0;
        }
        en0 en02 = new en0(this);
        this.b = en02;
        return en02;
    }

    @NotNull
    public String toString() {
        String b2 = e() ? e.b() : this.a;
        if (b2 == null) {
            a(17);
        }
        return b2;
    }

    public fn0(@NotNull String str) {
        if (str == null) {
            a(2);
        }
        this.a = str;
    }

    private fn0(@NotNull String str, fn0 fn0, og1 og1) {
        if (str == null) {
            a(3);
        }
        this.a = str;
        this.c = fn0;
        this.d = og1;
    }
}
