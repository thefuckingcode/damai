package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
public class b00 extends gy {
    public static final long DX_PARSER_ROOTDATA = 6173462809577930310L;

    /* access modifiers changed from: protected */
    @Override // tb.gy
    public Object a(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getRootView() == null) {
            return null;
        }
        return dXRuntimeContext.getRootView().getData();
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "rootData";
    }
}
