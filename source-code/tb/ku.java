package tb;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class ku extends a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMADAPTIVEHEIGHT = -1525552786972270296L;

    private int a(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858466887")) {
            return ((Integer) ipChange.ipc$dispatch("858466887", new Object[]{this, context, str})).intValue();
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
            g91.b("DXDataParserDMAdaptiveHeight", e.getMessage());
        }
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369700938")) {
            return ipChange.ipc$dispatch("1369700938", new Object[]{this, objArr, dXRuntimeContext});
        } else if (objArr == null || objArr.length == 0) {
            return null;
        } else {
            Object obj = objArr[0];
            if (!(obj instanceof String)) {
                return obj;
            }
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return obj;
            }
            int a = a(dXRuntimeContext.getContext(), str);
            g91.b("DXDataParserDMAdaptiveHeight", "realHeight = " + a + f80.DIMEN_SUFFIX_NP);
            int c = v50.c(dXRuntimeContext.getContext(), a);
            g91.b("DXDataParserDMAdaptiveHeight", "adaptiveHeightPx = " + c + "px");
            int e = v50.e(dXRuntimeContext.getContext(), (float) c);
            g91.b("DXDataParserDMAdaptiveHeight", "adaptiveHeightNp = " + e + f80.DIMEN_SUFFIX_NP);
            return e + f80.DIMEN_SUFFIX_NP;
        }
    }
}
