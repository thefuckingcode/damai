package tb;

import cn.damai.common.image.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
public class su extends a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMTOWEBP = -7411709743744784406L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863633860")) {
            return ipChange.ipc$dispatch("863633860", new Object[]{this, objArr, dXRuntimeContext});
        } else if (objArr == null || objArr.length == 0) {
            return null;
        } else {
            Object obj = objArr[0];
            if (obj == null || (!(obj instanceof String) && !(obj instanceof CharSequence))) {
                return obj;
            }
            String str = (String) obj;
            if (xf2.j(str)) {
                return obj;
            }
            if (!b.e()) {
                return str;
            }
            if (xp.a(objArr) >= 2) {
                String str2 = (String) objArr[1];
                if (xf2.j(str2) || !str2.contains(Constants.Name.X) || str2.split(Constants.Name.X).length != 2) {
                    return str;
                }
                try {
                    String[] split = str2.split(Constants.Name.X);
                    return String.format("%s%s%sx%s", str, "?optParams=", Integer.valueOf(v50.a(dXRuntimeContext.getContext(), (float) Integer.parseInt(split[0]))), Integer.valueOf(v50.a(dXRuntimeContext.getContext(), (float) Integer.parseInt(split[1]))));
                } catch (Exception e) {
                    g91.b("DXDataParserDMToWebp", e.getMessage());
                    return str;
                }
            } else {
                return String.format("%s%s%s", str, "?optParams=", "-1x-1");
            }
        }
    }
}
