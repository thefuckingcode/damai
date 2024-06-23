package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.DramaWrapBean;
import cn.damai.tetris.component.drama.mvp.DramaByMonthContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class DramaByMonthModel extends AbsModel implements DramaByMonthContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private DramaWrapBean mBean;

    @Override // cn.damai.tetris.component.drama.mvp.DramaByMonthContract.Model
    public DramaWrapBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-442780015")) {
            return this.mBean;
        }
        return (DramaWrapBean) ipChange.ipc$dispatch("-442780015", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897702984")) {
            ipChange.ipc$dispatch("897702984", new Object[]{this, baseNode});
            return;
        }
        this.mBean = (DramaWrapBean) s41.d(baseNode.getItem(), DramaWrapBean.class);
        CardTitleBean fromTetrisStyle = CardTitleBean.fromTetrisStyle(baseNode.getStyle());
        DramaWrapBean dramaWrapBean = this.mBean;
        if (dramaWrapBean != null) {
            dramaWrapBean.mTitleBean = fromTetrisStyle;
        }
    }
}
