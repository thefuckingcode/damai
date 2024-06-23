package com.youku.gaiax.js.impl.qjs.module;

import com.youku.gaiax.quickjs.JSFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class QuickJSBridgeModule$callPromise$1$resolve$1$invoke$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ Ref$ObjectRef<JSFunction> $jsResolve;
    final /* synthetic */ Object $result;
    final /* synthetic */ QuickJSBridgeModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuickJSBridgeModule$callPromise$1$resolve$1$invoke$1(Ref$ObjectRef<JSFunction> ref$ObjectRef, QuickJSBridgeModule quickJSBridgeModule, Object obj) {
        super(0);
        this.$jsResolve = ref$ObjectRef;
        this.this$0 = quickJSBridgeModule;
        this.$result = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        T t = this.$jsResolve.element;
        if (t != null) {
            t.invoke(null, this.this$0.arrayOfJSValues(this.$result));
        }
    }
}
