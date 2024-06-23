package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class dd2 {
    public static final og1 ANONYMOUS_FUNCTION = og1.i("<anonymous>");
    public static final og1 DEFAULT_NAME_FOR_COMPANION_OBJECT = og1.f("Companion");
    public static final og1 NO_NAME_PROVIDED = og1.i("<no name provided>");
    public static final og1 ROOT_PACKAGE = og1.i("<root package>");
    public static final og1 SAFE_IDENTIFIER_FOR_NO_NAME = og1.f("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");

    private static /* synthetic */ void a(int i) {
        String str = i != 1 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i != 1 ? 2 : 3)];
        if (i != 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        } else {
            objArr[0] = "name";
        }
        if (i != 1) {
            objArr[1] = "safeIdentifier";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        }
        if (i == 1) {
            objArr[2] = "isSafeIdentifier";
        }
        String format = String.format(str, objArr);
        if (i != 1) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    public static boolean b(@NotNull og1 og1) {
        if (og1 == null) {
            a(1);
        }
        return !og1.b().isEmpty() && !og1.g();
    }

    @NotNull
    public static og1 c(@Nullable og1 og1) {
        if (og1 == null || og1.g()) {
            og1 = SAFE_IDENTIFIER_FOR_NO_NAME;
        }
        if (og1 == null) {
            a(0);
        }
        return og1;
    }
}
