package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.config.IDXConfigInterface;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class iw extends a {
    public static final long DX_DATA_PARSER_ORANGE = 2060908603279329344L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IDXConfigInterface b;
        String str = null;
        if (objArr == null || objArr.length < 2 || !(objArr[0] instanceof String) || !(objArr[1] instanceof String) || (b = DXGlobalCenter.b()) == null) {
            return null;
        }
        String str2 = (String) objArr[0];
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = (String) objArr[1];
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        Object obj = objArr.length >= 3 ? objArr[2] : null;
        if (obj != null) {
            str = obj.toString();
        }
        return b.getConfig(str2, str3, str);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "dxOrange";
    }
}
