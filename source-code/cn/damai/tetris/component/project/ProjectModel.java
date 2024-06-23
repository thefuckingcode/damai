package cn.damai.tetris.component.project;

import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.project.ProjectContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.qa;
import tb.s41;

/* compiled from: Taobao */
public class ProjectModel extends AbsModel implements ProjectContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectItemBean bean;
    private Daojishi daojishi;
    int index;
    private boolean showDis;

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public boolean ShowDis() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-139648459")) {
            return this.showDis;
        }
        return ((Boolean) ipChange.ipc$dispatch("-139648459", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public ProjectItemBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1863659794")) {
            return this.bean;
        }
        return (ProjectItemBean) ipChange.ipc$dispatch("1863659794", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public Daojishi getDaojishi() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1201364889")) {
            return this.daojishi;
        }
        return (Daojishi) ipChange.ipc$dispatch("1201364889", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1569362977")) {
            return this.index;
        }
        return ((Integer) ipChange.ipc$dispatch("-1569362977", new Object[]{this})).intValue();
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998015673")) {
            ipChange.ipc$dispatch("-998015673", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        this.bean = (ProjectItemBean) s41.d(item.getJSONObject(qa.KEY_PROJECT), ProjectItemBean.class);
        if (item.getJSONObject(qa.KEY_DAOJISHI) != null) {
            this.daojishi = (Daojishi) s41.d(item.getJSONObject(qa.KEY_DAOJISHI), Daojishi.class);
        }
        if (item.getBoolean(qa.KEY_SHOW_DIS) != null) {
            this.showDis = item.getBoolean(qa.KEY_SHOW_DIS).booleanValue();
        }
        this.index = baseNode.getOffset();
    }
}
