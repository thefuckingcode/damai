package com.youku.live.messagechannel.session;

/* compiled from: Taobao */
public enum SessionStatus {
    INIT(0),
    OPENING(1),
    OPEN(2),
    CLOSING(3),
    CLOSED(4);
    
    private int code;

    private SessionStatus(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
