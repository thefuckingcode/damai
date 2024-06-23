package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.rk1;
import tb.wr2;
import tb.yr2;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Iterators {

    /* compiled from: Taobao */
    private enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            k.e(false);
        }
    }

    /* compiled from: Taobao */
    static class a extends wr2<T> {
        final /* synthetic */ Iterator a;

        a(Iterator it) {
            this.a = it;
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.a.next();
        }
    }

    /* compiled from: Taobao */
    static class b extends AbstractIterator<T> {
        final /* synthetic */ Iterator c;
        final /* synthetic */ Predicate d;

        b(Iterator it, Predicate predicate) {
            this.c = it;
            this.d = predicate;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public T a() {
            while (this.c.hasNext()) {
                T t = (T) this.c.next();
                if (this.d.apply(t)) {
                    return t;
                }
            }
            return (T) b();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c extends j0<F, T> {
        final /* synthetic */ Function b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Iterator it, Function function) {
            super(it);
            this.b = function;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.j0
        public T a(F f) {
            return (T) this.b.apply(f);
        }
    }

    /* compiled from: Taobao */
    static class d extends wr2<T> {
        boolean a;
        final /* synthetic */ Object b;

        d(Object obj) {
            this.b = obj;
        }

        public boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.a) {
                this.a = true;
                return (T) this.b;
            }
            throw new NoSuchElementException();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class e<T> extends a<T> {
        static final yr2<Object> e = new e(new Object[0], 0, 0, 0);
        private final T[] c;
        private final int d;

        e(T[] tArr, int i, int i2, int i3) {
            super(i2, i3);
            this.c = tArr;
            this.d = i;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.a
        public T a(int i) {
            return this.c[this.d + i];
        }
    }

    /* compiled from: Taobao */
    private static class f<T> implements Iterator<T> {
        @NullableDecl
        private Iterator<? extends T> a;
        private Iterator<? extends T> b = Iterators.h();
        private Iterator<? extends Iterator<? extends T>> c;
        @NullableDecl
        private Deque<Iterator<? extends Iterator<? extends T>>> d;

        f(Iterator<? extends Iterator<? extends T>> it) {
            this.c = (Iterator) ds1.p(it);
        }

        @NullableDecl
        private Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.c;
                if (it != null && it.hasNext()) {
                    return this.c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.c = this.d.removeFirst();
            }
        }

        public boolean hasNext() {
            while (!((Iterator) ds1.p(this.b)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> a2 = a();
                this.c = a2;
                if (a2 == null) {
                    return false;
                }
                Iterator<? extends T> it = (Iterator) a2.next();
                this.b = it;
                if (it instanceof f) {
                    f fVar = (f) it;
                    this.b = fVar.b;
                    if (this.d == null) {
                        this.d = new ArrayDeque();
                    }
                    this.d.addFirst(this.c);
                    if (fVar.d != null) {
                        while (!fVar.d.isEmpty()) {
                            this.d.addFirst(fVar.d.removeLast());
                        }
                    }
                    this.c = fVar.c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.b;
                this.a = it;
                return (T) it.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            k.e(this.a != null);
            this.a.remove();
            this.a = null;
        }
    }

    /* compiled from: Taobao */
    private static class g<T> extends wr2<T> {
        final Queue<PeekingIterator<T>> a;

        /* compiled from: Taobao */
        class a implements Comparator<PeekingIterator<T>> {
            final /* synthetic */ Comparator a;

            a(g gVar, Comparator comparator) {
                this.a = comparator;
            }

            /* renamed from: a */
            public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
                return this.a.compare(peekingIterator.peek(), peekingIterator2.peek());
            }
        }

        public g(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.a = new PriorityQueue(2, new a(this, comparator));
            Iterator<? extends Iterator<? extends T>> it = iterable.iterator();
            while (it.hasNext()) {
                Iterator it2 = (Iterator) it.next();
                if (it2.hasNext()) {
                    this.a.add(Iterators.p(it2));
                }
            }
        }

        public boolean hasNext() {
            return !this.a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            PeekingIterator<T> remove = this.a.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.a.add(remove);
            }
            return next;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class h<E> implements PeekingIterator<E> {
        private final Iterator<? extends E> a;
        private boolean b;
        @NullableDecl
        private E c;

        public h(Iterator<? extends E> it) {
            this.a = (Iterator) ds1.p(it);
        }

        public boolean hasNext() {
            return this.b || this.a.hasNext();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public E next() {
            if (!this.b) {
                return (E) this.a.next();
            }
            E e = this.c;
            this.b = false;
            this.c = null;
            return e;
        }

        @Override // com.google.common.collect.PeekingIterator
        public E peek() {
            if (!this.b) {
                this.c = (E) this.a.next();
                this.b = true;
            }
            return this.c;
        }

        @Override // com.google.common.collect.PeekingIterator
        public void remove() {
            ds1.x(!this.b, "Can't remove after you've peeked at next");
            this.a.remove();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        ds1.p(collection);
        ds1.p(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static int b(Iterator<?> it, int i) {
        ds1.p(it);
        int i2 = 0;
        ds1.e(i >= 0, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    static void d(Iterator<?> it) {
        ds1.p(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> it) {
        return new f(it);
    }

    public static boolean f(Iterator<?> it, @NullableDecl Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    public static boolean g(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !rk1.a(it.next(), it2.next())) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return !it2.hasNext();
    }

    static <T> wr2<T> h() {
        return i();
    }

    static <T> yr2<T> i() {
        return (yr2<T>) e.e;
    }

    static <T> Iterator<T> j() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> wr2<T> k(Iterator<T> it, Predicate<? super T> predicate) {
        ds1.p(it);
        ds1.p(predicate);
        return new b(it, predicate);
    }

    public static <T> T l(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @NullableDecl
    public static <T> T m(Iterator<? extends T> it, @NullableDecl T t) {
        return it.hasNext() ? (T) it.next() : t;
    }

    public static <T> T n(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append((Object) next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append((Object) it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    @Beta
    public static <T> wr2<T> o(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        ds1.q(iterable, "iterators");
        ds1.q(comparator, "comparator");
        return new g(iterable, comparator);
    }

    public static <T> PeekingIterator<T> p(Iterator<? extends T> it) {
        if (it instanceof h) {
            return (h) it;
        }
        return new h(it);
    }

    @NullableDecl
    static <T> T q(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    @CanIgnoreReturnValue
    public static boolean r(Iterator<?> it, Collection<?> collection) {
        ds1.p(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean s(Iterator<?> it, Collection<?> collection) {
        ds1.p(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> wr2<T> t(@NullableDecl T t) {
        return new d(t);
    }

    public static int u(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return Ints.j(j);
    }

    public static String v(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.ARRAY_START);
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            z = false;
            sb.append(it.next());
        }
        sb.append(jl1.ARRAY_END);
        return sb.toString();
    }

    public static <F, T> Iterator<T> w(Iterator<F> it, Function<? super F, ? extends T> function) {
        ds1.p(function);
        return new c(it, function);
    }

    public static <T> wr2<T> x(Iterator<? extends T> it) {
        ds1.p(it);
        if (it instanceof wr2) {
            return (wr2) it;
        }
        return new a(it);
    }
}
