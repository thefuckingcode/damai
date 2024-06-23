package org.jetbrains.anko;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0014\b\b\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"applyRecursively", "T", "Landroid/view/View;", "f", "Lkotlin/Function1;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Ui.kt */
public final class UiKt {
    public static final <T extends View> T applyRecursively(T t, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        AnkoInternals.INSTANCE.applyRecursively(t, function1);
        return t;
    }
}
