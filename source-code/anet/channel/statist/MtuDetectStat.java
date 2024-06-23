package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;

@Monitor(module = "networkPrefer", monitorPoint = "mtuDetect")
/* compiled from: Taobao */
public class MtuDetectStat extends StatObject {
    @Dimension
    public String bssid = NetworkStatusHelper.k();
    @Dimension
    public int errCode;
    @Dimension
    public String ip;
    @Dimension
    public String mnc = NetworkStatusHelper.h();
    @Dimension
    public int mtu;
    @Dimension
    public String nettype = NetworkStatusHelper.e();
    @Dimension
    public int pingSuccessCount;
    @Dimension
    public int pingTimeoutCount;
    @Dimension
    public String rtt;
}
