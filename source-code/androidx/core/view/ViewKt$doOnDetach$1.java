package androidx.core.view;

import android.view.View;
import com.youku.arch.v3.event.ViewHolderEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"androidx/core/view/ViewKt$doOnDetach$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "Ltb/ur2;", ViewHolderEvent.ON_VIEW_ATTACHED_TO_WINDOW, ViewHolderEvent.ON_VIEW_DETACHED_FROM_WINDOW, "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ViewKt$doOnDetach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Function1 $action;
    final /* synthetic */ View $this_doOnDetach;

    public ViewKt$doOnDetach$1(View view, Function1 function1) {
        this.$this_doOnDetach = view;
        this.$action = function1;
    }

    public void onViewAttachedToWindow(@NotNull View view) {
        k21.i(view, "view");
    }

    public void onViewDetachedFromWindow(@NotNull View view) {
        k21.i(view, "view");
        this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }
}
