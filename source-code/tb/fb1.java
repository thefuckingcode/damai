package tb;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class fb1<E> extends c<E> {
    @NotNull
    private final MapBuilder<E, ?> a;

    public fb1(@NotNull MapBuilder<E, ?> mapBuilder) {
        k21.i(mapBuilder, "backing");
        this.a = mapBuilder;
    }

    @Override // kotlin.collections.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        k21.i(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // kotlin.collections.c
    public int getSize() {
        return this.a.size();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return this.a.keysIterator$kotlin_stdlib();
    }

    public boolean remove(Object obj) {
        return this.a.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.AbstractSet, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
