package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PurchaseNotice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PurchaseNotice> CREATOR = new Parcelable.Creator<PurchaseNotice>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.PurchaseNotice.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public PurchaseNotice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-829141677")) {
                return new PurchaseNotice(parcel);
            }
            return (PurchaseNotice) ipChange.ipc$dispatch("-829141677", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public PurchaseNotice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1018516688")) {
                return new PurchaseNotice[i];
            }
            return (PurchaseNotice[]) ipChange.ipc$dispatch("1018516688", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String itemId;
    public String orderId;
    public String tip;
    public String title;

    public PurchaseNotice() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "763070147")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("763070147", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "887929960")) {
            ipChange.ipc$dispatch("887929960", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.tip);
        parcel.writeString(this.title);
    }

    protected PurchaseNotice(Parcel parcel) {
        this.tip = parcel.readString();
        this.title = parcel.readString();
    }
}
