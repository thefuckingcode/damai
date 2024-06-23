package org.jetbrains.anko;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/DialogInterface;", "invoke"}, k = 3, mv = {1, 1, 11})
/* compiled from: AlertDialogBuilder.kt */
final class AlertDialogBuilder$neutralButton$1 extends Lambda implements Function1<DialogInterface, Unit> {
    public static final AlertDialogBuilder$neutralButton$1 INSTANCE = new AlertDialogBuilder$neutralButton$1();

    AlertDialogBuilder$neutralButton$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface) {
        invoke(dialogInterface);
        return Unit.INSTANCE;
    }

    public final void invoke(DialogInterface dialogInterface) {
        Intrinsics.checkParameterIsNotNull(dialogInterface, "$receiver");
        dialogInterface.dismiss();
    }
}
