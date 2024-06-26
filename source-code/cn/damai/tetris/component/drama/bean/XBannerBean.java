package cn.damai.tetris.component.drama.bean;

import cn.damai.uikit.banner.sub.BannerItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class XBannerBean implements BannerItem {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cover;
    public String dataType;
    public int height;
    public String id;
    public String idx;
    public String jumpUrl;
    public String tag;
    public int width;

    @Override // cn.damai.uikit.banner.sub.BannerItem
    public String bannerPicUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1629348210")) {
            return this.cover;
        }
        return (String) ipChange.ipc$dispatch("1629348210", new Object[]{this});
    }

    @Override // cn.damai.uikit.banner.sub.BannerItem
    public String bannerUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "931975256")) {
            return this.jumpUrl;
        }
        return (String) ipChange.ipc$dispatch("931975256", new Object[]{this});
    }
}
