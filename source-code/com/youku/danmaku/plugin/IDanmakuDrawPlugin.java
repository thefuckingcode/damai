package com.youku.danmaku.plugin;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import java.util.HashMap;

/* compiled from: Taobao */
public interface IDanmakuDrawPlugin {
    void renderBarrage(BaseDanmaku baseDanmaku);

    void renderBarrage(HashMap<String, String> hashMap, byte[] bArr);
}
