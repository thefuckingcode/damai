package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt__BuildersKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"sendBlocking", "", "E", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "element", "(Lkotlinx/coroutines/experimental/channels/SendChannel;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 10}, xs = "kotlinx/coroutines/experimental/channels/ChannelsKt")
/* compiled from: Channels.kt */
final /* synthetic */ class ChannelsKt__ChannelsKt {
    public static final <E> void sendBlocking(SendChannel<? super E> sendChannel, E e) {
        Intrinsics.checkParameterIsNotNull(sendChannel, "$receiver");
        if (!sendChannel.offer(e)) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$sendBlocking$1(sendChannel, e, null), 1, null);
        }
    }
}
