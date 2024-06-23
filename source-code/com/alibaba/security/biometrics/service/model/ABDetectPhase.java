package com.alibaba.security.biometrics.service.model;

/* compiled from: Taobao */
public enum ABDetectPhase {
    INIT(0),
    ADJUST_BEGIN(1),
    ADJUST_END(2),
    ACTION_BEGIN(3),
    ACTION_END(4),
    FACE_DETECT(100),
    FINISH(10000);
    
    private int value = -1;

    private ABDetectPhase(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
