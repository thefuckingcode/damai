package com.youku.danmaku.engine.danmaku.model.danmaku;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.Duration;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;

/* compiled from: Taobao */
public class FTDanmaku extends BaseDanmaku {
    private float[] RECT = null;
    private int mLastDispWidth;
    private float mLastLeft;
    private float mLastPaintWidth;
    private float positionY = -1.0f;
    private float x = 0.0f;
    protected float y = -1.0f;

    public FTDanmaku(Duration duration) {
        this.duration = duration;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getBottom() {
        return this.y + this.paintHeight;
    }

    /* access modifiers changed from: protected */
    public float getLeft(IDisplayer iDisplayer) {
        if (this.mLastDispWidth == iDisplayer.getWidth() && this.mLastPaintWidth == this.paintWidth) {
            return this.mLastLeft;
        }
        float width = (((float) iDisplayer.getWidth()) - this.paintWidth) / 2.0f;
        this.mLastDispWidth = iDisplayer.getWidth();
        this.mLastPaintWidth = this.paintWidth;
        this.mLastLeft = width;
        return width;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getPositionY() {
        return this.positionY;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float[] getRectAtTime(IDisplayer iDisplayer, long j) {
        if (!isMeasured()) {
            return null;
        }
        float left = getLeft(iDisplayer);
        if (this.RECT == null) {
            this.RECT = new float[4];
        }
        float[] fArr = this.RECT;
        fArr[0] = left;
        float f = this.y;
        fArr[1] = f;
        fArr[2] = left + this.paintWidth;
        fArr[3] = f + this.paintHeight;
        return fArr;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getRight() {
        return this.x + this.paintWidth;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getTop() {
        return this.y;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public int getType() {
        return 5;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void layout(IDisplayer iDisplayer, float f, float f2) {
        DanmakuTimer danmakuTimer = this.mTimer;
        if (danmakuTimer != null) {
            long j = danmakuTimer.currMillisecond - this.time;
            if (j < 0 || j >= this.duration.value) {
                setVisibility(false);
                this.y = -1.0f;
                this.x = (float) iDisplayer.getWidth();
            } else if (!isShown()) {
                this.x = getLeft(iDisplayer);
                this.y = f2;
                setVisibility(true);
            }
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void reset() {
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void setPositionX(float f) {
        this.x = f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void setPositionY(float f) {
        this.positionY = f;
        this.y = f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getLeft() {
        return this.x;
    }
}
