package com.youku.gaiax.js.impl.qjs.module;

import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.quickjs.JSFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/youku/gaiax/js/impl/qjs/module/QuickJSBridgeModule$callPromise$1$resolve$1", "Lcom/youku/gaiax/js/api/IGaiaXCallback;", "", "result", "Ltb/ur2;", "invoke", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class QuickJSBridgeModule$callPromise$1$resolve$1 implements IGaiaXCallback {
    final /* synthetic */ Ref$ObjectRef<JSFunction> $jsResolve;
    final /* synthetic */ QuickJSBridgeModule this$0;

    QuickJSBridgeModule$callPromise$1$resolve$1(Ref$ObjectRef<JSFunction> ref$ObjectRef, QuickJSBridgeModule quickJSBridgeModule) {
        this.$jsResolve = ref$ObjectRef;
        this.this$0 = quickJSBridgeModule;
    }

    @Override // com.youku.gaiax.js.api.IGaiaXCallback
    public void invoke(@Nullable Object obj) {
        GaiaXJS.Companion.getInstance().executeTask(new QuickJSBridgeModule$callPromise$1$resolve$1$invoke$1(this.$jsResolve, this.this$0, obj));
    }
}
