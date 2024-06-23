package cn.damai.tetris.component.drama.mvp;

import android.view.View;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.a03;
import tb.w9;
import tb.zb0;

/* compiled from: Taobao */
public class ProjectBroadcastListPresenter extends BasePresenter<ProjectBroadcastListModel, ProjectBroadcastListView, BaseSection> implements ProjectBroadcastListContract.Presenter<ProjectBroadcastListModel, ProjectBroadcastListView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ProjectBroadcastListPresenter(ProjectBroadcastListView projectBroadcastListView, String str, w9 w9Var) {
        super(projectBroadcastListView, str, w9Var);
    }

    @Override // cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract.Presenter
    public void allClick(ProjectBroadcastListContract.View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582013692")) {
            ipChange.ipc$dispatch("582013692", new Object[]{this, view, str});
            return;
        }
        userTrackClick("all", a03.f(), true);
        zb0.d(getContext(), str);
    }

    @Override // cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract.Presenter
    public void exposeItem(View view, ProjectShowBean projectShowBean, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043594861")) {
            ipChange.ipc$dispatch("-2043594861", new Object[]{this, view, projectShowBean, Integer.valueOf(i), str});
            return;
        }
        HashMap<String, String> f = a03.f();
        a03.h(f, "item_id", projectShowBean.itemId);
        a03.b(f, str);
        userTrackExpose(view, "item_" + i, f, false);
    }

    @Override // cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract.Presenter
    public void itemClick(ProjectBroadcastListContract.View view, ProjectShowBean projectShowBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-192955978")) {
            ipChange.ipc$dispatch("-192955978", new Object[]{this, view, projectShowBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        userTrackClick("item_" + i, f, true);
        zb0.c(getContext(), projectShowBean);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939826687")) {
            ipChange.ipc$dispatch("1939826687", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(ProjectBroadcastListModel projectBroadcastListModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1707016887")) {
            ipChange.ipc$dispatch("-1707016887", new Object[]{this, projectBroadcastListModel});
            return;
        }
        ((ProjectBroadcastListView) getView()).setData(projectBroadcastListModel.getBean(), 0);
    }
}
