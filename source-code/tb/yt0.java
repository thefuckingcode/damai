package tb;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import kotlin.Result;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.android.HandlerContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class yt0 {
    @JvmField
    @Nullable
    public static final wt0 Main;
    @Nullable
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        wt0 wt0 = null;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m913constructorimpl(new HandlerContext(c(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m913constructorimpl(k12.a(th));
        }
        if (!Result.m919isFailureimpl(obj)) {
            wt0 = obj;
        }
        Main = wt0;
    }

    @VisibleForTesting
    @NotNull
    public static final Handler c(@NotNull Looper looper, boolean z) {
        int i;
        if (!z || (i = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    private static final void d(Choreographer choreographer2, CancellableContinuation<? super Long> cancellableContinuation) {
        choreographer2.postFrameCallback(new xt0(cancellableContinuation));
    }

    /* access modifiers changed from: private */
    public static final void e(CancellableContinuation cancellableContinuation, long j) {
        f90 f90 = f90.INSTANCE;
        cancellableContinuation.resumeUndispatched(f90.c(), Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public static final void f(CancellableContinuation<? super Long> cancellableContinuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            k21.f(choreographer2);
            choreographer = choreographer2;
        }
        d(choreographer2, cancellableContinuation);
    }
}
