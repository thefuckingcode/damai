package cn.damai.user.userhome.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class UserHomeDataBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private int commentCount;
    private ContentInfoBean contentInfo;
    private int couponCount;
    private String dnaSimilar;
    private int fansCount;
    private int followStatus;
    private String goDnaUrl;
    private int myFollowCount;
    private String myHeadAreaBgImg;
    private boolean mySelf;
    private String notice;
    private int praiseWantCount;
    private String praiseWantPopInfo;
    private MinepublishCheckBean publishCheckInfo;
    private int seeShowCount;
    private boolean showWantLabel;
    private UserInfoBean userInfo;

    public int getCommentCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "547041883")) {
            return this.commentCount;
        }
        return ((Integer) ipChange.ipc$dispatch("547041883", new Object[]{this})).intValue();
    }

    public ContentInfoBean getContentInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-257052344")) {
            return this.contentInfo;
        }
        return (ContentInfoBean) ipChange.ipc$dispatch("-257052344", new Object[]{this});
    }

    public int getCouponCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-948201732")) {
            return this.couponCount;
        }
        return ((Integer) ipChange.ipc$dispatch("-948201732", new Object[]{this})).intValue();
    }

    public String getDnaSimilar() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1945893724")) {
            return this.dnaSimilar;
        }
        return (String) ipChange.ipc$dispatch("1945893724", new Object[]{this});
    }

    public int getFansCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1606391850")) {
            return this.fansCount;
        }
        return ((Integer) ipChange.ipc$dispatch("-1606391850", new Object[]{this})).intValue();
    }

    public int getFollowStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2128223336")) {
            return this.followStatus;
        }
        return ((Integer) ipChange.ipc$dispatch("2128223336", new Object[]{this})).intValue();
    }

    public String getGoDnaUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1235746728")) {
            return this.goDnaUrl;
        }
        return (String) ipChange.ipc$dispatch("1235746728", new Object[]{this});
    }

    public int getMyFollowCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "293372179")) {
            return this.myFollowCount;
        }
        return ((Integer) ipChange.ipc$dispatch("293372179", new Object[]{this})).intValue();
    }

    public String getMyHeadAreaBgImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "161872147")) {
            return this.myHeadAreaBgImg;
        }
        return (String) ipChange.ipc$dispatch("161872147", new Object[]{this});
    }

    public String getNotice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-20972064")) {
            return this.notice;
        }
        return (String) ipChange.ipc$dispatch("-20972064", new Object[]{this});
    }

    public int getPraiseWantCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1847855106")) {
            return this.praiseWantCount;
        }
        return ((Integer) ipChange.ipc$dispatch("1847855106", new Object[]{this})).intValue();
    }

    public String getPraiseWantPopInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1828389953")) {
            return this.praiseWantPopInfo;
        }
        return (String) ipChange.ipc$dispatch("1828389953", new Object[]{this});
    }

    public MinepublishCheckBean getPublishCheckInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-468811531")) {
            return this.publishCheckInfo;
        }
        return (MinepublishCheckBean) ipChange.ipc$dispatch("-468811531", new Object[]{this});
    }

    public int getSeeShowCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "524930284")) {
            return this.seeShowCount;
        }
        return ((Integer) ipChange.ipc$dispatch("524930284", new Object[]{this})).intValue();
    }

    public UserInfoBean getUserInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "607198362")) {
            return this.userInfo;
        }
        return (UserInfoBean) ipChange.ipc$dispatch("607198362", new Object[]{this});
    }

    public boolean isArtistVip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579861062")) {
            return ((Boolean) ipChange.ipc$dispatch("1579861062", new Object[]{this})).booleanValue();
        }
        UserInfoBean userInfoBean = this.userInfo;
        return userInfoBean != null && userInfoBean.artistVip;
    }

    public boolean isMySelf() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1586166690")) {
            return this.mySelf;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1586166690", new Object[]{this})).booleanValue();
    }

    public boolean isShowWantLabel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-241309643")) {
            return this.showWantLabel;
        }
        return ((Boolean) ipChange.ipc$dispatch("-241309643", new Object[]{this})).booleanValue();
    }

    public boolean isVip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "40644703")) {
            return ((Boolean) ipChange.ipc$dispatch("40644703", new Object[]{this})).booleanValue();
        }
        UserInfoBean userInfoBean = this.userInfo;
        return userInfoBean != null && userInfoBean.vip;
    }

    public void setCommentCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765268825")) {
            ipChange.ipc$dispatch("-1765268825", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.commentCount = i;
    }

    public void setContentInfo(ContentInfoBean contentInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210961642")) {
            ipChange.ipc$dispatch("-210961642", new Object[]{this, contentInfoBean});
            return;
        }
        this.contentInfo = contentInfoBean;
    }

    public void setCouponCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1590580878")) {
            ipChange.ipc$dispatch("1590580878", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.couponCount = i;
    }

    public void setDnaSimilar(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1916720126")) {
            ipChange.ipc$dispatch("-1916720126", new Object[]{this, str});
            return;
        }
        this.dnaSimilar = str;
    }

    public void setFansCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89952780")) {
            ipChange.ipc$dispatch("-89952780", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.fansCount = i;
    }

    public void setFollowStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6715962")) {
            ipChange.ipc$dispatch("6715962", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.followStatus = i;
    }

    public void setGoDnaUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228884938")) {
            ipChange.ipc$dispatch("-228884938", new Object[]{this, str});
            return;
        }
        this.goDnaUrl = str;
    }

    public void setMyFollowCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106290601")) {
            ipChange.ipc$dispatch("-106290601", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.myFollowCount = i;
    }

    public void setMyHeadAreaBgImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004882627")) {
            ipChange.ipc$dispatch("1004882627", new Object[]{this, str});
            return;
        }
        this.myHeadAreaBgImg = str;
    }

    public void setMySelf(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7180704")) {
            ipChange.ipc$dispatch("-7180704", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mySelf = z;
    }

    public void setNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045225986")) {
            ipChange.ipc$dispatch("-2045225986", new Object[]{this, str});
            return;
        }
        this.notice = str;
    }

    public void setPraiseWantCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532875704")) {
            ipChange.ipc$dispatch("-1532875704", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.praiseWantCount = i;
    }

    public void setPraiseWantPopInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856508501")) {
            ipChange.ipc$dispatch("1856508501", new Object[]{this, str});
            return;
        }
        this.praiseWantPopInfo = str;
    }

    public void setPublishCheckInfo(MinepublishCheckBean minepublishCheckBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1148545899")) {
            ipChange.ipc$dispatch("-1148545899", new Object[]{this, minepublishCheckBean});
            return;
        }
        this.publishCheckInfo = minepublishCheckBean;
    }

    public void setSeeShowCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1844238902")) {
            ipChange.ipc$dispatch("1844238902", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.seeShowCount = i;
    }

    public void setShowWantLabel(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1977993891")) {
            ipChange.ipc$dispatch("-1977993891", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.showWantLabel = z;
    }

    public void setUserInfo(UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084693610")) {
            ipChange.ipc$dispatch("-2084693610", new Object[]{this, userInfoBean});
            return;
        }
        this.userInfo = userInfoBean;
    }
}
