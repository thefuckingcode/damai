package com.youku.live.messagechannel.callback;

/* compiled from: Taobao */
public enum MCChannelEvent {
    OPEN_SUCCESS(1001),
    OPEN_FAIL(1002),
    CLOSE_SUCCESS(2001),
    CLOSE_FAIL(2002),
    DEVICE_ONLINE(3001),
    DEVICE_OFFLINE(3002);
    
    private int code;

    private MCChannelEvent(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
