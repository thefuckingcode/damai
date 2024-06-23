package com.youku.alixplayer.opensdk;

/* compiled from: Taobao */
public enum PlayType {
    VOD(0),
    URL(2),
    LIVE(1);
    
    private int value;

    private PlayType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
