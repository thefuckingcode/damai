package cn.damai.issue.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class NoticeInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<NoticeInfo> CREATOR = new Parcelable.Creator<NoticeInfo>() {
        /* class cn.damai.issue.net.NoticeInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public NoticeInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "951738993")) {
                return new NoticeInfo(parcel);
            }
            return (NoticeInfo) ipChange.ipc$dispatch("951738993", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public NoticeInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1980088016")) {
                return new NoticeInfo[i];
            }
            return (NoticeInfo[]) ipChange.ipc$dispatch("-1980088016", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private ArrayList<IssueActivityIntroduce> activityIntroduce;
    private String activityNotice;
    private String activityPic;
    private String redActivityNotice;

    public NoticeInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "573208724")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("573208724", new Object[]{this})).intValue();
    }

    public ArrayList<IssueActivityIntroduce> getActivityIntroduce() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-240122170")) {
            return this.activityIntroduce;
        }
        return (ArrayList) ipChange.ipc$dispatch("-240122170", new Object[]{this});
    }

    public String getActivityNotice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1093840153")) {
            return this.activityNotice;
        }
        return (String) ipChange.ipc$dispatch("1093840153", new Object[]{this});
    }

    public String getActivityPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1545698719")) {
            return this.activityPic;
        }
        return (String) ipChange.ipc$dispatch("1545698719", new Object[]{this});
    }

    public String getRedActivityNotice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "71155740")) {
            return this.redActivityNotice;
        }
        return (String) ipChange.ipc$dispatch("71155740", new Object[]{this});
    }

    public void setActivityIntroduce(ArrayList<IssueActivityIntroduce> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1870609230")) {
            ipChange.ipc$dispatch("-1870609230", new Object[]{this, arrayList});
            return;
        }
        this.activityIntroduce = arrayList;
    }

    public void setActivityNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432199653")) {
            ipChange.ipc$dispatch("432199653", new Object[]{this, str});
            return;
        }
        this.activityNotice = str;
    }

    public void setActivityPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1627931209")) {
            ipChange.ipc$dispatch("-1627931209", new Object[]{this, str});
            return;
        }
        this.activityPic = str;
    }

    public void setRedActivityNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078144550")) {
            ipChange.ipc$dispatch("-1078144550", new Object[]{this, str});
            return;
        }
        this.redActivityNotice = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1123518135")) {
            ipChange.ipc$dispatch("1123518135", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.activityNotice);
        parcel.writeString(this.redActivityNotice);
        parcel.writeTypedList(this.activityIntroduce);
        parcel.writeString(this.activityPic);
    }

    protected NoticeInfo(Parcel parcel) {
        this.activityNotice = parcel.readString();
        this.redActivityNotice = parcel.readString();
        this.activityIntroduce = parcel.createTypedArrayList(IssueActivityIntroduce.CREATOR);
        this.activityPic = parcel.readString();
    }
}
