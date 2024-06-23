package tb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.pictures.responsive.IConfig;
import com.alibaba.pictures.responsive.ResponsiveManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class e70 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final e70 INSTANCE = new e70();
    private static int a = -1;
    private static int b = -1;
    private static int c = -1;
    private static int d = -1;

    private e70() {
    }

    private final ur2 a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447252594")) {
            return (ur2) ipChange.ipc$dispatch("447252594", new Object[]{this});
        } else if (d != -1) {
            return ur2.INSTANCE;
        } else {
            d = j() ? 1 : 0;
            return ur2.INSTANCE;
        }
    }

    @JvmStatic
    public static final boolean g(@NotNull Context context) {
        IConfig b2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767977699")) {
            return ((Boolean) ipChange.ipc$dispatch("1767977699", new Object[]{context})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (a == -1) {
            a = (INSTANCE.h(context) || ((b2 = ResponsiveManager.Companion.a().b()) != null && b2.hitFold())) ? 1 : 0;
        }
        if (a == 1) {
            return true;
        }
        return false;
    }

    private final boolean h(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "815992592")) {
            return k(context) || i(context) || t(context) || v() || n(context) || m() || u(context);
        }
        return ((Boolean) ipChange.ipc$dispatch("815992592", new Object[]{this, context})).booleanValue();
    }

    private final boolean i(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1436284401")) {
            return (o.w("HONOR", Build.getMANUFACTURER(), true)) && context != null && context.getPackageManager() != null && context.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture");
        }
        return ((Boolean) ipChange.ipc$dispatch("-1436284401", new Object[]{this, context})).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (r6.equals("RLI-AN00") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        if (r6.equals("RLI-N29") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        if (r6.equals("RHA-AN00m") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        if (r6.equals("TAH-AN00m") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        if (r6.equals("TAH-N29m") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        if (r6.equals("TAH-AN00") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0089, code lost:
        if (r6.equals("TAH-N29") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0092, code lost:
        if (r6.equals("RHA-N29m") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0095, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c7 A[RETURN] */
    private final boolean k(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1130839314")) {
            return ((Boolean) ipChange.ipc$dispatch("1130839314", new Object[]{this, context})).booleanValue();
        }
        if (o.w("HUAWEI", Build.getMANUFACTURER(), true)) {
            if (context == null || context.getPackageManager() == null || !context.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture")) {
                String model = Build.getMODEL();
                if (model != null) {
                    switch (model.hashCode()) {
                        case -1737858118:
                            break;
                        case -830296637:
                            break;
                        case 30247423:
                            break;
                        case 30608138:
                            break;
                        case 937670222:
                            break;
                        case 1949791134:
                            break;
                        case 2005507479:
                            break;
                        case 2040829099:
                            break;
                    }
                }
                String str = android.os.Build.DEVICE;
                if (str != null) {
                    switch (str.hashCode()) {
                        case 69168140:
                            return str.equals("HWTAH");
                        case 1160623169:
                            if (!str.equals("unknownRHA")) {
                            }
                            break;
                        case 1160623301:
                            if (!str.equals("unknownRLI")) {
                            }
                            break;
                        case 2046074562:
                            if (!str.equals("HWTAH-C")) {
                            }
                            break;
                    }
                }
            } else {
                return true;
            }
        }
    }

    private final boolean r(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "608831587")) {
            return ((Boolean) ipChange.ipc$dispatch("608831587", new Object[]{this, context})).booleanValue();
        }
        if (p(context)) {
            double b2 = b(context);
            if (b2 > 0.0d) {
                IConfig b3 = ResponsiveManager.Companion.a().b();
                double d2 = 8.0d;
                if (b3 != null && b3.getPhoneScreenInches() > 0.0d) {
                    d2 = b3.getPhoneScreenInches();
                }
                if (b2 >= d2) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private final boolean t(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665251357")) {
            return ((Boolean) ipChange.ipc$dispatch("665251357", new Object[]{this, context})).booleanValue();
        } else if ((o.w("samsung", Build.getBRAND(), true)) && (o.w("winner", android.os.Build.DEVICE, true))) {
            return true;
        } else {
            String model = Build.getMODEL();
            if (!TextUtils.isEmpty(model)) {
                k21.h(model, "model");
                if ((o.L(model, "SM-F9", false, 2, null)) || (o.L(model, "SM-W202", false, 2, null)) || (o.L(model, "SM-W90", false, 2, null))) {
                    return true;
                }
            }
            return false;
        }
    }

    public final double b(@Nullable Context context) {
        Display defaultDisplay;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-269345178")) {
            return ((Double) ipChange.ipc$dispatch("-269345178", new Object[]{this, context})).doubleValue();
        }
        if (context == null) {
            return 0.0d;
        }
        Object systemService = context.getSystemService(v.ATTACH_MODE_WINDOW);
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
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

    public final boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-867578428")) {
            return l() || d();
        }
        return ((Boolean) ipChange.ipc$dispatch("-867578428", new Object[]{this})).booleanValue();
    }

    public final boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-481463083")) {
            return ((Boolean) ipChange.ipc$dispatch("-481463083", new Object[]{this})).booleanValue();
        }
        if (d == -1) {
            a();
        }
        if (d == 1) {
            return true;
        }
        return false;
    }

    public final boolean e(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275600602")) {
            return ((Boolean) ipChange.ipc$dispatch("-275600602", new Object[]{this, activity})).booleanValue();
        } else if (activity == null) {
            return false;
        } else {
            return f(activity.getResources().getConfiguration());
        }
    }

    public final boolean f(@Nullable Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356945444")) {
            return ((Boolean) ipChange.ipc$dispatch("1356945444", new Object[]{this, configuration})).booleanValue();
        } else if (configuration == null) {
            return false;
        } else {
            String configuration2 = configuration.toString();
            k21.h(configuration2, "configuration.toString()");
            if ((StringsKt__StringsKt.Q(configuration2, "hwMultiwindow-magic", false, 2, null)) || (StringsKt__StringsKt.Q(configuration2, "hw-magic-windows", false, 2, null))) {
                return true;
            }
            return false;
        }
    }

    public final boolean j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1820360755")) {
            return ((Boolean) ipChange.ipc$dispatch("1820360755", new Object[]{this})).booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.youku.phone.BuildConfig");
            Object obj = cls.getDeclaredField("multiAppType").get(cls);
            if (obj != null) {
                return TextUtils.equals((String) obj, "hw-car");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean l() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-416363308")) {
            return c == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-416363308", new Object[]{this})).booleanValue();
    }

    public final boolean m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212154795")) {
            return ((Boolean) ipChange.ipc$dispatch("1212154795", new Object[]{this})).booleanValue();
        } else if (!(o.w("oppo", Build.getMANUFACTURER(), true))) {
            return false;
        } else {
            try {
                Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
                Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                Object invoke2 = cls.getDeclaredMethod("hasFeature", String.class).invoke(invoke, "oplus.hardware.type.fold");
                if (invoke2 instanceof Boolean) {
                    return ((Boolean) invoke2).booleanValue();
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public final boolean n(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1679599395")) {
            return ((Boolean) ipChange.ipc$dispatch("1679599395", new Object[]{this, context})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", "android");
        if (identifier > 0) {
            return context.getResources().getBoolean(identifier);
        }
        return false;
    }

    public final boolean o(@NotNull Context context) {
        IConfig b2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "579297867")) {
            return ((Boolean) ipChange.ipc$dispatch("579297867", new Object[]{this, context})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (b == -1) {
            boolean s = s();
            if (!s) {
                s = q(context);
            }
            if (!s) {
                s = r(context);
            }
            if (s && g(context)) {
                s = false;
            }
            b = (s || ((b2 = ResponsiveManager.Companion.a().b()) != null && b2.hitPad())) ? 1 : 0;
        }
        if (b == 1) {
            return true;
        }
        return false;
    }

    public final boolean p(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189615141")) {
            return ((Boolean) ipChange.ipc$dispatch("-189615141", new Object[]{this, context})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        IConfig b2 = ResponsiveManager.Companion.a().b();
        if ((b2 == null || b2.isUsePadOpt()) && (context.getResources().getConfiguration().screenLayout & 15) < 3) {
            return false;
        }
        return true;
    }

    public final boolean q(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238039220")) {
            return ((Boolean) ipChange.ipc$dispatch("238039220", new Object[]{this, context})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        IConfig b2 = ResponsiveManager.Companion.a().b();
        if (b2 != null && !b2.isUsePadOpt()) {
            return false;
        }
        Object systemService = context.getSystemService("phone");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        if (((TelephonyManager) systemService).getPhoneType() == 0) {
            return true;
        }
        return false;
    }

    public final boolean s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533207124")) {
            return ((Boolean) ipChange.ipc$dispatch("-533207124", new Object[]{this})).booleanValue();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object invoke = cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "ro.build.characteristics");
            String str = invoke instanceof String ? (String) invoke : null;
            if (str == null || !(o.w(str, "tablet", true))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean u(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902589649")) {
            return ((Boolean) ipChange.ipc$dispatch("-902589649", new Object[]{this, context})).booleanValue();
        }
        if (o.w("vivo", Build.getMANUFACTURER(), true)) {
            try {
                Class<?> cls = Class.forName("android.util.FtDeviceInfo");
                Object invoke = cls.getMethod("getDeviceType", new Class[0]).invoke(cls, new Object[0]);
                String str = invoke instanceof String ? (String) invoke : null;
                if (str == null || !(o.w(str, "foldable", true))) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1451410258")) {
            return ((Boolean) ipChange.ipc$dispatch("1451410258", new Object[]{this})).booleanValue();
        } else if (!(o.w("Xiaomi", Build.getMANUFACTURER(), true))) {
            return false;
        } else {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                Object invoke = cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "persist.sys.muiltdisplay_type");
                String str = invoke instanceof String ? (String) invoke : null;
                if (str == null || !(o.w(str, "2", true))) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
