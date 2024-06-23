package kotlinx.coroutines.experimental.sync;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.experimental.internal.Symbol;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a5\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0011*\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0015HHø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aE\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0011*\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a9\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0011*\u00020\r2\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a9\u0010\u001b\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0011*\u00020\r2\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u001c"}, d2 = {"ENQUEUE_FAIL", "Lkotlinx/coroutines/experimental/internal/Symbol;", "EmptyLocked", "Lkotlinx/coroutines/experimental/sync/Empty;", "EmptyUnlocked", "LOCKED", "LOCK_FAIL", "RESUME_ACTIVE", "RESUME_QUIESCENT", "SELECT_SUCCESS", "UNLOCKED", "UNLOCK_FAIL", "Mutex", "Lkotlinx/coroutines/experimental/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/experimental/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/experimental/sync/Mutex;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "withMutex", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Mutex.kt */
public final class MutexKt {
    private static final Symbol ENQUEUE_FAIL = new Symbol("ENQUEUE_FAIL");
    private static final Empty EmptyLocked;
    private static final Empty EmptyUnlocked;
    private static final Symbol LOCKED;
    private static final Symbol LOCK_FAIL = new Symbol("LOCK_FAIL");
    private static final Symbol RESUME_ACTIVE = new Symbol("RESUME_ACTIVE");
    private static final Symbol RESUME_QUIESCENT = new Symbol("RESUME_QUIESCENT");
    private static final Symbol SELECT_SUCCESS = new Symbol("SELECT_SUCCESS");
    private static final Symbol UNLOCKED;
    private static final Symbol UNLOCK_FAIL = new Symbol("UNLOCK_FAIL");

    public static /* bridge */ /* synthetic */ Mutex Mutex$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Mutex(z);
    }

    public static final Mutex Mutex(boolean z) {
        return new MutexImpl(z);
    }

    private static final <T> Object withLock(Mutex mutex, Object obj, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        mutex.lock(obj, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "binary compatibility with old code")
    public static final /* synthetic */ <T> Object withLock(Mutex mutex, Object obj, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        MutexKt$withLock$2 mutexKt$withLock$2;
        Object obj2;
        Object coroutine_suspended;
        int label;
        Throwable th;
        Object obj3;
        Mutex mutex2;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        Object obj4;
        Mutex mutex3;
        if (continuation instanceof MutexKt$withLock$2) {
            mutexKt$withLock$2 = (MutexKt$withLock$2) continuation;
            if ((mutexKt$withLock$2.getLabel() & Integer.MIN_VALUE) != 0) {
                mutexKt$withLock$2.setLabel(mutexKt$withLock$2.getLabel() - Integer.MIN_VALUE);
                obj2 = mutexKt$withLock$2.data;
                Throwable th2 = mutexKt$withLock$2.exception;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = mutexKt$withLock$2.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        Mutex mutex4 = (Mutex) mutexKt$withLock$2.L$3;
                        Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) mutexKt$withLock$2.L$2;
                        Object obj5 = mutexKt$withLock$2.L$1;
                        Mutex mutex5 = (Mutex) mutexKt$withLock$2.L$0;
                        if (th2 == null) {
                            mutex3 = mutex4;
                            mutex = mutex5;
                            function12 = function13;
                            obj4 = obj5;
                        } else {
                            throw th2;
                        }
                    } else if (label == 2) {
                        mutex2 = (Mutex) mutexKt$withLock$2.L$3;
                        Function1 function14 = (Function1) mutexKt$withLock$2.L$2;
                        obj3 = mutexKt$withLock$2.L$1;
                        Mutex mutex6 = (Mutex) mutexKt$withLock$2.L$0;
                        if (th2 != null) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        mutex2.unlock(obj3);
                        return obj2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th2 == null) {
                    mutexKt$withLock$2.L$0 = mutex;
                    mutexKt$withLock$2.L$1 = obj;
                    mutexKt$withLock$2.L$2 = function1;
                    mutexKt$withLock$2.L$3 = mutex;
                    mutexKt$withLock$2.setLabel(1);
                    if (mutex.lock(obj, mutexKt$withLock$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function12 = function1;
                    obj4 = obj;
                    mutex3 = mutex;
                } else {
                    throw th2;
                }
                mutexKt$withLock$2.L$0 = mutex;
                mutexKt$withLock$2.L$1 = obj4;
                mutexKt$withLock$2.L$2 = function12;
                mutexKt$withLock$2.L$3 = mutex3;
                mutexKt$withLock$2.setLabel(2);
                obj2 = function12.invoke(mutexKt$withLock$2);
                if (obj2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex3;
                obj3 = obj4;
                mutex2.unlock(obj3);
                return obj2;
            }
        }
        mutexKt$withLock$2 = new MutexKt$withLock$2(continuation);
        obj2 = mutexKt$withLock$2.data;
        Throwable th22 = mutexKt$withLock$2.exception;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = mutexKt$withLock$2.getLabel();
        if (label == 0) {
        }
        try {
            mutexKt$withLock$2.L$0 = mutex;
            mutexKt$withLock$2.L$1 = obj4;
            mutexKt$withLock$2.L$2 = function12;
            mutexKt$withLock$2.L$3 = mutex3;
            mutexKt$withLock$2.setLabel(2);
            obj2 = function12.invoke(mutexKt$withLock$2);
            if (obj2 != coroutine_suspended) {
            }
        } catch (Throwable th4) {
            th = th4;
            mutex2 = mutex3;
            obj3 = obj4;
            mutex2.unlock(obj3);
            throw th;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "binary compatibility with old code")
    public static /* bridge */ /* synthetic */ Object withLock$default(Mutex mutex, Object obj, Function1 function1, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return withLock(mutex, obj, function1, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use `withLock(owner, action)")
    public static final /* synthetic */ <T> Object withLock(Mutex mutex, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        MutexKt$withLock$4 mutexKt$withLock$4;
        Object obj;
        Object coroutine_suspended;
        int label;
        Throwable th;
        Mutex mutex2;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        Mutex mutex3;
        if (continuation instanceof MutexKt$withLock$4) {
            mutexKt$withLock$4 = (MutexKt$withLock$4) continuation;
            if ((mutexKt$withLock$4.getLabel() & Integer.MIN_VALUE) != 0) {
                mutexKt$withLock$4.setLabel(mutexKt$withLock$4.getLabel() - Integer.MIN_VALUE);
                obj = mutexKt$withLock$4.data;
                Throwable th2 = mutexKt$withLock$4.exception;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = mutexKt$withLock$4.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        Mutex mutex4 = (Mutex) mutexKt$withLock$4.L$2;
                        Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) mutexKt$withLock$4.L$1;
                        Mutex mutex5 = (Mutex) mutexKt$withLock$4.L$0;
                        if (th2 == null) {
                            mutex3 = mutex4;
                            mutex = mutex5;
                            function12 = function13;
                        } else {
                            throw th2;
                        }
                    } else if (label == 2) {
                        mutex2 = (Mutex) mutexKt$withLock$4.L$2;
                        Function1 function14 = (Function1) mutexKt$withLock$4.L$1;
                        Mutex mutex6 = (Mutex) mutexKt$withLock$4.L$0;
                        if (th2 != null) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        mutex2.unlock(null);
                        return obj;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th2 == null) {
                    mutexKt$withLock$4.L$0 = mutex;
                    mutexKt$withLock$4.L$1 = function1;
                    mutexKt$withLock$4.L$2 = mutex;
                    mutexKt$withLock$4.setLabel(1);
                    if (mutex.lock(null, mutexKt$withLock$4) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function12 = function1;
                    mutex3 = mutex;
                } else {
                    throw th2;
                }
                mutexKt$withLock$4.L$0 = mutex;
                mutexKt$withLock$4.L$1 = function12;
                mutexKt$withLock$4.L$2 = mutex3;
                mutexKt$withLock$4.setLabel(2);
                obj = function12.invoke(mutexKt$withLock$4);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex3;
                mutex2.unlock(null);
                return obj;
            }
        }
        mutexKt$withLock$4 = new MutexKt$withLock$4(continuation);
        obj = mutexKt$withLock$4.data;
        Throwable th22 = mutexKt$withLock$4.exception;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = mutexKt$withLock$4.getLabel();
        if (label == 0) {
        }
        try {
            mutexKt$withLock$4.L$0 = mutex;
            mutexKt$withLock$4.L$1 = function12;
            mutexKt$withLock$4.L$2 = mutex3;
            mutexKt$withLock$4.setLabel(2);
            obj = function12.invoke(mutexKt$withLock$4);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th4) {
            th = th4;
            mutex2 = mutex3;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    @Deprecated(message = "Use `withLock`", replaceWith = @ReplaceWith(expression = "withLock(action)", imports = {}))
    public static final <T> Object withMutex(Mutex mutex, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        MutexKt$withMutex$1 mutexKt$withMutex$1;
        Object obj;
        Object coroutine_suspended;
        int label;
        Throwable th;
        Mutex mutex2;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        Mutex mutex3;
        if (continuation instanceof MutexKt$withMutex$1) {
            mutexKt$withMutex$1 = (MutexKt$withMutex$1) continuation;
            if ((mutexKt$withMutex$1.getLabel() & Integer.MIN_VALUE) != 0) {
                mutexKt$withMutex$1.setLabel(mutexKt$withMutex$1.getLabel() - Integer.MIN_VALUE);
                obj = mutexKt$withMutex$1.data;
                Throwable th2 = mutexKt$withMutex$1.exception;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = mutexKt$withMutex$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        Mutex mutex4 = (Mutex) mutexKt$withMutex$1.L$2;
                        Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) mutexKt$withMutex$1.L$1;
                        Mutex mutex5 = (Mutex) mutexKt$withMutex$1.L$0;
                        if (th2 == null) {
                            mutex3 = mutex4;
                            mutex = mutex5;
                            function12 = function13;
                        } else {
                            throw th2;
                        }
                    } else if (label == 2) {
                        mutex2 = (Mutex) mutexKt$withMutex$1.L$2;
                        Function1 function14 = (Function1) mutexKt$withMutex$1.L$1;
                        Mutex mutex6 = (Mutex) mutexKt$withMutex$1.L$0;
                        if (th2 != null) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        mutex2.unlock(null);
                        return obj;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th2 == null) {
                    mutexKt$withMutex$1.L$0 = mutex;
                    mutexKt$withMutex$1.L$1 = function1;
                    mutexKt$withMutex$1.L$2 = mutex;
                    mutexKt$withMutex$1.setLabel(1);
                    if (mutex.lock(null, mutexKt$withMutex$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function12 = function1;
                    mutex3 = mutex;
                } else {
                    throw th2;
                }
                mutexKt$withMutex$1.L$0 = mutex;
                mutexKt$withMutex$1.L$1 = function12;
                mutexKt$withMutex$1.L$2 = mutex3;
                mutexKt$withMutex$1.setLabel(2);
                obj = function12.invoke(mutexKt$withMutex$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex3;
                mutex2.unlock(null);
                return obj;
            }
        }
        mutexKt$withMutex$1 = new MutexKt$withMutex$1(continuation);
        obj = mutexKt$withMutex$1.data;
        Throwable th22 = mutexKt$withMutex$1.exception;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = mutexKt$withMutex$1.getLabel();
        if (label == 0) {
        }
        try {
            mutexKt$withMutex$1.L$0 = mutex;
            mutexKt$withMutex$1.L$1 = function12;
            mutexKt$withMutex$1.L$2 = mutex3;
            mutexKt$withMutex$1.setLabel(2);
            obj = function12.invoke(mutexKt$withMutex$1);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th4) {
            th = th4;
            mutex2 = mutex3;
            mutex2.unlock(null);
            throw th;
        }
    }

    static {
        Symbol symbol = new Symbol("LOCKED");
        LOCKED = symbol;
        Symbol symbol2 = new Symbol("UNLOCKED");
        UNLOCKED = symbol2;
        EmptyLocked = new Empty(symbol);
        EmptyUnlocked = new Empty(symbol2);
    }

    static /* bridge */ /* synthetic */ Object withLock$default(Mutex mutex, Object obj, Function0 function0, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        InlineMarker.mark(0);
        mutex.lock(obj, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }
}
