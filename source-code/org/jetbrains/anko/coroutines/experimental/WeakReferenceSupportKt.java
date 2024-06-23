package org.jetbrains.anko.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"asReference", "Lorg/jetbrains/anko/coroutines/experimental/Ref;", "T", "", "(Ljava/lang/Object;)Lorg/jetbrains/anko/coroutines/experimental/Ref;", "anko-coroutines_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: weakReferenceSupport.kt */
public final class WeakReferenceSupportKt {
    public static final <T> Ref<T> asReference(T t) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        return new Ref<>(t);
    }
}
