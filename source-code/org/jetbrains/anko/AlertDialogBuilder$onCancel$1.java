package org.jetbrains.anko;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 1, 11})
/* compiled from: AlertDialogBuilder.kt */
final class AlertDialogBuilder$onCancel$1 implements DialogInterface.OnCancelListener {
    final /* synthetic */ Function0 $callback;

    AlertDialogBuilder$onCancel$1(Function0 function0) {
        this.$callback = function0;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.$callback.invoke();
    }
}
