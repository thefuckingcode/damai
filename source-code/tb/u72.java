package tb;

import android.os.Build;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class u72 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DEPEND_ON_ORANGE = "hw_by_orange";
    public static final String DEPEND_ON_POPCORN_CLOSED = "hw_by_popcorn_closed";
    public static final String DEPEND_ON_POPCORN_ENABLE = "hw_by_popcorn_enable";

    private static long a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1129333523")) {
            return ((Long) ipChange.ipc$dispatch("1129333523", new Object[0])).longValue();
        }
        long k = lk1.k(d20.E(), -1);
        if (k != -1) {
            return k % 100;
        }
        return -1;
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025570042")) {
            return (String) ipChange.ipc$dispatch("2025570042", new Object[0]);
        }
        String B = d20.B("sp_hw_popcorn_key");
        return TextUtils.isEmpty(B) ? DEPEND_ON_ORANGE : B;
    }

    public static boolean c(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765560114")) {
            return ((Boolean) ipChange.ipc$dispatch("-1765560114", new Object[]{Long.valueOf(j), Boolean.valueOf(z)})).booleanValue();
        }
        try {
            return d(j, z);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00cd  */
    private static boolean d(long j, boolean z) {
        boolean z2;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        boolean z4 = false;
        if (AndroidInstantRuntime.support(ipChange, "-444585106")) {
            return ((Boolean) ipChange.ipc$dispatch("-444585106", new Object[]{Long.valueOf(j), Boolean.valueOf(z)})).booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        if (i <= 28) {
            return false;
        }
        if (!AppConfig.v() || !e()) {
            OrangeConfigCenter c = OrangeConfigCenter.c();
            int a = c.a("damai_svg_seat_view_hw_accelerate_switch", "hw_accelerate_main_key", -1);
            f(z, "HW+ RegionSeatView 参数：orange main key = " + a);
            if (a == 1) {
                String b = c.b("damai_svg_seat_view_hw_accelerate_switch", "hw_accelerate_disable_item_ids_key", null);
                f(z, "HW+ RegionSeatView 参数：orange disable itemIds = " + b + ", cur itemId = " + j);
                if (!TextUtils.isEmpty(b)) {
                    if (b.contains(j + "")) {
                        z2 = true;
                        if (!z2) {
                            long a2 = a();
                            if (a2 != -1) {
                                int a3 = c.a("damai_svg_seat_view_hw_accelerate_switch", "hw_accelerate_user_code_suffix_key", -1);
                                if (a2 > ((long) a3)) {
                                    z3 = false;
                                }
                                f(z, "HW+ RegionSeatView 参数：orange suffix = " + a3 + ", user suffix = " + a2);
                                z4 = z3;
                            }
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                }
            }
            f(z, "HW+ RegionSeatView 硬件加速：" + z4 + " sdkLevel：" + i + " 当前受到orange控制");
            return z4;
        }
        boolean equals = TextUtils.equals(DEPEND_ON_POPCORN_ENABLE, b());
        f(z, "HW+ RegionSeatView 硬件加速：" + equals + " sdkLevel：" + i + " 当前受到爆米花控制");
        return equals;
    }

    private static boolean e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662531147")) {
            return ((Boolean) ipChange.ipc$dispatch("662531147", new Object[0])).booleanValue();
        }
        return !TextUtils.equals(DEPEND_ON_ORANGE, b());
    }

    private static void f(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1359108490")) {
            ipChange.ipc$dispatch("1359108490", new Object[]{Boolean.valueOf(z), str});
        } else if (AppConfig.v() && z) {
            s72.f(str);
        }
    }

    public static void g(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130979614")) {
            ipChange.ipc$dispatch("-1130979614", new Object[]{Boolean.valueOf(z)});
        } else if (z) {
            try {
                OrangeConfigCenter.c().e("damai_svg_seat_view_hw_accelerate_switch");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            OrangeConfigCenter.c().g("damai_svg_seat_view_hw_accelerate_switch");
        }
    }
}
