package com.taobao.tao.log.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tb.li2;
import tb.mi2;

/* compiled from: Taobao */
public class TLogThreadPool {
    private ThreadPoolExecutor executor;
    private ThreadPoolExecutor uploadExecutor;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SingletonHolder {
        private static final TLogThreadPool INSTANCE = new TLogThreadPool();

        private SingletonHolder() {
        }
    }

    public static TLogThreadPool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$new$1(Runnable runnable) {
        return new Thread(runnable, "tlog-thread");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$new$2(Runnable runnable) {
        return new Thread(runnable, "tlog-thread");
    }

    public void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public void executeUpload(Runnable runnable) {
        this.uploadExecutor.execute(runnable);
    }

    private TLogThreadPool() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.uploadExecutor = new ThreadPoolExecutor(1, 1, 1, timeUnit, new LinkedBlockingQueue(), mi2.a);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 1, timeUnit, new LinkedBlockingQueue(), li2.a);
        this.executor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.uploadExecutor.allowCoreThreadTimeOut(true);
    }
}
