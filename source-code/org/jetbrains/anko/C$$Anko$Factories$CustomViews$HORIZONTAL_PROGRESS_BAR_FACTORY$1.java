package org.jetbrains.anko;

import android.content.Context;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/widget/ProgressBar;", "ctx", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 1, 11})
/* renamed from: org.jetbrains.anko.$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1  reason: invalid class name */
/* compiled from: CustomViews.kt */
final class C$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1 extends Lambda implements Function1<Context, ProgressBar> {
    public static final C$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1 INSTANCE = new C$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1();

    C$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1() {
        super(1);
    }

    public final ProgressBar invoke(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new ProgressBar(context, null, 16842872);
    }
}
