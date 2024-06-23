package org.jetbrains.anko;

import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"org/jetbrains/anko/BuildSpannedKt$clickable$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: buildSpanned.kt */
public final class BuildSpannedKt$clickable$1 extends ClickableSpan {
    final /* synthetic */ Function1 $onClick;

    public BuildSpannedKt$clickable$1(Function1 function1) {
        this.$onClick = function1;
    }

    public void onClick(View view) {
        Intrinsics.checkParameterIsNotNull(view, "widget");
        this.$onClick.invoke(view);
    }
}
