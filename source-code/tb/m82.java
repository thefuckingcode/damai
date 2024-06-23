package tb;

import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class m82<E> extends l82<E> {
    @JvmField
    @NotNull
    public final Function1<E, ur2> f;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super E, tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public m82(E e, @NotNull CancellableContinuation<? super ur2> cancellableContinuation, @NotNull Function1<? super E, ur2> function1) {
        super(e, cancellableContinuation);
        this.f = function1;
    }

    @Override // kotlinx.coroutines.internal.b
    public boolean p() {
        if (!super.p()) {
            return false;
        }
        y();
        return true;
    }

    @Override // tb.k82
    public void y() {
        OnUndeliveredElementKt.b(this.f, v(), this.e.getContext());
    }
}
