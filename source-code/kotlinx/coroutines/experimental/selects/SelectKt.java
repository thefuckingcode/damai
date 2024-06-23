package kotlinx.coroutines.experimental.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.experimental.internal.Symbol;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u001f\b\u0004\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fHHø\u0001\u0000¢\u0006\u0002\u0010\r\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u000e"}, d2 = {"ALREADY_SELECTED", "", "getALREADY_SELECTED", "()Ljava/lang/Object;", "RESUMED", "UNDECIDED", "select", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/experimental/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Select.kt */
public final class SelectKt {
    private static final Object ALREADY_SELECTED = new Symbol("ALREADY_SELECTED");
    private static final Object RESUMED = new Symbol("RESUMED");
    private static final Object UNDECIDED = new Symbol("UNDECIDED");

    private static final <R> Object select(Function1<? super SelectBuilder<? super R>, Unit> function1, Continuation<? super R> continuation) {
        InlineMarker.mark(0);
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(CoroutineIntrinsics.normalizeContinuation(continuation));
        try {
            function1.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        Object result = selectBuilderImpl.getResult();
        InlineMarker.mark(1);
        return result;
    }

    public static final Object getALREADY_SELECTED() {
        return ALREADY_SELECTED;
    }
}
