package com.youku.gaiax.js.impl.qjs.module;

import com.youku.gaiax.quickjs.JSContext;
import com.youku.gaiax.quickjs.JSFunction;
import com.youku.gaiax.quickjs.JSValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class QuickJSTimer$SetTimeout$invoke$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ JSFunction $func;
    final /* synthetic */ JSContext $jsContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuickJSTimer$SetTimeout$invoke$1(JSFunction jSFunction, JSContext jSContext) {
        super(0);
        this.$func = jSFunction;
        this.$jsContext = jSContext;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.$func.invoke(this.$jsContext.createJSUndefined(), new JSValue[0]);
    }
}
