package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.youku.uplayer.AliMediaPlayer;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2}, l = {AliMediaPlayer.OPEN_RENDER_VV_BEGIN, AliMediaPlayer.UPLAYER_PROPERTY_DRM_LICENSE_URI, AliMediaPlayer.UPLAYER_PROPERTY_DRM_LICENSE_URI}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$2", "L$0"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super E, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$filterIndexed$1> continuation) {
        super(2, continuation);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super E> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ProducerScope producerScope;
        ChannelIterator<E> channelIterator;
        int i;
        Object obj2;
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1;
        int i2;
        ChannelIterator<E> channelIterator2;
        Object obj3;
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$12;
        ProducerScope producerScope2;
        ChannelIterator<E> channelIterator3;
        int i3;
        Object hasNext;
        Object obj4 = b.d();
        int i4 = this.label;
        if (i4 == 0) {
            k12.b(obj);
            i3 = 0;
            channelIterator3 = this.$this_filterIndexed.iterator();
            producerScope2 = (ProducerScope) this.L$0;
            channelsKt__DeprecatedKt$filterIndexed$12 = this;
            channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$filterIndexed$12.L$1 = channelIterator3;
            channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
            channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i3;
            channelsKt__DeprecatedKt$filterIndexed$12.label = 1;
            hasNext = channelIterator3.hasNext(channelsKt__DeprecatedKt$filterIndexed$12);
            if (hasNext == obj4) {
            }
            return obj4;
        } else if (i4 == 1) {
            int i5 = this.I$0;
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            channelIterator = (ChannelIterator) this.L$1;
            i = i5;
            obj2 = obj4;
            channelsKt__DeprecatedKt$filterIndexed$1 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
            return ur2.INSTANCE;
        } else if (i4 == 2) {
            int i6 = this.I$0;
            Object obj5 = this.L$2;
            producerScope = (ProducerScope) this.L$0;
            k12.b(obj);
            i2 = i6;
            obj2 = obj4;
            channelsKt__DeprecatedKt$filterIndexed$1 = this;
            channelIterator2 = (ChannelIterator) this.L$1;
            obj3 = obj5;
        } else if (i4 == 3) {
            i3 = this.I$0;
            channelIterator3 = (ChannelIterator) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            k12.b(obj);
            channelsKt__DeprecatedKt$filterIndexed$12 = this;
            channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$filterIndexed$12.L$1 = channelIterator3;
            channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
            channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i3;
            channelsKt__DeprecatedKt$filterIndexed$12.label = 1;
            hasNext = channelIterator3.hasNext(channelsKt__DeprecatedKt$filterIndexed$12);
            if (hasNext == obj4) {
                return obj4;
            }
            channelsKt__DeprecatedKt$filterIndexed$1 = channelsKt__DeprecatedKt$filterIndexed$12;
            obj = hasNext;
            producerScope = producerScope2;
            channelIterator = channelIterator3;
            i = i3;
            obj2 = obj4;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                Function3<Integer, E, Continuation<? super Boolean>, Object> function3 = channelsKt__DeprecatedKt$filterIndexed$1.$predicate;
                i2 = i + 1;
                Integer b = qc.b(i);
                channelsKt__DeprecatedKt$filterIndexed$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$filterIndexed$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$filterIndexed$1.L$2 = next;
                channelsKt__DeprecatedKt$filterIndexed$1.I$0 = i2;
                channelsKt__DeprecatedKt$filterIndexed$1.label = 2;
                Object invoke = function3.invoke(b, next, channelsKt__DeprecatedKt$filterIndexed$1);
                if (invoke == obj2) {
                    return obj2;
                }
                channelIterator2 = channelIterator;
                obj3 = next;
                obj = invoke;
                return obj2;
            }
            return ur2.INSTANCE;
            return obj4;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelIterator3 = channelIterator2;
        if (((Boolean) obj).booleanValue()) {
            channelsKt__DeprecatedKt$filterIndexed$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$filterIndexed$1.L$1 = channelIterator3;
            channelsKt__DeprecatedKt$filterIndexed$1.L$2 = null;
            channelsKt__DeprecatedKt$filterIndexed$1.I$0 = i2;
            channelsKt__DeprecatedKt$filterIndexed$1.label = 3;
            if (producerScope.send(obj3, channelsKt__DeprecatedKt$filterIndexed$1) == obj2) {
                return obj2;
            }
        }
        channelsKt__DeprecatedKt$filterIndexed$12 = channelsKt__DeprecatedKt$filterIndexed$1;
        obj4 = obj2;
        producerScope2 = producerScope;
        i3 = i2;
        channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope2;
        channelsKt__DeprecatedKt$filterIndexed$12.L$1 = channelIterator3;
        channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
        channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i3;
        channelsKt__DeprecatedKt$filterIndexed$12.label = 1;
        hasNext = channelIterator3.hasNext(channelsKt__DeprecatedKt$filterIndexed$12);
        if (hasNext == obj4) {
        }
        return obj4;
    }
}
