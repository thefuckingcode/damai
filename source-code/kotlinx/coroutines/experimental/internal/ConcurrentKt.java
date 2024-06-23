package kotlinx.coroutines.experimental.internal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0000\u001a*\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00060\u0005j\u0002`\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\b¢\u0006\u0002\u0010\t*\f\b\u0000\u0010\n\"\u00020\u00052\u00020\u0005¨\u0006\u000b"}, d2 = {"subscriberList", "", "E", "withLock", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/experimental/internal/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Concurrent.kt */
public final class ConcurrentKt {
    public static /* synthetic */ void ReentrantLock$annotations() {
    }

    public static final <E> List<E> subscriberList() {
        return new CopyOnWriteArrayList();
    }

    public static final <T> T withLock(ReentrantLock reentrantLock, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(reentrantLock, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "action");
        ReentrantLock reentrantLock2 = reentrantLock;
        reentrantLock2.lock();
        try {
            return (T) function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            reentrantLock2.unlock();
            InlineMarker.finallyEnd(1);
        }
    }
}
