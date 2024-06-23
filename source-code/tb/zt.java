package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.d;
import com.taobao.android.dinamicx.eventchain.b;

/* compiled from: Taobao */
public class zt extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_ABILITYHUB = -8392059985777200873L;

    /* compiled from: Taobao */
    class a implements AKIAbilityCallback {
        a(zt ztVar) {
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, l lVar) {
        }
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DinamicXEngine e;
        b o;
        h j;
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject(0);
        d engineContext = dXRuntimeContext.getEngineContext();
        if (!(engineContext == null || (e = engineContext.e()) == null || (o = e.o()) == null || (j = o.j()) == null || objArr == null || objArr.length < 1 || !(objArr[0] instanceof String))) {
            String str = (String) objArr[0];
            if (objArr.length <= 1 || !(objArr[1] instanceof JSONObject)) {
                jSONObject = new JSONObject(0);
            } else {
                jSONObject = (JSONObject) objArr[1];
            }
            JSONObject jSONObject3 = new JSONObject(2);
            jSONObject3.put("type", (Object) str);
            jSONObject3.put("params", (Object) jSONObject);
            d10 d10 = new d10();
            d10.e(dXRuntimeContext.getContext());
            d10.g(dXRuntimeContext.getNativeView());
            d10.d(j);
            d10.i(dXRuntimeContext.getRootView());
            d10.j(dXRuntimeContext.getWidgetNode());
            l a2 = j.a(jSONObject3, d10, new a(this));
            if (a2 instanceof o) {
                return a2.a();
            }
        }
        return jSONObject2;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "abilityHub";
    }
}
