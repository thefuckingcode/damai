package com.alibaba.appmonitor.pool;

/* compiled from: Taobao */
public interface Reusable {
    void clean();

    void fill(Object... objArr);
}
