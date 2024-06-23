package tb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import mtopsdk.mtop.domain.MtopResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class hb0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final hb0 INSTANCE = new hb0();

    private hb0() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable MtopResponse mtopResponse) {
        Map<String, List<String>> headerFields;
        List<String> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1484957264")) {
            return (String) ipChange.ipc$dispatch("1484957264", new Object[]{mtopResponse});
        }
        return (mtopResponse == null || (headerFields = mtopResponse.getHeaderFields()) == null || (list = headerFields.get("x-eagleeye-id")) == null) ? "trace null" : list.toString();
    }

    @JvmStatic
    public static final boolean b(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539437747")) {
            return ((Boolean) ipChange.ipc$dispatch("539437747", new Object[]{context})).booleanValue();
        }
        ConnectivityManager connectivityManager = null;
        Object systemService = context != null ? context.getSystemService("connectivity") : null;
        if (systemService instanceof ConnectivityManager) {
            connectivityManager = systemService;
        }
        ConnectivityManager connectivityManager2 = connectivityManager;
        if (connectivityManager2 != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager2.getNetworkCapabilities(connectivityManager2.getActiveNetwork());
                if (networkCapabilities != null) {
                    if (!networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(3)) {
                        return false;
                    }
                    return true;
                }
            } else {
                try {
                    vp.a("update_statut", "Network is available : true");
                    NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager2);
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                } catch (Exception e) {
                    vp.a("update_statut", "" + e.getMessage());
                    ur2 ur2 = ur2.INSTANCE;
                }
            }
        }
        vp.a("update_statut", "Network is available : FALSE ");
        return false;
    }
}
