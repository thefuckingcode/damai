package cn.damai.discover.main.ui.bean;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class ThemeRankBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bannerPic;
    public String bannerUrl;
    public int cliquePrize;
    public long countDown;
    public String descUrl;
    public String name;
    public List<RankUserBean> rankList;
    public List<RankUserBean> ranks;
    public int type;

    @NonNull
    public List<RankUserBean> getRankList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472518200")) {
            return (List) ipChange.ipc$dispatch("-472518200", new Object[]{this});
        } else if (!f92.d(this.rankList)) {
            return this.rankList;
        } else {
            if (f92.d(this.ranks)) {
                return new ArrayList();
            }
            return this.ranks;
        }
    }
}
