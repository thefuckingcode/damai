package kotlinx.coroutines.experimental.test;

import com.lzy.okgo.cache.CacheEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.experimental.CancellableContinuation;
import kotlinx.coroutines.experimental.CoroutineDispatcher;
import kotlinx.coroutines.experimental.CoroutineExceptionHandler;
import kotlinx.coroutines.experimental.DebugKt;
import kotlinx.coroutines.experimental.Delay;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.EventLoop;
import kotlinx.coroutines.experimental.internal.ThreadSafeHeap;

public final class TestCoroutineContext implements CoroutineContext {
    private long counter;
    private final Dispatcher ctxDispatcher;
    private final CoroutineExceptionHandler ctxHandler;
    private final String name;
    private final ThreadSafeHeap<TimedRunnable> queue;
    private long time;
    private final List<Throwable> uncaughtExceptions;

    public TestCoroutineContext() {
        this(null, 1, null);
    }

    public TestCoroutineContext(String str) {
        this.name = str;
        this.uncaughtExceptions = new ArrayList();
        this.ctxDispatcher = new Dispatcher();
        this.ctxHandler = new TestCoroutineContext$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
        this.queue = new ThreadSafeHeap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TestCoroutineContext(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    public final List<Throwable> getExceptions() {
        return this.uncaughtExceptions;
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        return (R) function2.invoke((Object) function2.invoke(r, this.ctxDispatcher), this.ctxHandler);
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
        if (key == ContinuationInterceptor.Key) {
            Dispatcher dispatcher = this.ctxDispatcher;
            if (dispatcher != null) {
                return dispatcher;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        } else if (key != CoroutineExceptionHandler.Key) {
            return null;
        } else {
            CoroutineExceptionHandler coroutineExceptionHandler = this.ctxHandler;
            if (coroutineExceptionHandler != null) {
                return coroutineExceptionHandler;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        }
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
        if (key == ContinuationInterceptor.Key) {
            return this.ctxHandler;
        }
        if (key == CoroutineExceptionHandler.Key) {
            return this.ctxDispatcher;
        }
        return this;
    }

    public static /* bridge */ /* synthetic */ long now$default(TestCoroutineContext testCoroutineContext, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.now(timeUnit);
    }

    public final long now(TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        return timeUnit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    public static /* bridge */ /* synthetic */ long advanceTimeBy$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.advanceTimeBy(j, timeUnit);
    }

    public final long advanceTimeBy(long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        long j2 = this.time;
        advanceTimeTo(timeUnit.toNanos(j) + j2, TimeUnit.NANOSECONDS);
        return timeUnit.convert(this.time - j2, TimeUnit.NANOSECONDS);
    }

    public static /* bridge */ /* synthetic */ void advanceTimeTo$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        testCoroutineContext.advanceTimeTo(j, timeUnit);
    }

    public final void advanceTimeTo(long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        long nanos = timeUnit.toNanos(j);
        triggerActions(nanos);
        if (nanos > this.time) {
            this.time = nanos;
        }
    }

    public final void triggerActions() {
        triggerActions(this.time);
    }

    public final void cancelAllActions() {
        if (!this.queue.isEmpty()) {
            this.queue.clear();
        }
    }

    public static /* bridge */ /* synthetic */ void assertUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertUnhandledException(str, function1);
    }

    public final void assertUnhandledException(String str, Function1<? super Throwable, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (this.uncaughtExceptions.size() != 1 || !function1.invoke(this.uncaughtExceptions.get(0)).booleanValue()) {
            throw new AssertionError(str);
        }
        this.uncaughtExceptions.clear();
    }

    public static /* bridge */ /* synthetic */ void assertAllUnhandledExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAllUnhandledExceptions(str, function1);
    }

    public final void assertAllUnhandledExceptions(String str, Function1<? super Throwable, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        List<Throwable> list = this.uncaughtExceptions;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!function1.invoke(it.next()).booleanValue()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public static /* bridge */ /* synthetic */ void assertAnyUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAnyUnhandledException(str, function1);
    }

    public final void assertAnyUnhandledException(String str, Function1<? super Throwable, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        List<Throwable> list = this.uncaughtExceptions;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (function1.invoke(it.next()).booleanValue()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public static /* bridge */ /* synthetic */ void assertExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertExceptions(str, function1);
    }

    public final void assertExceptions(String str, Function1<? super List<? extends Throwable>, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (function1.invoke(this.uncaughtExceptions).booleanValue()) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }

    private final void post(Runnable runnable) {
        ThreadSafeHeap<TimedRunnable> threadSafeHeap = this.queue;
        long j = this.counter;
        this.counter = 1 + j;
        threadSafeHeap.addLast(new TimedRunnable(runnable, j, 0, 4, null));
    }

    private final TimedRunnable postDelayed(Runnable runnable, long j) {
        long j2 = this.counter;
        this.counter = 1 + j2;
        TimedRunnable timedRunnable = new TimedRunnable(runnable, j2, this.time + TimeUnit.MILLISECONDS.toNanos(j));
        this.queue.addLast(timedRunnable);
        return timedRunnable;
    }

    private final long processNextEvent() {
        TimedRunnable peek = this.queue.peek();
        if (peek != null) {
            triggerActions(peek.time);
        }
        if (this.queue.isEmpty()) {
            return LongCompanionObject.MAX_VALUE;
        }
        return 0;
    }

    private final void triggerActions(long j) {
        TimedRunnable timedRunnable;
        while (true) {
            ThreadSafeHeap<TimedRunnable> threadSafeHeap = this.queue;
            synchronized (threadSafeHeap) {
                TimedRunnable firstImpl = threadSafeHeap.firstImpl();
                timedRunnable = null;
                if (firstImpl != null) {
                    if (firstImpl.time <= j) {
                        timedRunnable = threadSafeHeap.removeAtImpl(0);
                    }
                }
            }
            TimedRunnable timedRunnable2 = timedRunnable;
            if (timedRunnable2 != null) {
                if (timedRunnable2.time != 0) {
                    this.time = timedRunnable2.time;
                }
                timedRunnable2.run();
            } else {
                return;
            }
        }
    }

    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        return "TestCoroutineContext@" + DebugKt.getHexAddress(this);
    }

    public final class Dispatcher extends CoroutineDispatcher implements Delay, EventLoop {
        public Dispatcher() {
            TestCoroutineContext.this = r1;
        }

        @Override // kotlinx.coroutines.experimental.Delay
        public Object delay(long j, TimeUnit timeUnit, Continuation<? super Unit> continuation) {
            return Delay.DefaultImpls.delay(this, j, timeUnit, continuation);
        }

        @Override // kotlinx.coroutines.experimental.CoroutineDispatcher
        public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
            Intrinsics.checkParameterIsNotNull(runnable, "block");
            TestCoroutineContext.this.post(runnable);
        }

        @Override // kotlinx.coroutines.experimental.Delay
        public void scheduleResumeAfterDelay(long j, TimeUnit timeUnit, CancellableContinuation<? super Unit> cancellableContinuation) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
            TestCoroutineContext.this.postDelayed(new TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(this, cancellableContinuation), timeUnit.toMillis(j));
        }

        @Override // kotlinx.coroutines.experimental.Delay
        public DisposableHandle invokeOnTimeout(long j, TimeUnit timeUnit, Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            Intrinsics.checkParameterIsNotNull(runnable, "block");
            return new TestCoroutineContext$Dispatcher$invokeOnTimeout$1(this, TestCoroutineContext.this.postDelayed(runnable, timeUnit.toMillis(j)));
        }

        @Override // kotlinx.coroutines.experimental.EventLoop
        public long processNextEvent() {
            return TestCoroutineContext.this.processNextEvent();
        }

        @Override // kotlinx.coroutines.experimental.CoroutineDispatcher
        public String toString() {
            return "Dispatcher(" + TestCoroutineContext.this + ')';
        }
    }
}
