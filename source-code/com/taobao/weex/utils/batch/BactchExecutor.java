package com.taobao.weex.utils.batch;

/* compiled from: Taobao */
public interface BactchExecutor {
    void post(Runnable runnable);

    void setInterceptor(Interceptor interceptor);
}
