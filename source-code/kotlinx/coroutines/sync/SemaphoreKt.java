package kotlinx.coroutines.sync;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function0;
import tb.b11;
import tb.jh2;
import tb.k12;
import tb.oh2;

public final class SemaphoreKt {
    private static final int a = oh2.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
    private static final jh2 b = new jh2("PERMIT");
    private static final jh2 c = new jh2("TAKEN");
    private static final jh2 d = new jh2("BROKEN");
    private static final jh2 e = new jh2("CANCELLED");
    private static final int f = oh2.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final d h(long j, d dVar) {
        return new d(j, dVar, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    public static final <T> Object i(Semaphore semaphore, Function0<? extends T> function0, Continuation<? super T> continuation) {
        SemaphoreKt$withPermit$1 semaphoreKt$withPermit$1;
        int i;
        if (continuation instanceof SemaphoreKt$withPermit$1) {
            semaphoreKt$withPermit$1 = (SemaphoreKt$withPermit$1) continuation;
            int i2 = semaphoreKt$withPermit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                semaphoreKt$withPermit$1.label = i2 - Integer.MIN_VALUE;
                Object obj = semaphoreKt$withPermit$1.result;
                Object obj2 = b.d();
                i = semaphoreKt$withPermit$1.label;
                if (i != 0) {
                    k12.b(obj);
                    semaphoreKt$withPermit$1.L$0 = semaphore;
                    semaphoreKt$withPermit$1.L$1 = function0;
                    semaphoreKt$withPermit$1.label = 1;
                    if (semaphore.acquire(semaphoreKt$withPermit$1) == obj2) {
                        return obj2;
                    }
                } else if (i == 1) {
                    function0 = (Function0) semaphoreKt$withPermit$1.L$1;
                    semaphore = (Semaphore) semaphoreKt$withPermit$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return function0.invoke();
            }
        }
        semaphoreKt$withPermit$1 = new SemaphoreKt$withPermit$1(continuation);
        Object obj3 = semaphoreKt$withPermit$1.result;
        Object obj22 = b.d();
        i = semaphoreKt$withPermit$1.label;
        if (i != 0) {
        }
        try {
            return function0.invoke();
        } finally {
            b11.b(1);
            semaphore.release();
            b11.a(1);
        }
    }
}
