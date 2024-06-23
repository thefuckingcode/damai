package com.youku.upsplayer.data;

import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class ConnectStat {
    public boolean connect_success = false;
    public long connect_time = 0;
    public String errMsg;
    public Map<String, List<String>> header;
    public MTopUpsRequest mTopUpsRequest;
    public UpsTimeTraceBean mUpsTimeTraceBean;
    public String rawUpsData;
    public long read_time = 0;
    public int response_code = 0;
    public Map<String, String> statsMap;
    public String url;
    public UtAntiTheaftBean utMsg = null;
}
