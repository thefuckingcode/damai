package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
public class nx extends gy {
    public static final long DX_PARSER_EVENTCHAINDATA = 1597069669224900237L;

    /* access modifiers changed from: protected */
    @Override // tb.gy
    public Object a(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getEventChainExpressionSourceContext() == null) {
            return null;
        }
        return dXRuntimeContext.getEventChainExpressionSourceContext().c();
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "eventChainData";
    }
}
