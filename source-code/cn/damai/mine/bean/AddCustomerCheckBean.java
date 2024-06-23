package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AddCustomerCheckBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddCustomerCheckBean> CREATOR = new Parcelable.Creator<AddCustomerCheckBean>() {
        /* class cn.damai.mine.bean.AddCustomerCheckBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public AddCustomerCheckBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "340054357")) {
                return new AddCustomerCheckBean(parcel);
            }
            return (AddCustomerCheckBean) ipChange.ipc$dispatch("340054357", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public AddCustomerCheckBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1145363728")) {
                return new AddCustomerCheckBean[i];
            }
            return (AddCustomerCheckBean[]) ipChange.ipc$dispatch("-1145363728", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String addCustomerFailToSmsLimit;
    private String failedCount;
    private String lockState;
    private String remainCount;
    private String showPhone;
    private String touchLimit;

    public AddCustomerCheckBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1632592450")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1632592450", new Object[]{this})).intValue();
    }

    public String getAddCustomerFailToSmsLimit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-781652432")) {
            return this.addCustomerFailToSmsLimit;
        }
        return (String) ipChange.ipc$dispatch("-781652432", new Object[]{this});
    }

    public String getFailedCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "717890440")) {
            return this.failedCount;
        }
        return (String) ipChange.ipc$dispatch("717890440", new Object[]{this});
    }

    public String getLockState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "122541980")) {
            return this.lockState;
        }
        return (String) ipChange.ipc$dispatch("122541980", new Object[]{this});
    }

    public String getRemainCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1819015225")) {
            return this.remainCount;
        }
        return (String) ipChange.ipc$dispatch("1819015225", new Object[]{this});
    }

    public String getShowPhone() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-474809753")) {
            return this.showPhone;
        }
        return (String) ipChange.ipc$dispatch("-474809753", new Object[]{this});
    }

    public String getTouchLimit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1592288708")) {
            return this.touchLimit;
        }
        return (String) ipChange.ipc$dispatch("-1592288708", new Object[]{this});
    }

    public void setAddCustomerFailToSmsLimit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-85419450")) {
            ipChange.ipc$dispatch("-85419450", new Object[]{this, str});
            return;
        }
        this.addCustomerFailToSmsLimit = str;
    }

    public void setFailedCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1520184082")) {
            ipChange.ipc$dispatch("-1520184082", new Object[]{this, str});
            return;
        }
        this.failedCount = str;
    }

    public void setLockState(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1833596506")) {
            ipChange.ipc$dispatch("1833596506", new Object[]{this, str});
            return;
        }
        this.lockState = str;
    }

    public void setRemainCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745054115")) {
            ipChange.ipc$dispatch("-1745054115", new Object[]{this, str});
            return;
        }
        this.remainCount = str;
    }

    public void setShowPhone(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495561967")) {
            ipChange.ipc$dispatch("495561967", new Object[]{this, str});
            return;
        }
        this.showPhone = str;
    }

    public void setTouchLimit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "68774178")) {
            ipChange.ipc$dispatch("68774178", new Object[]{this, str});
            return;
        }
        this.touchLimit = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306802377")) {
            ipChange.ipc$dispatch("306802377", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.addCustomerFailToSmsLimit);
        parcel.writeString(this.failedCount);
        parcel.writeString(this.lockState);
        parcel.writeString(this.remainCount);
        parcel.writeString(this.showPhone);
        parcel.writeString(this.touchLimit);
    }

    protected AddCustomerCheckBean(Parcel parcel) {
        this.addCustomerFailToSmsLimit = parcel.readString();
        this.failedCount = parcel.readString();
        this.lockState = parcel.readString();
        this.remainCount = parcel.readString();
        this.showPhone = parcel.readString();
        this.touchLimit = parcel.readString();
    }
}
