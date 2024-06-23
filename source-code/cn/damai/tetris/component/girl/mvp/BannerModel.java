package cn.damai.tetris.component.girl.mvp;

import cn.damai.tetris.component.girl.bean.BannerBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class BannerModel extends AbsModel implements BannerContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    public String mTitle;
    public List<BannerBean> result;

    @Override // cn.damai.tetris.component.girl.mvp.BannerContract$Model
    public List<BannerBean> getBannerList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1071757471")) {
            return this.result;
        }
        return (List) ipChange.ipc$dispatch("-1071757471", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.girl.mvp.BannerContract$Model
    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1207389058")) {
            return this.mTitle;
        }
        return (String) ipChange.ipc$dispatch("-1207389058", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951608565")) {
            ipChange.ipc$dispatch("-1951608565", new Object[]{this, baseNode});
            return;
        }
        BannerModel bannerModel = (BannerModel) JSON.parseObject(baseNode.toJSONString(), getClass());
        if (getTrackInfo() != null && getTrackInfo().containsKey("title")) {
            this.mTitle = getTrackInfo().getString("title");
        }
        this.result = bannerModel.result;
    }
}
