package tb;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.alibaba.android.ultron.trade.presenter.a;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public class ik2 extends v0 {
    public static final String PARSER_TAG = "theme";
    public static final String TYPE_COLOR = "color";
    public static final String TYPE_GRADIENT = "gradient";
    public static final String TYPE_SIZE = "size";
    public static final String TYPE_STRING = "string";

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        jk2 jk2;
        String valueOf;
        String str = null;
        if (list == null || list.size() < 3) {
            return null;
        }
        if (x70 != null && (x70.b() instanceof Map)) {
            Object obj = ((Map) x70.b()).get(a.DINAMIC_CONTEXT_KEY_PRESENTER);
            if (obj instanceof a) {
                jk2 = ((a) obj).getThemeManager();
                valueOf = String.valueOf(list.get(0));
                String valueOf2 = String.valueOf(list.get(1));
                String valueOf3 = String.valueOf(list.get(2));
                List<String> c = jk2 == null ? jk2.c(valueOf2) : null;
                if (!"gradient".equalsIgnoreCase(valueOf)) {
                    GradientDrawable a = xj.a(c);
                    if (a != null) {
                        return a;
                    }
                    if (!TextUtils.isEmpty(valueOf3)) {
                        return xj.c(valueOf3.split(SymbolExpUtil.SYMBOL_VERTICALBAR));
                    }
                    return null;
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
                } else if (!"string".equalsIgnoreCase(valueOf) || c == null || c.size() <= 0) {
                    return null;
                } else {
                    return c.get(0);
                }
            }
        }
        jk2 = null;
        valueOf = String.valueOf(list.get(0));
        String valueOf22 = String.valueOf(list.get(1));
        String valueOf32 = String.valueOf(list.get(2));
        if (jk2 == null) {
        }
        if (!"gradient".equalsIgnoreCase(valueOf)) {
        }
    }
}
