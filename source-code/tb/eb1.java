package tb;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.builders.MapBuilder;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class eb1<K, V> extends u1<Map.Entry<K, V>, K, V> {
    @NotNull
    private final MapBuilder<K, V> a;

    public eb1(@NotNull MapBuilder<K, V> mapBuilder) {
        k21.i(mapBuilder, "backing");
        this.a = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends Map.Entry<K, V>> collection) {
        k21.i(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // tb.u1
    public boolean b(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        k21.i(entry, "element");
        return this.a.containsEntry$kotlin_stdlib(entry);
    }

    @Override // tb.u1
    public boolean c(@NotNull Map.Entry entry) {
        k21.i(entry, "element");
        return this.a.removeEntry$kotlin_stdlib(entry);
    }

    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        return this.a.containsAllEntries$kotlin_stdlib(collection);
    }

    /* renamed from: d */
    public boolean add(@NotNull Map.Entry<K, V> entry) {
        k21.i(entry, "element");
        throw new UnsupportedOperationException();
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
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.a.entriesIterator$kotlin_stdlib();
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
