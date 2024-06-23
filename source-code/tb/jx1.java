package tb;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.internal.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class jx1<E> extends b implements ReceiveOrClosed<E> {
    @NotNull
    /* renamed from: u */
    public jh2 getOfferResult() {
        return i1.OFFER_SUCCESS;
    }

    @Nullable
    public Function1<Throwable, ur2> v(E e) {
        return null;
    }

    public abstract void w(@NotNull fj<?> fjVar);
}
