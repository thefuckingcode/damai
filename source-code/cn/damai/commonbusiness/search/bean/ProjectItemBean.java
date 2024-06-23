package cn.damai.commonbusiness.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.bh0;

/* compiled from: Taobao */
public class ProjectItemBean extends com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ProjectItemBean toBricksBean(com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925441975")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("1925441975", new Object[]{projectItemBean});
        }
        try {
            bh0 bh0 = bh0.INSTANCE;
            return (ProjectItemBean) bh0.c(bh0.d(projectItemBean), ProjectItemBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ProjectItemBean();
        }
    }
}
