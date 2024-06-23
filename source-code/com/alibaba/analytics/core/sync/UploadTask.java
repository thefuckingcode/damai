package com.alibaba.analytics.core.sync;

/* compiled from: Taobao */
public class UploadTask implements Runnable {
    public void run() {
        UploadQueueMgr.getInstance().add("i");
    }
}
