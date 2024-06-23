package org.jetbrains.anko;

import android.content.DialogInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 1, 11})
/* compiled from: AndroidAlertBuilder.kt */
final class AndroidAlertBuilder$items$4 implements DialogInterface.OnClickListener {
    final /* synthetic */ List $items;
    final /* synthetic */ Function3 $onItemSelected;

    AndroidAlertBuilder$items$4(Function3 function3, List list) {
        this.$onItemSelected = function3;
        this.$items = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Function3 function3 = this.$onItemSelected;
        Intrinsics.checkExpressionValueIsNotNull(dialogInterface, "dialog");
        function3.invoke(dialogInterface, this.$items.get(i), Integer.valueOf(i));
    }
}
