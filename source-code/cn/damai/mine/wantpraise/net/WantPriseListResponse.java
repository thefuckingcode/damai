package cn.damai.mine.wantpraise.net;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class WantPriseListResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    private List<JSONObject> dataList;
    private String praiseCount;
    private String praiseWantCount;
    private String wantCount;
    private String wantSeeType;

    public List<JSONObject> getDataList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1427673340")) {
            return this.dataList;
        }
        return (List) ipChange.ipc$dispatch("-1427673340", new Object[]{this});
    }

    public String getPraiseCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1548689940")) {
            return this.praiseCount;
        }
        return (String) ipChange.ipc$dispatch("1548689940", new Object[]{this});
    }

    public String getPraiseWantCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-312838940")) {
            return this.praiseWantCount;
        }
        return (String) ipChange.ipc$dispatch("-312838940", new Object[]{this});
    }

    public String getWantCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1108265344")) {
            return this.wantCount;
        }
        return (String) ipChange.ipc$dispatch("1108265344", new Object[]{this});
    }

    public String getWantSeeType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1640453602")) {
            return this.wantSeeType;
        }
        return (String) ipChange.ipc$dispatch("-1640453602", new Object[]{this});
    }

    public void setDataList(List<JSONObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1797745848")) {
            ipChange.ipc$dispatch("-1797745848", new Object[]{this, list});
            return;
        }
        this.dataList = list;
    }

    public void setPraiseCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535203358")) {
            ipChange.ipc$dispatch("-1535203358", new Object[]{this, str});
            return;
        }
        this.praiseCount = str;
    }

    public void setPraiseWantCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-826259182")) {
            ipChange.ipc$dispatch("-826259182", new Object[]{this, str});
            return;
        }
        this.praiseWantCount = str;
    }

    public void setWantCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1968717578")) {
            ipChange.ipc$dispatch("-1968717578", new Object[]{this, str});
            return;
        }
        this.wantCount = str;
    }

    public void setWantSeeType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1614405352")) {
            ipChange.ipc$dispatch("-1614405352", new Object[]{this, str});
            return;
        }
        this.wantSeeType = str;
    }
}
