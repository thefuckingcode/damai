package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class tu extends a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMTRANSFERARRAY = 3246970341203680996L;

    private List<Object> a(Object[] objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-73840510")) {
            return (List) ipChange.ipc$dispatch("-73840510", new Object[]{this, objArr});
        }
        ArrayList arrayList = new ArrayList();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            Object obj2 = "";
            if (obj == null) {
                obj = obj2;
            }
            if (obj instanceof JSONArray) {
                arrayList.addAll(a(((JSONArray) obj).toArray()));
            } else {
                if (!(obj instanceof String) || !TextUtils.isEmpty((String) obj)) {
                    obj2 = obj;
                }
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589517365")) {
            return ipChange.ipc$dispatch("1589517365", new Object[]{this, objArr, dXRuntimeContext});
        } else if (objArr == null || objArr.length <= 0) {
            return null;
        } else {
            return new JSONArray(a(objArr));
        }
    }
}
