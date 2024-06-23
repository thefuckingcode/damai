package com.alipay.android.phone.mobilesdk.socketcraft.monitor;

/* compiled from: Taobao */
public class SimpleStatistical {
    public long connectedTime = 0;
    public long disconnectedTime = 0;
    public long dnsTime = -1;
    public long endConnAllTime = 0;
    public long recvMsgCount = 0;
    public String recvMsgLenArray = "";
    public long sendMsgCount = 0;
    public String sendMsgLenArray = "";
    public long sslTime = -1;
    public long startConnAllTime = 0;
    public String targetHost = "";
    public long tcpTime = -1;
    public long wsHsTime = -1;

    public long getConnAllTime() {
        long j = this.startConnAllTime;
        if (j <= 0) {
            return -1;
        }
        long j2 = this.endConnAllTime;
        if (j2 > j) {
            return j2 - j;
        }
        return -1;
    }

    public long getLinkLiveTime() {
        long j = this.connectedTime;
        if (j <= 0) {
            return -1;
        }
        long j2 = this.disconnectedTime;
        if (j2 > j) {
            return j2 - j;
        }
        return -1;
    }
}
