package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "old", "new", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class FlowKt__DistinctKt$defaultAreEquivalent$1 extends Lambda implements Function2<Object, Object, Boolean> {
    public static final FlowKt__DistinctKt$defaultAreEquivalent$1 INSTANCE = new FlowKt__DistinctKt$defaultAreEquivalent$1();

    FlowKt__DistinctKt$defaultAreEquivalent$1() {
        super(2);
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(@Nullable Object obj, @Nullable Object obj2) {
        return k21.d(obj, obj2);
    }
}
