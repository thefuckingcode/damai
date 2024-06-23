package tb;

import com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule;
import com.youku.gaiax.quickjs.JSFunction;
import com.youku.gaiax.quickjs.PromiseExecutor;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Taobao */
public final /* synthetic */ class jw1 implements PromiseExecutor {
    public final /* synthetic */ Ref$ObjectRef a;
    public final /* synthetic */ Ref$ObjectRef b;

    public /* synthetic */ jw1(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
        this.a = ref$ObjectRef;
        this.b = ref$ObjectRef2;
    }

    @Override // com.youku.gaiax.quickjs.PromiseExecutor
    public final void execute(JSFunction jSFunction, JSFunction jSFunction2) {
        QuickJSBridgeModule.m903callPromise$lambda0(this.a, this.b, jSFunction, jSFunction2);
    }
}
