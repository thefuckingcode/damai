package org.jetbrains.anko.custom;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.anko.AnkoAsyncContext;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "R", "T", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
/* compiled from: Deprecated.kt */
final class DeprecatedKt$asyncResult$1 extends Lambda implements Function0<R> {
    final /* synthetic */ AnkoAsyncContext $context;
    final /* synthetic */ Function1 $task;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeprecatedKt$asyncResult$1(Function1 function1, AnkoAsyncContext ankoAsyncContext) {
        super(0);
        this.$task = function1;
        this.$context = ankoAsyncContext;
    }

    @Override // kotlin.jvm.functions.Function0
    public final R invoke() {
        return (R) this.$task.invoke(this.$context);
    }
}
