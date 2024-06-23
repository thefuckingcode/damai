package com.taobao.rxm.schedule;

/* compiled from: Taobao */
public interface SchedulerSupplier {
    Scheduler forCpuBound();

    Scheduler forDecode();

    Scheduler forIoBound();

    Scheduler forNetwork();

    Scheduler forUiThread();
}
