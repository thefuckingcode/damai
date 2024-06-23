package cn.damai.mine.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class LogisticsDetailResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String iconUrl;
    private long orderId;
    private String status;
    private List<TransitStepInfosBean> transitStepInfos;
    private String waybillId;
    private String waybillName;
    private String waybillPhone;

    /* compiled from: Taobao */
    public static class TransitStepInfosBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        private String action;
        private String trackInfo;
        private String trackTime;

        public String getAction() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-232777601")) {
                return this.action;
            }
            return (String) ipChange.ipc$dispatch("-232777601", new Object[]{this});
        }

        public String getTrackInfo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1609244582")) {
                return this.trackInfo;
            }
            return (String) ipChange.ipc$dispatch("1609244582", new Object[]{this});
        }

        public String getTrackTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-256718779")) {
                return this.trackTime;
            }
            return (String) ipChange.ipc$dispatch("-256718779", new Object[]{this});
        }

        public void setAction(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-21263041")) {
                ipChange.ipc$dispatch("-21263041", new Object[]{this, str});
                return;
            }
            this.action = str;
        }

        public void setTrackInfo(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "676736912")) {
                ipChange.ipc$dispatch("676736912", new Object[]{this, str});
                return;
            }
            this.trackInfo = str;
        }

        public void setTrackTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1333552431")) {
                ipChange.ipc$dispatch("-1333552431", new Object[]{this, str});
                return;
            }
            this.trackTime = str;
        }
    }

    public String getIconUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "880487825")) {
            return this.iconUrl;
        }
        return (String) ipChange.ipc$dispatch("880487825", new Object[]{this});
    }

    public long getOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "340159280")) {
            return this.orderId;
        }
        return ((Long) ipChange.ipc$dispatch("340159280", new Object[]{this})).longValue();
    }

    public String getStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "180183597")) {
            return this.status;
        }
        return (String) ipChange.ipc$dispatch("180183597", new Object[]{this});
    }

    public List<TransitStepInfosBean> getTransitStepInfos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2085832616")) {
            return this.transitStepInfos;
        }
        return (List) ipChange.ipc$dispatch("2085832616", new Object[]{this});
    }

    public String getWaybillId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-180793588")) {
            return this.waybillId;
        }
        return (String) ipChange.ipc$dispatch("-180793588", new Object[]{this});
    }

    public String getWaybillName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1873063172")) {
            return this.waybillName;
        }
        return (String) ipChange.ipc$dispatch("-1873063172", new Object[]{this});
    }

    public String getWaybillPhone() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "480646867")) {
            return this.waybillPhone;
        }
        return (String) ipChange.ipc$dispatch("480646867", new Object[]{this});
    }

    public void setIconUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-90934779")) {
            ipChange.ipc$dispatch("-90934779", new Object[]{this, str});
            return;
        }
        this.iconUrl = str;
    }

    public void setOrderId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183297660")) {
            ipChange.ipc$dispatch("183297660", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.orderId = j;
    }

    public void setStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-104367791")) {
            ipChange.ipc$dispatch("-104367791", new Object[]{this, str});
            return;
        }
        this.status = str;
    }

    public void setTransitStepInfos(List<TransitStepInfosBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024741668")) {
            ipChange.ipc$dispatch("2024741668", new Object[]{this, list});
            return;
        }
        this.transitStepInfos = list;
    }

    public void setWaybillId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020128490")) {
            ipChange.ipc$dispatch("1020128490", new Object[]{this, str});
            return;
        }
        this.waybillId = str;
    }

    public void setWaybillName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235367430")) {
            ipChange.ipc$dispatch("-235367430", new Object[]{this, str});
            return;
        }
        this.waybillName = str;
    }

    public void setWaybillPhone(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881935253")) {
            ipChange.ipc$dispatch("-1881935253", new Object[]{this, str});
            return;
        }
        this.waybillPhone = str;
    }
}
