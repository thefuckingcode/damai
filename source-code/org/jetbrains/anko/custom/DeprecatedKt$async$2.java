package org.jetbrains.anko.custom;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.anko.AnkoAsyncContext;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 1, 11})
/* compiled from: Deprecated.kt */
final class DeprecatedKt$async$2<V> implements Callable<Unit> {
    final /* synthetic */ AnkoAsyncContext $context;
    final /* synthetic */ Function1 $task;

    DeprecatedKt$async$2(Function1 function1, AnkoAsyncContext ankoAsyncContext) {
        this.$task = function1;
        this.$context = ankoAsyncContext;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.$task.invoke(this.$context);
    }
}
