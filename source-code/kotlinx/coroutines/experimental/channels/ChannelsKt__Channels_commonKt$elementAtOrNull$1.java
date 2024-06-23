package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007H@ø\u0001\u0000"}, d2 = {"elementAtOrNull", "", "E", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "index", "", "continuation", "Lkotlin/coroutines/experimental/Continuation;"}, k = 3, mv = {1, 1, 10})
/* compiled from: Channels.common.kt */
public final class ChannelsKt__Channels_commonKt$elementAtOrNull$1 extends CoroutineImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    /* synthetic */ Object data;
    /* synthetic */ Throwable exception;

    ChannelsKt__Channels_commonKt$elementAtOrNull$1(Continuation continuation) {
        super(0, continuation);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        this.data = obj;
        this.exception = th;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt.elementAtOrNull(null, 0, this);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int getLabel() {
        return this.label;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void setLabel(int i) {
        this.label = i;
    }
}
