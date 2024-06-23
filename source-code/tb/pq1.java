package tb;

import android.text.TextUtils;
import java.util.List;

/* compiled from: Taobao */
public class pq1 extends v0 {
    public static final String PARSER_TAG = "platform";

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        if (list == null || list.size() < 1) {
            return Boolean.FALSE;
        }
        String valueOf = String.valueOf(list.get(0));
        if (TextUtils.isEmpty(valueOf)) {
            return Boolean.FALSE;
        }
        if ("Android".equalsIgnoreCase(valueOf)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
