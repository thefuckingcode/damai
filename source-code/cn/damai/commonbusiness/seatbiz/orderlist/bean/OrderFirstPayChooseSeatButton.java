package cn.damai.commonbusiness.seatbiz.orderlist.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderFirstPayChooseSeatButton implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderFirstPayChooseSeatButton> CREATOR = new Parcelable.Creator<OrderFirstPayChooseSeatButton>() {
        /* class cn.damai.commonbusiness.seatbiz.orderlist.bean.OrderFirstPayChooseSeatButton.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderFirstPayChooseSeatButton createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1575009931")) {
                return new OrderFirstPayChooseSeatButton(parcel);
            }
            return (OrderFirstPayChooseSeatButton) ipChange.ipc$dispatch("1575009931", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderFirstPayChooseSeatButton[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2058713750")) {
                return new OrderFirstPayChooseSeatButton[i];
            }
            return (OrderFirstPayChooseSeatButton[]) ipChange.ipc$dispatch("-2058713750", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String name;
    public int type;

    public OrderFirstPayChooseSeatButton() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1475567995")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1475567995", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542761190")) {
            ipChange.ipc$dispatch("542761190", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.name);
    }

    protected OrderFirstPayChooseSeatButton(Parcel parcel) {
        this.type = parcel.readInt();
        this.name = parcel.readString();
    }
}
