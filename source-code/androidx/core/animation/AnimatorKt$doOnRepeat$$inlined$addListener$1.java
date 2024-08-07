package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "Ltb/ur2;", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class AnimatorKt$doOnRepeat$$inlined$addListener$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function1 $onRepeat;

    public AnimatorKt$doOnRepeat$$inlined$addListener$1(Function1 function1) {
        this.$onRepeat = function1;
    }

    public void onAnimationCancel(@NotNull Animator animator) {
        k21.i(animator, "animator");
    }

    public void onAnimationEnd(@NotNull Animator animator) {
        k21.i(animator, "animator");
    }

    public void onAnimationRepeat(@NotNull Animator animator) {
        k21.i(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationStart(@NotNull Animator animator) {
        k21.i(animator, "animator");
    }
}
