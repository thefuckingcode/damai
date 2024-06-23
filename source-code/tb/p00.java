package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import java.util.StringTokenizer;

/* compiled from: Taobao */
public class p00 extends a {
    private Object a(DXRuntimeContext dXRuntimeContext, Object obj, String str) {
        if (obj == null || str == null) {
            return null;
        }
        return gx.a(dXRuntimeContext, obj, str);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object subData = dXRuntimeContext.getSubData();
        if (!(objArr == null || objArr.length == 0)) {
            if (objArr.length > 1) {
                return null;
            }
            Object obj = objArr[0];
            if (!(obj instanceof String)) {
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer((String) obj, " .[]", false);
            while (stringTokenizer.hasMoreTokens()) {
                subData = a(dXRuntimeContext, subData, stringTokenizer.nextToken());
            }
        }
        return subData;
    }
}
