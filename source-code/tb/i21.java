package tb;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final class i21 {
    /* access modifiers changed from: private */
    public static final <T> T b(CoroutineContext coroutineContext, Function0<? extends T> function0) {
        try {
            sk2 sk2 = new sk2(j41.h(coroutineContext));
            sk2.d();
            try {
                return (T) function0.invoke();
            } finally {
                sk2.a();
            }
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }
}
