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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {415, 288, 288}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_map;
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<Object>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$map$1> continuation) {
        super(2, continuation);
        this.$this_map = receiveChannel;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, continuation);
        channelsKt__DeprecatedKt$map$1.L$0 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c3  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1;
        ProducerScope producerScope;
        Function2<Object, Continuation<Object>, Object> function2;
        ReceiveChannel<Object> receiveChannel;
        ChannelIterator<Object> channelIterator;
        ProducerScope producerScope2;
        ChannelIterator<Object> channelIterator2;
        ReceiveChannel<Object> receiveChannel2;
        Function2<Object, Continuation<Object>, Object> function22;
        ProducerScope producerScope3;
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$12;
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$13;
        ProducerScope producerScope4;
        Throwable th;
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            producerScope3 = (ProducerScope) this.L$0;
            receiveChannel2 = this.$this_map;
            channelsKt__DeprecatedKt$map$12 = this;
            function22 = this.$transform;
            channelIterator2 = receiveChannel2.iterator();
        } else if (i == 1) {
            channelIterator2 = (ChannelIterator) this.L$3;
            receiveChannel2 = (ReceiveChannel) this.L$2;
            function22 = (Function2) this.L$1;
            producerScope4 = (ProducerScope) this.L$0;
            k12.b(obj);
            channelsKt__DeprecatedKt$map$13 = this;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator2.next();
                channelsKt__DeprecatedKt$map$13.L$0 = producerScope4;
                channelsKt__DeprecatedKt$map$13.L$1 = function22;
                channelsKt__DeprecatedKt$map$13.L$2 = receiveChannel2;
                channelsKt__DeprecatedKt$map$13.L$3 = channelIterator2;
                channelsKt__DeprecatedKt$map$13.L$4 = producerScope4;
                channelsKt__DeprecatedKt$map$13.label = 2;
                obj = function22.invoke(next, channelsKt__DeprecatedKt$map$13);
                if (obj == obj2) {
                    return obj2;
                }
                channelsKt__DeprecatedKt$map$1 = channelsKt__DeprecatedKt$map$13;
                producerScope = producerScope4;
                function2 = function22;
                receiveChannel = receiveChannel2;
                channelIterator = channelIterator2;
                producerScope2 = producerScope;
                channelsKt__DeprecatedKt$map$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$map$1.L$1 = function2;
                channelsKt__DeprecatedKt$map$1.L$2 = receiveChannel;
                channelsKt__DeprecatedKt$map$1.L$3 = channelIterator;
                channelsKt__DeprecatedKt$map$1.L$4 = null;
                channelsKt__DeprecatedKt$map$1.label = 3;
                if (producerScope2.send(obj, channelsKt__DeprecatedKt$map$1) != obj2) {
                }
                return obj2;
                return obj2;
            }
            ur2 ur2 = ur2.INSTANCE;
            b.b(receiveChannel2, null);
            return ur2;
        } else if (i == 2) {
            producerScope2 = (ProducerScope) this.L$4;
            channelIterator = (ChannelIterator) this.L$3;
            receiveChannel = (ReceiveChannel) this.L$2;
            function2 = (Function2) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            try {
                k12.b(obj);
                channelsKt__DeprecatedKt$map$1 = this;
                channelsKt__DeprecatedKt$map$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$map$1.L$1 = function2;
                channelsKt__DeprecatedKt$map$1.L$2 = receiveChannel;
                channelsKt__DeprecatedKt$map$1.L$3 = channelIterator;
                channelsKt__DeprecatedKt$map$1.L$4 = null;
                channelsKt__DeprecatedKt$map$1.label = 3;
                if (producerScope2.send(obj, channelsKt__DeprecatedKt$map$1) != obj2) {
                    return obj2;
                }
                channelIterator2 = channelIterator;
                receiveChannel2 = receiveChannel;
                function22 = function2;
                producerScope3 = producerScope;
                channelsKt__DeprecatedKt$map$12 = channelsKt__DeprecatedKt$map$1;
                return obj2;
            } catch (Throwable th2) {
                th = th2;
                receiveChannel2 = receiveChannel;
                throw th;
            }
        } else if (i == 3) {
            channelIterator2 = (ChannelIterator) this.L$3;
            receiveChannel2 = (ReceiveChannel) this.L$2;
            function22 = (Function2) this.L$1;
            ProducerScope producerScope5 = (ProducerScope) this.L$0;
            try {
                k12.b(obj);
                producerScope3 = producerScope5;
                channelsKt__DeprecatedKt$map$12 = this;
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    b.b(receiveChannel2, th);
                    throw th4;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$map$12.L$0 = producerScope3;
        channelsKt__DeprecatedKt$map$12.L$1 = function22;
        channelsKt__DeprecatedKt$map$12.L$2 = receiveChannel2;
        channelsKt__DeprecatedKt$map$12.L$3 = channelIterator2;
        channelsKt__DeprecatedKt$map$12.label = 1;
        Object hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$map$12);
        if (hasNext == obj2) {
            return obj2;
        }
        producerScope4 = producerScope3;
        obj = hasNext;
        channelsKt__DeprecatedKt$map$13 = channelsKt__DeprecatedKt$map$12;
        if (!((Boolean) obj).booleanValue()) {
            ur2 ur22 = ur2.INSTANCE;
            b.b(receiveChannel2, null);
        }
        ur2 ur222 = ur2.INSTANCE;
        b.b(receiveChannel2, null);
        return ur222;
        return obj2;
    }
}
