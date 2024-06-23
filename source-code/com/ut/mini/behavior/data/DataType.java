package com.ut.mini.behavior.data;

import android.text.TextUtils;

/* compiled from: Taobao */
public enum DataType {
    Begin("b"),
    Event("e");
    
    private final String value;

    private DataType(String str) {
        this.value = str;
    }

    public static DataType getDataType(String str) {
        if (TextUtils.isEmpty(str)) {
            return Event;
        }
        DataType[] values = values();
        for (DataType dataType : values) {
            if (dataType.getValue().equals(str)) {
                return dataType;
            }
        }
        return Event;
    }

    public String getValue() {
        return this.value;
    }
}
