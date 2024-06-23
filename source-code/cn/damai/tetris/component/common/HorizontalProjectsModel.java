package cn.damai.tetris.component.common;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.common.HorizontalProjectsContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class HorizontalProjectsModel extends AbsModel implements HorizontalProjectsContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    List<ProjectItemBean> projectItemBeans;

    @Override // cn.damai.tetris.component.common.HorizontalProjectsContract.Model
    public List<ProjectItemBean> getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2136188230")) {
            return this.projectItemBeans;
        }
        return (List) ipChange.ipc$dispatch("2136188230", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1373524102")) {
            ipChange.ipc$dispatch("1373524102", new Object[]{this, baseNode});
            return;
        }
        try {
            if (baseNode.getItem() != null && baseNode.getItem().getString("result") != null) {
                this.projectItemBeans = JSON.parseArray(baseNode.getItem().getString("result"), ProjectItemBean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
