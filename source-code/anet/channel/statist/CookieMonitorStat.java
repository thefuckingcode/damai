package anet.channel.statist;

@Monitor(module = "networkPrefer", monitorPoint = "cookieMonitor")
/* compiled from: Taobao */
public class CookieMonitorStat extends StatObject {
    @Dimension
    public String cookieName;
    @Dimension
    public String cookieText;
    @Dimension
    public int missType;
    @Dimension
    public String setCookie;
    @Dimension
    public String url;

    public CookieMonitorStat(String str) {
        this.url = str;
    }
}
