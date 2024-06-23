package com.youku.live.messagechannel.connection;

/* compiled from: Taobao */
public enum MCConnectionFlag {
    PM(0),
    CDN(1),
    ACCS_MASS(2);
    
    private int code;

    private MCConnectionFlag(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
