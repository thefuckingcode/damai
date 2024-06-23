package com.taobao.downloader.adpater;

/* compiled from: Taobao */
public interface ThreadExecutor {
    void execute(Runnable runnable, boolean z);

    void postDelayed(Runnable runnable, long j);
}
