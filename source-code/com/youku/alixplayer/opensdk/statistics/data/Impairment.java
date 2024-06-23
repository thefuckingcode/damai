package com.youku.alixplayer.opensdk.statistics.data;

/* compiled from: Taobao */
public class Impairment {
    public double impairmentInterval = 0.0d;
    public float loadingPosition;
    public float playLoadingEndTime;
    public float playLoadingStartTime;

    public double getImpairmentDuration() {
        return (double) (this.playLoadingEndTime - this.playLoadingStartTime);
    }

    public void reset() {
        this.loadingPosition = 0.0f;
    }
}
