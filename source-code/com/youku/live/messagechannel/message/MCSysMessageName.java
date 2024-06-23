package com.youku.live.messagechannel.message;

/* compiled from: Taobao */
public enum MCSysMessageName {
    SYS_PROBE("SYS_PROBE"),
    SYS_MASS_SUBSCRIBE("SYS_MASS_SUBSCRIBE");
    
    private String name;

    private MCSysMessageName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
