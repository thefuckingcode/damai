package org.jetbrains.anko;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "run"}, k = 3, mv = {1, 1, 11})
/* compiled from: Async.kt */
final class AsyncKt$onComplete$1 implements Runnable {
    final /* synthetic */ Function1 $f;
    final /* synthetic */ Object $ref;

    AsyncKt$onComplete$1(Function1 function1, Object obj) {
        this.$f = function1;
        this.$ref = obj;
    }

    public final void run() {
        this.$f.invoke(this.$ref);
    }
}
