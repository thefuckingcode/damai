package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.p30;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002HHø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"R", "Landroidx/activity/contextaware/ContextAware;", "Lkotlin/Function1;", "Landroid/content/Context;", "onContextAvailable", "withContextAvailable", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ContextAwareKt {
    @Nullable
    public static final <R> Object withContextAvailable(@NotNull ContextAware contextAware, @NotNull Function1<? super Context, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return function1.invoke(peekAvailableContext);
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 = new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuationImpl, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1);
        cancellableContinuationImpl.invokeOnCancellation(new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, contextAware, function1));
        Object result = cancellableContinuationImpl.getResult();
        if (result != b.d()) {
            return result;
        }
        p30.c(continuation);
        return result;
    }

    @Nullable
    private static final Object withContextAvailable$$forInline(@NotNull ContextAware contextAware, @NotNull Function1 function1, @NotNull Continuation continuation) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return function1.invoke(peekAvailableContext);
        }
        b11.c(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 = new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuationImpl, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1);
        cancellableContinuationImpl.invokeOnCancellation(new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, contextAware, function1));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b.d()) {
            p30.c(continuation);
        }
        b11.c(1);
        return result;
    }
}
