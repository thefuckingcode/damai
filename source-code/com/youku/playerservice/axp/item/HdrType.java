package com.youku.playerservice.axp.item;

/* compiled from: Taobao */
public enum HdrType {
    NO_HDR(0),
    YK_HDR(1),
    PW_HDR(2),
    HDR_10(3);
    
    private final int mValue;

    private HdrType(int i) {
        this.mValue = i;
    }
}
