package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.b;
import kotlin.collections.e;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.k7;
import tb.q71;
import tb.s1;

/* compiled from: Taobao */
public final class ListBuilder<E> extends b<E> implements List<E>, RandomAccess {
    @NotNull
    private E[] array;
    @Nullable
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    @Nullable
    private final ListBuilder<E> root;

    /* compiled from: Taobao */
    private static final class a<E> implements ListIterator<E>, KMutableListIterator {
        @NotNull
        private final ListBuilder<E> a;
        private int b;
        private int c = -1;

        public a(@NotNull ListBuilder<E> listBuilder, int i) {
            k21.i(listBuilder, "list");
            this.a = listBuilder;
            this.b = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            ListBuilder<E> listBuilder = this.a;
            int i = this.b;
            this.b = i + 1;
            listBuilder.add(i, e);
            this.c = -1;
        }

        public boolean hasNext() {
            return this.b < ((ListBuilder) this.a).length;
        }

        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public E next() {
            if (this.b < ((ListBuilder) this.a).length) {
                int i = this.b;
                this.b = i + 1;
                this.c = i;
                return (E) ((ListBuilder) this.a).array[((ListBuilder) this.a).offset + this.c];
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i = this.b;
            if (i > 0) {
                int i2 = i - 1;
                this.b = i2;
                this.c = i2;
                return (E) ((ListBuilder) this.a).array[((ListBuilder) this.a).offset + this.c];
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.b - 1;
        }

        public void remove() {
            int i = this.c;
            if (i != -1) {
                this.a.remove(i);
                this.b = this.c;
                this.c = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            int i = this.c;
            if (i != -1) {
                this.a.set(i, e);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i;
        this.length = i2;
        this.isReadOnly = z;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: E[] */
    /* JADX WARN: Multi-variable type inference failed */
    private final void addAllInternal(int i, Collection<? extends E> collection, int i2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i, collection, i2);
            this.array = this.backing.array;
            this.length += i2;
            return;
        }
        insertAtInternal(i, i2);
        Iterator<? extends E> it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.array[i + i3] = it.next();
        }
    }

    private final void addAtInternal(int i, E e) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i, e);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i, 1);
        this.array[i] = e;
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        return q71.h(this.array, this.offset, this.length, list);
    }

    private final void ensureCapacity(int i) {
        if (this.backing != null) {
            throw new IllegalStateException();
        } else if (i >= 0) {
            E[] eArr = this.array;
            if (i > eArr.length) {
                this.array = (E[]) q71.e(this.array, k7.Companion.a(eArr.length, i));
            }
        } else {
            throw new OutOfMemoryError();
        }
    }

    private final void ensureExtraCapacity(int i) {
        ensureCapacity(this.length + i);
    }

    private final void insertAtInternal(int i, int i2) {
        ensureExtraCapacity(i2);
        E[] eArr = this.array;
        e.e(eArr, eArr, i + i2, i, this.offset + this.length);
        this.length += i2;
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        return this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly);
    }

    private final E removeAtInternal(int i) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i);
        }
        E[] eArr = this.array;
        E e = eArr[i];
        e.e(eArr, eArr, i, i + 1, this.offset + this.length);
        q71.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e;
    }

    private final void removeRangeInternal(int i, int i2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i, i2);
        } else {
            E[] eArr = this.array;
            e.e(eArr, eArr, i, i + i2, this.length);
            E[] eArr2 = this.array;
            int i3 = this.length;
            q71.g(eArr2, i3 - i2, i3);
        }
        this.length -= i2;
    }

    private final int retainOrRemoveAllInternal(int i, int i2, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i, i2, collection, z);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.array[i5]) == z) {
                E[] eArr = this.array;
                i3++;
                eArr[i4 + i] = eArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        E[] eArr2 = this.array;
        e.e(eArr2, eArr2, i + i4, i2 + i, this.length);
        E[] eArr3 = this.array;
        int i7 = this.length;
        q71.g(eArr3, i7 - i6, i7);
        this.length -= i6;
        return i6;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        k21.i(collection, "elements");
        checkIsMutable();
        int size = collection.size();
        addAllInternal(this.offset + this.length, collection, size);
        return size > 0;
    }

    @NotNull
    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    @Override // java.util.List, java.util.AbstractList
    public E get(int i) {
        s1.Companion.a(i, this.length);
        return this.array[this.offset + i];
    }

    @Override // kotlin.collections.b
    public int getSize() {
        return this.length;
    }

    public int hashCode() {
        return q71.i(this.array, this.offset, this.length);
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (k21.d(this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    public int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (k21.d(this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.AbstractList
    @NotNull
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, false) > 0;
    }

    @Override // kotlin.collections.b
    public E removeAt(int i) {
        checkIsMutable();
        s1.Companion.a(i, this.length);
        return removeAtInternal(this.offset + i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        k21.i(collection, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, true) > 0;
    }

    @Override // kotlin.collections.b, java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        checkIsMutable();
        s1.Companion.a(i, this.length);
        E[] eArr = this.array;
        int i2 = this.offset;
        E e2 = eArr[i2 + i];
        eArr[i2 + i] = e;
        return e2;
    }

    @Override // java.util.List, java.util.AbstractList
    @NotNull
    public List<E> subList(int i, int i2) {
        s1.Companion.c(i, i2, this.length);
        E[] eArr = this.array;
        int i3 = this.offset + i;
        int i4 = i2 - i;
        boolean z = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i3, i4, z, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        k21.i(tArr, "destination");
        int length2 = tArr.length;
        int i = this.length;
        if (length2 < i) {
            E[] eArr = this.array;
            int i2 = this.offset;
            T[] tArr2 = (T[]) Arrays.copyOfRange(eArr, i2, i + i2, tArr.getClass());
            k21.h(tArr2, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr2;
        }
        E[] eArr2 = this.array;
        k21.g(eArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        int i3 = this.offset;
        e.e(eArr2, tArr, 0, i3, this.length + i3);
        int length3 = tArr.length;
        int i4 = this.length;
        if (length3 > i4) {
            tArr[i4] = null;
        }
        return tArr;
    }

    @NotNull
    public String toString() {
        return q71.j(this.array, this.offset, this.length);
    }

    @Override // java.util.List, java.util.AbstractList
    @NotNull
    public ListIterator<E> listIterator(int i) {
        s1.Companion.b(i, this.length);
        return new a(this, i);
    }

    @Override // kotlin.collections.b, java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        checkIsMutable();
        s1.Companion.b(i, this.length);
        addAtInternal(this.offset + i, e);
    }

    @Override // java.util.List, java.util.AbstractList
    public boolean addAll(int i, @NotNull Collection<? extends E> collection) {
        k21.i(collection, "elements");
        checkIsMutable();
        s1.Companion.b(i, this.length);
        int size = collection.size();
        addAllInternal(this.offset + i, collection, size);
        return size > 0;
    }

    @NotNull
    public Object[] toArray() {
        E[] eArr = this.array;
        int i = this.offset;
        Object[] h = e.h(eArr, i, this.length + i);
        k21.g(h, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return h;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(q71.d(i), 0, 0, false, null, null);
    }
}
