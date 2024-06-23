package kotlinx.coroutines.sync;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.jh2;
import tb.k12;

/* compiled from: Taobao */
public final class MutexKt {
    @NotNull
    private static final jh2 a = new jh2("LOCK_FAIL");
    @NotNull
    private static final jh2 b = new jh2("UNLOCK_FAIL");
    @NotNull
    private static final jh2 c = new jh2("SELECT_SUCCESS");
    @NotNull
    private static final jh2 d;
    @NotNull
    private static final jh2 e;
    @NotNull
    private static final b f;
    @NotNull
    private static final b g;

    static {
        jh2 jh2 = new jh2("LOCKED");
        d = jh2;
        jh2 jh22 = new jh2("UNLOCKED");
        e = jh22;
        f = new b(jh2);
        g = new b(jh22);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object h(@NotNull Mutex mutex, @Nullable Object obj, @NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        MutexKt$withLock$1 mutexKt$withLock$1;
        int i;
        if (continuation instanceof MutexKt$withLock$1) {
            mutexKt$withLock$1 = (MutexKt$withLock$1) continuation;
            int i2 = mutexKt$withLock$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                mutexKt$withLock$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = mutexKt$withLock$1.result;
                Object obj3 = b.d();
                i = mutexKt$withLock$1.label;
                if (i != 0) {
                    k12.b(obj2);
                    mutexKt$withLock$1.L$0 = mutex;
                    mutexKt$withLock$1.L$1 = obj;
                    mutexKt$withLock$1.L$2 = function0;
                    mutexKt$withLock$1.label = 1;
                    if (mutex.lock(obj, mutexKt$withLock$1) == obj3) {
                        return obj3;
                    }
                } else if (i == 1) {
                    function0 = (Function0) mutexKt$withLock$1.L$2;
                    obj = mutexKt$withLock$1.L$1;
                    mutex = (Mutex) mutexKt$withLock$1.L$0;
                    k12.b(obj2);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return function0.invoke();
            }
        }
        mutexKt$withLock$1 = new MutexKt$withLock$1(continuation);
        Object obj22 = mutexKt$withLock$1.result;
        Object obj32 = b.d();
        i = mutexKt$withLock$1.label;
        if (i != 0) {
        }
        try {
            return function0.invoke();
        } finally {
            b11.b(1);
            mutex.unlock(obj);
            b11.a(1);
        }
    }
}
