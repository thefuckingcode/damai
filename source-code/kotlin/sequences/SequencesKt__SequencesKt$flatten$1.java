package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SequencesKt__SequencesKt$flatten$1 extends Lambda implements Function1<Sequence<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt$flatten$1 INSTANCE = new SequencesKt__SequencesKt$flatten$1();

    SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: java.util.Iterator<? extends T>, java.util.Iterator<T> */
    @NotNull
    public final Iterator<T> invoke(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, AdvanceSetting.NETWORK_TYPE);
        return (Iterator<? extends T>) sequence.iterator();
    }
}
