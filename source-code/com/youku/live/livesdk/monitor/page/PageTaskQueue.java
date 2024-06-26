package com.youku.live.livesdk.monitor.page;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.monitor.page.IPageMonitor;
import java.util.Comparator;
import java.util.PriorityQueue;

/* compiled from: Taobao */
public class PageTaskQueue extends PriorityQueue<IPageMonitor.MonitorTask> {
    private static transient /* synthetic */ IpChange $ipChange;

    PageTaskQueue(int i) {
        super(i, new Comparator<IPageMonitor.MonitorTask>() {
            /* class com.youku.live.livesdk.monitor.page.PageTaskQueue.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public int compare(IPageMonitor.MonitorTask monitorTask, IPageMonitor.MonitorTask monitorTask2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "567271386")) {
                    return ((Integer) ipChange.ipc$dispatch("567271386", new Object[]{this, monitorTask, monitorTask2})).intValue();
                } else if (monitorTask == null || monitorTask2 == null) {
                    return 0;
                } else {
                    return monitorTask.compareTo(monitorTask2);
                }
            }
        });
    }

    public static PageTaskQueue newInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1610090203") ? (PageTaskQueue) ipChange.ipc$dispatch("-1610090203", new Object[0]) : new PageTaskQueue(20);
    }
}
