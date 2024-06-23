package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineContextKt;
import kotlinx.coroutines.experimental.CoroutineStart;
import kotlinx.coroutines.experimental.Job;
import kotlinx.coroutines.experimental.Unconfined;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a¢\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2-\b\u0002\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fj\u0004\u0018\u0001`\u00122-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001a2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u0002\u0004\n\u0002\b\t¨\u0006\u001b"}, d2 = {"broadcast", "Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "E", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/experimental/CoroutineStart;", "parent", "Lkotlinx/coroutines/experimental/Job;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", SerializableCookie.NAME, "cause", "", "Lkotlinx/coroutines/experimental/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;ILkotlinx/coroutines/experimental/CoroutineStart;Lkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Broadcast.kt */
public final class BroadcastKt {
    public static /* bridge */ /* synthetic */ BroadcastChannel broadcast$default(ReceiveChannel receiveChannel, int i, CoroutineStart coroutineStart, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return broadcast(receiveChannel, i, coroutineStart);
    }

    public static final <E> BroadcastChannel<E> broadcast(ReceiveChannel<? extends E> receiveChannel, int i, CoroutineStart coroutineStart) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        return broadcast$default(Unconfined.INSTANCE, i, coroutineStart, null, ChannelsKt.consumes(receiveChannel), new BroadcastKt$broadcast$1(receiveChannel, null), 8, null);
    }

    public static /* bridge */ /* synthetic */ BroadcastChannel broadcast$default(CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Job job, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        int i3 = (i2 & 2) != 0 ? 1 : i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        if ((i2 & 8) != 0) {
            job = null;
        }
        if ((i2 & 16) != 0) {
            function1 = null;
        }
        return broadcast(coroutineContext, i3, coroutineStart, job, function1, function2);
    }

    public static final <E> BroadcastChannel<E> broadcast(CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Job job, Function1<? super Throwable, Unit> function1, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        LazyBroadcastCoroutine lazyBroadcastCoroutine;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        BroadcastChannel BroadcastChannel = BroadcastChannelKt.BroadcastChannel(i);
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineContext, job);
        if (coroutineStart.isLazy()) {
            lazyBroadcastCoroutine = new LazyBroadcastCoroutine(newCoroutineContext, BroadcastChannel, function2);
        } else {
            lazyBroadcastCoroutine = new BroadcastCoroutine(newCoroutineContext, BroadcastChannel, true);
        }
        if (function1 != null) {
            lazyBroadcastCoroutine.invokeOnCompletion(function1);
        }
        lazyBroadcastCoroutine.start(coroutineStart, lazyBroadcastCoroutine, function2);
        return lazyBroadcastCoroutine;
    }
}
