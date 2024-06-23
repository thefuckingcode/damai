package com.youku.gaiax.js.impl.qjs.module;

import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.IGaiaXPromise;
import com.youku.gaiax.quickjs.JSFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/youku/gaiax/js/impl/qjs/module/QuickJSBridgeModule$callPromise$1", "Lcom/youku/gaiax/js/api/IGaiaXPromise;", "Lcom/youku/gaiax/js/api/IGaiaXCallback;", "resolve", "reject", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class QuickJSBridgeModule$callPromise$1 implements IGaiaXPromise {
    final /* synthetic */ Ref$ObjectRef<JSFunction> $jsReject;
    final /* synthetic */ Ref$ObjectRef<JSFunction> $jsResolve;
    final /* synthetic */ QuickJSBridgeModule this$0;

    QuickJSBridgeModule$callPromise$1(Ref$ObjectRef<JSFunction> ref$ObjectRef, QuickJSBridgeModule quickJSBridgeModule, Ref$ObjectRef<JSFunction> ref$ObjectRef2) {
        this.$jsResolve = ref$ObjectRef;
        this.this$0 = quickJSBridgeModule;
        this.$jsReject = ref$ObjectRef2;
    }

    @Override // com.youku.gaiax.js.api.IGaiaXPromise
    @NotNull
    public IGaiaXCallback reject() {
        return new QuickJSBridgeModule$callPromise$1$reject$1(this.$jsReject, this.this$0);
    }

    @Override // com.youku.gaiax.js.api.IGaiaXPromise
    @NotNull
    public IGaiaXCallback resolve() {
        return new QuickJSBridgeModule$callPromise$1$resolve$1(this.$jsResolve, this.this$0);
    }
}
