package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {53, 54}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
/* compiled from: Taobao */
final class BroadcastKt$broadcast$2 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_broadcast;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BroadcastKt$broadcast$2(ReceiveChannel<Object> receiveChannel, Continuation<? super BroadcastKt$broadcast$2> continuation) {
        super(2, continuation);
        this.$this_broadcast = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BroadcastKt$broadcast$2 broadcastKt$broadcast$2 = new BroadcastKt$broadcast$2(this.$this_broadcast, continuation);
        broadcastKt$broadcast$2.L$0 = obj;
        return broadcastKt$broadcast$2;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((BroadcastKt$broadcast$2) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ChannelIterator<Object> channelIterator;
        ProducerScope producerScope;
        BroadcastKt$broadcast$2 broadcastKt$broadcast$2;
        Object hasNext;
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            channelIterator = this.$this_broadcast.iterator();
        } else if (i == 1) {
            channelIterator = (ChannelIterator) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            k12.b(obj);
            BroadcastKt$broadcast$2 broadcastKt$broadcast$22 = this;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                broadcastKt$broadcast$22.L$0 = producerScope2;
                broadcastKt$broadcast$22.L$1 = channelIterator;
                broadcastKt$broadcast$22.label = 2;
                if (producerScope2.send(next, broadcastKt$broadcast$22) == obj2) {
                    return obj2;
                }
                producerScope = producerScope2;
                broadcastKt$broadcast$2 = broadcastKt$broadcast$22;
                broadcastKt$broadcast$2.L$0 = producerScope;
                broadcastKt$broadcast$2.L$1 = channelIterator;
                broadcastKt$broadcast$2.label = 1;
                hasNext = channelIterator.hasNext(broadcastKt$broadcast$2);
                if (hasNext != obj2) {
                    return obj2;
                }
                producerScope2 = producerScope;
                obj = hasNext;
                broadcastKt$broadcast$22 = broadcastKt$broadcast$2;
                if (!((Boolean) obj).booleanValue()) {
                }
                return obj2;
                return obj2;
            }
            return ur2.INSTANCE;
        } else if (i == 2) {
            channelIterator = (ChannelIterator) this.L$1;
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        broadcastKt$broadcast$2 = this;
        broadcastKt$broadcast$2.L$0 = producerScope;
        broadcastKt$broadcast$2.L$1 = channelIterator;
        broadcastKt$broadcast$2.label = 1;
        hasNext = channelIterator.hasNext(broadcastKt$broadcast$2);
        if (hasNext != obj2) {
        }
        return obj2;
    }
}
