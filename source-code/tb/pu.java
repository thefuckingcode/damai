package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class pu extends a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMOSTYPE = -7411732534807036195L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1762098005")) {
            return "2";
        }
        return ipChange.ipc$dispatch("-1762098005", new Object[]{this, objArr, dXRuntimeContext});
    }
}
