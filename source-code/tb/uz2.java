package tb;

import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
public class uz2 {
    public static final byte[] a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return tz2.j(obj);
        } catch (Exception e) {
            WXLogUtils.e("weex wson to wson error ", e);
            return null;
        }
    }
}
