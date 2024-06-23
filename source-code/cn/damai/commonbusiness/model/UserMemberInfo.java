package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class UserMemberInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<UserMemberInfo> CREATOR = new Parcelable.Creator<UserMemberInfo>() {
        /* class cn.damai.commonbusiness.model.UserMemberInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public UserMemberInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "961194635")) {
                return new UserMemberInfo(parcel);
            }
            return (UserMemberInfo) ipChange.ipc$dispatch("961194635", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public UserMemberInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1518115798")) {
                return new UserMemberInfo[i];
            }
            return (UserMemberInfo[]) ipChange.ipc$dispatch("-1518115798", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String memberStatusDesc;
    private String memberTip;
    private String memberTitle;
    private String thirdConfigDialogTip;

    public UserMemberInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1325199067")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1325199067", new Object[]{this})).intValue();
    }

    public String getMemberStatusDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "14958464")) {
            return this.memberStatusDesc;
        }
        return (String) ipChange.ipc$dispatch("14958464", new Object[]{this});
    }

    public String getMemberTip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1485575060")) {
            return this.memberTip;
        }
        return (String) ipChange.ipc$dispatch("1485575060", new Object[]{this});
    }

    public String getMemberTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-19087023")) {
            return this.memberTitle;
        }
        return (String) ipChange.ipc$dispatch("-19087023", new Object[]{this});
    }

    public String getThirdConfigDialogTip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1772644301")) {
            return this.thirdConfigDialogTip;
        }
        return (String) ipChange.ipc$dispatch("1772644301", new Object[]{this});
    }

    public void setMemberStatusDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708082338")) {
            ipChange.ipc$dispatch("-708082338", new Object[]{this, str});
            return;
        }
        this.memberStatusDesc = str;
    }

    public void setMemberTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137949026")) {
            ipChange.ipc$dispatch("1137949026", new Object[]{this, str});
            return;
        }
        this.memberTip = str;
    }

    public void setMemberTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403318341")) {
            ipChange.ipc$dispatch("1403318341", new Object[]{this, str});
            return;
        }
        this.memberTitle = str;
    }

    public void setThirdConfigDialogTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824912207")) {
            ipChange.ipc$dispatch("-1824912207", new Object[]{this, str});
            return;
        }
        this.thirdConfigDialogTip = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872612422")) {
            ipChange.ipc$dispatch("872612422", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.memberTitle);
        parcel.writeString(this.memberStatusDesc);
        parcel.writeString(this.memberTip);
        parcel.writeString(this.thirdConfigDialogTip);
    }

    protected UserMemberInfo(Parcel parcel) {
        this.memberTitle = parcel.readString();
        this.memberStatusDesc = parcel.readString();
        this.memberTip = parcel.readString();
        this.thirdConfigDialogTip = parcel.readString();
    }
}
