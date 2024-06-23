package tb;

import kotlin.Result;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class l82<E> extends k82 {
    private final E d;
    @JvmField
    @NotNull
    public final CancellableContinuation<ur2> e;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public l82(E e2, @NotNull CancellableContinuation<? super ur2> cancellableContinuation) {
        this.d = e2;
        this.e = cancellableContinuation;
    }

    @Override // kotlinx.coroutines.internal.b
    @NotNull
    public String toString() {
        return q30.a(this) + '@' + q30.b(this) + '(' + ((Object) v()) + ')';
    }

    @Override // tb.k82
    public void u() {
        this.e.completeResume(jf.RESUME_TOKEN);
    }

    @Override // tb.k82
    public E v() {
        return this.d;
    }

    @Override // tb.k82
    public void w(@NotNull fj<?> fjVar) {
        CancellableContinuation<ur2> cancellableContinuation = this.e;
        Throwable C = fjVar.C();
        Result.a aVar = Result.Companion;
        cancellableContinuation.resumeWith(Result.m913constructorimpl(k12.a(C)));
    }

    @Override // tb.k82
    @Nullable
    public jh2 x(@Nullable b.d dVar) {
        Object tryResume = this.e.tryResume(ur2.INSTANCE, dVar == null ? null : dVar.c);
        if (tryResume == null) {
            return null;
        }
        if (n30.a()) {
            if (!(tryResume == jf.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        if (dVar != null) {
            dVar.d();
        }
        return jf.RESUME_TOKEN;
    }
}
