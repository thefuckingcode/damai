package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
public class bi2 extends a {
    public static final String PARSER_TAG = "tdcolor";

    private Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext) throws Exception {
        String a = qo1.a(objArr, 2, new Class[]{null, String.class});
        if (TextUtils.isEmpty(a)) {
            Object obj = objArr[0];
            String str = (String) objArr[1];
            if (obj == null) {
                return str;
            }
            String obj2 = obj.toString();
            if (xj.e(obj2, 0) == 0) {
                return str;
            }
            if (obj2.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                return obj2;
            }
            return obj2 + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
        }
        throw new RuntimeException(a);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        try {
            return a(objArr, dXRuntimeContext);
        } catch (Exception e) {
            tr2.b(PARSER_TAG, String.valueOf(objArr), e.toString(), String.valueOf(dXRuntimeContext));
            return null;
        }
    }
}
