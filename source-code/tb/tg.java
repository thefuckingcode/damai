package tb;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.a;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class tg<E> extends a<ur2> implements Channel<E> {
    @NotNull
    private final Channel<E> a;

    public tg(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this.a = channel;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final Channel<E> a() {
        return this.a;
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.JobSupport, kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            cancelInternal(cancellationException);
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(@NotNull Throwable th) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th, null, 1, null);
        this.a.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable th) {
        return this.a.close(th);
    }

    @NotNull
    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceive() {
        return this.a.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<fh<E>> getOnReceiveCatching() {
        return this.a.getOnReceiveCatching();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        return this.a.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this.a.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @ExperimentalCoroutinesApi
    public void invokeOnClose(@NotNull Function1<? super Throwable, ur2> function1) {
        this.a.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this.a.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.a.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator<E> iterator() {
        return this.a.iterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return this.a.offer(e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return this.a.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receive(@NotNull Continuation<? super E> continuation) {
        return this.a.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    public Object m935receiveCatchingJP2dKIU(@NotNull Continuation<? super fh<? extends E>> continuation) {
        Object r2 = this.a.m928receiveCatchingJP2dKIU(continuation);
        Object unused = b.d();
        return r2;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return this.a.receiveOrNull(continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(E e, @NotNull Continuation<? super ur2> continuation) {
        return this.a.send(e, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public Object m936tryReceivePtdJZtk() {
        return this.a.m929tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m937trySendJP2dKIU(E e) {
        return this.a.m931trySendJP2dKIU(e);
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.JobSupport, kotlinx.coroutines.channels.ReceiveChannel
    public /* synthetic */ void cancel() {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.JobSupport, kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(Throwable th) {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
        return true;
    }
}
