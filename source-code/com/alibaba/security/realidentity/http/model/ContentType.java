package com.alibaba.security.realidentity.http.model;

/* compiled from: Taobao */
public enum ContentType {
    JSON("application/json"),
    FORM("multipart/form-data");
    
    public String name;

    private ContentType(String str) {
        this.name = str;
    }
}
