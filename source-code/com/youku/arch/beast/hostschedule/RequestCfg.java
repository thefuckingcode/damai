package com.youku.arch.beast.hostschedule;

/* compiled from: Taobao */
public class RequestCfg {
    public DomainCell adDomain;
    public String fileType;
    public DomainCell hlsDomain;
    public DomainCell mp4Domain;
    public PlayMode playMode = PlayMode.VIDEO;
    public boolean useAbsoluteFreeFlowDomain;
    public boolean useProxyNewDomain;

    /* compiled from: Taobao */
    public enum PlayMode {
        AD,
        VIDEO,
        FEED
    }
}
