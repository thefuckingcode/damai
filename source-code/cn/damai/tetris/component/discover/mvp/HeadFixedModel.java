package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.HeadFixedWrapBean;
import cn.damai.tetris.component.discover.mvp.HeadFixedContract;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class HeadFixedModel extends AbsModel implements HeadFixedContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private HeadFixedWrapBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.HeadFixedContract.Model
    public HeadFixedWrapBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "899091158")) {
            return this.mBean;
        }
        return (HeadFixedWrapBean) ipChange.ipc$dispatch("899091158", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460795356")) {
            ipChange.ipc$dispatch("1460795356", new Object[]{this, baseNode});
            return;
        }
        HeadFixedWrapBean headFixedWrapBean = (HeadFixedWrapBean) s41.d(baseNode.getItem(), HeadFixedWrapBean.class);
        this.mBean = headFixedWrapBean;
        headFixedWrapBean.handleData();
        this.mBean.pos = baseNode.getOffset();
        this.mBean.mTitleBean = CardTitleBean.fromTetrisStyle(baseNode.getStyle());
    }
}
