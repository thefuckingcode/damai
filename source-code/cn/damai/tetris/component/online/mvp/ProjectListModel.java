package cn.damai.tetris.component.online.mvp;

import cn.damai.tetris.component.online.bean.OnlineTitleBean;
import cn.damai.tetris.component.online.bean.ProjectInfoBean;
import cn.damai.tetris.component.online.bean.ProjectList;
import cn.damai.tetris.component.online.mvp.ProjectListContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;
import tb.s41;

/* compiled from: Taobao */
public class ProjectListModel extends AbsModel implements ProjectListContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectList mBean;

    @Override // cn.damai.tetris.component.online.mvp.ProjectListContract.Model
    public ProjectList getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1494209560")) {
            return this.mBean;
        }
        return (ProjectList) ipChange.ipc$dispatch("-1494209560", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278958295")) {
            ipChange.ipc$dispatch("-278958295", new Object[]{this, baseNode});
            return;
        }
        try {
            ProjectList projectList = (ProjectList) s41.d(baseNode.getItem(), ProjectList.class);
            this.mBean = projectList;
            if (projectList != null) {
                List<ProjectInfoBean> list = projectList.result;
                if (!f92.d(list)) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        list.get(i).pos = i;
                    }
                }
                this.mBean.mTitleBean = OnlineTitleBean.fromTetrisStyle(baseNode.getStyle());
            }
        } catch (Exception unused) {
        }
    }
}
