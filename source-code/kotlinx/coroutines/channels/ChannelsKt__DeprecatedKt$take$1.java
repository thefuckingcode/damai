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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 1}, l = {223, 224}, m = "invokeSuspend", n = {"remaining", "remaining"}, s = {"I$0", "I$0"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super ur2>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel<E> $this_take;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$take$1(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$take$1> continuation) {
        super(2, continuation);
        this.$n = i;
        this.$this_take = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, continuation);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super E> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1;
        ChannelIterator<E> channelIterator;
        int i;
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$12;
        ProducerScope producerScope2;
        Object obj2 = b.d();
        int i2 = this.label;
        if (i2 == 0) {
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            i = this.$n;
            if (i == 0) {
                return ur2.INSTANCE;
            }
            if (i >= 0) {
                channelIterator = this.$this_take.iterator();
                channelsKt__DeprecatedKt$take$1 = this;
            } else {
                throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
            }
        } else if (i2 == 1) {
            i = this.I$0;
            channelIterator = (ChannelIterator) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            k12.b(obj);
            channelsKt__DeprecatedKt$take$12 = this;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                channelsKt__DeprecatedKt$take$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$take$12.L$1 = channelIterator;
                channelsKt__DeprecatedKt$take$12.I$0 = i;
                channelsKt__DeprecatedKt$take$12.label = 2;
                if (producerScope2.send(next, channelsKt__DeprecatedKt$take$12) == obj2) {
                    return obj2;
                }
                producerScope = producerScope2;
                channelsKt__DeprecatedKt$take$1 = channelsKt__DeprecatedKt$take$12;
                i--;
                if (i == 0) {
                }
                return obj2;
            }
            return ur2.INSTANCE;
        } else if (i2 == 2) {
            i = this.I$0;
            channelIterator = (ChannelIterator) this.L$1;
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            channelsKt__DeprecatedKt$take$1 = this;
            i--;
            if (i == 0) {
                return ur2.INSTANCE;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$take$1.L$0 = producerScope;
        channelsKt__DeprecatedKt$take$1.L$1 = channelIterator;
        channelsKt__DeprecatedKt$take$1.I$0 = i;
        channelsKt__DeprecatedKt$take$1.label = 1;
        Object hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$take$1);
        if (hasNext == obj2) {
            return obj2;
        }
        producerScope2 = producerScope;
        obj = hasNext;
        channelsKt__DeprecatedKt$take$12 = channelsKt__DeprecatedKt$take$1;
        if (!((Boolean) obj).booleanValue()) {
        }
        return ur2.INSTANCE;
        return obj2;
    }
}
