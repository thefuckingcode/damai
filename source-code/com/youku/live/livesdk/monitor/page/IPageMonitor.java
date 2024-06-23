package com.youku.live.livesdk.monitor.page;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public interface IPageMonitor {
    public static final int STATE_MONITOR_FINISH = 2;
    public static final int STATE_MONITOR_INIT = 0;
    public static final int STATE_MONITOR_START = 1;

    /* compiled from: Taobao */
    public static class MonitorTask implements Comparable<MonitorTask> {
        private static transient /* synthetic */ IpChange $ipChange = null;
        public static final int PRIORITY_EXTREMELY_HIGH = 0;
        public static final int PRIORITY_HIGH = 1;
        public static final int PRIORITY_LOW = 3;
        public static final int PRIORITY_MIDDLE = 2;
        int delayTime = 50;
        String pageName;
        boolean runInMainThread = true;
        Runnable runnable;
        String taskName;
        int taskPriority = 2;

        public static MonitorTask buildMonitorTask(Runnable runnable2, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-450243713")) {
                return buildMonitorTask(true, runnable2, str, str2, 50);
            }
            return (MonitorTask) ipChange.ipc$dispatch("-450243713", new Object[]{runnable2, str, str2});
        }

        public int getTaskPriority() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "693129137")) {
                return this.taskPriority;
            }
            return ((Integer) ipChange.ipc$dispatch("693129137", new Object[]{this})).intValue();
        }

        public MonitorTask setTaskPriority(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1449954916")) {
                return (MonitorTask) ipChange.ipc$dispatch("-1449954916", new Object[]{this, Integer.valueOf(i)});
            }
            this.taskPriority = i;
            return this;
        }

        public static MonitorTask buildMonitorTask(boolean z, Runnable runnable2, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2090065955")) {
                return buildMonitorTask(z, runnable2, str, str2, 50);
            }
            return (MonitorTask) ipChange.ipc$dispatch("2090065955", new Object[]{Boolean.valueOf(z), runnable2, str, str2});
        }

        public int compareTo(@NonNull MonitorTask monitorTask) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "687962695")) {
                return this.taskPriority - monitorTask.taskPriority;
            }
            return ((Integer) ipChange.ipc$dispatch("687962695", new Object[]{this, monitorTask})).intValue();
        }

        public static MonitorTask buildMonitorTask(boolean z, Runnable runnable2, String str, String str2, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2059514220")) {
                return (MonitorTask) ipChange.ipc$dispatch("-2059514220", new Object[]{Boolean.valueOf(z), runnable2, str, str2, Integer.valueOf(i)});
            }
            MonitorTask monitorTask = new MonitorTask();
            monitorTask.runInMainThread = z;
            monitorTask.runnable = runnable2;
            monitorTask.pageName = str;
            monitorTask.taskName = str2;
            monitorTask.delayTime = i;
            return monitorTask;
        }
    }

    void addMonitorTask(MonitorTask monitorTask);

    void clear();

    void clearBarrier();

    void initMonitor(String... strArr);

    void removeMonitorTask(MonitorTask monitorTask);

    void setBarrier();

    void setExecuteDelay(long j);
}
