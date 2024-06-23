package cn.damai.trade.newtradeorder.ui.projectdetail.common.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ProjectSwitchIdDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.contract.ProjectContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.request.ProjectIdSwitchRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectPresenter extends ProjectContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.common.contract.ProjectContract.Presenter
    public void retrieveOldProjectItemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388242288")) {
            ipChange.ipc$dispatch("-388242288", new Object[]{this, str});
            return;
        }
        ProjectIdSwitchRequest projectIdSwitchRequest = new ProjectIdSwitchRequest();
        projectIdSwitchRequest.oldProjectId = str;
        projectIdSwitchRequest.request(new DMMtopRequestListener<ProjectSwitchIdDataBean.ProjectSwitchIdResultBean>(ProjectSwitchIdDataBean.ProjectSwitchIdResultBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.common.presenter.ProjectPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "501017766")) {
                    ipChange.ipc$dispatch("501017766", new Object[]{this, str, str2});
                    return;
                }
                ProjectPresenter.this.mView.onRetrieveOldProjectIdError(str, str2);
            }

            public void onSuccess(ProjectSwitchIdDataBean.ProjectSwitchIdResultBean projectSwitchIdResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1658506425")) {
                    ipChange.ipc$dispatch("-1658506425", new Object[]{this, projectSwitchIdResultBean});
                    return;
                }
                ProjectPresenter.this.mView.onRetrieveOldProjectIdSuccess(projectSwitchIdResultBean);
            }
        });
    }
}
