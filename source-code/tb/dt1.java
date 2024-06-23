package tb;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class dt1<E> extends tg<E> implements ProducerScope<E> {
    public dt1(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel) {
        super(coroutineContext, channel, true, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onCompleted(@NotNull ur2 ur2) {
        SendChannel.a.a(a(), null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope, tb.tg
    public /* bridge */ /* synthetic */ SendChannel getChannel() {
        return getChannel();
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.JobSupport, kotlinx.coroutines.a
    public boolean isActive() {
        return super.isActive();
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    public void onCancelled(@NotNull Throwable th, boolean z) {
        if (!a().close(th) && !z) {
            sn.a(getContext(), th);
        }
    }
}
