package com.taobao.weex.common;

/* compiled from: Taobao */
public enum WXRenderStrategy {
    APPEND_ASYNC("APPEND_ASYNC"),
    APPEND_ONCE("APPEND_ONCE"),
    DATA_RENDER("DATA_RENDER"),
    DATA_RENDER_BINARY("DATA_RENDER_BINARY"),
    JSON_RENDER("JSON_RENDER");
    
    private String flag;

    private WXRenderStrategy(String str) {
        this.flag = str;
    }

    public String getFlag() {
        return this.flag;
    }
}
