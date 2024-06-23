package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class RequestExecutor {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class DefaultThreadFactory implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        /* compiled from: Taobao */
        private static class ProcessPriorityThread extends Thread {
            private final int mPriority;

            ProcessPriorityThread(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.mPriority = i;
            }

            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        DefaultThreadFactory(@NonNull String str, int i) {
            this.mThreadName = str;
            this.mPriority = i;
        }

        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        HandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (!this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class ReplyRunnable<T> implements Runnable {
        @NonNull
        private Callable<T> mCallable;
        @NonNull
        private Consumer<T> mConsumer;
        @NonNull
        private Handler mHandler;

        ReplyRunnable(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
            this.mCallable = callable;
            this.mConsumer = consumer;
            this.mHandler = handler;
        }

        public void run() {
            final T t;
            try {
                t = this.mCallable.call();
            } catch (Exception unused) {
                t = null;
            }
            final Consumer<T> consumer = this.mConsumer;
            this.mHandler.post(new Runnable() {
                /* class androidx.core.provider.RequestExecutor.ReplyRunnable.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: androidx.core.util.Consumer */
                /* JADX WARN: Multi-variable type inference failed */
                public void run() {
                    consumer.accept(t);
                }
            });
        }
    }

    private RequestExecutor() {
    }

    static ThreadPoolExecutor createDefaultExecutor(@NonNull String str, int i, @IntRange(from = 0) int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Executor createHandlerExecutor(@NonNull Handler handler) {
        return new HandlerExecutor(handler);
    }

    static <T> void execute(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.create(), callable, consumer));
    }

    static <T> T submit(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, @IntRange(from = 0) int i) throws InterruptedException {
        try {
            return executorService.submit(callable).get((long) i, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
