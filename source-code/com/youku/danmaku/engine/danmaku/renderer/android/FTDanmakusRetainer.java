package com.youku.danmaku.engine.danmaku.renderer.android;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;

/* compiled from: Taobao */
public class FTDanmakusRetainer extends RLDanmakusRetainer {
    /* access modifiers changed from: protected */
    @Override // com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusRetainer
    public boolean isOutVerticalEdge(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
        return f + baseDanmaku.paintHeight > ((float) iDisplayer.getHeight());
    }
}
