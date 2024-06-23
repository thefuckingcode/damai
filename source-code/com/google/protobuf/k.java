package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class k<E> extends b<E> {
    private static final k<Object> c;
    private final List<E> b;

    static {
        k<Object> kVar = new k<>();
        c = kVar;
        kVar.makeImmutable();
    }

    k() {
        this(new ArrayList(10));
    }

    public static <E> k<E> b() {
        return (k<E>) c;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        a();
        this.b.add(i, e);
        ((AbstractList) this).modCount++;
    }

    /* renamed from: c */
    public k<E> mutableCopyWithCapacity(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.b);
            return new k<>(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public E get(int i) {
        return this.b.get(i);
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        a();
        E remove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        a();
        E e2 = this.b.set(i, e);
        ((AbstractList) this).modCount++;
        return e2;
    }

    public int size() {
        return this.b.size();
    }

    private k(List<E> list) {
        this.b = list;
    }
}
