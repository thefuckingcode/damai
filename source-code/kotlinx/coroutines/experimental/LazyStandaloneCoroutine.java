package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.intrinsics.CancellableKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\b\u0010\r\u001a\u00020\bH\u0014R4\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\f\u0002\u0004\n\u0002\b\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/experimental/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/experimental/StandaloneCoroutine;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "onStart", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Builders.common.kt */
public final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    private final Function2<CoroutineScope, Continuation<? super Unit>, Object> block;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.experimental.CoroutineScope, ? super kotlin.coroutines.experimental.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStandaloneCoroutine(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        this.block = function2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.AbstractCoroutine
    public void onStart() {
        CancellableKt.startCoroutineCancellable(this.block, this, this);
    }
}
