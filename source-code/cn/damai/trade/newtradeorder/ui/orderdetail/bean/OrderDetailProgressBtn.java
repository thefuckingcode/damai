package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailProgressBtn implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailProgressBtn> CREATOR = new Parcelable.Creator<OrderDetailProgressBtn>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailProgressBtn.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailProgressBtn createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "323922661")) {
                return new OrderDetailProgressBtn(parcel);
            }
            return (OrderDetailProgressBtn) ipChange.ipc$dispatch("323922661", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailProgressBtn[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2041656304")) {
                return new OrderDetailProgressBtn[i];
            }
            return (OrderDetailProgressBtn[]) ipChange.ipc$dispatch("2041656304", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String buttonName;
    public int buttonType;
    public String toast;
    public String url;

    public OrderDetailProgressBtn() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1779128186")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1779128186", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-734031727")) {
            ipChange.ipc$dispatch("-734031727", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.buttonName);
        parcel.writeInt(this.buttonType);
        parcel.writeString(this.url);
        parcel.writeString(this.toast);
    }

    protected OrderDetailProgressBtn(Parcel parcel) {
        this.buttonName = parcel.readString();
        this.buttonType = parcel.readInt();
        this.url = parcel.readString();
        this.toast = parcel.readString();
    }
}
