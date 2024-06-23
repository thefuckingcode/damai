package com.youku.live.messagechannel.callback;

/* compiled from: Taobao */
public enum MCHeartbeatEvent {
    START_SUCCESS(1, "Heartbeat start success."),
    START_FAIL(2, "Heartbeat start fail."),
    STOP_SUCCESS(3, "Heartbeat stop success."),
    STOP_FAIL(4, "Heartbeat stop fail.");
    
    private int code;
    private String msg;

    private MCHeartbeatEvent(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
