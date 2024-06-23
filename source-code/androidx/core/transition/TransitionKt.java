package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import com.uc.webview.export.media.MessageID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a5\u0010\b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a5\u0010\t\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a5\u0010\n\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a5\u0010\u000b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001a5\u0010\f\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u001aÉ\u0001\u0010\u0012\u001a\u00020\u0007*\u00020\u00002#\b\u0006\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"Landroid/transition/Transition;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "Ltb/ur2;", "action", "Landroid/transition/Transition$TransitionListener;", "doOnEnd", "doOnStart", "doOnCancel", "doOnResume", "doOnPause", "onEnd", "onStart", "onCancel", "onResume", MessageID.onPause, "addListener", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TransitionKt {
    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener addListener(@NotNull Transition transition, @NotNull Function1<? super Transition, ur2> function1, @NotNull Function1<? super Transition, ur2> function12, @NotNull Function1<? super Transition, ur2> function13, @NotNull Function1<? super Transition, ur2> function14, @NotNull Function1<? super Transition, ur2> function15) {
        k21.i(transition, "$this$addListener");
        k21.i(function1, "onEnd");
        k21.i(function12, "onStart");
        k21.i(function13, "onCancel");
        k21.i(function14, "onResume");
        k21.i(function15, MessageID.onPause);
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function13, function12);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = TransitionKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function13 = TransitionKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            function14 = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i & 16) != 0) {
            function15 = TransitionKt$addListener$5.INSTANCE;
        }
        k21.i(transition, "$this$addListener");
        k21.i(function1, "onEnd");
        k21.i(function12, "onStart");
        k21.i(function13, "onCancel");
        k21.i(function14, "onResume");
        k21.i(function15, MessageID.onPause);
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function13, function12);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnCancel(@NotNull Transition transition, @NotNull Function1<? super Transition, ur2> function1) {
        k21.i(transition, "$this$doOnCancel");
        k21.i(function1, "action");
        TransitionKt$doOnCancel$$inlined$addListener$1 transitionKt$doOnCancel$$inlined$addListener$1 = new TransitionKt$doOnCancel$$inlined$addListener$1(function1);
        transition.addListener(transitionKt$doOnCancel$$inlined$addListener$1);
        return transitionKt$doOnCancel$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnEnd(@NotNull Transition transition, @NotNull Function1<? super Transition, ur2> function1) {
        k21.i(transition, "$this$doOnEnd");
        k21.i(function1, "action");
        TransitionKt$doOnEnd$$inlined$addListener$1 transitionKt$doOnEnd$$inlined$addListener$1 = new TransitionKt$doOnEnd$$inlined$addListener$1(function1);
        transition.addListener(transitionKt$doOnEnd$$inlined$addListener$1);
        return transitionKt$doOnEnd$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnPause(@NotNull Transition transition, @NotNull Function1<? super Transition, ur2> function1) {
        k21.i(transition, "$this$doOnPause");
        k21.i(function1, "action");
        TransitionKt$doOnPause$$inlined$addListener$1 transitionKt$doOnPause$$inlined$addListener$1 = new TransitionKt$doOnPause$$inlined$addListener$1(function1);
        transition.addListener(transitionKt$doOnPause$$inlined$addListener$1);
        return transitionKt$doOnPause$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnResume(@NotNull Transition transition, @NotNull Function1<? super Transition, ur2> function1) {
        k21.i(transition, "$this$doOnResume");
        k21.i(function1, "action");
        TransitionKt$doOnResume$$inlined$addListener$1 transitionKt$doOnResume$$inlined$addListener$1 = new TransitionKt$doOnResume$$inlined$addListener$1(function1);
        transition.addListener(transitionKt$doOnResume$$inlined$addListener$1);
        return transitionKt$doOnResume$$inlined$addListener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnStart(@NotNull Transition transition, @NotNull Function1<? super Transition, ur2> function1) {
        k21.i(transition, "$this$doOnStart");
        k21.i(function1, "action");
        TransitionKt$doOnStart$$inlined$addListener$1 transitionKt$doOnStart$$inlined$addListener$1 = new TransitionKt$doOnStart$$inlined$addListener$1(function1);
        transition.addListener(transitionKt$doOnStart$$inlined$addListener$1);
        return transitionKt$doOnStart$$inlined$addListener$1;
    }
}
