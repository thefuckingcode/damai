package cn.damai.commonbusiness.search.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class SearchTourItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String city;
    public String itemId;
    public String itemSaleStatusDesc;
    public String liveItemUrl;
    public String liveStartTime;
    public String liveStatus;
    public String schema;
    public String showTime;
    public String status;
    public String type;

    public String getSchema() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963559434")) {
            return (String) ipChange.ipc$dispatch("-1963559434", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.liveItemUrl)) {
            return this.liveItemUrl;
        } else {
            if (!TextUtils.isEmpty(this.schema)) {
                return this.schema;
            }
            return null;
        }
    }

    public boolean isLiveProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222066686")) {
            return ((Boolean) ipChange.ipc$dispatch("-1222066686", new Object[]{this})).booleanValue();
        } else if (TextUtils.isEmpty(this.liveStatus)) {
            return false;
        } else {
            return "1".equals(this.liveStatus) || "2".equals(this.liveStatus);
        }
    }

    public boolean isRedBackground() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-155017424")) {
            return !TextUtils.isEmpty(this.type) && this.type.equals("2");
        }
        return ((Boolean) ipChange.ipc$dispatch("-155017424", new Object[]{this})).booleanValue();
    }
}
