package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProfileInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProfileInfo> CREATOR = new Parcelable.Creator<ProfileInfo>() {
        /* class cn.damai.mine.bean.ProfileInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProfileInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1605329621")) {
                return new ProfileInfo(parcel);
            }
            return (ProfileInfo) ipChange.ipc$dispatch("-1605329621", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProfileInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-869942980")) {
                return new ProfileInfo[i];
            }
            return (ProfileInfo[]) ipChange.ipc$dispatch("-869942980", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String bgImg;
    public String birthday;
    public String nickName;
    public String sex;
    public String successMsg;
    public String userIntro;

    public ProfileInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1788010140")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1788010140", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "473362863")) {
            ipChange.ipc$dispatch("473362863", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.bgImg);
        parcel.writeString(this.userIntro);
        parcel.writeString(this.nickName);
        parcel.writeString(this.sex);
        parcel.writeString(this.birthday);
        parcel.writeString(this.successMsg);
    }

    protected ProfileInfo(Parcel parcel) {
        this.bgImg = parcel.readString();
        this.userIntro = parcel.readString();
        this.nickName = parcel.readString();
        this.sex = parcel.readString();
        this.birthday = parcel.readString();
        this.successMsg = parcel.readString();
    }
}
