package cn.damai.user.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class Banner implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String pic;
    public String url;

    public String getPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2038049928")) {
            return this.pic;
        }
        return (String) ipChange.ipc$dispatch("2038049928", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "411458541")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("411458541", new Object[]{this});
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "173586414")) {
            ipChange.ipc$dispatch("173586414", new Object[]{this, str});
            return;
        }
        this.pic = str;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1288860969")) {
            ipChange.ipc$dispatch("1288860969", new Object[]{this, str});
            return;
        }
        this.url = str;
    }
}
