package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class ou extends a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMNUMBERFORMAT = -2092015216107125647L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object obj;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110196461")) {
            return ipChange.ipc$dispatch("110196461", new Object[]{this, objArr, dXRuntimeContext});
        }
        if (objArr == null || objArr.length == 0 || (obj = objArr[0]) == null || !(obj instanceof String)) {
            return "";
        }
        String str = (String) obj;
        if (xf2.j(str)) {
            return "";
        }
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i <= 0) {
            return "";
        }
        if (i < 10000) {
            return str;
        }
        if (i % 10000 > 0) {
            return String.format("%s万", Double.valueOf(Math.floor(((((double) i) * 1.0d) / 10000.0d) * 10.0d) / 10.0d));
        }
        return String.format("%s万", Integer.valueOf(i / 10000));
    }
}
