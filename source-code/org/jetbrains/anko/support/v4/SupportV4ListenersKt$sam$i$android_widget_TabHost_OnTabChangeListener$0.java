package org.jetbrains.anko.support.v4;

import android.widget.TabHost;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
/* compiled from: Listeners.kt */
public final class SupportV4ListenersKt$sam$i$android_widget_TabHost_OnTabChangeListener$0 implements TabHost.OnTabChangeListener {
    private final /* synthetic */ Function1 function;

    public SupportV4ListenersKt$sam$i$android_widget_TabHost_OnTabChangeListener$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void onTabChanged(String str) {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(str), "invoke(...)");
    }
}
