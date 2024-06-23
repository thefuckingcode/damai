package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class rf0 implements IExecutorServiceFactory {

    /* compiled from: Taobao */
    class a implements RejectedExecutionHandler {
        @NonNull
        private ExecutorService a;
        final /* synthetic */ ThreadFactory b;
        final /* synthetic */ pf0 c;

        a(rf0 rf0, ThreadFactory threadFactory, pf0 pf0) {
            this.b = threadFactory;
            this.c = pf0;
            this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        public void rejectedExecution(@NonNull Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            ve0.a().g(TaskType.IO, this.c.c());
            this.a.submit(runnable);
        }
    }

    @Override // com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory
    @NonNull
    public ListeningExecutorService createCpuExecutorService(@NonNull pf0 pf0) {
        return new com.alibaba.android.onescheduler.threadpool.a(pf0, TaskType.CPU);
    }

    @Override // com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory
    @NonNull
    public ListeningExecutorService createIOExecutorService(@NonNull pf0 pf0) {
        ThreadFactory threadFactory;
        if (pf0.e() != null) {
            threadFactory = pf0.e();
        } else {
            threadFactory = Executors.defaultThreadFactory();
        }
        int d = pf0.d();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(pf0.a(), pf0.c(), pf0.b(), TimeUnit.MILLISECONDS, d > 0 ? new LinkedBlockingQueue(d) : new SynchronousQueue(), threadFactory, new a(this, threadFactory, pf0));
        threadPoolExecutor.allowCoreThreadTimeOut(pf0.f());
        return MoreExecutors.c(threadPoolExecutor);
    }

    @Override // com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory
    @NonNull
    public ListeningExecutorService createNormalExecutorService(@NonNull pf0 pf0) {
        return new com.alibaba.android.onescheduler.threadpool.a(pf0, TaskType.NORMAL);
    }

    @Override // com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory
    @NonNull
    public ListeningExecutorService createRpcExecutorService(pf0 pf0) {
        return new com.alibaba.android.onescheduler.threadpool.a(pf0, TaskType.RPC);
    }
}
