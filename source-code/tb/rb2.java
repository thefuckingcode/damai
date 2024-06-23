package tb;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.fw2;

/* compiled from: Taobao */
public class rb2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static fw2.b a(View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "871117871")) {
            return new fw2.b(view);
        }
        return (fw2.b) ipChange.ipc$dispatch("871117871", new Object[]{view});
    }
}
