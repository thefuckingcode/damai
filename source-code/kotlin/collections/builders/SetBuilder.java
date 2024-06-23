package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.c;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class SetBuilder<E> extends c<E> implements Set<E> {
    @NotNull
    private final MapBuilder<E, ?> backing;

    public SetBuilder(@NotNull MapBuilder<E, ?> mapBuilder) {
        k21.i(mapBuilder, "backing");
        this.backing = mapBuilder;
    }

    private final Object writeReplace() {
        if (this.backing.isReadOnly$kotlin_stdlib()) {
            return new SerializedCollection(this, 1);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        return this.backing.addKey$kotlin_stdlib(e) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        k21.i(collection, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.addAll(collection);
    }

    @NotNull
    public final Set<E> build() {
        this.backing.build();
        return this;
    }

    public void clear() {
        this.backing.clear();
    }

    public boolean contains(Object obj) {
        return this.backing.containsKey(obj);
    }

    @Override // kotlin.collections.c
    public int getSize() {
        return this.backing.size();
    }

    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return this.backing.keysIterator$kotlin_stdlib();
    }

    public boolean remove(Object obj) {
        return this.backing.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.AbstractSet, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    public SetBuilder() {
        this(new MapBuilder());
    }

    public SetBuilder(int i) {
        this(new MapBuilder(i));
    }
}
