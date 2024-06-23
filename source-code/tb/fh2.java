package tb;

import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class fh2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    public static boolean a() {
        int i;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233102534")) {
            return ((Boolean) ipChange.ipc$dispatch("1233102534", new Object[0])).booleanValue();
        }
        try {
            i = OrangeConfigCenter.c().a("damai_svg_protect_api_level_switch", "useDecryptApiLevel", 1);
            try {
                g91.b("useDecryptApiLevel", "useDecryptApiLevel_" + i);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            i = 1;
            e.printStackTrace();
            if (i != 1) {
            }
        }
        if (i != 1) {
            return true;
        }
        return false;
    }

    public static void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1987874535")) {
            ipChange.ipc$dispatch("-1987874535", new Object[]{Boolean.valueOf(z)});
        } else if (z) {
            OrangeConfigCenter.c().e("damai_svg_protect_api_level_switch");
        } else {
            OrangeConfigCenter.c().g("damai_svg_protect_api_level_switch");
        }
    }
}
