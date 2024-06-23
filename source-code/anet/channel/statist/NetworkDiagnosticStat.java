package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.Inet64Util;

@Monitor(module = "networkPrefer", monitorPoint = "networkDiagnostic")
/* compiled from: Taobao */
public class NetworkDiagnosticStat extends StatObject {
    public static final int DIAGNOSTIC_TYPE_AUTO = 2;
    public static final int DIAGNOSTIC_TYPE_USER = 1;
    @Dimension
    public int code = 1;
    @Dimension
    public int ipStackType;
    @Dimension
    public boolean isProxy;
    @Dimension
    public String netType;
    @Dimension
    public int type;

    public NetworkDiagnosticStat(int i) {
        this.type = i;
        this.netType = NetworkStatusHelper.i().toString();
        this.isProxy = NetworkStatusHelper.o();
        this.ipStackType = Inet64Util.n();
    }
}
