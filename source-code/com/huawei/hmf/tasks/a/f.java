package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public final class f<TResult> implements ExecuteResult<TResult> {
    private OnFailureListener a;
    private Executor b;
    private final Object c = new Object();

    f(Executor executor, OnFailureListener onFailureListener) {
        this.a = onFailureListener;
        this.b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            this.b.execute(new Runnable() {
                /* class com.huawei.hmf.tasks.a.f.AnonymousClass1 */

                public final void run() {
                    synchronized (f.this.c) {
                        if (f.this.a != null) {
                            f.this.a.onFailure(task.getException());
                        }
                    }
                }
            });
        }
    }
}
