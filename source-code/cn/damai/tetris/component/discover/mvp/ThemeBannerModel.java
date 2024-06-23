package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.ThemeBannerWrapBean;
import cn.damai.tetris.component.discover.mvp.ThemeBannerContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class ThemeBannerModel extends AbsModel implements ThemeBannerContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    ThemeBannerWrapBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.ThemeBannerContract.Model
    public ThemeBannerWrapBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "922024310")) {
            return this.mBean;
        }
        return (ThemeBannerWrapBean) ipChange.ipc$dispatch("922024310", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636033917")) {
            ipChange.ipc$dispatch("636033917", new Object[]{this, baseNode});
            return;
        }
        this.mBean = (ThemeBannerWrapBean) s41.d(baseNode.getItem(), ThemeBannerWrapBean.class);
    }
}
