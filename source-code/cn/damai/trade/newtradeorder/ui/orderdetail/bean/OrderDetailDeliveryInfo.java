package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class OrderDetailDeliveryInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailDeliveryInfo> CREATOR = new Parcelable.Creator<OrderDetailDeliveryInfo>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailDeliveryInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailDeliveryInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1456442997")) {
                return new OrderDetailDeliveryInfo(parcel);
            }
            return (OrderDetailDeliveryInfo) ipChange.ipc$dispatch("-1456442997", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailDeliveryInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-182183254")) {
                return new OrderDetailDeliveryInfo[i];
            }
            return (OrderDetailDeliveryInfo[]) ipChange.ipc$dispatch("-182183254", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public int deliveryId;
    public String deliveryMethod;
    public String deliveryMethodMessage;
    public ArrayList<String> tags;
    public String ticketType;

    public OrderDetailDeliveryInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1029771483")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1029771483", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377901498")) {
            ipChange.ipc$dispatch("-1377901498", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.deliveryId);
        parcel.writeString(this.deliveryMethod);
        parcel.writeString(this.ticketType);
        parcel.writeString(this.deliveryMethodMessage);
        parcel.writeStringList(this.tags);
    }

    protected OrderDetailDeliveryInfo(Parcel parcel) {
        this.deliveryId = parcel.readInt();
        this.deliveryMethod = parcel.readString();
        this.ticketType = parcel.readString();
        this.deliveryMethodMessage = parcel.readString();
        this.tags = parcel.createStringArrayList();
    }
}
