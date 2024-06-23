package tb;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class rm<T> implements Sequence<T> {
    @NotNull
    private final AtomicReference<Sequence<T>> a;

    public rm(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "sequence");
        this.a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        Sequence<T> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
