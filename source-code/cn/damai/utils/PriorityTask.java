package cn.damai.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import tb.o70;

/* compiled from: Taobao */
public abstract class PriorityTask implements Runnable, Comparable<PriorityTask> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PRIORITY_HIGH = 100;
    public static final int PRIORITY_MEDIUM = 50;
    public static final int PRIORITY_NORMAL = 1;
    private WeakReference<Object> param;
    private int priority;
    private String tag;

    private PriorityTask(int i) {
        this.priority = 1;
        if (i >= 0) {
            this.priority = i > 100 ? 100 : i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public abstract void doTask();

    public Object getParam() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "334371082")) {
            return this.param.get();
        }
        return ipChange.ipc$dispatch("334371082", new Object[]{this});
    }

    public int getPriority() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2137340900")) {
            return this.priority;
        }
        return ((Integer) ipChange.ipc$dispatch("2137340900", new Object[]{this})).intValue();
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1492325152")) {
            ipChange.ipc$dispatch("-1492325152", new Object[]{this});
            return;
        }
        doTask();
    }

    public void setPriority(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1551126466")) {
            ipChange.ipc$dispatch("-1551126466", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.priority = i;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2117014131")) {
            return (String) ipChange.ipc$dispatch("-2117014131", new Object[]{this});
        } else if (this.tag == null) {
            return getClass().toString();
        } else {
            return "Tag:" + this.tag + o70.DINAMIC_PREFIX_AT + getClass().toString();
        }
    }

    public int compareTo(PriorityTask priorityTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "486995303")) {
            return ((Integer) ipChange.ipc$dispatch("486995303", new Object[]{this, priorityTask})).intValue();
        }
        int priority2 = getPriority();
        int priority3 = priorityTask.getPriority();
        if (priority2 < priority3) {
            return 1;
        }
        return priority2 > priority3 ? -1 : 0;
    }

    public PriorityTask(String str, Object obj) {
        this(1);
        this.tag = str;
        this.param = new WeakReference<>(obj);
    }

    public PriorityTask(String str, Object obj, int i) {
        this(i);
        this.tag = str;
        this.param = new WeakReference<>(obj);
    }
}
