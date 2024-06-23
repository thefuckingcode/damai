package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
public class oy extends gy {
    /* access modifiers changed from: protected */
    @Override // tb.gy
    public Object a(DXRuntimeContext dXRuntimeContext) {
        qx eventChainExpressionSourceContext = dXRuntimeContext.getEventChainExpressionSourceContext();
        if (eventChainExpressionSourceContext == null) {
            return null;
        }
        return eventChainExpressionSourceContext.e();
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "lastdata";
    }
}
