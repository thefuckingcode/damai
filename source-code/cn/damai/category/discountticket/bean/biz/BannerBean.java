package cn.damai.category.discountticket.bean.biz;

import cn.damai.uikit.banner.sub.BannerItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BannerBean implements BannerItem {
    private static transient /* synthetic */ IpChange $ipChange;
    public String content;
    public String link;

    public BannerBean() {
    }

    @Override // cn.damai.uikit.banner.sub.BannerItem
    public String bannerPicUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-718702063")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("-718702063", new Object[]{this});
    }

    @Override // cn.damai.uikit.banner.sub.BannerItem
    public String bannerUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "44962841")) {
            return this.link;
        }
        return (String) ipChange.ipc$dispatch("44962841", new Object[]{this});
    }

    public BannerBean(String str, String str2) {
        this.link = str;
        this.content = str2;
    }
}
