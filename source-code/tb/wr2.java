package tb;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
/* compiled from: Taobao */
public abstract class wr2<E> implements Iterator<E> {
    protected wr2() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
