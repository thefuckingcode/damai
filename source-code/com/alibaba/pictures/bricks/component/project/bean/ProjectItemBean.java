package com.alibaba.pictures.bricks.component.project.bean;

import android.os.SystemClock;
import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.MarketTabBase;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.jk1;
import tb.t71;

/* compiled from: Taobao */
public class ProjectItemBean extends MarketTabBase {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -8470055033790130775L;
    public List<HnProjectTag> activityTags;
    public String actores;
    public String alg;
    public String atmosphericPic;
    public String brandOptimizationTag;
    public String categoryName;
    public String cityName;
    public String collectNum;
    public List<CommonTagBean> commonTags;
    public String countdownTime;
    public List<HnProjectTag> couponTags;
    public String discountRate;
    public String displayStatus;
    public String favourable;
    public String followStatus;
    public String formattedDistance;
    public String formattedPriceStr;
    public String guideSubCategoryName;
    public List<String> highlightWord;
    public String id;
    public boolean isAtmospheric;
    public String isHot;
    public int isNewItem;
    public String isSelectSeat;
    public String isSnapUp;
    public boolean isTour;
    public String isVideoSupport;
    public double itemScore = -1.0d;
    public int itemStar = -1;
    public Integer itemType;
    public String liveStartTime;
    public String liveStatus;
    public String logicAddress;
    public String logicDynamicLabel;
    public String name;
    public String onSaleTime;
    public Long playerCount;
    public int pos;
    public String priceDesc;
    public String priceLow;
    public List<HnProjectTag> privilegeTags;
    public String projectStatusTag;
    public String promotionPrice;
    public List<String> promotionTags;
    public RankingListBean rankingList;
    public String recommendHintDesc;
    public String recommendHintLabel;
    public String recommendHintTitle;
    public String recommendHintType;
    public RecommendProjects recommendProjects;
    public String schema;
    public ProjectBuyStatus showStatus;
    public String showTag;
    public String showTime;
    public Long storeId;
    public long tempDeviceBootTime = SystemClock.elapsedRealtime();
    public long upTime;
    public String utKeyWord;
    public String venueCity;
    public String venueId;
    public String venueName;
    public String verticalPic;
    public List<VideoBean> videos;
    public List<ProjectVipTagBean> vipCouponTags;
    public int wantSeeStatus;

    public String getActivityTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1327627113")) {
            return (String) ipChange.ipc$dispatch("-1327627113", new Object[]{this});
        } else if (t71.a(this.activityTags) > 0) {
            return this.activityTags.get(0).name;
        } else {
            return null;
        }
    }

    public String getCategoryNameCompat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006932597")) {
            return (String) ipChange.ipc$dispatch("2006932597", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.guideSubCategoryName)) {
            return this.guideSubCategoryName;
        } else {
            return this.categoryName;
        }
    }

    public long getCountDownTimeMills() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1914612881")) {
            return jk1.f(this.countdownTime, -1);
        }
        return ((Long) ipChange.ipc$dispatch("1914612881", new Object[]{this})).longValue();
    }

    public String getCouponTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216974368")) {
            return (String) ipChange.ipc$dispatch("-1216974368", new Object[]{this});
        } else if (t71.a(this.couponTags) > 0) {
            return this.couponTags.get(0).name;
        } else {
            return null;
        }
    }

    public String getPrivilegeTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183226963")) {
            return (String) ipChange.ipc$dispatch("183226963", new Object[]{this});
        } else if (t71.a(this.privilegeTags) > 0) {
            return this.privilegeTags.get(0).name;
        } else {
            return null;
        }
    }

    public String getVipMark() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-762528234")) {
            return (String) ipChange.ipc$dispatch("-762528234", new Object[]{this});
        } else if (t71.a(this.vipCouponTags) > 0) {
            return this.vipCouponTags.get(0).name;
        } else {
            return null;
        }
    }

    public boolean hasVideo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1379973823")) {
            return ((Boolean) ipChange.ipc$dispatch("-1379973823", new Object[]{this})).booleanValue();
        } else if (TextUtils.isEmpty(this.isVideoSupport)) {
            return false;
        } else {
            return this.isVideoSupport.equals("true") || this.isVideoSupport.equals("1");
        }
    }

    public boolean isFollowStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546963381")) {
            return ((Boolean) ipChange.ipc$dispatch("546963381", new Object[]{this})).booleanValue();
        } else if (TextUtils.isEmpty(this.followStatus)) {
            return false;
        } else {
            return this.followStatus.equals("1") || this.followStatus.equals("2") || "true".equals(this.followStatus);
        }
    }

    public boolean isHNProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1935145593")) {
            return this.isNewItem == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1935145593", new Object[]{this})).booleanValue();
    }

    public boolean isHotProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1408635852")) {
            return ((Boolean) ipChange.ipc$dispatch("1408635852", new Object[]{this})).booleanValue();
        } else if (TextUtils.isEmpty(this.isHot)) {
            return false;
        } else {
            return this.isHot.equals("true") || this.isHot.equals("1");
        }
    }

    public boolean isLiveProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092268595")) {
            return ((Boolean) ipChange.ipc$dispatch("-1092268595", new Object[]{this})).booleanValue();
        } else if (TextUtils.isEmpty(this.liveStatus)) {
            return false;
        } else {
            return "1".equals(this.liveStatus) || "2".equals(this.liveStatus);
        }
    }

    public boolean isSelectSeat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075803287")) {
            return ((Boolean) ipChange.ipc$dispatch("1075803287", new Object[]{this})).booleanValue();
        } else if (TextUtils.isEmpty(this.isSelectSeat)) {
            return false;
        } else {
            return this.isSelectSeat.equals("true") || this.isSelectSeat.equals("1");
        }
    }

    public boolean isSnapUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "281250483")) {
            return ((Boolean) ipChange.ipc$dispatch("281250483", new Object[]{this})).booleanValue();
        } else if (TextUtils.isEmpty(this.isSnapUp)) {
            return false;
        } else {
            return this.isSnapUp.equals("true") || this.isSnapUp.equals("1");
        }
    }

    public boolean isSoldOut() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1912584736")) {
            return TextUtils.equals("SELL_OUT", this.projectStatusTag);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1912584736", new Object[]{this})).booleanValue();
    }

    public boolean isXiaJiaProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740048269")) {
            return ((Boolean) ipChange.ipc$dispatch("-740048269", new Object[]{this})).booleanValue();
        }
        ProjectBuyStatus projectBuyStatus = this.showStatus;
        return projectBuyStatus != null && !TextUtils.isEmpty(projectBuyStatus.id) && "2".equals(this.showStatus.id);
    }
}
