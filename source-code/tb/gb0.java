package tb;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class gb0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final gb0 INSTANCE = new gb0();
    private static final int a;
    private static final int b;
    private static final int c;
    private static final ThreadFactory d;
    private static final BlockingQueue<Runnable> e;
    private static ThreadPoolExecutor f;

    /* compiled from: Taobao */
    public static final class a implements ThreadFactory {
        private static transient /* synthetic */ IpChange $ipChange;
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @NotNull
        public Thread newThread(@NotNull Runnable runnable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "885998256")) {
                return (Thread) ipChange.ipc$dispatch("885998256", new Object[]{this, runnable});
            }
            k21.i(runnable, UploadQueueMgr.MSGTYPE_REALTIME);
            return new Thread(runnable, "DoloresTask #" + this.a.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        b = max;
        int i = (availableProcessors * 2) + 1;
        c = i;
        a aVar = new a();
        d = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(512);
        e = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i, 30, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f = threadPoolExecutor;
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }

    private gb0() {
    }

    public final void a(@NotNull Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138304919")) {
            ipChange.ipc$dispatch("2138304919", new Object[]{this, runnable});
            return;
        }
        k21.i(runnable, "runnable");
        if (k21.d(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public final void b(@Nullable Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1570554902")) {
            ipChange.ipc$dispatch("-1570554902", new Object[]{this, runnable});
        } else if (runnable != null && (threadPoolExecutor = f) != null) {
            threadPoolExecutor.execute(runnable);
        }
    }
}
