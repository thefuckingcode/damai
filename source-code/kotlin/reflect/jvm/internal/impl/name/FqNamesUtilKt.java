package kotlin.reflect.jvm.internal.impl.name;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FqNamesUtil.kt */
public final class FqNamesUtilKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[State.BEGINNING.ordinal()] = 1;
            iArr[State.AFTER_DOT.ordinal()] = 2;
            iArr[State.MIDDLE.ordinal()] = 3;
        }
    }

    public static final boolean isSubpackageOf(FqName fqName, FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName, "$this$isSubpackageOf");
        Intrinsics.checkParameterIsNotNull(fqName2, "packageName");
        if (Intrinsics.areEqual(fqName, fqName2) || fqName2.isRoot()) {
            return true;
        }
        String asString = fqName.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "this.asString()");
        String asString2 = fqName2.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString2, "packageName.asString()");
        return isSubpackageOf(asString, asString2);
    }

    private static final boolean isSubpackageOf(String str, String str2) {
        return StringsKt.startsWith$default(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final FqName tail(FqName fqName, FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName, "$this$tail");
        Intrinsics.checkParameterIsNotNull(fqName2, "prefix");
        if (!isSubpackageOf(fqName, fqName2) || fqName2.isRoot()) {
            return fqName;
        }
        if (Intrinsics.areEqual(fqName, fqName2)) {
            FqName fqName3 = FqName.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(fqName3, "FqName.ROOT");
            return fqName3;
        }
        String asString = fqName.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "asString()");
        int length = fqName2.asString().length() + 1;
        if (asString != null) {
            String substring = asString.substring(length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return new FqName(substring);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final boolean isValidJavaFqName(String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else if (i2 != 3) {
                continue;
            } else if (charAt == '.') {
                state = State.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        if (state != State.AFTER_DOT) {
            return true;
        }
        return false;
    }
}
