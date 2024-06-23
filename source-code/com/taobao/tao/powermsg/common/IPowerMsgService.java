package com.taobao.tao.powermsg.common;

import java.util.List;
import java.util.Map;
import tb.ck2;
import tb.wr1;

/* compiled from: Taobao */
public interface IPowerMsgService {
    void countValue(int i, String str, Map<String, Double> map, boolean z, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    List<wr1> getStashMessages(int i, String str);

    void pullMessages(int i, String str, int i2, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    int registerDispatcher(int i, String str, IPowerMsgDispatcher iPowerMsgDispatcher);

    void report(int i, wr1 wr1, int i2);

    void sendMessage(int i, wr1 wr1, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void sendRequest(int i, String str, int i2, int i3, int i4, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void sendText(int i, ck2 ck2, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void setMsgFetchMode(int i, String str, int i2);

    void setSubscribeMode(int i, String str, int i2);

    void subscribe(int i, String str, String str2, String str3, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void subscribe(int i, String str, String str2, String str3, String str4, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void subscribeDirectly(int i, String str, String str2, String str3, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void unSubscribe(int i, String str, String str2, String str3, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void unSubscribe(int i, String str, String str2, String str3, String str4, IPowerMsgCallback iPowerMsgCallback, Object... objArr);
}
