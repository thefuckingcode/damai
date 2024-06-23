package com.youku.middlewareservice.provider.task;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.DelayType;
import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.task.a;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tb.yk1;

/* compiled from: Taobao */
public class YKExecutorService extends ThreadPoolExecutor {
    private static SharedPreferences sp;
    private String groupName;
    private int index = 0;
    private boolean use = true;

    public YKExecutorService(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        allowCoreThreadTimeOut(true);
        setRejectedExecutionHandler(new RejectedExecutionHandler(str) {
            /* class com.youku.middlewareservice.provider.task.YKExecutorService.AnonymousClass1 */
            private ExecutorService executorService;
            final /* synthetic */ String val$groupName;

            {
                this.val$groupName = r10;
                this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory(r10));
            }

            public void rejectedExecution(@NonNull Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                this.executorService.submit(runnable);
            }
        });
        this.groupName = str;
        if (AppInfoProviderProxy.getAppContext() != null) {
            SharedPreferences sharedPreferences = AppInfoProviderProxy.getAppContext().getSharedPreferences("OneSchedulerConfig", 0);
            sp = sharedPreferences;
            if (sharedPreferences != null) {
                this.use = sharedPreferences.getBoolean("use", true);
            }
        }
    }

    public void execute(Runnable runnable) {
        String str;
        if (this.use) {
            if (yk1.g().f(this.groupName) == null) {
                yk1.g().a(this.groupName, 10);
            }
            a f = yk1.g().h().setRunnable(runnable).setTaskGroup(this.groupName);
            if (runnable instanceof YKRunnable) {
                YKRunnable yKRunnable = (YKRunnable) runnable;
                str = yKRunnable.getName();
                TaskType type = yKRunnable.getType();
                if (type != null) {
                    f.setTaskType(TaskType.fromValue(type.getValue()));
                }
                Priority priority = yKRunnable.getPriority();
                if (priority != null) {
                    f.setPriority(Priority.fromValue(priority.getValue()));
                }
                DelayType delayType = yKRunnable.getDelayType();
                if (delayType != null) {
                    f.setIsFixDelayed(DelayType.fromValue(delayType.getValue()));
                    f.setDelayTime(yKRunnable.getDelayTime());
                    f.setInitialDelayTime(yKRunnable.getInitialDelayTime());
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(this.groupName);
                sb.append(" task ");
                int i = this.index;
                this.index = i + 1;
                sb.append(i);
                str = sb.toString();
            }
            f.setTaskName(str).buildCommonTask().run();
            return;
        }
        super.execute(runnable);
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void pauseSelf() {
        if (this.use) {
            yk1.g().i(this.groupName);
        }
    }

    public void resumeSelf() {
        if (this.use) {
            yk1.g().l(this.groupName);
        }
    }
}
