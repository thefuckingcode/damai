package cn.damai.trade.newtradeorder.ui.projectdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PrivilegeVerifyBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PrivilegeVerifyBean> CREATOR = new Parcelable.Creator<PrivilegeVerifyBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.bean.PrivilegeVerifyBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public PrivilegeVerifyBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1465928885")) {
                return new PrivilegeVerifyBean(parcel);
            }
            return (PrivilegeVerifyBean) ipChange.ipc$dispatch("-1465928885", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public PrivilegeVerifyBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1996576590")) {
                return new PrivilegeVerifyBean[i];
            }
            return (PrivilegeVerifyBean[]) ipChange.ipc$dispatch("1996576590", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String failedCode;
    private String failedMsg;
    private String successActivityId;
    private String verifiedSuccess;

    public PrivilegeVerifyBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2136520371")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("2136520371", new Object[]{this})).intValue();
    }

    public String getFailedCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1071998459")) {
            return this.failedCode;
        }
        return (String) ipChange.ipc$dispatch("1071998459", new Object[]{this});
    }

    public String getFailedMsg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1048728663")) {
            return this.failedMsg;
        }
        return (String) ipChange.ipc$dispatch("-1048728663", new Object[]{this});
    }

    public String getSuccessActivityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1110149614")) {
            return this.successActivityId;
        }
        return (String) ipChange.ipc$dispatch("-1110149614", new Object[]{this});
    }

    public String getVerifiedSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "524591296")) {
            return this.verifiedSuccess;
        }
        return (String) ipChange.ipc$dispatch("524591296", new Object[]{this});
    }

    public void setFailedCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1057297731")) {
            ipChange.ipc$dispatch("1057297731", new Object[]{this, str});
            return;
        }
        this.failedCode = str;
    }

    public void setFailedMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-116055059")) {
            ipChange.ipc$dispatch("-116055059", new Object[]{this, str});
            return;
        }
        this.failedMsg = str;
    }

    public void setSuccessActivityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "956095140")) {
            ipChange.ipc$dispatch("956095140", new Object[]{this, str});
            return;
        }
        this.successActivityId = str;
    }

    public void setVerifiedSuccess(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-635725642")) {
            ipChange.ipc$dispatch("-635725642", new Object[]{this, str});
            return;
        }
        this.verifiedSuccess = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240951416")) {
            ipChange.ipc$dispatch("1240951416", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.verifiedSuccess);
        parcel.writeString(this.successActivityId);
        parcel.writeString(this.failedCode);
        parcel.writeString(this.failedMsg);
    }

    protected PrivilegeVerifyBean(Parcel parcel) {
        this.verifiedSuccess = parcel.readString();
        this.successActivityId = parcel.readString();
        this.failedCode = parcel.readString();
        this.failedMsg = parcel.readString();
    }
}
