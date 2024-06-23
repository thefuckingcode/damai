package anet.channel.statist;

@Monitor(module = "networkPrefer", monitorPoint = "request_monitor_full_sampling")
/* compiled from: Taobao */
public class RequestMonitorFullSampling extends RequestMonitor {
    public RequestMonitorFullSampling(RequestStatistic requestStatistic) {
        super(requestStatistic);
    }
}
