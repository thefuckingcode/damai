package com.meizu.cloud.pushsdk.notification.model.styleenum;

/* compiled from: Taobao */
public enum InnerStyleLayout {
    EXPANDABLE_STANDARD(0),
    EXPANDABLE_TEXT(1),
    EXPANDABLE_PIC(2),
    EXPANDABLE_VIDEO(3);
    
    private final int code;

    private InnerStyleLayout(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
