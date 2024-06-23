package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.do2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\n"}, d2 = {ExifInterface.LONGITUDE_EAST, "R", "t1", "t2", "Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class ChannelsKt__DeprecatedKt$zip$1 extends Lambda implements Function2<E, R, Pair<? extends E, ? extends R>> {
    public static final ChannelsKt__DeprecatedKt$zip$1 INSTANCE = new ChannelsKt__DeprecatedKt$zip$1();

    ChannelsKt__DeprecatedKt$zip$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final Pair<E, R> invoke(E e, R r) {
        return do2.a(e, r);
    }
}
