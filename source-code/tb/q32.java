package tb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@PublishedApi
/* compiled from: Taobao */
public final class q32<T> implements Continuation<T>, CoroutineStackFrame {
    @Deprecated
    private static final AtomicReferenceFieldUpdater<q32<?>, Object> b = AtomicReferenceFieldUpdater.newUpdater(q32.class, Object.class, "result");
    @NotNull
    private final Continuation<T> a;
    @Nullable
    private volatile Object result;

    /* compiled from: Taobao */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public q32(@NotNull Continuation<? super T> continuation, @Nullable Object obj) {
        k21.i(continuation, "delegate");
        this.a = continuation;
        this.result = obj;
    }

    @PublishedApi
    @Nullable
    public final Object a() {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            if (b.compareAndSet(this, coroutineSingletons, b.d())) {
                return b.d();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return b.d();
        }
        if (!(obj instanceof Result.Failure)) {
            return obj;
        }
        throw ((Result.Failure) obj).exception;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.a.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                if (b.compareAndSet(this, coroutineSingletons, obj)) {
                    return;
                }
            } else if (obj2 != b.d()) {
                throw new IllegalStateException("Already resumed");
            } else if (b.compareAndSet(this, b.d(), CoroutineSingletons.RESUMED)) {
                this.a.resumeWith(obj);
                return;
            }
        }
    }

    @NotNull
    public String toString() {
        return "SafeContinuation for " + this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public q32(@NotNull Continuation<? super T> continuation) {
        this(continuation, CoroutineSingletons.UNDECIDED);
        k21.i(continuation, "delegate");
    }
}
