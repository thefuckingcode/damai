package com.ut.mini.behavior.data;

import android.text.TextUtils;
import tb.o70;

/* compiled from: Taobao */
public enum LogicalType {
    AND(o70.AND_PREFIX),
    OR(o70.OR_PREFIX);
    
    private final String value;

    private LogicalType(String str) {
        this.value = str;
    }

    public static LogicalType getLogicalType(String str) {
        if (TextUtils.isEmpty(str)) {
            return AND;
        }
        LogicalType[] values = values();
        for (LogicalType logicalType : values) {
            if (logicalType.getValue().equals(str)) {
                return logicalType;
            }
        }
        return AND;
    }

    public static boolean isLogicalType(String str) {
        return AND.getValue().equals(str) || OR.getValue().equals(str);
    }

    public String getValue() {
        return this.value;
    }
}
