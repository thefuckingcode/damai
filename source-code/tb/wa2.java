package tb;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class wa2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a;
    private Activity b;

    public wa2() {
    }

    public Activity a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "376917394")) {
            return this.b;
        }
        return (Activity) ipChange.ipc$dispatch("376917394", new Object[]{this});
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-989056493")) {
            return this.a;
        }
        return ((Boolean) ipChange.ipc$dispatch("-989056493", new Object[]{this})).booleanValue();
    }

    public wa2(boolean z, Activity activity) {
        this.a = z;
        this.b = activity;
    }
}
