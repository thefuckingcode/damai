package tb;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class t41 {
    @NotNull
    public static final t41 INSTANCE = new t41();
    @JvmField
    @NotNull
    public static final en0 JVM_FIELD_ANNOTATION_FQ_NAME = new en0("kotlin.jvm.JvmField");

    static {
        k21.h(oi.m(new en0("kotlin.reflect.jvm.internal.ReflectionFactoryImpl")), "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
    }

    private t41() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String str) {
        k21.i(str, "propertyName");
        return e(str) ? str : k21.r(gl1.TYPE_OPEN_URL_METHOD_GET, qf.a(str));
    }

    @JvmStatic
    public static final boolean b(@NotNull String str) {
        k21.i(str, "name");
        return (o.L(str, gl1.TYPE_OPEN_URL_METHOD_GET, false, 2, null)) || (o.L(str, "is", false, 2, null));
    }

    @JvmStatic
    public static final boolean c(@NotNull String str) {
        k21.i(str, "name");
        return o.L(str, "set", false, 2, null);
    }

    @JvmStatic
    @NotNull
    public static final String d(@NotNull String str) {
        String str2;
        k21.i(str, "propertyName");
        if (e(str)) {
            str2 = str.substring(2);
            k21.h(str2, "(this as java.lang.String).substring(startIndex)");
        } else {
            str2 = qf.a(str);
        }
        return k21.r("set", str2);
    }

    @JvmStatic
    public static final boolean e(@NotNull String str) {
        k21.i(str, "name");
        if (!(o.L(str, "is", false, 2, null)) || str.length() == 2) {
            return false;
        }
        char charAt = str.charAt(2);
        if (k21.k(97, charAt) > 0 || k21.k(charAt, 122) > 0) {
            return true;
        }
        return false;
    }
}
