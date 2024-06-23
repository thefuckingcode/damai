package cn.damai.ticklet.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.ColorUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.gl2;
import tb.xf2;

/* compiled from: Taobao */
public class TicketDeatilResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    private int[] bgGradientColors;
    private float[] bgGradientPostions;
    private EmptyDataVO emptyDataVO;
    public int hasMore;
    public Boolean isLocalData = Boolean.FALSE;
    public long loadTime = 0;
    private int mainColor;
    public ArrayList<TickletDetailModuleBean> modules;
    private int pageBgColor;
    public String pagingKey;
    public Long serverTimestamp;
    private PerformTable userPerformVO;

    public AnnouncementVO getAnnouncement() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1841199277")) {
            return this.userPerformVO.getAnnouncement();
        }
        return (AnnouncementVO) ipChange.ipc$dispatch("1841199277", new Object[]{this});
    }

    public Long getBeginTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-814422483")) {
            return Long.valueOf(this.userPerformVO.getStartTimeByLong());
        }
        return (Long) ipChange.ipc$dispatch("-814422483", new Object[]{this});
    }

    public int[] getBgGradientColors() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "434718269")) {
            return this.bgGradientColors;
        }
        return (int[]) ipChange.ipc$dispatch("434718269", new Object[]{this});
    }

    public float[] getBgGradientPostions() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1022967253")) {
            return this.bgGradientPostions;
        }
        return (float[]) ipChange.ipc$dispatch("1022967253", new Object[]{this});
    }

    public String getChangeDateReason() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1560897930")) {
            return this.userPerformVO.getTimeChangedReason();
        }
        return (String) ipChange.ipc$dispatch("-1560897930", new Object[]{this});
    }

    public String getChangeDateState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1743290005")) {
            return this.userPerformVO.getIsTimeChanged();
        }
        return (String) ipChange.ipc$dispatch("1743290005", new Object[]{this});
    }

    public int getColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "273524462")) {
            return this.mainColor;
        }
        return ((Integer) ipChange.ipc$dispatch("273524462", new Object[]{this})).intValue();
    }

    public TicketAlipayCardBean getEcertTipsInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1282224301")) {
            return this.userPerformVO.ecertTipsInfo;
        }
        return (TicketAlipayCardBean) ipChange.ipc$dispatch("1282224301", new Object[]{this});
    }

    public EmptyDataVO getEmptyDataVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1830040318")) {
            return this.emptyDataVO;
        }
        return (EmptyDataVO) ipChange.ipc$dispatch("-1830040318", new Object[]{this});
    }

    public int getEsouvenirEnable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1054910842")) {
            return this.userPerformVO.getEsouvenirEnable();
        }
        return ((Integer) ipChange.ipc$dispatch("1054910842", new Object[]{this})).intValue();
    }

    public int getHasMore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1395379326")) {
            return this.hasMore;
        }
        return ((Integer) ipChange.ipc$dispatch("-1395379326", new Object[]{this})).intValue();
    }

    public String getIsCertPerform() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-547801675")) {
            return this.userPerformVO.getIsCertPerform();
        }
        return (String) ipChange.ipc$dispatch("-547801675", new Object[]{this});
    }

    public String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1815012322")) {
            return this.userPerformVO.getItemId();
        }
        return (String) ipChange.ipc$dispatch("1815012322", new Object[]{this});
    }

    public String getLiveH5Url() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-13673352")) {
            return this.userPerformVO.getLiveH5Url();
        }
        return (String) ipChange.ipc$dispatch("-13673352", new Object[]{this});
    }

    public String getLiveTicketBgUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1486058476")) {
            return this.userPerformVO.getLiveTicketBgUrl();
        }
        return (String) ipChange.ipc$dispatch("-1486058476", new Object[]{this});
    }

    public String getLiveType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-362582950")) {
            return this.userPerformVO.getLiveType();
        }
        return (String) ipChange.ipc$dispatch("-362582950", new Object[]{this});
    }

    public long getLoadTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-493026483")) {
            return this.loadTime;
        }
        return ((Long) ipChange.ipc$dispatch("-493026483", new Object[]{this})).longValue();
    }

    public String getLocaleName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1085688409")) {
            return this.userPerformVO.getLocaleName();
        }
        return (String) ipChange.ipc$dispatch("1085688409", new Object[]{this});
    }

    public String getLongtermProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1095167757")) {
            return this.userPerformVO.getIsLongtermProject();
        }
        return (String) ipChange.ipc$dispatch("-1095167757", new Object[]{this});
    }

    public void getMainColorFun() {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185464183")) {
            ipChange.ipc$dispatch("185464183", new Object[]{this});
            return;
        }
        if (getPerformExtAttr() == null || xf2.e(getPerformExtAttr().bgColor) <= 0 || TextUtils.isEmpty(getPerformExtAttr().bgColor.get(0))) {
            str = gl2.DETAIL_PAGE_DEFAULT_COLOR;
            str2 = "#965BBD";
        } else {
            str2 = getPerformExtAttr().bgColor.get(0);
            str = getPerformExtAttr().bgColor.get(getPerformExtAttr().bgColor.size() - 1);
        }
        this.mainColor = ColorUtil.parseColorSafely(str2, "#965BBD");
        this.pageBgColor = ColorUtil.parseColorSafely(str, gl2.DETAIL_PAGE_DEFAULT_COLOR);
    }

    public String getMemberLevel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983977452")) {
            return (String) ipChange.ipc$dispatch("983977452", new Object[]{this});
        } else if (getUserPerformVO() == null) {
            return null;
        } else {
            return getUserPerformVO().getMemberLevel();
        }
    }

    public String getMoreType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "733318083")) {
            return this.userPerformVO.getIsMoreEnter();
        }
        return (String) ipChange.ipc$dispatch("733318083", new Object[]{this});
    }

    public int getPageBgColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1519427710")) {
            return this.pageBgColor;
        }
        return ((Integer) ipChange.ipc$dispatch("-1519427710", new Object[]{this})).intValue();
    }

    public String getPagingKey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1978705067")) {
            return this.pagingKey;
        }
        return (String) ipChange.ipc$dispatch("-1978705067", new Object[]{this});
    }

    public String getPerformDetailTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1888658746")) {
            return this.userPerformVO.getPerformDetailTitle();
        }
        return (String) ipChange.ipc$dispatch("1888658746", new Object[]{this});
    }

    public PerformExtAttr getPerformExtAttr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "874653574")) {
            return (PerformExtAttr) ipChange.ipc$dispatch("874653574", new Object[]{this});
        } else if (getUserPerformVO() == null || getUserPerformVO().getExtAttr() == null) {
            return null;
        } else {
            return getUserPerformVO().getExtAttr();
        }
    }

    public String getPerformId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "837711358")) {
            return this.userPerformVO.getPerformId();
        }
        return (String) ipChange.ipc$dispatch("837711358", new Object[]{this});
    }

    public PerformNftExtAttr getPerformNftExtAttr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616701300")) {
            return (PerformNftExtAttr) ipChange.ipc$dispatch("616701300", new Object[]{this});
        } else if (getUserPerformVO() == null || getUserPerformVO().getExtAttr() == null) {
            return null;
        } else {
            return getUserPerformVO().getExtAttr().nftAttr;
        }
    }

    public String getPerformStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "584211285")) {
            return this.userPerformVO.getPerformStatus();
        }
        return (String) ipChange.ipc$dispatch("584211285", new Object[]{this});
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-513884234")) {
            return this.userPerformVO.getProjectId();
        }
        return (String) ipChange.ipc$dispatch("-513884234", new Object[]{this});
    }

    public String getProjectImage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1206853974")) {
            return this.userPerformVO.getProjectImage();
        }
        return (String) ipChange.ipc$dispatch("1206853974", new Object[]{this});
    }

    public String getProjectName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "149373222")) {
            return this.userPerformVO.getProjectName();
        }
        return (String) ipChange.ipc$dispatch("149373222", new Object[]{this});
    }

    public Long getServerTimestamp() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1886242218")) {
            return this.serverTimestamp;
        }
        return (Long) ipChange.ipc$dispatch("1886242218", new Object[]{this});
    }

    public String getShowTimeRangeDetail() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1288304890")) {
            return this.userPerformVO.getShowTimeRangeDetail();
        }
        return (String) ipChange.ipc$dispatch("-1288304890", new Object[]{this});
    }

    public List<UserTicketTable> getTicketInfoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "153656467")) {
            return this.userPerformVO.getUserTicketVOList();
        }
        return (List) ipChange.ipc$dispatch("153656467", new Object[]{this});
    }

    public int getTicketNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "530146711")) {
            return this.userPerformVO.getTicketQuantity();
        }
        return ((Integer) ipChange.ipc$dispatch("530146711", new Object[]{this})).intValue();
    }

    public String getTimeTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "622461869")) {
            return this.userPerformVO.getTimeTitle();
        }
        return (String) ipChange.ipc$dispatch("622461869", new Object[]{this});
    }

    public String getTransferBackDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-361344585")) {
            return this.userPerformVO.getTransferBackDesc();
        }
        return (String) ipChange.ipc$dispatch("-361344585", new Object[]{this});
    }

    public String getTransferBackUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-354734465")) {
            return this.userPerformVO.getTransferBackUrl();
        }
        return (String) ipChange.ipc$dispatch("-354734465", new Object[]{this});
    }

    public String getTransferWarn() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2094907173")) {
            return this.userPerformVO.getTransferWarn();
        }
        return (String) ipChange.ipc$dispatch("2094907173", new Object[]{this});
    }

    public int getTransferringNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-588993242")) {
            return this.userPerformVO.getTransferringNum();
        }
        return ((Integer) ipChange.ipc$dispatch("-588993242", new Object[]{this})).intValue();
    }

    public PerformTable getUserPerformVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-858889418")) {
            return this.userPerformVO;
        }
        return (PerformTable) ipChange.ipc$dispatch("-858889418", new Object[]{this});
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1128159292")) {
            return this.userPerformVO.getVenueName();
        }
        return (String) ipChange.ipc$dispatch("1128159292", new Object[]{this});
    }

    public boolean isLivePerform() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1394955813")) {
            return "1".equals(this.userPerformVO.getIsLive());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1394955813", new Object[]{this})).booleanValue();
    }

    public boolean isNftPerform() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254143715")) {
            return ((Boolean) ipChange.ipc$dispatch("-1254143715", new Object[]{this})).booleanValue();
        }
        PerformTable performTable = this.userPerformVO;
        if (performTable == null) {
            return false;
        }
        return performTable.isNftPerform();
    }

    public void setBgGradientColors(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211245239")) {
            ipChange.ipc$dispatch("-211245239", new Object[]{this, iArr});
            return;
        }
        this.bgGradientColors = iArr;
    }

    public void setBgGradientPostions(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020920011")) {
            ipChange.ipc$dispatch("2020920011", new Object[]{this, fArr});
            return;
        }
        this.bgGradientPostions = fArr;
    }

    public void setColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "184671761")) {
            ipChange.ipc$dispatch("184671761", new Object[]{this, str});
            return;
        }
        PerformTable performTable = this.userPerformVO;
        if (performTable != null) {
            performTable.setColor(str);
        }
    }

    public void setEmptyDataVO(EmptyDataVO emptyDataVO2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113869718")) {
            ipChange.ipc$dispatch("-1113869718", new Object[]{this, emptyDataVO2});
            return;
        }
        this.emptyDataVO = emptyDataVO2;
    }

    public void setHasMore(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078792504")) {
            ipChange.ipc$dispatch("-2078792504", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.hasMore = i;
    }

    public void setLoadTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1488135785")) {
            ipChange.ipc$dispatch("-1488135785", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.loadTime = j;
    }

    public void setPagingKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119447489")) {
            ipChange.ipc$dispatch("1119447489", new Object[]{this, str});
            return;
        }
        this.pagingKey = str;
    }

    public void setProjectImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-844351416")) {
            ipChange.ipc$dispatch("-844351416", new Object[]{this, str});
            return;
        }
        this.userPerformVO.setProjectImage(str);
    }

    public void setServerTimestamp(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062542934")) {
            ipChange.ipc$dispatch("2062542934", new Object[]{this, l});
            return;
        }
        this.serverTimestamp = l;
    }

    public void setUserPerformVO(PerformTable performTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709896426")) {
            ipChange.ipc$dispatch("1709896426", new Object[]{this, performTable});
            return;
        }
        this.userPerformVO = performTable;
    }
}
