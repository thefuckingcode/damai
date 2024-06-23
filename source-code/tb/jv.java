package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
public class jv extends gy {
    /* access modifiers changed from: protected */
    @Override // tb.gy
    public Object a(DXRuntimeContext dXRuntimeContext) {
        q a;
        qx eventChainExpressionSourceContext = dXRuntimeContext.getEventChainExpressionSourceContext();
        if (eventChainExpressionSourceContext == null || (a = eventChainExpressionSourceContext.a()) == null) {
            return null;
        }
        return a.b();
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "getChainStorage";
    }
}
