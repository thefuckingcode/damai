package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailSeatImgBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailSeatImgBean> CREATOR = new Parcelable.Creator<OrderDetailSeatImgBean>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSeatImgBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatImgBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1015739993")) {
                return new OrderDetailSeatImgBean(parcel);
            }
            return (OrderDetailSeatImgBean) ipChange.ipc$dispatch("-1015739993", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatImgBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1678384912")) {
                return new OrderDetailSeatImgBean[i];
            }
            return (OrderDetailSeatImgBean[]) ipChange.ipc$dispatch("1678384912", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String hasNoneSeatImg;
    public String seatImg;

    public OrderDetailSeatImgBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "436006297")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("436006297", new Object[]{this})).intValue();
    }

    public boolean isHasNoneSeatImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1948757273")) {
            return !TextUtils.isEmpty(this.hasNoneSeatImg) && this.hasNoneSeatImg.equals("true");
        }
        return ((Boolean) ipChange.ipc$dispatch("1948757273", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748100690")) {
            ipChange.ipc$dispatch("748100690", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.hasNoneSeatImg);
        parcel.writeString(this.seatImg);
    }

    protected OrderDetailSeatImgBean(Parcel parcel) {
        this.hasNoneSeatImg = parcel.readString();
        this.seatImg = parcel.readString();
    }
}
