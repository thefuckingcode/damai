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
import tb.s01;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H@"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "Ltb/s01;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1}, l = {313, 314}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce"}, s = {"L$0", "I$0", "L$0"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Function2<ProducerScope<? super s01<? extends E>>, Continuation<? super ur2>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$withIndex$1> continuation) {
        super(2, continuation);
        this.$this_withIndex = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, continuation);
        channelsKt__DeprecatedKt$withIndex$1.L$0 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super s01<? extends E>> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ChannelIterator<E> channelIterator;
        int i;
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1;
        Object hasNext;
        Object obj2 = b.d();
        int i2 = this.label;
        if (i2 == 0) {
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            i = 0;
            channelIterator = this.$this_withIndex.iterator();
        } else if (i2 == 1) {
            i = this.I$0;
            channelIterator = (ChannelIterator) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            k12.b(obj);
            ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$12 = this;
            if (!((Boolean) obj).booleanValue()) {
                int i3 = i + 1;
                s01 s01 = new s01(i, channelIterator.next());
                channelsKt__DeprecatedKt$withIndex$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$withIndex$12.L$1 = channelIterator;
                channelsKt__DeprecatedKt$withIndex$12.I$0 = i3;
                channelsKt__DeprecatedKt$withIndex$12.label = 2;
                if (producerScope2.send(s01, channelsKt__DeprecatedKt$withIndex$12) == obj2) {
                    return obj2;
                }
                producerScope = producerScope2;
                channelsKt__DeprecatedKt$withIndex$1 = channelsKt__DeprecatedKt$withIndex$12;
                i = i3;
                channelsKt__DeprecatedKt$withIndex$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$withIndex$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$withIndex$1.I$0 = i;
                channelsKt__DeprecatedKt$withIndex$1.label = 1;
                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$withIndex$1);
                if (hasNext != obj2) {
                    return obj2;
                }
                producerScope2 = producerScope;
                obj = hasNext;
                channelsKt__DeprecatedKt$withIndex$12 = channelsKt__DeprecatedKt$withIndex$1;
                if (!((Boolean) obj).booleanValue()) {
                }
                return obj2;
                return obj2;
            }
            return ur2.INSTANCE;
        } else if (i2 == 2) {
            i = this.I$0;
            channelIterator = (ChannelIterator) this.L$1;
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$withIndex$1 = this;
        channelsKt__DeprecatedKt$withIndex$1.L$0 = producerScope;
        channelsKt__DeprecatedKt$withIndex$1.L$1 = channelIterator;
        channelsKt__DeprecatedKt$withIndex$1.I$0 = i;
        channelsKt__DeprecatedKt$withIndex$1.label = 1;
        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$withIndex$1);
        if (hasNext != obj2) {
        }
        return obj2;
    }
}
