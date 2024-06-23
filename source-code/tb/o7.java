package tb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class o7<T> implements Iterator<T>, KMappedMarker {
    @NotNull
    private final T[] a;
    private int b;

    public o7(@NotNull T[] tArr) {
        k21.i(tArr, "array");
        this.a = tArr;
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
