package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.p7;
import tb.pj;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class d<T> implements Collection<T>, KMappedMarker {
    @NotNull
    private final T[] a;
    private final boolean b;

    public d(@NotNull T[] tArr, boolean z) {
        k21.i(tArr, "values");
        this.a = tArr;
        this.b = z;
    }

    public int a() {
        return this.a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return ArraysKt___ArraysKt.r(this.a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return p7.a(this.a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return a();
    }

    @NotNull
    public final Object[] toArray() {
        return l.b(this.a, this.b);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        k21.i(tArr, "array");
        return (T[]) pj.b(this, tArr);
    }
}
