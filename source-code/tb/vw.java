package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class vw extends a {
    public static final long DX_PARSER_TOBINDINGXUNIT = 6677129169796262308L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        int i;
        if (objArr != null) {
            try {
                if (objArr.length == 1) {
                    Object obj = objArr[0];
                    if (obj instanceof Number) {
                        return Integer.valueOf(d00.b(DinamicXEngine.i(), ((Number) obj).floatValue()));
                    }
                    if (!(obj instanceof String)) {
                        return 0;
                    }
                    String str = (String) obj;
                    if (str.endsWith("ap")) {
                        i = d00.b(DinamicXEngine.i(), Float.parseFloat(str.substring(0, str.length() - 2)));
                    } else if (!str.endsWith(f80.DIMEN_SUFFIX_NP)) {
                        return Integer.valueOf(d00.b(DinamicXEngine.i(), Float.valueOf(str).floatValue()));
                    } else {
                        i = d00.c(DinamicXEngine.i(), Float.parseFloat(str.substring(0, str.length() - 2)));
                    }
                    return Integer.valueOf(i);
                }
            } catch (Throwable unused) {
                return 0;
            }
        }
        return 0;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "toBindingXUnit";
    }
}
