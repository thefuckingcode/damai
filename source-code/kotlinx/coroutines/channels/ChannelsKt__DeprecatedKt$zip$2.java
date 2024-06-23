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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H@"}, d2 = {ExifInterface.LONGITUDE_EAST, "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {415, 397, 399}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $other;
    final /* synthetic */ ReceiveChannel<Object> $this_zip;
    final /* synthetic */ Function2<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<Object> receiveChannel, ReceiveChannel<Object> receiveChannel2, Function2<Object, Object, Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> continuation) {
        super(2, continuation);
        this.$other = receiveChannel;
        this.$this_zip = receiveChannel2;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, continuation);
        channelsKt__DeprecatedKt$zip$2.L$0 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e9 A[Catch:{ all -> 0x0106 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Throwable th;
        ReceiveChannel<Object> receiveChannel;
        ProducerScope producerScope;
        ChannelIterator<Object> channelIterator;
        Function2<Object, Object, Object> function2;
        ReceiveChannel<Object> receiveChannel2;
        Object obj2;
        ChannelIterator<Object> channelIterator2;
        Object obj3;
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2;
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$22;
        ChannelIterator<Object> channelIterator3;
        Function2<Object, Object, Object> function22;
        ChannelIterator<Object> channelIterator4;
        ProducerScope producerScope2;
        ProducerScope producerScope3;
        ChannelIterator<Object> channelIterator5;
        Function2<Object, Object, Object> function23;
        ReceiveChannel<Object> receiveChannel3;
        Object obj4 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            ChannelIterator<Object> it = this.$other.iterator();
            receiveChannel = this.$this_zip;
            function22 = this.$transform;
            producerScope2 = (ProducerScope) this.L$0;
            channelsKt__DeprecatedKt$zip$22 = this;
            channelIterator4 = it;
            channelIterator3 = receiveChannel.iterator();
        } else if (i == 1) {
            k12.b(obj);
            producerScope3 = (ProducerScope) this.L$0;
            channelIterator5 = (ChannelIterator) this.L$1;
            function23 = (Function2) this.L$2;
            receiveChannel3 = (ReceiveChannel) this.L$3;
            channelIterator2 = (ChannelIterator) this.L$4;
            obj3 = obj4;
            channelsKt__DeprecatedKt$zip$2 = this;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator2.next();
                channelsKt__DeprecatedKt$zip$2.L$0 = producerScope3;
                channelsKt__DeprecatedKt$zip$2.L$1 = channelIterator5;
                channelsKt__DeprecatedKt$zip$2.L$2 = function23;
                channelsKt__DeprecatedKt$zip$2.L$3 = receiveChannel3;
                channelsKt__DeprecatedKt$zip$2.L$4 = channelIterator2;
                channelsKt__DeprecatedKt$zip$2.L$5 = next;
                channelsKt__DeprecatedKt$zip$2.label = 2;
                Object hasNext = channelIterator5.hasNext(channelsKt__DeprecatedKt$zip$2);
                if (hasNext == obj3) {
                    return obj3;
                }
                obj2 = next;
                obj = hasNext;
                producerScope = producerScope3;
                channelIterator = channelIterator5;
                function2 = function23;
                receiveChannel2 = receiveChannel3;
                if (((Boolean) obj).booleanValue()) {
                }
                channelsKt__DeprecatedKt$zip$22 = channelsKt__DeprecatedKt$zip$2;
                obj4 = obj3;
                channelIterator3 = channelIterator2;
                receiveChannel = receiveChannel2;
                function22 = function2;
                channelIterator4 = channelIterator;
                producerScope2 = producerScope;
                return obj3;
            }
            ur2 ur2 = ur2.INSTANCE;
            b.b(receiveChannel3, null);
            return ur2;
        } else if (i == 2) {
            Object obj5 = this.L$5;
            channelIterator2 = (ChannelIterator) this.L$4;
            ReceiveChannel<Object> receiveChannel4 = (ReceiveChannel) this.L$3;
            Function2<Object, Object, Object> function24 = (Function2) this.L$2;
            ChannelIterator<Object> channelIterator6 = (ChannelIterator) this.L$1;
            ProducerScope producerScope4 = (ProducerScope) this.L$0;
            try {
                k12.b(obj);
                producerScope = producerScope4;
                channelIterator = channelIterator6;
                function2 = function24;
                receiveChannel2 = receiveChannel4;
                obj2 = obj5;
                obj3 = obj4;
                channelsKt__DeprecatedKt$zip$2 = this;
            } catch (Throwable th2) {
                th = th2;
                receiveChannel = receiveChannel4;
                throw th;
            }
            try {
                if (((Boolean) obj).booleanValue()) {
                    Object invoke = function2.invoke(obj2, channelIterator.next());
                    channelsKt__DeprecatedKt$zip$2.L$0 = producerScope;
                    channelsKt__DeprecatedKt$zip$2.L$1 = channelIterator;
                    channelsKt__DeprecatedKt$zip$2.L$2 = function2;
                    channelsKt__DeprecatedKt$zip$2.L$3 = receiveChannel2;
                    channelsKt__DeprecatedKt$zip$2.L$4 = channelIterator2;
                    channelsKt__DeprecatedKt$zip$2.L$5 = null;
                    channelsKt__DeprecatedKt$zip$2.label = 3;
                    if (producerScope.send(invoke, channelsKt__DeprecatedKt$zip$2) == obj3) {
                        return obj3;
                    }
                }
                channelsKt__DeprecatedKt$zip$22 = channelsKt__DeprecatedKt$zip$2;
                obj4 = obj3;
                channelIterator3 = channelIterator2;
                receiveChannel = receiveChannel2;
                function22 = function2;
                channelIterator4 = channelIterator;
                producerScope2 = producerScope;
            } catch (Throwable th3) {
                th = th3;
                receiveChannel = receiveChannel2;
                throw th;
            }
        } else if (i == 3) {
            channelIterator3 = (ChannelIterator) this.L$4;
            receiveChannel = (ReceiveChannel) this.L$3;
            function22 = (Function2) this.L$2;
            channelIterator4 = (ChannelIterator) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            try {
                k12.b(obj);
                channelsKt__DeprecatedKt$zip$22 = this;
            } catch (Throwable th4) {
                th = th4;
                try {
                    throw th;
                } catch (Throwable th5) {
                    b.b(receiveChannel, th);
                    throw th5;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$zip$22.L$0 = producerScope2;
        channelsKt__DeprecatedKt$zip$22.L$1 = channelIterator4;
        channelsKt__DeprecatedKt$zip$22.L$2 = function22;
        channelsKt__DeprecatedKt$zip$22.L$3 = receiveChannel;
        channelsKt__DeprecatedKt$zip$22.L$4 = channelIterator3;
        channelsKt__DeprecatedKt$zip$22.L$5 = null;
        channelsKt__DeprecatedKt$zip$22.label = 1;
        Object hasNext2 = channelIterator3.hasNext(channelsKt__DeprecatedKt$zip$22);
        if (hasNext2 == obj4) {
            return obj4;
        }
        channelsKt__DeprecatedKt$zip$2 = channelsKt__DeprecatedKt$zip$22;
        obj = hasNext2;
        producerScope3 = producerScope2;
        channelIterator5 = channelIterator4;
        function23 = function22;
        receiveChannel3 = receiveChannel;
        channelIterator2 = channelIterator3;
        obj3 = obj4;
        if (!((Boolean) obj).booleanValue()) {
            ur2 ur22 = ur2.INSTANCE;
            b.b(receiveChannel3, null);
        }
        ur2 ur222 = ur2.INSTANCE;
        b.b(receiveChannel3, null);
        return ur222;
        return obj4;
    }
}
