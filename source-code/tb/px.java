package tb;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
public class px extends gy {
    public static final long DX_PARSER_EVENTCHAINEVENTDATA = 5680234302234270868L;

    /* access modifiers changed from: protected */
    @Override // tb.gy
    public Object a(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getEventChainExpressionSourceContext() == null) {
            return null;
        }
        return dXRuntimeContext.getEventChainExpressionSourceContext().d();
    }

    /* access modifiers changed from: protected */
    public JSONObject d(@NonNull lx lxVar) {
        return g31.f(lxVar, true, lx.class);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, tb.gy, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object evalWithArgs = super.evalWithArgs(objArr, dXRuntimeContext);
        if (evalWithArgs != null) {
            return evalWithArgs;
        }
        if (!at.e0() || dXRuntimeContext == null || dXRuntimeContext.getEventChainExpressionSourceContext() == null) {
            return null;
        }
        lx b = dXRuntimeContext.getEventChainExpressionSourceContext().b();
        if (objArr == null || objArr.length == 0 || !(objArr[0] instanceof String) || b == null) {
            return new JSONObject();
        }
        return b((String) objArr[0], d(b), dXRuntimeContext);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "eventChainEventData";
    }
}
