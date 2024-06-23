package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;

@Monitor(module = "networkPrefer", monitorPoint = "CustomFrame")
/* compiled from: Taobao */
public class CustomFrameStat extends StatObject {
    @Dimension
    public int errCode;
    @Dimension
    public String host;
    @Dimension
    public boolean isAccs;
    @Dimension
    public String netType = NetworkStatusHelper.i().toString();
    @Dimension
    public int ret = 0;

    public String toString() {
        return "CustomFrameStat{host='" + this.host + '\'' + ", isAccs=" + this.isAccs + ", ret=" + this.ret + ", errCode=" + this.errCode + ", netType='" + this.netType + '\'' + '}';
    }
}
