package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.NetworkInfoProviderProxy;

/* compiled from: Taobao */
public class yh1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1748543749")) {
            return NetworkInfoProviderProxy.isMobile();
        }
        return ((Boolean) ipChange.ipc$dispatch("1748543749", new Object[]{context})).booleanValue();
    }

    public static boolean b(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-385504624")) {
            return NetworkInfoProviderProxy.isNetworkAvailable();
        }
        return ((Boolean) ipChange.ipc$dispatch("-385504624", new Object[]{context})).booleanValue();
    }

    public static boolean c(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "464643946")) {
            return NetworkInfoProviderProxy.isWifi();
        }
        return ((Boolean) ipChange.ipc$dispatch("464643946", new Object[]{context})).booleanValue();
    }
}
