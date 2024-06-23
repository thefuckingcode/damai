package cn.damai.ultron.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import tb.jn2;

/* compiled from: Taobao */
public class DmLinkageNotification {
    private static transient /* synthetic */ IpChange $ipChange;
    private jn2 tradeEvent;
    private IDMComponent trigger;

    public DmLinkageNotification(IDMComponent iDMComponent, jn2 jn2) {
        this.trigger = iDMComponent;
        this.tradeEvent = jn2;
    }

    public jn2 getEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-444055235")) {
            return this.tradeEvent;
        }
        return (jn2) ipChange.ipc$dispatch("-444055235", new Object[]{this});
    }

    public IDMComponent getTrigger() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1067309196")) {
            return this.trigger;
        }
        return (IDMComponent) ipChange.ipc$dispatch("-1067309196", new Object[]{this});
    }

    public void setTradeEventAndTrigger(jn2 jn2, IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-573479040")) {
            ipChange.ipc$dispatch("-573479040", new Object[]{this, jn2, iDMComponent});
            return;
        }
        this.tradeEvent = jn2;
        this.trigger = iDMComponent;
    }
}
