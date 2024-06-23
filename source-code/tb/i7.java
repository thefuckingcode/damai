package tb;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.h;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.channels.a;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class i7<E> extends AbstractChannel<E> {
    private final int d;
    @NotNull
    private final BufferOverflow e;
    @NotNull
    private final ReentrantLock f;
    @NotNull
    private Object[] g;
    private int h;
    @NotNull
    private volatile /* synthetic */ int size;

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public i7(int i, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, ur2> function1) {
        super(function1);
        this.d = i;
        this.e = bufferOverflow;
        if (i < 1 ? false : true) {
            this.f = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i, 8)];
            h.k(objArr, i1.EMPTY, 0, 0, 6, null);
            ur2 ur2 = ur2.INSTANCE;
            this.g = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
    }

    private final void Y(int i, E e2) {
        if (i < this.d) {
            Z(i);
            Object[] objArr = this.g;
            objArr[(this.h + i) % objArr.length] = e2;
            return;
        }
        if (n30.a()) {
            if (!(this.e == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.g;
        int i2 = this.h;
        objArr2[i2 % objArr2.length] = null;
        objArr2[(i + i2) % objArr2.length] = e2;
        this.h = (i2 + 1) % objArr2.length;
    }

    private final void Z(int i) {
        Object[] objArr = this.g;
        if (i >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.d);
            Object[] objArr2 = new Object[min];
            if (i > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    Object[] objArr3 = this.g;
                    objArr2[i2] = objArr3[(this.h + i2) % objArr3.length];
                    if (i3 >= i) {
                        break;
                    }
                    i2 = i3;
                }
            }
            h.j(objArr2, i1.EMPTY, i, min);
            this.g = objArr2;
            this.h = 0;
        }
    }

    private final jh2 a0(int i) {
        if (i < this.d) {
            this.size = i + 1;
            return null;
        }
        int i2 = a.$EnumSwitchMapping$0[this.e.ordinal()];
        if (i2 == 1) {
            return i1.OFFER_FAILED;
        }
        if (i2 == 2) {
            return i1.OFFER_SUCCESS;
        }
        if (i2 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean I(@NotNull jx1<? super E> jx1) {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return super.I(jx1);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean L() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean M() {
        return this.size == 0;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void O(boolean z) {
        Function1<E, ur2> function1 = this.a;
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.g[this.h];
                if (!(function1 == null || obj == i1.EMPTY)) {
                    undeliveredElementException = OnUndeliveredElementKt.c(function1, obj, undeliveredElementException);
                }
                Object[] objArr = this.g;
                int i3 = this.h;
                objArr[i3] = i1.EMPTY;
                this.h = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            ur2 ur2 = ur2.INSTANCE;
            reentrantLock.unlock();
            super.O(z);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    public Object S() {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object j = j();
                if (j == null) {
                    j = i1.POLL_FAILED;
                }
                return j;
            }
            Object[] objArr = this.g;
            int i2 = this.h;
            Object obj = objArr[i2];
            k82 k82 = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object obj2 = i1.POLL_FAILED;
            boolean z = false;
            if (i == this.d) {
                k82 k822 = null;
                while (true) {
                    k82 B = B();
                    if (B == null) {
                        k82 = k822;
                        break;
                    }
                    jh2 x = B.x(null);
                    if (x != null) {
                        if (n30.a()) {
                            if (x == jf.RESUME_TOKEN) {
                                z = true;
                            }
                            if (!z) {
                                throw new AssertionError();
                            }
                        }
                        obj2 = B.v();
                        k82 = B;
                        z = true;
                    } else {
                        B.y();
                        k822 = B;
                    }
                }
            }
            if (obj2 != i1.POLL_FAILED && !(obj2 instanceof fj)) {
                this.size = i;
                Object[] objArr2 = this.g;
                objArr2[(this.h + i) % objArr2.length] = obj2;
            }
            this.h = (this.h + 1) % this.g.length;
            ur2 ur2 = ur2.INSTANCE;
            reentrantLock.unlock();
            if (z) {
                k21.f(k82);
                k82.u();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1  */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    public Object T(@NotNull SelectInstance<?> selectInstance) {
        boolean z;
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object j = j();
                if (j == null) {
                    j = i1.POLL_FAILED;
                }
                return j;
            }
            Object[] objArr = this.g;
            int i2 = this.h;
            Object obj = objArr[i2];
            k82 k82 = null;
            objArr[i2] = null;
            this.size = i - 1;
            jh2 jh2 = i1.POLL_FAILED;
            if (i == this.d) {
                while (true) {
                    AbstractChannel.g<E> G = G();
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(G);
                    if (performAtomicTrySelect == null) {
                        k82 = G.o();
                        k21.f(k82);
                        jh2 = ((k82) k82).v();
                        break;
                    } else if (performAtomicTrySelect == i1.POLL_FAILED) {
                        break;
                    } else if (performAtomicTrySelect != i8.RETRY_ATOMIC) {
                        if (performAtomicTrySelect == e82.d()) {
                            this.size = i;
                            this.g[this.h] = obj;
                            reentrantLock.unlock();
                            return performAtomicTrySelect;
                        } else if (performAtomicTrySelect instanceof fj) {
                            jh2 = performAtomicTrySelect;
                            k82 = jh2;
                        } else {
                            throw new IllegalStateException(k21.r("performAtomicTrySelect(describeTryOffer) returned ", performAtomicTrySelect).toString());
                        }
                    }
                }
                z = true;
                if (jh2 == i1.POLL_FAILED && !(jh2 instanceof fj)) {
                    this.size = i;
                    Object[] objArr2 = this.g;
                    objArr2[(this.h + i) % objArr2.length] = jh2;
                } else if (!selectInstance.trySelect()) {
                    this.size = i;
                    this.g[this.h] = obj;
                    Object d2 = e82.d();
                    reentrantLock.unlock();
                    return d2;
                }
                this.h = (this.h + 1) % this.g.length;
                ur2 ur2 = ur2.INSTANCE;
                reentrantLock.unlock();
                if (z) {
                    k21.f(k82);
                    k82.u();
                }
                return obj;
            }
            z = false;
            if (jh2 == i1.POLL_FAILED) {
            }
            if (!selectInstance.trySelect()) {
            }
            this.h = (this.h + 1) % this.g.length;
            ur2 ur22 = ur2.INSTANCE;
            reentrantLock.unlock();
            if (z) {
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @Nullable
    public Object g(@NotNull k82 k82) {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return super.g(k82);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @NotNull
    public String h() {
        return "(buffer:capacity=" + this.d + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.AbstractChannel
    public boolean isClosedForReceive() {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.AbstractChannel
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return N();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public final boolean r() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public final boolean s() {
        return this.size == this.d && this.e == BufferOverflow.SUSPEND;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @NotNull
    public Object u(E e2) {
        ReceiveOrClosed<E> A;
        jh2 tryResumeReceive;
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            fj<?> j = j();
            if (j == null) {
                jh2 a0 = a0(i);
                if (a0 == null) {
                    if (i == 0) {
                        do {
                            A = A();
                            if (A != null) {
                                if (A instanceof fj) {
                                    this.size = i;
                                    reentrantLock.unlock();
                                    return A;
                                }
                                tryResumeReceive = A.tryResumeReceive(e2, null);
                            }
                        } while (tryResumeReceive == null);
                        if (n30.a()) {
                            if (!(tryResumeReceive == jf.RESUME_TOKEN)) {
                                throw new AssertionError();
                            }
                        }
                        this.size = i;
                        ur2 ur2 = ur2.INSTANCE;
                        reentrantLock.unlock();
                        A.completeResumeReceive(e2);
                        return A.getOfferResult();
                    }
                    Y(i, e2);
                    jh2 jh2 = i1.OFFER_SUCCESS;
                    reentrantLock.unlock();
                    return jh2;
                }
                reentrantLock.unlock();
                return a0;
            }
            reentrantLock.unlock();
            return j;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @NotNull
    public Object v(E e2, @NotNull SelectInstance<?> selectInstance) {
        Object performAtomicTrySelect;
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            fj<?> j = j();
            if (j == null) {
                jh2 a0 = a0(i);
                if (a0 == null) {
                    if (i == 0) {
                        do {
                            a.d<E> f2 = f(e2);
                            performAtomicTrySelect = selectInstance.performAtomicTrySelect(f2);
                            if (performAtomicTrySelect == null) {
                                this.size = i;
                                Object o = f2.o();
                                ur2 ur2 = ur2.INSTANCE;
                                reentrantLock.unlock();
                                k21.f(o);
                                ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) o;
                                receiveOrClosed.completeResumeReceive(e2);
                                return receiveOrClosed.getOfferResult();
                            } else if (performAtomicTrySelect == i1.OFFER_FAILED) {
                            }
                        } while (performAtomicTrySelect == i8.RETRY_ATOMIC);
                        if (performAtomicTrySelect == e82.d() || (performAtomicTrySelect instanceof fj)) {
                            this.size = i;
                            return performAtomicTrySelect;
                        }
                        throw new IllegalStateException(k21.r("performAtomicTrySelect(describeTryOffer) returned ", performAtomicTrySelect).toString());
                    }
                    if (!selectInstance.trySelect()) {
                        this.size = i;
                        Object d2 = e82.d();
                        reentrantLock.unlock();
                        return d2;
                    }
                    Y(i, e2);
                    jh2 jh2 = i1.OFFER_SUCCESS;
                    reentrantLock.unlock();
                    return jh2;
                }
                reentrantLock.unlock();
                return a0;
            }
            reentrantLock.unlock();
            return j;
        } finally {
            reentrantLock.unlock();
        }
    }
}
