package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.selects.SelectClause2;
import kotlinx.coroutines.experimental.selects.SelectInstance;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003JV\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00028\u00002(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\t¨\u0006\u000f"}, d2 = {"kotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$onSend$1", "Lkotlinx/coroutines/experimental/selects/SelectClause2;", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "(Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel;)V", "registerSelectClause2", "", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "param", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: ConflatedBroadcastChannel.kt */
public final class ConflatedBroadcastChannel$onSend$1 implements SelectClause2<E, SendChannel<? super E>> {
    final /* synthetic */ ConflatedBroadcastChannel this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ConflatedBroadcastChannel$onSend$1(ConflatedBroadcastChannel conflatedBroadcastChannel) {
        this.this$0 = conflatedBroadcastChannel;
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectClause2
    public <R> void registerSelectClause2(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        this.this$0.registerSelectSend(selectInstance, e, function2);
    }
}
