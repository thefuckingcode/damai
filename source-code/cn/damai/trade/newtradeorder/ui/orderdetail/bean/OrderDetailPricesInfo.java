package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailPricesInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailPricesInfo> CREATOR = new Parcelable.Creator<OrderDetailPricesInfo>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPricesInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailPricesInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2095454795")) {
                return new OrderDetailPricesInfo(parcel);
            }
            return (OrderDetailPricesInfo) ipChange.ipc$dispatch("2095454795", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailPricesInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "982975678")) {
                return new OrderDetailPricesInfo[i];
            }
            return (OrderDetailPricesInfo[]) ipChange.ipc$dispatch("982975678", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String displayAmount;
    public String displayAmountDesc;
    public String itemAmount;

    public OrderDetailPricesInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "746196731")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("746196731", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776426704")) {
            ipChange.ipc$dispatch("-776426704", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.itemAmount);
        parcel.writeString(this.displayAmountDesc);
        parcel.writeString(this.displayAmount);
    }

    protected OrderDetailPricesInfo(Parcel parcel) {
        this.itemAmount = parcel.readString();
        this.displayAmountDesc = parcel.readString();
        this.displayAmount = parcel.readString();
    }
}
