package cn.damai.trade.newtradeorder.ui.projectdetail.common.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class ProjectRecommendResultBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectRecommendDataBean data;

    /* compiled from: Taobao */
    public static class ProjectRecommendDataBean {
        private static transient /* synthetic */ IpChange $ipChange;
        private List<ProjectItemBean> projectInfo;

        public List<ProjectItemBean> getProjectInfo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-755963558")) {
                return this.projectInfo;
            }
            return (List) ipChange.ipc$dispatch("-755963558", new Object[]{this});
        }

        public void setProjectInfo(List<ProjectItemBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1275275338")) {
                ipChange.ipc$dispatch("1275275338", new Object[]{this, list});
                return;
            }
            this.projectInfo = list;
        }
    }

    public void setData(ProjectRecommendDataBean projectRecommendDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951683415")) {
            ipChange.ipc$dispatch("1951683415", new Object[]{this, projectRecommendDataBean});
            return;
        }
        this.data = projectRecommendDataBean;
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public ProjectRecommendDataBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-889431995")) {
            return this.data;
        }
        return (ProjectRecommendDataBean) ipChange.ipc$dispatch("-889431995", new Object[]{this});
    }
}
