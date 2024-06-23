package androidx.lifecycle;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Landroid/view/View;", "Landroidx/lifecycle/LifecycleOwner;", "findViewTreeLifecycleOwner", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ViewKt {
    @Nullable
    public static final LifecycleOwner findViewTreeLifecycleOwner(@NotNull View view) {
        k21.i(view, "$this$findViewTreeLifecycleOwner");
        return ViewTreeLifecycleOwner.get(view);
    }
}
