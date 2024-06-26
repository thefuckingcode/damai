package tb;

import com.alibaba.pictures.abtest.provider.ABTestProvider;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.module.plugin.UTPlugin;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class e extends UTPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final e INSTANCE = new e();

    private e() {
    }

    public final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373557338")) {
            ipChange.ipc$dispatch("373557338", new Object[]{this});
            return;
        }
        try {
            UTAnalytics.getInstance().registerPlugin(INSTANCE);
        } catch (Throwable unused) {
        }
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    @NotNull
    public int[] getAttentionEventIds() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-657087507")) {
            return new int[]{2001, 2101, 2201, 19999, 12002, 12003};
        }
        return (int[]) ipChange.ipc$dispatch("-657087507", new Object[]{this});
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    @Nullable
    public Map<String, String> onEventDispatch(@Nullable String str, int i, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-31894245")) {
            return (Map) ipChange.ipc$dispatch("-31894245", new Object[]{this, str, Integer.valueOf(i), str2, str3, str4, map});
        }
        HashMap hashMap = new HashMap();
        ABTestProvider aBTestProvider = ABTestProvider.INSTANCE;
        String d = aBTestProvider.d();
        if (d.length() > 0) {
            hashMap.put("MVPABTestFullBuckets", d);
        }
        String e = aBTestProvider.e();
        if (e.length() <= 0) {
            z = false;
        }
        if (z) {
            hashMap.put("MVPABTestBuckets", e);
        }
        return hashMap;
    }
}
