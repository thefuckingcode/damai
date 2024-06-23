package androidx.lifecycle;

import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import tb.f90;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/PausingDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", WPKFactory.INIT_KEY_CONTEXT, "", "isDispatchNeeded", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Ltb/ur2;", "dispatch", "Landroidx/lifecycle/DispatchQueue;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "<init>", "()V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class PausingDispatcher extends CoroutineDispatcher {
    @JvmField
    @NotNull
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        k21.i(coroutineContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(runnable, "block");
        this.dispatchQueue.dispatchAndEnqueue(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        k21.i(coroutineContext, WPKFactory.INIT_KEY_CONTEXT);
        if (f90.c().a().isDispatchNeeded(coroutineContext)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
