package cn.damai.user.userhome.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.uikit.view.avatar.AvatarConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.h03;

/* compiled from: Taobao */
public class UserInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean artistVip;
    public String birthday;
    public String havanaIdStr;
    public String headBgImg;
    public String imgUrl;
    public PerformFilmVipDO performFilmVipDO;
    public String region;
    public int sex;
    public String userIntro;
    public String userNick;
    public String userNickStatus;
    public int userTypeCode;
    public String userTypeIcon;
    public boolean vip;
    public String vipLevel;
    public String vipLevelIcon;

    public static AvatarConfig createConfig(UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205169912")) {
            return (AvatarConfig) ipChange.ipc$dispatch("-205169912", new Object[]{userInfoBean});
        } else if (userInfoBean == null) {
            return AvatarConfig.defaultConfig();
        } else {
            if (userInfoBean.userTypeCode == 2) {
                return AvatarConfig.vTagConfig();
            }
            if (!userInfoBean.isPerformFilmVip()) {
                return AvatarConfig.defaultConfig();
            }
            String memberFlag = userInfoBean.getMemberFlag();
            if (TextUtils.equals("1", memberFlag)) {
                return AvatarConfig.normalDiamondConfig();
            }
            if (TextUtils.equals("10", memberFlag)) {
                return AvatarConfig.blackDiamondConfig();
            }
            return AvatarConfig.defaultConfig();
        }
    }

    public String getHavanaIdStr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1680416376")) {
            return this.havanaIdStr;
        }
        return (String) ipChange.ipc$dispatch("-1680416376", new Object[]{this});
    }

    public String getImgUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-749243975")) {
            return this.imgUrl;
        }
        return (String) ipChange.ipc$dispatch("-749243975", new Object[]{this});
    }

    public String getMemberFlag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643502029")) {
            return (String) ipChange.ipc$dispatch("-1643502029", new Object[]{this});
        }
        PerformFilmVipDO performFilmVipDO2 = this.performFilmVipDO;
        if (performFilmVipDO2 != null) {
            return performFilmVipDO2.memberFlag;
        }
        return h03.h();
    }

    public PerformFilmVipDO getPerformFilmVipDO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-185656193")) {
            return this.performFilmVipDO;
        }
        return (PerformFilmVipDO) ipChange.ipc$dispatch("-185656193", new Object[]{this});
    }

    public String getUserNick() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1525619877")) {
            return this.userNick;
        }
        return (String) ipChange.ipc$dispatch("-1525619877", new Object[]{this});
    }

    public String getUserNickStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1718580845")) {
            return this.userNickStatus;
        }
        return (String) ipChange.ipc$dispatch("1718580845", new Object[]{this});
    }

    public String getVipLevel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1345286260")) {
            return this.vipLevel;
        }
        return (String) ipChange.ipc$dispatch("1345286260", new Object[]{this});
    }

    public String getVipLevelIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1586274803")) {
            return this.vipLevelIcon;
        }
        return (String) ipChange.ipc$dispatch("-1586274803", new Object[]{this});
    }

    public boolean isPerformFilmVip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-214159005")) {
            return ((Boolean) ipChange.ipc$dispatch("-214159005", new Object[]{this})).booleanValue();
        }
        PerformFilmVipDO performFilmVipDO2 = this.performFilmVipDO;
        return performFilmVipDO2 != null && h03.d(performFilmVipDO2.memberFlag);
    }

    public boolean isVip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1252201786")) {
            return this.vip;
        }
        return ((Boolean) ipChange.ipc$dispatch("1252201786", new Object[]{this})).booleanValue();
    }

    public void setImgUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1148148549")) {
            ipChange.ipc$dispatch("1148148549", new Object[]{this, str});
            return;
        }
        this.imgUrl = str;
    }
}
