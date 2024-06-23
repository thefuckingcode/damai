package cn.damai.tetris.component.star.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class TourInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentVideoCoverUrl;
    public String contentVideoUrl;
    private List<ProjectItemBean> projects;
    private List<TourCityItem> tourCities;
    private TourInfoItem tourInfo;
    private String tourVideoCover;
    private String tourVideoUrl;

    public List<ProjectItemBean> getProjects() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "212149991")) {
            return this.projects;
        }
        return (List) ipChange.ipc$dispatch("212149991", new Object[]{this});
    }

    public List<TourCityItem> getTourCities() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1848141906")) {
            return this.tourCities;
        }
        return (List) ipChange.ipc$dispatch("-1848141906", new Object[]{this});
    }

    public TourInfoItem getTourInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1264157751")) {
            return this.tourInfo;
        }
        return (TourInfoItem) ipChange.ipc$dispatch("-1264157751", new Object[]{this});
    }

    public String getTourVideoCover() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339210746")) {
            return (String) ipChange.ipc$dispatch("1339210746", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.contentVideoCoverUrl)) {
            return this.contentVideoCoverUrl;
        } else {
            return this.tourVideoCover;
        }
    }

    public String getTourVideoUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-937377870")) {
            return (String) ipChange.ipc$dispatch("-937377870", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.contentVideoUrl)) {
            return this.contentVideoUrl;
        } else {
            return this.tourVideoUrl;
        }
    }

    public void setProjects(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792137157")) {
            ipChange.ipc$dispatch("1792137157", new Object[]{this, list});
            return;
        }
        this.projects = list;
    }

    public void setTourCities(List<TourCityItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434605346")) {
            ipChange.ipc$dispatch("-434605346", new Object[]{this, list});
            return;
        }
        this.tourCities = list;
    }

    public void setTourInfo(TourInfoItem tourInfoItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998405903")) {
            ipChange.ipc$dispatch("998405903", new Object[]{this, tourInfoItem});
            return;
        }
        this.tourInfo = tourInfoItem;
    }

    public void setTourVideoCover(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551246556")) {
            ipChange.ipc$dispatch("-551246556", new Object[]{this, str});
            return;
        }
        this.tourVideoCover = str;
    }

    public void setTourVideoUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403938156")) {
            ipChange.ipc$dispatch("1403938156", new Object[]{this, str});
            return;
        }
        this.tourVideoUrl = str;
    }
}
