package com.huawei.hms.framework.common;

/* compiled from: Taobao */
public class RunnableEnhance implements Runnable {
    static final String TRANCELOGO = " -->";
    private String parentName = Thread.currentThread().getName();
    private Runnable proxy;

    RunnableEnhance(Runnable runnable) {
        this.proxy = runnable;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void run() {
        this.proxy.run();
    }
}
