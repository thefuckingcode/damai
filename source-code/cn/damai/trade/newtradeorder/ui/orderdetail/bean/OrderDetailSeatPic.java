package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailSeatPic implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailSeatPic> CREATOR = new Parcelable.Creator<OrderDetailSeatPic>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSeatPic.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatPic createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-354377543")) {
                return new OrderDetailSeatPic(parcel);
            }
            return (OrderDetailSeatPic) ipChange.ipc$dispatch("-354377543", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatPic[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "715933232")) {
                return new OrderDetailSeatPic[i];
            }
            return (OrderDetailSeatPic[]) ipChange.ipc$dispatch("715933232", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String fontColor;
    public String text;
    public String url;

    public OrderDetailSeatPic() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "169117008")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("169117008", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "503908731")) {
            ipChange.ipc$dispatch("503908731", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.text);
        parcel.writeString(this.fontColor);
        parcel.writeString(this.url);
    }

    protected OrderDetailSeatPic(Parcel parcel) {
        this.text = parcel.readString();
        this.fontColor = parcel.readString();
        this.url = parcel.readString();
    }
}
