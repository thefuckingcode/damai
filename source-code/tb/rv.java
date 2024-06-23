package tb;

import com.alibaba.fastjson.JSONArray;

/* compiled from: Taobao */
public class rv extends qv {
    /* access modifiers changed from: protected */
    @Override // tb.qv
    public int a(JSONArray jSONArray, Object obj) {
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            if (jSONArray.get(i).equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, tb.qv, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "index_of_value";
    }
}
