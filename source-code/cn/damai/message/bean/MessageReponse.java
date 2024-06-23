package cn.damai.message.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class MessageReponse extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private MessageList data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public MessageList getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1846461030")) {
            return this.data;
        }
        return (MessageList) ipChange.ipc$dispatch("-1846461030", new Object[]{this});
    }
}
