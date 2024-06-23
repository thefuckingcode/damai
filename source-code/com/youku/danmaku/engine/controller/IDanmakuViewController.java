package com.youku.danmaku.engine.controller;

import android.content.Context;

/* compiled from: Taobao */
public interface IDanmakuViewController {
    void clear();

    long drawDanmakus();

    Context getContext();

    int getHeight();

    int getWidth();

    boolean isDanmakuDrawingCacheEnabled();

    boolean isHardwareAccelerated();

    boolean isViewReady();
}
