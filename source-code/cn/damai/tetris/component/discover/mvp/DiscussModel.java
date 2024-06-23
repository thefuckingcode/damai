package cn.damai.tetris.component.discover.mvp;

import cn.damai.comment.bean.HotDiscussBean;
import cn.damai.tetris.component.discover.mvp.DiscussContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class DiscussModel extends AbsModel implements DiscussContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    HotDiscussBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.DiscussContract.Model
    public HotDiscussBean getDiscussData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1086955323")) {
            return this.mBean;
        }
        return (HotDiscussBean) ipChange.ipc$dispatch("1086955323", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1129953032")) {
            ipChange.ipc$dispatch("1129953032", new Object[]{this, baseNode});
            return;
        }
        HotDiscussBean hotDiscussBean = (HotDiscussBean) s41.d(baseNode.getItem(), HotDiscussBean.class);
        this.mBean = hotDiscussBean;
        hotDiscussBean.pos = baseNode.getOffset();
    }
}
