package com.taobao.tao.log.statistics;

/* compiled from: Taobao */
public enum UploadReason {
    UNKNOWN(0),
    SERVER_PULL(1),
    LOCAL_PUSH(2);
    
    private int value;

    private UploadReason(int i) {
        this.value = i;
    }

    public String getValue() {
        return String.valueOf(this.value);
    }
}
