package tb;

import java.util.Iterator;
import kotlin.collections.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class u01<T> implements Iterator<s01<? extends T>>, KMappedMarker {
    @NotNull
    private final Iterator<T> a;
    private int b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Iterator<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public u01(@NotNull Iterator<? extends T> it) {
        k21.i(it, "iterator");
        this.a = it;
    }

    @NotNull
    /* renamed from: a */
    public final s01<T> next() {
        int i = this.b;
        this.b = i + 1;
        if (i < 0) {
            m.p();
        }
        return new s01<>(i, this.a.next());
    }

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
