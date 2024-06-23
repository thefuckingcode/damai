package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {279, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super ur2>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_flatMap;
    final /* synthetic */ Function2<E, Continuation<? super ReceiveChannel<? extends R>>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ReceiveChannel<? extends R>>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$flatMap$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$flatMap$1> continuation) {
        super(2, continuation);
        this.$this_flatMap = receiveChannel;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1 = new ChannelsKt__DeprecatedKt$flatMap$1(this.$this_flatMap, this.$transform, continuation);
        channelsKt__DeprecatedKt$flatMap$1.L$0 = obj;
        return channelsKt__DeprecatedKt$flatMap$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super R> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ProducerScope producerScope;
        ChannelIterator<E> channelIterator;
        Object obj2;
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1;
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$12;
        ChannelIterator<E> channelIterator2;
        ProducerScope producerScope2;
        Object hasNext;
        Object obj3 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            channelIterator2 = this.$this_flatMap.iterator();
            producerScope2 = (ProducerScope) this.L$0;
        } else if (i == 1) {
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = obj3;
            channelsKt__DeprecatedKt$flatMap$1 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
            return ur2.INSTANCE;
        } else if (i == 2) {
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = obj3;
            channelsKt__DeprecatedKt$flatMap$1 = this;
            channelsKt__DeprecatedKt$flatMap$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$flatMap$1.L$1 = channelIterator;
            channelsKt__DeprecatedKt$flatMap$1.label = 3;
            if (b.s((ReceiveChannel) obj, producerScope, channelsKt__DeprecatedKt$flatMap$1) != obj2) {
                return obj2;
            }
            channelsKt__DeprecatedKt$flatMap$12 = channelsKt__DeprecatedKt$flatMap$1;
            obj3 = obj2;
            channelIterator2 = channelIterator;
            producerScope2 = producerScope;
            channelsKt__DeprecatedKt$flatMap$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$flatMap$12.L$1 = channelIterator2;
            channelsKt__DeprecatedKt$flatMap$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$flatMap$12);
            if (hasNext != obj3) {
                return obj3;
            }
            channelsKt__DeprecatedKt$flatMap$1 = channelsKt__DeprecatedKt$flatMap$12;
            obj = hasNext;
            producerScope = producerScope2;
            channelIterator = channelIterator2;
            obj2 = obj3;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                Function2<E, Continuation<? super ReceiveChannel<? extends R>>, Object> function2 = channelsKt__DeprecatedKt$flatMap$1.$transform;
                channelsKt__DeprecatedKt$flatMap$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$flatMap$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$flatMap$1.label = 2;
                obj = function2.invoke(next, channelsKt__DeprecatedKt$flatMap$1);
                if (obj == obj2) {
                    return obj2;
                }
                channelsKt__DeprecatedKt$flatMap$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$flatMap$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$flatMap$1.label = 3;
                if (b.s((ReceiveChannel) obj, producerScope, channelsKt__DeprecatedKt$flatMap$1) != obj2) {
                }
            }
            return ur2.INSTANCE;
            return obj3;
            return obj2;
        } else if (i == 3) {
            channelIterator2 = (ChannelIterator) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$flatMap$12 = this;
        channelsKt__DeprecatedKt$flatMap$12.L$0 = producerScope2;
        channelsKt__DeprecatedKt$flatMap$12.L$1 = channelIterator2;
        channelsKt__DeprecatedKt$flatMap$12.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$flatMap$12);
        if (hasNext != obj3) {
        }
        return obj3;
    }
}
