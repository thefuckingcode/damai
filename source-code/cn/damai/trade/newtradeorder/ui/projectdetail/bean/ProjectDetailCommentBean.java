package cn.damai.trade.newtradeorder.ui.projectdetail.bean;

import cn.damai.comment.bean.CommentsItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class ProjectDetailCommentBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 3739113332570390732L;
    private ProjectDetailCommentConfigureBean config;
    private String hotTotal;
    private List<CommentsItemBean> moduleComments;
    private String total;
    private List<CommentsItemBean> userComments;

    public ProjectDetailCommentConfigureBean getConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "418258216")) {
            return this.config;
        }
        return (ProjectDetailCommentConfigureBean) ipChange.ipc$dispatch("418258216", new Object[]{this});
    }

    public String getHotTotal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "526511695")) {
            return this.hotTotal;
        }
        return (String) ipChange.ipc$dispatch("526511695", new Object[]{this});
    }

    public List<CommentsItemBean> getModuleComments() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "822840127")) {
            return this.moduleComments;
        }
        return (List) ipChange.ipc$dispatch("822840127", new Object[]{this});
    }

    public String getTotal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "184338210")) {
            return this.total;
        }
        return (String) ipChange.ipc$dispatch("184338210", new Object[]{this});
    }

    public List<CommentsItemBean> getUserComments() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "241993502")) {
            return this.userComments;
        }
        return (List) ipChange.ipc$dispatch("241993502", new Object[]{this});
    }

    public void setConfig(ProjectDetailCommentConfigureBean projectDetailCommentConfigureBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955399570")) {
            ipChange.ipc$dispatch("1955399570", new Object[]{this, projectDetailCommentConfigureBean});
            return;
        }
        this.config = projectDetailCommentConfigureBean;
    }

    public void setHotTotal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740334481")) {
            ipChange.ipc$dispatch("-740334481", new Object[]{this, str});
            return;
        }
        this.hotTotal = str;
    }

    public void setModuleComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041667949")) {
            ipChange.ipc$dispatch("1041667949", new Object[]{this, list});
            return;
        }
        this.moduleComments = list;
    }

    public void setTotal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384082540")) {
            ipChange.ipc$dispatch("-384082540", new Object[]{this, str});
            return;
        }
        this.total = str;
    }

    public void setUserComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002494574")) {
            ipChange.ipc$dispatch("2002494574", new Object[]{this, list});
            return;
        }
        this.userComments = list;
    }
}
