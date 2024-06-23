package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

@Deprecated
/* compiled from: Taobao */
public class Brand implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 8581687041246138733L;
    private String archives;
    private long brandId;
    private String brandLabel;
    private String brandName;
    private String picUrl;
    private String subFlag;

    public String getArchives() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "231116897")) {
            return this.archives;
        }
        return (String) ipChange.ipc$dispatch("231116897", new Object[]{this});
    }

    public long getBrandId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "860990860")) {
            return this.brandId;
        }
        return ((Long) ipChange.ipc$dispatch("860990860", new Object[]{this})).longValue();
    }

    public String getBrandLabel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1314927395")) {
            return this.brandLabel;
        }
        return (String) ipChange.ipc$dispatch("-1314927395", new Object[]{this});
    }

    public String getBrandName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1915920648")) {
            return this.brandName;
        }
        return (String) ipChange.ipc$dispatch("-1915920648", new Object[]{this});
    }

    public String getPicUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1538096331")) {
            return this.picUrl;
        }
        return (String) ipChange.ipc$dispatch("-1538096331", new Object[]{this});
    }

    public String getSubFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1513579474")) {
            return this.subFlag;
        }
        return (String) ipChange.ipc$dispatch("1513579474", new Object[]{this});
    }

    public void setArchives(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1307638627")) {
            ipChange.ipc$dispatch("-1307638627", new Object[]{this, str});
            return;
        }
        this.archives = str;
    }

    public void setBrandId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850792544")) {
            ipChange.ipc$dispatch("-850792544", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.brandId = j;
    }

    public void setBrandLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "77040289")) {
            ipChange.ipc$dispatch("77040289", new Object[]{this, str});
            return;
        }
        this.brandLabel = str;
    }

    public void setBrandName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229202818")) {
            ipChange.ipc$dispatch("-1229202818", new Object[]{this, str});
            return;
        }
        this.brandName = str;
    }

    public void setPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831438007")) {
            ipChange.ipc$dispatch("-1831438007", new Object[]{this, str});
            return;
        }
        this.picUrl = str;
    }

    public void setSubFlag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939930140")) {
            ipChange.ipc$dispatch("-1939930140", new Object[]{this, str});
            return;
        }
        this.subFlag = str;
    }
}
