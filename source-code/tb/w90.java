package tb;

import android.content.Context;
import android.content.SharedPreferences;
import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.kvdata.SPProviderProxy;

/* compiled from: Taobao */
public class w90 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1367491884")) {
            return e(context).getBoolean("dm_sp_is_seat", false);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1367491884", new Object[]{context})).booleanValue();
    }

    public static long b(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-681096349")) {
            return e(context).getLong("dm_sp_item_id", 0);
        }
        return ((Long) ipChange.ipc$dispatch("-681096349", new Object[]{context})).longValue();
    }

    public static String c(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1024509784")) {
            return e(context).getString("dm_sp_promotion_type", "");
        }
        return (String) ipChange.ipc$dispatch("1024509784", new Object[]{context});
    }

    public static String d(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1733499709")) {
            return e(context).getString("dm_sp_promotion_type_id", "");
        }
        return (String) ipChange.ipc$dispatch("1733499709", new Object[]{context});
    }

    private static SharedPreferences e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2117422381")) {
            return (SharedPreferences) ipChange.ipc$dispatch("-2117422381", new Object[]{context});
        } else if (context == null) {
            return null;
        } else {
            if ("true".equals(OrangeConfigCenter.c().b("damai_oneservice_switch", "SPProvider", "false"))) {
                return SPProviderProxy.getSharedPreferences("ultron_sharedpreferences");
            }
            return context.getSharedPreferences("ultron_sharedpreferences", 4);
        }
    }

    public static void f(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323718280")) {
            ipChange.ipc$dispatch("-1323718280", new Object[]{context, Boolean.valueOf(z)});
            return;
        }
        SharedPreferences e = e(context);
        if (e != null) {
            e.edit().putBoolean("dm_sp_is_seat", z).commit();
        }
    }

    public static void g(Context context, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1520308055")) {
            ipChange.ipc$dispatch("-1520308055", new Object[]{context, Long.valueOf(j)});
            return;
        }
        SharedPreferences e = e(context);
        if (e != null) {
            e.edit().putLong("dm_sp_item_id", j).commit();
        }
    }

    public static void h(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528446074")) {
            ipChange.ipc$dispatch("-1528446074", new Object[]{context, str});
            return;
        }
        SharedPreferences e = e(context);
        if (e != null) {
            e.edit().putString("dm_sp_promotion_type", str).commit();
        }
    }

    public static void i(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878941505")) {
            ipChange.ipc$dispatch("1878941505", new Object[]{context, str});
            return;
        }
        SharedPreferences e = e(context);
        if (e != null) {
            e.edit().putString("dm_sp_promotion_type_id", str).commit();
        }
    }
}
