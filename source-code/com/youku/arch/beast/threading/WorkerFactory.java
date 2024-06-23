package com.youku.arch.beast.threading;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class WorkerFactory {
    private static transient /* synthetic */ IpChange $ipChange;
    private static WorkerThread mWorkThread = new WorkerThread();

    public static WorkerThread get() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "856843420") ? (WorkerThread) ipChange.ipc$dispatch("856843420", new Object[0]) : mWorkThread;
    }

    public static void run(final Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1320934504")) {
            ipChange.ipc$dispatch("1320934504", new Object[]{runnable});
            return;
        }
        new Thread() {
            /* class com.youku.arch.beast.threading.WorkerFactory.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1555941379")) {
                    ipChange.ipc$dispatch("-1555941379", new Object[]{this});
                    return;
                }
                runnable.run();
            }
        }.start();
    }
}
