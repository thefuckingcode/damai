package com.youku.danmaku.engine.danmaku.model.objectpool;

/* compiled from: Taobao */
public interface Poolable<T> {
    T getNextPoolable();

    boolean isPooled();

    void setNextPoolable(T t);

    void setPooled(boolean z);
}
