package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.math.c;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.rk1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Lists {

    /* compiled from: Taobao */
    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        @NullableDecl
        final E first;
        final E[] rest;

        OnePlusArrayList(@NullableDecl E e, E[] eArr) {
            this.first = e;
            this.rest = (E[]) ((Object[]) ds1.p(eArr));
        }

        @Override // java.util.List, java.util.AbstractList
        public E get(int i) {
            ds1.n(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }

        public int size() {
            return c.f(this.rest.length, 1);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        StringAsImmutableList(String str) {
            this.string = str;
        }

        @Override // com.google.common.collect.ImmutableList
        public int indexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList
        public int lastIndexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public int size() {
            return this.string.length();
        }

        @Override // java.util.List
        public Character get(int i) {
            ds1.n(i, size());
            return Character.valueOf(this.string.charAt(i));
        }

        @Override // java.util.List, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableList
        public ImmutableList<Character> subList(int i, int i2) {
            ds1.v(i, i2, size());
            return Lists.b(this.string.substring(i, i2));
        }
    }

    /* compiled from: Taobao */
    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        /* compiled from: Taobao */
        class a extends k0<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.j0
            public T a(F f) {
                return (T) TransformingRandomAccessList.this.function.apply(f);
            }
        }

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) ds1.p(list);
            this.function = (Function) ds1.p(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.List, java.util.AbstractList
        public T get(int i) {
            return (T) this.function.apply(this.fromList.get(i));
        }

        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.List, java.util.AbstractList
        public ListIterator<T> listIterator(int i) {
            return new a(this.fromList.listIterator(i));
        }

        @Override // java.util.List, java.util.AbstractList
        public T remove(int i) {
            return (T) this.function.apply(this.fromList.remove(i));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    /* compiled from: Taobao */
    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        /* compiled from: Taobao */
        class a extends k0<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.j0
            public T a(F f) {
                return (T) TransformingSequentialList.this.function.apply(f);
            }
        }

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) ds1.p(list);
            this.function = (Function) ds1.p(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.List, java.util.AbstractList, java.util.AbstractSequentialList
        public ListIterator<T> listIterator(int i) {
            return new a(this.fromList.listIterator(i));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    /* compiled from: Taobao */
    private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        @NullableDecl
        final E first;
        final E[] rest;
        @NullableDecl
        final E second;

        TwoPlusArrayList(@NullableDecl E e, @NullableDecl E e2, E[] eArr) {
            this.first = e;
            this.second = e2;
            this.rest = (E[]) ((Object[]) ds1.p(eArr));
        }

        @Override // java.util.List, java.util.AbstractList
        public E get(int i) {
            if (i == 0) {
                return this.first;
            }
            if (i == 1) {
                return this.second;
            }
            ds1.n(i, size());
            return this.rest[i - 2];
        }

        public int size() {
            return c.f(this.rest.length, 2);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a<T> extends AbstractList<List<T>> {
        final List<T> a;
        final int b;

        a(List<T> list, int i) {
            this.a = list;
            this.b = i;
        }

        /* renamed from: a */
        public List<T> get(int i) {
            ds1.n(i, size());
            int i2 = this.b;
            int i3 = i * i2;
            return this.a.subList(i3, Math.min(i2 + i3, this.a.size()));
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        public int size() {
            return c.b(this.a.size(), this.b, RoundingMode.CEILING);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b<T> extends a<T> implements RandomAccess {
        b(List<T> list, int i) {
            super(list, i);
        }
    }

    public static <E> List<E> a(@NullableDecl E e, E[] eArr) {
        return new OnePlusArrayList(e, eArr);
    }

    public static ImmutableList<Character> b(String str) {
        return new StringAsImmutableList((String) ds1.p(str));
    }

    @VisibleForTesting
    static int c(int i) {
        k.b(i, "arraySize");
        return Ints.j(((long) i) + 5 + ((long) (i / 10)));
    }

    static boolean d(List<?> list, @NullableDecl Object obj) {
        if (obj == ds1.p(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.g(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!rk1.a(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static int e(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return f(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (rk1.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int f(List<?> list, @NullableDecl Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    static int g(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return h(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (rk1.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int h(List<?> list, @NullableDecl Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> i() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> j(Iterable<? extends E> iterable) {
        ds1.p(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(l.a(iterable));
        }
        return k(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> k(Iterator<? extends E> it) {
        ArrayList<E> i = i();
        Iterators.a(i, it);
        return i;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> l(int i) {
        k.b(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> m(int i) {
        return new ArrayList<>(c(i));
    }

    public static <T> List<List<T>> n(List<T> list, int i) {
        ds1.p(list);
        ds1.d(i > 0);
        return list instanceof RandomAccess ? new b(list, i) : new a(list, i);
    }

    public static <F, T> List<T> o(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }
}
