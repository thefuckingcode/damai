package kotlinx.coroutines.debug.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ou0;
import tb.ww1;
import tb.x1;

/* compiled from: Taobao */
public final class ConcurrentWeakMap<K, V> extends x1<K, V> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    @NotNull
    private volatile /* synthetic */ int _size;
    @Nullable
    private final ReferenceQueue<K> a;
    @NotNull
    volatile /* synthetic */ Object core;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class a {
        private static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");
        private final int a;
        private final int b;
        private final int c;
        @NotNull
        /* synthetic */ AtomicReferenceArray d;
        @NotNull
        /* synthetic */ AtomicReferenceArray e;
        @NotNull
        private volatile /* synthetic */ int load = 0;

        /* access modifiers changed from: private */
        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public final class C0289a<E> implements Iterator<E>, KMutableIterator {
            @NotNull
            private final Function2<K, V, E> a;
            private int b = -1;
            private K c;
            private V d;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super K, ? super V, ? extends E> */
            /* JADX WARN: Multi-variable type inference failed */
            public C0289a(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
                this.a = function2;
                a();
            }

            private final void a() {
                while (true) {
                    int i = this.b + 1;
                    this.b = i;
                    if (i < ((a) a.this).a) {
                        ou0 ou0 = (ou0) a.this.d.get(this.b);
                        K k = ou0 == null ? null : (K) ou0.get();
                        if (k != null) {
                            this.c = k;
                            V v = (V) a.this.e.get(this.b);
                            if (v instanceof d) {
                                v = (V) v.a;
                            }
                            if (v != null) {
                                this.d = v;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            @NotNull
            /* renamed from: b */
            public Void remove() {
                Void unused = a.e();
                throw new KotlinNothingValueException();
            }

            public boolean hasNext() {
                return this.b < ((a) a.this).a;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.b < ((a) a.this).a) {
                    Function2<K, V, E> function2 = this.a;
                    K k = this.c;
                    if (k != null) {
                        V v = this.d;
                        if (v != null) {
                            E invoke = function2.invoke(k, v);
                            a();
                            return invoke;
                        }
                        k21.A("value");
                        throw null;
                    }
                    k21.A("key");
                    throw null;
                }
                throw new NoSuchElementException();
            }
        }

        public a(int i) {
            this.a = i;
            this.b = Integer.numberOfLeadingZeros(i) + 1;
            this.c = (i * 2) / 3;
            this.d = new AtomicReferenceArray(i);
            this.e = new AtomicReferenceArray(i);
        }

        private final int d(int i) {
            return (i * -1640531527) >>> this.b;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object g(a aVar, Object obj, Object obj2, ou0 ou0, int i, Object obj3) {
            if ((i & 4) != 0) {
                ou0 = null;
            }
            return aVar.f(obj, obj2, ou0);
        }

        private final void i(int i) {
            Object obj;
            do {
                obj = this.e.get(i);
                if (obj == null || (obj instanceof d)) {
                    return;
                }
            } while (!this.e.compareAndSet(i, obj, null));
            ConcurrentWeakMap.this.h();
        }

        public final void b(@NotNull ou0<?> ou0) {
            int d2 = d(ou0.a);
            while (true) {
                ou0<?> ou02 = (ou0) this.d.get(d2);
                if (ou02 != null) {
                    if (ou02 == ou0) {
                        i(d2);
                        return;
                    }
                    if (d2 == 0) {
                        d2 = this.a;
                    }
                    d2--;
                } else {
                    return;
                }
            }
        }

        @Nullable
        public final V c(@NotNull K k) {
            int d2 = d(k.hashCode());
            while (true) {
                ou0 ou0 = (ou0) this.d.get(d2);
                if (ou0 == null) {
                    return null;
                }
                Object obj = ou0.get();
                if (k21.d(k, obj)) {
                    V v = (V) this.e.get(d2);
                    return v instanceof d ? (V) v.a : v;
                }
                if (obj == null) {
                    i(d2);
                }
                if (d2 == 0) {
                    d2 = this.a;
                }
                d2--;
            }
        }

        @NotNull
        public final <E> Iterator<E> e(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            return new C0289a(function2);
        }

        @Nullable
        public final Object f(@NotNull K k, @Nullable V v, @Nullable ou0<K> ou0) {
            Object obj;
            int i;
            int d2 = d(k.hashCode());
            boolean z = false;
            while (true) {
                ou0 ou02 = (ou0) this.d.get(d2);
                if (ou02 != null) {
                    Object obj2 = ou02.get();
                    if (!k21.d(k, obj2)) {
                        if (obj2 == null) {
                            i(d2);
                        }
                        if (d2 == 0) {
                            d2 = this.a;
                        }
                        d2--;
                    } else if (z) {
                        g.decrementAndGet(this);
                    }
                } else if (v == null) {
                    return null;
                } else {
                    if (!z) {
                        do {
                            i = this.load;
                            if (i >= this.c) {
                                return a.a;
                            }
                        } while (!g.compareAndSet(this, i, i + 1));
                        z = true;
                    }
                    if (ou0 == null) {
                        ou0 = new ou0<>(k, ((ConcurrentWeakMap) ConcurrentWeakMap.this).a);
                    }
                    if (this.d.compareAndSet(d2, null, ou0)) {
                        break;
                    }
                }
            }
            do {
                obj = this.e.get(d2);
                if (obj instanceof d) {
                    return a.a;
                }
            } while (!this.e.compareAndSet(d2, obj, v));
            return obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V>$a */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ConcurrentWeakMap<K, V>.a h() {
            ConcurrentWeakMap<K, V>.a aVar;
            Object obj;
            Object obj2;
            loop0:
            while (true) {
                aVar = new a(Integer.highestOneBit(ww1.a(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i = 0;
                int i2 = this.a;
                if (i2 <= 0) {
                    break;
                }
                while (true) {
                    int i3 = i + 1;
                    ou0 ou0 = (ou0) this.d.get(i);
                    if (ou0 == null) {
                        obj = null;
                    } else {
                        obj = ou0.get();
                    }
                    if (ou0 != null && obj == null) {
                        i(i);
                    }
                    while (true) {
                        obj2 = this.e.get(i);
                        if (!(obj2 instanceof d)) {
                            if (this.e.compareAndSet(i, obj2, a.d(obj2))) {
                                break;
                            }
                        } else {
                            obj2 = ((d) obj2).a;
                            break;
                        }
                    }
                    if (obj == null || obj2 == null || aVar.f(obj, obj2, ou0) != a.a) {
                        if (i3 >= i2) {
                            break loop0;
                        }
                        i = i3;
                    }
                }
            }
            return aVar;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final K a;
        private final V b;

        public b(K k, V v) {
            this.a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            Void unused = a.e();
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: Taobao */
    private final class c<E> extends kotlin.collections.c<E> {
        @NotNull
        private final Function2<K, V, E> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super K, ? super V, ? extends E> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            this.a = function2;
        }

        @Override // kotlin.collections.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            Void unused = a.e();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.c
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        @NotNull
        public Iterator<E> iterator() {
            return ((a) ConcurrentWeakMap.this.core).e(this.a);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, m40 m40) {
        this((i & 1) != 0 ? false : z);
    }

    private final void g(ou0<?> ou0) {
        ((a) this.core).b(ou0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void h() {
        b.decrementAndGet(this);
    }

    private final synchronized V i(K k, V v) {
        V v2;
        ConcurrentWeakMap<K, V>.a aVar = (a) this.core;
        while (true) {
            v2 = (V) a.g(aVar, k, v, null, 4, null);
            if (v2 == a.a) {
                aVar = aVar.h();
                this.core = aVar;
            }
        }
        return v2;
    }

    @Override // tb.x1
    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return new c(ConcurrentWeakMap$entries$1.INSTANCE);
    }

    @Override // tb.x1
    @NotNull
    public Set<K> b() {
        return new c(ConcurrentWeakMap$keys$1.INSTANCE);
    }

    @Override // tb.x1
    public int c() {
        return this._size;
    }

    public void clear() {
        for (K k : keySet()) {
            remove(k);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((a) this.core).c(obj);
    }

    public final void j() {
        if (this.a != null) {
            while (true) {
                try {
                    Reference<? extends K> remove = this.a.remove();
                    if (remove != null) {
                        g((ou0) remove);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K k, @NotNull V v) {
        V v2 = (V) a.g((a) this.core, k, v, null, 4, null);
        if (v2 == a.a) {
            v2 = i(k, v);
        }
        if (v2 == null) {
            b.incrementAndGet(this);
        }
        return v2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@Nullable Object obj) {
        if (obj == 0) {
            return null;
        }
        V v = (V) a.g((a) this.core, obj, null, null, 4, null);
        if (v == a.a) {
            v = i(obj, null);
        }
        if (v != null) {
            b.decrementAndGet(this);
        }
        return v;
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new a(16);
        this.a = z ? new ReferenceQueue<>() : null;
    }
}
