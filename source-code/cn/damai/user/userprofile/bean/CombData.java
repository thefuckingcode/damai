package cn.damai.user.userprofile.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CombData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CombData> CREATOR = new Parcelable.Creator<CombData>() {
        /* class cn.damai.user.userprofile.bean.CombData.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CombData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-124538653")) {
                return new CombData(parcel);
            }
            return (CombData) ipChange.ipc$dispatch("-124538653", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CombData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "401955024")) {
                return new CombData[i];
            }
            return (CombData[]) ipChange.ipc$dispatch("401955024", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public ProfileData data;

    protected CombData(Parcel parcel) {
        this.data = (ProfileData) parcel.readParcelable(ProfileData.class.getClassLoader());
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1959938309")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1959938309", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197788464")) {
            ipChange.ipc$dispatch("197788464", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.data, i);
    }
}
