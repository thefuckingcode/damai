package org.jetbrains.anko.coroutines.experimental;

import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\b\u001a\u00028\u0000HBø\u0001\u0000¢\u0006\u0002\u0010\tR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00018\u00008\u00000\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\n"}, d2 = {"Lorg/jetbrains/anko/coroutines/experimental/Ref;", "T", "", "obj", "(Ljava/lang/Object;)V", "weakRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "invoke", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "anko-coroutines_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: weakReferenceSupport.kt */
public final class Ref<T> {
    private final WeakReference<T> weakRef;

    public Ref(T t) {
        Intrinsics.checkParameterIsNotNull(t, "obj");
        this.weakRef = new WeakReference<>(t);
    }

    public final Object invoke(Continuation<? super T> continuation) {
        CoroutineIntrinsics.normalizeContinuation(continuation);
        Object obj = this.weakRef.get();
        if (obj != null) {
            return obj;
        }
        throw new CancellationException();
    }
}
