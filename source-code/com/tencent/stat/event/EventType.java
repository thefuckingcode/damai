package com.tencent.stat.event;

/* compiled from: Taobao */
public enum EventType {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(1002);
    
    private int v;

    private EventType(int i) {
        this.v = i;
    }

    public int GetIntValue() {
        return this.v;
    }
}
