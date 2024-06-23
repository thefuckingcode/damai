package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.DramaList;
import cn.damai.tetris.component.drama.bean.DramaV2Bean;
import cn.damai.tetris.component.drama.mvp.DramaWorthSeeContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;
import tb.s41;

/* compiled from: Taobao */
public class DramaWorthSeeModel extends AbsModel implements DramaWorthSeeContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private DramaList mBean;

    @Override // cn.damai.tetris.component.drama.mvp.DramaWorthSeeContract.Model
    public DramaList getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1730645141")) {
            return this.mBean;
        }
        return (DramaList) ipChange.ipc$dispatch("1730645141", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447902784")) {
            ipChange.ipc$dispatch("447902784", new Object[]{this, baseNode});
            return;
        }
        DramaList dramaList = (DramaList) s41.d(baseNode.getItem(), DramaList.class);
        this.mBean = dramaList;
        if (dramaList != null) {
            List<DramaV2Bean> list = dramaList.result;
            if (!f92.d(list)) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).mustSeePos = i;
                }
            }
            this.mBean.mTitleBean = CardTitleBean.fromTetrisStyle(baseNode.getStyle());
        }
    }
}
