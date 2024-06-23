package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import android.os.Build;
import android.widget.RatingBar;
import androidx.appcompat.widget.AppCompatRatingBar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/widget/RatingBar;", "ctx", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 1, 11})
/* renamed from: org.jetbrains.anko.appcompat.v7.$$Anko$Factories$AppcompatV7View$TINTED_RATING_BAR$1  reason: invalid class name */
/* compiled from: Views.kt */
final class C$$Anko$Factories$AppcompatV7View$TINTED_RATING_BAR$1 extends Lambda implements Function1<Context, RatingBar> {
    public static final C$$Anko$Factories$AppcompatV7View$TINTED_RATING_BAR$1 INSTANCE = new C$$Anko$Factories$AppcompatV7View$TINTED_RATING_BAR$1();

    C$$Anko$Factories$AppcompatV7View$TINTED_RATING_BAR$1() {
        super(1);
    }

    public final RatingBar invoke(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return Build.VERSION.SDK_INT < 21 ? new AppCompatRatingBar(context) : new RatingBar(context);
    }
}
