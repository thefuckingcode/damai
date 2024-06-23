package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class cg0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private Map<String, String> c;

    public final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852484982")) {
            ipChange.ipc$dispatch("-852484982", new Object[]{this});
        } else if (TextUtils.isEmpty(this.b)) {
            ot2.c("曝光埋点无效，eventName == null");
        } else {
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(this.b);
            if (!TextUtils.isEmpty(this.a)) {
                uTCustomHitBuilder.setEventPage(this.a);
            }
            Map<String, String> map = this.c;
            if (map != null) {
                uTCustomHitBuilder.setProperties(map);
            }
            UTAnalytics instance = UTAnalytics.getInstance();
            k21.h(instance, "UTAnalytics.getInstance()");
            instance.getDefaultTracker().send(uTCustomHitBuilder.build());
        }
    }

    @NotNull
    public final cg0 b(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-567866229")) {
            return (cg0) ipChange.ipc$dispatch("-567866229", new Object[]{this, str});
        }
        this.b = str;
        return this;
    }

    @NotNull
    public final cg0 c(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "512160789")) {
            return (cg0) ipChange.ipc$dispatch("512160789", new Object[]{this, str});
        }
        this.a = str;
        return this;
    }

    @NotNull
    public final cg0 d(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-795739793")) {
            return (cg0) ipChange.ipc$dispatch("-795739793", new Object[]{this, map});
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        if (map != null) {
            Map<String, String> map2 = this.c;
            k21.f(map2);
            map2.putAll(map);
        }
        return this;
    }
}
