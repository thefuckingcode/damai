package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import tb.ds1;
import tb.yr2;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public abstract class a<E> extends yr2<E> {
    private final int a;
    private int b;

    protected a(int i) {
        this(i, 0);
    }

    /* access modifiers changed from: protected */
    public abstract E a(int i);

    public final boolean hasNext() {
        return this.b < this.a;
    }

    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.b;
            this.b = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.b - 1;
            this.b = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.b - 1;
    }

    protected a(int i, int i2) {
        ds1.t(i2, i);
        this.a = i;
        this.b = i2;
    }
}
