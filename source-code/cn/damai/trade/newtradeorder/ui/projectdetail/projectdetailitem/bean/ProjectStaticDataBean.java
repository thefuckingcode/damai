package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import cn.damai.commonbusiness.notice.bean.NoticeListBean;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class ProjectStaticDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -3251974394106774030L;
    public String alipayDetailUrl;
    public ProjectNotice announcementMsg;
    public NoticeListBean announcementVO;
    public HashMap<String, String> ext;
    public List<String> faqs;
    public ProjectStaticItemBaseBean itemBase;
    public ProjectStaticExtendInfoBean itemExtendInfo;
    public NoticeMatter noticeMatter;
    public RankInfo rankListVO;
    public ProjectRatingBean rating;
    public RealNameBean realName;
    public SharingBar sharingBar;
    public List<ProjectStaticTicketNoteBean> ticketNotes;
    public ProjectTicketGuideBean ticketPurchasesGuidePage;
    public List<ProjectStaticTipBean> tips;
    public List<ProjectTour> tourProjects;
    public String track;
    public VenueBean venue;

    public String getExt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-748044637")) {
            return (String) ipChange.ipc$dispatch("-748044637", new Object[]{this, str});
        }
        HashMap<String, String> hashMap = this.ext;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public List<String> getFaqs() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-127356434")) {
            return this.faqs;
        }
        return (List) ipChange.ipc$dispatch("-127356434", new Object[]{this});
    }

    public ProjectStaticItemBaseBean getItemBase() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "44005008")) {
            return this.itemBase;
        }
        return (ProjectStaticItemBaseBean) ipChange.ipc$dispatch("44005008", new Object[]{this});
    }

    public ProjectStaticExtendInfoBean getItemExtendInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1448788093")) {
            return this.itemExtendInfo;
        }
        return (ProjectStaticExtendInfoBean) ipChange.ipc$dispatch("-1448788093", new Object[]{this});
    }

    public NoticeMatter getNoticeMatter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1284200643")) {
            return this.noticeMatter;
        }
        return (NoticeMatter) ipChange.ipc$dispatch("-1284200643", new Object[]{this});
    }

    public RankInfo getRankListVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "126715216")) {
            return this.rankListVO;
        }
        return (RankInfo) ipChange.ipc$dispatch("126715216", new Object[]{this});
    }

    public String getShareIconPicUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1965342057")) {
            return (String) ipChange.ipc$dispatch("1965342057", new Object[]{this});
        }
        SharingBar sharingBar2 = this.sharingBar;
        if (sharingBar2 != null) {
            return sharingBar2.sharingIcon;
        }
        return null;
    }

    public String getTheater_status() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2010291190")) {
            return getExt("pro_theater_status");
        }
        return (String) ipChange.ipc$dispatch("-2010291190", new Object[]{this});
    }

    public List<ProjectStaticTicketNoteBean> getTicketNotes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "52759624")) {
            return this.ticketNotes;
        }
        return (List) ipChange.ipc$dispatch("52759624", new Object[]{this});
    }

    public List<ProjectStaticTipBean> getTips() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-790709175")) {
            return this.tips;
        }
        return (List) ipChange.ipc$dispatch("-790709175", new Object[]{this});
    }

    public VenueBean getVenue() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "378018567")) {
            return this.venue;
        }
        return (VenueBean) ipChange.ipc$dispatch("378018567", new Object[]{this});
    }

    public void setTips(List<ProjectStaticTipBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004718243")) {
            ipChange.ipc$dispatch("1004718243", new Object[]{this, list});
            return;
        }
        this.tips = list;
    }
}
