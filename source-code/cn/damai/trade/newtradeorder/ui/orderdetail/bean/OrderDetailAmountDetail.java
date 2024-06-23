package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailAmountDetail implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailAmountDetail> CREATOR = new Parcelable.Creator<OrderDetailAmountDetail>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAmountDetail.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailAmountDetail createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "789746923")) {
                return new OrderDetailAmountDetail(parcel);
            }
            return (OrderDetailAmountDetail) ipChange.ipc$dispatch("789746923", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailAmountDetail[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "438589212")) {
                return new OrderDetailAmountDetail[i];
            }
            return (OrderDetailAmountDetail[]) ipChange.ipc$dispatch("438589212", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String amount;
    public String desc;
    public String icon;
    public String jumpUrl;

    public OrderDetailAmountDetail() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-497485844")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-497485844", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "366781023")) {
            ipChange.ipc$dispatch("366781023", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.amount);
        parcel.writeString(this.desc);
        parcel.writeString(this.icon);
        parcel.writeString(this.jumpUrl);
    }

    protected OrderDetailAmountDetail(Parcel parcel) {
        this.amount = parcel.readString();
        this.desc = parcel.readString();
        this.icon = parcel.readString();
        this.jumpUrl = parcel.readString();
    }
}
