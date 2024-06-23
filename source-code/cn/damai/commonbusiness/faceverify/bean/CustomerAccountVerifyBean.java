package cn.damai.commonbusiness.faceverify.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CustomerAccountVerifyBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CustomerAccountVerifyBean> CREATOR = new Parcelable.Creator<CustomerAccountVerifyBean>() {
        /* class cn.damai.commonbusiness.faceverify.bean.CustomerAccountVerifyBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CustomerAccountVerifyBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1460279217")) {
                return new CustomerAccountVerifyBean(parcel);
            }
            return (CustomerAccountVerifyBean) ipChange.ipc$dispatch("1460279217", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CustomerAccountVerifyBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1396120528")) {
                return new CustomerAccountVerifyBean[i];
            }
            return (CustomerAccountVerifyBean[]) ipChange.ipc$dispatch("-1396120528", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private boolean could;

    public CustomerAccountVerifyBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "495614772")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("495614772", new Object[]{this})).intValue();
    }

    public boolean isCould() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2136553041")) {
            return this.could;
        }
        return ((Boolean) ipChange.ipc$dispatch("2136553041", new Object[]{this})).booleanValue();
    }

    public void setCould(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94107603")) {
            ipChange.ipc$dispatch("-94107603", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.could = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921587223")) {
            ipChange.ipc$dispatch("1921587223", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeByte(this.could ? (byte) 1 : 0);
    }

    protected CustomerAccountVerifyBean(Parcel parcel) {
        this.could = parcel.readByte() != 0;
    }
}
