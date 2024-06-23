package org.jetbrains.anko;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroid/app/Activity;", "run"}, k = 3, mv = {1, 1, 11})
/* compiled from: Async.kt */
final class AsyncKt$activityUiThread$2 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function1 $f;

    AsyncKt$activityUiThread$2(Function1 function1, Activity activity) {
        this.$f = function1;
        this.$activity = activity;
    }

    public final void run() {
        this.$f.invoke(this.$activity);
    }
}
