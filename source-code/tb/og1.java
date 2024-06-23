package tb;

import com.taobao.weex.ui.view.gesture.WXGestureType;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class og1 implements Comparable<og1> {
    @NotNull
    private final String a;
    private final boolean b;

    private og1(@NotNull String str, boolean z) {
        if (str == null) {
            a(0);
        }
        this.a = str;
        this.b = z;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = WXGestureType.GestureInfo.POINTER_ID;
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 1 || i == 2) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static og1 e(@NotNull String str) {
        if (str == null) {
            a(6);
        }
        if (str.startsWith(jl1.L)) {
            return i(str);
        }
        return f(str);
    }

    @NotNull
    public static og1 f(@NotNull String str) {
        if (str == null) {
            a(3);
        }
        return new og1(str, false);
    }

    public static boolean h(@NotNull String str) {
        if (str == null) {
            a(4);
        }
        if (str.isEmpty() || str.startsWith(jl1.L)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static og1 i(@NotNull String str) {
        if (str == null) {
            a(5);
        }
        if (str.startsWith(jl1.L)) {
            return new og1(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    @NotNull
    public String b() {
        String str = this.a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    /* renamed from: c */
    public int compareTo(og1 og1) {
        return this.a.compareTo(og1.a);
    }

    @NotNull
    public String d() {
        if (!this.b) {
            String b2 = b();
            if (b2 == null) {
                a(2);
            }
            return b2;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof og1)) {
            return false;
        }
        og1 og1 = (og1) obj;
        return this.b == og1.b && this.a.equals(og1.a);
    }

    public boolean g() {
        return this.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
    }

    public String toString() {
        return this.a;
    }
}
