package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ih2 {
    private static final Map<String, String> a = new HashMap();

    public static boolean a(String str, boolean z) {
        String str2 = a.get(str);
        if (str2 != null) {
            try {
                return Boolean.valueOf(str2).booleanValue();
            } catch (Exception e) {
                s91.e(e);
            }
        }
        return z;
    }
}
