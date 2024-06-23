package com.youku.upsplayer.data;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class GetInfoResult {
    public ConnectStat connectStat = null;
    public String data = null;
    public Map<String, List<String>> header = null;

    public GetInfoResult(String str, Map<String, List<String>> map, ConnectStat connectStat2) {
        this.data = str;
        this.header = map;
        this.connectStat = connectStat2;
    }
}
