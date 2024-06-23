package cn.damai.tetris.component.live.mvp;

import cn.damai.tetris.component.live.bean.LiveHeaderCardBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class BannerModel extends AbsModel implements BannerContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private LiveHeaderCardBean bean;

    @Override // cn.damai.tetris.component.live.mvp.BannerContract$Model
    public LiveHeaderCardBean getBannerBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1968853407")) {
            return this.bean;
        }
        return (LiveHeaderCardBean) ipChange.ipc$dispatch("1968853407", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731526469")) {
            ipChange.ipc$dispatch("-1731526469", new Object[]{this, baseNode});
            return;
        }
        try {
            this.bean = (LiveHeaderCardBean) s41.d(baseNode.getItem(), LiveHeaderCardBean.class);
        } catch (Exception unused) {
        }
    }
}
