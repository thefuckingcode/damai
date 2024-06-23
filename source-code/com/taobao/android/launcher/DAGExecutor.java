package com.taobao.android.launcher;

import androidx.annotation.NonNull;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class DAGExecutor extends ThreadPoolExecutor {
    private final Interceptor interceptor;

    /* compiled from: Taobao */
    public interface Interceptor {
        boolean adjustParam(@NonNull DAGExecutorParam dAGExecutorParam);
    }

    DAGExecutor(int i) {
        this(i, i);
    }

    /* access modifiers changed from: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
        if (this.interceptor != null) {
            DAGExecutorParam dAGExecutorParam = new DAGExecutorParam();
            dAGExecutorParam.maxPoolSize = getMaximumPoolSize();
            dAGExecutorParam.priority = thread.getPriority();
            dAGExecutorParam.coreSize = getCorePoolSize();
            if (this.interceptor.adjustParam(dAGExecutorParam)) {
                setCorePoolSize(dAGExecutorParam.coreSize);
                setMaximumPoolSize(dAGExecutorParam.maxPoolSize);
                thread.setPriority(dAGExecutorParam.priority);
            }
        }
        super.beforeExecute(thread, runnable);
    }

    DAGExecutor(int i, int i2) {
        this(i, i2, null);
    }

    DAGExecutor(int i, int i2, Interceptor interceptor2) {
        this(i, i2, interceptor2, null);
    }

    DAGExecutor(int i, int i2, Interceptor interceptor2, ThreadFactory threadFactory) {
        super(i, i2, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), threadFactory);
        allowCoreThreadTimeOut(true);
        this.interceptor = interceptor2;
    }
}
