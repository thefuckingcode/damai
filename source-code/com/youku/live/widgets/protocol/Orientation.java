package com.youku.live.widgets.protocol;

/* compiled from: Taobao */
public enum Orientation {
    ORIENTATION_LANDSCAPE("landscape"),
    ORIENTATION_PORTAIT("portait");
    
    private final String mOrientation;

    private Orientation(String str) {
        this.mOrientation = str;
    }

    public String get() {
        return this.mOrientation;
    }
}
