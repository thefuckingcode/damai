package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailAddressBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailAddressBean> CREATOR = new Parcelable.Creator<OrderDetailAddressBean>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAddressBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailAddressBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-985383493")) {
                return new OrderDetailAddressBean(parcel);
            }
            return (OrderDetailAddressBean) ipChange.ipc$dispatch("-985383493", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailAddressBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-665643440")) {
                return new OrderDetailAddressBean[i];
            }
            return (OrderDetailAddressBean[]) ipChange.ipc$dispatch("-665643440", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String addressId;
    public String deliveryAmount;
    public String email;
    public String fullAddress;
    public String mobilePhone;
    public boolean modify;
    public String userName;

    public OrderDetailAddressBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-814585201")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-814585201", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42440164")) {
            ipChange.ipc$dispatch("-42440164", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.addressId);
        parcel.writeString(this.deliveryAmount);
        parcel.writeString(this.fullAddress);
        parcel.writeString(this.mobilePhone);
        parcel.writeByte(this.modify ? (byte) 1 : 0);
        parcel.writeString(this.userName);
        parcel.writeString(this.email);
    }

    protected OrderDetailAddressBean(Parcel parcel) {
        this.addressId = parcel.readString();
        this.deliveryAmount = parcel.readString();
        this.fullAddress = parcel.readString();
        this.mobilePhone = parcel.readString();
        this.modify = parcel.readByte() != 0;
        this.userName = parcel.readString();
        this.email = parcel.readString();
    }
}
