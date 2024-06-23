package tb;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class ww extends a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_TOCOMPUTEPX = 3196568048963202419L;

    private int a(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1634283037")) {
            return ((Integer) ipChange.ipc$dispatch("1634283037", new Object[]{this, context, str})).intValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.endsWith("ap")) {
                return d00.b(context, (float) Integer.parseInt(str.replace("ap", "")));
            }
            if (str.endsWith(f80.DIMEN_SUFFIX_NP)) {
                return d00.c(context, (float) Integer.parseInt(str.replace(f80.DIMEN_SUFFIX_NP, "")));
            }
            return 0;
        } catch (Exception e) {
            g91.b("DXDataParserToComputePX", e.getMessage());
        }
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618858828")) {
            return ipChange.ipc$dispatch("-1618858828", new Object[]{this, objArr, dXRuntimeContext});
        } else if (objArr == null || objArr.length == 0) {
            return null;
        } else {
            Object obj = objArr[0];
            if (!(obj instanceof String)) {
                return "0np";
            }
            String str = (String) obj;
            if (TextUtils.isEmpty(str) || !str.contains("-")) {
                return "0np";
            }
            String[] split = str.split("-");
            if (xp.a(split) < 2) {
                return "0np";
            }
            int a = a(dXRuntimeContext.getContext(), split[0]);
            int a2 = a(dXRuntimeContext.getContext(), split[1]);
            return v50.e(dXRuntimeContext.getContext(), (float) (a - a2)) + f80.DIMEN_SUFFIX_NP;
        }
    }
}
