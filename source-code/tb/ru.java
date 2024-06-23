package tb;

import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class ru extends a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMSUBARRAY = -3678511738734981180L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-586932410")) {
            return ipChange.ipc$dispatch("-586932410", new Object[]{this, objArr, dXRuntimeContext});
        }
        int a = xp.a(objArr);
        if (a <= 0) {
            return null;
        }
        if (a > 2) {
            try {
                Object obj = objArr[0];
                if (!(obj instanceof JSONArray)) {
                    return null;
                }
                JSONArray jSONArray = (JSONArray) obj;
                int b = c31.b(jSONArray);
                Object obj2 = objArr[1];
                if (obj2 instanceof String) {
                    i2 = xf2.l((String) obj2, 0);
                }
                Object obj3 = objArr[2];
                if (obj3 instanceof String) {
                    i = xf2.l((String) obj3, b);
                    int i3 = b - 1;
                    if (i > i3) {
                        i = i3;
                    }
                } else {
                    i = b;
                }
                if (i2 < 0 || i2 >= b || i <= i2) {
                    return jSONArray;
                }
                JSONArray jSONArray2 = new JSONArray();
                while (i2 <= i) {
                    jSONArray2.add(jSONArray.getJSONObject(i2));
                    i2++;
                }
                return jSONArray2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (a > 0) {
                return objArr[0];
            }
            return null;
        }
    }
}
