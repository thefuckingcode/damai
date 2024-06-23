package tb;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.builders.MapBuilder;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class gb1<V> extends w1<V> {
    @NotNull
    private final MapBuilder<?, V> a;

    public gb1(@NotNull MapBuilder<?, V> mapBuilder) {
        k21.i(mapBuilder, "backing");
        this.a = mapBuilder;
    }

    @Override // tb.w1
    public int a() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends V> collection) {
        k21.i(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<V> iterator() {
        return this.a.valuesIterator$kotlin_stdlib();
    }

    public boolean remove(Object obj) {
        return this.a.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
