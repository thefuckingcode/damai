package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a¢\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2-\b\u0002\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fj\u0004\u0018\u0001`\u00122-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001au\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001ai\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001b\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u0002\u0004\n\u0002\b\t¨\u0006\u001d"}, d2 = {"actor", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "E", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/experimental/CoroutineStart;", "parent", "Lkotlinx/coroutines/experimental/Job;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", SerializableCookie.NAME, "cause", "", "Lkotlinx/coroutines/experimental/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/channels/ActorScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;ILkotlinx/coroutines/experimental/CoroutineStart;Lkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/channels/SendChannel;", "(Lkotlin/coroutines/experimental/CoroutineContext;ILkotlinx/coroutines/experimental/CoroutineStart;Lkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/channels/SendChannel;", "Lkotlinx/coroutines/experimental/channels/ActorJob;", "(Lkotlin/coroutines/experimental/CoroutineContext;ILkotlinx/coroutines/experimental/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/channels/ActorJob;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Actor.kt */
public final class ActorKt {
    public static /* bridge */ /* synthetic */ SendChannel actor$default(CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Job job, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        int i3 = (i2 & 2) != 0 ? 0 : i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i2 & 8) != 0) {
            job = null;
        }
        if ((i2 & 16) != 0) {
            function1 = null;
        }
        return actor(coroutineContext, i3, coroutineStart, job, function1, function2);
    }

    public static final <E> SendChannel<E> actor(CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Job job, Function1<? super Throwable, Unit> function1, Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        LazyActorCoroutine lazyActorCoroutine;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineContext, job);
        Channel Channel = ChannelKt.Channel(i);
        if (coroutineStart.isLazy()) {
            lazyActorCoroutine = new LazyActorCoroutine(newCoroutineContext, Channel, function2);
        } else {
            lazyActorCoroutine = new ActorCoroutine(newCoroutineContext, Channel, true);
        }
        if (function1 != null) {
            lazyActorCoroutine.invokeOnCompletion(function1);
        }
        lazyActorCoroutine.start(coroutineStart, lazyActorCoroutine, function2);
        return lazyActorCoroutine;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static /* bridge */ /* synthetic */ SendChannel actor$default(CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Job job, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i2 & 8) != 0) {
            job = null;
        }
        return actor(coroutineContext, i, coroutineStart, job, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ <E> SendChannel<E> actor(CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Job job, Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return actor$default(coroutineContext, i, coroutineStart, job, null, function2, 16, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static /* bridge */ /* synthetic */ ActorJob actor$default(CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = CoroutineContextKt.getDefaultDispatcher();
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return actor(coroutineContext, i, coroutineStart, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ <E> ActorJob<E> actor(CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        SendChannel actor$default = actor$default(coroutineContext, i, coroutineStart, null, null, function2, 24, null);
        if (actor$default != null) {
            return (ActorJob) actor$default;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ActorJob<E>");
    }
}
