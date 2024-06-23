package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RealNameCustomerBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameCustomerBean> CREATOR = new Parcelable.Creator<RealNameCustomerBean>() {
        /* class cn.damai.mine.bean.RealNameCustomerBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RealNameCustomerBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1234443495")) {
                return new RealNameCustomerBean(parcel);
            }
            return (RealNameCustomerBean) ipChange.ipc$dispatch("-1234443495", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RealNameCustomerBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1380215504")) {
                return new RealNameCustomerBean[i];
            }
            return (RealNameCustomerBean[]) ipChange.ipc$dispatch("-1380215504", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String createSource;
    private String identityHash;
    private String identityNo;
    private String identityType;
    private String identityTypeName;
    private String isUserVerified;
    private String maskedIdentityNo;
    private String maskedName;
    private String name;
    private String verifyStatus;

    public RealNameCustomerBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1358338144")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1358338144", new Object[]{this})).intValue();
    }

    public String getCreateSource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1304431637")) {
            return this.createSource;
        }
        return (String) ipChange.ipc$dispatch("1304431637", new Object[]{this});
    }

    public String getIdentityHash() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "334851658")) {
            return this.identityHash;
        }
        return (String) ipChange.ipc$dispatch("334851658", new Object[]{this});
    }

    public String getIdentityNo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-81441859")) {
            return this.identityNo;
        }
        return (String) ipChange.ipc$dispatch("-81441859", new Object[]{this});
    }

    public String getIdentityType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "525495926")) {
            return this.identityType;
        }
        return (String) ipChange.ipc$dispatch("525495926", new Object[]{this});
    }

    public String getIdentityTypeName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-465826783")) {
            return this.identityTypeName;
        }
        return (String) ipChange.ipc$dispatch("-465826783", new Object[]{this});
    }

    public String getIsUserVerified() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1952255461")) {
            return this.isUserVerified;
        }
        return (String) ipChange.ipc$dispatch("-1952255461", new Object[]{this});
    }

    public String getMaskedIdentityNo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1423191832")) {
            return this.maskedIdentityNo;
        }
        return (String) ipChange.ipc$dispatch("-1423191832", new Object[]{this});
    }

    public String getMaskedName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1072918316")) {
            return this.maskedName;
        }
        return (String) ipChange.ipc$dispatch("-1072918316", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2082213737")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("2082213737", new Object[]{this});
    }

    public String getVerifyStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1700300887")) {
            return this.verifyStatus;
        }
        return (String) ipChange.ipc$dispatch("-1700300887", new Object[]{this});
    }

    public void setCreateSource(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114411159")) {
            ipChange.ipc$dispatch("-2114411159", new Object[]{this, str});
            return;
        }
        this.createSource = str;
    }

    public void setIdentityHash(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2106619436")) {
            ipChange.ipc$dispatch("-2106619436", new Object[]{this, str});
            return;
        }
        this.identityHash = str;
    }

    public void setIdentityNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339613759")) {
            ipChange.ipc$dispatch("-339613759", new Object[]{this, str});
            return;
        }
        this.identityNo = str;
    }

    public void setIdentityType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491614424")) {
            ipChange.ipc$dispatch("-491614424", new Object[]{this, str});
            return;
        }
        this.identityType = str;
    }

    public void setIdentityTypeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567444189")) {
            ipChange.ipc$dispatch("1567444189", new Object[]{this, str});
            return;
        }
        this.identityTypeName = str;
    }

    public void setIsUserVerified(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "492516131")) {
            ipChange.ipc$dispatch("492516131", new Object[]{this, str});
            return;
        }
        this.isUserVerified = str;
    }

    public void setMaskedIdentityNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953898742")) {
            ipChange.ipc$dispatch("1953898742", new Object[]{this, str});
            return;
        }
        this.maskedIdentityNo = str;
    }

    public void setMaskedName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010612854")) {
            ipChange.ipc$dispatch("-1010612854", new Object[]{this, str});
            return;
        }
        this.maskedName = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168640363")) {
            ipChange.ipc$dispatch("-168640363", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setVerifyStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771838891")) {
            ipChange.ipc$dispatch("-771838891", new Object[]{this, str});
            return;
        }
        this.verifyStatus = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1414363243")) {
            ipChange.ipc$dispatch("1414363243", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.createSource);
        parcel.writeString(this.identityHash);
        parcel.writeString(this.identityNo);
        parcel.writeString(this.identityType);
        parcel.writeString(this.identityTypeName);
        parcel.writeString(this.isUserVerified);
        parcel.writeString(this.maskedIdentityNo);
        parcel.writeString(this.maskedName);
        parcel.writeString(this.name);
        parcel.writeString(this.verifyStatus);
    }

    protected RealNameCustomerBean(Parcel parcel) {
        this.createSource = parcel.readString();
        this.identityHash = parcel.readString();
        this.identityNo = parcel.readString();
        this.identityType = parcel.readString();
        this.identityTypeName = parcel.readString();
        this.isUserVerified = parcel.readString();
        this.maskedIdentityNo = parcel.readString();
        this.maskedName = parcel.readString();
        this.name = parcel.readString();
        this.verifyStatus = parcel.readString();
    }
}
