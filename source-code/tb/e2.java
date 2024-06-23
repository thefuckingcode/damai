package tb;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public abstract class e2<T> extends wr2<T> {
    @NullableDecl
    private T a;

    protected e2(@NullableDecl T t) {
        this.a = t;
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public abstract T a(T t);

    public final boolean hasNext() {
        return this.a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                T t = this.a;
                this.a = a(t);
                return t;
            } catch (Throwable th) {
                this.a = a(this.a);
                throw th;
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
