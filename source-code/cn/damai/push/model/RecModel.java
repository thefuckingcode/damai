package cn.damai.push.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class RecModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String bizType;
    private String data;
    private String dataId;
    private String expiryTime;
    private String extMap;
    private String sendTime;

    public String getBizType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1840332631")) {
            return this.bizType;
        }
        return (String) ipChange.ipc$dispatch("-1840332631", new Object[]{this});
    }

    public String getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1175723428")) {
            return this.data;
        }
        return (String) ipChange.ipc$dispatch("1175723428", new Object[]{this});
    }

    public String getDataId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "283289887")) {
            return this.dataId;
        }
        return (String) ipChange.ipc$dispatch("283289887", new Object[]{this});
    }

    public String getExpiryTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-471455142")) {
            return this.expiryTime;
        }
        return (String) ipChange.ipc$dispatch("-471455142", new Object[]{this});
    }

    public String getExtMap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1525149493")) {
            return this.extMap;
        }
        return (String) ipChange.ipc$dispatch("1525149493", new Object[]{this});
    }

    public String getSendTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "598293871")) {
            return this.sendTime;
        }
        return (String) ipChange.ipc$dispatch("598293871", new Object[]{this});
    }

    public void setBizType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462977005")) {
            ipChange.ipc$dispatch("1462977005", new Object[]{this, str});
            return;
        }
        this.bizType = str;
    }

    public void setData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794931130")) {
            ipChange.ipc$dispatch("1794931130", new Object[]{this, str});
            return;
        }
        this.data = str;
    }

    public void setDataId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203040097")) {
            ipChange.ipc$dispatch("-1203040097", new Object[]{this, str});
            return;
        }
        this.dataId = str;
    }

    public void setExpiryTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454876356")) {
            ipChange.ipc$dispatch("454876356", new Object[]{this, str});
            return;
        }
        this.expiryTime = str;
    }

    public void setExtMap(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360097975")) {
            ipChange.ipc$dispatch("-1360097975", new Object[]{this, str});
            return;
        }
        this.extMap = str;
    }

    public void setSendTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1484912975")) {
            ipChange.ipc$dispatch("1484912975", new Object[]{this, str});
            return;
        }
        this.sendTime = str;
    }
}
