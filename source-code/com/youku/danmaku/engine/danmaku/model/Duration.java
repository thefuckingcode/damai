package com.youku.danmaku.engine.danmaku.model;

/* compiled from: Taobao */
public class Duration {
    public float factor = 1.0f;
    public long mInitialDuration;
    public long value;

    public Duration(long j) {
        this.mInitialDuration = j;
        this.value = j;
    }

    public void setFactor(float f) {
        if (this.factor != f) {
            this.factor = f;
            this.value = (long) (((float) this.mInitialDuration) * f);
        }
    }

    public void setValue(long j) {
        this.mInitialDuration = j;
        this.value = (long) (((float) j) * this.factor);
    }

    public void setFactor(float f, long j) {
        this.mInitialDuration = j;
        this.factor = f;
        this.value = (long) (((float) j) * f);
    }
}
