package cn.damai.common.util;

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
        if (!AndroidInstantRuntime.support(ipChange, "-831263297")) {
            return this.param.get();
        }
        return ipChange.ipc$dispatch("-831263297", new Object[]{this});
    }

    public int getPriority() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1227865767")) {
            return this.priority;
        }
        return ((Integer) ipChange.ipc$dispatch("-1227865767", new Object[]{this})).intValue();
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092302677")) {
            ipChange.ipc$dispatch("1092302677", new Object[]{this});
            return;
        }
        doTask();
    }

    public void setPriority(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1501649257")) {
            ipChange.ipc$dispatch("1501649257", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.priority = i;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1012318786")) {
            return (String) ipChange.ipc$dispatch("1012318786", new Object[]{this});
        } else if (this.tag == null) {
            return getClass().toString();
        } else {
            return "Tag:" + this.tag + o70.DINAMIC_PREFIX_AT + getClass().toString();
        }
    }

    public int compareTo(PriorityTask priorityTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339013817")) {
            return ((Integer) ipChange.ipc$dispatch("-339013817", new Object[]{this, priorityTask})).intValue();
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
