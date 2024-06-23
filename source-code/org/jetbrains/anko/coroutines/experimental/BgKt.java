package org.jetbrains.anko.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Deferred;
import kotlinx.coroutines.experimental.DeferredKt;
import kotlinx.coroutines.experimental.ThreadPoolDispatcher;
import kotlinx.coroutines.experimental.ThreadPoolDispatcherKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\b\"$\u0010\u0000\u001a\u00020\u00018\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"POOL", "Lkotlinx/coroutines/experimental/ThreadPoolDispatcher;", "POOL$annotations", "()V", "getPOOL", "()Lkotlinx/coroutines/experimental/ThreadPoolDispatcher;", "setPOOL", "(Lkotlinx/coroutines/experimental/ThreadPoolDispatcher;)V", "bg", "Lkotlinx/coroutines/experimental/Deferred;", "T", "block", "Lkotlin/Function0;", "anko-coroutines_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: bg.kt */
public final class BgKt {
    private static ThreadPoolDispatcher POOL = ThreadPoolDispatcherKt.newFixedThreadPoolContext(Runtime.getRuntime().availableProcessors() * 2, "bg");

    @Deprecated(message = "Use the default pool")
    public static /* synthetic */ void POOL$annotations() {
    }

    public static final ThreadPoolDispatcher getPOOL() {
        return POOL;
    }

    public static final void setPOOL(ThreadPoolDispatcher threadPoolDispatcher) {
        Intrinsics.checkParameterIsNotNull(threadPoolDispatcher, "<set-?>");
        POOL = threadPoolDispatcher;
    }

    @Deprecated(message = "Use the default pool", replaceWith = @ReplaceWith(expression = "async(block)", imports = {"kotlinx.coroutines.experimental.async"}))
    public static final <T> Deferred<T> bg(Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "block");
        return DeferredKt.async$default(getPOOL(), null, null, null, new BgKt$bg$1(function0, null), 14, null);
    }
}
