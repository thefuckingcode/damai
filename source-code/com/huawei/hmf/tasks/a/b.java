package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public final class b<TResult> implements ExecuteResult<TResult> {
    private OnCanceledListener a;
    private Executor b;
    private final Object c = new Object();

    b(Executor executor, OnCanceledListener onCanceledListener) {
        this.a = onCanceledListener;
        this.b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.b.execute(new Runnable() {
                /* class com.huawei.hmf.tasks.a.b.AnonymousClass1 */

                public final void run() {
                    synchronized (b.this.c) {
                        if (b.this.a != null) {
                            b.this.a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
