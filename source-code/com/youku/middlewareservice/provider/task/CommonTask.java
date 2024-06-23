package com.youku.middlewareservice.provider.task;

import com.alibaba.android.onescheduler.DelayType;
import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.TaskTracker;

/* compiled from: Taobao */
public class CommonTask implements OneCommonTask {
    private OneCommonTask oneCommonTask;

    public CommonTask(OneCommonTask oneCommonTask2) {
        this.oneCommonTask = oneCommonTask2;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void cancel(boolean z) {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            oneCommonTask2.cancel(z);
        }
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public long getAddedTime() {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            return oneCommonTask2.getAddedTime();
        }
        return 0;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public Object getData() {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            return oneCommonTask2.getData();
        }
        return null;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public long getDelayTime() {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            return oneCommonTask2.getDelayTime();
        }
        return 0;
    }

    public DelayType getDelayType() {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            return oneCommonTask2.getDelayType();
        }
        return null;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public String getGroupName() {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            return oneCommonTask2.getGroupName();
        }
        return null;
    }

    public long getInitialDelayTime() {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            return oneCommonTask2.getInitialDelayTime();
        }
        return 0;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public String getName() {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            return oneCommonTask2.getName();
        }
        return null;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public boolean isCancelled() {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            return oneCommonTask2.isCancelled();
        }
        return false;
    }

    public void run() {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            oneCommonTask2.run();
        }
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void setAddedTime(long j) {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            oneCommonTask2.setAddedTime(j);
        }
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void setData(Object obj) {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            oneCommonTask2.setData(obj);
        }
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void setTaskTracker(TaskTracker taskTracker) {
        OneCommonTask oneCommonTask2 = this.oneCommonTask;
        if (oneCommonTask2 != null) {
            oneCommonTask2.setTaskTracker(taskTracker);
        }
    }
}
