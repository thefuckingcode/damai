package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailSeatBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailSeatBean> CREATOR = new Parcelable.Creator<OrderDetailSeatBean>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSeatBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1892554987")) {
                return new OrderDetailSeatBean(parcel);
            }
            return (OrderDetailSeatBean) ipChange.ipc$dispatch("1892554987", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1134184708")) {
                return new OrderDetailSeatBean[i];
            }
            return (OrderDetailSeatBean[]) ipChange.ipc$dispatch("1134184708", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String area;
    public String combineTicketId;
    public String price;
    public String seatNo;
    public String seatPrice;
    public String seatTypeDesc;

    public OrderDetailSeatBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-376904328")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-376904328", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "11271763")) {
            ipChange.ipc$dispatch("11271763", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.area);
        parcel.writeString(this.seatPrice);
        parcel.writeString(this.price);
        parcel.writeString(this.seatNo);
        parcel.writeString(this.combineTicketId);
        parcel.writeString(this.seatTypeDesc);
    }

    protected OrderDetailSeatBean(Parcel parcel) {
        this.area = parcel.readString();
        this.seatPrice = parcel.readString();
        this.price = parcel.readString();
        this.seatNo = parcel.readString();
        this.combineTicketId = parcel.readString();
        this.seatTypeDesc = parcel.readString();
    }
}
