package com.taobao.android.dinamicx.template.download;

/* compiled from: Taobao */
public class DXPriorityRunnable implements Runnable {
    long SEQ;
    public final int priority;
    private final Runnable runnable;

    public DXPriorityRunnable(int i, Runnable runnable2) {
        this.priority = i;
        this.runnable = runnable2;
    }

    public final void run() {
        this.runnable.run();
    }
}
