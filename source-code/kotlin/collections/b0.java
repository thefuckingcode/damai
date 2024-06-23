package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.s1;
import tb.ww1;

/* compiled from: Taobao */
final class b0<T> extends s1<T> implements RandomAccess {
    @NotNull
    private final Object[] a;
    private final int b;
    private int c;
    private int d;

    /* compiled from: Taobao */
    public static final class a extends a<T> {
        private int c;
        private int d;
        final /* synthetic */ b0<T> e;

        a(b0<T> b0Var) {
            this.e = b0Var;
            this.c = b0Var.size();
            this.d = ((b0) b0Var).c;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.collections.b0$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: protected */
        @Override // kotlin.collections.a
        public void a() {
            if (this.c == 0) {
                b();
                return;
            }
            c(((b0) this.e).a[this.d]);
            this.d = (this.d + 1) % ((b0) this.e).b;
            this.c--;
        }
    }

    public b0(@NotNull Object[] objArr, int i) {
        k21.i(objArr, "buffer");
        this.a = objArr;
        boolean z = true;
        if (i >= 0) {
            if (i > objArr.length ? false : z) {
                this.b = objArr.length;
                this.d = i;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return this.d;
    }

    public final void e(T t) {
        if (!g()) {
            this.a[(this.c + size()) % this.b] = t;
            this.d = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.collections.b0<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final b0<T> f(int i) {
        Object[] objArr;
        int i2 = this.b;
        int i3 = ww1.d(i2 + (i2 >> 1) + 1, i);
        if (this.c == 0) {
            objArr = Arrays.copyOf(this.a, i3);
            k21.h(objArr, "copyOf(this, newSize)");
        } else {
            objArr = toArray(new Object[i3]);
        }
        return new b0<>(objArr, size());
    }

    public final boolean g() {
        return size() == this.b;
    }

    @Override // tb.s1, java.util.List
    public T get(int i) {
        s1.Companion.a(i, size());
        return (T) this.a[(this.c + i) % this.b];
    }

    public final void h(int i) {
        boolean z = true;
        if (i >= 0) {
            if (i > size()) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
            } else if (i > 0) {
                int i2 = this.c;
                int i3 = (i2 + i) % this.b;
                if (i2 > i3) {
                    h.j(this.a, null, i2, this.b);
                    h.j(this.a, null, 0, i3);
                } else {
                    h.j(this.a, null, i2, i3);
                }
                this.c = i3;
                this.d = size() - i;
            }
        } else {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
    }

    @Override // tb.s1, java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection, kotlin.collections.AbstractCollection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        k21.i(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            k21.h(tArr, "copyOf(this, newSize)");
        }
        int size = size();
        int i = this.c;
        int i2 = 0;
        int i3 = 0;
        while (i3 < size && i < this.b) {
            tArr[i3] = this.a[i];
            i3++;
            i++;
        }
        while (i3 < size) {
            tArr[i3] = this.a[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        k21.g(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.RingBuffer.toArray>");
        return tArr;
    }

    public b0(int i) {
        this(new Object[i], 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.collections.b0<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
