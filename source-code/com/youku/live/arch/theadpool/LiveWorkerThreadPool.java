package com.youku.live.arch.theadpool;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.concurrent.Future;
import tb.yk1;

/* compiled from: Taobao */
public class LiveWorkerThreadPool {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile LiveWorkerThreadPool instance;

    private LiveWorkerThreadPool() {
        init();
    }

    public static LiveWorkerThreadPool getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "850523899")) {
            return (LiveWorkerThreadPool) ipChange.ipc$dispatch("850523899", new Object[0]);
        }
        if (instance == null) {
            synchronized (LiveWorkerThreadPool.class) {
                if (instance == null) {
                    instance = new LiveWorkerThreadPool();
                }
            }
        }
        return instance;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205336734")) {
            ipChange.ipc$dispatch("1205336734", new Object[]{this});
        }
    }

    public static void releaseAndShutdown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009123688")) {
            ipChange.ipc$dispatch("1009123688", new Object[0]);
        } else if (instance != null) {
            instance.shutdown();
            instance = null;
        }
    }

    private void shutdown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "970311448")) {
            ipChange.ipc$dispatch("970311448", new Object[]{this});
        }
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766095633")) {
            ipChange.ipc$dispatch("-766095633", new Object[]{this});
        }
    }

    public void execute(PriorityRunnable priorityRunnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932853588")) {
            ipChange.ipc$dispatch("-932853588", new Object[]{this, priorityRunnable});
            return;
        }
        yk1.d(priorityRunnable);
    }

    @Deprecated
    public <T> Future<T> submit(PriorityRunnable priorityRunnable, T t) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1843639853")) {
            return null;
        }
        return (Future) ipChange.ipc$dispatch("1843639853", new Object[]{this, priorityRunnable, t});
    }

    public void execute(List<PriorityRunnable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-995058184")) {
            ipChange.ipc$dispatch("-995058184", new Object[]{this, list});
            return;
        }
        for (PriorityRunnable priorityRunnable : list) {
            yk1.d(priorityRunnable);
        }
    }
}
