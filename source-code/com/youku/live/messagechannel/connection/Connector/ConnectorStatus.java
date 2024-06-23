package com.youku.live.messagechannel.connection.Connector;

/* compiled from: Taobao */
public enum ConnectorStatus {
    INIT(0),
    OPENING(1),
    OPEN(2),
    CLOSED(3);
    
    private int code;

    private ConnectorStatus(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
