package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.wr2;

@GwtCompatible
/* compiled from: Taobao */
public abstract class AbstractIterator<T> extends wr2<T> {
    private State a = State.NOT_READY;
    @NullableDecl
    private T b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[State.values().length];
            a = iArr;
            iArr[State.DONE.ordinal()] = 1;
            a[State.READY.ordinal()] = 2;
        }
    }

    protected AbstractIterator() {
    }

    private boolean c() {
        this.a = State.FAILED;
        this.b = a();
        if (this.a == State.DONE) {
            return false;
        }
        this.a = State.READY;
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract T a();

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public final T b() {
        this.a = State.DONE;
        return null;
    }

    @CanIgnoreReturnValue
    public final boolean hasNext() {
        ds1.w(this.a != State.FAILED);
        int i = a.a[this.a.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (hasNext()) {
            this.a = State.NOT_READY;
            T t = this.b;
            this.b = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
