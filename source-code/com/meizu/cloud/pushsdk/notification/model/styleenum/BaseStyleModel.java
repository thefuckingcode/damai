package com.meizu.cloud.pushsdk.notification.model.styleenum;

/* compiled from: Taobao */
public enum BaseStyleModel {
    FLYME(0),
    PURE_PICTURE(1),
    ANDROID(2);
    
    private final int code;

    private BaseStyleModel(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
