package com.taobao.android.launcher.biz.task;

import com.taobao.android.launcher.statistics.TaoTrace;

/* compiled from: Taobao */
public abstract class DeferrableTask extends TaggedTask {
    private static final String CATEGORY = "defer";

    public DeferrableTask(String str) {
        super(str);
        shouldRunImmediately(true);
    }

    @Override // com.taobao.android.job.core.task.Task, com.taobao.android.launcher.biz.task.TaggedTask, com.taobao.android.launcher.biz.task.TaggedTask
    public Void execute() {
        TaoTrace.start(CATEGORY, (String) getId());
        Void execute = super.execute();
        TaoTrace.end(CATEGORY, (String) getId());
        return execute;
    }
}
