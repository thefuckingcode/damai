package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public abstract class x<E> extends v<E> implements SortedSet<E> {
    protected x() {
    }

    private int unsafeCompare(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Comparator<? super E> comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
    public abstract /* bridge */ /* synthetic */ Object delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
    public abstract /* bridge */ /* synthetic */ Set delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return delegate().headSet(e);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    @Beta
    public boolean standardContains(@NullableDecl Object obj) {
        try {
            if (unsafeCompare(tailSet(obj).first(), obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    @Beta
    public boolean standardRemove(@NullableDecl Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (it.hasNext() && unsafeCompare(it.next(), obj) == 0) {
                it.remove();
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Beta
    public SortedSet<E> standardSubSet(E e, E e2) {
        return tailSet(e).headSet(e2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return delegate().subSet(e, e2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return delegate().tailSet(e);
    }
}
