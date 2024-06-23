package tb;

import android.util.Log;
import cn.damai.utils.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class os1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ThreadPoolExecutor a;

    /* compiled from: Taobao */
    public static class a extends ThreadPoolExecutor {
        private static transient /* synthetic */ IpChange $ipChange;

        public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            super(i, i2, j, timeUnit, blockingQueue);
        }

        /* access modifiers changed from: protected */
        public void afterExecute(Runnable runnable, Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "111167444")) {
                ipChange.ipc$dispatch("111167444", new Object[]{this, runnable, th});
                return;
            }
            super.afterExecute(runnable, th);
            if (runnable instanceof PriorityTask) {
                Log.d("PriorityExecutor", "afterExecute:" + runnable.toString());
            }
        }

        /* access modifiers changed from: protected */
        public void beforeExecute(Thread thread, Runnable runnable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1138246631")) {
                ipChange.ipc$dispatch("1138246631", new Object[]{this, thread, runnable});
                return;
            }
            super.beforeExecute(thread, runnable);
            if (runnable instanceof PriorityTask) {
                Log.d("PriorityExecutor", "beforeExecute:" + runnable.toString());
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        Log.e("LauncherApplication_xxx", " threadPoolnum: " + availableProcessors);
        a = new a(availableProcessors + 1, (availableProcessors * 2) + 1, 0, TimeUnit.SECONDS, new PriorityBlockingQueue());
    }

    public static void a(PriorityTask priorityTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1090291081")) {
            ipChange.ipc$dispatch("-1090291081", new Object[]{priorityTask});
            return;
        }
        a.execute(priorityTask);
    }
}
