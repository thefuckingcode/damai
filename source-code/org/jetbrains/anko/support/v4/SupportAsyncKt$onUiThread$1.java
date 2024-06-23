package org.jetbrains.anko.support.v4;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 11})
/* compiled from: SupportAsync.kt */
public final class SupportAsyncKt$onUiThread$1 implements Runnable {
    final /* synthetic */ Function0 $f;

    public SupportAsyncKt$onUiThread$1(Function0 function0) {
        this.$f = function0;
    }

    public final void run() {
        this.$f.invoke();
    }
}
