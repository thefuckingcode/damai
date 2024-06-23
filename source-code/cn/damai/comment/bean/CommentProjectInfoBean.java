package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentProjectInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentProjectInfoBean> CREATOR = new Parcelable.Creator<CommentProjectInfoBean>() {
        /* class cn.damai.comment.bean.CommentProjectInfoBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentProjectInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1891166773")) {
                return new CommentProjectInfoBean(parcel);
            }
            return (CommentProjectInfoBean) ipChange.ipc$dispatch("-1891166773", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentProjectInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1060991850")) {
                return new CommentProjectInfoBean[i];
            }
            return (CommentProjectInfoBean[]) ipChange.ipc$dispatch("-1060991850", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String cityId;
    private String cityName;
    private String projectId;
    private String projectName;
    private String projectPoster;
    private String showTime;
    public String simpleName;
    private String subTitle;
    private String venueId;
    private String venueName;
    public String viewStatus;
    public boolean wantSee;

    protected CommentProjectInfoBean(Parcel parcel) {
        this.cityId = parcel.readString();
        this.cityName = parcel.readString();
        this.projectId = parcel.readString();
        this.projectName = parcel.readString();
        this.subTitle = parcel.readString();
        this.projectPoster = parcel.readString();
        this.showTime = parcel.readString();
        this.venueId = parcel.readString();
        this.venueName = parcel.readString();
        this.viewStatus = parcel.readString();
        this.wantSee = parcel.readByte() != 0;
        this.simpleName = parcel.readString();
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1728987793")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1728987793", new Object[]{this})).intValue();
    }

    public String getCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "860050131")) {
            return this.cityId;
        }
        return (String) ipChange.ipc$dispatch("860050131", new Object[]{this});
    }

    public String getCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1945338115")) {
            return this.cityName;
        }
        return (String) ipChange.ipc$dispatch("1945338115", new Object[]{this});
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-484185475")) {
            return this.projectId;
        }
        return (String) ipChange.ipc$dispatch("-484185475", new Object[]{this});
    }

    public String getProjectName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1374890451")) {
            return this.projectName;
        }
        return (String) ipChange.ipc$dispatch("-1374890451", new Object[]{this});
    }

    public String getProjectPoster() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1138059823")) {
            return this.projectPoster;
        }
        return (String) ipChange.ipc$dispatch("1138059823", new Object[]{this});
    }

    @NonNull
    public String getShortOptName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888663249")) {
            return (String) ipChange.ipc$dispatch("-888663249", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.simpleName)) {
            return this.simpleName;
        } else {
            if (TextUtils.isEmpty(this.projectName)) {
                return "";
            }
            return this.projectName;
        }
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1873399767")) {
            return this.showTime;
        }
        return (String) ipChange.ipc$dispatch("1873399767", new Object[]{this});
    }

    public String getSubTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2082439835")) {
            return this.subTitle;
        }
        return (String) ipChange.ipc$dispatch("-2082439835", new Object[]{this});
    }

    public String getVenueId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1402219309")) {
            return this.venueId;
        }
        return (String) ipChange.ipc$dispatch("-1402219309", new Object[]{this});
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1157858051")) {
            return this.venueName;
        }
        return (String) ipChange.ipc$dispatch("1157858051", new Object[]{this});
    }

    public boolean isXiaJia() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1495350793")) {
            return TextUtils.equals("0", this.viewStatus);
        }
        return ((Boolean) ipChange.ipc$dispatch("1495350793", new Object[]{this})).booleanValue();
    }

    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503341717")) {
            ipChange.ipc$dispatch("-503341717", new Object[]{this, str});
            return;
        }
        this.cityId = str;
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293611579")) {
            ipChange.ipc$dispatch("293611579", new Object[]{this, str});
            return;
        }
        this.cityName = str;
    }

    public void setProjectId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204914585")) {
            ipChange.ipc$dispatch("204914585", new Object[]{this, str});
            return;
        }
        this.projectId = str;
    }

    public void setProjectName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1971882263")) {
            ipChange.ipc$dispatch("-1971882263", new Object[]{this, str});
            return;
        }
        this.projectName = str;
    }

    public void setProjectPoster(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-948547545")) {
            ipChange.ipc$dispatch("-948547545", new Object[]{this, str});
            return;
        }
        this.projectPoster = str;
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1936477209")) {
            ipChange.ipc$dispatch("-1936477209", new Object[]{this, str});
            return;
        }
        this.showTime = str;
    }

    public void setSubTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-13453287")) {
            ipChange.ipc$dispatch("-13453287", new Object[]{this, str});
            return;
        }
        this.subTitle = str;
    }

    public void setVenueId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135379197")) {
            ipChange.ipc$dispatch("-2135379197", new Object[]{this, str});
            return;
        }
        this.venueId = str;
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431343661")) {
            ipChange.ipc$dispatch("-431343661", new Object[]{this, str});
            return;
        }
        this.venueName = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005400892")) {
            ipChange.ipc$dispatch("1005400892", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.cityId);
        parcel.writeString(this.cityName);
        parcel.writeString(this.projectId);
        parcel.writeString(this.projectName);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.projectPoster);
        parcel.writeString(this.showTime);
        parcel.writeString(this.venueId);
        parcel.writeString(this.venueName);
        parcel.writeString(this.viewStatus);
        parcel.writeByte(this.wantSee ? (byte) 1 : 0);
        parcel.writeString(this.simpleName);
    }

    public CommentProjectInfoBean() {
    }
}
