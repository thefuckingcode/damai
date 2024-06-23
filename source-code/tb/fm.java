package tb;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.channels.a;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class fm<E> extends AbstractChannel<E> {
    @NotNull
    private final ReentrantLock d = new ReentrantLock();
    @Nullable
    private Object e = i1.EMPTY;

    public fm(@Nullable Function1<? super E, ur2> function1) {
        super(function1);
    }

    private final UndeliveredElementException Y(Object obj) {
        Function1<E, ur2> function1;
        Object obj2 = this.e;
        UndeliveredElementException undeliveredElementException = null;
        if (!(obj2 == i1.EMPTY || (function1 = this.a) == null)) {
            undeliveredElementException = OnUndeliveredElementKt.d(function1, obj2, null, 2, null);
        }
        this.e = obj;
        return undeliveredElementException;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean I(@NotNull jx1<? super E> jx1) {
        ReentrantLock reentrantLock = this.d;
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
        return this.e == i1.EMPTY;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void O(boolean z) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            UndeliveredElementException Y = Y(i1.EMPTY);
            ur2 ur2 = ur2.INSTANCE;
            reentrantLock.unlock();
            super.O(z);
            if (Y != null) {
                throw Y;
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
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            Object obj = this.e;
            jh2 jh2 = i1.EMPTY;
            if (obj == jh2) {
                Object j = j();
                if (j == null) {
                    j = i1.POLL_FAILED;
                }
                return j;
            }
            this.e = jh2;
            ur2 ur2 = ur2.INSTANCE;
            reentrantLock.unlock();
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    public Object T(@NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            Object obj = this.e;
            jh2 jh2 = i1.EMPTY;
            if (obj == jh2) {
                Object j = j();
                if (j == null) {
                    j = i1.POLL_FAILED;
                }
                return j;
            } else if (!selectInstance.trySelect()) {
                Object d2 = e82.d();
                reentrantLock.unlock();
                return d2;
            } else {
                Object obj2 = this.e;
                this.e = jh2;
                ur2 ur2 = ur2.INSTANCE;
                reentrantLock.unlock();
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @NotNull
    public String h() {
        return "(value=" + this.e + ')';
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.AbstractChannel
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.d;
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
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @NotNull
    public Object u(E e2) {
        ReceiveOrClosed<E> A;
        jh2 tryResumeReceive;
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            fj<?> j = j();
            if (j == null) {
                if (this.e == i1.EMPTY) {
                    do {
                        A = A();
                        if (A != null) {
                            if (A instanceof fj) {
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
                    ur2 ur2 = ur2.INSTANCE;
                    reentrantLock.unlock();
                    A.completeResumeReceive(e2);
                    return A.getOfferResult();
                }
                UndeliveredElementException Y = Y(e2);
                if (Y == null) {
                    jh2 jh2 = i1.OFFER_SUCCESS;
                    reentrantLock.unlock();
                    return jh2;
                }
                throw Y;
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
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            fj<?> j = j();
            if (j == null) {
                if (this.e == i1.EMPTY) {
                    do {
                        a.d<E> f = f(e2);
                        performAtomicTrySelect = selectInstance.performAtomicTrySelect(f);
                        if (performAtomicTrySelect == null) {
                            Object o = f.o();
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
                        return performAtomicTrySelect;
                    }
                    throw new IllegalStateException(k21.r("performAtomicTrySelect(describeTryOffer) returned ", performAtomicTrySelect).toString());
                }
                if (!selectInstance.trySelect()) {
                    Object d2 = e82.d();
                    reentrantLock.unlock();
                    return d2;
                }
                UndeliveredElementException Y = Y(e2);
                if (Y == null) {
                    jh2 jh2 = i1.OFFER_SUCCESS;
                    reentrantLock.unlock();
                    return jh2;
                }
                throw Y;
            }
            reentrantLock.unlock();
            return j;
        } finally {
            reentrantLock.unlock();
        }
    }
}
