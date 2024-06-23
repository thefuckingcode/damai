package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class zw extends a {
    public static final long DX_PARSER_TOSTR = 19624365692481L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        long j;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    if (objArr.length <= 2) {
                        Object obj = objArr[0];
                        if (obj instanceof String) {
                            return obj;
                        }
                        if (objArr.length != 1 && !(obj instanceof Integer)) {
                            if (!(obj instanceof Long)) {
                                if (!(obj instanceof Number)) {
                                    return "";
                                }
                                Object obj2 = objArr[1];
                                if (obj2 instanceof Number) {
                                    j = ((Number) obj2).longValue();
                                } else {
                                    try {
                                        j = Double.valueOf(obj2.toString()).longValue();
                                    } catch (Throwable th) {
                                        vx.b(th);
                                        j = 0;
                                    }
                                }
                                if (j < 0) {
                                    return obj.toString();
                                }
                                return String.format("%." + j + "f", Double.valueOf(((Number) obj).doubleValue()));
                            }
                        }
                        return obj.toString();
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "toStr";
    }
}
