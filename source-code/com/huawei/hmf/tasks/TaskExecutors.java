package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: Taobao */
public final class TaskExecutors {
    private static final TaskExecutors INSTANCE = new TaskExecutors();
    private final ExecutorService mBackground = a.a();
    private final Executor mImmediate = new ImmediateExecutor();
    private final Executor mUiThread = a.b();

    /* compiled from: Taobao */
    static final class ImmediateExecutor implements Executor {
        ImmediateExecutor() {
        }

        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private TaskExecutors() {
    }

    static ExecutorService background() {
        return INSTANCE.mBackground;
    }

    public static Executor immediate() {
        return INSTANCE.mImmediate;
    }

    public static Executor uiThread() {
        return INSTANCE.mUiThread;
    }
}
