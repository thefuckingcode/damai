package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
public class TicketPerformanceNoticeResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public ArrayList<TicketNoticeData> viewerNoticeItemVOList;

    /* compiled from: Taobao */
    public static class TicketNoticeData implements Serializable {
        private static final long serialVersionUID = -985456821228750695L;
        public String description;
        public String name;
    }

    public ArrayList<TicketNoticeData> getPairInfoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "424855045")) {
            return this.viewerNoticeItemVOList;
        }
        return (ArrayList) ipChange.ipc$dispatch("424855045", new Object[]{this});
    }

    public void setPairInfoList(ArrayList<TicketNoticeData> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1507027989")) {
            ipChange.ipc$dispatch("-1507027989", new Object[]{this, arrayList});
            return;
        }
        this.viewerNoticeItemVOList = arrayList;
    }
}
