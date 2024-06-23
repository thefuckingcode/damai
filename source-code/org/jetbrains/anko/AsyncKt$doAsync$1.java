package org.jetbrains.anko;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 1, 11})
/* compiled from: Async.kt */
final class AsyncKt$doAsync$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AnkoAsyncContext $context;
    final /* synthetic */ Function1 $exceptionHandler;
    final /* synthetic */ Function1 $task;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AsyncKt$doAsync$1(Function1 function1, AnkoAsyncContext ankoAsyncContext, Function1 function12) {
        super(0);
        this.$task = function1;
        this.$context = ankoAsyncContext;
        this.$exceptionHandler = function12;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        try {
            Unit unit = (Unit) this.$task.invoke(this.$context);
        } catch (Throwable th) {
            Function1 function1 = this.$exceptionHandler;
            if ((function1 != null ? (Unit) function1.invoke(th) : null) == null) {
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }
}
