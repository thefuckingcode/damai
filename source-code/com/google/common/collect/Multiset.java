package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public interface Multiset<E> extends Collection<E> {

    /* compiled from: Taobao */
    public interface Entry<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    @CanIgnoreReturnValue
    int add(@NullableDecl E e, int i);

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    boolean add(E e);

    boolean contains(@NullableDecl Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(@NullableDecl @CompatibleWith("E") Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@NullableDecl Object obj);

    int hashCode();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @CanIgnoreReturnValue
    int remove(@NullableDecl @CompatibleWith("E") Object obj, int i);

    @CanIgnoreReturnValue
    boolean remove(@NullableDecl Object obj);

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    boolean retainAll(Collection<?> collection);

    @CanIgnoreReturnValue
    int setCount(E e, int i);

    @CanIgnoreReturnValue
    boolean setCount(E e, int i, int i2);

    int size();

    String toString();
}
