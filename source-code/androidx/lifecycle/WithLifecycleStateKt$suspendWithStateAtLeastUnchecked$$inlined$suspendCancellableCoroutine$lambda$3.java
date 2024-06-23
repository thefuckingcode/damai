package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"R", "", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "invoke", "(Ljava/lang/Throwable;)V", "androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3 extends Lambda implements Function1<Throwable, ur2> {
    final /* synthetic */ Function0 $block$inlined;
    final /* synthetic */ boolean $dispatchNeeded$inlined;
    final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher$inlined;
    final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 $observer;
    final /* synthetic */ Lifecycle.State $state$inlined;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3(WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, Lifecycle lifecycle, Lifecycle.State state, Function0 function0, boolean z, CoroutineDispatcher coroutineDispatcher) {
        super(1);
        this.$observer = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1;
        this.$this_suspendWithStateAtLeastUnchecked$inlined = lifecycle;
        this.$state$inlined = state;
        this.$block$inlined = function0;
        this.$dispatchNeeded$inlined = z;
        this.$lifecycleDispatcher$inlined = coroutineDispatcher;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
        invoke(th);
        return ur2.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        CoroutineDispatcher coroutineDispatcher = this.$lifecycleDispatcher$inlined;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher.isDispatchNeeded(emptyCoroutineContext)) {
            this.$lifecycleDispatcher$inlined.dispatch(emptyCoroutineContext, new Runnable(this) {
                /* class androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.AnonymousClass1 */
                final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3 = this.this$0;
                    withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.$observer);
                }
            });
        } else {
            this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this.$observer);
        }
    }
}
