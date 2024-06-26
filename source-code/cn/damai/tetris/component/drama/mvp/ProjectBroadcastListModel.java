package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.ProjectListBean;
import cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class ProjectBroadcastListModel extends AbsModel implements ProjectBroadcastListContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectListBean mBean;

    @Override // cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract.Model
    public ProjectListBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "255344295")) {
            return this.mBean;
        }
        return (ProjectListBean) ipChange.ipc$dispatch("255344295", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458758572")) {
            ipChange.ipc$dispatch("1458758572", new Object[]{this, baseNode});
            return;
        }
        ProjectListBean projectListBean = (ProjectListBean) s41.d(baseNode.getItem(), ProjectListBean.class);
        this.mBean = projectListBean;
        if (projectListBean != null) {
            projectListBean.mTitleBean = CardTitleBean.fromTetrisStyle(baseNode.getStyle());
        }
    }
}
