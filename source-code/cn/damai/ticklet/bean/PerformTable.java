package cn.damai.ticklet.bean;

import cn.damai.common.db.db.annotation.Column;
import cn.damai.common.db.db.annotation.Table;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "perform")
/* compiled from: Taobao */
public class PerformTable implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String COUPON_PERFORM_TYPE = "1";
    private static final String NFT_PERFORM_TYPE = "2";
    public static final String PERFORM_SUPPORT_BIND_FACE = "1";
    public static final String PERFORM_SUPPORT_ONE = "1";
    private static final long serialVersionUID = 1;
    private AnnouncementVO announcement;
    @Column(name = "color")
    public String color;
    @Column(name = "createTime")
    public long createTime;
    public TicketAlipayCardBean ecertTipsInfo;
    @Column(name = "ecertTipsInfodb")
    public String ecertTipsInfodb;
    @Column(name = "endTime")
    public long endTime;
    private int esouvenirEnable;
    @Column(name = "expireTime")
    public long expireTime;
    private PerformExtAttr extAttr;
    public String historyPerformFlag;
    @Column(isId = true, name = "id")
    public int id;
    @Column(name = "isCertPerform")
    public String isCertPerform;
    @Column(name = "isLive")
    public String isLive;
    @Column(name = "isLongtermProject")
    public String isLongtermProject;
    @Column(name = "isMoreEnter")
    public String isMoreEnter;
    public String isTimeChanged;
    @Column(name = "liveH5Url")
    public String liveH5Url;
    private String liveTicketBgUrl;
    @Column(name = "liveType")
    public String liveType;
    @Column(name = "localExtAttr")
    private String localExtAttr;
    @Column(name = "localUserProjectVO")
    public String localUserProjectVO;
    @Column(name = "localUserVenueVO")
    public String localUserVenueVO;
    @Column(name = "memberLevel")
    private String memberLevel;
    private String performDetailTitle;
    @Column(name = TicketDetailExtFragment.PERFORM_ID)
    public String performId;
    public ArrayList<PerformOpModule> performOpList;
    @Column(name = "performOpListLocal")
    public String performOpListLocal;
    @Column(name = "performStatus")
    public String performStatus;
    @Column(name = "performType")
    public String performType;
    @Column(name = TicketDetailExtFragment.PRODUCT_SYSTEM_ID)
    public String productSystemId;
    public int sepType = 0;
    @Column(name = "showTimeRangeDetail")
    public String showTimeRangeDetail;
    private String startTime;
    @Column(name = "startTimeByLong")
    public long startTimeByLong;
    private String tenantId;
    @Column(name = "ticketQuantity")
    public int ticketQuantity;
    public String timeChangedReason;
    public String timeShow;
    public int timeShowIcon = -1;
    @Column(name = "timeTitle")
    public String timeTitle;
    private int transferState;
    private String transferWarn;
    private int transferringNum;
    @Column(name = "userCode")
    public String userCode;
    private UserProjectBean userProjectVO;
    private List<UserTicketTable> userTicketVOList;
    private UserVenueBean userVenueVO;
    private TransferBackBean withdrawVO;

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "321867322")) {
            return super.clone();
        }
        return ipChange.ipc$dispatch("321867322", new Object[]{this});
    }

    public AnnouncementVO getAnnouncement() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1561450970")) {
            return this.announcement;
        }
        return (AnnouncementVO) ipChange.ipc$dispatch("1561450970", new Object[]{this});
    }

    public String getColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1294884360")) {
            return this.color;
        }
        return (String) ipChange.ipc$dispatch("-1294884360", new Object[]{this});
    }

    public long getCreateTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-474616790")) {
            return this.createTime;
        }
        return ((Long) ipChange.ipc$dispatch("-474616790", new Object[]{this})).longValue();
    }

    public TicketAlipayCardBean getEcertTipsInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1638952224")) {
            return this.ecertTipsInfo;
        }
        return (TicketAlipayCardBean) ipChange.ipc$dispatch("-1638952224", new Object[]{this});
    }

    public String getEcertTipsInfodb() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-156148478")) {
            return this.ecertTipsInfodb;
        }
        return (String) ipChange.ipc$dispatch("-156148478", new Object[]{this});
    }

    public long getEndTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "866545943")) {
            return this.endTime;
        }
        return ((Long) ipChange.ipc$dispatch("866545943", new Object[]{this})).longValue();
    }

    public int getEsouvenirEnable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-988191257")) {
            return this.esouvenirEnable;
        }
        return ((Integer) ipChange.ipc$dispatch("-988191257", new Object[]{this})).intValue();
    }

    public long getExpireTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-830721369")) {
            return this.expireTime;
        }
        return ((Long) ipChange.ipc$dispatch("-830721369", new Object[]{this})).longValue();
    }

    public PerformExtAttr getExtAttr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-229721112")) {
            return this.extAttr;
        }
        return (PerformExtAttr) ipChange.ipc$dispatch("-229721112", new Object[]{this});
    }

    public String getHistoryPerformFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1247884410")) {
            return this.historyPerformFlag;
        }
        return (String) ipChange.ipc$dispatch("1247884410", new Object[]{this});
    }

    public int getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-287887945")) {
            return this.id;
        }
        return ((Integer) ipChange.ipc$dispatch("-287887945", new Object[]{this})).intValue();
    }

    public String getIsCertPerform() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1277981096")) {
            return this.isCertPerform;
        }
        return (String) ipChange.ipc$dispatch("1277981096", new Object[]{this});
    }

    public String getIsLive() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "101449975")) {
            return this.isLive;
        }
        return (String) ipChange.ipc$dispatch("101449975", new Object[]{this});
    }

    public String getIsLongtermProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "853109788")) {
            return this.isLongtermProject;
        }
        return (String) ipChange.ipc$dispatch("853109788", new Object[]{this});
    }

    public String getIsMoreEnter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "677385870")) {
            return this.isMoreEnter;
        }
        return (String) ipChange.ipc$dispatch("677385870", new Object[]{this});
    }

    public String getIsTimeChanged() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1695750962")) {
            return this.isTimeChanged;
        }
        return (String) ipChange.ipc$dispatch("1695750962", new Object[]{this});
    }

    public String getItemId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659968689")) {
            return (String) ipChange.ipc$dispatch("-1659968689", new Object[]{this});
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        return userProjectBean != null ? userProjectBean.itemId : "";
    }

    public String getLiveH5Url() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1576236565")) {
            return this.liveH5Url;
        }
        return (String) ipChange.ipc$dispatch("-1576236565", new Object[]{this});
    }

    public String getLiveTicketBgUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "744527687")) {
            return this.liveTicketBgUrl;
        }
        return (String) ipChange.ipc$dispatch("744527687", new Object[]{this});
    }

    public String getLiveType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1665221767")) {
            return this.liveType;
        }
        return (String) ipChange.ipc$dispatch("1665221767", new Object[]{this});
    }

    public String getLocalExtAttr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-655693176")) {
            return this.localExtAttr;
        }
        return (String) ipChange.ipc$dispatch("-655693176", new Object[]{this});
    }

    public String getLocalUserProjectVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2047071773")) {
            return this.localUserProjectVO;
        }
        return (String) ipChange.ipc$dispatch("2047071773", new Object[]{this});
    }

    public String getLocalUserVenueVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1536336115")) {
            return this.localUserVenueVO;
        }
        return (String) ipChange.ipc$dispatch("1536336115", new Object[]{this});
    }

    public String getLocaleName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109130938")) {
            return (String) ipChange.ipc$dispatch("-109130938", new Object[]{this});
        }
        UserVenueBean userVenueBean = this.userVenueVO;
        return userVenueBean != null ? userVenueBean.localeName : "";
    }

    public String getMemberLevel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1695683937")) {
            return this.memberLevel;
        }
        return (String) ipChange.ipc$dispatch("-1695683937", new Object[]{this});
    }

    public String getPerformDetailTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1547036967")) {
            return this.performDetailTitle;
        }
        return (String) ipChange.ipc$dispatch("1547036967", new Object[]{this});
    }

    public String getPerformId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-724851855")) {
            return this.performId;
        }
        return (String) ipChange.ipc$dispatch("-724851855", new Object[]{this});
    }

    public ArrayList<PerformOpModule> getPerformOpList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1733250203")) {
            return this.performOpList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1733250203", new Object[]{this});
    }

    public String getPerformOpListLocal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "290398380")) {
            return this.performOpListLocal;
        }
        return (String) ipChange.ipc$dispatch("290398380", new Object[]{this});
    }

    public String getPerformStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1884973240")) {
            return this.performStatus;
        }
        return (String) ipChange.ipc$dispatch("-1884973240", new Object[]{this});
    }

    public String getPerformType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1156254032")) {
            return this.performType;
        }
        return (String) ipChange.ipc$dispatch("1156254032", new Object[]{this});
    }

    public String getProductSystemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "600970446")) {
            return this.productSystemId;
        }
        return (String) ipChange.ipc$dispatch("600970446", new Object[]{this});
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076447447")) {
            return (String) ipChange.ipc$dispatch("-2076447447", new Object[]{this});
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        return userProjectBean != null ? userProjectBean.projectId : "";
    }

    public String getProjectImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258270461")) {
            return (String) ipChange.ipc$dispatch("-258270461", new Object[]{this});
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        return userProjectBean != null ? userProjectBean.projectImageUrl : "";
    }

    public String getProjectName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1764679129")) {
            return (String) ipChange.ipc$dispatch("1764679129", new Object[]{this});
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        return userProjectBean != null ? userProjectBean.projectName : "";
    }

    public String getShowTimeRangeDetail() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1006321849")) {
            return this.showTimeRangeDetail;
        }
        return (String) ipChange.ipc$dispatch("1006321849", new Object[]{this});
    }

    public long getStartTimeByLong() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "376106109")) {
            return this.startTimeByLong;
        }
        return ((Long) ipChange.ipc$dispatch("376106109", new Object[]{this})).longValue();
    }

    public String getTenantId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2133954598")) {
            return this.tenantId;
        }
        return (String) ipChange.ipc$dispatch("2133954598", new Object[]{this});
    }

    public int getTicketQuantity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1818960229")) {
            return this.ticketQuantity;
        }
        return ((Integer) ipChange.ipc$dispatch("-1818960229", new Object[]{this})).intValue();
    }

    public String getTimeChangedReason() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "984706016")) {
            return this.timeChangedReason;
        }
        return (String) ipChange.ipc$dispatch("984706016", new Object[]{this});
    }

    public String getTimeTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-940101344")) {
            return this.timeTitle;
        }
        return (String) ipChange.ipc$dispatch("-940101344", new Object[]{this});
    }

    public String getTransferBackDesc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67349732")) {
            return (String) ipChange.ipc$dispatch("67349732", new Object[]{this});
        }
        TransferBackBean transferBackBean = this.withdrawVO;
        return transferBackBean != null ? transferBackBean.withdrawDesc : "";
    }

    public String getTransferBackUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875851698")) {
            return (String) ipChange.ipc$dispatch("1875851698", new Object[]{this});
        }
        TransferBackBean transferBackBean = this.withdrawVO;
        return transferBackBean != null ? transferBackBean.withdrawUrl : "";
    }

    public int getTransferState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1844573880")) {
            return this.transferState;
        }
        return ((Integer) ipChange.ipc$dispatch("1844573880", new Object[]{this})).intValue();
    }

    public String getTransferWarn() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "629782738")) {
            return this.transferWarn;
        }
        return (String) ipChange.ipc$dispatch("629782738", new Object[]{this});
    }

    public int getTransferringNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1662871955")) {
            return this.transferringNum;
        }
        return ((Integer) ipChange.ipc$dispatch("1662871955", new Object[]{this})).intValue();
    }

    public UserProjectBean getUserProjectVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1235929526")) {
            return this.userProjectVO;
        }
        return (UserProjectBean) ipChange.ipc$dispatch("-1235929526", new Object[]{this});
    }

    public List<UserTicketTable> getUserTicketVOList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1319172586")) {
            return this.userTicketVOList;
        }
        return (List) ipChange.ipc$dispatch("-1319172586", new Object[]{this});
    }

    public UserVenueBean getUserVenueVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-870829986")) {
            return this.userVenueVO;
        }
        return (UserVenueBean) ipChange.ipc$dispatch("-870829986", new Object[]{this});
    }

    public String getVenueDetailAddress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882051061")) {
            return (String) ipChange.ipc$dispatch("882051061", new Object[]{this});
        }
        UserVenueBean userVenueBean = this.userVenueVO;
        return userVenueBean != null ? userVenueBean.detailLocation : "";
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434403921")) {
            return (String) ipChange.ipc$dispatch("-434403921", new Object[]{this});
        }
        UserVenueBean userVenueBean = this.userVenueVO;
        return userVenueBean != null ? userVenueBean.venueName : "";
    }

    public TransferBackBean getWithdrawVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "967784148")) {
            return this.withdrawVO;
        }
        return (TransferBackBean) ipChange.ipc$dispatch("967784148", new Object[]{this});
    }

    public boolean isCouponPerform() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-249595512")) {
            return "1".equals(this.performType);
        }
        return ((Boolean) ipChange.ipc$dispatch("-249595512", new Object[]{this})).booleanValue();
    }

    public boolean isHistoryTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2117421309")) {
            return "1".equals(getHistoryPerformFlag());
        }
        return ((Boolean) ipChange.ipc$dispatch("-2117421309", new Object[]{this})).booleanValue();
    }

    public boolean isLivePerform() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-324068018")) {
            return "1".equals(this.isLive);
        }
        return ((Boolean) ipChange.ipc$dispatch("-324068018", new Object[]{this})).booleanValue();
    }

    public boolean isMaiLive() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-95437886")) {
            return "1".equals(getLiveType());
        }
        return ((Boolean) ipChange.ipc$dispatch("-95437886", new Object[]{this})).booleanValue();
    }

    public boolean isNftPerform() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "304421706")) {
            return "2".equals(this.performType);
        }
        return ((Boolean) ipChange.ipc$dispatch("304421706", new Object[]{this})).booleanValue();
    }

    public void setAnnouncement(AnnouncementVO announcementVO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041108136")) {
            ipChange.ipc$dispatch("2041108136", new Object[]{this, announcementVO});
            return;
        }
        this.announcement = announcementVO;
    }

    public void setColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004658046")) {
            ipChange.ipc$dispatch("1004658046", new Object[]{this, str});
            return;
        }
        this.color = str;
    }

    public void setCreateTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526626650")) {
            ipChange.ipc$dispatch("1526626650", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.createTime = j;
    }

    public void setEcertTipsInfo(TicketAlipayCardBean ticketAlipayCardBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "846177806")) {
            ipChange.ipc$dispatch("846177806", new Object[]{this, ticketAlipayCardBean});
            return;
        }
        this.ecertTipsInfo = ticketAlipayCardBean;
    }

    public void setEcertTipsInfodb(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263822156")) {
            ipChange.ipc$dispatch("-263822156", new Object[]{this, str});
            return;
        }
        this.ecertTipsInfodb = str;
    }

    public void setEndTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678584971")) {
            ipChange.ipc$dispatch("-678584971", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.endTime = j;
    }

    public void setEsouvenirEnable(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744000259")) {
            ipChange.ipc$dispatch("744000259", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.esouvenirEnable = i;
    }

    public void setExpireTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922680707")) {
            ipChange.ipc$dispatch("-922680707", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.expireTime = j;
    }

    public void setExtAttr(PerformExtAttr performExtAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165184496")) {
            ipChange.ipc$dispatch("1165184496", new Object[]{this, performExtAttr});
            return;
        }
        this.extAttr = performExtAttr;
    }

    public void setHistoryPerformFlag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12295516")) {
            ipChange.ipc$dispatch("-12295516", new Object[]{this, str});
            return;
        }
        this.historyPerformFlag = str;
    }

    public void setId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549178933")) {
            ipChange.ipc$dispatch("-549178933", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.id = i;
    }

    public void setIsCertPerform(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905955378")) {
            ipChange.ipc$dispatch("-905955378", new Object[]{this, str});
            return;
        }
        this.isCertPerform = str;
    }

    public void setIsLive(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749857223")) {
            ipChange.ipc$dispatch("1749857223", new Object[]{this, str});
            return;
        }
        this.isLive = str;
    }

    public void setIsLongtermProject(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687594458")) {
            ipChange.ipc$dispatch("1687594458", new Object[]{this, str});
            return;
        }
        this.isLongtermProject = str;
    }

    public void setIsMoreEnter(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1519141544")) {
            ipChange.ipc$dispatch("1519141544", new Object[]{this, str});
            return;
        }
        this.isMoreEnter = str;
    }

    public void setIsTimeChanged(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839991420")) {
            ipChange.ipc$dispatch("-839991420", new Object[]{this, str});
            return;
        }
        this.isTimeChanged = str;
    }

    public void setLiveH5Url(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711069163")) {
            ipChange.ipc$dispatch("711069163", new Object[]{this, str});
            return;
        }
        this.liveH5Url = str;
    }

    public void setLiveTicketBgUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887335183")) {
            ipChange.ipc$dispatch("1887335183", new Object[]{this, str});
            return;
        }
        this.liveTicketBgUrl = str;
    }

    public void setLiveType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199939383")) {
            ipChange.ipc$dispatch("199939383", new Object[]{this, str});
            return;
        }
        this.liveType = str;
    }

    public void setLocalExtAttr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546229078")) {
            ipChange.ipc$dispatch("1546229078", new Object[]{this, str});
            return;
        }
        this.localExtAttr = str;
    }

    public void setLocalUserProjectVO(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007291039")) {
            ipChange.ipc$dispatch("-1007291039", new Object[]{this, str});
            return;
        }
        this.localUserProjectVO = str;
    }

    public void setLocalUserVenueVO(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790015413")) {
            ipChange.ipc$dispatch("-790015413", new Object[]{this, str});
            return;
        }
        this.localUserVenueVO = str;
    }

    public void setMemberLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "968421559")) {
            ipChange.ipc$dispatch("968421559", new Object[]{this, str});
            return;
        }
        this.memberLevel = str;
    }

    public void setPerformDetailTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671499159")) {
            ipChange.ipc$dispatch("671499159", new Object[]{this, str});
            return;
        }
        this.performDetailTitle = str;
    }

    public void setPerformId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1334191397")) {
            ipChange.ipc$dispatch("1334191397", new Object[]{this, str});
            return;
        }
        this.performId = str;
    }

    public void setPerformOpList(ArrayList<PerformOpModule> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1142422029")) {
            ipChange.ipc$dispatch("-1142422029", new Object[]{this, arrayList});
            return;
        }
        this.performOpList = arrayList;
    }

    public void setPerformOpListLocal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370408626")) {
            ipChange.ipc$dispatch("370408626", new Object[]{this, str});
            return;
        }
        this.performOpListLocal = str;
    }

    public void setPerformStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173291986")) {
            ipChange.ipc$dispatch("-173291986", new Object[]{this, str});
            return;
        }
        this.performStatus = str;
    }

    public void setPerformType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815814618")) {
            ipChange.ipc$dispatch("-815814618", new Object[]{this, str});
            return;
        }
        this.performType = str;
    }

    public void setProductSystemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1732028008")) {
            ipChange.ipc$dispatch("1732028008", new Object[]{this, str});
            return;
        }
        this.productSystemId = str;
    }

    public void setProjectImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "981431355")) {
            ipChange.ipc$dispatch("981431355", new Object[]{this, str});
            return;
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        if (userProjectBean != null) {
            userProjectBean.projectImageUrl = str;
        }
    }

    public void setShowTimeRangeDetail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489071651")) {
            ipChange.ipc$dispatch("-1489071651", new Object[]{this, str});
            return;
        }
        this.showTimeRangeDetail = str;
    }

    public void setStartTimeByLong(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "87546575")) {
            ipChange.ipc$dispatch("87546575", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.startTimeByLong = j;
    }

    public void setTenantId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845755256")) {
            ipChange.ipc$dispatch("1845755256", new Object[]{this, str});
            return;
        }
        this.tenantId = str;
    }

    public void setTicketQuantity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983048551")) {
            ipChange.ipc$dispatch("1983048551", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.ticketQuantity = i;
    }

    public void setTimeChangedReason(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472110230")) {
            ipChange.ipc$dispatch("1472110230", new Object[]{this, str});
            return;
        }
        this.timeChangedReason = str;
    }

    public void setTimeTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043575466")) {
            ipChange.ipc$dispatch("-1043575466", new Object[]{this, str});
            return;
        }
        this.timeTitle = str;
    }

    public void setTransferState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736321874")) {
            ipChange.ipc$dispatch("736321874", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.transferState = i;
    }

    public void setTransferWarn(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1553690548")) {
            ipChange.ipc$dispatch("-1553690548", new Object[]{this, str});
            return;
        }
        this.transferWarn = str;
    }

    public void setTransferringNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322581207")) {
            ipChange.ipc$dispatch("1322581207", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.transferringNum = i;
    }

    public void setUserCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "401826405")) {
            ipChange.ipc$dispatch("401826405", new Object[]{this, str});
            return;
        }
        this.userCode = str;
    }

    public void setUserProjectVO(UserProjectBean userProjectBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "184470854")) {
            ipChange.ipc$dispatch("184470854", new Object[]{this, userProjectBean});
            return;
        }
        this.userProjectVO = userProjectBean;
    }

    public void setUserTicketVOList(List<UserTicketTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-451204490")) {
            ipChange.ipc$dispatch("-451204490", new Object[]{this, list});
            return;
        }
        this.userTicketVOList = list;
    }

    public void setUserVenueVO(UserVenueBean userVenueBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670784390")) {
            ipChange.ipc$dispatch("670784390", new Object[]{this, userVenueBean});
            return;
        }
        this.userVenueVO = userVenueBean;
    }

    public void setWithdrawVO(TransferBackBean transferBackBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-482837654")) {
            ipChange.ipc$dispatch("-482837654", new Object[]{this, transferBackBean});
            return;
        }
        this.withdrawVO = transferBackBean;
    }
}
