package com.youku.danmaku.engine.danmaku.model.objectpool;

import com.youku.danmaku.engine.danmaku.model.objectpool.Poolable;

/* compiled from: Taobao */
public interface Pool<T extends Poolable<T>> {
    T acquire();

    void release(T t);
}
