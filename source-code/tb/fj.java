package tb;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.channels.b;
import kotlinx.coroutines.internal.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fj<E> extends k82 implements ReceiveOrClosed<E> {
    @JvmField
    @Nullable
    public final Throwable d;

    public fj(@Nullable Throwable th) {
        this.d = th;
    }

    @NotNull
    /* renamed from: A */
    public fj<E> v() {
        return this;
    }

    @NotNull
    public final Throwable B() {
        Throwable th = this.d;
        return th == null ? new ClosedReceiveChannelException(b.DEFAULT_CLOSE_MESSAGE) : th;
    }

    @NotNull
    public final Throwable C() {
        Throwable th = this.d;
        return th == null ? new ClosedSendChannelException(b.DEFAULT_CLOSE_MESSAGE) : th;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public void completeResumeReceive(E e) {
    }

    @Override // kotlinx.coroutines.internal.b
    @NotNull
    public String toString() {
        return "Closed@" + q30.b(this) + jl1.ARRAY_START + this.d + jl1.ARRAY_END;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    @NotNull
    public jh2 tryResumeReceive(E e, @Nullable b.d dVar) {
        jh2 jh2 = jf.RESUME_TOKEN;
        if (dVar != null) {
            dVar.d();
        }
        return jh2;
    }

    @Override // tb.k82
    public void u() {
    }

    @Override // tb.k82
    public void w(@NotNull fj<?> fjVar) {
        if (n30.a()) {
            throw new AssertionError();
        }
    }

    @Override // tb.k82
    @NotNull
    public jh2 x(@Nullable b.d dVar) {
        jh2 jh2 = jf.RESUME_TOKEN;
        if (dVar != null) {
            dVar.d();
        }
        return jh2;
    }

    @NotNull
    /* renamed from: z */
    public fj<E> getOfferResult() {
        return this;
    }
}
