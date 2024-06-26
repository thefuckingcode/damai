package com.youku.kubus;

import java.lang.reflect.Method;

@NoProguard
/* compiled from: Taobao */
public interface IEventStatistic {
    void eventHandleBegin(Event event, long j);

    void eventHandleEnd(Event event, long j, long j2);

    void methodInvokeBegin(Event event, Method method, ThreadMode threadMode, long j);

    void methodInvokeEnd(Event event, Method method, ThreadMode threadMode, long j, long j2);

    void methodInvokeFailed(Event event, Method method, ThreadMode threadMode, Throwable th);
}
