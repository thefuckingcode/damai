package kotlinx.coroutines.experimental.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a>\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\u00060\tH\b¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"BroadcastChannel", "Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "E", "capacity", "", "use", "R", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "block", "Lkotlin/Function1;", "(Lkotlinx/coroutines/experimental/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: BroadcastChannel.kt */
public final class BroadcastChannelKt {
    public static final <E> BroadcastChannel<E> BroadcastChannel(int i) {
        if (i == -1) {
            return new ConflatedBroadcastChannel();
        }
        if (i == 0) {
            throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
        } else if (i != Integer.MAX_VALUE) {
            return new ArrayBroadcastChannel(i);
        } else {
            throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r2.cancel(r3);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use `ReceiveChannel<*>.consume` instead", replaceWith = @ReplaceWith(expression = "consume { let(block) }", imports = {}))
    public static final <E, R> R use(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Throwable th = null;
        R r = (R) function1.invoke(receiveChannel);
        InlineMarker.finallyStart(1);
        receiveChannel.cancel(th);
        InlineMarker.finallyEnd(1);
        return r;
    }
}
