package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public /* synthetic */ class SequencesKt___SequencesKt$flatMap$2 extends FunctionReferenceImpl implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMap$2 INSTANCE = new SequencesKt___SequencesKt$flatMap$2();

    SequencesKt___SequencesKt$flatMap$2() {
        super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: java.util.Iterator<? extends R>, java.util.Iterator<R> */
    @NotNull
    public final Iterator<R> invoke(@NotNull Sequence<? extends R> sequence) {
        k21.i(sequence, "p0");
        return (Iterator<? extends R>) sequence.iterator();
    }
}
