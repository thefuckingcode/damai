package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class xw extends a {
    public static final long DX_PARSER_TODOUBLE = 6762231815649095238L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null) {
            try {
                if (objArr.length == 1) {
                    Object obj = objArr[0];
                    if (obj instanceof Number) {
                        return Double.valueOf(((Number) obj).doubleValue());
                    }
                    if (!(obj instanceof String)) {
                        return Double.valueOf(0.0d);
                    }
                    try {
                        return Double.valueOf(Double.parseDouble((String) obj));
                    } catch (Throwable unused) {
                        return Double.valueOf(0.0d);
                    }
                }
            } catch (Exception unused2) {
                return Double.valueOf(0.0d);
            }
        }
        return Double.valueOf(0.0d);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "toDouble";
    }
}
