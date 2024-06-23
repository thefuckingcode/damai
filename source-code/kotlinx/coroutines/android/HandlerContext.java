package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jc0;
import tb.k21;
import tb.m40;
import tb.ur2;
import tb.wt0;
import tb.ww1;

/* compiled from: Taobao */
public final class HandlerContext extends wt0 {
    @Nullable
    private volatile HandlerContext _immediate;
    @NotNull
    private final Handler a;
    @Nullable
    private final String b;
    private final boolean c;
    @NotNull
    private final HandlerContext d;

    /* compiled from: Taobao */
    public static final class a implements DisposableHandle {
        final /* synthetic */ HandlerContext a;
        final /* synthetic */ Runnable b;

        a(HandlerContext handlerContext, Runnable runnable) {
            this.a = handlerContext;
            this.b = runnable;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.a.a.removeCallbacks(this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        HandlerContext handlerContext = null;
        this.a = handler;
        this.b = str;
        this.c = z;
        this._immediate = z ? this : handlerContext;
        HandlerContext handlerContext2 = this._immediate;
        if (handlerContext2 == null) {
            handlerContext2 = new HandlerContext(handler, str, true);
            this._immediate = handlerContext2;
            ur2 ur2 = ur2.INSTANCE;
        }
        this.d = handlerContext2;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        this.a.post(runnable);
    }

    @NotNull
    /* renamed from: e */
    public HandlerContext a() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).a == this.a;
    }

    public int hashCode() {
        return System.identityHashCode(this.a);
    }

    @Override // kotlinx.coroutines.Delay, tb.wt0
    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        this.a.postDelayed(runnable, ww1.e(j, jc0.MAX_MILLIS));
        return new a(this, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return !this.c || !k21.d(Looper.myLooper(), this.a.getLooper());
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super ur2> cancellableContinuation) {
        HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 = new HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(cancellableContinuation, this);
        this.a.postDelayed(handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1, ww1.e(j, jc0.MAX_MILLIS));
        cancellableContinuation.invokeOnCancellation(new HandlerContext$scheduleResumeAfterDelay$1(this, handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1));
    }

    @Override // tb.xa1, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String c2 = c();
        if (c2 != null) {
            return c2;
        }
        String str = this.b;
        if (str == null) {
            str = this.a.toString();
        }
        return this.c ? k21.r(str, ".immediate") : str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerContext(Handler handler, String str, int i, m40 m40) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
