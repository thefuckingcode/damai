package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;
    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] links;

    CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactLinkedHashMap<>(i);
    }

    private int getPredecessor(int i) {
        return (int) (this.links[i] >>> 32);
    }

    private void setPredecessor(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & 4294967295L) | (((long) i2) << 32);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstEntry = i2;
        } else {
            setSuccessor(i, i2);
        }
        if (i2 == -2) {
            this.lastEntry = i;
        } else {
            setPredecessor(i2, i);
        }
    }

    private void setSuccessor(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & -4294967296L) | (((long) i2) & 4294967295L);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int i) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i), getSuccessor(i));
            setSucceeds(this.lastEntry, i);
            setSucceeds(i, -2);
            this.modCount++;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void allocArrays() {
        super.allocArrays();
        long[] jArr = new long[this.keys.length];
        this.links = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void clear() {
        if (!needsAllocArrays()) {
            this.firstEntry = -2;
            this.lastEntry = -2;
            Arrays.fill(this.links, 0, size(), -1L);
            super.clear();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int i) {
        return (int) this.links[i];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void init(int i) {
        super.init(i);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int i, K k, V v, int i2) {
        super.insertEntry(i, k, v, i2);
        setSucceeds(this.lastEntry, i);
        setSucceeds(i, -2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i) {
        int size = size() - 1;
        super.moveLastEntry(i);
        setSucceeds(getPredecessor(i), getSuccessor(i));
        if (i < size) {
            setSucceeds(getPredecessor(size), i);
            setSucceeds(i, getSuccessor(size));
        }
        this.links[size] = -1;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int i) {
        super.resizeEntries(i);
        long[] jArr = this.links;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        this.links = copyOf;
        if (length < i) {
            Arrays.fill(copyOf, length, i, -1L);
        }
    }

    CompactLinkedHashMap(int i) {
        this(i, false);
    }

    CompactLinkedHashMap(int i, boolean z) {
        super(i);
        this.accessOrder = z;
    }
}
