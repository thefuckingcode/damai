package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailFaq implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailFaq> CREATOR = new Parcelable.Creator<OrderDetailFaq>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailFaq.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailFaq createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2068981271")) {
                return new OrderDetailFaq(parcel);
            }
            return (OrderDetailFaq) ipChange.ipc$dispatch("2068981271", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailFaq[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "577084688")) {
                return new OrderDetailFaq[i];
            }
            return (OrderDetailFaq[]) ipChange.ipc$dispatch("577084688", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String question;

    public OrderDetailFaq() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1726854753")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1726854753", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-397935478")) {
            ipChange.ipc$dispatch("-397935478", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.question);
    }

    protected OrderDetailFaq(Parcel parcel) {
        this.question = parcel.readString();
    }
}
