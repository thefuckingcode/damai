package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;

@Monitor(module = "networkPrefer", monitorPoint = "policyVersion")
/* compiled from: Taobao */
public class PolicyVersionStat extends StatObject {
    @Dimension
    public String host;
    @Dimension
    public String mnc = NetworkStatusHelper.h();
    @Dimension
    public String netType = NetworkStatusHelper.e();
    @Dimension
    public int reportType;
    @Dimension
    public int version;

    public PolicyVersionStat(String str, int i) {
        this.host = str;
        this.version = i;
    }
}
