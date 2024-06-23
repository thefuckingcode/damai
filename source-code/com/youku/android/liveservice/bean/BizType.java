package com.youku.android.liveservice.bean;

import android.text.TextUtils;

/* compiled from: Taobao */
public enum BizType {
    UNKNOWN("0"),
    PGC("6", "PGC"),
    OGC("4", "OGC"),
    LF("3", "Laifeng");
    
    private String description;
    private String value;

    private BizType(String str) {
        this(str, null);
    }

    public static BizType getBizTypeByValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        BizType[] values = values();
        for (BizType bizType : values) {
            if (str.equals(bizType.value)) {
                return bizType;
            }
        }
        return UNKNOWN;
    }

    public String getDescription() {
        return this.description;
    }

    public String getValue() {
        return this.value;
    }

    private BizType(String str, String str2) {
        this.value = str;
        this.description = str2;
    }
}
