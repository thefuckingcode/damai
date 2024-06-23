package cn.damai.tetris.component.common;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.common.HorizontalProjectsContract;
import cn.damai.tetris.component.common.view.HorizontalProjectAdapter;
import cn.damai.tetris.component.common.view.LeftSpaceItemDecoration;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.tb2;
import tb.v50;
import tb.w9;

/* compiled from: Taobao */
public class HorizontalProjectsPresenter extends BasePresenter<HorizontalProjectsContract.Model, HorizontalProjectsView, BaseSection> implements HorizontalProjectsContract.Presenter<HorizontalProjectsContract.Model, HorizontalProjectsView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @SuppressLint({"NewApi"})
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1128785702")) {
                ipChange.ipc$dispatch("1128785702", new Object[]{this, view});
            } else if (view.getTag() != null) {
                try {
                    ProjectItemBean projectItemBean = (ProjectItemBean) view.getTag();
                    Bundle bundle = new Bundle();
                    bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
                    tb2.a(HorizontalProjectsPresenter.this.getContext().getActivity(), projectItemBean.schema, bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public HorizontalProjectsPresenter(HorizontalProjectsView horizontalProjectsView, String str, w9 w9Var) {
        super(horizontalProjectsView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246365669")) {
            ipChange.ipc$dispatch("246365669", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(HorizontalProjectsContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "116401469")) {
            ipChange.ipc$dispatch("116401469", new Object[]{this, model});
            return;
        }
        ViewGroup projectsView = ((HorizontalProjectsView) getView()).getProjectsView();
        if (!TextUtils.isEmpty(model.getStyleValue("title"))) {
            int i = R$id.startindex_morepro_title;
            projectsView.findViewById(i).setVisibility(0);
            ((TextView) projectsView.findViewById(i)).setText(model.getStyleValue("title"));
        } else {
            projectsView.findViewById(R$id.startindex_morepro_title).setVisibility(8);
        }
        HorizontalRecyclerView horizontalRecyclerView = (HorizontalRecyclerView) projectsView.findViewById(R$id.user_project_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext().getActivity());
        linearLayoutManager.setOrientation(0);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);
        if (horizontalRecyclerView.getItemDecorationCount() > 0) {
            horizontalRecyclerView.removeItemDecorationAt(0);
        }
        horizontalRecyclerView.addItemDecoration(new LeftSpaceItemDecoration(v50.a(getContext().getActivity(), 13.0f)));
        HorizontalProjectAdapter horizontalProjectAdapter = new HorizontalProjectAdapter(getContext().getActivity(), new a());
        horizontalRecyclerView.setAdapter(horizontalProjectAdapter);
        horizontalProjectAdapter.c(((HorizontalProjectsContract.Model) getModel()).getData());
    }
}
