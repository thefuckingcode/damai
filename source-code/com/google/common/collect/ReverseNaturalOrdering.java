package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import tb.ds1;

@GwtCompatible(serializable = true)
/* compiled from: Taobao */
final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    public int compare(Comparable comparable, Comparable comparable2) {
        ds1.p(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public <E extends Comparable> E max(E e, E e2) {
        return (E) ((Comparable) NaturalOrdering.INSTANCE.min(e, e2));
    }

    public <E extends Comparable> E min(E e, E e2) {
        return (E) ((Comparable) NaturalOrdering.INSTANCE.max(e, e2));
    }

    public <E extends Comparable> E max(E e, E e2, E e3, E... eArr) {
        return (E) ((Comparable) NaturalOrdering.INSTANCE.min(e, e2, e3, eArr));
    }

    public <E extends Comparable> E min(E e, E e2, E e3, E... eArr) {
        return (E) ((Comparable) NaturalOrdering.INSTANCE.max(e, e2, e3, eArr));
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterator<E> it) {
        return (E) ((Comparable) NaturalOrdering.INSTANCE.min(it));
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterator<E> it) {
        return (E) ((Comparable) NaturalOrdering.INSTANCE.max(it));
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (E) ((Comparable) NaturalOrdering.INSTANCE.min(iterable));
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (E) ((Comparable) NaturalOrdering.INSTANCE.max(iterable));
    }
}
