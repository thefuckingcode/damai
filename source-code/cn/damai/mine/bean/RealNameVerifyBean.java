package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RealNameVerifyBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameVerifyBean> CREATOR = new Parcelable.Creator<RealNameVerifyBean>() {
        /* class cn.damai.mine.bean.RealNameVerifyBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RealNameVerifyBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1179405853")) {
                return new RealNameVerifyBean(parcel);
            }
            return (RealNameVerifyBean) ipChange.ipc$dispatch("-1179405853", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RealNameVerifyBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1891615504")) {
                return new RealNameVerifyBean[i];
            }
            return (RealNameVerifyBean[]) ipChange.ipc$dispatch("1891615504", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String faceVerifyStatus;
    private String verifyToken;

    public RealNameVerifyBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1085321211")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1085321211", new Object[]{this})).intValue();
    }

    public String getFaceVerifyStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1277286593")) {
            return this.faceVerifyStatus;
        }
        return (String) ipChange.ipc$dispatch("1277286593", new Object[]{this});
    }

    public String getVerifyToken() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1926601763")) {
            return this.verifyToken;
        }
        return (String) ipChange.ipc$dispatch("-1926601763", new Object[]{this});
    }

    public void setFaceVerifyStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230616003")) {
            ipChange.ipc$dispatch("-230616003", new Object[]{this, str});
            return;
        }
        this.faceVerifyStatus = str;
    }

    public void setVerifyToken(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895063751")) {
            ipChange.ipc$dispatch("-1895063751", new Object[]{this, str});
            return;
        }
        this.verifyToken = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1351079376")) {
            ipChange.ipc$dispatch("-1351079376", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.faceVerifyStatus);
        parcel.writeString(this.verifyToken);
    }

    protected RealNameVerifyBean(Parcel parcel) {
        this.faceVerifyStatus = parcel.readString();
        this.verifyToken = parcel.readString();
    }
}
