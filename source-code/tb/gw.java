package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class gw extends a {
    public static final Object DEFAULT_VALUE = null;
    public static final long DX_PARSER_NOTEQUAL = 4995563293267863121L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null) {
            try {
                if (objArr.length == 2) {
                    boolean z = false;
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    if (obj == null && obj2 == null) {
                        return Boolean.FALSE;
                    }
                    if (obj != null) {
                        if (obj2 != null) {
                            if (obj.getClass().equals(obj2.getClass())) {
                                if (!obj.equals(obj2)) {
                                    z = true;
                                }
                                return Boolean.valueOf(z);
                            } else if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
                                if (!obj.equals(obj2)) {
                                    z = true;
                                }
                                return Boolean.valueOf(z);
                            } else {
                                if (!yy.a((Number) obj, (Number) obj2)) {
                                    z = true;
                                }
                                return Boolean.valueOf(z);
                            }
                        }
                    }
                    return Boolean.TRUE;
                }
            } catch (Throwable unused) {
                return DEFAULT_VALUE;
            }
        }
        return DEFAULT_VALUE;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "notEqual";
    }
}
