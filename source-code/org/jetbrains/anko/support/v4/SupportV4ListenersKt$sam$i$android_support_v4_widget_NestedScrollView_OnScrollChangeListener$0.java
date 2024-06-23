package org.jetbrains.anko.support.v4;

import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
/* compiled from: Listeners.kt */
public final class SupportV4ListenersKt$sam$i$android_support_v4_widget_NestedScrollView_OnScrollChangeListener$0 implements NestedScrollView.OnScrollChangeListener {
    private final /* synthetic */ Function5 function;

    public SupportV4ListenersKt$sam$i$android_support_v4_widget_NestedScrollView_OnScrollChangeListener$0(Function5 function5) {
        this.function = function5;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public final /* synthetic */ void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(nestedScrollView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)), "invoke(...)");
    }
}
