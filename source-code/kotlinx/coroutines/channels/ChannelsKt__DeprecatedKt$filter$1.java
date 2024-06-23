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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_LOWSPEED_THRESHOLD, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_LOWSPEED_THRESHOLD}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$filter$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<Object> $this_filter;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$filter$1> continuation) {
        super(2, continuation);
        this.$this_filter = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filter$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filter$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ChannelIterator<Object> channelIterator;
        Object obj2;
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1;
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$12;
        ChannelIterator<Object> channelIterator2;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        Object hasNext;
        Object obj3 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            channelIterator2 = this.$this_filter.iterator();
            producerScope = (ProducerScope) this.L$0;
        } else if (i == 1) {
            k12.b(obj);
            producerScope2 = (ProducerScope) this.L$0;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = obj3;
            channelsKt__DeprecatedKt$filter$1 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
            return ur2.INSTANCE;
        } else if (i == 2) {
            Object obj4 = this.L$2;
            channelIterator = (ChannelIterator) this.L$1;
            k12.b(obj);
            ProducerScope producerScope3 = (ProducerScope) this.L$0;
            Object obj5 = obj4;
            obj2 = obj3;
            channelsKt__DeprecatedKt$filter$1 = this;
            if (((Boolean) obj).booleanValue()) {
                channelsKt__DeprecatedKt$filter$1.L$0 = producerScope3;
                channelsKt__DeprecatedKt$filter$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$filter$1.L$2 = null;
                channelsKt__DeprecatedKt$filter$1.label = 3;
                if (producerScope3.send(obj5, channelsKt__DeprecatedKt$filter$1) == obj2) {
                    return obj2;
                }
            }
            channelsKt__DeprecatedKt$filter$12 = channelsKt__DeprecatedKt$filter$1;
            obj3 = obj2;
            channelIterator2 = channelIterator;
            producerScope = producerScope3;
            channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
            channelsKt__DeprecatedKt$filter$12.L$1 = channelIterator2;
            channelsKt__DeprecatedKt$filter$12.L$2 = null;
            channelsKt__DeprecatedKt$filter$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$filter$12);
            if (hasNext == obj3) {
                return obj3;
            }
            channelsKt__DeprecatedKt$filter$1 = channelsKt__DeprecatedKt$filter$12;
            obj = hasNext;
            producerScope2 = producerScope;
            channelIterator = channelIterator2;
            obj2 = obj3;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                Function2<Object, Continuation<? super Boolean>, Object> function2 = channelsKt__DeprecatedKt$filter$1.$predicate;
                channelsKt__DeprecatedKt$filter$1.L$0 = producerScope2;
                channelsKt__DeprecatedKt$filter$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$filter$1.L$2 = next;
                channelsKt__DeprecatedKt$filter$1.label = 2;
                Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$filter$1);
                if (invoke == obj2) {
                    return obj2;
                }
                obj5 = next;
                obj = invoke;
                producerScope3 = producerScope2;
                if (((Boolean) obj).booleanValue()) {
                }
                channelsKt__DeprecatedKt$filter$12 = channelsKt__DeprecatedKt$filter$1;
                obj3 = obj2;
                channelIterator2 = channelIterator;
                producerScope = producerScope3;
                channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
                channelsKt__DeprecatedKt$filter$12.L$1 = channelIterator2;
                channelsKt__DeprecatedKt$filter$12.L$2 = null;
                channelsKt__DeprecatedKt$filter$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$filter$12);
                if (hasNext == obj3) {
                }
                return obj2;
            }
            return ur2.INSTANCE;
            return obj3;
        } else if (i == 3) {
            channelIterator2 = (ChannelIterator) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$filter$12 = this;
        channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
        channelsKt__DeprecatedKt$filter$12.L$1 = channelIterator2;
        channelsKt__DeprecatedKt$filter$12.L$2 = null;
        channelsKt__DeprecatedKt$filter$12.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$filter$12);
        if (hasNext == obj3) {
        }
        return obj3;
    }
}
