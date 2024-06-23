package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineContextKt;
import kotlinx.coroutines.experimental.CoroutineStart;
import kotlinx.coroutines.experimental.Job;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a]\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122-\b\u0002\u0010\u0013\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014j\u0004\u0018\u0001`\u00192-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001ak\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a_\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\t¨\u0006\u001c"}, d2 = {"buildChannel", "Lkotlinx/coroutines/experimental/channels/ProducerJob;", "E", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "capacity", "", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/channels/ProducerScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/channels/ProducerJob;", "produce", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "parent", "Lkotlinx/coroutines/experimental/Job;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", SerializableCookie.NAME, "cause", "Lkotlinx/coroutines/experimental/CompletionHandler;", "(Lkotlin/coroutines/experimental/CoroutineContext;ILkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "(Lkotlin/coroutines/experimental/CoroutineContext;ILkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Produce.kt */
public final class ProduceKt {
    public static /* bridge */ /* synthetic */ ReceiveChannel produce$default(CoroutineContext coroutineContext, int i, Job job, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            job = null;
        }
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        return produce(coroutineContext, i, job, function1, function2);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineContext coroutineContext, int i, Job job, Function1<? super Throwable, Unit> function1, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(coroutineContext, job), ChannelKt.Channel(i));
        if (function1 != null) {
            producerCoroutine.invokeOnCompletion(function1);
        }
        producerCoroutine.start(CoroutineStart.DEFAULT, producerCoroutine, function2);
        return producerCoroutine;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static /* bridge */ /* synthetic */ ReceiveChannel produce$default(CoroutineContext coroutineContext, int i, Job job, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            job = null;
        }
        return produce(coroutineContext, i, job, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ <E> ReceiveChannel<E> produce(CoroutineContext coroutineContext, int i, Job job, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return produce$default(coroutineContext, i, job, null, function2, 8, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static /* bridge */ /* synthetic */ ProducerJob produce$default(CoroutineContext coroutineContext, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return produce(coroutineContext, i, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ <E> ProducerJob<E> produce(CoroutineContext coroutineContext, int i, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        ReceiveChannel produce$default = produce$default(coroutineContext, i, null, null, function2, 12, null);
        if (produce$default != null) {
            return (ProducerJob) produce$default;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ProducerJob<E>");
    }

    @Deprecated(message = "Renamed to `produce`", replaceWith = @ReplaceWith(expression = "produce(context, capacity, block)", imports = {}))
    public static /* bridge */ /* synthetic */ ProducerJob buildChannel$default(CoroutineContext coroutineContext, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return buildChannel(coroutineContext, i, function2);
    }

    @Deprecated(message = "Renamed to `produce`", replaceWith = @ReplaceWith(expression = "produce(context, capacity, block)", imports = {}))
    public static final <E> ProducerJob<E> buildChannel(CoroutineContext coroutineContext, int i, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        ReceiveChannel produce$default = produce$default(coroutineContext, i, null, null, function2, 12, null);
        if (produce$default != null) {
            return (ProducerJob) produce$default;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ProducerJob<E>");
    }
}
