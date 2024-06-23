package com.alibaba.verificationsdk.ui;

/* compiled from: Taobao */
public enum VerifyType {
    SMS(1),
    CALL(2),
    NOCAPTCHA(3),
    MAIL(4),
    SHAKING(5),
    TILTBALL(6),
    LIVENESS(7);
    
    private int value;

    private VerifyType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
