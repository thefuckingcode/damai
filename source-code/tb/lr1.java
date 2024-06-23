package tb;

import androidx.annotation.MainThread;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class lr1<T> {
    @NotNull
    private final nq1 a = nq1.INSTANCE;
    @Nullable
    private Continuation<? super T> b;
    private Object c;

    @Nullable
    public final Object a(@NotNull Continuation<? super T> continuation) {
        Object obj = this.c;
        if (obj != null) {
            if (obj == null) {
                k21.A("data");
                obj = ur2.INSTANCE;
            }
            if (obj == this.a) {
                return null;
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                return obj2;
            }
            k21.A("data");
            return ur2.INSTANCE;
        }
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        System.out.println((Object) "PendingData await2");
        this.b = q32;
        Object a2 = q32.a();
        if (a2 == b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    @MainThread
    public final void b(T t) {
        if (this.c == null) {
            this.c = t == null ? this.a : t;
            Continuation<? super T> continuation = this.b;
            if (continuation != null) {
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m913constructorimpl(t));
                this.b = null;
            }
        }
    }
}
