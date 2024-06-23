package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.weex.ui.component.AbstractEditComponent;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.wj2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0004\u001a\u00020\u0003H¦Bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0004\b\u0006\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ChannelIterator;", ExifInterface.LONGITUDE_EAST, "", "", wj2.HAS_NEXT, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AbstractEditComponent.ReturnTypes.NEXT, "next0", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface ChannelIterator<E> {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = AbstractEditComponent.ReturnTypes.NEXT)
        public static /* synthetic */ Object a(ChannelIterator channelIterator, Continuation continuation) {
            ChannelIterator$next0$1 channelIterator$next0$1;
            Object obj;
            int i;
            if (continuation instanceof ChannelIterator$next0$1) {
                channelIterator$next0$1 = (ChannelIterator$next0$1) continuation;
                int i2 = channelIterator$next0$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelIterator$next0$1.label = i2 - Integer.MIN_VALUE;
                    obj = channelIterator$next0$1.result;
                    Object obj2 = b.d();
                    i = channelIterator$next0$1.label;
                    if (i != 0) {
                        k12.b(obj);
                        channelIterator$next0$1.L$0 = channelIterator;
                        channelIterator$next0$1.label = 1;
                        obj = channelIterator.hasNext(channelIterator$next0$1);
                        if (obj == obj2) {
                            return obj2;
                        }
                    } else if (i == 1) {
                        channelIterator = (ChannelIterator) channelIterator$next0$1.L$0;
                        k12.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return channelIterator.next();
                    }
                    throw new ClosedReceiveChannelException(b.DEFAULT_CLOSE_MESSAGE);
                }
            }
            channelIterator$next0$1 = new ChannelIterator$next0$1(continuation);
            obj = channelIterator$next0$1.result;
            Object obj22 = b.d();
            i = channelIterator$next0$1.label;
            if (i != 0) {
            }
            if (!((Boolean) obj).booleanValue()) {
            }
        }
    }

    @Nullable
    Object hasNext(@NotNull Continuation<? super Boolean> continuation);

    E next();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @JvmName(name = AbstractEditComponent.ReturnTypes.NEXT)
    /* synthetic */ Object next(Continuation continuation);
}
