package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.youku.uplayer.AliMediaPlayer;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0}, l = {151, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_UP_GEAR_NEED_BUFFER, 157}, m = "invokeSuspend", n = {"remaining"}, s = {"I$0"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$drop$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super ur2>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel<E> $this_drop;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$drop$1(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$drop$1> continuation) {
        super(2, continuation);
        this.$n = i;
        this.$this_drop = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1 = new ChannelsKt__DeprecatedKt$drop$1(this.$n, this.$this_drop, continuation);
        channelsKt__DeprecatedKt$drop$1.L$0 = obj;
        return channelsKt__DeprecatedKt$drop$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super E> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$drop$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ProducerScope producerScope;
        ChannelIterator<E> channelIterator;
        Object obj2;
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1;
        ProducerScope producerScope2;
        Object hasNext;
        ProducerScope producerScope3;
        ChannelIterator<E> channelIterator2;
        int i;
        ChannelIterator<E> channelIterator3;
        ProducerScope producerScope4;
        int i2;
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$12;
        Object obj3 = b.d();
        int i3 = this.label;
        if (i3 == 0) {
            k12.b(obj);
            producerScope2 = (ProducerScope) this.L$0;
            i2 = this.$n;
            if (!(i2 >= 0)) {
                throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
            } else if (i2 > 0) {
                channelIterator3 = this.$this_drop.iterator();
                producerScope4 = producerScope2;
                channelsKt__DeprecatedKt$drop$12 = this;
            } else {
                obj2 = obj3;
                channelsKt__DeprecatedKt$drop$1 = this;
                channelIterator = channelsKt__DeprecatedKt$drop$1.$this_drop.iterator();
                channelsKt__DeprecatedKt$drop$1.L$0 = producerScope2;
                channelsKt__DeprecatedKt$drop$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$drop$1.label = 2;
                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$drop$1);
                if (hasNext == obj2) {
                }
                return obj2;
            }
        } else if (i3 == 1) {
            int i4 = this.I$0;
            k12.b(obj);
            producerScope3 = (ProducerScope) this.L$0;
            channelIterator2 = (ChannelIterator) this.L$1;
            i = i4;
            obj2 = obj3;
            channelsKt__DeprecatedKt$drop$1 = this;
            if (((Boolean) obj).booleanValue()) {
                channelIterator2.next();
                int i5 = i - 1;
                if (i5 != 0) {
                    channelIterator3 = channelIterator2;
                    producerScope4 = producerScope3;
                    i2 = i5;
                    channelsKt__DeprecatedKt$drop$12 = channelsKt__DeprecatedKt$drop$1;
                    obj3 = obj2;
                }
            }
            producerScope2 = producerScope3;
            channelIterator = channelsKt__DeprecatedKt$drop$1.$this_drop.iterator();
            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope2;
            channelsKt__DeprecatedKt$drop$1.L$1 = channelIterator;
            channelsKt__DeprecatedKt$drop$1.label = 2;
            hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$drop$1);
            if (hasNext == obj2) {
            }
            return obj2;
        } else if (i3 == 2) {
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = obj3;
            channelsKt__DeprecatedKt$drop$1 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
            return ur2.INSTANCE;
        } else if (i3 == 3) {
            k12.b(obj);
            producerScope2 = (ProducerScope) this.L$0;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = obj3;
            channelsKt__DeprecatedKt$drop$1 = this;
            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope2;
            channelsKt__DeprecatedKt$drop$1.L$1 = channelIterator;
            channelsKt__DeprecatedKt$drop$1.label = 2;
            hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$drop$1);
            if (hasNext == obj2) {
                return obj2;
            }
            producerScope = producerScope2;
            obj = hasNext;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$drop$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$drop$1.label = 3;
                if (producerScope.send(next, channelsKt__DeprecatedKt$drop$1) == obj2) {
                    return obj2;
                }
                producerScope2 = producerScope;
                channelsKt__DeprecatedKt$drop$1.L$0 = producerScope2;
                channelsKt__DeprecatedKt$drop$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$drop$1.label = 2;
                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$drop$1);
                if (hasNext == obj2) {
                }
                return obj2;
            }
            return ur2.INSTANCE;
            return obj2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$drop$12.L$0 = producerScope4;
        channelsKt__DeprecatedKt$drop$12.L$1 = channelIterator3;
        channelsKt__DeprecatedKt$drop$12.I$0 = i2;
        channelsKt__DeprecatedKt$drop$12.label = 1;
        Object hasNext2 = channelIterator3.hasNext(channelsKt__DeprecatedKt$drop$12);
        if (hasNext2 == obj3) {
            return obj3;
        }
        channelsKt__DeprecatedKt$drop$1 = channelsKt__DeprecatedKt$drop$12;
        obj = hasNext2;
        producerScope3 = producerScope4;
        channelIterator2 = channelIterator3;
        i = i2;
        obj2 = obj3;
        if (((Boolean) obj).booleanValue()) {
        }
        producerScope2 = producerScope3;
        channelIterator = channelsKt__DeprecatedKt$drop$1.$this_drop.iterator();
        channelsKt__DeprecatedKt$drop$1.L$0 = producerScope2;
        channelsKt__DeprecatedKt$drop$1.L$1 = channelIterator;
        channelsKt__DeprecatedKt$drop$1.label = 2;
        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$drop$1);
        if (hasNext == obj2) {
        }
        return obj2;
        return obj3;
    }
}
