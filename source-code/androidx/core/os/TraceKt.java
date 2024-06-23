package androidx.core.os;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import tb.b11;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, d2 = {"T", "", "sectionName", "Lkotlin/Function0;", "block", AgooConstants.MESSAGE_TRACE, "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TraceKt {
    @Deprecated(message = "Use androidx.tracing.Trace instead", replaceWith = @ReplaceWith(expression = "trace(sectionName)", imports = {"androidx.tracing.trace"}))
    public static final <T> T trace(@NotNull String str, @NotNull Function0<? extends T> function0) {
        k21.i(str, "sectionName");
        k21.i(function0, "block");
        TraceCompat.beginSection(str);
        try {
            return (T) function0.invoke();
        } finally {
            b11.b(1);
            TraceCompat.endSection();
            b11.a(1);
        }
    }
}
