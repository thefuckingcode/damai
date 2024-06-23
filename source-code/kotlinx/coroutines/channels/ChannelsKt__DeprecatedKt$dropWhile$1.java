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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {164, 165, 166, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_DOWNLOAD_SPEED_CALC_COUNT}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$dropWhile$1> continuation) {
        super(2, continuation);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super E> producerScope, @Nullable Continuation<? super ur2> continuation) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(producerScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ProducerScope producerScope;
        ChannelIterator<E> channelIterator;
        Object obj2;
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1;
        ChannelIterator<E> channelIterator2;
        Object hasNext;
        ProducerScope producerScope2;
        Object obj3;
        ChannelIterator<E> channelIterator3;
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$12;
        ChannelIterator<E> channelIterator4;
        ProducerScope producerScope3;
        Object obj4 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            channelIterator4 = this.$this_dropWhile.iterator();
            producerScope3 = (ProducerScope) this.L$0;
            channelsKt__DeprecatedKt$dropWhile$12 = this;
        } else if (i == 1) {
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            channelIterator3 = (ChannelIterator) this.L$1;
            obj2 = obj4;
            channelsKt__DeprecatedKt$dropWhile$1 = this;
            if (((Boolean) obj).booleanValue()) {
                Object next = channelIterator3.next();
                Function2<E, Continuation<? super Boolean>, Object> function2 = channelsKt__DeprecatedKt$dropWhile$1.$predicate;
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = channelIterator3;
                channelsKt__DeprecatedKt$dropWhile$1.L$2 = next;
                channelsKt__DeprecatedKt$dropWhile$1.label = 2;
                Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$dropWhile$1);
                if (invoke == obj2) {
                    return obj2;
                }
                obj3 = next;
                obj = invoke;
                producerScope2 = producerScope;
                if (((Boolean) obj).booleanValue()) {
                }
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope2;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = null;
                channelsKt__DeprecatedKt$dropWhile$1.L$2 = null;
                channelsKt__DeprecatedKt$dropWhile$1.label = 3;
                if (producerScope2.send(obj3, channelsKt__DeprecatedKt$dropWhile$1) == obj2) {
                }
                producerScope = producerScope2;
                return obj2;
            }
            channelIterator2 = channelsKt__DeprecatedKt$dropWhile$1.$this_dropWhile.iterator();
            channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$dropWhile$1.L$1 = channelIterator2;
            channelsKt__DeprecatedKt$dropWhile$1.label = 4;
            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
            if (hasNext != obj2) {
            }
            return obj2;
        } else if (i == 2) {
            Object obj5 = this.L$2;
            channelIterator3 = (ChannelIterator) this.L$1;
            k12.b(obj);
            producerScope2 = (ProducerScope) this.L$0;
            obj3 = obj5;
            obj2 = obj4;
            channelsKt__DeprecatedKt$dropWhile$1 = this;
            if (((Boolean) obj).booleanValue()) {
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope2;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = null;
                channelsKt__DeprecatedKt$dropWhile$1.L$2 = null;
                channelsKt__DeprecatedKt$dropWhile$1.label = 3;
            } else {
                channelsKt__DeprecatedKt$dropWhile$12 = channelsKt__DeprecatedKt$dropWhile$1;
                obj4 = obj2;
                channelIterator4 = channelIterator3;
                producerScope3 = producerScope2;
            }
            channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope2;
            channelsKt__DeprecatedKt$dropWhile$1.L$1 = null;
            channelsKt__DeprecatedKt$dropWhile$1.L$2 = null;
            channelsKt__DeprecatedKt$dropWhile$1.label = 3;
            if (producerScope2.send(obj3, channelsKt__DeprecatedKt$dropWhile$1) == obj2) {
                return obj2;
            }
            producerScope = producerScope2;
            channelIterator2 = channelsKt__DeprecatedKt$dropWhile$1.$this_dropWhile.iterator();
            channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$dropWhile$1.L$1 = channelIterator2;
            channelsKt__DeprecatedKt$dropWhile$1.label = 4;
            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
            if (hasNext != obj2) {
            }
            return obj2;
        } else if (i == 3) {
            k12.b(obj);
            producerScope2 = (ProducerScope) this.L$0;
            obj2 = obj4;
            channelsKt__DeprecatedKt$dropWhile$1 = this;
            producerScope = producerScope2;
            channelIterator2 = channelsKt__DeprecatedKt$dropWhile$1.$this_dropWhile.iterator();
            channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$dropWhile$1.L$1 = channelIterator2;
            channelsKt__DeprecatedKt$dropWhile$1.label = 4;
            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
            if (hasNext != obj2) {
            }
            return obj2;
        } else if (i == 4) {
            k12.b(obj);
            producerScope = (ProducerScope) this.L$0;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = obj4;
            channelsKt__DeprecatedKt$dropWhile$1 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
            return ur2.INSTANCE;
        } else if (i == 5) {
            k12.b(obj);
            channelIterator2 = (ChannelIterator) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            obj2 = obj4;
            channelsKt__DeprecatedKt$dropWhile$1 = this;
            channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$dropWhile$1.L$1 = channelIterator2;
            channelsKt__DeprecatedKt$dropWhile$1.label = 4;
            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
            if (hasNext != obj2) {
                return obj2;
            }
            channelIterator = channelIterator2;
            obj = hasNext;
            if (!((Boolean) obj).booleanValue()) {
                Object next2 = channelIterator.next();
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$dropWhile$1.label = 5;
                if (producerScope.send(next2, channelsKt__DeprecatedKt$dropWhile$1) == obj2) {
                    return obj2;
                }
                channelIterator2 = channelIterator;
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = channelIterator2;
                channelsKt__DeprecatedKt$dropWhile$1.label = 4;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
                if (hasNext != obj2) {
                }
                return obj2;
            }
            return ur2.INSTANCE;
            return obj2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope3;
        channelsKt__DeprecatedKt$dropWhile$12.L$1 = channelIterator4;
        channelsKt__DeprecatedKt$dropWhile$12.L$2 = null;
        channelsKt__DeprecatedKt$dropWhile$12.label = 1;
        Object hasNext2 = channelIterator4.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
        if (hasNext2 == obj4) {
            return obj4;
        }
        channelsKt__DeprecatedKt$dropWhile$1 = channelsKt__DeprecatedKt$dropWhile$12;
        obj = hasNext2;
        producerScope = producerScope3;
        channelIterator3 = channelIterator4;
        obj2 = obj4;
        if (((Boolean) obj).booleanValue()) {
        }
        channelIterator2 = channelsKt__DeprecatedKt$dropWhile$1.$this_dropWhile.iterator();
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
        channelsKt__DeprecatedKt$dropWhile$1.L$1 = channelIterator2;
        channelsKt__DeprecatedKt$dropWhile$1.label = 4;
        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
        if (hasNext != obj2) {
        }
        return obj2;
        return obj4;
    }
}
