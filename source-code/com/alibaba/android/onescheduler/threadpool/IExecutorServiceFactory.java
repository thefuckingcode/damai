package com.alibaba.android.onescheduler.threadpool;

import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListeningExecutorService;
import tb.pf0;

/* compiled from: Taobao */
public interface IExecutorServiceFactory {
    @NonNull
    ListeningExecutorService createCpuExecutorService(pf0 pf0);

    @NonNull
    ListeningExecutorService createIOExecutorService(pf0 pf0);

    @NonNull
    ListeningExecutorService createNormalExecutorService(pf0 pf0);

    @NonNull
    ListeningExecutorService createRpcExecutorService(pf0 pf0);
}
