package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailInvoiceInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailInvoiceInfo> CREATOR = new Parcelable.Creator<OrderDetailInvoiceInfo>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailInvoiceInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailInvoiceInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1514340301")) {
                return new OrderDetailInvoiceInfo(parcel);
            }
            return (OrderDetailInvoiceInfo) ipChange.ipc$dispatch("1514340301", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailInvoiceInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1750044272")) {
                return new OrderDetailInvoiceInfo[i];
            }
            return (OrderDetailInvoiceInfo[]) ipChange.ipc$dispatch("1750044272", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String invoiceDesc;
    public String invoiceFetchName;
    public int invoiceFetchType;
    public int invoiceType;

    public OrderDetailInvoiceInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-452433146")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-452433146", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718781573")) {
            ipChange.ipc$dispatch("1718781573", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.invoiceFetchName);
        parcel.writeInt(this.invoiceFetchType);
        parcel.writeString(this.invoiceDesc);
        parcel.writeInt(this.invoiceType);
    }

    protected OrderDetailInvoiceInfo(Parcel parcel) {
        this.invoiceFetchName = parcel.readString();
        this.invoiceFetchType = parcel.readInt();
        this.invoiceDesc = parcel.readString();
        this.invoiceType = parcel.readInt();
    }
}
