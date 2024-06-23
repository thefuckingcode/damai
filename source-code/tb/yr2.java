package tb;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
/* compiled from: Taobao */
public abstract class yr2<E> extends wr2<E> implements ListIterator<E> {
    protected yr2() {
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
