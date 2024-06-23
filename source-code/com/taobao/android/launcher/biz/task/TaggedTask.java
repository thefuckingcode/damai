package com.taobao.android.launcher.biz.task;

import com.taobao.android.job.core.task.Task;
import com.taobao.android.launcher.common.LauncherParam;
import com.taobao.android.launcher.common.LauncherRuntime;

/* compiled from: Taobao */
public abstract class TaggedTask extends Task<String, Void> implements TaggedRunnable {
    private TaggedTask() {
    }

    /* access modifiers changed from: protected */
    public boolean needParam() {
        return true;
    }

    public TaggedTask(String str) {
        setId(str);
    }

    @Override // com.taobao.android.job.core.task.Task
    public Void execute() {
        if (needParam()) {
            run(LauncherRuntime.sApplication, LauncherParam.getParams((String) getId()));
        } else {
            run(LauncherRuntime.sApplication, null);
        }
        return null;
    }
}
