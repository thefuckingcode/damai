package com.taobao.weex.devtools.inspector.elements;

import com.taobao.weex.devtools.json.annotation.JsonValue;

/* compiled from: Taobao */
public enum Origin {
    INJECTED("injected"),
    USER_AGENT("user-agent"),
    INSPECTOR("inspector"),
    REGULAR("regular");
    
    private final String mValue;

    private Origin(String str) {
        this.mValue = str;
    }

    @JsonValue
    public String getProtocolValue() {
        return this.mValue;
    }
}
