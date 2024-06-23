package com.youku.danmaku.engine.danmaku.model.android.stuffer;

import android.graphics.Canvas;
import android.text.TextPaint;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import com.youku.danmaku.engine.danmaku.model.style.BaseExtraStyle;

/* compiled from: Taobao */
public final class YoukuCacheStuffer extends SpannedCacheStuffer {
    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.SpannedCacheStuffer
    public void clearCache(BaseDanmaku baseDanmaku) {
        super.clearCache(baseDanmaku);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.SpannedCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer
    public void clearCaches() {
        super.clearCaches();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer
    public void drawDanmaku(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        displayConfig.definePaintParams(z);
        BaseExtraStyle baseExtraStyle = baseDanmaku.mExtraStyle;
        if (baseExtraStyle != null) {
            baseExtraStyle.drawDanmaku(baseDanmaku, canvas, f, f2, z, displayConfig);
        } else {
            super.drawDanmaku(baseDanmaku, canvas, f, f2, z, displayConfig);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.SpannedCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer
    public void measure(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
        BaseExtraStyle baseExtraStyle = baseDanmaku.mExtraStyle;
        if (baseExtraStyle != null) {
            baseExtraStyle.onMeasure(baseDanmaku, this.mProxy, z, displayConfig);
        } else {
            super.measure(baseDanmaku, textPaint, z, displayConfig);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.SpannedCacheStuffer
    public void releaseResource(BaseDanmaku baseDanmaku) {
        super.releaseResource(baseDanmaku);
        BaseExtraStyle baseExtraStyle = baseDanmaku.mExtraStyle;
        if (baseExtraStyle != null) {
            baseExtraStyle.releaseResource(baseDanmaku);
        }
    }
}
