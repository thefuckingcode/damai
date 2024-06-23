package com.youku.danmaku.engine.danmaku.model;

/* compiled from: Taobao */
public interface IDanmakuIterator {
    boolean hasNext();

    BaseDanmaku next();

    void remove();

    void reset();
}
