package com.youku.playerservice.axp.p2p;

/* compiled from: Taobao */
public enum PcdnType {
    NONE(0),
    VOD(1),
    DOWNLOAD(2),
    LIVE(3);
    
    private int value;

    private PcdnType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
