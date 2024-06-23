package org.jetbrains.anko.support.v4;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
/* compiled from: Listeners.kt */
public final class SupportV4ListenersKt$sam$i$android_support_v4_widget_SwipeRefreshLayout_OnRefreshListener$0 implements SwipeRefreshLayout.OnRefreshListener {
    private final /* synthetic */ Function0 function;

    public SupportV4ListenersKt$sam$i$android_support_v4_widget_SwipeRefreshLayout_OnRefreshListener$0(Function0 function0) {
        this.function = function0;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public final /* synthetic */ void onRefresh() {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(), "invoke(...)");
    }
}
