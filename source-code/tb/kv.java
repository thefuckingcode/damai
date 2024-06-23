package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.d;
import com.taobao.android.dinamicx.eventchain.b;

/* compiled from: Taobao */
public class kv extends gy {
    /* access modifiers changed from: protected */
    @Override // tb.gy
    public Object a(DXRuntimeContext dXRuntimeContext) {
        DinamicXEngine e;
        b o;
        h j;
        d engineContext = dXRuntimeContext.getEngineContext();
        if (engineContext == null || (e = engineContext.e()) == null || (o = e.o()) == null || (j = o.j()) == null) {
            return null;
        }
        return j.d();
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "getEngineStorage";
    }
}
