package tb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.responsive.IConfig;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;

/* compiled from: Taobao */
public class d70 {
    private static int a = -1;
    private static int b = -1;
    private static int c = -1;
    private static int d = -1;

    public static void a() {
        if (d == -1) {
            d = i() ? 1 : 0;
        }
    }

    public static double b(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        if (context == null || (windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0.0d;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        float f = displayMetrics.xdpi;
        if (f <= 0.0f || displayMetrics.ydpi <= 0.0f) {
            return 0.0d;
        }
        return Math.sqrt(Math.pow((double) (((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)) / f), 2.0d) + Math.pow((double) (((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)) / displayMetrics.ydpi), 2.0d));
    }

    public static boolean c() {
        return k() || d();
    }

    public static boolean d() {
        if (d == -1) {
            a();
        }
        return d == 1;
    }

    public static boolean e(Activity activity) {
        if (activity == null) {
            return false;
        }
        return f(activity.getResources().getConfiguration());
    }

    public static boolean f(Configuration configuration) {
        if (configuration == null) {
            return false;
        }
        String configuration2 = configuration.toString();
        if (configuration2.contains("hwMultiwindow-magic") || configuration2.contains("hw-magic-windows")) {
            return true;
        }
        return false;
    }

    public static boolean g(Context context) {
        if (a == -1) {
            if (!h(context)) {
                IConfig a2 = x02.c().a();
                if (a2 == null || !a2.hitFold()) {
                    a = 0;
                } else {
                    a = 1;
                }
            } else {
                a = 1;
            }
        }
        if (a == 1) {
            return true;
        }
        return false;
    }

    private static boolean h(Context context) {
        if (!j(context) && !r(context) && !t() && !l(context) && !s(context)) {
            return false;
        }
        return true;
    }

    public static boolean i() {
        try {
            Class<?> cls = Class.forName("com.youku.phone.BuildConfig");
            return TextUtils.equals((String) cls.getDeclaredField("multiAppType").get(cls), "hw-car");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a4, code lost:
        if (r6.equals("HWTAH-C") == false) goto L_0x009c;
     */
    private static boolean j(Context context) {
        char c2;
        if ("HUAWEI".equalsIgnoreCase(Build.getMANUFACTURER())) {
            if (context != null && context.getPackageManager() != null && context.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture")) {
                return true;
            }
            String model = Build.getMODEL();
            model.hashCode();
            char c3 = 3;
            switch (model.hashCode()) {
                case -1737858118:
                    if (model.equals("RHA-N29m")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -830296637:
                    if (model.equals("TAH-N29")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 30247423:
                    if (model.equals("TAH-AN00")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 30608138:
                    if (model.equals("TAH-N29m")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 937670222:
                    if (model.equals("TAH-AN00m")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1949791134:
                    if (model.equals("RHA-AN00m")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2005507479:
                    if (model.equals("RLI-N29")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2040829099:
                    if (model.equals("RLI-AN00")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                default:
                    String str = android.os.Build.DEVICE;
                    str.hashCode();
                    switch (str.hashCode()) {
                        case 69168140:
                            if (str.equals("HWTAH")) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1160623169:
                            if (str.equals("unknownRHA")) {
                                c3 = 1;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1160623301:
                            if (str.equals("unknownRLI")) {
                                c3 = 2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 2046074562:
                            break;
                        default:
                            c3 = 65535;
                            break;
                    }
                    switch (c3) {
                    }
            }
            return true;
        }
        return false;
    }

    public static boolean k() {
        return c == 1;
    }

    public static boolean l(Context context) {
        int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", "android");
        if (identifier > 0) {
            return context.getResources().getBoolean(identifier);
        }
        return false;
    }

    public static boolean m(Context context) {
        if (b == -1) {
            boolean q = q();
            if (!q) {
                q = o(context);
            }
            if (!q) {
                q = p(context);
            }
            if (q && g(context)) {
                q = false;
            }
            if (!q) {
                IConfig a2 = x02.c().a();
                if (a2 == null || !a2.hitPad()) {
                    b = 0;
                } else {
                    b = 1;
                }
            } else {
                b = 1;
            }
        }
        if (b == 1) {
            return true;
        }
        return false;
    }

    public static boolean n(Context context) {
        IConfig a2 = x02.c().a();
        if ((a2 == null || a2.isUsePadOpt()) && (context.getResources().getConfiguration().screenLayout & 15) < 3) {
            return false;
        }
        return true;
    }

    public static boolean o(Context context) {
        IConfig a2 = x02.c().a();
        if ((a2 == null || a2.isUsePadOpt()) && ((TelephonyManager) context.getSystemService("phone")).getPhoneType() == 0) {
            return true;
        }
        return false;
    }

    private static boolean p(Context context) {
        if (!n(context)) {
            return false;
        }
        double b2 = b(context);
        if (b2 <= 0.0d) {
            return false;
        }
        IConfig a2 = x02.c().a();
        double d2 = 8.0d;
        if (a2 != null && a2.getPhoneScreenInches() > 0.0d) {
            d2 = a2.getPhoneScreenInches();
        }
        if (b2 >= d2) {
            return true;
        }
        return false;
    }

    public static boolean q() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "ro.build.characteristics");
            if (str == null || !str.equalsIgnoreCase("tablet")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean r(Context context) {
        if ("samsung".equalsIgnoreCase(Build.getBRAND()) && "winner".equalsIgnoreCase(android.os.Build.DEVICE)) {
            return true;
        }
        String model = Build.getMODEL();
        if (TextUtils.isEmpty(model)) {
            return false;
        }
        if (model.startsWith("SM-F9") || model.startsWith("SM-W202")) {
            return true;
        }
        return false;
    }

    public static boolean s(Context context) {
        if (!"vivo".equalsIgnoreCase(Build.getMANUFACTURER())) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.util.FtDeviceInfo");
            String str = (String) cls.getMethod("getDeviceType", String.class).invoke(cls, new Object[0]);
            if (str == null || !str.equalsIgnoreCase("foldable")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean t() {
        if (!"Xiaomi".equalsIgnoreCase(Build.getMANUFACTURER())) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "persist.sys.muiltdisplay_type");
            if (str == null || !str.equalsIgnoreCase("2")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
