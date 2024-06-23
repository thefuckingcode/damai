package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: RenderingUtils.kt */
public final class RenderingUtilsKt {
    public static final String render(Name name) {
        Intrinsics.checkParameterIsNotNull(name, "$this$render");
        if (shouldBeEscaped(name)) {
            StringBuilder sb = new StringBuilder();
            String asString = name.asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "asString()");
            sb.append(String.valueOf('`') + asString);
            sb.append('`');
            return sb.toString();
        }
        String asString2 = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString2, "asString()");
        return asString2;
    }

    private static final boolean shouldBeEscaped(Name name) {
        boolean z;
        if (name.isSpecial()) {
            return false;
        }
        String asString = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "asString()");
        if (!KeywordStringsGenerated.KEYWORDS.contains(asString)) {
            String str = asString;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = false;
                    break;
                }
                char charAt = str.charAt(i);
                if (!Character.isLetterOrDigit(charAt) && charAt != '_') {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static final String render(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkParameterIsNotNull(fqNameUnsafe, "$this$render");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkExpressionValueIsNotNull(pathSegments, "pathSegments()");
        return renderFqName(pathSegments);
    }

    public static final String renderFqName(List<Name> list) {
        Intrinsics.checkParameterIsNotNull(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (Name name : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(name));
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
