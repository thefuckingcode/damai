package com.youku.squareup.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ImmutableList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    private final ArrayList<T> list;

    ImmutableList(List<T> list2) {
        this.list = new ArrayList<>(list2);
    }

    private Object writeReplace() throws ObjectStreamException {
        return Collections.unmodifiableList(this.list);
    }

    @Override // java.util.List, java.util.AbstractList
    public T get(int i) {
        return this.list.get(i);
    }

    public int size() {
        return this.list.size();
    }

    public Object[] toArray() {
        return this.list.toArray();
    }
}
