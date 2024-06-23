package cn.damai.tetris.component.star;

import cn.damai.tetris.component.star.FansRankingContract;
import cn.damai.tetris.component.star.bean.FansRankingBean;
import cn.damai.tetris.component.star.bean.RankBeanObject;
import cn.damai.tetris.component.star.bean.TopFans;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class FansRankingModel extends AbsModel implements FansRankingContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    List<TopFans> list;
    RankBeanObject rankBeanObject = null;
    FansRankingBean rankingBean;

    @Override // cn.damai.tetris.component.star.FansRankingContract.Model
    public String getBannerImg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144195935")) {
            return (String) ipChange.ipc$dispatch("-144195935", new Object[]{this});
        }
        RankBeanObject rankBeanObject2 = this.rankBeanObject;
        if (rankBeanObject2 != null) {
            return rankBeanObject2.artistMainpic;
        }
        return null;
    }

    @Override // cn.damai.tetris.component.star.FansRankingContract.Model
    public List<TopFans> getFansList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1729887793")) {
            return this.list;
        }
        return (List) ipChange.ipc$dispatch("1729887793", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.star.FansRankingContract.Model
    public FansRankingBean getRankingData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "317198192")) {
            return this.rankingBean;
        }
        return (FansRankingBean) ipChange.ipc$dispatch("317198192", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.star.FansRankingContract.Model
    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-15168935")) {
            return (String) ipChange.ipc$dispatch("-15168935", new Object[]{this});
        }
        RankBeanObject rankBeanObject2 = this.rankBeanObject;
        if (rankBeanObject2 != null) {
            return rankBeanObject2.rule;
        }
        return null;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217661839")) {
            ipChange.ipc$dispatch("217661839", new Object[]{this, baseNode});
            return;
        }
        try {
            if (baseNode.getItem() != null) {
                this.rankBeanObject = (RankBeanObject) JSON.parseObject(baseNode.getItem().toString(), RankBeanObject.class);
            }
            RankBeanObject rankBeanObject2 = this.rankBeanObject;
            if (rankBeanObject2 != null) {
                this.rankingBean = rankBeanObject2.myRanking;
                this.list = rankBeanObject2.list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
