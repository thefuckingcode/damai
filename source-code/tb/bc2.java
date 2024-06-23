package tb;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.e0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class bc2<T> extends AbstractSet<T> {
    @NotNull
    public static final b Companion = new b(null);
    @Nullable
    private Object a;
    private int b;

    /* compiled from: Taobao */
    private static final class a<T> implements Iterator<T>, KMutableIterator {
        @NotNull
        private final Iterator<T> a;

        public a(@NotNull T[] tArr) {
            k21.i(tArr, "array");
            this.a = p7.a(tArr);
        }

        @NotNull
        /* renamed from: a */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.a.next();
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        @JvmStatic
        @NotNull
        public final <T> bc2<T> a() {
            return new bc2<>(null);
        }

        @JvmStatic
        @NotNull
        public final <T> bc2<T> b(@NotNull Collection<? extends T> collection) {
            k21.i(collection, "set");
            bc2<T> bc2 = new bc2<>(null);
            bc2.addAll(collection);
            return bc2;
        }
    }

    /* compiled from: Taobao */
    private static final class c<T> implements Iterator<T>, KMutableIterator {
        private final T a;
        private boolean b = true;

        public c(T t) {
            this.a = t;
        }

        @NotNull
        /* renamed from: a */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b) {
                this.b = false;
                return this.a;
            }
            throw new NoSuchElementException();
        }
    }

    private bc2() {
    }

    public /* synthetic */ bc2(m40 m40) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final <T> bc2<T> a() {
        return Companion.a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.util.LinkedHashSet */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        Object[] objArr;
        if (size() == 0) {
            this.a = t;
        } else if (size() == 1) {
            if (k21.d(this.a, t)) {
                return false;
            }
            this.a = new Object[]{this.a, t};
        } else if (size() < 5) {
            Object obj = this.a;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            if (ArraysKt___ArraysKt.r(objArr2, t)) {
                return false;
            }
            if (size() == 4) {
                Object[] objArr3 = new Object[objArr2.length];
                System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
                LinkedHashSet linkedHashSet = e0.e(objArr3);
                linkedHashSet.add(t);
                ur2 ur2 = ur2.INSTANCE;
                objArr = linkedHashSet;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                k21.h(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                copyOf[copyOf.length - 1] = t;
                ur2 ur22 = ur2.INSTANCE;
                objArr = copyOf;
            }
            this.a = objArr;
        } else {
            Object obj2 = this.a;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!po2.d(obj2).add(t)) {
                return false;
            }
        }
        c(size() + 1);
        return true;
    }

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public void clear() {
        this.a = null;
        c(0);
    }

    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return k21.d(this.a, obj);
        }
        if (size() < 5) {
            Object obj2 = this.a;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return ArraysKt___ArraysKt.r((Object[]) obj2, obj);
        }
        Object obj3 = this.a;
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.a);
        }
        if (size() < 5) {
            Object obj = this.a;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.a;
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return po2.d(obj2).iterator();
    }

    public final /* bridge */ int size() {
        return b();
    }
}
