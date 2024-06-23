package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.internal.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c90;
import tb.hl;
import tb.kl;

/* compiled from: Taobao */
public final class i<T> extends d<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(i.class, "_decision");
    @NotNull
    private volatile /* synthetic */ int _decision = 0;

    public i(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    private final boolean b() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!a.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean c() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!a.compareAndSet(this, 0, 1));
        return true;
    }

    @Nullable
    public final Object a() {
        if (c()) {
            return b.d();
        }
        Object h = q.h(getState$kotlinx_coroutines_core());
        if (!(h instanceof hl)) {
            return h;
        }
        throw ((hl) h).a;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.d, kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object obj) {
        afterResume(obj);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.d, kotlinx.coroutines.a
    public void afterResume(@Nullable Object obj) {
        if (!b()) {
            c90.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.uCont), kl.a(obj, this.uCont), null, 2, null);
        }
    }
}
