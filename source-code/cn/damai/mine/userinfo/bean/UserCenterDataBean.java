package cn.damai.mine.userinfo.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.mine.bean.UserCenterDynamicMenu;
import cn.damai.user.userhome.bean.UserHomeDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class UserCenterDataBean extends UserHomeDataBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<UserBanner> banner;
    private RealNameAuthStatusBean certificateInfo;
    private UserCenterDynamicMenu dynamicMenu;
    private LogisticsInfo logistics;
    private UserPerformFileVip performFilmVip;
    private UserGuideBean userGuide;

    /* compiled from: Taobao */
    public static class LogisticsInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String orderDetailUrl;
        public String orderId;
        public String performImageUrl;
        public String status;
        public List<TransitStepInfo> transitStepInfos;
        public String waybillId;
        public String waybillName;

        public String getOrderDetailUrl() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-422727278")) {
                return this.orderDetailUrl;
            }
            return (String) ipChange.ipc$dispatch("-422727278", new Object[]{this});
        }

        public String getPerformImageUrl() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1430170455")) {
                return this.performImageUrl;
            }
            return (String) ipChange.ipc$dispatch("-1430170455", new Object[]{this});
        }

        public String getStatus() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1244781524")) {
                return this.status;
            }
            return (String) ipChange.ipc$dispatch("1244781524", new Object[]{this});
        }

        public List<TransitStepInfo> getTransitStepInfos() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "417540687")) {
                return this.transitStepInfos;
            }
            return (List) ipChange.ipc$dispatch("417540687", new Object[]{this});
        }

        public String getWaybillId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1217536005")) {
                return this.waybillId;
            }
            return (String) ipChange.ipc$dispatch("1217536005", new Object[]{this});
        }

        public String getWaybillName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1891879349")) {
                return this.waybillName;
            }
            return (String) ipChange.ipc$dispatch("1891879349", new Object[]{this});
        }

        public void setStatus(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1461570422")) {
                ipChange.ipc$dispatch("-1461570422", new Object[]{this, str});
                return;
            }
            this.status = str;
        }
    }

    /* compiled from: Taobao */
    public static class TransitStepInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String action;
        public String statusDesc;
        public String statusTime;

        public String getStatusDesc() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1970507185")) {
                return this.statusDesc;
            }
            return (String) ipChange.ipc$dispatch("1970507185", new Object[]{this});
        }

        public String getStatusTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1348627437")) {
                return this.statusTime;
            }
            return (String) ipChange.ipc$dispatch("1348627437", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public static class UserGuideBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        public String bindAuthorization;
        public String content;
        public boolean memberThreshold;

        public boolean isUnbind() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1409416346")) {
                return "0".equals(this.bindAuthorization);
            }
            return ((Boolean) ipChange.ipc$dispatch("1409416346", new Object[]{this})).booleanValue();
        }

        public boolean isbindNotAuth() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "722277796")) {
                return "1".equals(this.bindAuthorization);
            }
            return ((Boolean) ipChange.ipc$dispatch("722277796", new Object[]{this})).booleanValue();
        }
    }

    public List<UserBanner> getBanner() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1883450280")) {
            return this.banner;
        }
        return (List) ipChange.ipc$dispatch("-1883450280", new Object[]{this});
    }

    public RealNameAuthStatusBean getCertificateInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1174735417")) {
            return this.certificateInfo;
        }
        return (RealNameAuthStatusBean) ipChange.ipc$dispatch("1174735417", new Object[]{this});
    }

    public UserCenterDynamicMenu getDynamicMenu() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "869328404")) {
            return this.dynamicMenu;
        }
        return (UserCenterDynamicMenu) ipChange.ipc$dispatch("869328404", new Object[]{this});
    }

    public LogisticsInfo getLogistics() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "171041704")) {
            return this.logistics;
        }
        return (LogisticsInfo) ipChange.ipc$dispatch("171041704", new Object[]{this});
    }

    public UserPerformFileVip getPerformFilmVip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-807392499")) {
            return this.performFilmVip;
        }
        return (UserPerformFileVip) ipChange.ipc$dispatch("-807392499", new Object[]{this});
    }

    public UserGuideBean getUserGuide() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "607379366")) {
            return this.userGuide;
        }
        return (UserGuideBean) ipChange.ipc$dispatch("607379366", new Object[]{this});
    }

    public int getVipLevel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "800139367")) {
            return ((Integer) ipChange.ipc$dispatch("800139367", new Object[]{this})).intValue();
        } else if (getUserInfo() == null || TextUtils.isEmpty(getUserInfo().vipLevel)) {
            return 0;
        } else {
            return xf2.l(getUserInfo().vipLevel, 0);
        }
    }

    public String getVipLevelIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589138501")) {
            return (String) ipChange.ipc$dispatch("1589138501", new Object[]{this});
        } else if (getUserInfo() != null) {
            return getUserInfo().vipLevelIcon;
        } else {
            return null;
        }
    }

    public void setBanner(List<UserBanner> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939593868")) {
            ipChange.ipc$dispatch("-1939593868", new Object[]{this, list});
            return;
        }
        this.banner = list;
    }

    public void setCertificateInfo(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339799363")) {
            ipChange.ipc$dispatch("1339799363", new Object[]{this, realNameAuthStatusBean});
            return;
        }
        this.certificateInfo = realNameAuthStatusBean;
    }

    public void setDynamicMenu(UserCenterDynamicMenu userCenterDynamicMenu) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948920436")) {
            ipChange.ipc$dispatch("-1948920436", new Object[]{this, userCenterDynamicMenu});
            return;
        }
        this.dynamicMenu = userCenterDynamicMenu;
    }

    public void setLogistics(LogisticsInfo logisticsInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923698902")) {
            ipChange.ipc$dispatch("923698902", new Object[]{this, logisticsInfo});
            return;
        }
        this.logistics = logisticsInfo;
    }

    public void setPerformFilmVip(UserPerformFileVip userPerformFileVip) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407095057")) {
            ipChange.ipc$dispatch("1407095057", new Object[]{this, userPerformFileVip});
            return;
        }
        this.performFilmVip = userPerformFileVip;
    }

    public void setUserGuide(UserGuideBean userGuideBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199491288")) {
            ipChange.ipc$dispatch("199491288", new Object[]{this, userGuideBean});
            return;
        }
        this.userGuide = userGuideBean;
    }
}
