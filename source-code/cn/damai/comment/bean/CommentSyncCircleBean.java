package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentSyncCircleBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentSyncCircleBean> CREATOR = new Parcelable.Creator<CommentSyncCircleBean>() {
        /* class cn.damai.comment.bean.CommentSyncCircleBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentSyncCircleBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-696490249")) {
                return new CommentSyncCircleBean(parcel);
            }
            return (CommentSyncCircleBean) ipChange.ipc$dispatch("-696490249", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentSyncCircleBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "986048656")) {
                return new CommentSyncCircleBean[i];
            }
            return (CommentSyncCircleBean[]) ipChange.ipc$dispatch("986048656", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String circleId;
    private String circleName;
    private String circleTargetId;
    private String circleTargetType;

    public CommentSyncCircleBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "18815345")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("18815345", new Object[]{this})).intValue();
    }

    public String getCircleId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1303483642")) {
            return this.circleId;
        }
        return (String) ipChange.ipc$dispatch("1303483642", new Object[]{this});
    }

    public String getCircleName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1411787414")) {
            return this.circleName;
        }
        return (String) ipChange.ipc$dispatch("-1411787414", new Object[]{this});
    }

    public String getCircleTargetId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1694449899")) {
            return this.circleTargetId;
        }
        return (String) ipChange.ipc$dispatch("1694449899", new Object[]{this});
    }

    public String getCircleTargetType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1767034806")) {
            return this.circleTargetType;
        }
        return (String) ipChange.ipc$dispatch("-1767034806", new Object[]{this});
    }

    public void setCircleId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870959396")) {
            ipChange.ipc$dispatch("1870959396", new Object[]{this, str});
            return;
        }
        this.circleId = str;
    }

    public void setCircleName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369346996")) {
            ipChange.ipc$dispatch("1369346996", new Object[]{this, str});
            return;
        }
        this.circleName = str;
    }

    public void setCircleTargetId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1871232595")) {
            ipChange.ipc$dispatch("1871232595", new Object[]{this, str});
            return;
        }
        this.circleTargetId = str;
    }

    public void setCircleTargetType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115298860")) {
            ipChange.ipc$dispatch("-115298860", new Object[]{this, str});
            return;
        }
        this.circleTargetType = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1983440006")) {
            ipChange.ipc$dispatch("-1983440006", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.circleId);
        parcel.writeString(this.circleName);
        parcel.writeString(this.circleTargetId);
        parcel.writeString(this.circleTargetType);
    }

    protected CommentSyncCircleBean(Parcel parcel) {
        this.circleId = parcel.readString();
        this.circleName = parcel.readString();
        this.circleTargetId = parcel.readString();
        this.circleTargetType = parcel.readString();
    }
}
