package org.jetbrains.anko;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lorg/jetbrains/anko/AnkoAsyncContext;", "T", "", "weakRef", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "getWeakRef", "()Ljava/lang/ref/WeakReference;", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: Async.kt */
public final class AnkoAsyncContext<T> {
    private final WeakReference<T> weakRef;

    public AnkoAsyncContext(WeakReference<T> weakReference) {
        Intrinsics.checkParameterIsNotNull(weakReference, "weakRef");
        this.weakRef = weakReference;
    }

    public final WeakReference<T> getWeakRef() {
        return this.weakRef;
    }
}
