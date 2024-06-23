package com.youku.danmaku.plugin;

import com.youku.danmaku.engine.controller.DanmakuFilters;

/* compiled from: Taobao */
public interface IDanmakuFilterPlugin {
    DanmakuFilters.IDanmakuFilter<?> getFilter(String str);
}
