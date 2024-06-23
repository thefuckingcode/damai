package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import tb.ss0;

@Monitor(module = "networkPrefer", monitorPoint = "amdc")
/* compiled from: Taobao */
public class AmdcStatistic extends StatObject {
    @Dimension
    public String errorCode;
    @Dimension
    public String errorMsg;
    @Dimension
    public String host;
    @Dimension
    public String netType = NetworkStatusHelper.i().toString();
    @Dimension
    public String proxyType = NetworkStatusHelper.f();
    @Dimension
    public int retryTimes;
    @Dimension
    public String trace;
    @Dimension
    public String ttid = ss0.f();
    @Dimension
    public String url;
}
