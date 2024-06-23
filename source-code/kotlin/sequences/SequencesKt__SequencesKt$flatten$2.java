package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class SequencesKt__SequencesKt$flatten$2 extends Lambda implements Function1<Iterable<Object>, Iterator<Object>> {
    public static final SequencesKt__SequencesKt$flatten$2 INSTANCE = new SequencesKt__SequencesKt$flatten$2();

    SequencesKt__SequencesKt$flatten$2() {
        super(1);
    }

    @NotNull
    public final Iterator<Object> invoke(@NotNull Iterable<Object> iterable) {
        k21.i(iterable, AdvanceSetting.NETWORK_TYPE);
        return iterable.iterator();
    }
}
