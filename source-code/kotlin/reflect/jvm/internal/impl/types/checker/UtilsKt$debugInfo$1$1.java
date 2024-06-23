package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* compiled from: utils.kt */
final class UtilsKt$debugInfo$1$1 extends Lambda implements Function1<String, StringBuilder> {
    final /* synthetic */ StringBuilder $this_buildString;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UtilsKt$debugInfo$1$1(StringBuilder sb) {
        super(1);
        this.$this_buildString = sb;
    }

    public final StringBuilder invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$unaryPlus");
        StringBuilder sb = this.$this_buildString;
        sb.append(str);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(value)");
        return StringsKt.appendln(sb);
    }
}
