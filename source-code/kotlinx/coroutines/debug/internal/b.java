package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.po2;
import tb.ur2;

/* compiled from: Taobao */
public final class b {
    @NotNull
    public static final b INSTANCE;
    @NotNull
    private static final ConcurrentWeakMap<a<?>, Boolean> a = new ConcurrentWeakMap<>(false, 1, null);
    @Nullable
    private static final Function1<Boolean, ur2> b;
    @NotNull
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> c = new ConcurrentWeakMap<>(true);
    private static volatile int installations;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a<T> implements Continuation<T>, CoroutineStackFrame {
        @JvmField
        @NotNull
        public final Continuation<T> a;
        @JvmField
        @NotNull
        public final DebugCoroutineInfoImpl b;
        @Nullable
        private final CoroutineStackFrame c;

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getCallerFrame();
        }

        @Override // kotlin.coroutines.Continuation
        @NotNull
        public CoroutineContext getContext() {
            return this.a.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getStackTraceElement();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object obj) {
            b.INSTANCE.f(this);
            this.a.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.a.toString();
        }
    }

    static {
        b bVar = new b();
        INSTANCE = bVar;
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        new c(0);
        new ReentrantReadWriteLock();
        b = bVar.d();
        AtomicLongFieldUpdater.newUpdater(c.class, "sequenceNumber");
    }

    private b() {
    }

    private final Function1<Boolean, ur2> d() {
        Object obj;
        try {
            Result.a aVar = Result.Companion;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            if (newInstance != null) {
                obj = Result.m913constructorimpl((Function1) po2.e(newInstance, 1));
                if (Result.m919isFailureimpl(obj)) {
                    obj = null;
                }
                return (Function1) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m913constructorimpl(k12.a(th));
        }
    }

    /* access modifiers changed from: private */
    public final boolean e(a<?> aVar) {
        CoroutineContext b2 = aVar.b.b();
        Job job = b2 == null ? null : (Job) b2.get(Job.Key);
        if (job == null || !job.isCompleted()) {
            return false;
        }
        a.remove(aVar);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void f(a<?> aVar) {
        a.remove(aVar);
        CoroutineStackFrame c2 = aVar.b.c();
        CoroutineStackFrame g = c2 == null ? null : g(c2);
        if (g != null) {
            c.remove(g);
        }
    }

    private final CoroutineStackFrame g(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }
}
