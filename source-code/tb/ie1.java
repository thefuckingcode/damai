package tb;

import kotlin.KotlinNothingValueException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ie1 extends xa1 implements Delay {
    @Nullable
    private final Throwable a;
    @Nullable
    private final String b;

    public ie1(@Nullable Throwable th, @Nullable String str) {
        this.a = th;
        this.b = str;
    }

    private final Void e() {
        String r;
        if (this.a != null) {
            String str = this.b;
            String str2 = "";
            if (!(str == null || (r = k21.r(". ", str)) == null)) {
                str2 = r;
            }
            throw new IllegalStateException(k21.r("Module with the Main dispatcher had failed to initialize", str2), this.a);
        }
        za1.c();
        throw new KotlinNothingValueException();
    }

    @Override // tb.xa1
    @NotNull
    public xa1 a() {
        return this;
    }

    @NotNull
    /* renamed from: d */
    public Void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.Delay
    @Nullable
    public Object delay(long j, @NotNull Continuation<?> continuation) {
        e();
        throw new KotlinNothingValueException();
    }

    @NotNull
    /* renamed from: f */
    public Void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super ur2> cancellableContinuation) {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // tb.xa1, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th = this.a;
        sb.append(th != null ? k21.r(", cause=", th) : "");
        sb.append(jl1.ARRAY_END);
        return sb.toString();
    }
}
