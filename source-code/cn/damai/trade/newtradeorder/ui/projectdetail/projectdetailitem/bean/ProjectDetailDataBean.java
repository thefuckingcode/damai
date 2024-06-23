package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class ProjectDetailDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 2192310044093519974L;
    public ProjectDynamicExtDataBean dynamicExtData;
    public ProjectItemDataBean item;
    public ProjectStaticDataBean staticData;

    public ProjectDynamicExtDataBean getDynamicExtData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "932742337")) {
            return this.dynamicExtData;
        }
        return (ProjectDynamicExtDataBean) ipChange.ipc$dispatch("932742337", new Object[]{this});
    }

    public ProjectItemDataBean getItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "587392151")) {
            return this.item;
        }
        return (ProjectItemDataBean) ipChange.ipc$dispatch("587392151", new Object[]{this});
    }

    public ProjectStaticDataBean getStaticData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "486297921")) {
            return this.staticData;
        }
        return (ProjectStaticDataBean) ipChange.ipc$dispatch("486297921", new Object[]{this});
    }

    public void setItem(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-960517003")) {
            ipChange.ipc$dispatch("-960517003", new Object[]{this, projectItemDataBean});
            return;
        }
        this.item = projectItemDataBean;
    }
}
