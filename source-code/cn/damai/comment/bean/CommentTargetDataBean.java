package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentTargetDataBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentTargetDataBean> CREATOR = new Parcelable.Creator<CommentTargetDataBean>() {
        /* class cn.damai.comment.bean.CommentTargetDataBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentTargetDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1111483351")) {
                return new CommentTargetDataBean(parcel);
            }
            return (CommentTargetDataBean) ipChange.ipc$dispatch("1111483351", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentTargetDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "209305232")) {
                return new CommentTargetDataBean[i];
            }
            return (CommentTargetDataBean[]) ipChange.ipc$dispatch("209305232", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String targetCityName;
    private String targetDataType;
    private String targetDesc;
    private String targetId;
    private String targetImg;
    private String targetName;
    private String targetPlace;
    private String targetShowTime;
    private String viewStatus;

    public CommentTargetDataBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-386873599")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-386873599", new Object[]{this})).intValue();
    }

    public String getTargetCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-155075898")) {
            return this.targetCityName;
        }
        return (String) ipChange.ipc$dispatch("-155075898", new Object[]{this});
    }

    public String getTargetDataType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "683928372")) {
            return this.targetDataType;
        }
        return (String) ipChange.ipc$dispatch("683928372", new Object[]{this});
    }

    public String getTargetDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1695838783")) {
            return this.targetDesc;
        }
        return (String) ipChange.ipc$dispatch("-1695838783", new Object[]{this});
    }

    public String getTargetId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1913825419")) {
            return this.targetId;
        }
        return (String) ipChange.ipc$dispatch("1913825419", new Object[]{this});
    }

    public String getTargetImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "171747721")) {
            return this.targetImg;
        }
        return (String) ipChange.ipc$dispatch("171747721", new Object[]{this});
    }

    public String getTargetName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1011108027")) {
            return this.targetName;
        }
        return (String) ipChange.ipc$dispatch("1011108027", new Object[]{this});
    }

    public String getTargetPlace() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "124562957")) {
            return this.targetPlace;
        }
        return (String) ipChange.ipc$dispatch("124562957", new Object[]{this});
    }

    public String getTargetShowTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-227014246")) {
            return this.targetShowTime;
        }
        return (String) ipChange.ipc$dispatch("-227014246", new Object[]{this});
    }

    public String getViewStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-610282378")) {
            return this.viewStatus;
        }
        return (String) ipChange.ipc$dispatch("-610282378", new Object[]{this});
    }

    public void setTargetCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370507736")) {
            ipChange.ipc$dispatch("370507736", new Object[]{this, str});
            return;
        }
        this.targetCityName = str;
    }

    public void setTargetDataType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "609836330")) {
            ipChange.ipc$dispatch("609836330", new Object[]{this, str});
            return;
        }
        this.targetDataType = str;
    }

    public void setTargetDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1153689149")) {
            ipChange.ipc$dispatch("1153689149", new Object[]{this, str});
            return;
        }
        this.targetDesc = str;
    }

    public void setTargetId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683281997")) {
            ipChange.ipc$dispatch("-683281997", new Object[]{this, str});
            return;
        }
        this.targetId = str;
    }

    public void setTargetImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-935992819")) {
            ipChange.ipc$dispatch("-935992819", new Object[]{this, str});
            return;
        }
        this.targetImg = str;
    }

    public void setTargetName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-830305661")) {
            ipChange.ipc$dispatch("-830305661", new Object[]{this, str});
            return;
        }
        this.targetName = str;
    }

    public void setTargetPlace(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561500425")) {
            ipChange.ipc$dispatch("1561500425", new Object[]{this, str});
            return;
        }
        this.targetPlace = str;
    }

    public void setTargetShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859581052")) {
            ipChange.ipc$dispatch("-1859581052", new Object[]{this, str});
            return;
        }
        this.targetShowTime = str;
    }

    public void setViewStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "446199336")) {
            ipChange.ipc$dispatch("446199336", new Object[]{this, str});
            return;
        }
        this.viewStatus = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173635050")) {
            ipChange.ipc$dispatch("1173635050", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.targetId);
        parcel.writeString(this.targetDataType);
        parcel.writeString(this.targetImg);
        parcel.writeString(this.targetName);
        parcel.writeString(this.targetCityName);
        parcel.writeString(this.targetShowTime);
        parcel.writeString(this.targetDesc);
        parcel.writeString(this.viewStatus);
        parcel.writeString(this.targetPlace);
    }

    protected CommentTargetDataBean(Parcel parcel) {
        this.targetId = parcel.readString();
        this.targetDataType = parcel.readString();
        this.targetImg = parcel.readString();
        this.targetName = parcel.readString();
        this.targetCityName = parcel.readString();
        this.targetShowTime = parcel.readString();
        this.targetDesc = parcel.readString();
        this.viewStatus = parcel.readString();
        this.targetPlace = parcel.readString();
    }
}
