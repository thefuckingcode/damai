package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fh;
import tb.k12;
import tb.sd2;

public interface ReceiveChannel<E> {

    public static final class DefaultImpls {
        public static /* synthetic */ void b(ReceiveChannel receiveChannel, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                receiveChannel.cancel(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <E> SelectClause1<E> c(ReceiveChannel<? extends E> receiveChannel) {
            return new ReceiveChannel$onReceiveOrNull$1(receiveChannel);
        }

        public static <E> E d(ReceiveChannel<? extends E> receiveChannel) {
            Object r1 = receiveChannel.m929tryReceivePtdJZtk();
            if (fh.j(r1)) {
                return (E) fh.g(r1);
            }
            Throwable e = fh.e(r1);
            if (e == null) {
                return null;
            }
            throw sd2.k(e);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        public static <E> Object e(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
            ReceiveChannel$receiveOrNull$1 receiveChannel$receiveOrNull$1;
            int i;
            Object obj;
            if (continuation instanceof ReceiveChannel$receiveOrNull$1) {
                receiveChannel$receiveOrNull$1 = (ReceiveChannel$receiveOrNull$1) continuation;
                int i2 = receiveChannel$receiveOrNull$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    receiveChannel$receiveOrNull$1.label = i2 - Integer.MIN_VALUE;
                    Object obj2 = receiveChannel$receiveOrNull$1.result;
                    Object obj3 = b.d();
                    i = receiveChannel$receiveOrNull$1.label;
                    if (i != 0) {
                        k12.b(obj2);
                        receiveChannel$receiveOrNull$1.label = 1;
                        obj = receiveChannel.m928receiveCatchingJP2dKIU(receiveChannel$receiveOrNull$1);
                        if (obj == obj3) {
                            return obj3;
                        }
                    } else if (i == 1) {
                        k12.b(obj2);
                        obj = ((fh) obj2).l();
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return fh.f(obj);
                }
            }
            receiveChannel$receiveOrNull$1 = new ReceiveChannel$receiveOrNull$1(continuation);
            Object obj22 = receiveChannel$receiveOrNull$1.result;
            Object obj32 = b.d();
            i = receiveChannel$receiveOrNull$1.label;
            if (i != 0) {
            }
            return fh.f(obj);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    void cancel(@Nullable CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean cancel(Throwable th);

    @NotNull
    SelectClause1<E> getOnReceive();

    @NotNull
    SelectClause1<fh<E>> getOnReceiveCatching();

    @NotNull
    SelectClause1<E> getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    @NotNull
    ChannelIterator<E> iterator();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    E poll();

    @Nullable
    Object receive(@NotNull Continuation<? super E> continuation);

    @Nullable
    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    Object m928receiveCatchingJP2dKIU(@NotNull Continuation<? super fh<? extends E>> continuation);

    @Nullable
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    Object receiveOrNull(@NotNull Continuation<? super E> continuation);

    @NotNull
    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    Object m929tryReceivePtdJZtk();
}
