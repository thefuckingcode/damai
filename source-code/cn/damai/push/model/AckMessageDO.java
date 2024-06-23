package cn.damai.push.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class AckMessageDO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String bizType;
    private String dataId;
    private String passthrough;
    private String processTime;
    private String resultCode;

    public String getBizType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "696666329")) {
            return this.bizType;
        }
        return (String) ipChange.ipc$dispatch("696666329", new Object[]{this});
    }

    public String getDataId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "226581231")) {
            return this.dataId;
        }
        return (String) ipChange.ipc$dispatch("226581231", new Object[]{this});
    }

    public String getPassthrough() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1716774528")) {
            return this.passthrough;
        }
        return (String) ipChange.ipc$dispatch("-1716774528", new Object[]{this});
    }

    public String getProcessTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "578066888")) {
            return this.processTime;
        }
        return (String) ipChange.ipc$dispatch("578066888", new Object[]{this});
    }

    public String getResultCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1268788276")) {
            return this.resultCode;
        }
        return (String) ipChange.ipc$dispatch("1268788276", new Object[]{this});
    }

    public void setBizType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494433859")) {
            ipChange.ipc$dispatch("-1494433859", new Object[]{this, str});
            return;
        }
        this.bizType = str;
    }

    public void setDataId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1333958863")) {
            ipChange.ipc$dispatch("1333958863", new Object[]{this, str});
            return;
        }
        this.dataId = str;
    }

    public void setPassthrough(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "314613238")) {
            ipChange.ipc$dispatch("314613238", new Object[]{this, str});
            return;
        }
        this.passthrough = str;
    }

    public void setProcessTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1559746898")) {
            ipChange.ipc$dispatch("-1559746898", new Object[]{this, str});
            return;
        }
        this.processTime = str;
    }

    public void setResultCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432152534")) {
            ipChange.ipc$dispatch("-1432152534", new Object[]{this, str});
            return;
        }
        this.resultCode = str;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059601870")) {
            return (String) ipChange.ipc$dispatch("1059601870", new Object[]{this});
        }
        return "{dataId='" + this.dataId + '\'' + ", bizType='" + this.bizType + '\'' + ", resultCode='" + this.resultCode + '\'' + ", processTime='" + this.processTime + '\'' + '}';
    }
}
