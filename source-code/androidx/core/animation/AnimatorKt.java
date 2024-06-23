package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import com.uc.webview.export.media.MessageID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a5\u0010\b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a5\u0010\t\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a5\u0010\n\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a5\u0010\u000b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a5\u0010\r\u001a\u00020\f*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a5\u0010\u000e\u001a\u00020\f*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a¤\u0001\u0010\u0013\u001a\u00020\u0007*\u00020\u00002#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001aZ\u0010\u0016\u001a\u00020\f*\u00020\u00002#\b\u0006\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"Landroid/animation/Animator;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "Ltb/ur2;", "action", "Landroid/animation/Animator$AnimatorListener;", "doOnEnd", "doOnStart", "doOnCancel", "doOnRepeat", "Landroid/animation/Animator$AnimatorPauseListener;", "doOnResume", "doOnPause", "onEnd", "onStart", "onCancel", "onRepeat", "addListener", "onResume", MessageID.onPause, "addPauseListener", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class AnimatorKt {
    @NotNull
    public static final Animator.AnimatorListener addListener(@NotNull Animator animator, @NotNull Function1<? super Animator, ur2> function1, @NotNull Function1<? super Animator, ur2> function12, @NotNull Function1<? super Animator, ur2> function13, @NotNull Function1<? super Animator, ur2> function14) {
        k21.i(animator, "$this$addListener");
        k21.i(function1, "onEnd");
        k21.i(function12, "onStart");
        k21.i(function13, "onCancel");
        k21.i(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function13 = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            function14 = AnimatorKt$addListener$4.INSTANCE;
        }
        k21.i(animator, "$this$addListener");
        k21.i(function1, "onEnd");
        k21.i(function12, "onStart");
        k21.i(function13, "onCancel");
        k21.i(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener addPauseListener(@NotNull Animator animator, @NotNull Function1<? super Animator, ur2> function1, @NotNull Function1<? super Animator, ur2> function12) {
        k21.i(animator, "$this$addPauseListener");
        k21.i(function1, "onResume");
        k21.i(function12, MessageID.onPause);
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function12, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        k21.i(animator, "$this$addPauseListener");
        k21.i(function1, "onResume");
        k21.i(function12, MessageID.onPause);
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function12, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnCancel(@NotNull Animator animator, @NotNull Function1<? super Animator, ur2> function1) {
        k21.i(animator, "$this$doOnCancel");
        k21.i(function1, "action");
        AnimatorKt$doOnCancel$$inlined$addListener$1 animatorKt$doOnCancel$$inlined$addListener$1 = new AnimatorKt$doOnCancel$$inlined$addListener$1(function1);
        animator.addListener(animatorKt$doOnCancel$$inlined$addListener$1);
        return animatorKt$doOnCancel$$inlined$addListener$1;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnEnd(@NotNull Animator animator, @NotNull Function1<? super Animator, ur2> function1) {
        k21.i(animator, "$this$doOnEnd");
        k21.i(function1, "action");
        AnimatorKt$doOnEnd$$inlined$addListener$1 animatorKt$doOnEnd$$inlined$addListener$1 = new AnimatorKt$doOnEnd$$inlined$addListener$1(function1);
        animator.addListener(animatorKt$doOnEnd$$inlined$addListener$1);
        return animatorKt$doOnEnd$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnPause(@NotNull Animator animator, @NotNull Function1<? super Animator, ur2> function1) {
        k21.i(animator, "$this$doOnPause");
        k21.i(function1, "action");
        AnimatorKt$doOnPause$$inlined$addPauseListener$1 animatorKt$doOnPause$$inlined$addPauseListener$1 = new AnimatorKt$doOnPause$$inlined$addPauseListener$1(function1);
        animator.addPauseListener(animatorKt$doOnPause$$inlined$addPauseListener$1);
        return animatorKt$doOnPause$$inlined$addPauseListener$1;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnRepeat(@NotNull Animator animator, @NotNull Function1<? super Animator, ur2> function1) {
        k21.i(animator, "$this$doOnRepeat");
        k21.i(function1, "action");
        AnimatorKt$doOnRepeat$$inlined$addListener$1 animatorKt$doOnRepeat$$inlined$addListener$1 = new AnimatorKt$doOnRepeat$$inlined$addListener$1(function1);
        animator.addListener(animatorKt$doOnRepeat$$inlined$addListener$1);
        return animatorKt$doOnRepeat$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnResume(@NotNull Animator animator, @NotNull Function1<? super Animator, ur2> function1) {
        k21.i(animator, "$this$doOnResume");
        k21.i(function1, "action");
        AnimatorKt$doOnResume$$inlined$addPauseListener$1 animatorKt$doOnResume$$inlined$addPauseListener$1 = new AnimatorKt$doOnResume$$inlined$addPauseListener$1(function1);
        animator.addPauseListener(animatorKt$doOnResume$$inlined$addPauseListener$1);
        return animatorKt$doOnResume$$inlined$addPauseListener$1;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnStart(@NotNull Animator animator, @NotNull Function1<? super Animator, ur2> function1) {
        k21.i(animator, "$this$doOnStart");
        k21.i(function1, "action");
        AnimatorKt$doOnStart$$inlined$addListener$1 animatorKt$doOnStart$$inlined$addListener$1 = new AnimatorKt$doOnStart$$inlined$addListener$1(function1);
        animator.addListener(animatorKt$doOnStart$$inlined$addListener$1);
        return animatorKt$doOnStart$$inlined$addListener$1;
    }
}
