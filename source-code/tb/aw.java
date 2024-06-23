package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class aw extends a {
    public static final long DX_PARSER_MAX = 523333521;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object a = xy.a(objArr, 1);
        if (!(a instanceof Boolean)) {
            return null;
        }
        if (((Boolean) a).booleanValue()) {
            return yy.h(objArr[0]);
        }
        return yy.h(objArr[1]);
    }
}
