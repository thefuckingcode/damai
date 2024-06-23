package tb;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class t81<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    @NotNull
    public static final a Companion = new a(null);
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    @JvmField
    @NotNull
    public static final jh2 REMOVE_FROZEN = new jh2("REMOVE_FROZEN");
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    private static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(t81.class, Object.class, "_next");
    private static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(t81.class, "_state");
    @NotNull
    private volatile /* synthetic */ Object _next = null;
    @NotNull
    private volatile /* synthetic */ long _state = 0;
    private final int a;
    private final boolean b;
    private final int c;
    @NotNull
    private /* synthetic */ AtomicReferenceArray d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i) {
            return d(j, t81.HEAD_MASK) | (((long) i) << 0);
        }

        public final long c(long j, int i) {
            return d(j, t81.TAIL_MASK) | (((long) i) << 30);
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        @JvmField
        public final int a;

        public b(int i) {
            this.a = i;
        }
    }

    public t81(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        boolean z2 = false;
        if (i2 <= 1073741823) {
            if (!((i & i2) == 0 ? true : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.concurrent.atomic.AtomicReferenceArray */
    /* JADX WARN: Multi-variable type inference failed */
    private final t81<E> b(long j) {
        t81<E> t81 = new t81<>(this.a * 2, this.b);
        int i = (int) ((HEAD_MASK & j) >> 0);
        int i2 = (int) ((TAIL_MASK & j) >> 30);
        while (true) {
            int i3 = this.c;
            if ((i & i3) != (i2 & i3)) {
                Object obj = this.d.get(i3 & i);
                if (obj == null) {
                    obj = new b(i);
                }
                t81.d.set(t81.c & i, obj);
                i++;
            } else {
                t81._state = Companion.d(j, 1152921504606846976L);
                return t81;
            }
        }
    }

    private final t81<E> c(long j) {
        while (true) {
            t81<E> t81 = (t81) this._next;
            if (t81 != null) {
                return t81;
            }
            e.compareAndSet(this, null, b(j));
        }
    }

    private final t81<E> e(int i, E e2) {
        Object obj = this.d.get(this.c & i);
        if (!(obj instanceof b) || ((b) obj).a != i) {
            return null;
        }
        this.d.set(i & this.c, e2);
        return this;
    }

    private final long h() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f.compareAndSet(this, j, j2));
        return j2;
    }

    private final t81<E> k(int i, int i2) {
        long j;
        a aVar;
        int i3;
        do {
            j = this._state;
            aVar = Companion;
            boolean z = false;
            i3 = (int) ((HEAD_MASK & j) >> 0);
            if (n30.a()) {
                if (i3 == i) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return i();
            }
        } while (!f.compareAndSet(this, j, aVar.b(j, i2)));
        this.d.set(this.c & i3, null);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    public final int a(@NotNull E e2) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return Companion.a(j);
            }
            a aVar = Companion;
            int i = (int) ((HEAD_MASK & j) >> 0);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.b && this.d.get(i2 & i3) != null) {
                int i4 = this.a;
                if (i4 < 1024 || ((i2 - i) & MAX_CAPACITY_MASK) > (i4 >> 1)) {
                    return 1;
                }
            } else if (f.compareAndSet(this, j, aVar.c(j, (i2 + 1) & MAX_CAPACITY_MASK))) {
                this.d.set(i2 & i3, e2);
                t81<E> t81 = this;
                while ((t81._state & 1152921504606846976L) != 0 && (t81 = t81.i().e(i2, e2)) != null) {
                    while ((t81._state & 1152921504606846976L) != 0) {
                        while ((t81._state & 1152921504606846976L) != 0) {
                        }
                    }
                }
                return 0;
            }
        }
        return 1;
    }

    public final boolean d() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j = this._state;
        return 1073741823 & (((int) ((j & TAIL_MASK) >> 30)) - ((int) ((HEAD_MASK & j) >> 0)));
    }

    public final boolean g() {
        long j = this._state;
        return ((int) ((HEAD_MASK & j) >> 0)) == ((int) ((j & TAIL_MASK) >> 30));
    }

    @NotNull
    public final t81<E> i() {
        return c(h());
    }

    @Nullable
    public final Object j() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return REMOVE_FROZEN;
            }
            a aVar = Companion;
            int i = (int) ((HEAD_MASK & j) >> 0);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            int i3 = this.c;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.d.get(i3 & i);
            if (obj == null) {
                if (this.b) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i4 = (i + 1) & MAX_CAPACITY_MASK;
                if (f.compareAndSet(this, j, aVar.b(j, i4))) {
                    this.d.set(this.c & i, null);
                    return obj;
                } else if (this.b) {
                    t81<E> t81 = this;
                    do {
                        t81 = t81.k(i, i4);
                    } while (t81 != null);
                    return obj;
                }
            }
        }
    }
}
