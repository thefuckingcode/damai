package com.youku.alixplayer.opensdk.statistics.track.business;

/* compiled from: Taobao */
public class SeiDelay {
    public String localTimestamp = "0";
    public long mDelay = 0;
    public long ntpOffset;
    public String seiTimestamp = "0";

    public void reset() {
        this.mDelay = 0;
        this.seiTimestamp = "0";
        this.ntpOffset = 0;
        this.localTimestamp = "0";
    }
}
