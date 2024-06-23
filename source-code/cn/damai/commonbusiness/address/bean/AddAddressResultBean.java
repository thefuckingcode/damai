package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AddAddressResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddAddressResultBean> CREATOR = new Parcelable.Creator<AddAddressResultBean>() {
        /* class cn.damai.commonbusiness.address.bean.AddAddressResultBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public AddAddressResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1016946893")) {
                return new AddAddressResultBean(parcel);
            }
            return (AddAddressResultBean) ipChange.ipc$dispatch("1016946893", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public AddAddressResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1380884848")) {
                return new AddAddressResultBean[i];
            }
            return (AddAddressResultBean[]) ipChange.ipc$dispatch("1380884848", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private AddressBean address;
    private String success;

    public AddAddressResultBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2144797338")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-2144797338", new Object[]{this})).intValue();
    }

    public AddressBean getAddress() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "202698658")) {
            return this.address;
        }
        return (AddressBean) ipChange.ipc$dispatch("202698658", new Object[]{this});
    }

    public String getSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-347641323")) {
            return this.success;
        }
        return (String) ipChange.ipc$dispatch("-347641323", new Object[]{this});
    }

    public void setAddress(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1542374452")) {
            ipChange.ipc$dispatch("-1542374452", new Object[]{this, addressBean});
            return;
        }
        this.address = addressBean;
    }

    public void setSuccess(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "491767297")) {
            ipChange.ipc$dispatch("491767297", new Object[]{this, str});
            return;
        }
        this.success = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492975653")) {
            ipChange.ipc$dispatch("1492975653", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.success);
        parcel.writeParcelable(this.address, i);
    }

    protected AddAddressResultBean(Parcel parcel) {
        this.success = parcel.readString();
        this.address = (AddressBean) parcel.readParcelable(AddressBean.class.getClassLoader());
    }
}
