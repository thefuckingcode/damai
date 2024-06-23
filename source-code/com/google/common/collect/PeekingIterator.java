package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
/* compiled from: Taobao */
public interface PeekingIterator<E> extends Iterator<E> {
    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    E next();

    E peek();

    void remove();
}
