package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/experimental/channels/RendezvousChannel;", "E", "Lkotlinx/coroutines/experimental/channels/AbstractChannel;", "()V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: RendezvousChannel.kt */
public class RendezvousChannel<E> extends AbstractChannel<E> {
    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
    public final boolean isBufferAlwaysEmpty() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public final boolean isBufferAlwaysFull() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractChannel
    public final boolean isBufferEmpty() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel
    public final boolean isBufferFull() {
        return true;
    }
}
