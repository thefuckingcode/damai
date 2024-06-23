package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.qc;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {296, 297, 297}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_mapIndexed;
    final /* synthetic */ Function3<Integer, Object, Continuation<Object>, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function3<? super java.lang.Integer, java.lang.Object, ? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<Object> receiveChannel, Function3<? super Integer, Object, ? super Continuation<Object>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1> continuation) {
        super(2, continuation);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, continuation);
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i;
        ChannelIterator<Object> channelIterator;
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1;
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$12;
        ProducerScope producerScope2;
        Object hasNext;
        Object obj2 = b.d();
        int i2 = this.label;
        if (i2 == 0) {
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            i = 0;
            channelIterator = this.$this_mapIndexed.iterator();
        } else if (i2 == 1) {
            i = this.I$0;
            channelIterator = (ChannelIterator) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            k12.b(obj);
            channelsKt__DeprecatedKt$mapIndexed$12 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
            return ur2.INSTANCE;
        } else if (i2 == 2) {
            i = this.I$0;
            ProducerScope producerScope3 = (ProducerScope) this.L$2;
            ChannelIterator<Object> channelIterator2 = (ChannelIterator) this.L$1;
            ProducerScope producerScope4 = (ProducerScope) this.L$0;
            k12.b(obj);
            ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$13 = this;
            channelsKt__DeprecatedKt$mapIndexed$13.L$0 = producerScope4;
            channelsKt__DeprecatedKt$mapIndexed$13.L$1 = channelIterator2;
            channelsKt__DeprecatedKt$mapIndexed$13.L$2 = null;
            channelsKt__DeprecatedKt$mapIndexed$13.I$0 = i;
            channelsKt__DeprecatedKt$mapIndexed$13.label = 3;
            if (producerScope3.send(obj, channelsKt__DeprecatedKt$mapIndexed$13) != obj2) {
                return obj2;
            }
            channelIterator = channelIterator2;
            producerScope = producerScope4;
            channelsKt__DeprecatedKt$mapIndexed$1 = channelsKt__DeprecatedKt$mapIndexed$13;
            channelsKt__DeprecatedKt$mapIndexed$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$mapIndexed$1.L$1 = channelIterator;
            channelsKt__DeprecatedKt$mapIndexed$1.I$0 = i;
            channelsKt__DeprecatedKt$mapIndexed$1.label = 1;
            hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$mapIndexed$1);
            if (hasNext != obj2) {
                return obj2;
            }
            producerScope2 = producerScope;
            obj = hasNext;
            channelsKt__DeprecatedKt$mapIndexed$12 = channelsKt__DeprecatedKt$mapIndexed$1;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                Function3<Integer, Object, Continuation<Object>, Object> function3 = channelsKt__DeprecatedKt$mapIndexed$12.$transform;
                int i3 = i + 1;
                Integer b = qc.b(i);
                channelsKt__DeprecatedKt$mapIndexed$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$mapIndexed$12.L$1 = channelIterator;
                channelsKt__DeprecatedKt$mapIndexed$12.L$2 = producerScope2;
                channelsKt__DeprecatedKt$mapIndexed$12.I$0 = i3;
                channelsKt__DeprecatedKt$mapIndexed$12.label = 2;
                obj = function3.invoke(b, next, channelsKt__DeprecatedKt$mapIndexed$12);
                if (obj == obj2) {
                    return obj2;
                }
                channelsKt__DeprecatedKt$mapIndexed$13 = channelsKt__DeprecatedKt$mapIndexed$12;
                i = i3;
                producerScope4 = producerScope2;
                channelIterator2 = channelIterator;
                producerScope3 = producerScope4;
                channelsKt__DeprecatedKt$mapIndexed$13.L$0 = producerScope4;
                channelsKt__DeprecatedKt$mapIndexed$13.L$1 = channelIterator2;
                channelsKt__DeprecatedKt$mapIndexed$13.L$2 = null;
                channelsKt__DeprecatedKt$mapIndexed$13.I$0 = i;
                channelsKt__DeprecatedKt$mapIndexed$13.label = 3;
                if (producerScope3.send(obj, channelsKt__DeprecatedKt$mapIndexed$13) != obj2) {
                }
                return obj2;
            }
            return ur2.INSTANCE;
            return obj2;
            return obj2;
        } else if (i2 == 3) {
            i = this.I$0;
            channelIterator = (ChannelIterator) this.L$1;
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$mapIndexed$1 = this;
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = producerScope;
        channelsKt__DeprecatedKt$mapIndexed$1.L$1 = channelIterator;
        channelsKt__DeprecatedKt$mapIndexed$1.I$0 = i;
        channelsKt__DeprecatedKt$mapIndexed$1.label = 1;
        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$mapIndexed$1);
        if (hasNext != obj2) {
        }
        return obj2;
    }
}
