package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CancellableContinuation;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0014\u0010\r\u001a\u00020\u00072\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/experimental/channels/SendElement;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/channels/Send;", "pollResult", "", "cont", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/CancellableContinuation;)V", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "token", "resumeSendClosed", "closed", "Lkotlinx/coroutines/experimental/channels/Closed;", "toString", "", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: AbstractChannel.kt */
public final class SendElement extends LockFreeLinkedListNode implements Send {
    public final CancellableContinuation<Unit> cont;
    private final Object pollResult;

    @Override // kotlinx.coroutines.experimental.channels.Send
    public Object getPollResult() {
        return this.pollResult;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.experimental.CancellableContinuation<? super kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public SendElement(Object obj, CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
        this.pollResult = obj;
        this.cont = cancellableContinuation;
    }

    @Override // kotlinx.coroutines.experimental.channels.Send
    public Object tryResumeSend(Object obj) {
        return this.cont.tryResume(Unit.INSTANCE, obj);
    }

    @Override // kotlinx.coroutines.experimental.channels.Send
    public void completeResumeSend(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "token");
        this.cont.completeResume(obj);
    }

    @Override // kotlinx.coroutines.experimental.channels.Send
    public void resumeSendClosed(Closed<?> closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
        this.cont.resumeWithException(closed.getSendException());
    }

    @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
    public String toString() {
        return "SendElement(" + getPollResult() + ")[" + this.cont + ']';
    }
}
