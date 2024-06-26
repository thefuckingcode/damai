package com.alibaba.aliweex.plugin;

import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
interface WorkFlow$Flowable<T, R> {

    /* compiled from: Taobao */
    public interface OnActionCall<R> {
        void onCall(R r);
    }

    /* compiled from: Taobao */
    public enum RunThread {
        CURRENT,
        UI,
        SUB,
        NEW,
        SERIALTASK
    }

    WorkFlow$Flow countFlow(CountDownLatch countDownLatch);

    b<T, R> currentThread();

    WorkFlow$Flow flow();

    void flowToNext(T t);

    WorkFlow$Flow getContext();

    R getResult();

    boolean hasNext();

    boolean isLooping();

    b<T, R> newThread();

    WorkFlow$Flowable<R, ?> next();

    void onActionCall(OnActionCall<R> onActionCall);

    WorkFlow$Flowable<?, T> prior();

    void scheduleFlow(T t);

    b<T, R> serialTask();

    b<T, R> serialTask(int i);

    <A extends WorkFlow$Action<T, R>> WorkFlow$Flowable<T, R> setAction(A a);

    WorkFlow$Flowable<T, R> setContext(WorkFlow$Flow workFlow$Flow);

    WorkFlow$Flowable<T, R> setNext(WorkFlow$Flowable<R, ?> workFlow$Flowable);

    WorkFlow$Flowable<T, R> setPrior(WorkFlow$Flowable<?, T> workFlow$Flowable);

    b<T, R> subThread();

    b<T, R> uiThread();
}
