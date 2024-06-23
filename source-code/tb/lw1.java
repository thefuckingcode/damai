package tb;

import com.youku.gaiax.js.impl.qjs.QuickJSRuntime;
import com.youku.gaiax.quickjs.JSRuntime;

/* compiled from: Taobao */
public final /* synthetic */ class lw1 implements JSRuntime.PromiseRejectionHandler {
    public static final /* synthetic */ lw1 a = new lw1();

    private /* synthetic */ lw1() {
    }

    @Override // com.youku.gaiax.quickjs.JSRuntime.PromiseRejectionHandler
    public final void onError(String str) {
        QuickJSRuntime.m901initRuntime$lambda2(str);
    }
}
