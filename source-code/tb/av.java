package tb;

import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.IDXHardwareInterface;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class av extends a {
    public static final long DX_PARSER_DXDEVICELEVEL = 3863236816138429745L;
    public static final String PARAM_LEVEL_HIGH = "high";
    public static final String PARAM_LEVEL_LOW = "low";
    public static final String PARAM_LEVEL_MEDIUM = "medium";
    public static final String PARAM_LEVEL_UNKNOWN = "unknown";

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr == null || objArr.length == 0) {
            return Boolean.FALSE;
        }
        IDXHardwareInterface c = DXGlobalCenter.c();
        if (c == null) {
            return Boolean.FALSE;
        }
        boolean z = false;
        Object obj = objArr[0];
        if (!(obj instanceof String)) {
            return Boolean.FALSE;
        }
        String lowerCase = ((String) obj).toLowerCase();
        try {
            int deviceLevel = c.getDeviceLevel();
            if ("low".equals(lowerCase)) {
                if (deviceLevel == 2) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (PARAM_LEVEL_MEDIUM.equals(lowerCase)) {
                if (deviceLevel == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if ("high".equals(lowerCase)) {
                if (deviceLevel == 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (!"unknown".equals(lowerCase)) {
                return Boolean.FALSE;
            } else {
                if (deviceLevel == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
