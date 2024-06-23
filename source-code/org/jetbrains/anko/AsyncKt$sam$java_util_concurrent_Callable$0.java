package org.jetbrains.anko;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
/* compiled from: Async.kt */
public final class AsyncKt$sam$java_util_concurrent_Callable$0 implements Callable {
    private final /* synthetic */ Function0 function;

    AsyncKt$sam$java_util_concurrent_Callable$0(Function0 function0) {
        this.function = function0;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.function.invoke();
    }
}
