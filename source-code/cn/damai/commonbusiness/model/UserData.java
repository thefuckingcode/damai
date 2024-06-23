package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class UserData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<UserData> CREATOR = new Parcelable.Creator<UserData>() {
        /* class cn.damai.commonbusiness.model.UserData.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public UserData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "105739467")) {
                return new UserData(parcel);
            }
            return (UserData) ipChange.ipc$dispatch("105739467", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public UserData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-499140378")) {
                return new UserData[i];
            }
            return (UserData[]) ipChange.ipc$dispatch("-499140378", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private CertificationInfoBean certificationBaseInfo;
    private UserMemberInfo memberInfo;
    private UserBaseInfoBean userBaseInfo;

    protected UserData(Parcel parcel) {
        this.certificationBaseInfo = (CertificationInfoBean) parcel.readParcelable(CertificationInfoBean.class.getClassLoader());
        this.userBaseInfo = (UserBaseInfoBean) parcel.readParcelable(UserBaseInfoBean.class.getClassLoader());
        this.memberInfo = (UserMemberInfo) parcel.readParcelable(UserMemberInfo.class.getClassLoader());
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1885770087")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1885770087", new Object[]{this})).intValue();
    }

    public CertificationInfoBean getCertificationBaseInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1109887614")) {
            return this.certificationBaseInfo;
        }
        return (CertificationInfoBean) ipChange.ipc$dispatch("1109887614", new Object[]{this});
    }

    public UserMemberInfo getMemberInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1019838896")) {
            return this.memberInfo;
        }
        return (UserMemberInfo) ipChange.ipc$dispatch("1019838896", new Object[]{this});
    }

    public UserBaseInfoBean getUserBaseInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1954670827")) {
            return this.userBaseInfo;
        }
        return (UserBaseInfoBean) ipChange.ipc$dispatch("1954670827", new Object[]{this});
    }

    public void setCertificationBaseInfo(CertificationInfoBean certificationInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62514454")) {
            ipChange.ipc$dispatch("62514454", new Object[]{this, certificationInfoBean});
            return;
        }
        this.certificationBaseInfo = certificationInfoBean;
    }

    public void setMemberInfo(UserMemberInfo userMemberInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958177452")) {
            ipChange.ipc$dispatch("-958177452", new Object[]{this, userMemberInfo});
            return;
        }
        this.memberInfo = userMemberInfo;
    }

    public void setUserBaseInfo(UserBaseInfoBean userBaseInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1690440565")) {
            ipChange.ipc$dispatch("-1690440565", new Object[]{this, userBaseInfoBean});
            return;
        }
        this.userBaseInfo = userBaseInfoBean;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1705758276")) {
            ipChange.ipc$dispatch("1705758276", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.certificationBaseInfo, i);
        parcel.writeParcelable(this.userBaseInfo, i);
        parcel.writeParcelable(this.memberInfo, i);
    }

    public UserData() {
    }
}
