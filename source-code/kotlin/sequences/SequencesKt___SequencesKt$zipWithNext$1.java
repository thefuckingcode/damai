package kotlin.sequences;

import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.do2;

/* compiled from: Taobao */
final class SequencesKt___SequencesKt$zipWithNext$1 extends Lambda implements Function2<Object, Object, Pair<Object, Object>> {
    public static final SequencesKt___SequencesKt$zipWithNext$1 INSTANCE = new SequencesKt___SequencesKt$zipWithNext$1();

    SequencesKt___SequencesKt$zipWithNext$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final Pair<Object, Object> invoke(Object obj, Object obj2) {
        return do2.a(obj, obj2);
    }
}
