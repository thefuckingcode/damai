package cn.damai.user.userprofile.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.user.userprofile.cuser.bean.CUser;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProfileData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProfileData> CREATOR = new Parcelable.Creator<ProfileData>() {
        /* class cn.damai.user.userprofile.bean.ProfileData.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProfileData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2056751477")) {
                return new ProfileData(parcel);
            }
            return (ProfileData) ipChange.ipc$dispatch("-2056751477", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProfileData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "148912146")) {
                return new ProfileData[i];
            }
            return (ProfileData[]) ipChange.ipc$dispatch("148912146", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public CUser c;
    public boolean mySelf;

    protected ProfileData(Parcel parcel) {
        this.mySelf = parcel.readByte() != 0;
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-555970991")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-555970991", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472594586")) {
            ipChange.ipc$dispatch("1472594586", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeByte(this.mySelf ? (byte) 1 : 0);
    }
}
