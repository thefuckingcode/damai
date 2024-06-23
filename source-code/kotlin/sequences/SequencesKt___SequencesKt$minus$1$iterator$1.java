package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Object $element;
    final /* synthetic */ Ref$BooleanRef $removed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$minus$1$iterator$1(Ref$BooleanRef ref$BooleanRef, Object obj) {
        super(1);
        this.$removed = ref$BooleanRef;
        this.$element = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(Object obj) {
        boolean z = true;
        if (!this.$removed.element && k21.d(obj, this.$element)) {
            this.$removed.element = true;
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
