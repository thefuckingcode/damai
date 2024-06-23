package tb;

import android.content.Context;
import com.taobao.dp.DeviceSecuritySDK;

/* compiled from: Taobao */
public class x81 {
    private static boolean a = true;

    public static String a(Context context) {
        if (context == null || !a) {
            return null;
        }
        try {
            int i = DeviceSecuritySDK.ENVIRONMENT_ONLINE;
            Object d = cz1.d(DeviceSecuritySDK.class, "getInstance", new Object[]{context}, Context.class);
            if (d == null) {
                return null;
            }
            Object a2 = cz1.a(d, "getSecurityToken");
            if (a2 != null) {
                String str = (String) a2;
            }
            return (String) a2;
        } catch (Exception unused) {
            return null;
        }
    }
}
