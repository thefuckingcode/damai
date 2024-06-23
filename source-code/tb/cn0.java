package tb;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.t;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
/* compiled from: Taobao */
public abstract class cn0<T> extends t implements Iterator<T> {
    protected cn0() {
    }

    /* access modifiers changed from: protected */
    public abstract Iterator<T> a();

    public boolean hasNext() {
        return a().hasNext();
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public T next() {
        return a().next();
    }
}
