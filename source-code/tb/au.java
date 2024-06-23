package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class au extends a {
    public static final long DX_PARSER_ABS = 516202497;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null) {
            try {
                if (objArr.length == 1) {
                    Object obj = objArr[0];
                    if (!(obj instanceof Long)) {
                        if (!(obj instanceof Integer)) {
                            if (yy.c(obj)) {
                                return Double.valueOf(Math.abs(((Number) obj).doubleValue()));
                            }
                            if (!(obj instanceof String)) {
                                return 0L;
                            }
                            String str = (String) obj;
                            if (yy.b(str)) {
                                return Double.valueOf(Math.abs(Double.valueOf(str).doubleValue()));
                            }
                            return Long.valueOf(Math.abs(Long.valueOf(str).longValue()));
                        }
                    }
                    return Long.valueOf(Math.abs(((Number) obj).longValue()));
                }
            } catch (Throwable th) {
                vx.b(th);
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "abs";
    }
}
