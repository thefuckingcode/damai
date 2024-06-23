package cn.damai.commonbusiness.config;

import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.tool2.bufferkit.BufferSwitch;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import tb.bd;
import tb.d20;
import tb.g91;
import tb.u72;
import tb.xf2;

/* compiled from: Taobao */
public class SeatSwitch {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BY_NEW = 1;
    public static final int BY_OLD = 2;
    public static final int BY_ORANGE = 0;
    public static final String SEAT_QILIN_SEAT_REFACTOR_KEY = "match_user_code_suffix";
    @Deprecated
    public static final String SEAT_QILIN_SEAT_REFACTOR_SWITCH = "damai_qilin_seat_refactor_switch";
    public static final String SEAT_STATUS_COMPRESS_API_KEY = "is_use_seat_status_compress_api";
    public static final String SWITCH_MTOP_API_PRELOAD = "damai_mtop_api_preload_switch";
    public static final String SWITCH_MTOP_API_PRELOAD_KEY = "mtop_api_preload_close_group";
    @Deprecated
    public static final String SWITCH_SEAT_STATUS_COMPRESS_API = "damai_seat_status_compress_switch";

    static {
        try {
            String B = d20.B("sp_use_seat_page");
            if (xf2.h(B)) {
                Integer.parseInt(B);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(String str) {
        Exception e;
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-211070401")) {
            return ((Boolean) ipChange.ipc$dispatch("-211070401", new Object[]{str})).booleanValue();
        }
        try {
            String b = OrangeConfigCenter.c().b(SWITCH_MTOP_API_PRELOAD, SWITCH_MTOP_API_PRELOAD_KEY, "");
            if (TextUtils.isEmpty(b) || TextUtils.isEmpty(str) || !Arrays.asList(b.split(",")).contains(str)) {
                z = true;
            }
            try {
                if (!AppConfig.v()) {
                    return z;
                }
                g91.c("ApiPreload", "orange config=" + b + " groupType=" + str + " isSupport=" + z);
                return z;
            } catch (Exception e2) {
                e = e2;
                z2 = z;
                e.printStackTrace();
                return z2;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return z2;
        }
    }

    public static void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042337892")) {
            ipChange.ipc$dispatch("1042337892", new Object[]{Boolean.valueOf(z)});
            return;
        }
        if (z) {
            try {
                bd.f(new BufferSwitch() {
                    /* class cn.damai.commonbusiness.config.SeatSwitch.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.tool2.bufferkit.BufferSwitch
                    public boolean isGroupTypeSupport(String str) {
                        IpChange ipChange = $ipChange;
                        if (!AndroidInstantRuntime.support(ipChange, "-1098717515")) {
                            return SeatSwitch.a(str);
                        }
                        return ((Boolean) ipChange.ipc$dispatch("-1098717515", new Object[]{this, str})).booleanValue();
                    }
                }, AppConfig.v());
                OrangeConfigCenter.c().e(SWITCH_MTOP_API_PRELOAD);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            OrangeConfigCenter.c().g(SWITCH_MTOP_API_PRELOAD);
        }
        u72.g(z);
    }
}
