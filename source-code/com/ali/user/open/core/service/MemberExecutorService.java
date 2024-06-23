package com.ali.user.open.core.service;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* compiled from: Taobao */
public interface MemberExecutorService extends ExecutorService {
    Looper getDefaultLooper();

    void postHandlerTask(Runnable runnable);

    void postTask(Runnable runnable);

    void postUITask(Runnable runnable);
}
