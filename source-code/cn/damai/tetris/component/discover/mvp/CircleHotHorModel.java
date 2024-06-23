package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.CircleListWrapBean;
import cn.damai.tetris.component.discover.mvp.CircleHotHorContract;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class CircleHotHorModel extends AbsModel implements CircleHotHorContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    CircleListWrapBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.CircleHotHorContract.Model
    public CircleListWrapBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "409722118")) {
            return this.mBean;
        }
        return (CircleListWrapBean) ipChange.ipc$dispatch("409722118", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-926867360")) {
            ipChange.ipc$dispatch("-926867360", new Object[]{this, baseNode});
            return;
        }
        CircleListWrapBean circleListWrapBean = (CircleListWrapBean) s41.d(baseNode.getItem(), CircleListWrapBean.class);
        this.mBean = circleListWrapBean;
        circleListWrapBean.pos = baseNode.getOffset();
        this.mBean.mTitleBean = CardTitleBean.fromTetrisStyle(baseNode.getStyle());
    }
}
