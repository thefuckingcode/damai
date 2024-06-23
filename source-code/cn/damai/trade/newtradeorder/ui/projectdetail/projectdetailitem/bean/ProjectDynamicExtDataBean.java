package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import cn.damai.comment.bean.HotDiscussBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class ProjectDynamicExtDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -3374581284322019926L;
    public List<ProjectDynamicArtistBean> artists;
    public List<String> artistsRichText;
    public List<BrandAndArtists> brandArtists;
    public List<Brand> brands;
    public List<InFieldCommentsBean> inFieldComments;
    public ProjectDynamicIpCardBean ipCard;
    public ProjectMemberPrompt memberPrompt;
    public String sharingBtnBubbleText;
    public boolean subFlag;
    public HotDiscussBean topicHotComment;
    public ProjectWantSeeBean wantVO;

    public List<ProjectDynamicArtistBean> getArtists() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-106422005")) {
            return this.artists;
        }
        return (List) ipChange.ipc$dispatch("-106422005", new Object[]{this});
    }

    public List<String> getArtistsRichText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1440755692")) {
            return this.artistsRichText;
        }
        return (List) ipChange.ipc$dispatch("-1440755692", new Object[]{this});
    }

    public List<Brand> getBrands() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1308825489")) {
            return this.brands;
        }
        return (List) ipChange.ipc$dispatch("1308825489", new Object[]{this});
    }

    public ProjectDynamicIpCardBean getIpCard() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "38257591")) {
            return this.ipCard;
        }
        return (ProjectDynamicIpCardBean) ipChange.ipc$dispatch("38257591", new Object[]{this});
    }

    public String getSharingBtnBubbleText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1606084681")) {
            return this.sharingBtnBubbleText;
        }
        return (String) ipChange.ipc$dispatch("-1606084681", new Object[]{this});
    }

    public boolean isSubFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-251056262")) {
            return this.subFlag;
        }
        return ((Boolean) ipChange.ipc$dispatch("-251056262", new Object[]{this})).booleanValue();
    }

    public void setSubFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-14482484")) {
            ipChange.ipc$dispatch("-14482484", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.subFlag = z;
    }
}
