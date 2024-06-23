package androidx.activity.contextaware;

import android.content.Context;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import tb.k12;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Ltb/ur2;", "onContextAvailable", "activity-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 implements OnContextAvailableListener {
    final /* synthetic */ CancellableContinuation $co;
    final /* synthetic */ Function1 $onContextAvailable$inlined;
    final /* synthetic */ ContextAware $this_withContextAvailable$inlined;

    public ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, ContextAware contextAware, Function1 function1) {
        this.$co = cancellableContinuation;
        this.$this_withContextAvailable$inlined = contextAware;
        this.$onContextAvailable$inlined = function1;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(@NotNull Context context) {
        Object obj;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        CancellableContinuation cancellableContinuation = this.$co;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m913constructorimpl(this.$onContextAvailable$inlined.invoke(context));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m913constructorimpl(k12.a(th));
        }
        cancellableContinuation.resumeWith(obj);
    }
}
