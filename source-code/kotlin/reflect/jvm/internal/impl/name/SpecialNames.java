package kotlin.reflect.jvm.internal.impl.name;

import com.lzy.okgo.cookie.SerializableCookie;

public class SpecialNames {
    public static final Name ANONYMOUS_FUNCTION = Name.special("<anonymous>");
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT = Name.identifier("Companion");
    public static final Name NO_NAME_PROVIDED = Name.special("<no name provided>");
    public static final Name ROOT_PACKAGE = Name.special("<root package>");
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = i != 1 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i != 1 ? 2 : 3)];
        if (i != 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        } else {
            objArr[0] = SerializableCookie.NAME;
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

    public static Name safeIdentifier(Name name) {
        if (name == null || name.isSpecial()) {
            name = SAFE_IDENTIFIER_FOR_NO_NAME;
        }
        if (name == null) {
            $$$reportNull$$$0(0);
        }
        return name;
    }

    public static boolean isSafeIdentifier(Name name) {
        if (name == null) {
            $$$reportNull$$$0(1);
        }
        return !name.asString().isEmpty() && !name.isSpecial();
    }
}
