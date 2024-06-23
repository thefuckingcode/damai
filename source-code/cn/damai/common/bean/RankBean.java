package cn.damai.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class RankBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_MAI_LIST = 14;
    public static final int TYPE_RANK_LIST = 13;
    public String bgPic;
    public String count;
    public String id;
    public String ipvuv;
    public String name;
    public int pos;
    public String shortName;
    public int status;
    public String statusName;
    public int type;

    public static List<RankBean> mock() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011968098")) {
            return (List) ipChange.ipc$dispatch("1011968098", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            boolean z = true;
            boolean z2 = i % 4 == 0;
            if (i % 2 != 0) {
                z = false;
            }
            RankBean rankBean = new RankBean();
            rankBean.id = i + "";
            rankBean.type = z2 ? 13 : 14;
            rankBean.count = "共20部";
            rankBean.shortName = "不容错过的精彩演出";
            rankBean.name = "北京必看演唱会榜";
            rankBean.status = 0;
            rankBean.statusName = z ? "已下架" : "丫丫啊";
            rankBean.ipvuv = "20万人想看";
            arrayList.add(rankBean);
        }
        return arrayList;
    }

    public boolean isEnableClick() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1834173692")) {
            return this.status == 3;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1834173692", new Object[]{this})).booleanValue();
    }

    public boolean isMaiListType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1044466268")) {
            return this.type == 14;
        }
        return ((Boolean) ipChange.ipc$dispatch("1044466268", new Object[]{this})).booleanValue();
    }

    public boolean isRankListType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1277787717")) {
            return this.type == 13;
        }
        return ((Boolean) ipChange.ipc$dispatch("1277787717", new Object[]{this})).booleanValue();
    }
}
