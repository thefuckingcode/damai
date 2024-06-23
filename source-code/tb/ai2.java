package tb;

import android.text.TextUtils;
import com.taobao.android.sopatch.common.Constants;

/* compiled from: Taobao */
public class ai2 {
    private static final nc2 a = new nc2();

    public static void a(String str) {
        if (ih2.a(Constants.NEED_SO_PATCH, false) && !TextUtils.isEmpty(str)) {
            a.b(str);
        }
    }
}
