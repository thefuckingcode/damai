package cn.damai.homepage.v2;

import cn.damai.common.util.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gi;
import tb.xs0;

/* compiled from: Taobao */
public final class HomePageFragment$onViewCreated$6$1 extends PriorityTask {
    private static transient /* synthetic */ IpChange $ipChange;

    HomePageFragment$onViewCreated$6$1() {
        super("cityTask", "");
    }

    @Override // cn.damai.common.util.PriorityTask
    public void doTask() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171789047")) {
            ipChange.ipc$dispatch("171789047", new Object[]{this});
            return;
        }
        gi.a(xs0.a());
    }
}
