package cn.damai.commonbusiness.wannasee.bean;

import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.t71;

/* compiled from: Taobao */
public class RecommendProjects implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_EMTYPE = 2;
    public static final int TYPE_SIMILAR = 1;
    public static final int TYPE_XIAJIA = 3;
    public List<ProjectItemBean> details;
    public boolean hasNext;
    public int index = 0;
    public int pageNo;
    public String recommendDesc;
    public String recommendTitle;
    public int recommendType;

    public ProjectItemBean getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "862876284")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("862876284", new Object[]{this, Integer.valueOf(i)});
        }
        try {
            return this.details.get(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getSpmc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1611352797")) {
            return (String) ipChange.ipc$dispatch("1611352797", new Object[]{this});
        }
        int i = this.recommendType;
        if (i == 2) {
            return "recommendlist";
        }
        if (i == 1) {
            return "want_recommendlist";
        }
        return i == 3 ? "oldproject_recommendlist" : "";
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "530888638")) {
            return !t71.b(this.details);
        }
        return ((Boolean) ipChange.ipc$dispatch("530888638", new Object[]{this})).booleanValue();
    }
}
