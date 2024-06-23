package tb;

import com.youku.gaiax.js.impl.qjs.QuickJSRuntime;
import com.youku.gaiax.quickjs.JSRuntime;

/* compiled from: Taobao */
public final /* synthetic */ class kw1 implements JSRuntime.InterruptHandler {
    public static final /* synthetic */ kw1 a = new kw1();

    private /* synthetic */ kw1() {
    }

    @Override // com.youku.gaiax.quickjs.JSRuntime.InterruptHandler
    public final boolean onInterrupt() {
        return QuickJSRuntime.m902initRuntime$lambda3();
    }
}
