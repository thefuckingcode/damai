package com.alibaba.pictures.bricks.bean;

import com.alibaba.pictures.bricks.component.imgcard.BannerBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class VenueInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<BannerBean> banners;
    @Nullable
    private String bid;
    @Nullable
    private String bname;
    @Nullable
    private String distance;
    @Nullable
    private String fansNum;
    private int favoriteFlag;
    @Nullable
    private String lat;
    @Nullable
    private String lng;
    @Nullable
    private String mySelf;
    @Nullable
    private String nickname;
    @Nullable
    private String projectCount;
    @Nullable
    private ShareInfoBean share;
    @Nullable
    private String summary;
    @Nullable
    private String type;

    @Nullable
    public final ArrayList<BannerBean> getBanners() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1054970896")) {
            return this.banners;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1054970896", new Object[]{this});
    }

    @Nullable
    public final String getBid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "760909696")) {
            return this.bid;
        }
        return (String) ipChange.ipc$dispatch("760909696", new Object[]{this});
    }

    @Nullable
    public final String getBname() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1160660592")) {
            return this.bname;
        }
        return (String) ipChange.ipc$dispatch("1160660592", new Object[]{this});
    }

    @Nullable
    public final String getDistance() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1157713144")) {
            return this.distance;
        }
        return (String) ipChange.ipc$dispatch("-1157713144", new Object[]{this});
    }

    @Nullable
    public final String getFansNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "62262185")) {
            return this.fansNum;
        }
        return (String) ipChange.ipc$dispatch("62262185", new Object[]{this});
    }

    public final int getFavoriteFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "714962040")) {
            return this.favoriteFlag;
        }
        return ((Integer) ipChange.ipc$dispatch("714962040", new Object[]{this})).intValue();
    }

    @Nullable
    public final String getLat() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1465118942")) {
            return this.lat;
        }
        return (String) ipChange.ipc$dispatch("-1465118942", new Object[]{this});
    }

    @Nullable
    public final String getLng() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-642641496")) {
            return this.lng;
        }
        return (String) ipChange.ipc$dispatch("-642641496", new Object[]{this});
    }

    @Nullable
    public final String getMySelf() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "699901099")) {
            return this.mySelf;
        }
        return (String) ipChange.ipc$dispatch("699901099", new Object[]{this});
    }

    @Nullable
    public final String getNickname() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1465263871")) {
            return this.nickname;
        }
        return (String) ipChange.ipc$dispatch("-1465263871", new Object[]{this});
    }

    @Nullable
    public final String getProjectCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2016171529")) {
            return this.projectCount;
        }
        return (String) ipChange.ipc$dispatch("2016171529", new Object[]{this});
    }

    @Nullable
    public final ShareInfoBean getShare() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-928456859")) {
            return this.share;
        }
        return (ShareInfoBean) ipChange.ipc$dispatch("-928456859", new Object[]{this});
    }

    @Nullable
    public final String getSummary() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "719155113")) {
            return this.summary;
        }
        return (String) ipChange.ipc$dispatch("719155113", new Object[]{this});
    }

    @Nullable
    public final String getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1920563763")) {
            return this.type;
        }
        return (String) ipChange.ipc$dispatch("-1920563763", new Object[]{this});
    }

    public final void setBanners(@Nullable ArrayList<BannerBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766278600")) {
            ipChange.ipc$dispatch("1766278600", new Object[]{this, arrayList});
            return;
        }
        this.banners = arrayList;
    }

    public final void setBid(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-763055114")) {
            ipChange.ipc$dispatch("-763055114", new Object[]{this, str});
            return;
        }
        this.bid = str;
    }

    public final void setBname(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-182859770")) {
            ipChange.ipc$dispatch("-182859770", new Object[]{this, str});
            return;
        }
        this.bname = str;
    }

    public final void setDistance(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1411696938")) {
            ipChange.ipc$dispatch("-1411696938", new Object[]{this, str});
            return;
        }
        this.distance = str;
    }

    public final void setFansNum(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313874157")) {
            ipChange.ipc$dispatch("313874157", new Object[]{this, str});
            return;
        }
        this.fansNum = str;
    }

    public final void setFavoriteFlag(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-854711254")) {
            ipChange.ipc$dispatch("-854711254", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.favoriteFlag = i;
    }

    public final void setLat(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050466156")) {
            ipChange.ipc$dispatch("-1050466156", new Object[]{this, str});
            return;
        }
        this.lat = str;
    }

    public final void setLng(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323469106")) {
            ipChange.ipc$dispatch("-1323469106", new Object[]{this, str});
            return;
        }
        this.lng = str;
    }

    public final void setMySelf(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1172994413")) {
            ipChange.ipc$dispatch("-1172994413", new Object[]{this, str});
            return;
        }
        this.mySelf = str;
    }

    public final void setNickname(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939132413")) {
            ipChange.ipc$dispatch("1939132413", new Object[]{this, str});
            return;
        }
        this.nickname = str;
    }

    public final void setProjectCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525310987")) {
            ipChange.ipc$dispatch("-1525310987", new Object[]{this, str});
            return;
        }
        this.projectCount = str;
    }

    public final void setShare(@Nullable ShareInfoBean shareInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1425533399")) {
            ipChange.ipc$dispatch("1425533399", new Object[]{this, shareInfoBean});
            return;
        }
        this.share = shareInfoBean;
    }

    public final void setSummary(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797281555")) {
            ipChange.ipc$dispatch("-797281555", new Object[]{this, str});
            return;
        }
        this.summary = str;
    }

    public final void setType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299308721")) {
            ipChange.ipc$dispatch("299308721", new Object[]{this, str});
            return;
        }
        this.type = str;
    }
}
