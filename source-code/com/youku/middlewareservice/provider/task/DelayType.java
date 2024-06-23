package com.youku.middlewareservice.provider.task;

/* compiled from: Taobao */
public enum DelayType {
    ONE(1),
    FIXED_RATE(2),
    FIXED_DELAY(3);
    
    private int value;

    private DelayType(int i) {
        this.value = i;
    }

    public static DelayType fromValue(int i) {
        DelayType[] values = values();
        for (DelayType delayType : values) {
            if (delayType.getValue() == i) {
                return delayType;
            }
        }
        return ONE;
    }

    public int getValue() {
        return this.value;
    }
}
