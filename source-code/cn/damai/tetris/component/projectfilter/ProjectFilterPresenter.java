package cn.damai.tetris.component.projectfilter;

import cn.damai.tetris.component.projectfilter.ProjectFilterContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class ProjectFilterPresenter extends BasePresenter<ProjectFilterModel, ProjectFilterView, BaseSection> implements ProjectFilterContract.Presenter<ProjectFilterModel, ProjectFilterView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ProjectFilterPresenter(ProjectFilterView projectFilterView, String str, w9 w9Var) {
        super(projectFilterView, str, w9Var);
    }

    public void init(ProjectFilterModel projectFilterModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508850899")) {
            ipChange.ipc$dispatch("508850899", new Object[]{this, projectFilterModel});
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "382419060")) {
            ipChange.ipc$dispatch("382419060", new Object[]{this, Integer.valueOf(i), obj});
        }
    }
}
