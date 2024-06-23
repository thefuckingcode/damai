package com.alibaba.pictures.bricks.bean;

import android.graphics.Color;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class WaterFlowRec2Project implements IFeedProjectBean<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private WaterFlowRecommendItem mItem;
    private List<TagBean> tagList;

    public WaterFlowRec2Project(WaterFlowRecommendItem waterFlowRecommendItem) {
        this.mItem = waterFlowRecommendItem;
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public String getAtmospheric() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-409929603")) {
            return this.mItem.atmosphericPic;
        }
        return (String) ipChange.ipc$dispatch("-409929603", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public int getLiveStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1367508705")) {
            return this.mItem.liveStatus;
        }
        return ((Integer) ipChange.ipc$dispatch("-1367508705", new Object[]{this})).intValue();
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public String getPostPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "417498954")) {
            return this.mItem.projectPic;
        }
        return (String) ipChange.ipc$dispatch("417498954", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public String getProjectDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "765710823")) {
            return (String) ipChange.ipc$dispatch("765710823", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.mItem.liveStartTime)) {
            return this.mItem.liveStartTime;
        } else {
            return this.mItem.projectDatetime;
        }
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public String getProjectName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1477135428")) {
            return this.mItem.projectName;
        }
        return (String) ipChange.ipc$dispatch("1477135428", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public String getRankText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "116621231")) {
            return this.mItem.title;
        }
        return (String) ipChange.ipc$dispatch("116621231", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public double getScoreStar() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1134647242")) {
            return this.mItem.itemScore;
        }
        return ((Double) ipChange.ipc$dispatch("1134647242", new Object[]{this})).doubleValue();
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public String getShowPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1079838580")) {
            return this.mItem.priceLow;
        }
        return (String) ipChange.ipc$dispatch("-1079838580", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public List<TagBean> getTagList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212658815")) {
            return (List) ipChange.ipc$dispatch("212658815", new Object[]{this});
        }
        if (this.tagList == null) {
            this.tagList = new ArrayList();
            WaterFlowRecommendItem waterFlowRecommendItem = this.mItem;
            String str = waterFlowRecommendItem.tagType;
            String str2 = waterFlowRecommendItem.tag;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                if (TextUtils.equals("1", str)) {
                    this.tagList.add(new TagBean(str2, Color.parseColor("#FF2869")));
                } else if (TextUtils.equals("2", str)) {
                    this.tagList.add(new TagBean(str2, Color.parseColor("#FF2869")));
                } else if (TextUtils.equals("4", str)) {
                    this.tagList.add(new TagBean(str2, Color.parseColor("#30AEFF")));
                } else if (TextUtils.equals("5", str)) {
                    this.tagList.add(new TagBean(str2, Color.parseColor("#FF993A")));
                }
            }
            if (!TextUtils.isEmpty(this.mItem.categoryName)) {
                this.tagList.add(new TagBean(this.mItem.categoryName, Color.parseColor("#9C9CA5")));
            }
        }
        return this.tagList;
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public boolean isPendingPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-852066062")) {
            return TextUtils.isEmpty(this.mItem.priceLow) || this.mItem.priceLow.contains("待定");
        }
        return ((Boolean) ipChange.ipc$dispatch("-852066062", new Object[]{this})).booleanValue();
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public boolean isShowVideoIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "534021047")) {
            return this.mItem.hasVideo;
        }
        return ((Boolean) ipChange.ipc$dispatch("534021047", new Object[]{this})).booleanValue();
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public boolean isShowWannaSeeTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2010098125")) {
            return TextUtils.equals("3", this.mItem.tagType);
        }
        return ((Boolean) ipChange.ipc$dispatch("2010098125", new Object[]{this})).booleanValue();
    }

    @Override // com.alibaba.pictures.bricks.bean.IFeedProjectBean
    public WaterFlowRecommendItem getRaw() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1052228292")) {
            return this.mItem;
        }
        return (WaterFlowRecommendItem) ipChange.ipc$dispatch("1052228292", new Object[]{this});
    }
}
