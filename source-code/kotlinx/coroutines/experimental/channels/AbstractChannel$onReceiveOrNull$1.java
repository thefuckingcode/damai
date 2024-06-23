package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.selects.SelectClause1;
import kotlinx.coroutines.experimental.selects.SelectInstance;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072$\u0010\b\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\t¨\u0006\r"}, d2 = {"kotlinx/coroutines/experimental/channels/AbstractChannel$onReceiveOrNull$1", "Lkotlinx/coroutines/experimental/selects/SelectClause1;", "(Lkotlinx/coroutines/experimental/channels/AbstractChannel;)V", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: AbstractChannel.kt */
public final class AbstractChannel$onReceiveOrNull$1 implements SelectClause1<E> {
    final /* synthetic */ AbstractChannel this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AbstractChannel$onReceiveOrNull$1(AbstractChannel abstractChannel) {
        this.this$0 = abstractChannel;
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectClause1
    public <R> void registerSelectClause1(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        AbstractChannel.access$registerSelectReceiveOrNull(this.this$0, selectInstance, function2);
    }
}
