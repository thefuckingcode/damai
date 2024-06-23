package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class d03 extends xa {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String a;
    @Nullable
    private Map<String, String> b;

    @Override // tb.xa
    public void fillExtraData(@Nullable HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2133959911")) {
            ipChange.ipc$dispatch("-2133959911", new Object[]{this, hashMap});
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
        if (!AndroidInstantRuntime.support(ipChange, "-1034585186")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("-1034585186", new Object[]{this});
    }

    @Override // com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint
    @NotNull
    public String getPointName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-872979284")) {
            return "failureMonitor";
        }
        return (String) ipChange.ipc$dispatch("-872979284", new Object[]{this});
    }

    @Override // tb.xa
    public void setBizScene(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889697536")) {
            ipChange.ipc$dispatch("-1889697536", new Object[]{this, str});
            return;
        }
        if (str == null) {
            str = "damai-android";
        }
        this.a = str;
    }

    public final void setExtral(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103980530")) {
            ipChange.ipc$dispatch("103980530", new Object[]{this, map});
            return;
        }
        this.b = map;
    }
}
