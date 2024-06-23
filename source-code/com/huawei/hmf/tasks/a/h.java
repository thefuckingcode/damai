package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public final class h<TResult> implements ExecuteResult<TResult> {
    private OnSuccessListener<TResult> a;
    private Executor b;
    private final Object c = new Object();

    h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.a = onSuccessListener;
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
        if (task.isSuccessful() && !task.isCanceled()) {
            this.b.execute(new Runnable() {
                /* class com.huawei.hmf.tasks.a.h.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.huawei.hmf.tasks.OnSuccessListener */
                /* JADX WARN: Multi-variable type inference failed */
                public final void run() {
                    synchronized (h.this.c) {
                        if (h.this.a != null) {
                            h.this.a.onSuccess(task.getResult());
                        }
                    }
                }
            });
        }
    }
}
