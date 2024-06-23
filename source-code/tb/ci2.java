package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class ci2 extends a {
    public static final String PARSER_TAG = "tdPlatform";

    private Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext) throws Exception {
        String a = po1.a(objArr, 1, new Class[]{String.class});
        if (!TextUtils.isEmpty(a)) {
            throw new RuntimeException(a);
        } else if ("Android".equalsIgnoreCase(((String) objArr[0]).trim())) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        try {
            return a(objArr, dXRuntimeContext);
        } catch (Exception unused) {
            return null;
        }
    }
}
