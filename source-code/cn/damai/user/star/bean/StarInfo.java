package cn.damai.user.star.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class StarInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public ArtistVO artistVO;
    public GeneralBanner banner;
    public Config config;
    public List<ProjectItemBean> performanceMore;
    public TourVO tourVO;

    /* compiled from: Taobao */
    public class Config implements Serializable {
        public boolean hidPaidVipContent;

        public Config() {
        }
    }

    public List<Banner> getBanner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "936956095")) {
            return (List) ipChange.ipc$dispatch("936956095", new Object[]{this});
        }
        TourVO tourVO2 = this.tourVO;
        if (tourVO2 != null) {
            return tourVO2.banner;
        }
        return null;
    }

    public List<String> getDynamic() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2109967760")) {
            return (List) ipChange.ipc$dispatch("-2109967760", new Object[]{this});
        }
        TourVO tourVO2 = this.tourVO;
        if (tourVO2 != null) {
            return tourVO2.dynamic;
        }
        return null;
    }
}
