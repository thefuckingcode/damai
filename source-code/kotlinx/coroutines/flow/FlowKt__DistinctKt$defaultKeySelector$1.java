package kotlinx.coroutines.flow;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", AdvanceSetting.NETWORK_TYPE, "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class FlowKt__DistinctKt$defaultKeySelector$1 extends Lambda implements Function1<Object, Object> {
    public static final FlowKt__DistinctKt$defaultKeySelector$1 INSTANCE = new FlowKt__DistinctKt$defaultKeySelector$1();

    FlowKt__DistinctKt$defaultKeySelector$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Object invoke(@Nullable Object obj) {
        return obj;
    }
}
