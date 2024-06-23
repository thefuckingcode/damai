package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

public final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(Object[] objArr, int i) {
        Intrinsics.checkParameterIsNotNull(objArr, "buffer");
        this.buffer = objArr;
        boolean z = true;
        if (i >= 0) {
            if (i > objArr.length ? false : z) {
                this.capacity = objArr.length;
                this.size = i;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
    }

    public RingBuffer(int i) {
        this(new Object[i], 0);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    @Override // java.util.List, kotlin.collections.AbstractList
    public T get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return (T) this.buffer[(this.startIndex + i) % this.capacity];
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @Override // java.util.List, kotlin.collections.AbstractList, java.util.Collection, kotlin.collections.AbstractCollection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new RingBuffer$iterator$1(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection, kotlin.collections.AbstractCollection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            Intrinsics.checkExpressionValueIsNotNull(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size2 = size();
        int i = this.startIndex;
        int i2 = 0;
        int i3 = 0;
        while (i3 < size2 && i < this.capacity) {
            tArr[i3] = this.buffer[i];
            i3++;
            i++;
        }
        while (i3 < size2) {
            tArr[i3] = this.buffer[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        if (tArr != null) {
            return tArr;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.collections.RingBuffer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.collections.RingBuffer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> expanded(int i) {
        Object[] objArr;
        int i2 = this.capacity;
        int coerceAtMost = RangesKt.coerceAtMost(i2 + (i2 >> 1) + 1, i);
        if (this.startIndex == 0) {
            objArr = Arrays.copyOf(this.buffer, coerceAtMost);
            Intrinsics.checkExpressionValueIsNotNull(objArr, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            objArr = toArray(new Object[coerceAtMost]);
        }
        return new RingBuffer<>(objArr, size());
    }

    @Override // java.util.List, java.util.Collection, kotlin.collections.AbstractCollection
    public final void add(T t) {
        if (!isFull()) {
            this.buffer[(this.startIndex + size()) % this.capacity] = t;
            this.size = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    public final void removeFirst(int i) {
        boolean z = true;
        if (i >= 0) {
            if (i > size()) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
            } else if (i > 0) {
                int i2 = this.startIndex;
                int i3 = (i2 + i) % this.capacity;
                if (i2 > i3) {
                    ArraysKt.fill(this.buffer, (Object) null, i2, this.capacity);
                    ArraysKt.fill(this.buffer, (Object) null, 0, i3);
                } else {
                    ArraysKt.fill(this.buffer, (Object) null, i2, i3);
                }
                this.startIndex = i3;
                this.size = size() - i;
            }
        } else {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
    }

    /* access modifiers changed from: public */
    private final int forward(int i, int i2) {
        return (i + i2) % this.capacity;
    }
}
