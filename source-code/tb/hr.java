package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class hr extends xa {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String a;
    @Nullable
    private Map<String, String> b;

    @Override // tb.xa
    public void fillExtraData(@Nullable HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402006423")) {
            ipChange.ipc$dispatch("402006423", new Object[]{this, hashMap});
            return;
        }
        Map<String, String> map = this.b;
        if (!(map == null || hashMap == null)) {
            hashMap.putAll(map);
        }
        super.fillExtraData(hashMap);
        AppMonitor.Stat.setSampling(10000);
    }

    @Override // tb.xa
    @Nullable
    public String getBizScene() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "955265308")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("955265308", new Object[]{this});
    }

    @Override // com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint
    @NotNull
    public String getPointName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "682843886")) {
            return "page_business";
        }
        return (String) ipChange.ipc$dispatch("682843886", new Object[]{this});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        if (r5 == null) goto L_0x0026;
     */
    @Override // tb.xa
    public void setBizScene(@Nullable String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-333874366")) {
            ipChange.ipc$dispatch("-333874366", new Object[]{this, str});
            return;
        }
        if (str != null) {
            str2 = str.toLowerCase(Locale.ROOT);
            k21.h(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        str2 = "damai-android";
        this.a = str2;
    }

    public final void setExtral(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823116400")) {
            ipChange.ipc$dispatch("823116400", new Object[]{this, map});
            return;
        }
        this.b = map;
    }
}
