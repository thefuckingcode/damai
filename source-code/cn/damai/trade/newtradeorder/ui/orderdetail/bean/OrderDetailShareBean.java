package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderDetailShareBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailShareBean> CREATOR = new Parcelable.Creator<OrderDetailShareBean>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailShareBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailShareBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "149997989")) {
                return new OrderDetailShareBean(parcel);
            }
            return (OrderDetailShareBean) ipChange.ipc$dispatch("149997989", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailShareBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-861898256")) {
                return new OrderDetailShareBean[i];
            }
            return (OrderDetailShareBean[]) ipChange.ipc$dispatch("-861898256", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String cityAndTime;
    public String projectId;
    public String projectImage;
    public String projectName;
    public String showShare;

    public OrderDetailShareBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "364329914")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("364329914", new Object[]{this})).intValue();
    }

    public boolean isShowShare() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-28136502")) {
            return !TextUtils.isEmpty(this.showShare) && this.showShare.equals("true");
        }
        return ((Boolean) ipChange.ipc$dispatch("-28136502", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1513049007")) {
            ipChange.ipc$dispatch("-1513049007", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.showShare);
    }

    protected OrderDetailShareBean(Parcel parcel) {
        this.showShare = parcel.readString();
    }
}
