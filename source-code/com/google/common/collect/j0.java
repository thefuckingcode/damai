package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import tb.ds1;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public abstract class j0<F, T> implements Iterator<T> {
    final Iterator<? extends F> a;

    j0(Iterator<? extends F> it) {
        this.a = (Iterator) ds1.p(it);
    }

    /* access modifiers changed from: package-private */
    public abstract T a(F f);

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.j0<F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final T next() {
        return (T) a(this.a.next());
    }

    public final void remove() {
        this.a.remove();
    }
}
