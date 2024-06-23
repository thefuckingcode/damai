package com.youku.arch.beast.messenger;

import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.beast.EventType;
import com.youku.arch.beast.messenger.data.Data;

/* compiled from: Taobao */
public interface Messenger {

    /* compiled from: Taobao */
    public static class Message {
        private static transient /* synthetic */ IpChange $ipChange;
        public Data data;

        public String formJSONString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-529661757")) {
                return (String) ipChange.ipc$dispatch("-529661757", new Object[]{this});
            }
            Data data2 = this.data;
            return data2 == null ? "{}" : JSON.toJSONString(data2);
        }
    }

    Message gatherInfo();

    void sendForEvent(EventType eventType);
}
