package com.alibaba.security.biometrics.jni;

/* compiled from: Taobao */
public enum ABJniDetectType {
    DETECT_TYPE_BLINK(1),
    DETECT_TYPE_MOUTH(2),
    DETECT_TYPE_YAW(3),
    DETECT_TYPE_PITCH(4),
    DETECT_TYPE_STILL(11),
    DETECT_TYPE_AIMLESS(-1),
    DETECT_TYPE_BLINK_STILL(21),
    DETECT_TYPE_MOUTH_STILL(22),
    DETECT_TYPE_YAW_STILL(23),
    DETECT_TYPE_PITCH_STILL(24);
    
    private static String[] CHINESE_NAME = {"请眨眼", "请张嘴", "请左右摇头", "请上下点头", "请注视屏幕", "", "请眨眼", "请张嘴", "请左右摇头", "请上下点头"};
    private int value;

    private ABJniDetectType(int i) {
        this.value = i;
    }

    public static ABJniDetectType getStillAction(ABJniDetectType aBJniDetectType) {
        return aBJniDetectType.ordinal() < 4 ? valueOf(aBJniDetectType.value + 20) : aBJniDetectType;
    }

    public final String getMessage() {
        return CHINESE_NAME[ordinal()];
    }

    public final int getValue() {
        return this.value;
    }

    public static ABJniDetectType valueOf(int i) {
        if (i == -1) {
            return DETECT_TYPE_AIMLESS;
        }
        if (i == 11) {
            return DETECT_TYPE_STILL;
        }
        if (i == 1) {
            return DETECT_TYPE_BLINK;
        }
        if (i == 2) {
            return DETECT_TYPE_MOUTH;
        }
        if (i == 3) {
            return DETECT_TYPE_YAW;
        }
        if (i == 4) {
            return DETECT_TYPE_PITCH;
        }
        switch (i) {
            case 21:
                return DETECT_TYPE_BLINK_STILL;
            case 22:
                return DETECT_TYPE_MOUTH_STILL;
            case 23:
                return DETECT_TYPE_YAW_STILL;
            case 24:
                return DETECT_TYPE_PITCH_STILL;
            default:
                return DETECT_TYPE_AIMLESS;
        }
    }
}
