package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Taobao */
final class a<E> implements Iterable<E> {
    private static final a<Object> d = new a<>();
    final E a;
    final a<E> b;
    private final int c;

    /* access modifiers changed from: private */
    /* renamed from: kotlin.reflect.jvm.internal.pcollections.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0287a<E> implements Iterator<E> {
        private a<E> a;

        public C0287a(a<E> aVar) {
            this.a = aVar;
        }

        public boolean hasNext() {
            return ((a) this.a).c > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> aVar = this.a;
            E e = aVar.a;
            this.a = aVar.b;
            return e;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private a() {
        this.c = 0;
        this.a = null;
        this.b = null;
    }

    public static <E> a<E> b() {
        return (a<E>) d;
    }

    private Iterator<E> c(int i) {
        return new C0287a(g(i));
    }

    private a<E> e(Object obj) {
        if (this.c == 0) {
            return this;
        }
        if (this.a.equals(obj)) {
            return this.b;
        }
        a<E> e = this.b.e(obj);
        if (e == this.b) {
            return this;
        }
        return new a<>(this.a, e);
    }

    private a<E> g(int i) {
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException();
        } else if (i == 0) {
            return this;
        } else {
            return this.b.g(i - 1);
        }
    }

    public a<E> d(int i) {
        return e(get(i));
    }

    public a<E> f(E e) {
        return new a<>(e, this);
    }

    public E get(int i) {
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return c(i).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return c(0);
    }

    public int size() {
        return this.c;
    }

    private a(E e, a<E> aVar) {
        this.a = e;
        this.b = aVar;
        this.c = aVar.c + 1;
    }
}
