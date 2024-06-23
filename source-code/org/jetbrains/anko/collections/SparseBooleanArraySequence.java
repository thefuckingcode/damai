package org.jetbrains.anko.collections;

import android.util.SparseBooleanArray;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lorg/jetbrains/anko/collections/SparseBooleanArraySequence;", "Lkotlin/sequences/Sequence;", "", "a", "Landroid/util/SparseBooleanArray;", "(Landroid/util/SparseBooleanArray;)V", "iterator", "", "SparseIntArrayIterator", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: Arrays.kt */
public final class SparseBooleanArraySequence implements Sequence<Boolean> {
    private final SparseBooleanArray a;

    public SparseBooleanArraySequence(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "a");
        this.a = sparseBooleanArray;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Boolean> iterator() {
        return new SparseIntArrayIterator();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lorg/jetbrains/anko/collections/SparseBooleanArraySequence$SparseIntArrayIterator;", "", "", "(Lorg/jetbrains/anko/collections/SparseBooleanArraySequence;)V", "index", "", "size", "hasNext", "next", "()Ljava/lang/Boolean;", "commons-base_release"}, k = 1, mv = {1, 1, 11})
    /* compiled from: Arrays.kt */
    private final class SparseIntArrayIterator implements Iterator<Boolean>, KMappedMarker {
        private int index;
        private final int size;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public SparseIntArrayIterator() {
            this.size = SparseBooleanArraySequence.this.a.size();
        }

        public boolean hasNext() {
            return this.size > this.index;
        }

        @Override // java.util.Iterator
        public Boolean next() {
            if (SparseBooleanArraySequence.this.a.size() == this.size) {
                SparseBooleanArray sparseBooleanArray = SparseBooleanArraySequence.this.a;
                int i = this.index;
                this.index = i + 1;
                return Boolean.valueOf(sparseBooleanArray.get(i));
            }
            throw new ConcurrentModificationException();
        }
    }
}
