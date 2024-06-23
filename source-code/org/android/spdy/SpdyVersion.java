package org.android.spdy;

/* compiled from: Taobao */
public enum SpdyVersion {
    SPDY2(2),
    SPDY3(3),
    SPDY3DOT1(4);
    
    private int version;

    private SpdyVersion(int i) {
        this.version = i;
    }

    /* access modifiers changed from: package-private */
    public int getInt() {
        return this.version;
    }
}
