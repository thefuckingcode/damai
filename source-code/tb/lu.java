package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class lu extends a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMINDEX = 3573405303639617424L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1466202841")) {
            return ipChange.ipc$dispatch("1466202841", new Object[]{this, objArr, dXRuntimeContext});
        } else if (objArr == null || objArr.length == 0) {
            return "-1";
        } else {
            Object obj = objArr[0];
            int i = -1;
            int l = (obj == null || !(obj instanceof String)) ? -1 : xf2.l((String) obj, -1);
            if (l <= 0) {
                return "-1";
            }
            Object obj2 = null;
            int i2 = 0;
            while (true) {
                if (dXRuntimeContext == null) {
                    break;
                }
                if (!(dXRuntimeContext.getSubData() == null || obj2 == dXRuntimeContext.getSubData())) {
                    obj2 = dXRuntimeContext.getSubData();
                    i2++;
                    if (i2 == l) {
                        i = dXRuntimeContext.getSubdataIndex();
                        break;
                    }
                }
                dXRuntimeContext = (dXRuntimeContext.getWidgetNode() == null || dXRuntimeContext.getWidgetNode().getParentWidget() == null) ? null : dXRuntimeContext.getWidgetNode().getParentWidget().getDXRuntimeContext();
            }
            return String.format("%s", Integer.valueOf(i));
        }
    }
}
