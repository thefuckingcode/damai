package com.taobao.update.adapter;

/* compiled from: Taobao */
public interface ThreadExecutor {
    void delayExecute(Runnable runnable, int i);

    void execute(Runnable runnable);
}
