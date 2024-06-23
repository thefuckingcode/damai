package androidx.lifecycle;

import io.flutter.wpkbridge.WPKFactory;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.k41;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "close", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class CloseableCoroutineScope implements Closeable, CoroutineScope {
    @NotNull
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(@NotNull CoroutineContext coroutineContext2) {
        k21.i(coroutineContext2, WPKFactory.INIT_KEY_CONTEXT);
        this.coroutineContext = coroutineContext2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        k41.d(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
