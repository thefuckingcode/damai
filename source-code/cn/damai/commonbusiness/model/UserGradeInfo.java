package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class UserGradeInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<UserGradeInfo> CREATOR = new Parcelable.Creator<UserGradeInfo>() {
        /* class cn.damai.commonbusiness.model.UserGradeInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public UserGradeInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2124136659")) {
                return new UserGradeInfo(parcel);
            }
            return (UserGradeInfo) ipChange.ipc$dispatch("-2124136659", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public UserGradeInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1895039600")) {
                return new UserGradeInfo[i];
            }
            return (UserGradeInfo[]) ipChange.ipc$dispatch("1895039600", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public int userGrade;
    public String userGradeAvatar;
    public String userGradeName;

    public UserGradeInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1031901930")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1031901930", new Object[]{this})).intValue();
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099180348")) {
            return (String) ipChange.ipc$dispatch("-2099180348", new Object[]{this});
        }
        return "UserGradeInfo{userGrade=" + this.userGrade + ", userGradeName='" + this.userGradeName + '\'' + ", userGradeAvatar='" + this.userGradeAvatar + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794892683")) {
            ipChange.ipc$dispatch("-794892683", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.userGrade);
        parcel.writeString(this.userGradeName);
        parcel.writeString(this.userGradeAvatar);
    }

    protected UserGradeInfo(Parcel parcel) {
        this.userGrade = parcel.readInt();
        this.userGradeName = parcel.readString();
        this.userGradeAvatar = parcel.readString();
    }
}
