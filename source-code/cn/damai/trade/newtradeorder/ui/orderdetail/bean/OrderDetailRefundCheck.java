package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailRefundCheck implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailRefundCheck> CREATOR = new Parcelable.Creator<OrderDetailRefundCheck>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailRefundCheck.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailRefundCheck createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2091286115")) {
                return new OrderDetailRefundCheck(parcel);
            }
            return (OrderDetailRefundCheck) ipChange.ipc$dispatch("2091286115", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailRefundCheck[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2092020528")) {
                return new OrderDetailRefundCheck[i];
            }
            return (OrderDetailRefundCheck[]) ipChange.ipc$dispatch("-2092020528", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String canApply;
    public String failReason;

    public OrderDetailRefundCheck() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-690300869")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-690300869", new Object[]{this})).intValue();
    }

    public boolean isCanApply() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-345434711")) {
            return TextUtils.isEmpty(this.canApply) || !this.canApply.equals("false");
        }
        return ((Boolean) ipChange.ipc$dispatch("-345434711", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497317392")) {
            ipChange.ipc$dispatch("-497317392", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.canApply);
        parcel.writeString(this.failReason);
    }

    protected OrderDetailRefundCheck(Parcel parcel) {
        this.canApply = parcel.readString();
        this.failReason = parcel.readString();
    }
}
