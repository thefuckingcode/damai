package org.android.spdy;

/* compiled from: Taobao */
public enum SslVersion {
    SLIGHT_VERSION_V1(0);
    
    private int code;

    private SslVersion(int i) {
        this.code = i;
    }

    /* access modifiers changed from: package-private */
    public int getint() {
        return this.code;
    }
}
