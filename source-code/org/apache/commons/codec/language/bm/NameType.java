package org.apache.commons.codec.language.bm;

/* compiled from: Taobao */
public enum NameType {
    ASHKENAZI("ash"),
    GENERIC("gen"),
    SEPHARDIC("sep");
    
    private final String name;

    private NameType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
