package com.taobao.weex.utils.batch;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class BatchOperationHelper implements Interceptor {
    private BactchExecutor a;
    private CopyOnWriteArrayList<Runnable> b = new CopyOnWriteArrayList<>();
    private boolean c = false;

    public BatchOperationHelper(BactchExecutor bactchExecutor) {
        this.a = bactchExecutor;
        bactchExecutor.setInterceptor(this);
        this.c = true;
    }

    public void flush() {
        this.c = false;
        this.a.post(new Runnable() {
            /* class com.taobao.weex.utils.batch.BatchOperationHelper.AnonymousClass1 */

            public void run() {
                Iterator it = BatchOperationHelper.this.b.iterator();
                while (it.hasNext()) {
                    Runnable runnable = (Runnable) it.next();
                    runnable.run();
                    BatchOperationHelper.this.b.remove(runnable);
                }
            }
        });
        this.a.setInterceptor(null);
    }

    @Override // com.taobao.weex.utils.batch.Interceptor
    public boolean take(Runnable runnable) {
        if (!this.c) {
            return false;
        }
        this.b.add(runnable);
        return true;
    }
}
