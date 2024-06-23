package tb;

import android.text.TextUtils;
import com.alibaba.android.umbrella.trace.UmbrellaInfo;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;

/* compiled from: Taobao */
public class gr2 {
    public static final double DEFAULT_FAIL_SAMPLE_RATING = 1.0d;
    public static final double DEFAULT_PERFORMANCE_SAMPLE_RATING = 0.005d;
    public static final double DEFAULT_SUCCESS_SAMPLE_RATING = 5.0E-5d;
    public static final String FORCE_CLOSE_FAILURE_KEY = "ForceCloseFailure";
    public static final String FORCE_CLOSE_PERFORMANCE_PAGE_KEY = "ForceClosePerformancePage";
    public static final String FORCE_CLOSE_PERFORMANCE_POINT_KEY = "ForceClosePerformancePoint";
    public static final String FORCE_CLOSE_SUCCESS_KEY = "ForceCloseSuccess";
    public static final String OPEN_CRASH_REPORT_KEY = "isPointReportToCrash";
    public static final String OPEN_GRAY_REPORT_KEY = "isGrayReport";
    public static final String ORANGE_GROUP_NAME = "umbrella_trace";
    private static HashMap<String, Double> a = new HashMap<>();
    private static HashMap<String, Double> b = new HashMap<>();
    private static HashMap<String, Double> c = new HashMap<>();
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = true;
    private static boolean i = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements OrangeConfigListenerV1 {
        a() {
        }

        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
            if (gr2.ORANGE_GROUP_NAME.equals(str)) {
                for (String str2 : gr2.a.keySet()) {
                    try {
                        gr2.a.put(str2, Double.valueOf(Double.parseDouble(OrangeConfig.getInstance().getConfig(gr2.ORANGE_GROUP_NAME, str2, String.valueOf(5.0E-5d)))));
                    } catch (NumberFormatException unused) {
                        gr2.a.put(str2, Double.valueOf(5.0E-5d));
                    }
                }
                for (String str3 : gr2.b.keySet()) {
                    try {
                        gr2.b.put(str3, Double.valueOf(Double.parseDouble(OrangeConfig.getInstance().getConfig(gr2.ORANGE_GROUP_NAME, str3, String.valueOf(1.0d)))));
                    } catch (NumberFormatException unused2) {
                        gr2.b.put(str3, Double.valueOf(1.0d));
                    }
                }
                for (String str4 : gr2.c.keySet()) {
                    try {
                        gr2.b.put(str4, Double.valueOf(Double.parseDouble(OrangeConfig.getInstance().getConfig(gr2.ORANGE_GROUP_NAME, str4, String.valueOf(0.005d)))));
                    } catch (NumberFormatException unused3) {
                        gr2.b.put(str4, Double.valueOf(0.005d));
                    }
                }
                boolean unused4 = gr2.d = gr2.n(gr2.FORCE_CLOSE_SUCCESS_KEY);
                boolean unused5 = gr2.e = gr2.n(gr2.FORCE_CLOSE_FAILURE_KEY);
                boolean unused6 = gr2.f = gr2.n(gr2.FORCE_CLOSE_PERFORMANCE_POINT_KEY);
                boolean unused7 = gr2.g = gr2.n(gr2.FORCE_CLOSE_PERFORMANCE_PAGE_KEY);
                gr2.k(gr2.p());
                boolean unused8 = gr2.h = gr2.q();
            }
        }
    }

    static {
        x();
    }

    public static boolean A() {
        return f;
    }

    public static boolean B() {
        return d;
    }

    private static boolean C() {
        return false;
    }

    public static boolean D() {
        return h;
    }

    static /* synthetic */ boolean k(boolean z) {
        return z;
    }

    public static boolean m(UmbrellaInfo umbrellaInfo, String str) {
        if (umbrellaInfo != null && !TextUtils.isEmpty(umbrellaInfo.mainBizName) && !TextUtils.isEmpty(str)) {
            if (r(umbrellaInfo.mainBizName + '_' + str) > Math.random()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean n(String str) {
        if (!TextUtils.isEmpty(str) && "true".equals(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, str, "false"))) {
            return true;
        }
        return false;
    }

    public static boolean o() {
        return i;
    }

    /* access modifiers changed from: private */
    public static boolean p() {
        return "true".equals(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, OPEN_CRASH_REPORT_KEY, "true"));
    }

    /* access modifiers changed from: private */
    public static boolean q() {
        return "true".equals(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, OPEN_GRAY_REPORT_KEY, "true"));
    }

    public static double r(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1.0d;
        }
        Double d2 = b.get(str);
        if (d2 != null) {
            return d2.doubleValue();
        }
        try {
            double parseDouble = Double.parseDouble(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, str, String.valueOf(1.0d)));
            b.put(str, Double.valueOf(parseDouble));
            return parseDouble;
        } catch (NumberFormatException unused) {
            b.put(str, Double.valueOf(1.0d));
            return 1.0d;
        }
    }

    public static double s(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5.0E-5d;
        }
        Double d2 = a.get(str);
        if (d2 != null) {
            return d2.doubleValue();
        }
        try {
            double parseDouble = Double.parseDouble(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, str, String.valueOf(5.0E-5d)));
            a.put(str, Double.valueOf(parseDouble));
            return parseDouble;
        } catch (NumberFormatException unused) {
            a.put(str, Double.valueOf(5.0E-5d));
            return 5.0E-5d;
        }
    }

    public static double t(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.005d;
        }
        Double d2 = c.get(str);
        if (d2 != null) {
            return d2.doubleValue();
        }
        try {
            double parseDouble = Double.parseDouble(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, str, String.valueOf(0.005d)));
            c.put(str, Double.valueOf(parseDouble));
            return parseDouble;
        } catch (NumberFormatException unused) {
            c.put(str, Double.valueOf(0.005d));
            return 0.005d;
        }
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (t("Performance_Page_Load_" + str) > Math.random()) {
            return true;
        }
        return false;
    }

    public static boolean v(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (t("Performance_" + str + JSMethod.NOT_SET + str2) > Math.random()) {
                return true;
            }
        }
        return false;
    }

    public static boolean w(UmbrellaInfo umbrellaInfo) {
        if (umbrellaInfo != null && !TextUtils.isEmpty(umbrellaInfo.mainBizName) && !TextUtils.isEmpty(umbrellaInfo.tagId)) {
            if (s(umbrellaInfo.mainBizName + '_' + umbrellaInfo.tagId) > Math.random()) {
                return true;
            }
        }
        return false;
    }

    public static void x() {
        d = n(FORCE_CLOSE_SUCCESS_KEY);
        e = n(FORCE_CLOSE_FAILURE_KEY);
        p();
        f = n(FORCE_CLOSE_PERFORMANCE_POINT_KEY);
        g = n(FORCE_CLOSE_PERFORMANCE_PAGE_KEY);
        h = q();
        i = C();
        OrangeConfig.getInstance().registerListener(new String[]{ORANGE_GROUP_NAME}, new a());
    }

    public static boolean y() {
        return e;
    }

    public static boolean z() {
        return g;
    }
}
