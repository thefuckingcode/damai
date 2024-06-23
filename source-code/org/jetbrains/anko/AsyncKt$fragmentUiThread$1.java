package org.jetbrains.anko;

import android.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroid/app/Fragment;", "run"}, k = 3, mv = {1, 1, 11})
/* compiled from: Async.kt */
final class AsyncKt$fragmentUiThread$1 implements Runnable {
    final /* synthetic */ Function1 $f;
    final /* synthetic */ Fragment $fragment;

    AsyncKt$fragmentUiThread$1(Function1 function1, Fragment fragment) {
        this.$f = function1;
        this.$fragment = fragment;
    }

    public final void run() {
        Function1 function1 = this.$f;
        Fragment fragment = this.$fragment;
        Intrinsics.checkExpressionValueIsNotNull(fragment, "fragment");
        function1.invoke(fragment);
    }
}
