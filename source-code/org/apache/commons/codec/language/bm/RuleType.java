package org.apache.commons.codec.language.bm;

/* compiled from: Taobao */
public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES("rules");
    
    private final String name;

    private RuleType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
