package kotlin.sequences;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class SequencesKt___SequencesKt$minus$4$iterator$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Collection<Object> $other;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$minus$4$iterator$1(Collection<Object> collection) {
        super(1);
        this.$other = collection;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(this.$other.contains(obj));
    }
}
