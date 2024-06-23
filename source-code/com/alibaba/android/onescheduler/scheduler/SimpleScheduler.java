package com.alibaba.android.onescheduler.scheduler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.IScheduler;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.task.InnerDepentTask;
import com.alibaba.android.onescheduler.task.InnerOneTask;
import com.alibaba.android.onescheduler.threadpool.ListenableFutureTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import tb.sf0;
import tb.ve0;

/* compiled from: Taobao */
public class SimpleScheduler implements IScheduler {
    private ExecutorService a = Executors.newSingleThreadExecutor(new a(this));
    private Handler b;

    /* compiled from: Taobao */
    class a implements ThreadFactory {
        a(SimpleScheduler simpleScheduler) {
        }

        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Scheduler");
            thread.setPriority(10);
            return thread;
        }
    }

    /* compiled from: Taobao */
    class b extends Handler {
        final /* synthetic */ FutureTask a;
        final /* synthetic */ Executor b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SimpleScheduler simpleScheduler, Looper looper, FutureTask futureTask, Executor executor) {
            super(looper);
            this.a = futureTask;
            this.b = executor;
        }

        public void handleMessage(Message message) {
            ve0.a().e(this.a);
            this.b.execute(this.a);
        }
    }

    /* compiled from: Taobao */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[TaskType.values().length];
            a = iArr;
            iArr[TaskType.IO.ordinal()] = 1;
            a[TaskType.CPU.ordinal()] = 2;
            try {
                a[TaskType.RPC.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.alibaba.android.onescheduler.IScheduler
    public void schedule(@NonNull final InnerOneTask innerOneTask) {
        Executor executor = innerOneTask.getExecutor();
        if (executor == null) {
            int i = c.a[innerOneTask.getTaskType().ordinal()];
            if (i == 1) {
                executor = sf0.c().b();
            } else if (i == 2) {
                executor = sf0.c().a();
            } else if (i != 3) {
                executor = sf0.c().d();
            } else {
                executor = sf0.c().e();
            }
        }
        FutureTask futureTask = innerOneTask.getFutureTask();
        if (innerOneTask instanceof InnerDepentTask) {
            ((ListenableFutureTask) futureTask).addListener(new Runnable() {
                /* class com.alibaba.android.onescheduler.scheduler.SimpleScheduler.AnonymousClass2 */

                public void run() {
                    ((InnerDepentTask) innerOneTask).tryRunSuccessor();
                }
            }, this.a);
        }
        if (innerOneTask.getDelayTime() <= 0 || System.currentTimeMillis() - innerOneTask.getAddedTime() >= innerOneTask.getDelayTime()) {
            ve0.a().e(futureTask);
            executor.execute(futureTask);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = innerOneTask.hashCode();
        obtain.obj = innerOneTask;
        if (this.b == null) {
            this.b = new b(this, Looper.getMainLooper(), futureTask, executor);
        }
        this.b.sendMessageDelayed(obtain, System.currentTimeMillis() - innerOneTask.getAddedTime());
    }
}
