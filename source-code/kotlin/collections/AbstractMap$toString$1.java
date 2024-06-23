package kotlin.collections;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.t1;

/* compiled from: Taobao */
final class AbstractMap$toString$1 extends Lambda implements Function1<Map.Entry<Object, Object>, CharSequence> {
    final /* synthetic */ t1<Object, Object> this$0;

    AbstractMap$toString$1(t1<Object, Object> t1Var) {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Map.Entry<Object, Object> entry) {
        k21.i(entry, AdvanceSetting.NETWORK_TYPE);
        return t1.a(this.this$0, entry);
    }
}
