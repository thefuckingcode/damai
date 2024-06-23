package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.discover.mvp.FeedProjectContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class FeedProjectModel extends AbsModel implements FeedProjectContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    ProjectItemBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.FeedProjectContract.Model
    public ProjectItemBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1769511566")) {
            return this.mBean;
        }
        return (ProjectItemBean) ipChange.ipc$dispatch("1769511566", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1782812099")) {
            ipChange.ipc$dispatch("1782812099", new Object[]{this, baseNode});
            return;
        }
        ProjectItemBean projectItemBean = (ProjectItemBean) s41.d(baseNode.getItem(), ProjectItemBean.class);
        this.mBean = projectItemBean;
        projectItemBean.pos = baseNode.getOffset();
    }
}
