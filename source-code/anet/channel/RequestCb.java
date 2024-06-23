package anet.channel;

import anet.channel.statist.RequestStatistic;
import java.util.List;
import java.util.Map;
import tb.pd;

/* compiled from: Taobao */
public interface RequestCb {
    void onDataReceive(pd pdVar, boolean z);

    void onFinish(int i, String str, RequestStatistic requestStatistic);

    void onResponseCode(int i, Map<String, List<String>> map);
}
