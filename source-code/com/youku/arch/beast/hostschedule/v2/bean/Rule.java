package com.youku.arch.beast.hostschedule.v2.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
public class Rule {
    @JSONField(name = "hls_net_refresh_cellular")
    public String[] hls_net_refresh_cellular;
    @JSONField(name = "hls_net_refresh_wifi")
    public String[] hls_net_refresh_wifi;
    @JSONField(name = "mp4_net_refresh_cellular")
    public String[] mp4_net_refresh_cellular;
    @JSONField(name = "mp4_net_refresh_wifi")
    public String[] mp4_net_refresh_wifi;
}
