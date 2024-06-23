package org.android.spdy;

/* compiled from: Taobao */
enum SslMod {
    SLIGHT_SLL_NOT_ENCRYT(0),
    SLIGHT_SSL_0_RTT(1);
    
    private int code;

    private SslMod(int i) {
        this.code = i;
    }

    /* access modifiers changed from: package-private */
    public int getint() {
        return this.code;
    }
}
