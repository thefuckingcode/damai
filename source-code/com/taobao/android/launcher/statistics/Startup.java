package com.taobao.android.launcher.statistics;

import android.content.Context;
import com.taobao.android.job.core.task.ExecutionSummary;
import java.util.Map;

/* compiled from: Taobao */
public abstract class Startup {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class Lazy {
        static final Startup instance = new StartupDefaultImpl();

        Lazy() {
        }
    }

    Startup() {
    }

    public abstract void addJank(int i, long j);

    public abstract void addStage(String str, ExecutionSummary executionSummary, Map<String, ExecutionSummary> map);

    public abstract void dump(Context context);

    public abstract void start();

    public abstract void submit(Context context);

    public abstract void teardown();
}
