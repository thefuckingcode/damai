package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: numbers.kt */
public final class NumbersKt {
    public static final NumberWithRadix extractRadix(String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        if (StringsKt.startsWith$default(str, "0x", false, 2, (Object) null) || StringsKt.startsWith$default(str, "0X", false, 2, (Object) null)) {
            String substring = str.substring(2);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return new NumberWithRadix(substring, 16);
        } else if (!StringsKt.startsWith$default(str, "0b", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "0B", false, 2, (Object) null)) {
            return new NumberWithRadix(str, 10);
        } else {
            String substring2 = str.substring(2);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
            return new NumberWithRadix(substring2, 2);
        }
    }
}
