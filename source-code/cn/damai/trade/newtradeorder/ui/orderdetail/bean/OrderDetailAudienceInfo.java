package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailAudienceInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailAudienceInfo> CREATOR = new Parcelable.Creator<OrderDetailAudienceInfo>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAudienceInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailAudienceInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "150260619")) {
                return new OrderDetailAudienceInfo(parcel);
            }
            return (OrderDetailAudienceInfo) ipChange.ipc$dispatch("150260619", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailAudienceInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "605128330")) {
                return new OrderDetailAudienceInfo[i];
            }
            return (OrderDetailAudienceInfo[]) ipChange.ipc$dispatch("605128330", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String hashIdentityNumber;
    public String identifier;
    public String name;
    public String typeName;

    public OrderDetailAudienceInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2029799733")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("2029799733", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874783286")) {
            ipChange.ipc$dispatch("1874783286", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.hashIdentityNumber);
        parcel.writeString(this.identifier);
        parcel.writeString(this.name);
        parcel.writeString(this.typeName);
    }

    protected OrderDetailAudienceInfo(Parcel parcel) {
        this.hashIdentityNumber = parcel.readString();
        this.identifier = parcel.readString();
        this.name = parcel.readString();
        this.typeName = parcel.readString();
    }
}
