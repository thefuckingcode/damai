package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class a51 {
    private final String a;

    private a51(@NotNull String str) {
        if (str == null) {
            a(5);
        }
        this.a = str;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 3 || i == 6 || i == 7 || i == 8) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 3 || i == 6 || i == 7 || i == 8) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static a51 b(@NotNull oi oiVar) {
        if (oiVar == null) {
            a(1);
        }
        en0 h = oiVar.h();
        String replace = oiVar.i().b().replace('.', '$');
        if (h.d()) {
            return new a51(replace);
        }
        return new a51(h.b().replace('.', v00.DIR) + "/" + replace);
    }

    @NotNull
    public static a51 c(@NotNull en0 en0) {
        if (en0 == null) {
            a(2);
        }
        return new a51(en0.b().replace('.', v00.DIR));
    }

    @NotNull
    public static a51 d(@NotNull String str) {
        if (str == null) {
            a(0);
        }
        return new a51(str);
    }

    @NotNull
    public en0 e() {
        return new en0(this.a.replace(v00.DIR, '.'));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a51.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((a51) obj).a);
    }

    @NotNull
    public String f() {
        String str = this.a;
        if (str == null) {
            a(8);
        }
        return str;
    }

    @NotNull
    public en0 g() {
        int lastIndexOf = this.a.lastIndexOf("/");
        if (lastIndexOf != -1) {
            return new en0(this.a.substring(0, lastIndexOf).replace(v00.DIR, '.'));
        }
        en0 en0 = en0.ROOT;
        if (en0 == null) {
            a(7);
        }
        return en0;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
