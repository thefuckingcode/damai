package org.jetbrains.anko;

import android.content.Context;
import android.media.tv.TvView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/media/tv/TvView;", "ctx", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 1, 11})
/* renamed from: org.jetbrains.anko.$$Anko$Factories$Sdk27View$TV_VIEW$1  reason: invalid class name */
/* compiled from: Views.kt */
final class C$$Anko$Factories$Sdk27View$TV_VIEW$1 extends Lambda implements Function1<Context, TvView> {
    public static final C$$Anko$Factories$Sdk27View$TV_VIEW$1 INSTANCE = new C$$Anko$Factories$Sdk27View$TV_VIEW$1();

    C$$Anko$Factories$Sdk27View$TV_VIEW$1() {
        super(1);
    }

    public final TvView invoke(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new TvView(context);
    }
}
