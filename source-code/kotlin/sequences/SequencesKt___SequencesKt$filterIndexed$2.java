package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.s01;

/* compiled from: Taobao */
final class SequencesKt___SequencesKt$filterIndexed$2 extends Lambda implements Function1<s01<Object>, Object> {
    public static final SequencesKt___SequencesKt$filterIndexed$2 INSTANCE = new SequencesKt___SequencesKt$filterIndexed$2();

    SequencesKt___SequencesKt$filterIndexed$2() {
        super(1);
    }

    public final Object invoke(@NotNull s01<Object> s01) {
        k21.i(s01, AdvanceSetting.NETWORK_TYPE);
        return s01.d();
    }
}
