package com.youku.gaiax.provider.module.js;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class JSDelegate$startEngine$2 extends Lambda implements Function0<ur2> {
    final /* synthetic */ Function0<ur2> $callback;
    final /* synthetic */ JSDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JSDelegate$startEngine$2(JSDelegate jSDelegate, Function0<ur2> function0) {
        super(0);
        this.this$0 = jSDelegate;
        this.$callback = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        JSDelegate jSDelegate = this.this$0;
        jSDelegate.jsEngineStatus = jSDelegate.jsEngineStatus << 1;
        this.$callback.invoke();
    }
}
