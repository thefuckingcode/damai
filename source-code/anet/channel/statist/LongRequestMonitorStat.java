package anet.channel.statist;

@Monitor(module = "networkPrefer", monitorPoint = "long_request_monitor")
/* compiled from: Taobao */
public class LongRequestMonitorStat extends StatObject {
    @Dimension
    public String header;
    @Measure
    public int headerSize;
    @Dimension
    public int httpCode;
    @Dimension
    public String maxHeader;
    @Measure
    public int maxHeaderSize;
    @Dimension
    public String method;
    @Dimension
    public String originUrl;
    @Dimension
    public String refer;
    @Dimension
    public int reportType;
    @Dimension
    public String simpleUrl;
    @Measure
    public int urlSize;

    public LongRequestMonitorStat(String str) {
        this.simpleUrl = str;
    }
}
