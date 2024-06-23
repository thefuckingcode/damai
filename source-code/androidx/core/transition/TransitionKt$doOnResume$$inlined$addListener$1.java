package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n¸\u0006\u0000"}, d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "transition", "Ltb/ur2;", "onTransitionEnd", "onTransitionResume", "onTransitionPause", "onTransitionCancel", "onTransitionStart", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TransitionKt$doOnResume$$inlined$addListener$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1 $onResume;

    public TransitionKt$doOnResume$$inlined$addListener$1(Function1 function1) {
        this.$onResume = function1;
    }

    public void onTransitionCancel(@NotNull Transition transition) {
        k21.i(transition, "transition");
    }

    public void onTransitionEnd(@NotNull Transition transition) {
        k21.i(transition, "transition");
    }

    public void onTransitionPause(@NotNull Transition transition) {
        k21.i(transition, "transition");
    }

    public void onTransitionResume(@NotNull Transition transition) {
        k21.i(transition, "transition");
        this.$onResume.invoke(transition);
    }

    public void onTransitionStart(@NotNull Transition transition) {
        k21.i(transition, "transition");
    }
}
