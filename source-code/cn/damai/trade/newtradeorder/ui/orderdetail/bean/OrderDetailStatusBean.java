package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailStatusBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailStatusBean> CREATOR = new Parcelable.Creator<OrderDetailStatusBean>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailStatusBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailStatusBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-613457653")) {
                return new OrderDetailStatusBean(parcel);
            }
            return (OrderDetailStatusBean) ipChange.ipc$dispatch("-613457653", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailStatusBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-156551190")) {
                return new OrderDetailStatusBean[i];
            }
            return (OrderDetailStatusBean[]) ipChange.ipc$dispatch("-156551190", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public int deliveryWay;
    public int frontendStatus;
    public OrderDetailProgress headProgress;
    public String invoiceDesc;
    public int invoiceStatus;
    public String invoiceStatusStr;
    public String logisticsDesc;
    public String logisticsId;
    public String logisticsTimeStr;
    public int orderStatus;
    public String orderStatusStr;
    public int payStatus;
    public String payStatusStr;
    public String statusMessage;

    public OrderDetailStatusBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-872921563")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-872921563", new Object[]{this})).intValue();
    }

    public boolean isActiveAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-980587055")) {
            return ((Boolean) ipChange.ipc$dispatch("-980587055", new Object[]{this})).booleanValue();
        }
        int i = this.orderStatus;
        return i == 2 || i == 3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176263866")) {
            ipChange.ipc$dispatch("-176263866", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.logisticsId);
        parcel.writeString(this.logisticsTimeStr);
        parcel.writeString(this.logisticsDesc);
        parcel.writeInt(this.payStatus);
        parcel.writeString(this.payStatusStr);
        parcel.writeInt(this.orderStatus);
        parcel.writeString(this.orderStatusStr);
        parcel.writeString(this.statusMessage);
        parcel.writeInt(this.frontendStatus);
        parcel.writeInt(this.invoiceStatus);
        parcel.writeString(this.invoiceStatusStr);
        parcel.writeString(this.invoiceDesc);
        parcel.writeInt(this.deliveryWay);
        parcel.writeParcelable(this.headProgress, i);
    }

    protected OrderDetailStatusBean(Parcel parcel) {
        this.logisticsId = parcel.readString();
        this.logisticsTimeStr = parcel.readString();
        this.logisticsDesc = parcel.readString();
        this.payStatus = parcel.readInt();
        this.payStatusStr = parcel.readString();
        this.orderStatus = parcel.readInt();
        this.orderStatusStr = parcel.readString();
        this.statusMessage = parcel.readString();
        this.frontendStatus = parcel.readInt();
        this.invoiceStatus = parcel.readInt();
        this.invoiceStatusStr = parcel.readString();
        this.invoiceDesc = parcel.readString();
        this.deliveryWay = parcel.readInt();
        this.headProgress = (OrderDetailProgress) parcel.readParcelable(OrderDetailProgress.class.getClassLoader());
    }
}
