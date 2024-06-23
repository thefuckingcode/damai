package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ReceiveChannel$onReceiveOrNull$1 implements SelectClause1<E> {
    final /* synthetic */ ReceiveChannel<E> a;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    ReceiveChannel$onReceiveOrNull$1(ReceiveChannel<? extends E> receiveChannel) {
        this.a = receiveChannel;
    }

    @Override // kotlinx.coroutines.selects.SelectClause1
    @InternalCoroutinesApi
    public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        this.a.getOnReceiveCatching().registerSelectClause1(selectInstance, new ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1(function2, null));
    }
}
