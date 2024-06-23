package com.alibaba.android.onescheduler;

import java.util.List;

/* compiled from: Taobao */
public interface OneSchedulerExceptionHandler {
    void onThreadPoolFull(TaskType taskType, int i, List<String> list);
}
