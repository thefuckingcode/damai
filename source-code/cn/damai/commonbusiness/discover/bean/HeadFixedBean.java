package cn.damai.commonbusiness.discover.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class HeadFixedBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String backImage;
    public String contentImage;
    public String dispatchTaskId;
    public boolean hasActivity;
    public String iconUrl;
    public String name;
    public int pos;
    public String redirectName;
    public String subTitle;
    public int type;
    public String url;

    public String getContactSubTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947773734")) {
            return (String) ipChange.ipc$dispatch("-1947773734", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 0) {
            return this.subTitle;
        } else {
            return this.subTitle + StringUtils.LF + this.redirectName;
        }
    }

    public String getIndexBgImgUrl(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1583861679")) {
            return this.backImage;
        }
        return (String) ipChange.ipc$dispatch("1583861679", new Object[]{this, Integer.valueOf(i)});
    }
}
