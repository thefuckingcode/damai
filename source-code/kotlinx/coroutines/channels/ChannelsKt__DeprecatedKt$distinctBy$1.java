package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.aranger.constant.Constants;
import java.util.HashSet;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H@"}, d2 = {ExifInterface.LONGITUDE_EAST, "K", "Lkotlinx/coroutines/channels/ProducerScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {326, 327, 329}, m = "invokeSuspend", n = {"$this$produce", Constants.PARAM_KEYS, "$this$produce", Constants.PARAM_KEYS, "e", "$this$produce", Constants.PARAM_KEYS, "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $selector;
    final /* synthetic */ ReceiveChannel<Object> $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<Object>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> continuation) {
        super(2, continuation);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, continuation);
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1;
        ProducerScope producerScope;
        HashSet hashSet;
        ChannelIterator<Object> channelIterator;
        Object obj2;
        ChannelIterator<Object> channelIterator2;
        HashSet hashSet2;
        ProducerScope producerScope2;
        ProducerScope producerScope3;
        HashSet hashSet3;
        Object obj3;
        Object obj4;
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$12;
        ProducerScope producerScope4;
        HashSet hashSet4;
        Object obj5 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            HashSet hashSet5 = new HashSet();
            ChannelIterator<Object> it = this.$this_distinctBy.iterator();
            producerScope2 = (ProducerScope) this.L$0;
            channelsKt__DeprecatedKt$distinctBy$1 = this;
            hashSet2 = hashSet5;
            channelIterator2 = it;
        } else if (i == 1) {
            k12.b(obj);
            producerScope4 = (ProducerScope) this.L$0;
            hashSet4 = (HashSet) this.L$1;
            channelIterator = (ChannelIterator) this.L$2;
            obj4 = obj5;
            channelsKt__DeprecatedKt$distinctBy$12 = this;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                Function2<Object, Continuation<Object>, Object> function2 = channelsKt__DeprecatedKt$distinctBy$12.$selector;
                channelsKt__DeprecatedKt$distinctBy$12.L$0 = producerScope4;
                channelsKt__DeprecatedKt$distinctBy$12.L$1 = hashSet4;
                channelsKt__DeprecatedKt$distinctBy$12.L$2 = channelIterator;
                channelsKt__DeprecatedKt$distinctBy$12.L$3 = next;
                channelsKt__DeprecatedKt$distinctBy$12.label = 2;
                Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$distinctBy$12);
                if (invoke == obj4) {
                    return obj4;
                }
                obj3 = next;
                obj = invoke;
                producerScope3 = producerScope4;
                hashSet3 = hashSet4;
                if (hashSet3.contains(obj)) {
                    channelsKt__DeprecatedKt$distinctBy$1 = channelsKt__DeprecatedKt$distinctBy$12;
                    obj5 = obj4;
                    channelIterator2 = channelIterator;
                    hashSet2 = hashSet3;
                    producerScope2 = producerScope3;
                }
                channelsKt__DeprecatedKt$distinctBy$12.L$0 = producerScope3;
                channelsKt__DeprecatedKt$distinctBy$12.L$1 = hashSet3;
                channelsKt__DeprecatedKt$distinctBy$12.L$2 = channelIterator;
                channelsKt__DeprecatedKt$distinctBy$12.L$3 = obj;
                channelsKt__DeprecatedKt$distinctBy$12.label = 3;
                if (producerScope3.send(obj3, channelsKt__DeprecatedKt$distinctBy$12) != obj4) {
                }
                return obj4;
                return obj4;
            }
            return ur2.INSTANCE;
        } else if (i == 2) {
            Object obj6 = this.L$3;
            channelIterator = (ChannelIterator) this.L$2;
            k12.b(obj);
            producerScope3 = (ProducerScope) this.L$0;
            hashSet3 = (HashSet) this.L$1;
            obj3 = obj6;
            obj4 = obj5;
            channelsKt__DeprecatedKt$distinctBy$12 = this;
            if (hashSet3.contains(obj)) {
                channelsKt__DeprecatedKt$distinctBy$12.L$0 = producerScope3;
                channelsKt__DeprecatedKt$distinctBy$12.L$1 = hashSet3;
                channelsKt__DeprecatedKt$distinctBy$12.L$2 = channelIterator;
                channelsKt__DeprecatedKt$distinctBy$12.L$3 = obj;
                channelsKt__DeprecatedKt$distinctBy$12.label = 3;
                if (producerScope3.send(obj3, channelsKt__DeprecatedKt$distinctBy$12) != obj4) {
                    return obj4;
                }
                hashSet = hashSet3;
                producerScope = producerScope3;
                obj2 = obj;
                channelsKt__DeprecatedKt$distinctBy$1 = channelsKt__DeprecatedKt$distinctBy$12;
                obj5 = obj4;
                hashSet.add(obj2);
                channelIterator2 = channelIterator;
                hashSet2 = hashSet;
                producerScope2 = producerScope;
                return obj4;
            }
            channelsKt__DeprecatedKt$distinctBy$1 = channelsKt__DeprecatedKt$distinctBy$12;
            obj5 = obj4;
            channelIterator2 = channelIterator;
            hashSet2 = hashSet3;
            producerScope2 = producerScope3;
        } else if (i == 3) {
            obj2 = this.L$3;
            channelIterator = (ChannelIterator) this.L$2;
            hashSet = (HashSet) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            k12.b(obj);
            channelsKt__DeprecatedKt$distinctBy$1 = this;
            hashSet.add(obj2);
            channelIterator2 = channelIterator;
            hashSet2 = hashSet;
            producerScope2 = producerScope;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = producerScope2;
        channelsKt__DeprecatedKt$distinctBy$1.L$1 = hashSet2;
        channelsKt__DeprecatedKt$distinctBy$1.L$2 = channelIterator2;
        channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
        channelsKt__DeprecatedKt$distinctBy$1.label = 1;
        Object hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
        if (hasNext == obj5) {
            return obj5;
        }
        channelsKt__DeprecatedKt$distinctBy$12 = channelsKt__DeprecatedKt$distinctBy$1;
        obj = hasNext;
        producerScope4 = producerScope2;
        hashSet4 = hashSet2;
        channelIterator = channelIterator2;
        obj4 = obj5;
        if (!((Boolean) obj).booleanValue()) {
        }
        return ur2.INSTANCE;
        return obj5;
    }
}
