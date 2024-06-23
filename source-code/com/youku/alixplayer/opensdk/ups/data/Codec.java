package com.youku.alixplayer.opensdk.ups.data;

/* compiled from: Taobao */
public enum Codec {
    H264(0),
    H265(1),
    AV1(2);
    
    private final int mValue;

    private Codec(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
