package com.taobao.update.datasource;

/* compiled from: Taobao */
public abstract class PatchRunnable implements Runnable {
    private UpdateListener updateListener;

    public PatchRunnable(UpdateListener updateListener2) {
        this.updateListener = updateListener2;
    }

    public UpdateListener getUpdateListener() {
        return this.updateListener;
    }
}
