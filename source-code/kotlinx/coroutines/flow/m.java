package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g2;
import tb.h2;
import tb.k21;
import tb.n30;
import tb.p30;
import tb.qc;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class m extends h2<StateFlowImpl<?>> {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_state");
    @NotNull
    volatile /* synthetic */ Object _state = null;

    /* renamed from: c */
    public boolean a(@NotNull StateFlowImpl<?> stateFlowImpl) {
        if (this._state != null) {
            return false;
        }
        this._state = l.a;
        return true;
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super ur2> continuation) {
        boolean z = true;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (!n30.a() || qc.a(!(this._state instanceof CancellableContinuationImpl)).booleanValue()) {
            if (!a.compareAndSet(this, l.a, cancellableContinuationImpl)) {
                if (n30.a()) {
                    if (this._state != l.b) {
                        z = false;
                    }
                    if (!qc.a(z).booleanValue()) {
                        throw new AssertionError();
                    }
                }
                ur2 ur2 = ur2.INSTANCE;
                Result.a aVar = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m913constructorimpl(ur2));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == b.d()) {
                p30.c(continuation);
            }
            return result == b.d() ? result : ur2.INSTANCE;
        }
        throw new AssertionError();
    }

    @NotNull
    /* renamed from: e */
    public Continuation<Unit>[] b(@NotNull StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return g2.EMPTY_RESUMES;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj != null && obj != l.b) {
                if (obj == l.a) {
                    if (a.compareAndSet(this, obj, l.b)) {
                        return;
                    }
                } else if (a.compareAndSet(this, obj, l.a)) {
                    ur2 ur2 = ur2.INSTANCE;
                    Result.a aVar = Result.Companion;
                    ((CancellableContinuationImpl) obj).resumeWith(Result.m913constructorimpl(ur2));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = a.getAndSet(this, l.a);
        k21.f(andSet);
        if (n30.a() && !(!(andSet instanceof CancellableContinuationImpl))) {
            throw new AssertionError();
        } else if (andSet == l.b) {
            return true;
        } else {
            return false;
        }
    }
}
