package org.jetbrains.anko;

import android.content.DialogInterface;
import android.view.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
/* compiled from: AndroidAlertBuilder.kt */
final class AndroidAlertBuilderKt$sam$android_content_DialogInterface_OnKeyListener$0 implements DialogInterface.OnKeyListener {
    private final /* synthetic */ Function3 function;

    AndroidAlertBuilderKt$sam$android_content_DialogInterface_OnKeyListener$0(Function3 function3) {
        this.function = function3;
    }

    public final /* synthetic */ boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Object invoke = this.function.invoke(dialogInterface, Integer.valueOf(i), keyEvent);
        Intrinsics.checkExpressionValueIsNotNull(invoke, "invoke(...)");
        return ((Boolean) invoke).booleanValue();
    }
}
