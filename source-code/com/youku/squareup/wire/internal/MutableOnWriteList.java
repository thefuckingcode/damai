package com.youku.squareup.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class MutableOnWriteList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    private final List<T> immutableList;
    List<T> mutableList;

    MutableOnWriteList(List<T> list) {
        this.immutableList = list;
        this.mutableList = list;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.mutableList);
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, T t) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        this.mutableList.add(i, t);
    }

    @Override // java.util.List, java.util.AbstractList
    public T get(int i) {
        return this.mutableList.get(i);
    }

    @Override // java.util.List, java.util.AbstractList
    public T remove(int i) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        return this.mutableList.remove(i);
    }

    @Override // java.util.List, java.util.AbstractList
    public T set(int i, T t) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        return this.mutableList.set(i, t);
    }

    public int size() {
        return this.mutableList.size();
    }
}
