package com.youku.live.dsl.threadpool;

import cn.damai.utils.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.os1;
import tb.xs0;

/* compiled from: Taobao */
public class IThreadPoolImp implements IThreadPool {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.threadpool.IThreadPool
    public void excute(final Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1165197374")) {
            ipChange.ipc$dispatch("-1165197374", new Object[]{this, runnable});
            return;
        }
        os1.a(new PriorityTask("workerThread", xs0.a(), 1) {
            /* class com.youku.live.dsl.threadpool.IThreadPoolImp.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.utils.PriorityTask
            public void doTask() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1440267593")) {
                    ipChange.ipc$dispatch("-1440267593", new Object[]{this});
                    return;
                }
                try {
                    runnable.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
