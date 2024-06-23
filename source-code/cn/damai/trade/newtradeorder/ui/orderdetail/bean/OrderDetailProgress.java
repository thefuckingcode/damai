package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.OrderDetailPriceInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class OrderDetailProgress implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailProgress> CREATOR = new Parcelable.Creator<OrderDetailProgress>() {
        /* class cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailProgress.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public OrderDetailProgress createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1371528213")) {
                return new OrderDetailProgress(parcel);
            }
            return (OrderDetailProgress) ipChange.ipc$dispatch("-1371528213", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public OrderDetailProgress[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1024474284")) {
                return new OrderDetailProgress[i];
            }
            return (OrderDetailProgress[]) ipChange.ipc$dispatch("-1024474284", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public List<OrderDetailProgressBtn> buttonList;
    public long chooseSeatTime;
    public String chooseSeatTips;
    public String countDownDescPrefix;
    public String countDownDescSuffix;
    public String performId;
    public String performName;
    public List<OrderDetailPriceInfo> priceInfoList;
    public int progressType;
    public String rowNo;
    public String rowNoDesc;
    public String showCityId;
    public String url;

    public OrderDetailProgress() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-961172912")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-961172912", new Object[]{this})).intValue();
    }

    public boolean supportJumpPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013339520")) {
            return ((Boolean) ipChange.ipc$dispatch("1013339520", new Object[]{this})).booleanValue();
        }
        int i = this.progressType;
        return i == 1 || i == 2;
    }

    public boolean supportJumpProgressPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2015983763")) {
            return this.progressType == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("2015983763", new Object[]{this})).booleanValue();
    }

    public boolean supportJumpWebPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-835298848")) {
            return this.progressType == 2 && !TextUtils.isEmpty(this.url);
        }
        return ((Boolean) ipChange.ipc$dispatch("-835298848", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "758547579")) {
            ipChange.ipc$dispatch("758547579", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.countDownDescPrefix);
        parcel.writeString(this.countDownDescSuffix);
        parcel.writeString(this.chooseSeatTips);
        parcel.writeString(this.rowNo);
        parcel.writeString(this.rowNoDesc);
        parcel.writeLong(this.chooseSeatTime);
        parcel.writeTypedList(this.buttonList);
        parcel.writeInt(this.progressType);
        parcel.writeString(this.url);
        parcel.writeString(this.showCityId);
        parcel.writeString(this.performId);
        parcel.writeString(this.performName);
        parcel.writeTypedList(this.priceInfoList);
    }

    protected OrderDetailProgress(Parcel parcel) {
        this.countDownDescPrefix = parcel.readString();
        this.countDownDescSuffix = parcel.readString();
        this.chooseSeatTips = parcel.readString();
        this.rowNo = parcel.readString();
        this.rowNoDesc = parcel.readString();
        this.chooseSeatTime = parcel.readLong();
        this.buttonList = parcel.createTypedArrayList(OrderDetailProgressBtn.CREATOR);
        this.progressType = parcel.readInt();
        this.url = parcel.readString();
        this.showCityId = parcel.readString();
        this.performId = parcel.readString();
        this.performName = parcel.readString();
        this.priceInfoList = parcel.createTypedArrayList(OrderDetailPriceInfo.CREATOR);
    }
}
