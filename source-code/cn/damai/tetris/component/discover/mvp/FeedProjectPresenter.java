package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.discover.mvp.FeedProjectContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.tb2;
import tb.w9;

/* compiled from: Taobao */
public class FeedProjectPresenter extends BasePresenter<FeedProjectModel, FeedProjectView, BaseSection> implements FeedProjectContract.Presenter<FeedProjectModel, FeedProjectView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public FeedProjectPresenter(FeedProjectView feedProjectView, String str, w9 w9Var) {
        super(feedProjectView, str, w9Var);
    }

    @Override // cn.damai.tetris.component.discover.mvp.FeedProjectContract.Presenter
    public void exposeItem(View view, ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343261989")) {
            ipChange.ipc$dispatch("-1343261989", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.FeedProjectContract.Presenter
    public void itemClick(FeedProjectContract.View view, ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1394956567")) {
            ipChange.ipc$dispatch("1394956567", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
            return;
        }
        w9 context = getContext();
        if (context != null && context.getActivity() != null) {
            tb2.b(context.getActivity(), projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1946007560")) {
            ipChange.ipc$dispatch("1946007560", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(FeedProjectModel feedProjectModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106530615")) {
            ipChange.ipc$dispatch("2106530615", new Object[]{this, feedProjectModel});
            return;
        }
        ProjectItemBean bean = feedProjectModel.getBean();
        ((FeedProjectView) getView()).setData(bean, bean.pos);
    }
}
