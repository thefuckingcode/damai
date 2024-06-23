package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: capitalizeDecapitalize.kt */
public final class CapitalizeDecapitalizeKt {
    public static final String decapitalizeSmartForCompiler(String str, boolean z) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(str, "$this$decapitalizeSmartForCompiler");
        String str2 = str;
        if ((str2.length() == 0) || !isUpperCaseCharAt(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !isUpperCaseCharAt(str, 1, z)) {
            return z ? decapitalizeAsciiOnly(str) : StringsKt.decapitalize(str);
        }
        Iterator it = StringsKt.getIndices(str2).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!isUpperCaseCharAt(str, ((Number) obj).intValue(), z)) {
                break;
            }
        }
        Integer num = (Integer) obj;
        if (num == null) {
            return toLowerCase(str, z);
        }
        int intValue = num.intValue() - 1;
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, intValue);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(toLowerCase(substring, z));
        String substring2 = str.substring(intValue);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    private static final boolean isUpperCaseCharAt(String str, int i, boolean z) {
        char charAt = str.charAt(i);
        if (z) {
            return 'A' <= charAt && 'Z' >= charAt;
        }
        return Character.isUpperCase(charAt);
    }

    private static final String toLowerCase(String str, boolean z) {
        if (z) {
            return toLowerCaseAsciiOnly(str);
        }
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String capitalizeAsciiOnly(String str) {
        char charAt;
        Intrinsics.checkParameterIsNotNull(str, "$this$capitalizeAsciiOnly");
        if ((str.length() == 0) || 'a' > (charAt = str.charAt(0)) || 'z' < charAt) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        String substring = str.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(upperCase) + substring;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        char charAt;
        Intrinsics.checkParameterIsNotNull(str, "$this$decapitalizeAsciiOnly");
        if ((str.length() == 0) || 'A' > (charAt = str.charAt(0)) || 'Z' < charAt) {
            return str;
        }
        char lowerCase = Character.toLowerCase(charAt);
        String substring = str.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(lowerCase) + substring;
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toLowerCaseAsciiOnly");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ('A' <= charAt && 'Z' >= charAt) {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "builder.toString()");
        return sb2;
    }
}
