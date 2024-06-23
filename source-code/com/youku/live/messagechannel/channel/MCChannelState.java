package com.youku.live.messagechannel.channel;

/* compiled from: Taobao */
public enum MCChannelState {
    INIT(0),
    OPENING(1),
    OPENED(2),
    CLOSED(4);
    
    private int code;

    private MCChannelState(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
