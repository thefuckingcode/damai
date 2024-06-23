package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;

@Monitor(module = "networkPrefer", monitorPoint = "nettype")
/* compiled from: Taobao */
public class NetTypeStat extends StatObject {
    @Dimension
    public String carrierName = NetworkStatusHelper.c();
    @Dimension
    public int ipStackType;
    @Dimension
    public int lastIpStackType;
    @Dimension
    public String mnc = NetworkStatusHelper.h();
    @Dimension
    public String nat64Prefix;
    @Dimension
    public String netType = NetworkStatusHelper.i().getType();
}
