package cn.damai.launcher.altriax;

import cn.damai.launcher.AppPreLauncher;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitCrashReportDelegate;
import tb.g91;
import tb.xs0;

/* compiled from: Taobao */
public class DMInitCrashReportImpl implements DMInitCrashReportDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitCrashReportDelegate
    public void initCrashReport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1246831692")) {
            ipChange.ipc$dispatch("1246831692", new Object[]{this});
            return;
        }
        g91.f("MainScheduler", "initCrashReport");
        new AppPreLauncher().b(xs0.a());
    }
}
