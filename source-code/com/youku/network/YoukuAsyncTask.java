package com.youku.network;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public abstract class YoukuAsyncTask<Params, Progress, Result> {
    private static final LinkedBlockingQueue<Runnable> a;
    private static final ThreadFactory b;
    private static final ThreadPoolExecutor c;
    private static final a d = new a();
    private volatile Status e;

    /* compiled from: Taobao */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a extends Handler {
        private a() {
        }

        public void handleMessage(Message message) {
            b bVar = (b) message.obj;
            int i = message.what;
            if (i == 1) {
                bVar.a.b(bVar.b[0]);
            } else if (i == 2) {
                bVar.a.a((Object[]) bVar.b);
            } else if (i == 3) {
                bVar.a.a();
            }
        }
    }

    /* compiled from: Taobao */
    private static class b<Data> {
        final YoukuAsyncTask a;
        final Data[] b;

        b(YoukuAsyncTask youkuAsyncTask, Data... dataArr) {
            this.a = youkuAsyncTask;
            this.b = dataArr;
        }
    }

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(5);
        a = linkedBlockingQueue;
        AnonymousClass1 r7 = new ThreadFactory() {
            /* class com.youku.network.YoukuAsyncTask.AnonymousClass1 */
            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "YoukuAsyncTask #" + this.a.getAndIncrement());
            }
        };
        b = r7;
        c = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, linkedBlockingQueue, r7, new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(Result result) {
        a(result);
        this.e = Status.FINISHED;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    /* access modifiers changed from: protected */
    public void a(Progress... progressArr) {
    }
}
