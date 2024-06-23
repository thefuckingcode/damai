package tb;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public class ei2 extends a {
    public static final String PARSER_TAG = "theme";
    public static final String TYPE_COLOR = "color";
    public static final String TYPE_GRADIENT = "gradient";
    public static final String TYPE_SIZE = "size";
    public static final String TYPE_STRING = "string";

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    private Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext) throws Exception {
        jk2 jk2;
        String valueOf;
        String str = null;
        if (objArr != null && objArr.length >= 3) {
            if (dXRuntimeContext != null && (dXRuntimeContext.getDxUserContext() instanceof Map)) {
                Object obj = ((Map) dXRuntimeContext.getDxUserContext()).get(com.alibaba.android.ultron.trade.presenter.a.DINAMIC_CONTEXT_KEY_PRESENTER);
                if (obj instanceof com.alibaba.android.ultron.trade.presenter.a) {
                    jk2 = ((com.alibaba.android.ultron.trade.presenter.a) obj).getThemeManager();
                    valueOf = String.valueOf(objArr[0]);
                    String valueOf2 = String.valueOf(objArr[1]);
                    String valueOf3 = String.valueOf(objArr[2]);
                    List<String> c = jk2 == null ? jk2.c(valueOf2) : null;
                    if (!"gradient".equalsIgnoreCase(valueOf)) {
                        GradientDrawable a = xj.a(c);
                        if (a != null) {
                            return a;
                        }
                        if (!TextUtils.isEmpty(valueOf3)) {
                            return xj.c(valueOf3.split(SymbolExpUtil.SYMBOL_VERTICALBAR));
                        }
                    } else if ("color".equalsIgnoreCase(valueOf)) {
                        if (c != null && c.size() > 0) {
                            str = c.get(0);
                        }
                        return xj.e(str, -1) != -1 ? str : valueOf3;
                    } else if ("size".equalsIgnoreCase(valueOf)) {
                        if (c == null || c.size() <= 0) {
                            return valueOf3;
                        }
                        String str2 = c.get(0);
                        return f80.b(str2) ? f80.a(str2) : valueOf3;
                    } else if ("string".equalsIgnoreCase(valueOf)) {
                        if (c != null && c.size() > 0) {
                            str = c.get(0);
                        }
                        return TextUtils.isEmpty(str) ? valueOf3 : str;
                    }
                }
            }
            jk2 = null;
            valueOf = String.valueOf(objArr[0]);
            String valueOf22 = String.valueOf(objArr[1]);
            String valueOf32 = String.valueOf(objArr[2]);
            if (jk2 == null) {
            }
            if (!"gradient".equalsIgnoreCase(valueOf)) {
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        try {
            return a(objArr, dXRuntimeContext);
        } catch (Exception e) {
            tr2.b("theme", String.valueOf(objArr), e.toString(), String.valueOf(dXRuntimeContext));
            return null;
        }
    }
}
