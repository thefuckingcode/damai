package com.youku.danmaku.engine.danmaku.model.objectpool;

import com.youku.danmaku.engine.danmaku.model.objectpool.Poolable;

/* compiled from: Taobao */
public interface PoolableManager<T extends Poolable<T>> {
    T newInstance();

    void onAcquired(T t);

    void onReleased(T t);
}
