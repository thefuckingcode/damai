package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public final class d<TResult> implements ExecuteResult<TResult> {
    Executor a;
    private OnCompleteListener<TResult> b;
    private final Object c = new Object();

    d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.b = onCompleteListener;
        this.a = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.c) {
            this.b = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        this.a.execute(new Runnable() {
            /* class com.huawei.hmf.tasks.a.d.AnonymousClass1 */

            public final void run() {
                synchronized (d.this.c) {
                    if (d.this.b != null) {
                        d.this.b.onComplete(task);
                    }
                }
            }
        });
    }
}
