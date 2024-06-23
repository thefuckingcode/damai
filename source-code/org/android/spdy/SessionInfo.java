package org.android.spdy;

/* compiled from: Taobao */
public class SessionInfo {
    private static int INVALID_PUBLIC_SEQNUM = -1;
    private String certHost = null;
    private int cong_control;
    private int connTimeoutMs;
    private String domain;
    private String host;
    private int mode;
    private int port;
    private String proxyHost;
    private int proxyPort;
    private int pubkey_seqnum;
    private SessionCb sessionCb;
    private Object sessionUserData;
    private boolean xqcLossDetect = false;
    private int xqc_pacing;

    public SessionInfo(String str, int i, String str2, String str3, int i2, Object obj, SessionCb sessionCb2, int i3) {
        this.host = str;
        this.port = i;
        this.domain = str2;
        this.proxyHost = str3;
        this.proxyPort = i2;
        this.sessionUserData = obj;
        this.sessionCb = sessionCb2;
        this.mode = i3;
        this.pubkey_seqnum = INVALID_PUBLIC_SEQNUM;
        this.connTimeoutMs = -1;
        this.cong_control = 0;
        this.xqc_pacing = 0;
        this.xqcLossDetect = false;
    }

    /* access modifiers changed from: package-private */
    public String getAuthority() {
        if (this.proxyHost == null || this.proxyPort == 0) {
            return this.host + ":" + this.port;
        }
        return this.host + ":" + this.port + "/" + this.proxyHost + ":" + this.proxyPort;
    }

    /* access modifiers changed from: package-private */
    public String getCertHost() {
        if (this.pubkey_seqnum != INVALID_PUBLIC_SEQNUM) {
            return null;
        }
        return this.certHost;
    }

    /* access modifiers changed from: package-private */
    public int getConnectionTimeoutMs() {
        return this.connTimeoutMs;
    }

    /* access modifiers changed from: package-private */
    public String getDomain() {
        return this.domain;
    }

    /* access modifiers changed from: package-private */
    public int getMode() {
        return this.mode;
    }

    /* access modifiers changed from: package-private */
    public int getPubKeySeqNum() {
        return this.pubkey_seqnum;
    }

    /* access modifiers changed from: package-private */
    public SessionCb getSessionCb() {
        return this.sessionCb;
    }

    /* access modifiers changed from: package-private */
    public Object getSessonUserData() {
        return this.sessionUserData;
    }

    /* access modifiers changed from: package-private */
    public int getXquicCongControl() {
        return this.cong_control;
    }

    /* access modifiers changed from: package-private */
    public boolean getXquicLossDetect() {
        return this.xqcLossDetect;
    }

    /* access modifiers changed from: package-private */
    public int getXquicPacing() {
        return this.xqc_pacing;
    }

    public void setCertHost(String str) {
        this.certHost = str;
    }

    public void setConnectionTimeoutMs(int i) {
        this.connTimeoutMs = i;
    }

    public void setPubKeySeqNum(int i) {
        this.pubkey_seqnum = i;
    }

    public void setXquicCongControl(int i) {
        this.cong_control = i;
    }

    public void setXquicLossDetect(boolean z) {
        this.xqcLossDetect = z;
    }

    public void setXquicPacing(int i) {
        this.xqc_pacing = i;
    }
}
