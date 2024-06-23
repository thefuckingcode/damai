package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailSkuInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailSkuInfo> CREATOR = new Parcelable.Creator<OrderDetailSkuInfo>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSkuInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailSkuInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1309458323")) {
                return new OrderDetailSkuInfo(parcel);
            }
            return (OrderDetailSkuInfo) ipChange.ipc$dispatch("-1309458323", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailSkuInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-288089488")) {
                return new OrderDetailSkuInfo[i];
            }
            return (OrderDetailSkuInfo[]) ipChange.ipc$dispatch("-288089488", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String seatTypeDesc;
    public String skuInfo;
    public String totalPrice;

    public OrderDetailSkuInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-574188810")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-574188810", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012188011")) {
            ipChange.ipc$dispatch("-1012188011", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.seatTypeDesc);
        parcel.writeString(this.skuInfo);
        parcel.writeString(this.totalPrice);
    }

    protected OrderDetailSkuInfo(Parcel parcel) {
        this.seatTypeDesc = parcel.readString();
        this.skuInfo = parcel.readString();
        this.totalPrice = parcel.readString();
    }
}
